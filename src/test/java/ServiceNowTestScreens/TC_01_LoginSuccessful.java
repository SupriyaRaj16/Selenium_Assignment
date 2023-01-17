package ServiceNowTestScreens;

import org.testng.annotations.Test;

public class TC_01_LoginSuccessful extends BaseTestClass
{
	@Test(priority = 1)
	public void verifyAppLicationTitle() {
		// Get title before Login
//		lp.verifyAppTitle("ServiceNow");
		lp.verifyAppTitle();
	}

	@Test(priority = 2)
	public void TC_01_loginPositive() throws Exception {
		// Check and Enter Username, Password and click Login Button
		String U = conf.getAdminUser();
		String P = conf.getAdminPass();
		lp.switchFrame();
		lp.enterEmail(U);
		lp.enterPass(P);
		lp.clickLoginButton();
		lp.clickLogoutButton();
	}
	
	@Test(priority = 3)
	public void AfterLogin() {
		//Get title after Login
//		System.out.println("Logged In Successfully");
//		lp.verifyAppTitle("ServiceNow Home Page");
		lp.verifyAppTitle();
	}

}
