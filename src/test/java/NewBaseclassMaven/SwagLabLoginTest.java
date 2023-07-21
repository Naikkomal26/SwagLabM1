package NewBaseclassMaven;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import NewMaven.BaseClass;
import NewMaven.SwagLabHomePage;
import NewMaven.SwagLabLoginPage;
import NewMaven.SwagLabOpenMenuPage;
import NewMaven.UtilityClass;

public class SwagLabLoginTest extends BaseClass {
	SwagLabLoginPage login; 
	SwagLabHomePage home; 
	SwagLabOpenMenuPage menu;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException 
	{
	initializeBrowser();
	login=new SwagLabLoginPage(driver);
	home=new SwagLabHomePage(driver); 
	menu=new SwagLabOpenMenuPage(driver);
	}
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Thread.sleep(500);
		login.inpSwagLabLoginPageUsername(UtilityClass.getTD(0 , 0));
		login.inpSwagLabLoginPagePassword(UtilityClass.getTD(0 , 1)); 
		login.clickSwagLabLoginPageLoginBtn();
		
	}
	@Test
	public void verifyHeader() throws EncryptedDocumentException, IOException 
	{
	String actResult = home.getSwagLabHomePageHeader();
	String expResult=UtilityClass.getTD(0, 2);
	Assert.assertEquals(actResult, expResult,"Failed: both results are diff- ");
	}
	@Test
	
	public void selectOptionFromFilter() throws EncryptedDocumentException, IOException 
	{
	home.selectSwagLabHomePageFilter();
	}
	
	@AfterMethod
	public void logoutFromApp() throws InterruptedException 
	{
	Thread.sleep(2000); 
	home.clickSwagLabHomePageOpenMenu(); 
	Thread.sleep(2000); 
	menu.clickSwagLabOpenMenuPageLogoutBtn();
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
	Thread.sleep(2000);
	driver.quit(); 
	}
	}
