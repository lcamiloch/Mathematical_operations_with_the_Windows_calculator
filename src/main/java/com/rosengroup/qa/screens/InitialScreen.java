package com.rosengroup.qa.screens;

import org.openqa.selenium.By;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class InitialScreen {

    private final By count_visible_numbers = By.xpath("//Button[starts-with(@AutomationId,'num')]");
    private final By window_result = By.xpath("//*[@AutomationId='CalculatorResults']");
    private final By button_plus = By.xpath("//*[@AutomationId='plusButton']");
    private final By button_minus = By.xpath("//*[@AutomationId='minusButton']");
    private final By button_equal = By.xpath("//*[@AutomationId='equalButton']");
    private By button_number;

    public By getCount_visible_numbers() {
        return count_visible_numbers;
    }

    public By getWindow_result() {
        return window_result;
    }

    public By getButton_plus() {
        return button_plus;
    }

    public By getButton_minus() {
        return button_minus;
    }

    public By getButton_equal() {
        return button_equal;
    }

    public By getButton_number() {
        return button_number;
    }

    public void setButton_number(int position) {
        button_number = By.xpath(
                "//Button[starts-with(@AutomationId,'num')][" + position + "]");
    }
}
