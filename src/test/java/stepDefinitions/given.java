package stepDefinitions;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import managers.fileReaderManager;
import pages.formPage;
import pages.mainPage;
import pages.testPage;

public class given {

    public static WebDriver driver() throws MalformedURLException{

        WebDriver driver = webDriverSetUp.getWebDriverSession();
        return driver;
        
    }

    @Given("^I navigate to Main Page$")
    public void go_to_main_page() throws Exception {

        driver().get(fileReaderManager.getInstance().getConfigReader().getURL());
        driver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver().manage().window().maximize();
    }

    @Given("^I expect to see ToolsQA Logo$")
    public void I_expect_to_see_ToolsQA_Logo() throws Exception{

        mainPage main = new mainPage(driver());

        Assert.assertEquals(true, main.toolsQA_logo.isDisplayed());
    }

    @Given("I navigate to the Book Store Application")
    public void I_navigate_to_the_Book_Store_Application() throws Exception {

        mainPage main = new mainPage(driver());
        testPage test = new testPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 5);
        JavascriptExecutor ex=(JavascriptExecutor)driver();

		Assert.assertEquals(true, main.book_store_btn.isDisplayed());
        
        ex.executeScript("arguments[0].click()", main.book_store_btn);
        wait.until(ExpectedConditions.visibilityOf(test.book_store_header));

        Assert.assertEquals(true, test.book_store_header.isDisplayed());
    }

    @Given("^I navigate to the Student Registration Form Application$")
    public void I_navigate_to_the_Student_Registration_Form_Application() throws Exception {

        mainPage main = new mainPage(driver());
        formPage form = new formPage(driver());
        WebDriverWait wait = new WebDriverWait(driver(), 5);
        JavascriptExecutor ex=(JavascriptExecutor)driver();
        
		Assert.assertEquals(true, main.forms_btn.isDisplayed());
        
        ex.executeScript("arguments[0].click()", main.forms_btn);
        wait.until(ExpectedConditions.visibilityOf(form.forms_header));

        Assert.assertEquals(true, form.forms_header.isDisplayed());
    }
}
