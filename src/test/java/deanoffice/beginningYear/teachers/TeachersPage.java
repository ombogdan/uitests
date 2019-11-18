package deanoffice.beginningYear.teachers;

import org.openqa.selenium.By;

class TeachersPage {
    By startYear = By.xpath("//*[@id=\"nav-year-start\"]");
    By teachers = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[6]");
    By inactiveTeachers = By.xpath("//*[@id=\"active\"]");
    By getFirstNameTeacher = By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]");
    By selectFirstTeacher = By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]");
    By selectSecondTeacher = By.cssSelector("#app > div > app-teachers > div > div > div > div > ag-grid-angular > div > div.ag-root-wrapper-body.ag-layout-normal > div > div.ag-body-viewport.ag-layout-normal.ag-row-animation > div.ag-center-cols-clipper > div > div > div:nth-child(2) > div:nth-child(1) > span > span.ag-selection-checkbox > span.ag-icon.ag-icon-checkbox-unchecked");
    By deleteTeacherBtn = By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/div/div/button[1]");
    By deleteThisTeacherBtn = By.xpath("//*[@id=\"app\"]/div/app-teachers/delete-teacher/modal-wrapper/div/div/div/div[3]/button[1]");
    By addNewTeacherBtn = By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/div/div/button[3]");
    By createTeacherBtn = By.xpath("//*[@id=\"app\"]/div/app-teachers/add-teacher/modal-wrapper/div/div/div/div[3]/button[1]");
    By searchIcon = By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span");
    By searchField = By.xpath("//*[@id=\"filterText\"]");
    By surnameTeacher = By.xpath("//*[@id=\"surname\"]");
    By nameTeacher = By.xpath("//*[@id=\"name\"]");
    By patronimicTeacher = By.xpath("//*[@id=\"patronimic\"]");
    By positionTeacher = By.id("position");
    By departmentTeacher = By.id("department");
    By maleTeacher = By.xpath("//*[@id=\"sexMALE\"]");
    By name = By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/span[1]");
}
