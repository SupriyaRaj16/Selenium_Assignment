package CompTestScreen;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import CompTC_Pages.AddComp;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ConfigRead1;

public class BaseClass 
{
	
	WebDriver driver;
	Actions act;
	Alert al;
	ConfigRead1 conf;
	AddComp ac;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		conf = new ConfigRead1();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();   //session get created
		
		ac = new AddComp(driver);
		act = new Actions(driver);
				
		driver.manage().window().maximize();
		System.out.println("\n\n"+"Launching Application:  " + conf.getURL2());
		driver.get(conf.getURL2());
	}
	
	@AfterTest
	public void closingApp() throws Exception {
		
		Thread.sleep(3000);
		driver.close();
		System.out.println("\n"+"chrome browser closed.");
		
	}
}
