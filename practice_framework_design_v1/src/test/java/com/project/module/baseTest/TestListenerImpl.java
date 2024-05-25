package com.project.module.baseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestListenerImpl implements ITestListener {
    GenerateExtentReport generateExtentReport=new GenerateExtentReport();
    protected ExtentReports extentReports;
    protected ExtentTest extentTestReporter;
    public void onTestStart(ITestResult result, Method testMethod) {
        Test test= testMethod.getAnnotation(Test.class);
        extentReports=generateExtentReport.getExtentReports();
        extentTestReporter=extentReports.createTest("Test case:-"+test.testName()+"<br>Description:-"+test.description());
        ReporterFactory.getReporterFactoryInstance().setExtentTest(extentTestReporter);
    }

    public void onTestSuccess(ITestResult result) {
        extentTestReporter=ReporterFactory.getReporterFactoryInstance().getExtentTest();
        extentTestReporter.pass("<b>Function Name:- "+result.getName()+"</b>");
    }

    public void onTestFailure(ITestResult result) {
        extentTestReporter=ReporterFactory.getReporterFactoryInstance().getExtentTest();
        extentTestReporter.log(Status.FAIL,"<b>Function Name :"+result.getName()+"</b>");
        extentTestReporter.fail(result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        extentTestReporter=ReporterFactory.getReporterFactoryInstance().getExtentTest();
        extentTestReporter.skip("<b>Function Name:- "+result.getName()+"</b>");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        generateExtentReport.createExtentSparkReport();
    }

    public void onFinish(ITestContext context) {
        extentReports=generateExtentReport.getExtentReports();
        extentReports.flush();
    }
}
