package deanoffice.beginningYear.specializations;

import deanoffice.settings.Settings;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Specializations extends Settings {
    private SpecializationsPage specializationsPage = new SpecializationsPage();

    @Test
    public void sortField() {
        driver.findElement(specializationsPage.startYear).click();
        driver.findElement(specializationsPage.specializations).click();
        driver.findElement(specializationsPage.name).click();
        driver.findElement(specializationsPage.name).click();
    }

    @Test
    public void searchByOneField() throws InterruptedException {
        driver.findElement(specializationsPage.startYear).click();
        driver.findElement(specializationsPage.specializations).click();
        driver.findElement(specializationsPage.searchIcon).click();
        driver.findElement(specializationsPage.searchField).sendKeys("Інженерія програмного забезпечення");
        Thread.sleep(1000);
        String expected = driver.findElement(specializationsPage.firstNameSpecialization).getText();
        assertThat("Інженерія програмного забезпечення", containsString(expected));
    }

    @Test
    public void createNewSpecializations() {
        driver.findElement(specializationsPage.startYear).click();
        driver.findElement(specializationsPage.specializations).click();
        driver.findElement(specializationsPage.addNewSpecializationBtn).click();
        driver.findElement(specializationsPage.nameSpecialization).sendKeys("Autotest");
        new Select(driver.findElement(specializationsPage.specialityId)).selectByIndex(6);
        new Select(driver.findElement(specializationsPage.degreeId)).selectByIndex(1);
        new Select(driver.findElement(specializationsPage.departmentId)).selectByIndex(1);
        driver.findElement(By.xpath("//*[@id=\"nameEng\"]")).sendKeys(Keys.PAGE_DOWN);
        String actual = driver.findElement(specializationsPage.firstNameSpecialization).getText();
        assertThat("Autotest", containsString(actual));
    }

    @Test
    public void deleteSpecializations() {
        driver.findElement(specializationsPage.startYear).click();
        driver.findElement(specializationsPage.specializations).click();
        driver.findElement(specializationsPage.searchField).click();
        driver.findElement(specializationsPage.deleteSpecializationBtn).click();
        driver.findElement(specializationsPage.deleteThisSpecializationBtn).click();
    }
}
