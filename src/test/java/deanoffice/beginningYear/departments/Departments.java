package deanoffice.beginningYear.departments;

import deanoffice.settings.GoTo;
import deanoffice.settings.Settings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Departments extends Settings {

    @Test
    public void inactiveDepartments() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.departments();
        driver.findElement(By.xpath("//*[@id=\"active\"]")).click();
        driver.quit();
    }

    @Test
    public void addNewDepartments() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.departments();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/div/div/button[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Autotest1");
        driver.findElement(By.xpath("//*[@id=\"abbr\"]")).sendKeys("Autotest");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/add-department/modal-wrapper/div/div/div/department-form/form/div[2]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"filterText\"]")).sendKeys("Autotest");
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[1]/span/span[2]")).getText();
        Thread.sleep(2000);
        assertThat("Autotest1", containsString(expected));
        driver.quit();
    }

    @Test
    public void deleteDepartments() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.departments();
        String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/div/div/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/delete-department/modal-wrapper/div/div/div/form/div[2]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"filterText\"]")).sendKeys(actual);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/delete-department/modal-wrapper/div/div/div/form/div[2]/button[1]"));
        WebElement display = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]"));
        String q = display.getText();
        if (q == actual) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
        driver.quit();
    }

    @Test
    public void editInformationAboutDepartments() {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.departments();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/div/div/button[2]")).click();
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().window(windowHandler);
        driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("ChangeText");

    }

    @Test
    public void addANewDepartmentsIfExist() {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.departments();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/div/div/button[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Autotest");
        driver.findElement(By.xpath("//*[@id=\"abbr\"]")).sendKeys("Au");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/add-department/modal-wrapper/div/div/div/department-form/form/div[2]/button[1]")).click();
        try {
            WebDriverWait wait = new
                    WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            Assert.fail();
        }
        driver.quit();
    }

    @Test
    public void sortField() {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.departments();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/span[1]")).click();
        driver.quit();
    }

    @Test
    public void searchByOneField() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.departments();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span")).click();
        WebElement search = driver.findElement(By.id("filterText"));
        search.click();
        search.sendKeys("кафедра системного програмування");
        Thread.sleep(2000);
        String expected = driver.findElement(By.cssSelector("#app > div > app-department > div > div > div > div > ag-grid-angular > div > div.ag-root-wrapper-body.ag-layout-normal > div > div.ag-body-viewport.ag-layout-normal.ag-row-animation > div.ag-center-cols-clipper > div > div > div > div:nth-child(1) > span > span.ag-cell-value")).getText();
        assertThat("кафедра системного програмування", containsString(expected));
        driver.quit();
    }
}