package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainPage {


    public mainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='app']/header/a/img")
	public WebElement toolsQA_logo;
	
    @FindBy(xpath = "//*[contains(text(),'Book Store Application')]")
	public WebElement book_store_btn;
	
    @FindBy(xpath = "//*[contains(text(),'Forms')]")
	public WebElement forms_btn;
}
