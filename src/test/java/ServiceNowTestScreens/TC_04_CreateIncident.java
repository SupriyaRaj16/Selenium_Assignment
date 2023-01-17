package ServiceNowTestScreens;

import org.testng.annotations.Test;

public class TC_04_CreateIncident extends BaseTestClass
{
	@Test(priority = 1)
	public void login() throws Exception {
		// Check and Enter Username, Password and click Login Button
		String U = conf.getAdminUser();
		String P = conf.getAdminPass();
		ic1.switchFrame();
		ic1.enterEmail(U);
		ic1.enterPass(P);
		ic1.clickLoginButton();
	}
	@Test(priority = 2)
	public void CreateInc() throws Exception {

		ic1.CreateIncident();
		ic1.clickLogoutButton();
	}

}
