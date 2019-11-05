package deanoffice.beginningYear;

import deanoffice.settings.GoTo;
import deanoffice.settings.Login;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class  Courses extends Login {

    @Test
    public void sortField() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.subjects();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/span[1]")).click();
        driver.quit();
    }

    @Test
    public void searchByOneField() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.subjects();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span")).click();
        WebElement search = driver.findElement(By.id("filterText"));
        search.sendKeys("Алгебра та геометрія");
        Thread.sleep(2000);
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]")).getText();
        assertThat("Алгебра та геометрія", containsString(expected));
        driver.quit();
    }

    @Test
    public void searchCourse() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.subjects();
        new Select(driver.findElement(By.id("cmbSemester"))).selectByIndex(1);
        new Select(driver.findElement(By.id("cmbKnowledgeControl"))).selectByIndex(1);
        new Select(driver.findElement(By.id("cmbKnowledgeControl"))).selectByIndex(1);
        driver.findElement(By.xpath("//*[@id=\"tfHours\"]")).sendKeys("36");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/form/div/div/button")).click();
        Thread.sleep(1000);
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]")).getText();
        assertThat("Історія України", containsString(expected));
        driver.quit();
    }

}