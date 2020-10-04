package Pages;

import Tests.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Part2Page extends TestClassParent{

    public Part2Page(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Utils utils = new Utils();
    WebDriver driver;


    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private
    WebElement firstName;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private
    WebElement lastName;

    @FindBy(xpath = "//*[@id=\"userEmail\"]")
    private
    WebElement eMail;

    @FindBy(xpath = "//div[@class=\"col-md-9 col-sm-12\"]//*[@id=\"gender-radio-2\"]")
    private
    WebElement gender;

    @FindBy(css = "#userNumber")
    private
    WebElement mobileNumber;

    @FindBy(css = "#dateOfBirthInput")
    private
    WebElement dateOfBirth;

    @FindBy(xpath = "//*[@class=\"react-datepicker__month-select\"]")
    private
    WebElement month;

    @FindBy(xpath = "//*[text() = 'July']")
    private
    WebElement monthJuly;

    @FindBy(css = ".react-datepicker__year-select")
    private
    WebElement year;

    @FindBy(xpath = "//*[text() = '1995']")
    private
    WebElement year1995;

    @FindBy(xpath = "//*[@class=\"react-datepicker__day react-datepicker__day--026\"]")
    private
    WebElement day;

    @FindBy(xpath = "//*[@class=\"subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3\"]")
    private
    WebElement subjects;

    @FindBy(css = "#hobbies-checkbox-2")
    private
    WebElement firstHobby;

    @FindBy(css = "#hobbies-checkbox-3")
    private
    WebElement secondHobby;

    @FindBy(css = "#currentAddress")
    private
    WebElement address;

    @FindBy(css = ". css-tlfecz-indicatorContainer")
    private
    WebElement state;

    @FindBy(css = ". css-tlfecz-indicatorContainer")
    private
    WebElement city;

    @FindBy(xpath = "//*[@id='uploadPicture']")
    private
    WebElement uploadElement;





    public boolean waitElementisDisplayed(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public boolean waitElementIsClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.isDisplayed();
    }



    public void navigate() {
        driver.get(utils.E2E_URL);
    }



    public void selectNameAndEmail() {


        firstName.click();
        firstName.sendKeys("Aaaaaaa");

        lastName.click();
        lastName.sendKeys("Bbbbbbbb");

        eMail.click();
        eMail.sendKeys("nnnn@test.com");

    }

    public void selectGenderAndPhoneNumber() {

        Actions actions = new Actions(driver);


        actions.moveToElement(gender);
        actions.click();

        mobileNumber.click();
        mobileNumber.sendKeys("07661212192");
    }

    public void selectDateOfBirth() {

        dateOfBirth.click();

        month.click();
        monthJuly.click();
        year.click();
        year1995.click();
        day.click();

    }

    public void selectSubjects() {
        Actions actions = new Actions(driver);

        waitElementIsClickable(subjects);

        actions.moveToElement(subjects);
        actions.click();
        actions.sendKeys("English" + Keys.ENTER);
        actions.build().perform();

        actions.sendKeys("Computer Science" + Keys.ENTER);
        actions.build().perform();

    }

    public void selectHobbyandUploadPhoto() {
        Actions actions = new Actions(driver);


        actions.moveToElement(firstHobby);
        actions.click();
        actions.moveToElement(secondHobby);
        actions.click();

        uploadElement.sendKeys("/Users/normia/Desktop/testpicture.jpeg");
    }

    public void selectAddressandState() {
        Actions actions = new Actions(driver);

        actions.moveToElement(address);
        actions.click();
        actions.sendKeys("Street Blablabla, Number 34, New York City");
        actions.build().perform();

        actions.moveToElement(state);
        actions.click();
        actions.sendKeys("NCR" + Keys.ENTER);
//        actions.build().perform();

        actions.moveToElement(city);
        actions.click();
        actions.sendKeys("Noida" + Keys.ENTER);
//        actions.build().perform();
    }
}

