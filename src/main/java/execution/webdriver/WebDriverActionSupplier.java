package execution.webdriver;

import execution.executor.WebDriverActionExecutor;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by hvrigazov on 21.03.17.
 */
public interface WebDriverActionSupplier {
    WebDriverActionExecutor get() throws IOException, URISyntaxException;
}
