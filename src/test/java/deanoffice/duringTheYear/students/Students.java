package deanoffice.duringTheYear.students;

import deanoffice.settings.Settings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Students extends Settings {
    private StudentsPage studentsPage = new StudentsPage();
    //    Wait<WebDriver> wait;


    @Test
    public void searchByOneField() throws InterruptedException {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);

        driver.findElement(studentsPage.duringTheYear).click();
        driver.findElement(studentsPage.students).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(studentsPage.getFirstNameStudent)));
        driver.findElement(studentsPage.searchIcon).click();
        driver.findElement(studentsPage.searchField).sendKeys("Якименко");
        Thread.sleep(2000);
        String expected = driver.findElement(studentsPage.getFirstNameStudent).getText();
        assertThat("Якименко", containsString(expected));
    }

    @Test
    public void searchStudents() throws InterruptedException {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        driver.findElement(studentsPage.duringTheYear).click();
        driver.findElement(studentsPage.students).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(studentsPage.getFirstNameStudent)));
        driver.findElement(studentsPage.searchIcon);
        driver.findElement(studentsPage.searchLabel).sendKeys("Водолад Ілля Богданович");
        driver.findElement(studentsPage.searchBtn).click();
        Thread.sleep(1000);
        if (!driver.findElement(studentsPage.selectStudent).isSelected()) {
            System.out.println("Студент був вибраний");
        } else {
            Assert.fail();
        }
    }

    @Test
    public void selectColumnForDisplayed() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        driver.findElement(studentsPage.duringTheYear).click();
        driver.findElement(studentsPage.students).click();
        driver.findElement(studentsPage.selectColumnsBtn).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(studentsPage.birthDay))).click();
        driver.findElement(studentsPage.surname).click();
        driver.findElement(studentsPage.patronymic).click();
        driver.findElement(studentsPage.name).click();
        driver.findElement(studentsPage.okBtn).click();
        String group = driver.findElement(studentsPage.groupInThePage).getText();
        assertThat("Група", containsString(group));
    }

    @Test
    public void enrollANewStudent() throws InterruptedException {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        driver.findElement(studentsPage.duringTheYear).click();
        driver.findElement(studentsPage.students).click();
        driver.findElement(studentsPage.addNewStudentBtn).click();
        driver.findElement(studentsPage.enrollNewStudent).click();
        driver.findElement(studentsPage.surnameNewStudent).sendKeys("autotest");
        driver.findElement(studentsPage.nameNewStudent).sendKeys("autotest");
        driver.findElement(studentsPage.patronymicNewStudent).sendKeys("autotest");
        driver.findElement(studentsPage.maleNewStudent).click();
        driver.findElement(studentsPage.formOfTrainingNewStudent).click();
        driver.findElement(studentsPage.birthDateNewStudent).sendKeys("11/12/2019");
        driver.findElement(studentsPage.birthDateNewStudent).sendKeys(Keys.TAB);
        new Select(driver.findElement(studentsPage.groupNameNewStudent)).selectByIndex(1);
        driver.findElement(studentsPage.enrolThisStudent).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(studentsPage.getFirstNameStudent)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(studentsPage.searchIcon))).click();
        driver.findElement(studentsPage.searchField).sendKeys("Autotest");
        Thread.sleep(2000);
        String expected = driver.findElement(studentsPage.getFirstNameStudent).getText();
        assertThat("Autotest", containsString(expected));
    }

    @Test
    public void enrollAStudentIfExist() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        driver.findElement(studentsPage.duringTheYear).click();
        driver.findElement(studentsPage.students).click();
        driver.findElement(studentsPage.addNewStudentBtn).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(studentsPage.enrollNewStudent))).click();
        driver.findElement(studentsPage.pibNewStudent).sendKeys("Анціпорович Віра Борисівна");
        driver.findElement(studentsPage.birthDateNewStudent).sendKeys("11/12/2019");
        driver.findElement(studentsPage.formOfTrainingNewStudent).click();
        new Select(driver.findElement(studentsPage.groupNameNewStudent)).selectByIndex(10);
        driver.findElement(studentsPage.enrolThisStudent).click();
    }

    @Test
    public void enrollAStudentWithoutEnteringData() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        driver.findElement(studentsPage.duringTheYear).click();
        driver.findElement(studentsPage.students).click();
        driver.findElement(studentsPage.addNewStudentBtn).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(studentsPage.enrollNewStudent))).click();
        driver.findElement(studentsPage.enrolThisStudent).click();
        if (!driver.findElement(studentsPage.errorAboutBlankFields).isDisplayed())
            System.out.println("Test Passed");
    }

    @Test
    public void editInformationStudent() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        driver.findElement(studentsPage.duringTheYear).click();
        driver.findElement(studentsPage.students).click();
        driver.findElement(studentsPage.selectStudent).click();
        driver.findElement(studentsPage.informationAboutStudentsBtn).click();
        driver.findElement(studentsPage.editFieldEngSurnameStudent).clear();
        driver.findElement(studentsPage.editFieldEngSurnameStudent).sendKeys("Abdulaev");
        js.executeScript("window.scrollBy(0,-300)");
        driver.findElement(studentsPage.saveEditInformationBtn).click();
        driver.findElement(studentsPage.informationAboutStudentsBtn).click();
        String actual = driver.findElement(studentsPage.editFieldEngSurnameStudent).getText();
        assertThat("Abdulaev", containsString(actual));
    }
}
