package ServiceNowTC_Pages;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage01 {
	
WebDriver driver;
	
    public LoginPage01(WebDriver rdriver) 
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
	
	@FindBy(xpath  = "//label[text()='User name']")
	WebElement uname_label;
	
	@FindBy(xpath  = "//label[text()='Password']")
	WebElement pwd_label;
	

		
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

		Thread.sleep(2000);
		System.out.println("Username Label Check: ");
		elementIsDisplayed(uname_label);
		txt_Email.clear();
		txt_Email.sendKeys(email);
		System.out.println("Entering Username Test Passed\n");

	}

	
	public void enterPass(String password) throws Exception {
		
		Thread.sleep(2000);
		
		System.out.println("Password Label Check: ");
		elementIsDisplayed(pwd_label);
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
//		Thread.sleep(4000);
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


}
