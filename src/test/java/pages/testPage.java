package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class testPage {

    public testPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath = "//*[@class='main-header' and contains(text(),'Book Store')]")
	public WebElement book_store_header;

    @FindBy(xpath = "//*[@class='main-header' and contains(text(),'Profile')]")
	public WebElement profile_header;

    @FindBy(xpath = "//span[@class='text' and contains(text(),'Login')]")
	public WebElement menu_login_link;

    @FindBy(xpath = "//span[@class='text' and contains(text(),'Profile')]")
	public WebElement menu_profile_link;

    @FindBy(xpath = "//button[@id='login']")
	public WebElement login_btn;

    @FindBy(xpath = "//*[@id='newUser' and @type='button']")
	public WebElement newUser_btn;

    @FindBy(xpath = "//input[@id='firstname']")
	public WebElement firstname_input;

    @FindBy(xpath = "//input[@id='lastname']")
	public WebElement lastname_input;

    @FindBy(xpath = "//input[@id='userName']")
	public WebElement userName_input;

    @FindBy(xpath = "//input[@id='password']")
	public WebElement password_input;

    @FindBy(xpath = "//label[@id='userName-value']")
	public WebElement userName_value;

    @FindBy(xpath = "//button[@id='submit' and contains(text(),'Log out')]")
	public WebElement logout_btn;

    @FindBy(xpath = "//button[@id='gotoStore' and contains(text(),'Go To Book Store')]")
	public WebElement gotoStore_btn;

    @FindBy(xpath = "//button[@id='submit' and contains(text(),'Delete Account')]")
	public WebElement deleteAccount_btn;

    @FindBy(xpath = "//button[@id='submit' and contains(text(),'Delete All Books')]")
	public WebElement deleteAllBooks_btn;

    @FindBy(xpath = "//*[@class='rt-table']")
	public WebElement bookInventory_table;

    @FindBy(xpath = "//button[@id='addNewRecordButton' and contains(text(),'Add To Your Collection')]")
	public WebElement addNewRecord_btn;

    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]")
	public WebElement book_title;

    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[3]")
	public WebElement book_author;

    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[4]")
	public WebElement book_publisher;

    @FindBy(xpath = "//button[@id='closeSmallModal-ok']")
	public WebElement modal_ok_btn;
}
