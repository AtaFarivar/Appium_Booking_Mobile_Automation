package pages;

import models.BookingSearchModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ElementHelper;


import javax.xml.stream.events.EndElement;
import java.time.LocalDate;
import java.util.List;

public class BookingSearchPage {
    WebDriver driver;
    ElementHelper helper;

    public BookingSearchPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);

    }

    public void openHomePage() {
        helper.findElement(BookingSearchModel.bookingLogo);
    }

    public void closeSignInPage() {
        helper.click(BookingSearchModel.closeBtn);
    }

    public void clickStaysMenu() {
        helper.click(BookingSearchModel.staysBtn);
    }

    public void validateBookingLogo() {
        Assert.assertTrue(
                helper.findElement(BookingSearchModel.bookingLogo).isDisplayed(),
                "Booking.com logo must be visible on home page"
        );
    }

    // ---------- Destination ----------

    public void tapOnDestinationBox() {
        helper.click(BookingSearchModel.destinationTextBox);
    }

    public void enterDestination(String city) {

        helper.setText(BookingSearchModel.destinationInput, city);
    }

    public void selectDestinationFromSuggestions(String city) {
        helper.click(BookingSearchModel.cityName);
    }

    // ---------- Dates ----------

    // ---------- Dates – Dynamic Calendar Picker ----------

    /**
     * Selects a given date on the Booking.com calendar widget.
     * The method automatically scrolls down until the target date becomes visible.
     * Works across month and year transitions (e.g., Dec → Jan, 2025 → 2026).
     *
     * @param date The LocalDate value to select.
     */
    private void selectDateOnCalendar(LocalDate date) {

        // Dynamic locator for the given day
        By dayLocator = BookingSearchModel.dayCell(date);

        // Try up to 6 scroll attempts (enough to cover multiple months ahead)
        for (int i = 0; i < 6; i++) {

            // If the target date is visible, select it
            if (!driver.findElements(dayLocator).isEmpty()) {
                helper.click(dayLocator);
                return;
            }

            // Otherwise scroll down to load the next month
            helper.scrollDown();
        }

        throw new RuntimeException("Target date not found on the calendar: " + date);
    }

    /**
     * Selects the check-in date as tomorrow.
     * Automatically handles month transitions (e.g., last day of the month).
     */
    public void selectCheckInTomorrow() {
        LocalDate checkIn = LocalDate.now().plusDays(1);
        selectDateOnCalendar(checkIn);
    }

    /**
     * Selects the check-out date based on the number of nights.
     * Example: nights = 7 → selects 7 days after the check-in.
     * Handles cases where the date falls in the next month or year.
     */
    public void selectCheckOutAfterNights(int nights) {
        LocalDate checkIn = LocalDate.now().plusDays(1);
        LocalDate checkOut = checkIn.plusDays(nights);
        selectDateOnCalendar(checkOut);
    }

    public void tapSelectDatesButton() {
        helper.click(BookingSearchModel.selectDatesBtn);
    }
// ---------- Guests – Adults ----------

    public void openGuestsPanel() {
        helper.click(BookingSearchModel.guestBox);
    }

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

    // ---------- Guests – Children ----------

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

    public void increaseChildrenFrom0To2ByTwoTaps() {
        helper.click(BookingSearchModel.increaseChildrenBtn);
        helper.click(BookingSearchModel.increaseChildrenBtn);
    }

    public void openFirstChildDropdown() {
        helper.click(BookingSearchModel.age1dropdown);
    }

    public void openSecondChildDropdown() {
        helper.click(BookingSearchModel.age1dropdown);
    }


    private void setChildAge(String ageText) {
        // Extract only the number from the text, e.g. "6" from "6 years"
        String ageNumber = ageText.replaceAll("\\D+", "");  // "6"

        if (ageNumber.isEmpty()) {
            throw new RuntimeException("Could not parse age from: " + ageText);
        }

        // Try up to 10 small scrolls to reach the desired age
        for (int i = 0; i < 15; i++) {
            String current = helper.getText(BookingSearchModel.childAgePicker).trim();
            // Example of current: "Select", "6 years", "6 years old", etc.
            if (current.contains(ageNumber)) {
                // Desired age is now selected in the center
                return;
            }

            // Age not yet correct -> scroll a bit to move the wheel
            helper.smallScrollDown();
        }

        // If we exit the loop, the age was not reached
        String finalText = helper.getText(BookingSearchModel.childAgePicker);
        throw new RuntimeException("Could not set child age to: " + ageText +
                " (last value in picker: " + finalText + ")");
    }

    public void setFirstChildAge(String ageText) {
        setChildAge(ageText);
    }

    public void clickOnOkBtn(){
        helper.click(BookingSearchModel.childrenAgeConfirmBtn);
    }
    public void setSecondChildAge(String ageText) {
        setChildAge(ageText);
    }


    // ---------- Guests – Rooms ----------

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

    // ---------- Pets toggle ----------

    public void assertTravellingWithPetsDisabled() {
        WebElement petToggle = helper.findElement(BookingSearchModel.travellingPet);
        String checked = petToggle.getAttribute("checked"); // "true" / "false"
        Assert.assertEquals(checked, "false", "Travelling with pets toggle should be OFF");
    }

    // ---------- Apply & Search ----------

    public void clickApply() {
        helper.click(BookingSearchModel.applyBtn);
    }

    public void clickSearch() {
        helper.click(BookingSearchModel.searchBtn);
    }

}


