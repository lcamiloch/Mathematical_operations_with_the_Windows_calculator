package com.rosengroup.qa.steps;

import com.rosengroup.qa.screens.InitialScreen;
import com.rosengroup.qa.utils.DriverConfig;
import com.rosengroup.qa.utils.ReportConfig;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class CalculatorOperation {

    InitialScreen initialScreen;

    public CalculatorOperation(){
        initialScreen = new InitialScreen();
    }

    public void typeEvenNumbers(){
        for (Integer number: DataOperations.getEvenNumber()) {
            initialScreen.setButton_number(number + 1);
            DriverConfig.getDriver().findElement(initialScreen.getButton_number()).click();
            ReportConfig.screenshot(DriverConfig.getDriver(), "Type button " + number, "info");
            DriverConfig.getDriver().findElement(initialScreen.getButton_plus()).click();
            ReportConfig.screenshot(DriverConfig.getDriver(), "Type plus button ", "info");
        }
    }

    public void typeOddNumbers(){
        for (Integer number: DataOperations.getOddNumber()) {
            initialScreen.setButton_number(number + 1);
            DriverConfig.getDriver().findElement(initialScreen.getButton_minus()).click();
            ReportConfig.screenshot(DriverConfig.getDriver(), "Type minus button ", "info");
            DriverConfig.getDriver().findElement(initialScreen.getButton_number()).click();
            ReportConfig.screenshot(DriverConfig.getDriver(), "Type button " + number, "info");
        }
        DriverConfig.getDriver().findElement(initialScreen.getButton_equal()).click();
        ReportConfig.screenshot(DriverConfig.getDriver(), "Type equal button ", "info");
    }
}