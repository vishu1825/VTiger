package com.qa.pages;

import com.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

       private  By text_Box=By.xpath("//input[@name='user_name']");
       private  By pwd_box=By.xpath("//input[@name='user_password']");
       private  By login_btn=By.id("submitButton");


       public HomePage loginToApp(String username , String password) throws Exception {
           sendKeys(text_Box , username , WaitStrategy.PRESENCE ,"User name");
           sendKeys(pwd_box ,password , WaitStrategy.PRESENCE , "Password" );
           click(login_btn , WaitStrategy.NONE ,"Login button");
           return new HomePage();

       }



}
