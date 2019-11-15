package deanoffice.beginningYear.courses;

import org.openqa.selenium.By;

class CoursesPage {
    By nameCourses = By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/span[1]");
    By startYear = By.xpath("//*[@id=\"nav-year-start\"]");
    By courses = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[4]");
    By iconMenu = By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span");
    By searchInput = By.id("filterText");
    By firstField = By.xpath("//*[@id=\"app\"]/div/app-course/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]");
    By numberOfHours = By.xpath("//*[@id=\"tfHours\"]");
    By buttonSearchCourse = By.xpath("//*[@id=\"app\"]/div/app-course/form/div/div/button");
    By searchInputField = By.xpath("//*[@id=\"app\"]/div/app-course/form/div/div/input");
}
