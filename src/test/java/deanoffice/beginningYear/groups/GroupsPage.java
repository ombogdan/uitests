package deanoffice.beginningYear.groups;

import org.openqa.selenium.By;

class GroupsPage {
    By startYear = By.xpath("//*[@id=\"nav-year-start\"]");
    By groups = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[3]");
    By inactiveGroups = By.xpath("//*[@id=\"mat-slide-toggle-1\"]/label/div");
    By newGroupBtn = By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/div/div/div/button[3]");
    By nameGroup = By.xpath("//*[@id=\"name\"]");
    By createGroup = By.xpath("//*[@id=\"app\"]/div/app-group/add-group/modal-wrapper/div/div/div/group-form/form/div[2]/button[1]");
    By searchIcon = By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span/span");
    By searchField = By.xpath("//*[@id=\"filterText\"]");
    By nameFirstGroup = By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[1]/span/span[2]");
    By selectFirstGroup = By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]");
    By deleteGroupBtn = By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/div/div/div/button[1]");
    By deleteThisGroupBtn = By.xpath("//*[@id=\"app\"]/div/app-group/delete-group/modal-wrapper/div/div/div/form/div[2]/button[1]");
    By selectSecondGroup = By.cssSelector("#app > div > app-group > div > div > div > div > ag-grid-angular > div > div.ag-root-wrapper-body.ag-layout-normal > div > div.ag-body-viewport.ag-layout-normal.ag-row-animation > div.ag-center-cols-clipper > div > div > div:nth-child(2) > div:nth-child(1) > span > span.ag-selection-checkbox > span.ag-icon.ag-icon-checkbox-unchecked");
    By errorMessage = By.xpath("//*[@id=\"app\"]/div/app-group/simple-notifications/div/simple-notification/div/div/div[1]");
    By restoreGroupBtn = By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/div/div/div/button");
    By restoreThisGroupBtn = By.xpath("//*[@id=\"app\"]/div/app-group/recovery-group/modal-wrapper/div/div/div/form/div[2]/button[1]");
    By name = By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/span[1]");
}
