package com.qa.pages;

import com.qa.enums.WaitStrategy;
import com.qa.factories.ExplicitWaitFactory;
import com.qa.reports.ExtentLogger;
import org.openqa.selenium.By;

public class BasePage {

    protected void click(By by , WaitStrategy waitStrategy , String elementName) throws Exception {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
        ExtentLogger.pass(elementName + " is clicked successfully" ,true);
    }


    protected void sendKeys(By by , String value , WaitStrategy waitStrategy , String elementName) throws Exception {
        ExplicitWaitFactory.performExplicitWait(waitStrategy , by).sendKeys(value);
        ExtentLogger.pass(elementName + " field value entered successfully",true);
    }


}
