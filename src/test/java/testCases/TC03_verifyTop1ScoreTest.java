package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PointsTableMenuPage;
import testBase.BaseClass;

public class TC03_verifyTop1ScoreTest extends BaseClass {
@Test
public void verifyTop1Score()
{
	HomePage hp=new HomePage(driver);
	logger.info("home page loaded");
	hp.clickOnPointsTableMenu();
	
	PointsTableMenuPage pt=new PointsTableMenuPage(driver);
	try
	{
		if(pt.isTop1ScoreValid())
		{
			Assert.assertTrue(true);
			logger.info("top 1 team "+pt.top1Team()+" have valid score");
		}
		else {
			logger.info("top 1 team "+pt.top1Team()+" have invalid score");
			Assert.fail();
		}
	}
	catch(Exception e)
	{
		
		logger.info(e.getMessage());
		System.out.println(e.getMessage());
		Assert.fail();
	}
}


}
