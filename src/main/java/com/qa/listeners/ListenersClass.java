package com.qa.listeners;

import com.qa.annotations.FrameworkAnnotation;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentReport;
import org.testng.*;

public class ListenersClass implements ITestListener , ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();

    }
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).authors());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());


    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed ");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed " ,true);
            ExtentLogger.fail(result.getThrowable().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped " ,true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /* Currently ,this method not used in our framework */
    }

    @Override
    public void onStart(ITestContext context) {
        /* Currently , this method not used in our framework */
    }

    @Override
    public void onFinish(ITestContext context) {
        /* Currently ,this method not used in our framework */
    }

}
