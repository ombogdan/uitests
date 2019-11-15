package deanoffice.beginningYear.coursesForGroup;

import deanoffice.settings.GoTo;
import deanoffice.settings.Settings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class CoursesForGroups extends Settings {

    @Test
    public void selectGroup() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.coursesForGroups();
        new Select(driver.findElement(By.id("group"))).selectByIndex(1);
    }

    @Test
    public void findCourses() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[1]/div/div/div[4]/input")).sendKeys("Бази даних");
    }

    @Test
    public void setCourses() throws InterruptedException {
        findCourses();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[2]/div[1]/div/studied-courses/div/div/table/tbody/tr/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[5]/div/div[1]/button[1]")).click();
        driver.quit();
    }

    @Test
    public void setCoursesIfExist() throws InterruptedException {
        findCourses();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[2]/div[1]/div/studied-courses/div/div/table/tbody/tr[1]/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[1]")).click();
        String expected = driver.findElement(By.className("sn-title.ng-tns-c9-2.ng-star-inserted")).getText();
        assertThat("Помилка", containsString(expected));
        //я не можу знайти елемент який виводить повідомлення про помилку
    }

    @Test
    public void searchCourse() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[1]/div/div/div[4]/input")).sendKeys("Англійська мова");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[2]/div[1]/div/studied-courses/div/div/table/tbody/tr/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[1]")).click();
        driver.quit();
    }

    @Test
    public void removeCoursesFromAGroup() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[2]")).click();
        driver.quit();
    }

    @Test
    public void copyItemsFromAnotherGroup() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[3]")).click();
        driver.findElement(By.xpath("/html/body/modal-container/div/div/copy-courses-dialog/div[2]/div/div/ul/li[1]")).click();
        driver.quit();
    }

    @Test
    public void academicDifference() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[7]/input")).click();
        driver.findElement(By.cssSelector("#app > div > courses-for-groups > div > div.course-for-group-table > added-courses > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[5]/div/div[1]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/label/input")).click();
        WebElement elems = driver.findElement(By.cssSelector("#app > div > courses-for-groups > div > div.course-for-group-table > added-courses > div > div > table > tbody > tr:nth-child(1) > td:nth-child(7) > input"));
        if (elems.isSelected()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
        driver.quit();
    }

    @Test
    public void cancelEdit() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[3]")).click();
        driver.findElement(By.xpath("/html/body/modal-container/div/div/copy-courses-dialog/div[2]/div/div/ul/li[1]")).click();
        driver.quit();
    }

    @Test
    public void selectTeacherForCourses() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[6]/button")).click();
        String actual = driver.findElement(By.xpath("/html/body/modal-container/div/div/teacher-dialog/div[2]/ul/li[1]")).getText();
        actual = actual.substring(0, actual.indexOf(" "));
        driver.findElement(By.xpath("/html/body/modal-container/div/div/teacher-dialog/div[2]/ul/li[1]")).click();
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[6]/button")).getText();
        expected = expected.substring(0, expected.indexOf(" "));
        assertThat(actual, containsString(expected));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#app > div > courses-for-groups > div > div.bg-white.fixed-bottom.ml-3 > div > div.col-11 > button.btn.btn-success.btn-medium.ml-1")).click();
        driver.quit();
    }

    @Test
    public void editCourse() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[9]/button")).click();
        new Select(driver.findElement(By.id("knowledgeControl"))).selectByIndex(5);
        driver.findElement(By.xpath("/html/body/modal-container/div/div/edit-dialog/div[2]/div/div/button[1]")).click();
        String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[3]")).getText();
        assertThat("державний іспит", containsString(actual));
        driver.quit();
    }
}