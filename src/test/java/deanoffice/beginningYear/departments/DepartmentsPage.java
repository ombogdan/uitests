package deanoffice.beginningYear.departments;

import org.openqa.selenium.By;

class DepartmentsPage {
    By startYear = By.xpath("//*[@id=\"nav-year-start\"]");
    By departments = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[7]");
    By inactiveDepartments = By.xpath("//*[@id=\"active\"]");
    By nameDepartment = By.xpath("//*[@id=\"name\"]");
    By abbreviationDepartment = By.xpath("//*[@id=\"abbr\"]");
    By createDepartmentBtn = By.xpath("//*[@id=\"app\"]/div/app-department/add-department/modal-wrapper/div/div/div/department-form/form/div[2]/button[1]");
    By findIcon = By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span");
    By searchField = By.xpath("//*[@id=\"filterText\"]");
    By firstDepartmentName = By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[1]/span/span[2]");
    By selectFirstDepartment = By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[1]/span/span[2]");
    By deleteDepartmentBtn = By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/div/div/button[1]");
    By deleteThisDepartmentBtn = By.xpath("//*[@id=\"app\"]/div/app-department/delete-department/modal-wrapper/div/div/div/form/div[2]/button[1]");
    By editDepartmentBtn = By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/div/div/button[2]");
    By addNewDepartmentBtn = By.xpath("//*[@id=\"app\"]/div/app-department/div/div/div/div/div/div/button[3]");
}
