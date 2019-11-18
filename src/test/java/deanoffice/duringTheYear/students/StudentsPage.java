package deanoffice.duringTheYear.students;

import org.openqa.selenium.By;

class StudentsPage {
    By duringTheYear = By.xpath("//*[@id=\"nav-year-middle\"]");
    By students = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[2]/div/a[1]");
    By searchIcon = By.xpath("//*[@id=\"app\"]/div/app-students/div/div[2]/div[1]/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span");
    By searchField = By.xpath("//*[@id=\"filterText\"]");
    By getFirstNameStudent = By.xpath("//*[@id=\"app\"]/div/app-students/div/div[2]/div[1]/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]");
    By searchLabel = By.xpath("//*[@id=\"search\"]");
    By searchBtn = By.xpath("//*[@id=\"app\"]/div/app-students/div/div[1]/div/div/app-students-search/form/button");
    By selectStudent = By.xpath("//*[@id=\"app\"]/div/app-students/div/div[2]/div[1]/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]");
    By selectColumnsBtn = By.xpath("//*[@id=\"app\"]/div/app-students/div/div[2]/div[2]/button[4]");
    By birthdayDay = By.xpath("/html/body/modal-container/div/div/app-students-columns/div[2]/div/div[7]/div/label");
    By creditBookNumber = By.xpath("/html/body/modal-container/div/div/app-students-columns/div[2]/div/div[13]/div");
    By okBtn= By.xpath("/html/body/modal-container/div/div/app-students-columns/div[3]/button[1]");

}
