package utility;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigRead1 {
		
	Properties prop;

	public ConfigRead1() throws Exception {

		FileInputStream fis = new FileInputStream("./test-data/config.properties");
		prop = new Properties();
		prop.load(fis);

	}

	public String getURL1() {

		return prop.getProperty("pageURL1");

	}
	
	public String getURL2() {

		return prop.getProperty("pageURL2");

	}
	public String getAdminUser() {

		return prop.getProperty("adminUserName");

	}
	
	public String getAdminPass() {

		return prop.getProperty("adminPassword");

	}
	
	public String getSearchtext() {

		return prop.getProperty("Searchtxt");

	}
	
}
