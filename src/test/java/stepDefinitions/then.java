package stepDefinitions;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import managers.fileReaderManager;
import pages.formPage;
import pages.testPage;
import testData.books;

public class then {

    public static WebDriver driver() throws MalformedURLException{

        WebDriver driver = webDriverSetUp.getWebDriverSession();
        return driver;
        
    }

    @Then("I click on Login button")
    public void I_click_on_Login_button() throws Exception{

        testPage test = new testPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 5);

        wait.until(ExpectedConditions.visibilityOf(test.login_btn));
        //JavascriptExecutor ex = (JavascriptExecutor)driver;

        test.login_btn.click();
		//ex.executeScript("arguments[0].click()", test.login_btn);
    }

    @Then("I should be able to see the profile details")
    public void I_should_be_able_to_see_the_profile_details() throws Exception {
        
        testPage test = new testPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 5);

        wait.until(ExpectedConditions.visibilityOf(test.profile_header));

		Assert.assertEquals(true, test.profile_header.isDisplayed());
        Assert.assertEquals(true, test.userName_value.isDisplayed());
        Assert.assertEquals(true, test.bookInventory_table.isDisplayed());
        Assert.assertEquals(true, test.logout_btn.isDisplayed());
        Assert.assertEquals(true, test.gotoStore_btn.isDisplayed());
        Assert.assertEquals(true, test.deleteAccount_btn.isDisplayed());
        Assert.assertEquals(true, test.deleteAllBooks_btn.isDisplayed());
    }

    @Then("I should be able to see the Book Store Application")
    public void I_should_be_able_to_see_the_Book_Store_Application() throws Exception {

        testPage test = new testPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 5);

        wait.until(ExpectedConditions.visibilityOf(test.book_store_header));

		Assert.assertEquals(true, test.book_store_header.isDisplayed());
        Assert.assertEquals(true, test.bookInventory_table.isDisplayed());
    }

    @Then("I should be able to see {string} book added")
    public void I_should_be_able_to_see_book_added(String book_requested) throws Exception{

        books book = fileReaderManager.getInstance().getBookJsonReader().getBook_requested(book_requested);
        testPage test = new testPage(driver());
        
        Assert.assertEquals(test.book_title.getText(), book.bookName);
        Assert.assertEquals(test.book_author.getText(), book.author);
        Assert.assertEquals(test.book_publisher.getText(), book.publisher);
    }

    @Then("^I expect to see the Student Registration Form$")
    public void I_expect_to_see_the_Student_Registration_Form() throws Exception {

        formPage form = new formPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 5);

        wait.until(ExpectedConditions.visibilityOf(form.practice_form_header));

		Assert.assertEquals(true, form.practice_form_header.isDisplayed());
        Assert.assertEquals(true, form.firstname_input.isDisplayed());
        Assert.assertEquals(true, form.lastname_input.isDisplayed());
        Assert.assertEquals(true, form.email_input.isDisplayed());
        Assert.assertEquals(true, form.gender_wrapper.isDisplayed());
        Assert.assertEquals(true, form.mobileNumber_input.isDisplayed());
        Assert.assertEquals(true, form.dateOfBirth_input.isDisplayed());
        Assert.assertEquals(true, form.subjects_container.isDisplayed());
        Assert.assertEquals(true, form.hobbies_wrapper.isDisplayed());
        Assert.assertEquals(true, form.uploadPicture_btn.isDisplayed());
        Assert.assertEquals(true, form.currentAddress_input.isDisplayed());
        Assert.assertEquals(true, form.select_state.isDisplayed());
        Assert.assertEquals(true, form.select_city.isDisplayed());
        Assert.assertEquals(true, form.submit_btn.isDisplayed());

    }

    @Then("^I register a new student$")
    public void I_register_a_new_student() throws Exception{

        formPage form = new formPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 5);
        JavascriptExecutor ex=(JavascriptExecutor)driver();

		ex.executeScript("arguments[0].click()", form.submit_btn);
        wait.until(ExpectedConditions.visibilityOf(form.modal_header));

        ex.executeScript("arguments[0].click()", form.close_modal_btn);
    }
}
