package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement
            dataInput = $("#dateOfBirthInput"),
            monthDatapicker = $(".react-datepicker__month-select"),
            yearDatapicker = $(".react-datepicker__year-select"),
            dayDatapicker = $(".react-datepicker__month");

    public void setDate(String day, String month, String year) {
        dataInput.click();
        monthDatapicker.selectOption(month);
        yearDatapicker.selectOption(year);
        dayDatapicker.findElement(byText(day)).click();
    }
}
