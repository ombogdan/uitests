package deanoffice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

class GoTo {
    private ChromeDriver driver;


    GoTo(ChromeDriver driver) {
        this.driver = driver;
    }

    void Groups() {
        driver.findElement(By.xpath("//*[@id=\"nav-year-start\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[3]")).click();
    }

    void Active() {
        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/div/div/ul/li[7]/a/tab-heading")).click();
    }
    void Edit() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/div/div/div/button[2]")).click();
    }
    void SelectFirstGroup() {
        driver.findElement(By.className("ag-selection-checkbox")).click();
    }
    void InactiveGroups() {
        driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-1\"]/label/div")).click();

    }
    void Specializations() {
        driver.findElement(By.xpath("//*[@id=\"nav-year-start\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[2]")).click();
    }
    void editSpecializations() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/div/div[2]/button[2]")).click();
    }
}
