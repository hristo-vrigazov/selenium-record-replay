package parallel;

import edu.hvrigazov.automation.replay.ReplayBrowserConfiguration;
import edu.hvrigazov.automation.execution.executor.AutomationResult;
import edu.hvrigazov.automation.execution.executor.WebDriverActionExecutor;
import edu.hvrigazov.automation.execution.executor.WebDriverActionExecutorBase;
import edu.hvrigazov.automation.execution.executor.WebdriverActionExecutorBuilder;
import edu.hvrigazov.automation.execution.webdriver.PredefinedWebdriverActionFactory;
import org.junit.Test;
import edu.hvrigazov.automation.suite.AutomationManager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by hvrigazov on 19.03.17.
 */
public class AutomationManagerExamples {

    @Test
    public void sequentialExample() throws IOException, URISyntaxException {
        String pathToApplicationConfiguration = "/home/hvrigazov/github/selenium-edu.hvrigazov.automation.record-edu.hvrigazov.automation.replay/tenniskafe.json";
        String pathToChromedriver = "/home/hvrigazov/github/selenium-edu.hvrigazov.automation.record-edu.hvrigazov.automation.replay/chromedriver";
        String pathToTestScenario = "/home/hvrigazov/github/selenium-edu.hvrigazov.automation.record-edu.hvrigazov.automation.replay/testCase.json";

        WebdriverActionExecutorBuilder executorWebdriverActionExecutorBuilder = WebDriverActionExecutorBase
                .builder()
                .pathToDriverExecutable(pathToChromedriver)
                .timeoutInSeconds(30)
                .measurementsPrecisionInMilliseconds(50)
                .baseURI("http://www.tenniskafe.com/");

        ReplayBrowserConfiguration.Builder testScenarioRunnerBuilder = ReplayBrowserConfiguration
                .builder()
                .pathToApplicationConfiguration(pathToApplicationConfiguration)
                .url("http://www.tenniskafe.com/")
                .webdriverActionFactory(new PredefinedWebdriverActionFactory());

        AutomationManager automationManager = new AutomationManager();

        getScenario(pathToTestScenario, executorWebdriverActionExecutorBuilder, testScenarioRunnerBuilder);
        automationManager.addTestScenario(getScenario(pathToTestScenario, executorWebdriverActionExecutorBuilder, testScenarioRunnerBuilder),
                "0.csv", "0.har");
        automationManager.addTestScenario(getScenario(pathToTestScenario, executorWebdriverActionExecutorBuilder, testScenarioRunnerBuilder),
                "1.csv", "1.har");
        automationManager.addTestScenario(getScenario(pathToTestScenario, executorWebdriverActionExecutorBuilder, testScenarioRunnerBuilder),
                "2.csv", "2.har");

        List<AutomationResult> automationResultList = automationManager.runInParallel();

        System.out.println(automationResultList);
    }

    private WebDriverActionExecutor getScenario(String pathToTestScenario, WebdriverActionExecutorBuilder executor, ReplayBrowserConfiguration.Builder testScenarioRunner) throws IOException, URISyntaxException {
        return testScenarioRunner
                .executor(executor.buildChromedriver())
                .build()
                .getReplayBrowser()
                .getTestScenario(pathToTestScenario);
    }
}