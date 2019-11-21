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
    By birthDay = By.xpath("/html/body/modal-container/div/div/app-students-columns/div[2]/div/div[7]/div/label");
    By surname = By.xpath("/html/body/modal-container/div/div/app-students-columns/div[2]/div/div[1]/div");
    By patronymic = By.xpath("/html/body/modal-container/div/div/app-students-columns/div[2]/div/div[3]/div");
    By groupInThePage = By.xpath("//*[@id=\"app\"]/div/app-students/div/div[2]/div[1]/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div[2]/div/span[1]");
    By name = By.xpath("/html/body/modal-container/div/div/app-students-columns/div[2]/div/div[2]/div");
    By okBtn = By.xpath("/html/body/modal-container/div/div/app-students-columns/div[3]/button[1]");
    By addNewStudentBtn = By.xpath("//*[@id=\"app\"]/div/app-students/div/div[2]/div[2]/button[5]");
    By enrollNewStudent = By.xpath("//*[@id=\"app\"]/div/app-students/app-add-student/div/div/div/div[2]/tabset/ul/li[2]/a/span");
    By surnameNewStudent = By.xpath("//*[@id=\"surname\"]");
    By nameNewStudent = By.xpath("//*[@id=\"name\"]");
    By patronymicNewStudent = By.xpath("//*[@id=\"patronimic\"]");
    By maleNewStudent = By.xpath("//*[@id=\"sex1\"]");
    By formOfTrainingNewStudent = By.xpath("//*[@id=\"payment1\"]");
    By birthDateNewStudent = By.xpath("//*[@id=\"birthDate\"]");
    By groupNameNewStudent = By.xpath("//*[@id=\"group\"]");
    By enrolThisStudent = By.xpath("//*[@id=\"app\"]/div/app-students/app-add-student/div/div/div/div[3]/button[1]");
    By errorAboutBlankFields = By.xpath("//*[@id=\"app\"]/div/app-students/app-add-student/div/div/div/div[2]/tabset/div/tab[2]/form/div[2]/div[2]/div[2]/app-validation-errors/div/div");
    By informationAboutStudentsBtn = By.xpath("//*[@id=\"app\"]/div/app-students/div/div[1]/div/div/div/div/button[1]");
    By editFieldEngSurnameStudent = By.xpath("//*[@id=\"surnameEng\"]");
    By saveEditInformationBtn = By.xpath("//*[@id=\"app\"]/div/app-students/student-personal-info-modal/modal-wrapper/div/div/div/app-student-personal-info/div[2]/button[1]");
    By pibNewStudent = By.xpath("//*[@id=\"typeahead\"]");

}