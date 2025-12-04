package pages;

import models.BookingSearchModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ElementHelper;

public class BookingSearchPage {

    private final WebDriver driver;
    private final ElementHelper helper;

    public BookingSearchPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
    }

    // ---------- Home & basic navigation ----------

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

    // ---------- Apply & Search ----------

    public void clickApply() {
        helper.click(BookingSearchModel.applyBtn);
    }

    public void clickSearch() {
        helper.click(BookingSearchModel.searchBtn);
    }
}