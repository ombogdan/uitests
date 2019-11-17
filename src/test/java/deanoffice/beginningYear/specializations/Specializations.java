package deanoffice.beginningYear.specializations;

import deanoffice.settings.GoTo;
import deanoffice.settings.Settings;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Specializations extends Settings {

    @Test
    public void sortField() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        goTo.specializations();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div")).click();
        driver.quit();
    }

    @Test
    public void searchByOneField() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        goTo.specializations();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[3]/div[2]/span/span")).click();
        WebElement search = driver.findElement(By.id("filterText"));
        search.sendKeys("Інженерія програмного забезпечення");
        Thread.sleep(2000);
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        assertThat("Інженерія програмного забезпечення", containsString(expected));
        driver.quit();
    }

    @Test
    public void createNewSpecializations() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        goTo.specializations();
        driver.findElement(By.cssSelector("#app > div > specialization > div > div > div > div > div:nth-child(2) > button.btn.btn-success.mr-1")).click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Autotest");
        new Select(driver.findElement(By.id("specialityId"))).selectByIndex(6);
        new Select(driver.findElement(By.id("degreeId"))).selectByIndex(1);
        new Select(driver.findElement(By.id("departmentId"))).selectByIndex(1);
        driver.findElement(By.xpath("//*[@id=\"nameEng\"]")).sendKeys(Keys.PAGE_DOWN);
        String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        assertThat("Autotest", containsString(actual));
        driver.quit();
    }

    @Test
    public void deleteSpecializations() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        goTo.specializations();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]")).click();
        driver.findElement(By.cssSelector("#app > div > specialization > div > div > div > div > div:nth-child(2) > button.btn.btn-danger")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/delete-specialization/modal-wrapper/div/div/div/div[3]/button[1]")).click();
        driver.quit();
    }
}
