package deanoffice.beginningYear.courses;

import deanoffice.settings.Settings;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Courses extends Settings {

    @Test
    public void sortField() {
        CoursesPage coursesPage = new CoursesPage();
        Login();
        driver.findElement(coursesPage.startYear).click();
        driver.findElement(coursesPage.courses).click();
        driver.findElement(coursesPage.nameCourses).click();
        driver.findElement(coursesPage.nameCourses).click();
    }

    @Test
    public void searchByOneField() {
        CoursesPage coursesPage = new CoursesPage();
        Login();
        driver.findElement(coursesPage.startYear).click();
        driver.findElement(coursesPage.courses).click();
        driver.findElement(coursesPage.iconMenu).click();
        WebElement search = driver.findElement(coursesPage.searchInput);
        search.sendKeys("Алгебра та геометрія");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String expected = driver.findElement(coursesPage.firstField).getText();
        assertThat("Алгебра та геометрія", containsString(expected));
    }

    @Test
    public void searchCourse() throws InterruptedException {
        CoursesPage coursesPage = new CoursesPage();
        Login();
        driver.findElement(coursesPage.startYear).click();
        driver.findElement(coursesPage.courses).click();
        driver.findElement(coursesPage.searchInputField).sendKeys("Історія України");
        new Select(driver.findElement(By.id("cmbSemester"))).selectByIndex(1);
        new Select(driver.findElement(By.id("cmbKnowledgeControl"))).selectByIndex(1);
        new Select(driver.findElement(By.id("cmbKnowledgeControl"))).selectByIndex(1);
        driver.findElement(coursesPage.numberOfHours).sendKeys("36");
        driver.findElement(coursesPage.buttonSearchCourse).click();
        Thread.sleep(1000);
        String expected = driver.findElement(coursesPage.firstField).getText();
        assertThat("Історія України", containsString(expected));
    }
}