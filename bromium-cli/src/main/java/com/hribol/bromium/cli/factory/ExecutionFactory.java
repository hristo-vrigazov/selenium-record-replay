package com.hribol.bromium.cli.factory;

import com.google.inject.Inject;
import com.hribol.bromium.browsers.chrome.replay.ChromeDriverActionExecution;
import com.hribol.bromium.replay.execution.WebDriverActionExecution;
import com.hribol.bromium.replay.execution.ExecutorBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.remote.BrowserType.CHROME;

/**
 * Created by hvrigazov on 09.05.17.
 */
public class ExecutionFactory {
    private Map<String, ReplayBrowserSupplier> browserNameToSupplierMap;

    @Inject
    public ExecutionFactory() {
        browserNameToSupplierMap = new HashMap<>();
        browserNameToSupplierMap.put(CHROME, this::getChrome);
    }

    public WebDriverActionExecution create(String browserType, ExecutorBuilder executor) throws IOException, URISyntaxException {
        return browserNameToSupplierMap.get(browserType).get(executor);
    }

    private WebDriverActionExecution getChrome(ExecutorBuilder executorBuilder) throws IOException, URISyntaxException {
        return new ChromeDriverActionExecution(executorBuilder);
    }
}
