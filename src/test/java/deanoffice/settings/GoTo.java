package deanoffice.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoTo {
    private ChromeDriver driver;


    public GoTo(ChromeDriver driver) {
        this.driver = driver;
    }


    public void selectFirstGroup() {
        driver.findElement(By.className("ag-selection-checkbox")).click();
    }

    public void inactiveGroups() {
        driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-1\"]/label/div")).click();

    }
    public void specializations() {
        driver.findElement(By.xpath("//*[@id=\"nav-year-start\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[2]")).click();
    }

    public void teachers() {
        driver.findElement(By.xpath("//*[@id=\"nav-year-start\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[6]")).click();
    }

}
