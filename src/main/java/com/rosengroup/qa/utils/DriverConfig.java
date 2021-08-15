package com.rosengroup.qa.utils;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class DriverConfig {

    private static WindowsDriver driver;

    public static WindowsDriver getDriver() {
        return driver;
    }

    public static void initializeDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app",
                    PropertiesConfig.getParameter("App"));
            capabilities.setCapability("platformName",
                    PropertiesConfig.getParameter("SO"));
            capabilities.setCapability("deviceName",
                    PropertiesConfig.getParameter("DeviceName"));
            driver = new WindowsDriver(
                    new URL(PropertiesConfig.getParameter("Url")), capabilities);
            driver.manage().timeouts().implicitlyWait(
                    Long.parseLong(PropertiesConfig.getParameter("ImplicitlyWait")), TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void disconnectDriver(){
        driver.close();
        driver.quit();
    }
}