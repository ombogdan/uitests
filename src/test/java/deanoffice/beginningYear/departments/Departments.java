package deanoffice.beginningYear.departments;

import deanoffice.settings.Settings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Departments extends Settings {
    private DepartmentsPage departmentsPage = new DepartmentsPage();

    @Test
    public void inactiveDepartments() {
        Login();
        driver.findElement(departmentsPage.startYear).click();
        driver.findElement(departmentsPage.departments).click();
        driver.findElement(departmentsPage.inactiveDepartments).click();
    }

    @Test
    public void addNewDepartments() throws InterruptedException {
        Login();
        driver.findElement(departmentsPage.startYear).click();
        driver.findElement(departmentsPage.departments).click();
        driver.findElement(departmentsPage.addNewDepartmentBtn).click();
        driver.findElement(departmentsPage.nameDepartment).sendKeys("Autotest2");
        driver.findElement(departmentsPage.abbreviationDepartment).sendKeys("Autotest");
        driver.findElement(departmentsPage.createDepartmentBtn).click();
        Thread.sleep(1000);
        driver.findElement(departmentsPage.findIcon).click();
        driver.findElement(departmentsPage.searchField).sendKeys("Autotest2");
        String expected = driver.findElement(departmentsPage.firstDepartmentName).getText();
        Thread.sleep(1000);
        assertThat("Autotest1", containsString(expected));
    }

    @Test
    public void deleteDepartments() throws InterruptedException {
        Login();
        driver.findElement(departmentsPage.startYear).click();
        driver.findElement(departmentsPage.departments).click();
        String actual = driver.findElement(departmentsPage.firstDepartmentName).getText();
        driver.findElement(departmentsPage.selectFirstDepartment).click();
        driver.findElement(departmentsPage.deleteDepartmentBtn).click();
        driver.findElement(departmentsPage.deleteThisDepartmentBtn).click();
        Thread.sleep(1000);
        driver.findElement(departmentsPage.findIcon).click();
        driver.findElement(departmentsPage.searchField).sendKeys(actual);
        WebElement display = driver.findElement(departmentsPage.firstDepartmentName);
        String q = display.getText();
        if (q.equals(actual)) {
            Assert.fail();
        } else {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void editInformationAboutDepartments() {
        Login();
        driver.findElement(departmentsPage.startYear).click();
        driver.findElement(departmentsPage.departments).click();
        driver.findElement(departmentsPage.selectFirstDepartment).click();
        driver.findElement(departmentsPage.editDepartmentBtn).click();
        String windowHandler = driver.getWindowHandle();
        driver.switchTo().window(windowHandler);
        driver.findElement(departmentsPage.nameDepartment).clear();
        driver.findElement(departmentsPage.nameDepartment).sendKeys("ChangeText");
    }

    @Test
    public void addANewDepartmentsIfExist() {
        Login();
        driver.findElement(departmentsPage.startYear).click();
        driver.findElement(departmentsPage.departments).click();
        driver.findElement(departmentsPage.addNewDepartmentBtn).click();
        driver.findElement(departmentsPage.nameDepartment).sendKeys("Autotest");
        driver.findElement(departmentsPage.abbreviationDepartment).sendKeys("Au");
        driver.findElement(departmentsPage.createDepartmentBtn).click();
        try {
            WebDriverWait wait = new
                    WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void sortField() {
        Login();
        driver.findElement(departmentsPage.startYear).click();
        driver.findElement(departmentsPage.departments).click();
        driver.findElement(departmentsPage.nameDepartment).click();
        driver.findElement(departmentsPage.nameDepartment).click();
    }

    @Test
    public void searchByOneField() throws InterruptedException {
        Login();
        driver.findElement(departmentsPage.startYear).click();
        driver.findElement(departmentsPage.departments).click();
        driver.findElement(departmentsPage.findIcon).click();
        WebElement search = driver.findElement(departmentsPage.searchField);
        search.click();
        search.sendKeys("кафедра системного програмування");
        Thread.sleep(1000);
        String expected = driver.findElement(departmentsPage.firstDepartmentName).getText();
        assertThat("кафедра системного програмування", containsString(expected));
    }
}
