package com.hribol.bromium.integration.tests.record;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.hribol.bromium.core.utils.Constants.EVENT;
import static com.hribol.bromium.integration.tests.TestUtils.Events.CLICK_DELETE_ON_CHOSEN_ROW_BY_TEXT;
import static com.hribol.bromium.integration.tests.TestUtils.Pages.TABLE_DELETE_ROW_BY_TEXT_DEMO_PAGE;

public class DeleteTableRowByTextIT extends BaseRecordClickIT {

    public DeleteTableRowByTextIT() {
        super(TABLE_DELETE_ROW_BY_TEXT_DEMO_PAGE,
                ImmutableMap.of(
                        EVENT, CLICK_DELETE_ON_CHOSEN_ROW_BY_TEXT,
                        "rowDescription", "chosen"),
                DeleteTableRowByTextIT::getElement);
    }

    private static WebElement getElement(WebDriver driver) {
        List<WebElement> elements = driver.findElements(By.tagName("li"));

        WebElement webElement = elements
                .stream()
                .filter(DeleteTableRowByTextIT::filterElement)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Element was not found!"));

        return webElement
                .findElement(By.className("delete-button"));
    }

    private static boolean filterElement(WebElement webElement) {
        try {
            return webElement.findElement(By.className("description")).getText().trim().equals("chosen");
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean notFilterElement(WebElement webElement) {
        return !filterElement(webElement);
    }

}
