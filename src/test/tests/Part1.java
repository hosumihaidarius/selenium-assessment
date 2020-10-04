package Tests;

import Pages.Part1Page;
import Pages.TestClassParent;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Part1 extends TestClassParent {

    public Utils utils = new Utils();
    private final String userDirProperty = System.getProperty("user.dir");


    Part1Page c1p = new Part1Page(driver);


    @BeforeTest
    public void setup() {


        super.beforeMethod();
        c1p = new Part1Page(driver);
    }

    @AfterTest
    public void teardown() {

        super.afterMethod();
    }


    @Test(description = "Type to search - assert", priority = 1)

    public void assertTypeToSearch() {

        //Navigate to the URL

        c1p.navigate();

        //First text

        Assert.assertTrue(c1p.typeToSearch(utils.FIRST_TEXT));

        //Second text

        Assert.assertTrue(c1p.typeToSearch(utils.SECOND_TEXT));

        //Third text

        Assert.assertTrue(c1p.typeToSearch(utils.THIRD_TEXT));
    }

    @Test(description = "List - If book name == 'chosen book'", priority = 2)

    public void listOfBooks() {

        c1p.navigate();
        c1p.booksList();
    }

    @Test(description = "Get name of the book/author by index", priority = 3)

    public void bookAuthorByIndex() {

        c1p.navigate();
        c1p.listByIndex();
    }

    @Test(description = "Use a hash map to map title and author as k/v", priority = 4)

    public void hashMapTitleAndAuthorAsKeyAndValue() {

        c1p.navigate();
        c1p.hashMapTitleAndAuthor();
    }

    @Test(description = "Click on one of the books and return the name of the book", priority = 5)

    public void clickOnOneOfTheBooksURL() {


        c1p.navigate();
        c1p.clickOnOneOfTheBooks();
    }

    @Test(description = "Get the title and the author from any book in url : https://demoqa.com/books", priority = 6)

    public void titleAndAuthorFromUrl() {

        c1p.navigate();
        c1p.getTitleAndAuthorFromFirstPage();
    }
}






