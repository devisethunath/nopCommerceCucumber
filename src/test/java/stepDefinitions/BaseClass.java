package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
//import org.junit.platform.commons.logging.Logger;
import org.junit.runners.Parameterized.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.core.logging.Logger;
import io.cucumber.java.Before;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerByEmail;
import pageObjects.addCustomerPage;
import utilities.ReadConfig;

public class BaseClass {


	public WebDriver driver;
	public  LoginPage lp;
	public addCustomerPage ap;
	public SearchCustomerByEmail se;
	public ReadConfig readconfig =new ReadConfig();
	
	public static Logger logger;
	
	
	public static String randomstring()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	

//	@Before
//	//@Parameter("browser")
//	public void setup()
//	{
//		//logger=Logger.
//		//PropertyConfigurator.configure("C:\\Users\\sethu\\eclipse-workspace\\nopCommerce\\target\\classes\\Log4jproperties");//put this log4j properties file under target folder in classes
//		String br=readconfig.getBrowser();
//		
//		if (br.equals("chrome"))
//			
//		{		
//		//System.setProperty("webdriver.chrome.driver","C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");//opens browser
//		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());//.getProperty("user.dir")+"//Drivers/chromedriver.exe");
//		driver=new ChromeDriver();}
//		else if (br.equals("firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());//.getProperty("user.dir")+"//Drivers/chromedriver.exe");
//			driver=new FirefoxDriver();}
//		}
//		

//	@AfterClass
//	public void tearDown()
//	{
//		driver.quit();
//	}
//	
	
}



