package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerByEmail {

	WebDriver ldriver;
	WaitHelper wh;
	public SearchCustomerByEmail(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

		wh= new WaitHelper(ldriver);
	}

	@FindBy(xpath="//input[@id='SearchEmail']")
	@CacheLookup
	WebElement txtEmail;


	@FindBy(xpath="//button[@id='search-customers']")
	@CacheLookup
	WebElement btnSearch;

	@FindBy(xpath="//input[@id='SearchFirstName']")
	@CacheLookup
	WebElement txtFirstname;

	@FindBy(xpath="//input[@id='SearchLastName']")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(xpath="//select[@id='SearchMonthOfBirth']")
	@CacheLookup
	WebElement drpMonth;

	@FindBy(xpath="//select[@id='SearchDayOfBirth']")
	@CacheLookup
	WebElement drpDay;

	@FindBy(xpath="//input[@id='SearchCompany']")
	@CacheLookup
	WebElement txtCompany;

	@FindBy(xpath="//input[@id='SearchIpAddress']")
	@CacheLookup
	WebElement txtIPaddress;

	@FindBy(xpath="//div[@role='listbox']")
	@CacheLookup
	WebElement listItemCustomerRoles;


	@FindBy(xpath="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;

	@FindBy (xpath="//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;

	@FindBy(xpath="//tbody/tr[1]/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	@FindBy(xpath="//td[normalize-space()='victoria_victoria@nopCommerce.com']")
	@CacheLookup
	WebElement value;


	public void setEmail(String email)
	{
		wh.WaitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void clickSearch()
	{
		btnSearch.click();
	}


	public void setFirstname(String fname)
	{
		txtFirstname.clear();
		txtFirstname.sendKeys(fname);
	}

	public void setLastname(String lname)
	{
		txtLastName.clear();
	    txtLastName.sendKeys(lname);
	}
	
	public String getSearchResult()
	{
		String answer=value.getText();
		return answer;
	}

}
