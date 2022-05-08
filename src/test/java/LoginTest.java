import com.qa.annotations.FrameworkAnnotation;
import com.qa.enums.CategoryType;
import com.qa.enums.pageenums.Login;
import com.qa.pages.LoginPage;
import com.qa.utils.ExcelUtils;
import org.testng.annotations.Test;

import java.util.Map;

public final class LoginTest extends BaseTest {

    private LoginTest(){

    }
    Map<String, String> map;
    @FrameworkAnnotation(category={CategoryType.SMOKE},authors = {"Vishwajeet"})
    @Test()
    public void loginTest() throws Exception {
         map = ExcelUtils.readXlsPageObjects("Select * from Sheet1 where Serial=2");
         new LoginPage().loginToApp(map.get(Login.USERNAME.property) ,map.get(Login.PASSWORD.property));

    }

}