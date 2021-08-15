package com.rosengroup.qa.steps;

import com.rosengroup.qa.screens.InitialScreen;
import com.rosengroup.qa.utils.DriverConfig;
import com.rosengroup.qa.utils.Functions;
import com.rosengroup.qa.utils.PropertiesConfig;
import com.rosengroup.qa.utils.ReportConfig;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class ValidateResults extends Functions {

    InitialScreen initialScreen;

    public ValidateResults(){
        initialScreen = new InitialScreen();
    }

    public String checkResult(){
        ReportConfig.screenshot(DriverConfig.getDriver(), "Check result", "pass");
        return DriverConfig.getDriver().findElement(initialScreen
                .getWindow_result()).getText().substring(Integer
                .parseInt(PropertiesConfig.getParameter("StringModify")));
    }
}