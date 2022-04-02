package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addCustomerPage {

	WebDriver ldriver;
	public addCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By lnkCustomers_menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menu_item=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By btnAddNew=By.xpath("//a[normalize-space()='Add new']");
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	By txtFirstname=By.xpath("//input[@id='FirstName']");
	By txtLastname=By.xpath("//input[@id='LastName']");

	By radMale= By.xpath("//input[@id='Gender_Male']");
	By radFemale= By.xpath("//input[@id='Gender_Female']");

	By txtCompanyNmae=By.xpath("//input[@id='Company']");
	By chkTaxExempt=By.xpath("//input[@id='IsTaxExempt']");

	By txtNewsLetter=By.xpath("//body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]");

	By lstItemYourStoreName=By.id("65c10ad8-91e4-4b8c-bd31-8a5b508374c2");
	By lstItemTestStore2=By.xpath("//li[normalize-space()='Test store 2']");
	
	By txtCustomerRoles=By.xpath("//div[10]//div[2]//div[1]//div[1]//div[1]//div[1]");

	By lstItemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstItemForumModerators=By.xpath("//li[normalize-space()='Forum Moderators']");
	By lstItemGuests=By.xpath("//li[normalize-space()='Forum Moderators']");
	By lstItemRegistered=By.xpath("//li[normalize-space()='Registered']");
	By lstItemVendors=By.xpath("//li[contains(text(),'Vendors')]");

	By drpManagevendor=By.xpath("//select[@id='VendorId']");

	By txtDateofbirth=By.xpath("//input[@id='DateOfBirth']");

	By chkActive=By.xpath("//input[@id='Active']");

	By txtComment=By.xpath("//textarea[@id='AdminComment']");

	By btnSave =By.xpath("//button[@name='save']");



	public String getPageTitle()
	{
		return ldriver.getTitle();
	}


	public void clickCustomersMenu()
	{
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickCustomers_menu_item()
	{
		ldriver.findElement(lnkCustomers_menu_item).click();
	}

	public void clickOnAddNew()
	{
		ldriver.findElement(btnAddNew).click();
	}

	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	public void setFirstName(String name)
	{
		ldriver.findElement(txtFirstname).sendKeys(name);
	}
	
	public void setLastName(String lastname)
	{
		ldriver.findElement(txtLastname).sendKeys(lastname);
	}
	
	public void setCompanyName(String companyname)
	{
		ldriver.findElement(txtCompanyNmae).sendKeys(companyname);
	}
	public void setCustomerRoles(String role) throws InterruptedException
	{
		if (!role.equals("Vendors"))
		{
			// ldriver.findElement(By.xpath("//body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]"))
		}
		ldriver.findElement(txtCustomerRoles).click();

		WebElement listitem=null;

		Thread.sleep(3000);

		if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(lstItemAdministrators);
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(lstItemGuests);
		}	
		else if (role.equals("Forum Moderators"))
		{
			listitem=ldriver.findElement(lstItemForumModerators);
		}

		else if (role.equals("Registered"))
		{
			listitem=ldriver.findElement(lstItemRegistered);
		}

		//listitem.click();

		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);

	}

	public void setManageVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpManagevendor));
		drp.selectByVisibleText(value);

	}
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(radMale).click();

		}
		else if (gender.equals("Female"))
		{

			ldriver.findElement(radFemale).click();
		}}


	public void clickTaxExempt()
	{
		ldriver.findElement(chkTaxExempt).click();
	}

	public void clickActive()
	{
		ldriver.findElement(chkActive).click();
	}

	public void setDateofBirth(String dob)
	{
		ldriver.findElement(txtDateofbirth).sendKeys(dob);

	}

	public void setNewsLetter(String input)
	{
		ldriver.findElement(txtNewsLetter).click();

		if (input.equals("Your store name"))
		{
			ldriver.findElement(lstItemYourStoreName).click();
		}
		else if (input.equals("Test store 2"))
		{
			ldriver.findElement(lstItemTestStore2).click();
		}
	}

	public void setAdminComment(String comment)
	{
		ldriver.findElement(txtComment).sendKeys(comment);
	}

	public void clickSave()
	{
		ldriver.findElement(btnSave).click();
	}
}























