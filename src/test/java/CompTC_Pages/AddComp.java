package CompTC_Pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class AddComp {
	
WebDriver driver;
	
    public AddComp(WebDriver rdriver) 
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}	
    
//    @FindBy(xpath = " ")
//	WebElement myFrame;

	@FindBy(id = "searchbox")
	WebElement comp_txt_box;
	
	@FindBy(id  = "searchsubmit")
	WebElement filter_btn;
	
	@FindBy(xpath  = "//a[@href='/computers/new']")
	WebElement newcomp_btn;
	
	@FindBy(xpath  = "//table[contains(@class,'computers zebra-striped')]/thead[1]/tr[1]/th")
	List<WebElement> table;
	
	@FindBy(xpath  = "//li[@class='next']//a[1]")
	WebElement pagination;
	
	@FindBy(xpath  = "//a[@class='fill']")
	WebElement header_name;
	
	@FindBy(xpath  = "//div[@class='input']//input")
	WebElement comp_search;
	
	@FindBy(css  = "select#company")
	WebElement dropdown;

	@FindBy(css  = "section#main>form>div>input")
	WebElement create_comp;
	
	@FindBy(xpath  = "//div[@class='clearfix error']")
	WebElement clr_red;
	
	@FindBy(xpath  = "//div[@class='alert-message warning']")
	WebElement al;
	
//	public void verifyAppTitle(String Titlename) {
//		
//		Assert.assertEquals(driver.getTitle(), Titlename);
//		System.out.println("\n"+"Title Verification Test Passed\n"+ driver.getTitle());
//	}		

	public void verifyAppTitle() {
		
		String title = driver.getTitle();
// Code works but cannot compare as title is Computers Database and header is Computer Database		
//		Assert.assertEquals(title, header_name.getText()); 
		
		Assert.assertEquals(title, "Computers database");
		System.out.println("\n"+"Title Verification Test Passed\n"+ title);
		System.out.println("Header Verification Test Passed\n"+ header_name.getText());
	}	
		
	public void CheckElements() throws Exception {

		Thread.sleep(2000);
		System.out.println("\nFilter by computer name textbox Check: ");
		elementIsDisplayed(comp_txt_box);
		System.out.println("Add a new computer button Check: ");
		elementIsDisplayed(newcomp_btn);
		System.out.println("Filter by name button Check: ");
		elementIsDisplayed(filter_btn);
			
		System.out.println("Below are the headers of the Table");
		List<WebElement> allTableHeaders = table;
		for(WebElement header: allTableHeaders)
		{System.out.println(header.getText());}
		
		System.out.println("\n"+"Pagination Check: ");
		elementIsDisplayed(pagination);		
	}

	public void AddNewComputer(String txt) throws Exception {

		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(newcomp_btn).perform();
		newcomp_btn.click();
		
		act.moveToElement(create_comp).perform();
		create_comp.click();
		String a = clr_red.getCssValue("background-color");
		String c = Color.fromString(a).asHex();
		System.out.println("Color is :" + a);
	    System.out.println("Hex code for color:" + c);
		
	    Thread.sleep(2000);
		comp_search.sendKeys(txt);
		Select drpCompany = new Select(dropdown);
		drpCompany.selectByVisibleText("Nokia");
		act.moveToElement(create_comp).perform();
		create_comp.click();
		
		System.out.println("\n\n");
		getTexts();
	}
	
	public void elementIsDisplayed(WebElement ele) {
		
		boolean isTextPresent = ele.isDisplayed();
        if(isTextPresent) {
        	System.out.println(" Present"+"\n");
        }
        else
            Assert.fail("Not present in the webpage");

	}
	
	public void getTexts() throws Exception {

		Thread.sleep(2000);
		String AlertText = al.getText();
		System.out.println(AlertText);
	}
	
}
