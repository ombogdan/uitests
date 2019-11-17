package deanoffice.beginningYear.coursesForGroup;

import deanoffice.settings.Settings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class CoursesForGroups extends Settings {
    private CoursesForGroupsPage coursesForGroupsPage = new CoursesForGroupsPage();

    @Test
    public void selectGroup() {
        driver.findElement(coursesForGroupsPage.startYear).click();
        driver.findElement(coursesForGroupsPage.coursesForGroup).click();
        new Select(driver.findElement(By.id("group"))).selectByIndex(1);
    }

    @Test
    public void findCourses() {
        selectGroup();
        driver.findElement(coursesForGroupsPage.searchField).sendKeys("Бази даних");
        String result = driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[2]/div[1]/div/studied-courses/div/div/table/tbody/tr[1]/td[2]")).getText();
        assertThat("Бази даних", containsString(result));
    }

    @Test
    public void setCourses() {
        findCourses();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[2]/div[1]/div/studied-courses/div/div/table/tbody/tr/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[5]/div/div[1]/button[1]")).click();
    }

    @Test
    public void setCoursesIfExist() {
        findCourses();
        driver.findElement(coursesForGroupsPage.selectFirstCourse).click();
        driver.findElement(coursesForGroupsPage.assignCourse).click();
        String expected = driver.findElement(By.className("sn-title.ng-tns-c9-2.ng-star-inserted")).getText();
        assertThat("Помилка", containsString(expected));
        //я не можу знайти елемент який виводить повідомлення про помилку
    }

    @Test
    public void removeCoursesFromAGroup() {
        selectGroup();
        driver.findElement(coursesForGroupsPage.selectFirstCourseInGroup).click();
        driver.findElement(coursesForGroupsPage.deleteBtn).click();
    }

    @Test
    public void copyItemsFromAnotherGroup() {
        selectGroup();
        driver.findElement(coursesForGroupsPage.copyItems).click();
        driver.findElement(By.xpath("/html/body/modal-container/div/div/copy-courses-dialog/div[2]/div/div/ul/li[1]")).click();
    }

    @Test
    public void academicDifference() {
        selectGroup();
        driver.findElement(coursesForGroupsPage.selectFirstCourseInGroup).click();
        driver.findElement(By.cssSelector("#app > div > courses-for-groups > div > div.course-for-group-table > added-courses > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > input")).click();
        driver.findElement(coursesForGroupsPage.save).click();
        driver.findElement(coursesForGroupsPage.displayedAD).click();
        WebElement elems = driver.findElement(By.cssSelector("#app > div > courses-for-groups > div > div.course-for-group-table > added-courses > div > div > table > tbody > tr:nth-child(1) > td:nth-child(7) > input"));
        if (elems.isSelected()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
        driver.quit();
    }

    @Test
    public void cancelEdit() {
        selectGroup();
        driver.findElement(coursesForGroupsPage.copyItems).click();
        driver.findElement(coursesForGroupsPage.cancelEdit).click();
    }

    @Test
    public void selectTeacherForCourses() throws InterruptedException {
        selectGroup();
        driver.findElement(coursesForGroupsPage.selectTeacher).click();
        String actual = driver.findElement(By.xpath("/html/body/modal-container/div/div/teacher-dialog/div[2]/ul/li[1]")).getText();
        actual = actual.substring(0, actual.indexOf(" "));
        driver.findElement(By.xpath("/html/body/modal-container/div/div/teacher-dialog/div[2]/ul/li[1]")).click();
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[6]/button")).getText();
        expected = expected.substring(0, expected.indexOf(" "));
        assertThat(actual, containsString(expected));
        Thread.sleep(1000);
        driver.findElement(coursesForGroupsPage.save).click();
    }

    @Test
    public void editCourse() {
        selectGroup();
        driver.findElement(coursesForGroupsPage.editCourse).click();
        new Select(driver.findElement(By.id("knowledgeControl"))).selectByIndex(5);
        driver.findElement(By.xpath("/html/body/modal-container/div/div/edit-dialog/div[2]/div/div/button[1]")).click();
        String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[3]")).getText();
        assertThat("державний іспит", containsString(actual));
    }
}