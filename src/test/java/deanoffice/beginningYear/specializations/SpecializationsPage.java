package deanoffice.beginningYear.specializations;

import org.openqa.selenium.By;

public class SpecializationsPage {
    By startYear = By.xpath("//*[@id=\"nav-year-start\"]");
    By specializations = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[2]");
    By name = By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div");
    By searchIcon = By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[3]/div[2]/span/span");
    By searchField = By.id("filterText");
    By firstNameSpecialization= By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]");
    By addNewSpecializationBtn= By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/div/div[2]/button[3]");
    By nameSpecialization = By.xpath("//*[@id=\"name\"]");
    By specialityId = By.id("specialityId");
    By degreeId = By.id("degreeId");
    By departmentId = By.id("departmentId");
    By selectFirstSpecialization = By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]");
    By deleteSpecializationBtn = By.cssSelector("#app>div>specialization>div>div>div>div>div:nth-child(2)>button.btn.btn-danger");
    By deleteThisSpecializationBtn = By.xpath("//*[@id=\"app\"]/div/specialization/delete-specialization/modal-wrapper/div/div/div/div[3]/button[1]");
}
