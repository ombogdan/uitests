package deanoffice.beginningYear.teachers;

import deanoffice.settings.Settings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Teachers extends Settings {
    private TeachersPage teachersPage = new TeachersPage();

    @Test
    public void inactiveTeachers() {
        driver.findElement(teachersPage.startYear).click();
        driver.findElement(teachersPage.teachers).click();
        driver.findElement(teachersPage.inactiveTeachers).click();
    }

    @Test
    public void deleteTeacher() throws InterruptedException {
        driver.findElement(teachersPage.startYear).click();
        driver.findElement(teachersPage.teachers).click();
        String actual = driver.findElement(teachersPage.getFirstNameTeacher).getText();
        driver.findElement(teachersPage.selectFirstTeacher).click();
        driver.findElement(teachersPage.deleteTeacherBtn).click();
        driver.findElement(teachersPage.deleteThisTeacherBtn).click();
        Thread.sleep(1000);
        driver.findElement(teachersPage.inactiveTeachers).click();
        Thread.sleep(2000);
        driver.findElement(teachersPage.searchIcon).click();
        driver.findElement(teachersPage.searchField).sendKeys(actual);
        Thread.sleep(1000);
        String expected = driver.findElement(teachersPage.getFirstNameTeacher).getText();
        assertThat(actual, containsString(expected));
    }

    @Test
    public void deleteSomeTeacher() throws InterruptedException {
        driver.findElement(teachersPage.startYear).click();
        driver.findElement(teachersPage.teachers).click();
        String actual = driver.findElement(teachersPage.getFirstNameTeacher).getText();
        driver.findElement(teachersPage.selectFirstTeacher).click();
        driver.findElement(teachersPage.selectSecondTeacher).click();
        driver.findElement(teachersPage.deleteTeacherBtn).click();
        driver.findElement(teachersPage.deleteThisTeacherBtn).click();
        Thread.sleep(1000);
        driver.findElement(teachersPage.inactiveTeachers).click();
        Thread.sleep(2000);
        driver.findElement(teachersPage.searchIcon).click();
        driver.findElement(teachersPage.searchField).sendKeys(actual);
        Thread.sleep(1000);
        String expected = driver.findElement(teachersPage.getFirstNameTeacher).getText();
        assertThat(actual, containsString(expected));
    }

    @Test
    public void addNewTeacher() throws InterruptedException {
        driver.findElement(teachersPage.startYear).click();
        driver.findElement(teachersPage.teachers).click();
        driver.findElement(teachersPage.addNewTeacherBtn).click();
        driver.findElement(teachersPage.surnameTeacher).sendKeys("Прізвище");
        driver.findElement(teachersPage.nameTeacher).sendKeys("Імя");
        driver.findElement(teachersPage.patronimicTeacher).sendKeys("По Батькові");
        new Select(driver.findElement(teachersPage.positionTeacher)).selectByIndex(0);
        new Select(driver.findElement(teachersPage.departmentTeacher)).selectByIndex(1);
        driver.findElement(teachersPage.maleTeacher).click();
        driver.findElement(teachersPage.createTeacherBtn).click();
        Thread.sleep(2000);
        driver.findElement(teachersPage.searchIcon).click();
        driver.findElement(teachersPage.searchField).sendKeys("Прізвище");
        Thread.sleep(1000);
        String expected = driver.findElement(teachersPage.getFirstNameTeacher).getText();
        Thread.sleep(2000);
        assertThat("Прізвище", containsString(expected));
    }

    @Test
    public void AddANewTeacherWithoutEnteringData() {
        driver.findElement(teachersPage.startYear).click();
        driver.findElement(teachersPage.teachers).click();
        driver.findElement(teachersPage.addNewTeacherBtn).click();
        driver.findElement(teachersPage.createTeacherBtn).click();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().contains("Перевірте введені дані на правильність!")) {
            alert.accept();
        } else {
            Assert.fail();
        }
        driver.quit();
    }

    @Test
    public void addANewTeacherIfExist() throws InterruptedException {
        driver.findElement(teachersPage.startYear).click();
        driver.findElement(teachersPage.teachers).click();
        driver.findElement(teachersPage.addNewTeacherBtn).click();
        driver.findElement(teachersPage.surnameTeacher).sendKeys("Прізвище");
        driver.findElement(teachersPage.nameTeacher).sendKeys("Імя");
        driver.findElement(teachersPage.patronimicTeacher).sendKeys("По Батькові");
        new Select(driver.findElement(teachersPage.positionTeacher)).selectByIndex(0);
        new Select(driver.findElement(teachersPage.departmentTeacher)).selectByIndex(1);
        driver.findElement(teachersPage.maleTeacher).click();
        driver.findElement(teachersPage.createTeacherBtn).click();
        Thread.sleep(2000);
//        Тут повинно вивестись повідомлення про помилку але це ще нереалізовано
    }

    @Test
    public void sortField() {
        driver.findElement(teachersPage.startYear).click();
        driver.findElement(teachersPage.teachers).click();
        driver.findElement(teachersPage.name).click();
        driver.findElement(teachersPage.name).click();
    }

    @Test
    public void searchByOneField() throws InterruptedException {
        driver.findElement(teachersPage.startYear).click();
        driver.findElement(teachersPage.teachers).click();
        driver.findElement(teachersPage.searchIcon).click();
        driver.findElement(teachersPage.searchField).sendKeys("Щерба");
        Thread.sleep(1000);
        String expected = driver.findElement(teachersPage.getFirstNameTeacher).getText();
        assertThat("Щерба", containsString(expected));
    }
}
