package testCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_FooterTest extends BaseClass{
	
	@Test
	public void footerTest()
	{
		String secNames[]= {"TEAM","ABOUT","GUIDELINES","CONTACT"};	
		List<String> al=new ArrayList<>();
		try {
			
			HomePage hp=new HomePage(driver);
            logger.info("Home page Loaded");
			
			for(String secName:secNames)
			{
				if(!hp.isFooterLinksPresent(secName))
				{
					al.add(secName);
				}
			}
			logger.info("sections checked successfully");
			
			if(al.size()==0)
			{
				logger.info("All Sections having links are present");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Section(s): "+String.join(", ",al)+" =>have error!");
				Assert.assertTrue(false);
				
			}
			
			
			
		}
		catch(Exception e)
		{
	        logger.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}

}
