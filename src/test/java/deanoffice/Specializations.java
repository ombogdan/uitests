package deanoffice;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
public class Specializations extends Login{

    @Test
    public void SortField() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.Specializations();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div")).click();
    }

    @Test
    public void SearchByOneField() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.Specializations();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[3]/div[2]/span/span")).click();
        //Натиснув на три паралельні полоски
        WebElement search = driver.findElement(By.id("filterText"));
        search.sendKeys("Інженерія програмного забезпечення");
        //Ввів значення для пошуку
        Thread.sleep(2000);
        String expected= driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        //Знайшов назву групи
        assertThat("Інженерія програмного забезпечення", containsString(expected));

    }
    @Test
    public void EditGeneralInformation() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.Specializations();
        WebElement qwer = driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]"));
        //Вибрав групу натиснувши на checkbox
        qwer.click();
        goTo.editSpecializations();
        driver.findElement(By.cssSelector("#name")).sendKeys("Autotest");
        //Ввів значення для нової назви спеціалізації
        Thread.sleep(2000);
        String expected= driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        //Знайшов назву групи
        assertThat("Інженерія програмного забезпечення", containsString(expected));

    }
}
