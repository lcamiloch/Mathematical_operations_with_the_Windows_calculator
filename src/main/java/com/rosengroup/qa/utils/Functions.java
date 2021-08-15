package com.rosengroup.qa.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class Functions {

    public Integer getNumberString(String button) {
        int number = 0;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(button);
        while (matcher.find()) {
            number = Integer.parseInt(matcher.group());
        }
        return number;
    }

    public List<Integer> getEvenNumbers(List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer x : numbers) {
            if (x % 2 == 0 && x != 0) {
                evenNumbers.add(x);
            }
        }
        return evenNumbers;
    }

    public List<Integer> getOddNumbers(List<Integer> numbers) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer x : numbers) {
            if (x % 2 != 0){
                oddNumbers.add(x);
            }
        }
        return oddNumbers;
    }
}