package com.project.module.implementation;

import com.aventstack.extentreports.ExtentTest;
import com.project.module.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginImpl  {
    WebDriver driver;
    @FindBy(id="loginusername")
    private WebElement loginUserName;
    @FindBy(id="loginpassword")
    private WebElement loginUserpassword;
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Log in')]")
            private WebElement loginText;

    PropertyReader propertyReader = new PropertyReader();

    public LoginImpl(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void login()
    {
        loginText.click();
        loginUserName.sendKeys(propertyReader.getProperty("login"));
        loginUserpassword.sendKeys(propertyReader.getProperty("password"));
        loginButton.click();
    }

}
