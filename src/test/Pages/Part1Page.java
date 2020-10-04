package Pages;
import Tests.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.*;


public class Part1Page extends TestClassParent {

    public Part1Page(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public Utils utils = new Utils();
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"searchBox\"]")
    private
    WebElement textBox;

    @FindBy(xpath = "//*[@class=\"input-group-text\"]")
    private
    WebElement searchIcon;

    @FindBy(xpath = "//*[@class=\"rt-tr-group\"]")
    private
    WebElement searchBoxText;

    @FindBy(css = ".rt-tr-group")
    private
    List<WebElement> booksList;


    @FindBy(css = ".rt-tr-group")
    private
    List<WebElement> bookDetails;

    private String chosenBook = "You Don't Know JS";

    @FindBy(xpath = "//*[contains(text(), \"You Don't Know JS\")]")
    private
    WebElement bookToClick;

    @FindBy(css = "#title-wrapper > .col-md-9 > #userName-value")
    private
    WebElement titleLabel;

    @FindBy(css = "#author-wrapper> .col-md-9 > #userName-value")
    private
    WebElement authorLabel;

    @FindBy(css = ".rt-tr > .rt-td:nth-of-type(2)")
    private
    WebElement titleSelector;

    @FindBy(css = ".rt-tr > .rt-td:nth-of-type(3)")
    private
    WebElement authorSelector;


    public String bookToCheck = "Learning JavaScript Design Patterns";

    private HashMap hmap = new HashMap<String, String>();


    public void navigate() {
        driver.get(utils.GENERAL_URL);
    }


    //Type to search - assert - First test

    public boolean typeToSearch(String searchedText) {

        textBox.click();
        textBox.clear();
        textBox.sendKeys(searchedText);
        searchIcon.click();
        return searchBoxText.getText().contains(searchedText);
    }

// List of the books- Second test

    public boolean booksList() {

        for (WebElement details : bookDetails) {
            if (details.getText().contains(chosenBook)) {
                System.out.println(details.getText().replace(chosenBook, ""));
            }

        }
        return false;
    }


    //Made this by css selector, and this ">" descends, reaching to second and third element

    public void listByIndex(){

        for (int i = 0; i <bookDetails.size(); i++) {
            System.out.println(bookDetails.get(i).findElement(By.cssSelector(".rt-tr > .rt-td:nth-of-type(2)")).getText());
            System.out.println(bookDetails.get(i).findElement(By.cssSelector(".rt-tr > .rt-td:nth-of-type(3)")).getText());
            System.out.println("_______________________________");
        }

    }

    public void addTitleAndAuthorToHashmap() {
        for(WebElement details : bookDetails) {

            if (details.findElement(By.cssSelector(".rt-tr > .rt-td:nth-of-type(2)")).getText().length() > 0 && details.findElement(By.cssSelector(".rt-tr > .rt-td:nth-of-type(3)")).getText().length() > 0) {
                hmap.put(details.findElement(By.cssSelector(".rt-tr > .rt-td:nth-of-type(2)")).getText(), details.findElement(By.cssSelector(".rt-tr > .rt-td:nth-of-type(3)")).getText());

            }
        }
    }

    public void displayHashMapKey(HashMap hashMap) {
        Iterator it = hashMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }

        //By Key


        System.out.println(hashMap.get("Learning JavaScript Design Patterns"));
    }

    public void displayHashMapValue(HashMap hashMap) {
        Iterator it = hashMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(pair.getValue().equals("Kyle Simpson")) {
                System.out.println(pair.getKey());
            }
        }
    }

    public void hashMapTitleAndAuthor() {

        this.addTitleAndAuthorToHashmap();


       // by key
        this.displayHashMapKey(hmap);



        // By Value

        this.displayHashMapValue(hmap);



        }

        public void clickOnOneOfTheBooks() {

            //Split the URL until "?"


            bookToClick.click();
            String url = driver.getCurrentUrl();

            String[] splitedUrl = url.split("\\?");

            String[] splittedBookParam = splitedUrl[splitedUrl.length - 1].split("\\=");

            System.out.println(splitedUrl[splitedUrl.length - 1]);

            for(int i = 0;i < splittedBookParam.length; i++) {
                System.out.println("Book name is " + splittedBookParam[i]);
            }
    }

    public void getTitleAndAuthorFromFirstPage() {
        String bookTitle = "";
        String bookAuthor = "";

        for(WebElement details : bookDetails) {

            if (details.findElement(By.cssSelector(".rt-tr > .rt-td:nth-of-type(2)")).getText().length() > 0 && details.findElement(By.cssSelector(".rt-tr > .rt-td:nth-of-type(3)")).getText().length() > 0) {
                if(details.findElement(By.cssSelector(".rt-tr > .rt-td:nth-of-type(2)")).getText().contains(bookToCheck)) {
                    bookTitle = details.findElement(By.cssSelector(".rt-tr > .rt-td:nth-of-type(2)")).getText();
                    bookAuthor = details.findElement(By.cssSelector(".rt-tr > .rt-td:nth-of-type(3)")).getText();
                }
            }
        }

        driver.findElement(By.xpath("//*[contains(text(), \"" + bookToCheck + "\")]")).click();
        Assert.assertEquals(titleLabel.getText(), bookTitle);
        Assert.assertEquals(authorLabel.getText(), bookAuthor);
    }
}




