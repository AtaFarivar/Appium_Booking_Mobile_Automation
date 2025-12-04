package stepDefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.BookingSearchPage;
import pages.CalendarSection;
import pages.GuestsSection;
import utils.DriverFactory;

public class BookingSearchSteps {

    WebDriver driver = DriverFactory.getDriver();
    BookingSearchPage bookingPage = new BookingSearchPage(driver);
    CalendarSection calendar = new CalendarSection(driver);
    GuestsSection guests = new GuestsSection(driver);

    // ---------- Home & basic navigation ----------

    @Given("the user opens the Booking.com homepage")
    public void theUserOpensTheBookingComHomepage() {
        bookingPage.openHomePage();
    }

    @When("the user close the sign-in page")
    public void theUserCloseTheSignInPage() {
        bookingPage.closeSignInPage();
    }

    @When("the user clicks on Stays menu")
    public void theUserClicksOnStaysMenu() {
        bookingPage.clickStaysMenu();
    }

    @When("the user validate the booking logo")
    public void theUserValidateTheBookingLogo() {
        bookingPage.validateBookingLogo();
    }

    // ---------- Destination ----------

    @When("the user tap on the destination text box")
    public void theUserTapOnTheDestinationTextBox() {
        bookingPage.tapOnDestinationBox();
    }

    @When("the user enters {string} as the destination")
    public void theUserEntersAsTheDestination(String city) {
        bookingPage.enterDestination(city);
    }

    @When("the user selects {string} from the suggestions")
    public void theUserSelectsFromTheSuggestions(String city) {
        bookingPage.selectDestinationFromSuggestions(city);
    }

    // ---------- Calendar ----------

    @When("the user selects check-in date as tomorrow")
    public void theUserSelectsCheckInDateAsTomorrow() {
        calendar.selectCheckInTomorrow();
    }

    @When("the user selects check-out date as {int} nights later")
    public void theUserSelectsCheckOutDateAsNightsLater(int nights) {
        calendar.selectCheckOutAfterNights(nights);
    }

    @When("the user taps on the {string} button")
    public void theUserTapsOnTheButton(String buttonText) {
        // Şu an sadece "Select Dates" için kullanıyoruz
        calendar.tapSelectDatesButton();
    }

    // ---------- Guests panel ----------

    @When("the user opens the guests selection panel")
    public void theUserOpensTheGuestsSelectionPanel() {
        guests.openGuestsPanel();
    }

    // ---------- Adults ----------

    @When("the user decreases the number of adults from {int} to {int}")
    public void theUserDecreasesTheNumberOfAdultsFromTo(int from, int to) {
        guests.decreaseAdults(from, to);
    }

    @When("the user increases the number of adults from {int} to {int}")
    public void theUserIncreasesTheNumberOfAdultsFromTo(int from, int to) {
        guests.increaseAdults(from, to);
    }

    @Then("the number of adults should be {int}")
    public void theNumberOfAdultsShouldBe(int expected) {
        guests.assertAdultsCount(expected);
    }

    // ---------- Children ----------

    @When("the user increases the number of children from {int} to {int}")
    public void theUserIncreasesTheNumberOfChildrenFromTo(int from, int to) {
        guests.increaseChildren(from, to);
    }

    @When("the user decreases the number of children from {int} to {int}")
    public void theUserDecreasesTheNumberOfChildrenFromTo(int from, int to) {
        guests.decreaseChildren(from, to);
    }

    @Then("the first child age dropdown should appear")
    public void theFirstChildAgeDropdownShouldAppear() {
        guests.assertFirstChildDropdownAppears();
    }

    @Then("the first child age dropdown should disappear")
    public void theFirstChildAgeDropdownShouldDisappear() {
        guests.assertFirstChildDropdownDisappears();
    }

    @When("the user increases the number of children from {int} to {int} by tap to increase btn two times.")
    public void theUserIncreasesTheNumberOfChildrenFromToByTapToIncreaseBtnTwoTimes(int from, int to) {
        // Artık dinamik: 0→2 gibi durumlarda da aynı metodu kullanıyoruz
        guests.increaseChildren(from, to);
    }

    @When("the user open the first child dropdown item")
    public void theUserOpenTheFirstChildDropdownItem() {
        guests.openFirstChildDropdown();
    }

    @When("the user sets the first child’s age to {string}")
    public void theUserSetsTheFirstChildSAgeTo(String ageText) {
        guests.setFirstChildAge(ageText);
    }

    @When("the user open the second child dropdown item")
    public void theUserOpenTheSecondChildDropdownItem() {
        guests.openSecondChildDropdown();
    }

    @When("the user sets the second child’s age to {string}")
    public void theUserSetsTheSecondChildSAgeTo(String ageText) {
        guests.setSecondChildAge(ageText);
    }

    @When("the user tap on the Ok button")
    public void theUserTapOnTheOkButton() {
        guests.clickOnAgeOkButton();
    }

    // ---------- Rooms ----------

    @When("the user increases the number of rooms from {int} to {int}")
    public void theUserIncreasesTheNumberOfRoomsFromTo(int from, int to) {
        guests.increaseRooms(from, to);
    }

    @When("the user decreases the number of rooms from {int} to {int}")
    public void theUserDecreasesTheNumberOfRoomsFromTo(int from, int to) {
        guests.decreaseRooms(from, to);
    }

    @Then("the room count should display {string}")
    public void theRoomCountShouldDisplay(String expected) {
        guests.assertRoomCount(expected);
    }

    // ---------- Pets ----------

    @When("the travelling with pet should be disable")
    public void theTravellingWithPetShouldBeDisable() {
        guests.assertTravellingWithPetsDisabled();
    }

    // ---------- Apply & Search ----------

    @When("the user clicks on the Apply button")
    public void theUserClicksOnTheApplyButton() {
        bookingPage.clickApply();
    }

    @When("the user clicks on the Search button")
    public void theUserClicksOnTheSearchButton() {
        bookingPage.clickSearch();
    }
}