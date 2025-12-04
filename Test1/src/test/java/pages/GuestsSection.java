package pages;

import models.BookingSearchModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ElementHelper;

public class GuestsSection {

    private final WebDriver driver;
    private final ElementHelper helper;

    public GuestsSection(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
    }

    // ---------- Panel ----------
    public void openGuestsPanel() {
        helper.click(BookingSearchModel.guestBox);
    }

    // ---------- Adults ----------
    private int getAdultsCount() {
        String text = helper.getText(BookingSearchModel.adultNumber).trim();
        return Integer.parseInt(text);
    }

    public void decreaseAdults(int from, int to) {
        int current = getAdultsCount();
        while (current > to) {
            helper.click(BookingSearchModel.decreaseAdultsBtn);
            current = getAdultsCount();
        }
    }

    public void increaseAdults(int from, int to) {
        int current = getAdultsCount();
        while (current < to) {
            helper.click(BookingSearchModel.increaseAdultsBtn);
            current = getAdultsCount();
        }
    }

    public void assertAdultsCount(int expected) {
        Assert.assertEquals(getAdultsCount(), expected, "Adults count is not as expected");
    }

    // ---------- Children ----------
    private int getChildrenCount() {
        String text = helper.getText(BookingSearchModel.childrenNumber).trim();
        return Integer.parseInt(text);
    }

    public void increaseChildren(int from, int to) {
        int current = getChildrenCount();
        while (current < to) {
            helper.click(BookingSearchModel.increaseChildrenBtn);
            current = getChildrenCount();
        }
    }

    public void decreaseChildren(int from, int to) {
        int current = getChildrenCount();
        while (current > to) {
            helper.click(BookingSearchModel.decreaseChildrenBtn);
            current = getChildrenCount();
        }
    }

    public void assertFirstChildDropdownAppears() {
        Assert.assertTrue(
                helper.findElement(BookingSearchModel.age1dropdown).isDisplayed(),
                "First child age dropdown must be visible"
        );
    }

    public void assertFirstChildDropdownDisappears() {
        boolean present = !driver.findElements(BookingSearchModel.age1dropdown).isEmpty();
        Assert.assertFalse(present, "First child age dropdown must not be visible");
    }

    public void openFirstChildDropdown() {
        helper.click(BookingSearchModel.age1dropdown);
    }

    public void openSecondChildDropdown() {
        helper.click(BookingSearchModel.age1dropdown); // sende neyse onu koy
    }

    // ---- child age picker ----
    private void setChildAge(String ageText) {
        String ageNumber = ageText.replaceAll("\\D+", "");
        if (ageNumber.isEmpty()) {
            throw new RuntimeException("Could not parse age from: " + ageText);
        }

        for (int i = 0; i < 40; i++) {
            String current = helper.getText(BookingSearchModel.childAgePicker).trim();
            String currentNumber = current.replaceAll("\\D+", "");
            if (ageNumber.equals(currentNumber)) {
                return;
            }
            helper.smallScrollUp();
        }

        String finalText = helper.getText(BookingSearchModel.childAgePicker);
        throw new RuntimeException("Could not set child age to: " + ageText +
                " (last value in picker: " + finalText + ")");
    }

    public void setFirstChildAge(String ageText) {
        setChildAge(ageText);
    }

    public void setSecondChildAge(String ageText) {
        setChildAge(ageText);
    }

    public void clickOnAgeOkButton() {
        helper.click(BookingSearchModel.childrenAgeConfirmBtn);
    }

    // ---------- Rooms ----------
    private int getRoomCount() {
        String text = helper.getText(BookingSearchModel.roomNumber).trim();
        return Integer.parseInt(text);
    }

    public void increaseRooms(int from, int to) {
        int current = getRoomCount();
        while (current < to) {
            helper.click(BookingSearchModel.increaseRoom);
            current = getRoomCount();
        }
    }

    public void decreaseRooms(int from, int to) {
        int current = getRoomCount();
        while (current > to) {
            helper.click(BookingSearchModel.decreaseRoom);
            current = getRoomCount();
        }
    }

    public void assertRoomCount(String expected) {
        Assert.assertEquals(String.valueOf(getRoomCount()), expected, "Room count is not as expected");
    }

    // ---------- Pets ----------
    public void assertTravellingWithPetsDisabled() {
        WebElement petToggle = helper.findElement(BookingSearchModel.travellingPet);
        String checked = petToggle.getAttribute("checked");
        Assert.assertEquals(checked, "false", "Travelling with pets toggle should be OFF");
    }
}