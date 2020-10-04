package Tests;

import Pages.Part1Page;
import Pages.Part2Page;
import Pages.TestClassParent;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Part2 extends TestClassParent {

    public Utils utils = new Utils();
    private final String userDirProperty = System.getProperty("user.dir");


    Part2Page c2p = new Part2Page(driver);


    @BeforeTest
    public void setup() {


        super.beforeMethod();
        c2p = new Part2Page(driver);
    }

    @AfterTest
    public void teardown() {

        super.afterMethod();

    }

    @Test(description = "End to End", priority = 7)

    public void endToEnd(){

    c2p.navigate();
    c2p.selectNameAndEmail();
    c2p.selectGenderAndPhoneNumber();
    c2p.selectDateOfBirth();
    c2p.selectSubjects();
    c2p.selectHobbyandUploadPhoto();
    c2p.selectAddressandState();

    }
}
