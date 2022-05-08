package com.qa.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.drivers.DriverManager;
import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {

    private ExtentLogger(){

    }

    public static void pass (String message){
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail (String message){
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip (String message){
        ExtentManager.getExtentTest().skip(message);
    }

    public static void skip (String message ,boolean isScreenshotRequired) throws Exception {
        if(PropertyUtils.getValue(String.valueOf(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS)).equalsIgnoreCase("yes") &&
                isScreenshotRequired){
            ExtentManager.getExtentTest().skip(message , MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

        }
        else {
            skip(message);
        }

    }

    public static void fail (String message ,boolean isScreenshotRequired) throws Exception {
        if(PropertyUtils.getValue(String.valueOf(ConfigProperties.FAILEDSTEPSSCREENSHOTS)).equalsIgnoreCase("yes") &&
                isScreenshotRequired){
            ExtentManager.getExtentTest().fail(message , MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

        }
        else {
            fail(message);
        }

    }

    public static void pass (String message ,boolean isScreenshotRequired) throws Exception {
        if(PropertyUtils.getValue(String.valueOf(ConfigProperties.PASSEDSTEPSSCREENSHOTS)).equalsIgnoreCase("yes") &&
                isScreenshotRequired){
            ExtentManager.getExtentTest().pass(message , MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

        }
       else {
            pass(message);
        }

    }

    public static String getBase64Image(){

        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

    }
}
