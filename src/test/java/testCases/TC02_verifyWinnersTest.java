package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.TeamsMenuPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC02_verifyWinnersTest extends BaseClass{
@Test(dataProvider="WinnersData",dataProviderClass=DataProviders.class)
public void verifyWinmers(String year,String winner)
{
	try {
		System.out.println(year+" "+winner);
		HomePage hp=new HomePage(driver);
		logger.info("home page loaded");
		hp.clickOnTeamsMenu();
		
		TeamsMenuPage tp=new TeamsMenuPage(driver);
		String str=tp.hoverAndExtractTextOnTeam(winner);
		System.out.println(str);
		
		if(str.contains(year))
		{
			logger.info(winner+" in year "+year+" is displayed");
			Assert.assertTrue(true);
		}
		else
		{
			
			logger.info(winner+" in year "+year+" is not displayed!***"+str);
			Assert.fail();
		}
	}
	catch(Exception e)
	{
		logger.info("error in TC02_verifyWinnersTest");
	}
	
	
}

}
