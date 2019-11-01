package deanoffice.beginningYear;
import deanoffice.settings.GoTo;
import deanoffice.settings.Login;
import org.junit.Test;
import org.openqa.selenium.By;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class Teachers extends Login {

    @Test
    public void InactiveTeachers() throws InterruptedException {
        GoTo goTo = new GoTo(driver);
        Login();
        goTo.teachers();
        driver.findElement(By.xpath("//*[@id=\"active\"]")).click();
    }

}
