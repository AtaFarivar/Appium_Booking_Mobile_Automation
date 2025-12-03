Feature: Booking.com Search Steps

  Scenario: Verify hotel search flow with destination, dates, and guests configuration
    Given the user opens the Booking.com homepage
    When the user close the sign-in page
    When the user clicks on Stays menu
    When the user validate the booking logo
    When the user tap on the destination text box
    When the user enters "New York" as the destination
    When the user selects "New York" from the suggestions


    When the user selects check-in date as tomorrow
    When the user selects check-out date as 7 nights later
    When the user taps on the "Select Dates" button


    When the user opens the guests selection panel
    When the user decreases the number of adults from 2 to 1
    Then the number of adults should be 1
    When the user increases the number of adults from 1 to 2
    Then the number of adults should be 2

    When the user increases the number of children from 0 to 1
    Then the first child age dropdown should appear
    When the user decreases the number of children from 1 to 0
    Then the first child age dropdown should disappear
    When the user increases the number of children from 0 to 2 by tap to increase btn two times.
    When the user open the first child dropdown item
    When the user sets the first child’s age to "6 years"
    When the user tap on the Ok button

    When the user open the second child dropdown item
    When the user sets the second child’s age to "7 years"
    When the user tap on the Ok button

    When the user increases the number of rooms from 1 to 2
    Then the room count should display "2"
    When the user decreases the number of rooms from 2 to 1
    Then the room count should display "1"
    When the user increases the number of rooms from 1 to 2
    When the travelling with pet should be disable
    When the user clicks on the Apply button
    When the user clicks on the Search button