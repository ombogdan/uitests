package deanoffice.settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Login {
    public ChromeDriver driver;
    OperaDriver operaDriver;

    @Before
    public void setup() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();

    }

    public void Login() {
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

}
