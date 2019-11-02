package deanoffice.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoTo {
    private ChromeDriver driver;


    public GoTo(ChromeDriver driver) {
        this.driver = driver;
    }

    public void groups() {
        driver.findElement(By.xpath("//*[@id=\"nav-year-start\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[3]")).click();
    }    public void active() {
        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/div/div/ul/li[7]/a/tab-heading")).click();
    }

    public void edit() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/div/div/div/button[2]")).click();
    }



    public void selectFirstGroup() {
        driver.findElement(By.className("ag-selection-checkbox")).click();
    }

    public void selectFirstTeacher() {
        driver.findElement(By.className("ag-icon ag-icon-checkbox-unchecked")).click();
    }

    public void inactiveGroups() {
        driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-1\"]/label/div")).click();

    }
    public void specializations() {
        driver.findElement(By.xpath("//*[@id=\"nav-year-start\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[2]")).click();
    }
    public void editspecializations() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/specialization/div/div/div/div/div[2]/button[2]")).click();
    }

    public void subjects() {
        driver.findElement(By.xpath("//*[@id=\"nav-year-start\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[4]")).click();
    }

    public void coursesForGroups() {
        driver.findElement(By.xpath("//*[@id=\"nav-year-start\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[5]")).click();
    }

    public void teachers() {
        driver.findElement(By.xpath("//*[@id=\"nav-year-start\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[6]")).click();
    }

}
