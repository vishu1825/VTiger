import com.qa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public final class NewTest extends BaseTest {

    private NewTest(){

    }

    @Test
    public void newTest() {

        DriverManager.getDriver().findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
        DriverManager.getDriver().findElement(By.xpath("//input[@name='user_password']")).sendKeys("manager");
        DriverManager.getDriver().findElement(By.id("submitButton")).click();

    }
}
