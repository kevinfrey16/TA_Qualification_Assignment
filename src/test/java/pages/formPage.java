package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class formPage {

    public formPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

    @FindBy(xpath = "//*[@class='main-header' and contains(text(),'Forms')]")
	public WebElement forms_header;

    @FindBy(xpath = "//*[@class='main-header' and contains(text(),'Practice Form')]")
	public WebElement practice_form_header;

    @FindBy(xpath = "//span[@class='text' and contains(text(),'Practice Form')]")
	public WebElement menu_practice_form_link;

    @FindBy(xpath = "//input[@id='firstName']")
	public WebElement firstname_input;

    @FindBy(xpath = "//input[@id='lastName']")
	public WebElement lastname_input;

    @FindBy(xpath = "//input[@id='userEmail']")
	public WebElement email_input;

    @FindBy(xpath = "//*[@id='genterWrapper']")
	public WebElement gender_wrapper;

    @FindBy(xpath = "//*[@id='gender-radio-1']")
	public WebElement male_radio;

    @FindBy(xpath = "//*[@id='gender-radio-2']")
	public WebElement female_radio;

    @FindBy(xpath = "//*[@id='gender-radio-3']")
	public WebElement other_radio;

    @FindBy(xpath = "//input[@id='userNumber']")
	public WebElement mobileNumber_input;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
	public WebElement dateOfBirth_input;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
	public WebElement month_dropdown;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
	public WebElement year_dropdown;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div")
	public WebElement allDates;

    @FindBy(xpath = "//input[@id='subjectsInput']")
	public WebElement subjects_container;

    @FindBy(xpath = "//*[@id='hobbiesWrapper']")
	public WebElement hobbies_wrapper;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-1']")
	public WebElement sport_hobbie;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-2']")
	public WebElement reading_hobbie;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-3']")
	public WebElement music_hobbie;

    @FindBy(xpath = "//input[@id='uploadPicture']")
	public WebElement uploadPicture_btn;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
	public WebElement currentAddress_input;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
	public WebElement select_state;

    @FindBy(xpath = "//input[@id='react-select-4-input']")
	public WebElement select_city;

    @FindBy(xpath = "//button[@id='submit' and contains(text(),'Submit')]")
	public WebElement submit_btn;

    @FindBy(xpath = "//*[@id='example-modal-sizes-title-lg' and contains(text(),'Thanks for submitting the form')]")
	public WebElement modal_header;

    @FindBy(xpath = "//button[@id='closeLargeModal']")
	public WebElement close_modal_btn;
}
