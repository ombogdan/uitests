package deanoffice.beginningYear;

import deanoffice.settings.GoTo;
import deanoffice.settings.Login;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Departments extends Login {

    @Test
    public void inactiveDepartments() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.departments();
        driver.findElement(By.xpath("//*[@id=\"active\"]")).click();
    }

    @Test
    public void deleteDepartments() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.departments();
        String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/div/div/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/delete-department/modal-wrapper/div/div/div/form/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/delete-department/modal-wrapper/div/div/div/form/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/delete-department/modal-wrapper/div/div/div/form/div[2]/button[1]")).sendKeys(actual);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-department/delete-department/modal-wrapper/div/div/div/form/div[2]/button[1]"));

    }

}
