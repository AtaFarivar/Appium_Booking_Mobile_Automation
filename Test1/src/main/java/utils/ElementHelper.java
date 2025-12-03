package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.InvalidMidiDataException;

import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class ElementHelper {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;


    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver, Duration.ofSeconds(10));
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void setText(By by, String text) {
         findElement(by).sendKeys(text);
    }

    public void clear(By by) {
        findElement(by).clear();
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void waitText(By by, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }

    public void sendKeys(String text) {
        switch (text) {
            case "BackSpace":
                actions.sendKeys(Keys.BACK_SPACE).build().perform();
                break;
            case "Enter":
                actions.sendKeys(Keys.ENTER).build().perform();
                break;
            case "Return":
                actions.sendKeys(Keys.RETURN).build().perform();
                break;
            case "Space":
                actions.sendKeys(Keys.SPACE).build().perform();
                break;

        }
    }


    public void hideKeyBoard(){
        ((AndroidDriver) driver).hideKeyboard();
        ((IOSDriver) driver).hideKeyboard();
    }

    public void scrollDown() {
        {
            int startX = driver.manage().window().getSize().getWidth() / 2;
            int endX = driver.manage().window().getSize().getWidth() / 2;
            int startY = driver.manage().window().getSize().getHeight() / 4;
            int endY = driver.manage().window().getSize().getHeight() * 3 / 4;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            ((AppiumDriver) driver).perform(List.of(swipe));
        }
    }

    public void smallScrollDown() {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        int startX = width / 2;
        int startY = height / 2;
        int endY = (int)(height * 0.65);  // only small movement, perfect for NumberPicker

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence seq = new Sequence(finger, 1);
        seq.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(finger.createPointerMove(Duration.ofMillis(250), PointerInput.Origin.viewport(), startX, endY));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) driver).perform(List.of(seq));
    }

    public void scrollUp() {
        {
            int startX = driver.manage().window().getSize().getWidth() / 2;
            int endX = driver.manage().window().getSize().getWidth() / 2;
            int startY = driver.manage().window().getSize().getHeight() * 3 / 4;
            int endY = driver.manage().window().getSize().getHeight() / 4;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            ((AppiumDriver) driver).perform(List.of(swipe));
        }
    }

    public void scrollUpSmall() {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        int startX = width / 2;
        int endX = width / 2;
        int startY = height / 2 + height / 8;
        int endY = height / 2 - height / 8;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) driver).perform(List.of(swipe));
    }


}
