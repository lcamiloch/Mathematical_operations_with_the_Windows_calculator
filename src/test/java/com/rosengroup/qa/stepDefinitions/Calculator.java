package com.rosengroup.qa.stepDefinitions;

import com.rosengroup.qa.steps.CalculatorOperation;
import com.rosengroup.qa.steps.DataOperations;
import com.rosengroup.qa.steps.ValidateResults;
import com.rosengroup.qa.utils.PropertiesConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.rosengroup.qa.utils.DriverConfig.disconnectDriver;
import static com.rosengroup.qa.utils.DriverConfig.initializeDriver;
import static com.rosengroup.qa.utils.ReportConfig.generateReport;
import static com.rosengroup.qa.utils.ReportConfig.initializeReport;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class Calculator {

    DataOperations dataOperations;
    ValidateResults validateResults;
    CalculatorOperation calculatorOperation;

    @Before
    public void initialConfig(){
        initializeDriver();
        initializeReport();
    }

    @Given("The customer wants to test the functionality of the calculator")
    public void InitialInstance() {
        dataOperations = new DataOperations();
        validateResults = new ValidateResults();
        calculatorOperation = new CalculatorOperation();
        dataOperations.getNumbers();

    }
    @When("He adds all visible even numbers")
    public void typeEvenNumbers() {
        dataOperations.getEvenNumbers();
        dataOperations.getOddNumbers();
        calculatorOperation.typeEvenNumbers();
        Assert.assertEquals(PropertiesConfig
                .getParameter("ResultEvenNumbers"), validateResults.checkResult());
    }

    @And("He then subtracts all visible odd numbers")
    public void typeOddNumbers() {
        calculatorOperation.typeOddNumbers();
    }

    @Then("^He should get the result (.*)$")
    public void checkResult(String result) {
        Assert.assertEquals(result, validateResults.checkResult());
    }

    @After
    public void Disconnection(){
        generateReport();
        disconnectDriver();
    }
}
