package utils;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.formPage;
import stepDefinitions.webDriverSetUp;

public class datePicker {

    public static WebDriver driver() throws MalformedURLException{

        WebDriver driver = webDriverSetUp.getWebDriverSession();
        return driver;
        
    }

    public void selectDate(String date_requested) throws Exception{

        formPage form = new formPage(driver());

        String splitter[] = date_requested.split(" ");
        String day = splitter[0]; 
        String month = splitter[1];
        String year = splitter[2];

        form.dateOfBirth_input.click();

        Select drpMonth = new Select(form.month_dropdown);
        drpMonth.selectByVisibleText(month);

        Select drpYear = new Select(form.year_dropdown);
        drpYear.selectByVisibleText(year);

        List<WebElement> allDates = driver().findElements(By.xpath("//div[@class='react-datepicker__month']//div"));

        for(WebElement element : allDates) {
			
			String date = element.getText();
			
			if(date.equalsIgnoreCase(day)) {
				element.click();
				break;
			}
			
		}
    }

}
