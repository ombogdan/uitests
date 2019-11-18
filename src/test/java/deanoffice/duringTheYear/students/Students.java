package deanoffice.duringTheYear.students;

import deanoffice.settings.Settings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Students extends Settings {
    private StudentsPage studentsPage = new StudentsPage();
//    private final Wait<WebDriver> wait = new WebDriverWait(driver, 5).withMessage("Element was not found");


    @Test
    public void searchByOneField() throws InterruptedException {
        driver.findElement(studentsPage.duringTheYear).click();
        driver.findElement(studentsPage.students).click();
        driver.findElement(studentsPage.searchIcon).click();
        Thread.sleep(3000);
        driver.findElement(studentsPage.searchField).sendKeys("Якименко");
        Thread.sleep(1000);
        String expected = driver.findElement(studentsPage.getFirstNameStudent).getText();
        assertThat("Якименко", containsString(expected));
    }

    @Test
    public void searchStudents() throws InterruptedException {
        driver.findElement(studentsPage.duringTheYear).click();
        driver.findElement(studentsPage.students).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(studentsPage.getFirstNameStudent);
        driver.findElement(studentsPage.searchLabel).sendKeys("Водолад Ілля Богданович");
        driver.findElement(studentsPage.searchBtn).click();
        Thread.sleep(1000);
        if (!driver.findElement(studentsPage.selectStudent).isSelected()) {
            System.out.println("Студент був вибраний");
        } else {
            Assert.fail();
        }
    }
}
