package deanoffice.settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Settings {
    protected ChromeDriver driver;
//    private WebDriverWait wait;
    ChromeOptions ops = new ChromeOptions();


    @Before
    public void setupAndLogin() {
//        wait = new WebDriverWait(driver, 10);

        ops.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:4200/login");
        WebElement username = driver.findElementByName("username");
        WebElement password = driver.findElementByName("password");
        username.sendKeys("test");
        password.sendKeys("test");
        password.submit();
        String actual = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/a")).getText();
        assertThat(actual, containsString("Вийти"));
    }

    @After
    public void quit() {
        //driver.quit();
    }
}
