package com.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.constants.FrameworkConstants;
import com.qa.enums.CategoryType;

import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){

    }

    private static ExtentReports extent ;
    public static ExtentTest test ;

    public static void initReports() throws Exception {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Vtiger CRM");
            spark.config().setReportName("Automation Report");
        }

    }

    public static void flushReports(){
        if(Objects.nonNull(extent)){
            extent.flush();
        }
    }

    public static void createTest(String testcasename){
        ExtentManager.setExtentTest(extent.createTest(testcasename));
    }

    public static void addAuthors(String[] authors){
        for(String temp :authors){
            ExtentManager.getExtentTest().assignAuthor(temp);
        }

    }

    public static void addCategories(CategoryType[] categories){
        for(CategoryType temp :categories){
            ExtentManager.getExtentTest().assignCategory(temp.toString());
        }
    }
}
