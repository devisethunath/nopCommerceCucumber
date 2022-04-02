package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerByEmail;
import pageObjects.addCustomerPage;

public class LoginStepDefinitions extends BaseClass {
	
	@Before
	//@Parameter("browser")
	public void setup()
	{
		//logger=Logger.
		//PropertyConfigurator.configure("C:\\Users\\sethu\\eclipse-workspace\\nopCommerce\\target\\classes\\Log4jproperties");//put this log4j properties file under target folder in classes
		String br=readconfig.getBrowser();
		
		if (br.equals("chrome"))
			
		{		//C:\Users\sethu\Downloads\chromedriver_win32 (3)\chromedriver.exe
			
		//System.setProperty("webdriver.chrome.driver","C://Users//sethu//Downloads//chromedriver_win32New//chromedriver.exe");//opens browser
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());//.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver=new ChromeDriver();}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());//.getProperty("user.dir")+"//Drivers/chromedriver.exe");
			driver=new FirefoxDriver();}
		}
		




	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {


		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");//C://Users/sethu/Downloads/chromedriver_win32/chromedriver.exe");
		driver= new ChromeDriver();

		driver.manage().window().maximize();
		lp=new LoginPage(driver);
		se= new SearchCustomerByEmail(driver);
	}

	@When("User opens the URL {string}")
	public void user_opens_the_url(String url ) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3000);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) throws InterruptedException {

		lp.setUsername(username);
		Thread.sleep(3000);
		lp.setPassword(password);
		Thread.sleep(3000);
	}

	@When("click on login button")
	public void click_on_login_button() throws InterruptedException {
		lp.clickLogin();
		Thread.sleep(5000);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		Assert.assertEquals(title, driver.getTitle());
	}

	@When("User clicks on logout button")
	public void user_clicks_on_logout_button() {
		lp.clickLogout();
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}

	//Add new customer



	//	@When("user opens URL {string}")
	//	public void user_opens_url(String string) {
	//	    // Write code here that turns the phrase above into concrete actions
	//	    throw new io.cucumber.java.PendingException();
	//	}
	//
	//	@When("user enter email as {string} and password as {string}")
	//	public void user_enter_email_as_and_password_as(String string, String string2) {
	//	    // Write code here that turns the phrase above into concrete actions
	//	    throw new io.cucumber.java.PendingException();
	//	}

	@Then("user can view Dashbord")
	public void user_can_view_dashbord() throws InterruptedException {

		ap=new addCustomerPage(driver);
		Thread.sleep(3000);

		String title=ap.getPageTitle();
		String act_title="Dashboard / nopCommerce administration";
		Assert.assertEquals(act_title, title);

	}

	@When("User clicks on customers menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {

		ap.clickCustomersMenu();
		Thread.sleep(7000);

	}


	@When("click on customers menu item")
	public void click_on_customers_menu_item() throws InterruptedException {

		ap.clickCustomers_menu_item();
		Thread.sleep(3000);}

	@When("click on add new button")
	public void click_on_add_new_button() throws InterruptedException {

		ap.clickOnAddNew();
		Thread.sleep(3000);

	}

	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
		String newTitle=ap.getPageTitle();
		String actualTitle="Add a new customer / nopCommerce administration";

		Assert.assertEquals(actualTitle, newTitle);
		Thread.sleep(3000);

	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {

		String email1=randomstring()+"@gmail.com";
		ap.setEmail(email1);
		Thread.sleep(3000);
		ap.setPassword("Test123");
		Thread.sleep(3000);
		ap.setFirstName("Devi");
		Thread.sleep(3000);
		ap.setLastName("Sethu");
		Thread.sleep(3000);
		ap.setGender("Male");
		Thread.sleep(3000);
		ap.setDateofBirth("6/1/1999");
		Thread.sleep(3000);
        ap.setCompanyName("infosys");
        Thread.sleep(3000);
        ap.clickTaxExempt();
        Thread.sleep(3000);
        ap.setNewsLetter("Test store 2");
        Thread.sleep(3000);
        ap.setCustomerRoles("Guests");
        Thread.sleep(3000);
        ap.setManageVendor("Vendor 1");
        Thread.sleep(3000);
        ap.clickActive();
        Thread.sleep(3000);
        ap.setAdminComment("Testing");
        Thread.sleep(3000);
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		ap.clickSave();
		Thread.sleep(3000);

	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) throws InterruptedException {
		
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	
	

	}
	
	//Search customer by email
	
	@When("enter customer email")
	public void enter_customer_email() {
		
		se.setEmail("victoria_victoria@nopCommerce.com");
		
	}

	@When("click search button")
	public void click_search_button() {
	   se.clickSearch();
	}

	@Then("user should find email in search table")
	public void user_should_find_email_in_search_table() {
	   String ans= se.getSearchResult();
	   Assert.assertEquals("victoria_victoria@nopCommerce.com",ans);
	}


















}
