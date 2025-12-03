package utils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    static WebDriver driver;

    public static void startDriver() {
        String platform = PropertiesReader.getProperty("platform");

        if (platform.equals("Android")) {

            UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
            uiAutomator2Options.setPlatformName("Android");
            uiAutomator2Options.setAutomationName("UiAutomator2");
            uiAutomator2Options.setAppPackage("com.booking");
            uiAutomator2Options.setAppActivity("com.booking.startup.HomeActivity");
            uiAutomator2Options.setUdid("emulator-5554");
            uiAutomator2Options.setNoReset(false);
            uiAutomator2Options.setAutoGrantPermissions(true);
            uiAutomator2Options.setLanguage("en");
            uiAutomator2Options.setLocale("US");

            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), uiAutomator2Options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

        } else {
            XCUITestOptions xcuiTestOptions = new XCUITestOptions();
            xcuiTestOptions.setPlatformName("IOS");
            xcuiTestOptions.setAutomationName("XCUITest");
            xcuiTestOptions.setUdid("");
            xcuiTestOptions.setBundleId("");
            xcuiTestOptions.setNoReset(false);
            xcuiTestOptions.setAutoAcceptAlerts(true);
            xcuiTestOptions.setLanguage("en");
            xcuiTestOptions.setLocale("US");
            try {
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), xcuiTestOptions);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void stopDriver() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
