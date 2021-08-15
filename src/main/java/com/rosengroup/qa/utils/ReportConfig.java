package com.rosengroup.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.windows.WindowsDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class ReportConfig {

    private static Random numRand;
    private static File screenshot;
    private static ExtentTest report;
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;

    public static void initializeReport() {
        extent = new ExtentReports();
        htmlReporter = new ExtentHtmlReporter(
                PropertiesConfig.getParameter("ReportName"));
        htmlReporter.setAppendExisting(true);
        extent.attachReporter(htmlReporter);
        report = extent.createTest(PropertiesConfig.getParameter("ReportTitle"));
        report.assignAuthor(System.getProperty("user.name"));
        report.assignAuthor(System.getProperty("os.name"));
    }

    public static void screenshot(WindowsDriver driver, String msg, String status) {
        screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String name = pictureName();
        try {
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + PropertiesConfig.getParameter("ReportPath") + name + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (status) {
            case "pass":
                try {
                    report.pass(msg, MediaEntityBuilder.createScreenCaptureFromPath("pictures\\" + name + ".png").build());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "info":
                try {

                    report.info(msg, MediaEntityBuilder.createScreenCaptureFromPath("pictures\\" + name + ".png").build());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "fail":
                try {
                    report.fail(msg, MediaEntityBuilder.createScreenCaptureFromPath("pictures\\" + name + ".png").build());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println(" !! Status not such !!");
        }
    }

    public static void generateReport() {
        extent.flush();
    }

    static String pictureName() {
        String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
        String namePicture = "";
        numRand = new Random();
        char[] letter = lexicon.toCharArray();
        String letterOne = String.valueOf(letter[numRand.nextInt(lexicon.length())]);
        String letterTwo = String.valueOf(letter[numRand.nextInt(lexicon.length())]);
        String letterThree = String.valueOf(letter[numRand.nextInt(lexicon.length())]);
        String letterFour = String.valueOf(letter[numRand.nextInt(lexicon.length())]);
        namePicture = letterOne + letterTwo + letterThree + letterFour;
        return namePicture;
    }
}
