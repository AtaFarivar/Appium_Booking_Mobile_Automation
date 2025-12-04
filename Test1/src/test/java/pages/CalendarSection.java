package pages;

import models.BookingSearchModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

import java.time.LocalDate;

public class CalendarSection {

    private final WebDriver driver;
    private final ElementHelper helper;

    public CalendarSection(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
    }

    private void selectDateOnCalendar(LocalDate date) {
        By dayLocator = BookingSearchModel.dayCell(date);

        for (int i = 0; i < 6; i++) {
            if (!driver.findElements(dayLocator).isEmpty()) {
                helper.click(dayLocator);
                return;
            }
            helper.scrollUp();
        }

        throw new RuntimeException("Target date not found on the calendar: " + date);
    }

    public void selectCheckInTomorrow() {
        LocalDate checkIn = LocalDate.now().plusDays(1);
        selectDateOnCalendar(checkIn);
    }

    public void selectCheckOutAfterNights(int nights) {
        LocalDate checkIn = LocalDate.now().plusDays(1);
        LocalDate checkOut = checkIn.plusDays(nights);
        selectDateOnCalendar(checkOut);
    }

    public void tapSelectDatesButton() {
        helper.click(BookingSearchModel.selectDatesBtn);
    }
}