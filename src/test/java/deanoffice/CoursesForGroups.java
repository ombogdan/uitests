package deanoffice;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class CoursesForGroups extends Login {

    @Test
    public void selectGroup() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.CoursesForGroups();
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
    }

    @Test
    public void setCoursesIfExist() throws InterruptedException {
        findCourses();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[2]/div[1]/div/studied-courses/div/div/table/tbody/tr[1]/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[1]")).click();

        Thread.sleep(100);
        String expected = driver.findElement(By.xpath("/simple-notification/div/div/div[2]")).getText();
        assertThat("Помилка", containsString(expected));

    }

    @Test
    public void searchCourse() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[1]/div/div/div[4]/input")).sendKeys("Англійська мова");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[2]/div[1]/div/studied-courses/div/div/table/tbody/tr/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[1]")).click();
    }

    @Test
    public void removeAnCoursesFromAGroup() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[2]")).click();
    }

    @Test
    public void copyItemsFromAnotherGroup() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[3]")).click();
        driver.findElement(By.xpath("/html/body/modal-container/div/div/copy-courses-dialog/div[2]/div/div/ul/li[1]")).click();
    }

    @Test
    public void cancelEdit() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[3]")).click();
        driver.findElement(By.xpath("/html/body/modal-container/div/div/copy-courses-dialog/div[2]/div/div/ul/li[1]")).click();
    }

    @Test
    public void selectTeacheeForCourses() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[6]/button")).click();
        String actual = driver.findElement(By.xpath("/html/body/modal-container/div/div/teacher-dialog/div[2]/ul/li[1]")).getText();
        driver.findElement(By.xpath("/html/body/modal-container/div/div/teacher-dialog/div[2]/ul/li[1]")).click();
        String expected = driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[6]/button")).getText();
        assertThat(actual, containsString(expected));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[5]/div/div[1]/button[1]")).click();

    }

//    @Test
//    public void editData() throws InterruptedException {
//        selectGroup();
//        driver.findElement(By.xpath()).SendKeys(yourDateTime.ToString("ddd, dd.MM.yyyy",CultureInfo.CreateSpecificCulture("en-US")));
//    }

    @Test
    public void editCourse() throws InterruptedException {
        selectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[9]/button")).click();
        new Select(driver.findElement(By.id("knowledgeControl"))).selectByIndex(5);
        driver.findElement(By.xpath("/html/body/modal-container/div/div/edit-dialog/div[2]/div/div/button[1]")).click();
        String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[3]")).getText();
        assertThat("державний іспит", containsString(actual));
    }

}