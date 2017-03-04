package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.Generator;
import common.Page;

public class LoginTest {
	
	public static WebDriver driver = new FirefoxDriver();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		failedLogin();
		successfulLogin();
	}
	
	@Test
	public static void failedLogin(){
		Page.driver = driver;
		Page.goToGmail();
		Page.enterUsername(Generator.GenerateEMail());
		Page.clickNextButton();
		Page.enterPassword(Generator.GenerateWrongPassword());
		Page.clickSignInButton();
		Assert.assertEquals(true, Page.isSignedIn(), "Login Test Result");
	}
	@Test
	public static void successfulLogin(){
		Page.driver = driver;
		Page.goToGmail();
		Page.enterUsername(Generator.GenerateEMail());
		Page.clickNextButton();
		Page.enterPassword(Generator.GeneratePassword());
		Page.clickSignInButton();
		Assert.assertEquals(true, Page.isSignedIn(), "Login Test Result");
	}

}
