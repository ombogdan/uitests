package deanoffice.beginningYear;
import deanoffice.settings.GoTo;
import deanoffice.settings.Login;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Groups extends Login {

    @Test
    public void inactiveGroups() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.groups();
        driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-1\"]/label/div")).click();
        String actual = driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-1\"]/label/span\n")).getText();
        assertThat(actual, containsString("Неактивні групи"));


    }
    @Test
    public void deleteGroupsWithoutStudents() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.groups();
        String actual = driver.findElement(By.className("ag-cell-value")).getText();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]")).click();
        //Вибрав групу натиснувши checkbox
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/div/div/div/button[1]")).click();
        //Натиснув Delete
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/delete-group/modal-wrapper/div/div/div/form/div[2]/button[1]")).click();
        //Натиснув Delete
        Thread.sleep(2000);
        goTo.inactiveGroups();
        //натиcнув на слайдер
        Thread.sleep(2000);
        String expected= driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        //Знайшов назву групи в першій колонці
        Thread.sleep(2000);
        assertThat(actual, containsString(expected));
        //Робить через раз
    }

    @Test
    public void deleteSomeGroups() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.teachers();
        String actual = driver.findElement(By.className("ag-cell-value")).getText();
        //Записав значення першої групи
        goTo.selectFirstTeacher();
        //Вибрав першу групу натиснувши checkbox
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-teachers/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[2]/div[1]/span/span[1]/span[2]")).click();
        //Вибрав другу групу натиснувши checkbox
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/div/div/div/button[1]")).click();
        //Натиснув Delete
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/delete-group/modal-wrapper/div/div/div/form/div[2]/button[1]")).click();
        //Натиснув Delete
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-1\"]/label/div")).click();
        //натиcнув на слайдер
        Thread.sleep(2000);
        String expected= driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        //Знайшов назву групи в першій колонці
        Thread.sleep(2000);
        assertThat(actual, containsString(expected));
        //Порівнюю результати....Робить через раз
    }

    @Test
    public void deleteGroupsWithStudents() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.groups();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span")).click();
        //Натиснув на три паралельні полоски
        WebElement search = driver.findElement(By.id("filterText"));
        search.sendKeys("АКІТ-159");
        //Ввів значення для пошуку
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[1]/span[2]")).click();
        //Вибрав групу натиснувши checkbox
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/div/div/div/button[1]")).click();
        //Натиснув Delete
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/delete-group/modal-wrapper/div/div/div/form/div[2]/button[1]")).click();
        //Натиснув Delete
        String actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/simple-notifications/div/simple-notification/div/div/div[1]")).getText();
        assertThat(actual, containsString("Помилка"));
        //Порівнюю чи виводиться повідомлення про помилку
    }


    @Test
    public void addNewGroups() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.groups();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/div/div/div/button[3]")).click();
        WebElement reason = driver.findElementByXPath("//*[@id=\"name\"]");
        reason.sendKeys("autotest");
        js.executeScript("window.scrollBy(0,-300)");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/add-group/modal-wrapper/div/div/div/group-form/form/div[2]/button[1]")).click();
        Thread.sleep(2000);
        String expected= driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[2]/div[1]/span/span[2]")).getText();
        //Записав значння створеної групи
         assertThat("autotest", containsString(expected));

    }

    @Test
    public void restoreOneGroup() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.groups();
        goTo.inactiveGroups();
        Thread.sleep(2000);
        String actual = driver.findElement(By.className("ag-cell-value")).getText();
        //Записав значення першої групи
        goTo.selectFirstGroup();
        //Вибрав першу групу натиснувши checkbox
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/div/div/div/button")).click();
        //Натиснув Відновити
        driver.findElement(By.cssSelector("#app > div > app-group > recovery-group > modal-wrapper > div > div > div > form > div.modal-footer > button.btn.btn-success")).click();
        //Натиснув Відновити
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"mat-slide-toggle-1\"]/label/div")).click();
        //натиcнув на слайдер
        Thread.sleep(2000);
        String expected= driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/span/span[2]")).getText();
        //Знайшов назву групи в першій колонці
        Thread.sleep(2000);
        assertThat(actual, containsString(expected));
        //Порівнюю результати....Потрібно шоб була підготовлена баша данних
    }

    @Test
    public void sortField() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.groups();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/span[1]")).click();
    }

    @Test
    public void searchByOneField() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.groups();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div[2]/span")).click();
        //Натиснув на три паралельні полоски
        WebElement search = driver.findElement(By.id("filterText"));
        search.sendKeys("БІУ-148");
        //Ввів значення для пошуку
        Thread.sleep(2000);
        String expected= driver.findElement(By.xpath("//*[@id=\"app\"]/div/app-group/div/div/div/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div/div[1]/span/span[2]")).getText();
        //Знайшов назву групи
        assertThat("БІУ-148", containsString(expected));

    }
}
