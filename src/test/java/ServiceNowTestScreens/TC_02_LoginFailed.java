package ServiceNowTestScreens;

import org.testng.annotations.Test;

public class TC_02_LoginFailed extends BaseTestClass
{
	@Test(priority = 1)
	public void verifyAppLicationTitle() {

		lp2.verifyAppTitle();
	}

	@Test(priority = 2)
	public void TC_02_loginNegative() throws Exception {

		String U = conf.getAdminUser();
		lp2.switchFrame();
		lp2.clickLoginButton();
		// check error msg contains "Invalid input in user name!"
		lp2.getAlertText("Invalid input in user name!");
		lp2.enterEmail(U);
		lp2.clickLoginButton();
		// check error msg contains "User name or password invalid"
		lp2.getAlertText("User name or password invalid");
	}

}
