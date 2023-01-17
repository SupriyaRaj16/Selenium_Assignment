package CompTestScreen;

import org.testng.annotations.Test;

public class TC_01_AddComp extends BaseClass
{
	@Test(priority = 1)
	public void verifyAppLicationTitle() {
		// Get title 
		ac.verifyAppTitle();
	}

	@Test(priority = 2)
	public void CheckAddCompElements() throws Exception {
		
		ac.CheckElements();
	}

	@Test(priority = 3)
	public void AddNewComp() throws Exception {
		
		String T = conf.getSearchtext();
		ac.AddNewComputer(T);
	}
}
