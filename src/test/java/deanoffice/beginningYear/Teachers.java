package deanoffice.beginningYear;

import deanoffice.settings.GoTo;
import deanoffice.settings.Login;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Teachers extends Login {

    @Test
    public void inactiveTeachers() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.teachers();
        driver.findElement(By.xpath("//*[@id=\"active\"]")).click();
    }

    @Test
    public void deleteTeacher() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();

        goTo.teachers();
        String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/div/div/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/delete-teacher/modal-wrapper/div/div/div/div[3]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/delete-teacher/modal-wrapper/div/div/div/div[3]/button[1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"active\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"filterText\"]")).sendKeys(actual);
        Thread.sleep(2000);
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[1]/span/span[2]")).getText();
        Thread.sleep(2000);
        assertThat(actual, containsString(expected));
    }

}
