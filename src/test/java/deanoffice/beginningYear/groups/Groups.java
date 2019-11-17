package deanoffice.beginningYear.groups;

import deanoffice.settings.GoTo;
import deanoffice.settings.Settings;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Groups extends Settings {
    private GroupsPage groupsPage = new GroupsPage();

    @Test
    public void inactiveGroups(){
        Login();
        driver.findElement(groupsPage.startYear).click();
        driver.findElement(groupsPage.groups).click();
        driver.findElement(groupsPage.inactiveGroups).click();
        String actual = driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-1\"]/label/span\n")).getText();
        assertThat(actual, containsString("Неактивні групи"));
    }

    @Test
    public void addNewGroups() throws InterruptedException {
        JavascriptExecutor js = driver;
        Login();
        driver.findElement(groupsPage.startYear).click();
        driver.findElement(groupsPage.groups).click();
        driver.findElement(groupsPage.newGroupBtn).click();
        driver.findElement(groupsPage.nameGroup).sendKeys("autotest");
        js.executeScript("window.scrollBy(0,-300)");
        driver.findElement(groupsPage.createGroup).click();
        Thread.sleep(2000);
        driver.findElement(groupsPage.searchIcon).click();
        driver.findElement(groupsPage.searchField).sendKeys("autotest");
        String expected = driver.findElement(groupsPage.nameFirstGroup).getText();
        assertThat("autotest", containsString(expected));
    }

    @Test
    public void deleteGroupsWithoutStudents() throws InterruptedException {
        Login();
        driver.findElement(groupsPage.startYear).click();
        driver.findElement(groupsPage.groups).click();
        String actual = driver.findElement(groupsPage.nameFirstGroup).getText();
        driver.findElement(groupsPage.selectFirstGroup).click();
        driver.findElement(groupsPage.deleteGroupBtn).click();
        driver.findElement(groupsPage.deleteThisGroupBtn).click();
        Thread.sleep(1000);
        driver.findElement(groupsPage.inactiveGroups).click();
        Thread.sleep(2000);
        driver.findElement(groupsPage.searchIcon).click();
        driver.findElement(groupsPage.searchField).sendKeys(actual);
        String expected = driver.findElement(groupsPage.nameFirstGroup).getText();
        assertThat(actual, containsString(expected));
    }

    @Test
    public void deleteSomeGroups() throws InterruptedException {
        Login();
        driver.findElement(groupsPage.startYear).click();
        driver.findElement(groupsPage.groups).click();
        String actual = driver.findElement(groupsPage.nameFirstGroup).getText();
        driver.findElement(groupsPage.selectFirstGroup).click();
        driver.findElement(groupsPage.selectSecondGroup).click();
        driver.findElement(groupsPage.deleteGroupBtn).click();
        driver.findElement(groupsPage.deleteThisGroupBtn).click();
        Thread.sleep(1000);
        driver.findElement(groupsPage.inactiveGroups).click();
        Thread.sleep(2000);
        driver.findElement(groupsPage.searchIcon).click();
        driver.findElement(groupsPage.searchField).sendKeys(actual);
        String expected = driver.findElement(groupsPage.nameFirstGroup).getText();
        assertThat(actual, containsString(expected));
    }

    @Test
    public void deleteGroupsWithStudents(){
        Login();
        driver.findElement(groupsPage.startYear).click();
        driver.findElement(groupsPage.groups).click();
        driver.findElement(groupsPage.searchIcon).click();
        driver.findElement(groupsPage.searchField).sendKeys("АКІТ-169");
        driver.findElement(groupsPage.selectFirstGroup).click();
        driver.findElement(groupsPage.deleteGroupBtn).click();
        driver.findElement(groupsPage.deleteThisGroupBtn).click();
        String actual = driver.findElement(groupsPage.errorMessage).getText();
        assertThat(actual, containsString("Помилка"));
    }

    @Test
    public void restoreOneGroup() throws InterruptedException {
        Login();
        driver.findElement(groupsPage.startYear).click();
        driver.findElement(groupsPage.groups).click();
        driver.findElement(groupsPage.inactiveGroups).click();
        String actual = driver.findElement(groupsPage.nameFirstGroup).getText();
        driver.findElement(groupsPage.selectFirstGroup).click();
        driver.findElement(groupsPage.restoreGroupBtn).click();
        driver.findElement(groupsPage.restoreThisGroupBtn).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/recovery-group/modal-wrapper/div/div/div/form/div[2]/button[2]")).click();
        Thread.sleep(2000);
        driver.findElement(groupsPage.inactiveGroups).click();
        driver.findElement(groupsPage.searchIcon).click();
        driver.findElement(groupsPage.searchField).sendKeys(actual);
        String expected = driver.findElement(groupsPage.nameFirstGroup).getText();
        assertThat(actual, containsString(expected));
    }

    @Test
    public void sortField(){
        Login();
        driver.findElement(groupsPage.startYear).click();
        driver.findElement(groupsPage.groups).click();
        driver.findElement(groupsPage.name).click();
        driver.findElement(groupsPage.name).click();
    }

    @Test
    public void searchByOneField() throws InterruptedException {
        Login();
        driver.findElement(groupsPage.startYear).click();
        driver.findElement(groupsPage.groups).click();
        driver.findElement(groupsPage.searchIcon).click();
        Thread.sleep(1000);
        driver.findElement(groupsPage.searchField).sendKeys("БІУ-148");
        Thread.sleep(1000);
        String expected = driver.findElement(groupsPage.nameFirstGroup).getText();
        assertThat("БІУ-148", containsString(expected));
    }
}
