package common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Page {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Pattern pattern;
	public static Screen screen;
	
	public Page(){
	}	
	
	public static void goToGmail(){
		String url = "http://www.gmail.com/";
		driver.get(url);
	}
	public static void enterUsername(String username){
		//driver = myDriver;
		wait = new WebDriverWait(driver,4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("Email"))));
		
		driver.findElement(By.id("Email")).sendKeys(username);
		
	}
	public static void clickNextButton(){
		driver.findElement(By.id("next")).click();
	}
	public static void enterPassword(String password){
		pattern =  new Pattern("C:/Users/tr1a5141/Desktop/skuli/works.sikuli/staysignin.png");
		screen = new Screen();
		
    	try {
			screen.click(pattern);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	driver.findElement(By.id("Passwd")).sendKeys(password);;
	}
	
	public static void clickSignInButton(){
		driver.findElement(By.id("signIn")).click();
	}
	public static boolean isSignedIn(){
		pattern = new Pattern("C:/Users/tr1a5141/Desktop/skuli/works.sikuli/compose.png");
		if(pattern.isValid())
			return true;
		else
			return false;
	}

}
