package models;

import org.openqa.selenium.By;
import utils.PropertiesReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BookingSearchModel {

    static boolean isAndroid = PropertiesReader.isAndroid();


    //Home Page
    public static final By closeBtn = isAndroid
            ? By.xpath("//android.view.View[@resource-id=\"CROSS\"]")
            : By.id("");

    public static final By bookingLogo = isAndroid
            ? By.xpath("//android.widget.ImageView[@content-desc=\"Booking.com\"]")
            : By.id("");

    public static final By staysBtn = isAndroid
            ? By.xpath("//android.widget.TextView[@text=\"Stays\"]")
            : By.id("");


    //Destination Part:

    public static final By destinationTextBox = isAndroid
            ? By.xpath("//android.view.View[@content-desc=\"Enter your destination\"]")
            : By.id("");

    public static final By destinationInput = isAndroid
            ? By.xpath("//android.widget.EditText[.//android.widget.TextView[@text='Enter destination']]")
            : By.id("");

    public static final By cityName = isAndroid
            ? By.xpath("(//android.widget.TextView[@text=\"New York\"])[1]")
            : By.id("");

    //Select Dates part:

    private static final DateTimeFormatter DAY_CONTENT_FORMAT =
            DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH);
    // Sample Date: "Sunday, November 30, 2025"

    public static By dayCell(LocalDate date) {
        String formatted = date.format(DAY_CONTENT_FORMAT);

        if (isAndroid) {
            String xpath = "//android.view.View[contains(@content-desc,'" + formatted + "')]";
            return By.xpath(xpath);
        } else {
            return By.xpath(""); // iOS
        }
    }

    public static final By selectDatesBtn = isAndroid
            ? By.id("com.booking:id/facet_date_picker_confirm")
            : By.id("");


    //Adults part:

    public static final By guestBox = isAndroid
            ? By.xpath("//android.view.View[@content-desc='Accommodation search box']/android.view.View[3]")
            : By.id("");

    public static final By decreaseAdultsBtn = isAndroid
            ? By.xpath("//android.view.View[@content-desc=\"Decrease Adults\"]")
            : By.id("");

    public static final By increaseAdultsBtn = isAndroid
            ? By.xpath("//android.view.View[@content-desc=\"Increase Adults\"]")
            : By.id("");

    public static final By adultNumber = isAndroid
            ? By.xpath("//android.view.View[starts-with(@content-desc,'Adults ')]/android.widget.TextView")
            : By.id("");

    //Children part
    public static final By decreaseChildrenBtn = isAndroid
            ? By.xpath("//android.view.View[@content-desc=\"Decrease Children\"]")
            : By.id("");

    public static final By increaseChildrenBtn = isAndroid
            ? By.xpath("//android.view.View[@content-desc=\"Increase Children\"]")
            : By.id("");

    public static final By childrenNumber = isAndroid
            ? By.xpath("//android.view.View[contains(@content-desc,'Children')]/android.widget.TextView")
            : By.id("");

    public static final By child1Required = isAndroid
            ? By.xpath("//android.widget.TextView[@content-desc=\"Child 1 Input required\"]")
            : By.id("");

    public static final By childAgePicker = isAndroid
            ? By.id("android:id/numberpicker_input")
            : By.id("");

    public static final By childrenAgeConfirmBtn = isAndroid
            ? By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")
            : By.id("");

    public static final By age1dropdown = isAndroid
            ? By.xpath("(//android.widget.TextView[@text=\"Select age\"])[1]")
            : By.id("");


    //Rooms Part
    public static final By decreaseRoom = isAndroid
            ? By.xpath("//android.view.View[@content-desc=\"Decrease Rooms\"]")
            : By.id("");

    public static final By increaseRoom = isAndroid
            ? By.xpath("//android.view.View[@content-desc=\"Increase Rooms\"]")
            : By.id("");

    public static final By roomNumber = isAndroid
            ? By.xpath("//android.view.View[starts-with(@content-desc,'Rooms ')]/android.widget.TextView")
            : By.id("");


    public static final By travellingPet = isAndroid
            ? By.xpath("//android.view.View[@content-desc=\"Traveling with pets?\"]")
            : By.id("");


    public static final By applyBtn = isAndroid
            ? By.xpath("//*[@text='Apply']")
            : By.id("");

    public static final By searchBtn = isAndroid
            ? By.xpath("(//android.widget.TextView[@text=\"Search\"])[1]")
            : By.id("");

}

