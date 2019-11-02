package deanoffice.beginningYear;

import deanoffice.settings.GoTo;
import deanoffice.settings.Login;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    @Test
    public void deleteSomeTeacher() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.teachers();
        String actual = driver.findElement(By.className("ag-cell-value")).getText();
        goTo.selectFirstGroup();
        driver.findElement(By.cssSelector("#app > div > app-teachers > div > div > div > div > ag-grid-angular > div > div.ag-root-wrapper-body.ag-layout-normal > div > div.ag-body-viewport.ag-layout-normal.ag-row-animation > div.ag-center-cols-clipper > div > div > div:nth-child(2) > div:nth-child(1) > span > span.ag-selection-checkbox > span.ag-icon.ag-icon-checkbox-unchecked")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/div/div/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/delete-teacher/modal-wrapper/div/div/div/div[3]/button[1]")).click();
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

    @Test
    public void editInformationAboutTeacher() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.teachers();
        String actual = driver.findElement(By.className("ag-cell-value")).getText();
        goTo.selectFirstGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/div/div/button[2]")).click();
        Thread.sleep(2000);

        String longstring = "qwerty";
        WebElement inputField = driver.findElement(By.id("scientificDegree"));
        driver.executeScript("arguments[0].setAttribute('value', '" + longstring + "')", inputField);

        Thread.sleep(2000);
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[1]/span/span[2]")).getText();
        Thread.sleep(2000);
        assertThat(actual, containsString(expected));
    }

    @Test
    public void addNewTeacher() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.teachers();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/div/div/button[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"surname\"]")).sendKeys("Прізвище");
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Імя");
        driver.findElement(By.xpath("//*[@id=\"patronimic\"]")).sendKeys("По Батькові");
        new Select(driver.findElement(By.id("position"))).selectByIndex(0);
        new Select(driver.findElement(By.id("department"))).selectByIndex(4);
        driver.findElement(By.xpath("//*[@id=\"sexMALE\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/add-teacher/modal-wrapper/div/div/div/div[3]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"filterText\"]")).sendKeys("Прізвище");
        Thread.sleep(1000);
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[1]/span/span[2]")).getText();
        Thread.sleep(2000);
        assertThat("Прізвище", containsString(expected));

    }

}
