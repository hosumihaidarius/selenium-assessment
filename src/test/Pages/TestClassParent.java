package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestClassParent {


    private final String userDirProperty = System.getProperty("user.dir");
    int pageIndex;

    public WebDriver driver;



//    @Override
    public void beforeMethod() {
        System.out.println("BeforeMethod");
        System.setProperty("webdriver.chrome.driver", userDirProperty + "/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



//    @Override
    public void afterMethod() {


        System.out.println("AfterMethod");
        driver.close();
        driver.quit();
    }
}