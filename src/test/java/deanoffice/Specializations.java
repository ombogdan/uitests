package deanoffice;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


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
    public void CreateCurrentCompetences() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        GoTo goTo = new GoTo(driver);
        Login();
        goTo.Specializations();
        //Вибрав спеціалізацію натиснувши на checkbox
        driver.findElement(By.cssSelector("#app > div > specialization > div > div > div > div > div:nth-child(2) > button.btn.btn-success.mr-1")).click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Autotest");
        new Select (driver.findElement(By.id("specialityId"))).selectByIndex(6);
        new Select (driver.findElement(By.id("degreeId"))).selectByIndex(1);
        new Select (driver.findElement(By.id("departmentId"))).selectByIndex(1);
        driver.findElement(By.xpath("//*[@id=\"nameEng\"]")).sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/add-specialization/modal-wrapper/div/div/div/div[3]/button[1]")).click();
        String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        assertThat("Autotest", containsString(actual));

    }

    @Test
    public void EditGeneralInformation() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.Specializations();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]")).click();
        //Вибрав групу натиснувши на checkbox
        goTo.editSpecializations();
        WebElement q = driver.findElement(By.cssSelector("#name"));
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(q));
        wait.until(ExpectedConditions.elementToBeClickable(q));
        q.sendKeys("Autotest");
        //Ввів значення для нової назви спеціалізації
        Thread.sleep(2000);
        String expected= driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        //Знайшов назву групи
        assertThat("Інженерія програмного забезпечення", containsString(expected));

    }
    @Test

    public void EditCurrentCompetences() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.Specializations();
        WebElement qwer = driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]"));
        //Вибрав спеціалізацію натиснувши на checkbox
        qwer.click();

        goTo.editSpecializations();

        driver.findElement(By.xpath("//*[@id=\"specialization-form-tabset\"]/ul/li[3]/a/span")).click();

//        assertThat("Інженерія програмного забезпечення", containsString(expected));

    }


}
