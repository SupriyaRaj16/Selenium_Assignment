package ServiceNowTestScreens;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ServiceNowTC_Pages.Incident;
import ServiceNowTC_Pages.LoginPage01;
import ServiceNowTC_Pages.LoginPage02;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ConfigRead1;

public class BaseTestClass 
{
	
	WebDriver driver;
	Actions act;
	Alert al;
	ConfigRead1 conf;
	LoginPage01 lp;
	LoginPage02 lp2;
	Incident ic1;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		conf = new ConfigRead1();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();   //session get created
		
		lp = new LoginPage01(driver);
		lp2 = new LoginPage02(driver);
		ic1 = new Incident(driver);
		act = new Actions(driver);
				
		driver.manage().window().maximize();
		System.out.println("\n\n"+"Launching Application:  " + conf.getURL1());
		driver.get(conf.getURL1());
	}
	
	@AfterTest
	public void closingApp() throws Exception {
		
		Thread.sleep(7000);
		driver.close();
		System.out.println("\n"+"chrome browser closed.");
		
	}
}
