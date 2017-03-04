package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Login {
	private String userName;
	private String password;
	public static WebDriver driver;
	public static WebDriverWait wait;
	private WebElement psw;
	private WebElement usr;
	
	public boolean isLogin = false;
		public Login(){	
			driver = new ChromeDriver();
			//driver = new FirefoxDriver();
			wait = new WebDriverWait(driver,4000);
		}
		
		public Login(String uname,String pass){
			this.userName = uname;
			this.password = pass;
			driver = new FirefoxDriver();
		}
		
		public boolean isLoginSuccessfull(String uname, String pass){
			
			try {
				Screen screen = new Screen(); // Screen object
				wait = new WebDriverWait(driver,4000);
				driver.get("http://www.gmail.com/");
				wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("Email"))));
				usr= driver.findElement(By.id("Email"));
				usr.sendKeys(uname);
				driver.findElement(By.id("next")).click();
				Pattern pattern =  new Pattern("C:/Users/tr1a5141/Desktop/skuli/works.sikuli/4Staysignedi.png");
		    	screen.click(pattern);
				psw= driver.findElement(By.id("Passwd"));
				psw.sendKeys(pass);
				driver.findElement(By.id("signIn")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated((By.id(":3i"))));
				Pattern loginSign = new Pattern("C:/Users/tr1a5141/Desktop/skuli/works.sikuli/loginSign.png");
				
				if(loginSign.isValid())
					isLogin = true; 
					System.out.println("test pass");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("test failed");
				e.printStackTrace();
			}
			return isLogin;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public void closeBrowse(){
			//driver.quit();
			driver.close();
			
		}
}
