package ServiceNowTC_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Incident {
	
WebDriver driver;
	
    public Incident(WebDriver rdriver) 
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}	
    
    @FindBy(xpath = "//iframe[contains(@id,'gsft_main')]")
	WebElement myFrame;

	@FindBy(css = "input#user_name")
	WebElement txt_Email;
	
	@FindBy(css = "input#user_password")  
	WebElement txt_Pass;
	
	@FindBy(id  = "sysverb_login")
	WebElement btn_Login;
	
	@FindBy(xpath  = "//a[contains(@href,'logout.do')]")
	WebElement btn_Logout;
	
	@FindBy(xpath  = "//div[contains(@class,'dropdown pull-left')]")
	WebElement dropdown;
	
	 @FindBy(css  = "input#filter")
	 WebElement nav_box;
	 
	 @FindBy(xpath = "//div[text()='Incidents']")
	 WebElement inc;	
		
	 @FindBy(xpath = "//*[@id=\"087800c1c0a80164004e32c8a64a97c9\"]")
	 WebElement create_new;
	 
	 @FindBy(id = "incident.number")
	 WebElement num_txt;	
		
	 @FindBy(id = "lookup.incident.caller_id")
	 WebElement caller;
	 
	 @FindBy(id = "incident.short_description")
	 WebElement desc;
	 
	 @FindBy(id = "sysverb_insert_bottom")
	 WebElement submit;
	 
	 @FindBy(xpath  = "//input[@class='form-control']")
	 WebElement Incident_search;
	 
	 @FindBy(xpath = "//td[text()='abcdf']")
	 WebElement short_desc;
	 
		 
//	public void verifyAppTitle(String Titlename) {
//		
//		Assert.assertEquals(driver.getTitle(), Titlename);
//		System.out.println("\n"+"Title Verification Test Passed\n"+ driver.getTitle());
//	}		

	public void verifyAppTitle() {
		
		Assert.assertEquals(driver.getTitle(), "ServiceNow");
		System.out.println("\n"+"Title Verification Test Passed\n"+ driver.getTitle());
	}	
	
	public void switchFrame() {
		driver.switchTo().frame(myFrame);
	}
	
	public void enterEmail(String email) throws Exception {

		Thread.sleep(1000);
		txt_Email.clear();
		txt_Email.sendKeys(email);
		System.out.println("Entering Username Test Passed\n");

	}

	
	public void enterPass(String password) throws Exception {
		
		Thread.sleep(1000);
		txt_Pass.clear();
		txt_Pass.sendKeys(password);
		System.out.println("Entering Password Test Passed\n");
	}

	
	public void clickLoginButton() throws Exception {

		Actions act = new Actions(driver);
		System.out.println("Login Button Check: ");
		elementIsDisplayed(btn_Login);
		act.moveToElement(btn_Login).perform();
		Thread.sleep(1000);
		btn_Login.click();
	}
	

	public void elementIsDisplayed(WebElement ele) {
		
		boolean isTextPresent = ele.isDisplayed();
        if(isTextPresent) {
        	System.out.println(" Present"+"\n");
        }
        else
            Assert.fail("Not present in the webpage");

	}
	
	public void clickLogoutButton() throws Exception {

		driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		act.moveToElement(dropdown).click(); 
		act.moveToElement(btn_Logout).build().perform();
		btn_Logout.click();
	}
	
	public void CreateIncident() {
		
		Actions act = new Actions(driver);
		
		elementIsDisplayed(nav_box);
//		System.out.println("Navigation Box checked");
//		String i = "incident";
//		nav_box.sendKeys(i);
		
//		Select se = new Select (create_new);
//		se.selectByVisibleText("Create New");
//		act.moveToElement(inc).perform();
		elementIsDisplayed(create_new);
		System.out.println("Create New text checked");
		act.moveToElement(create_new).perform();
		
		// call switch frame
		switchFrame();
		String n = num_txt.getText();
		Assert.assertTrue(n.startsWith("INC"));
		System.out.println("Incident Number Starts with INC");
		
		String caller_name = "Abel Tuter";
		caller.sendKeys(caller_name);
		caller.sendKeys(Keys.ENTER);
		
		String description = "It is an incident";
	    desc.sendKeys(description);
	    
	    act.moveToElement(submit).click();
	    
	    Incident_search.sendKeys(n);
	    Incident_search.sendKeys(Keys.ENTER);
	}


}
