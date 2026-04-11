package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC04_verifySearchFunctionalityTest extends BaseClass {
    @Test
    public void verifySearchFunctionality()
    {
	try {
				
				HomePage hp=new HomePage(driver);
	            logger.info("Home page Loaded");
	            
	            hp.clickOnNewsMenu();
	            if(hp.isNewsPageLoaded())
	            	logger.info("news page loaded");
	            else logger.info("News page not loaded!***");
	            
	            hp.clickOnSearchIcon();
	            
	            String text="Auction 2026";
	            hp.search(text);
	            hp.clickOnSearchBarBtn();
	            if(hp.isAnyArcticleContains(text))
	            {
	            	logger.info("search functionality working perfectly");
	            	Assert.assertTrue(true);
	            }
	            else
	            {
	            	logger.info("search functionality not working!***");
	            	Assert.fail();
	            }
	            
	    }
	catch(Exception e)
	{
		logger.info(e.getMessage());
		Assert.fail(e.getMessage());
	}
}
}
