package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.TeamsMenuPage;
import testBase.BaseClass;

public class TC02_verifyTeamLogoTest extends BaseClass{
 
	@Test
	public void verifyTeamLogo()
	{
		HomePage hp=new HomePage(driver);
		logger.info("home page loaded");
		hp.clickOnTeamsMenu();
		
		TeamsMenuPage tp=new TeamsMenuPage(driver);
		
		String teams[]= {"CSK","DC","MI","SRH","KKR","RCB","GT","LSG","PK","RR"};
		for(String teamName:teams)
		{
			try {
				if(tp.isTeamLogoDisplayed(teamName))
				{
					logger.info(teamName+"logo displayed");
				}
				else
				{
					logger.info(teamName+" logo not displayed!");
				}
			}catch(Exception e)
			{
				logger.info(teamName+" logo not displayed!");
			}

			
		}
		
	}
}
