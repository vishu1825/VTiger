import com.qa.drivers.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    protected BaseTest(){

    }

    @BeforeMethod
    protected void setUp(Method m) throws Exception {
        Driver.initDriver();

    }


    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

}
