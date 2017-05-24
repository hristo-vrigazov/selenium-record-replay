package com.hribol.spiderman.replay.execution;
import com.hribol.spiderman.replay.actions.WebDriverAction;
import com.hribol.spiderman.replay.execution.scenario.TestScenario;
import com.hribol.spiderman.replay.config.suite.VirtualScreenProcessCreator;
import com.hribol.spiderman.replay.report.ExecutionReport;
import com.hribol.spiderman.replay.report.LoadingTimes;
import com.hribol.spiderman.replay.config.utils.Utils;
import com.hribol.spiderman.replay.report.AutomationResult;
import com.hribol.spiderman.replay.filters.ProxyFacade;
import com.hribol.spiderman.replay.filters.ReplayFiltersFacade;
import com.hribol.spiderman.replay.settings.ReplaySettings;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;


/**
 * Created by hvrigazov on 16.03.17.
 */
public abstract class WebDriverActionExecutionBase implements WebDriverActionExecution {

    public WebDriverActionExecutionBase(ExecutorBuilder executor) throws IOException, URISyntaxException {
        this.executor = executor;
        this.proxyFacade = executor.getProxyFacadeSupplier().get(executor.getBaseURL());
        this.replaySettings = createReplaySettings();
        this.automationResult = AutomationResult.NOT_STARTED;
        this.lock = new Object();
    }

    @Override
    public ExecutionReport execute(TestScenario testScenario) {
        return execute(testScenario, ":0");
    }

    @Override
    public ExecutionReport execute(TestScenario testScenario, String screenToUse) {
        List<Long> waitingTimes = new ArrayList<>();
        List<Date> actionTimestamps = new ArrayList<>();

        try {
            prepare(screenToUse);
        } catch (IOException e) {
            this.automationResult = AutomationResult.COULD_NOT_CREATE_DRIVER;
            Har har = replaySettings.getHar();
            return new ExecutionReport(loadingTimes, har, automationResult);
        }

        long elapsedTime = System.nanoTime();
        actionTimestamps.add(new Date());

        try {
            this.automationResult = AutomationResult.EXECUTING;
            while (testScenario.hasMoreSteps()) {

                proxyFacade.signalizeExecutionThreadWantsToAct();

                if (Utils.toSeconds(System.nanoTime() - elapsedTime) > executor.getTimeout()) {
                    this.automationResult = AutomationResult.TIMEOUT;
                    TimeoutException cause = new TimeoutException("Could not execute the action! Waited "
                            + String.valueOf(System.nanoTime() - elapsedTime)
                            + " to do " + testScenario.nextActionName()
                            + " http queries in queue: " + proxyFacade.getNumberOfRequestsInQueue());

                    throw new WebDriverActionExecutionException("Timeout!", cause, executor.getAutomationResultBuilder());
                }

                if (proxyFacade.canAct()) {
                    proxyFacade.setLock(testScenario.nextActionExpectsHttpRequest());
                    WebDriverAction webDriverAction = testScenario.pollWebDriverAction();

                    Future<?> future = executorService.submit(() -> executeIgnoringExceptions(webDriverAction));
                    try {
                        future.get(executor.getTimeout(), TimeUnit.SECONDS);
                    }  catch (java.util.concurrent.TimeoutException | InterruptedException e) {
                        throw new WebDriverActionExecutionException("Exception during execution", e, executor.getAutomationResultBuilder());
                    } catch (ExecutionException e) {
                        throw new WebDriverActionExecutionException("Exception during execution", e.getCause(), executor.getAutomationResultBuilder());
                    }
                    waitingTimes.add(System.nanoTime() - elapsedTime);
                    actionTimestamps.add(new Date());
                    elapsedTime = System.nanoTime();
                }
            }

            this.automationResult = AutomationResult.SUCCESS;
        } catch (WebDriverActionExecutionException executionException) {
            executionException.printStackTrace();
            this.automationResult = executionException.getAutomationResult();
        }

        this.replaySettings.cleanUpReplay();
        this.executorService.shutdownNow();
        this.loadingTimes = new LoadingTimes(testScenario.getActions(), waitingTimes, actionTimestamps);
        Har har = this.replaySettings.getHar();
        return new ExecutionReport(loadingTimes, har, automationResult);
    }

    @Override
    public ExecutionReport createVirtualScreenProcessAndExecute(TestScenario testScenario,
                                                                int screenNumber,
                                                                VirtualScreenProcessCreator virtualScreenProcessCreator) {
        Process process;
        String screen = virtualScreenProcessCreator.getScreen(screenNumber);
        try {
            process = virtualScreenProcessCreator.createXvfbProcess(screenNumber);
        } catch (IOException e) {
            this.automationResult = AutomationResult.NO_VIRTUAL_SCREEN;
            Har har = replaySettings.getHar();
            return new ExecutionReport(loadingTimes, har, automationResult);
        }

        try {
            return this.execute(testScenario, screen);
        } finally {
            process.destroy();
        }
    }

    @Override
    public String getBaseURL() {
        return executor.getBaseURL();
    }

    protected ReplayFiltersFacade proxyFacade;
    protected String baseURI;
    protected abstract ReplaySettings createReplaySettings();
    public abstract String getSystemProperty();

    private ReplaySettings replaySettings;
    private AutomationResult automationResult;

    private LoadingTimes loadingTimes;
    private final ExecutorBuilder executor;
    private final Object lock;
    private ExecutorService executorService;


    private void prepare(String screenToUse) throws IOException {
        System.setProperty(getSystemProperty(), executor.getPathToDriverExecutable());
        proxyFacade.setLock(false);
        this.automationResult = AutomationResult.NOT_STARTED;
        this.replaySettings.prepareReplay(executor.getPathToDriverExecutable(), screenToUse, executor.getTimeout());
        this.executorService = Executors.newSingleThreadExecutor();
    }

    private void executeIgnoringExceptions(WebDriverAction webDriverAction) {
        int i = 0;

        while (i < executor.getMaxRetries()) {
            try {
                webDriverAction.execute(replaySettings.getWebDriver(), proxyFacade);
                return;
            } catch (WebDriverException ex) {
                System.out.println(ex.toString());
                System.out.println("Could not make it from first try");
                i++;
                try {
                    Thread.sleep(executor.getMeasurementsPrecisionMilli());
                } catch (InterruptedException e) {
                    throw new WebDriverActionExecutionException("Interrupted while waiting to retry", e, executor.getAutomationResultBuilder());
                }
            }
        }

        throw new TimeoutException("Could not execute the action! " + webDriverAction.getName());
    }

}