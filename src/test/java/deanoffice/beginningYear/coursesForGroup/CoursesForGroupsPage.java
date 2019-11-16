package deanoffice.beginningYear.coursesForGroup;

import org.openqa.selenium.By;

class CoursesForGroupsPage {
    By startYear = By.xpath("//*[@id=\"nav-year-start\"]");
    By coursesForGroup = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[5]");
    By searchField = By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[1]/div/div/div[4]/input");
    By selectFirstCourse = By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[2]/div[1]/div/studied-courses/div/div/table/tbody/tr[1]/td[1]/input");
    By assignCourse = By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[1]");
    By selectFirstCourseInGroup = By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[1]/input");
    By deleteBtn = By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[2]");
    By copyItems = By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/button[2]");
    By save = By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[5]/div/div[1]/button[1]");
    By displayedAD = By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[3]/div/label/input");
    By cancelEdit = By.xpath("/html/body/modal-container/div/div/copy-courses-dialog/div[2]/div/div/ul/li[1]");
    By selectTeacher = By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[6]/button");
    By editCourse = By.xpath("//*[@id=\"app\"]/div/courses-for-groups/div/div[4]/added-courses/div/div/table/tbody/tr[1]/td[9]/button");
}
