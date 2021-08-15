package com.rosengroup.qa.steps;

import com.rosengroup.qa.screens.InitialScreen;
import com.rosengroup.qa.utils.DriverConfig;
import com.rosengroup.qa.utils.Functions;
import com.rosengroup.qa.utils.PropertiesConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class DataOperations extends Functions {

    private List<Integer> visibleNumbers;
    private static List<Integer> evenNumber;
    private static List<Integer> oddNumber;

    InitialScreen initialScreen;

    public DataOperations() {
        initialScreen = new InitialScreen();
    }

    public static List<Integer> getEvenNumber() {
        return evenNumber;
    }

    public static List<Integer> getOddNumber() {
        return oddNumber;
    }

    public void getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        int elements = DriverConfig.getDriver().findElements(initialScreen.getCount_visible_numbers()).size();
        for (int i = 1; i < elements + 1; i++) {
            initialScreen.setButton_number(i);
            String button = DriverConfig.getDriver().findElement(
                    initialScreen.getButton_number())
                    .getAttribute(PropertiesConfig.getParameter("Attribute"));
            numbers.add(getNumberString(button));
        }
        visibleNumbers = numbers;
    }

    public void getEvenNumbers(){
        evenNumber = getEvenNumbers(visibleNumbers);
    }

    public void getOddNumbers(){
        oddNumber = getOddNumbers(visibleNumbers);
    }
}
