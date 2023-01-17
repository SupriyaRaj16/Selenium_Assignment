package ServiceNowTC_Pages;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage02 {
	
WebDriver driver;
	
    public LoginPage02(WebDriver rdriver) 
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
			
	@FindBy(xpath  = "//div[contains(@class,'outputmsg outputmsg_error')]")
	WebElement al;
	
		
	public void verifyAppTitle() {
		
		Assert.assertEquals(driver.getTitle(), "ServiceNow");
		System.out.println("\n"+"Title Verification Test Passed\n"+ driver.getTitle());
	}		

	public void switchFrame() {
		driver.switchTo().frame(myFrame);
	}
	
	public void enterEmail(String email) throws Exception {

		Thread.sleep(2000);
		txt_Email.clear();
		txt_Email.sendKeys(email);

	}

	
	public void clickLoginButton() throws Exception {

		Actions act = new Actions(driver);
		act.moveToElement(btn_Login).perform();
		Thread.sleep(2000);
		btn_Login.click();
	}
	

	public void getAlertText(String msgtxt) throws Exception {

		Thread.sleep(3000);
		String actualAlertText = al.getText();
		System.out.println(actualAlertText);
		Assert.assertTrue(actualAlertText.contains(msgtxt));
		System.out.println("ALERT BOX TEXT PRESENT");
	}


}
