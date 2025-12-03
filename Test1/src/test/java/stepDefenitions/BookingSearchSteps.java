package stepDefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingSearchPage;
import utils.DriverFactory;

public class BookingSearchSteps {

    BookingSearchPage bookingSearchPage;

    public BookingSearchSteps() {
        bookingSearchPage = new BookingSearchPage(DriverFactory.getDriver());
    }

    // ---------- Home & navigation ----------

    @Given("the user opens the Booking.com homepage")
    public void theUserOpensTheBookingComHomepage() {
        bookingSearchPage.openHomePage();
    }

    @When("the user close the sign-in page")
    public void theUserCloseTheSignInPage() {
        bookingSearchPage.closeSignInPage();
    }

    @When("the user clicks on Stays menu")
    public void theUserClicksOnStaysMenu() {
        bookingSearchPage.clickStaysMenu();
    }

    @When("the user validate the booking logo")
    public void theUserValidateTheBookingLogo() {
        bookingSearchPage.validateBookingLogo();
    }

    // ---------- Destination ----------

    @When("the user tap on the destination text box")
    public void theUserTapOnTheDestinationTextBox() {
        bookingSearchPage.tapOnDestinationBox();
    }

    @When("the user enters {string} as the destination")
    public void theUserEntersAsTheDestination(String city) {
        bookingSearchPage.enterDestination(city);

    }

    @When("the user selects {string} from the suggestions")
    public void theUserSelectsFromTheSuggestions(String city) {
        bookingSearchPage.selectDestinationFromSuggestions(city);
    }

    // ---------- Dates ----------

    @When("the user selects check-in date as tomorrow")
    public void theUserSelectsCheckInDateAsTomorrow() {
        bookingSearchPage.selectCheckInTomorrow();
    }

    @When("the user selects check-out date as {int} nights later")
    public void theUserSelectsCheckOutDateAsNightsLater(int nights) {
        bookingSearchPage.selectCheckOutAfterNights(nights);
    }

    @When("the user taps on the {string} button")
    public void theUserTapsOnTheButton(String buttonText) {

        bookingSearchPage.tapSelectDatesButton();
    }

    // ---------- Guests – Adults ----------

    @When("the user opens the guests selection panel")
    public void theUserOpensTheGuestsSelectionPanel() {
        bookingSearchPage.openGuestsPanel();
    }

    @When("the user decreases the number of adults from {int} to {int}")
    public void theUserDecreasesTheNumberOfAdultsFromTo(int from, int to) {
        bookingSearchPage.decreaseAdults(from, to);
    }

    @Then("the number of adults should be {int}")
    public void theNumberOfAdultsShouldBe(int expected) {
        bookingSearchPage.assertAdultsCount(expected);
    }

    @When("the user increases the number of adults from {int} to {int}")
    public void theUserIncreasesTheNumberOfAdultsFromTo(int from, int to) {
        bookingSearchPage.increaseAdults(from, to);
    }

    // ---------- Guests – Children ----------

    @When("the user increases the number of children from {int} to {int}")
    public void theUserIncreasesTheNumberOfChildrenFromTo(int from, int to) {
        bookingSearchPage.increaseChildren(from, to);
    }

    @Then("the first child age dropdown should appear")
    public void theFirstChildAgeDropdownShouldAppear() {
        bookingSearchPage.assertFirstChildDropdownAppears();
    }

    @When("the user decreases the number of children from {int} to {int}")
    public void theUserDecreasesTheNumberOfChildrenFromTo(int from, int to) {
        bookingSearchPage.decreaseChildren(from, to);
    }

    @Then("the first child age dropdown should disappear")
    public void theFirstChildAgeDropdownShouldDisappear() {
        bookingSearchPage.assertFirstChildDropdownDisappears();
    }

    @When("the user increases the number of children from {int} to {int} by tap to increase btn two times.")
    public void theUserIncreasesTheNumberOfChildrenFromToByTapToIncreaseBtnTwoTimes(int from, int to) {
        bookingSearchPage.increaseChildrenFrom0To2ByTwoTaps();
    }

    @When("the user open the first child dropdown item")
    public void theUserOpenTheFirstChildDropdownItem() {
        bookingSearchPage.openFirstChildDropdown();
    }

    @When("the user sets the first child’s age to {string}")
    public void theUserSetsTheFirstChildSAgeTo(String ageText) {
        bookingSearchPage.setFirstChildAge(ageText);
    }

    @When("the user tap on the Ok button")
    public void theUserTapOnTheOkButton() {
        bookingSearchPage.clickOnOkBtn();
    }

    @When("the user open the second child dropdown item")
    public void theUserOpenTheSecondChildDropdownItem() {
        bookingSearchPage.openSecondChildDropdown();
    }

    @When("the user sets the second child’s age to {string}")
    public void theUserSetsTheSecondChildSAgeTo(String ageText) {
        bookingSearchPage.setSecondChildAge(ageText);
    }

    // ---------- Guests – Rooms ----------

    @When("the user increases the number of rooms from {int} to {int}")
    public void theUserIncreasesTheNumberOfRoomsFromTo(int from, int to) {
        bookingSearchPage.increaseRooms(from, to);
    }

    @Then("the room count should display {string}")
    public void theRoomCountShouldDisplay(String expected) {
        bookingSearchPage.assertRoomCount(expected);
    }

    @When("the user decreases the number of rooms from {int} to {int}")
    public void theUserDecreasesTheNumberOfRoomsFromTo(int from, int to) {
        bookingSearchPage.decreaseRooms(from, to);
    }

    // ---------- Pets toggle ----------

    @When("the travelling with pet should be disable")
    public void theTravellingWithPetShouldBeDisable() {
        bookingSearchPage.assertTravellingWithPetsDisabled();
    }

    // ---------- Apply & Search ----------

    @When("the user clicks on the Apply button")
    public void theUserClicksOnTheApplyButton() {
        bookingSearchPage.clickApply();
    }

    @When("the user clicks on the Search button")
    public void theUserClicksOnTheSearchButton() {
        bookingSearchPage.clickSearch();
    }

}