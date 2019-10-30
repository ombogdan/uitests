package deanoffice;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Courses extends Login {

    @Test
    public void SortField() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.Subjects();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/span[1]")).click();
    }

    @Test
    public void SearchByOneField() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.Subjects();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span")).click();
        //Натиснув на три паралельні полоски
        WebElement search = driver.findElement(By.id("filterText"));
        search.sendKeys("Алгебра та геометрія");
        //Ввів значення для пошуку
        Thread.sleep(2000);
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]")).getText();
        //Знайшов назву групи
        assertThat("Алгебра та геометрія", containsString(expected));

    }

    @Test
    public void SearchCourse() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.Subjects();
        new Select (driver.findElement(By.id("cmbSemester"))).selectByIndex(1);
        new Select (driver.findElement(By.id("cmbKnowledgeControl"))).selectByIndex(1);
        new Select (driver.findElement(By.id("cmbKnowledgeControl"))).selectByIndex(1);
        driver.findElement(By.xpath("//*[@id=\"tfHours\"]")).sendKeys("36");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/form/div/div/button")).click();
        Thread.sleep(1000);
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]")).getText();
        //Знайшов назву групи
        assertThat("Історія України", containsString(expected));

    }

}