package stepDefinitions;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.When;
import managers.fileReaderManager;
import pages.formPage;
import pages.testPage;
import testData.books;
import testData.students;
import testData.users;
import utils.datePicker;

public class when {

    public static WebDriver driver() throws MalformedURLException{

        WebDriver driver = webDriverSetUp.getWebDriverSession();
        return driver;
        
    }

    @When("I click on menu Login link")
    public void I_click_on_menu_Login_link() throws Exception{

        testPage test = new testPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 5);
		JavascriptExecutor ex=(JavascriptExecutor)driver();

        wait.until(ExpectedConditions.visibilityOf(test.menu_login_link));
        ex.executeScript("arguments[0].click()", test.menu_login_link);
    }

    @When("I click on menu Profile link")
    public void I_click_on_menu_Profile_link() throws Exception{

        testPage test = new testPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 5);
        JavascriptExecutor ex=(JavascriptExecutor)driver();

        wait.until(ExpectedConditions.visibilityOf(test.menu_profile_link));
        ex.executeScript("arguments[0].click()", test.menu_profile_link);
    }

    @When("^I click on menu Practice Form link$")
    public void I_click_on_menu_Practice_Form_link() throws Exception{

        formPage form = new formPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 5);
        JavascriptExecutor ex=(JavascriptExecutor)driver();

        wait.until(ExpectedConditions.visibilityOf(form.menu_practice_form_link));
        ex.executeScript("arguments[0].click()", form.menu_practice_form_link);

        Assert.assertEquals(true, form.practice_form_header.isDisplayed());
    }

    @When("I click on Logout button")
    public void I_click_on_Logout_button() throws Exception{

        testPage test = new testPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 5);
        JavascriptExecutor ex=(JavascriptExecutor)driver();

        wait.until(ExpectedConditions.visibilityOf(test.logout_btn));
		ex.executeScript("arguments[0].click()", test.logout_btn);
    }

    @When("I enter {string} login details")
    public void I_enter_login_details(String user_requested) throws Exception{

        users user = fileReaderManager.getInstance().getUserJsonReader().getUser_requested(user_requested);
        testPage test = new testPage(driver());

        test.userName_input.sendKeys(user.userName);
        test.password_input.sendKeys(user.password);
        
    }

    @When("I add {string} book")
    public void I_add_book(String book_requested) throws Exception{

        books book = fileReaderManager.getInstance().getBookJsonReader().getBook_requested(book_requested);
        testPage test = new testPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 20);
        JavascriptExecutor ex=(JavascriptExecutor)driver();

        WebElement book_r = driver().findElement(By.xpath("//a[contains(text(),\'" + book.bookName + "\')]"));

        book_r.click();
        wait.until(ExpectedConditions.visibilityOf(test.addNewRecord_btn));
        ex.executeScript("arguments[0].click()", test.addNewRecord_btn);

        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(driver().switchTo().alert().getText(), "Book added to your collection.");
        driver().switchTo().alert().accept();
    }

    @When("I click on Delete All Books button")
    public void I_click_on_Delete_All_Books_button() throws Exception{

        testPage test = new testPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 20);
        JavascriptExecutor ex=(JavascriptExecutor)driver();

        wait.until(ExpectedConditions.visibilityOf(test.deleteAllBooks_btn));
        ex.executeScript("arguments[0].click()", test.deleteAllBooks_btn);

        driver().switchTo().activeElement();
        ex.executeScript("arguments[0].click()", test.modal_ok_btn);

        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(driver().switchTo().alert().getText(), "All Books deleted.");
        driver().switchTo().alert().accept();
    }

    @When("^I enter \"([^\"]*)\" student details$")
    public void I_enter_student_details(String student_ID) throws Exception{

        students student = fileReaderManager.getInstance().getStudentJsonReader().getStudentByID(student_ID);
        formPage form = new formPage(driver());
        datePicker date = new datePicker();
        JavascriptExecutor ex=(JavascriptExecutor)driver();

        form.firstname_input.sendKeys(student.firstName);
        form.lastname_input.sendKeys(student.lastName);
        form.email_input.sendKeys(student.email);

        if (student.gender.equalsIgnoreCase("Male")) {
            ex.executeScript("arguments[0].click()", form.male_radio);

        } else if (student.gender.equalsIgnoreCase("Female")) {
            ex.executeScript("arguments[0].click()", form.female_radio);

        }else if (student.gender.equalsIgnoreCase("Other")) {
            ex.executeScript("arguments[0].click()", form.other_radio);

        } else {
            throw new Exception("Gender not specified");
        }

        form.mobileNumber_input.sendKeys(student.mobileNumber);

        date.selectDate(student.dateOfBirth);

        for (String subject : student.subjects) {

            form.subjects_container.sendKeys(subject);
            form.subjects_container.sendKeys(Keys.ENTER);
        }

        for (String hobbie : student.hobbies) {

            if (hobbie.equalsIgnoreCase("Sports")) {
                ex.executeScript("arguments[0].click()", form.sport_hobbie);
    
            } else if (hobbie.equalsIgnoreCase("Reading")) {
                ex.executeScript("arguments[0].click()", form.reading_hobbie);
    
            }else if (hobbie.equalsIgnoreCase("Music")) {
                ex.executeScript("arguments[0].click()", form.music_hobbie);
    
            }
        }

        form.uploadPicture_btn.sendKeys("/Users/kf0621/Desktop/Astrik Workspace/assignment/src/test/resources/utils/images/resize-images-print-photoshop-f.jpg");
        form.currentAddress_input.sendKeys(student.address);

        form.select_state.sendKeys(student.state);
        form.select_state.sendKeys(Keys.ENTER);
        
        form.select_city.sendKeys(student.city);
        form.select_city.sendKeys(Keys.ENTER);
        
    }

}
