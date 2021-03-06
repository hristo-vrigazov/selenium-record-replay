package com.hribol.bromium.replay.execution.scenario;

import com.hribol.bromium.replay.actions.WebDriverAction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by hvrigazov on 24.05.17.
 */
public class TestScenarioStepsTest {

    @Test
    public void canIterateOverTheSameNumberOfItems() {
        int n = 3;
        List<WebDriverAction> webDriverActionList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            webDriverActionList.add(mock(WebDriverAction.class));
        }

        TestScenarioActions testScenarioSteps = new TestScenarioActions(webDriverActionList);

        int numberOfActions = 0;
        for (WebDriverAction webDriverAction : testScenarioSteps) {
            numberOfActions++;
        }

        assertEquals(n, numberOfActions);
    }

}
