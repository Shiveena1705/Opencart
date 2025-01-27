package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	@Test(groups= {"Sanity","Master"})
	public void verify_account_registration() {
		
		logger.info("*****Starting TC001*****");
		try {
			
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on Myaccount info");
		
		hp.clickRegister();
		logger.info("Clicked on Register info");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		regpage.setFirstname(randomeString().toUpperCase());
		regpage.setLastname(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacypolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message");
		String confirmMsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
	}
	catch(Exception e) {
		logger.error("Test failed");
		logger.debug("Debug logs");
		Assert.fail();
	}
		logger.info("*****Finished TC001*****");
	}
	

}
