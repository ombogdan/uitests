package deanoffice;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class CoursesForGroups extends Login {

    @Test
    public void SelectGroup() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.CoursesForGroups();
        new Select(driver.findElement(By.id("group"))).selectByIndex(1);

    }

    @Test
    public void FindCourses() throws InterruptedException {
        SelectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[1]/div/div/div[4]/input")).sendKeys("Основи екології");

    }

    @Test
    public void SearchCourse() throws InterruptedException {
        SelectGroup();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[1]/div/div/div[4]/input")).sendKeys("Англійська мова");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[2]/div[1]/div/studied-courses/div/div/table/tbody/tr/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[1]")).click();

    }

}