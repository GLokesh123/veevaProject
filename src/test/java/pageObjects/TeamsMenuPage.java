package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TeamsMenuPage extends BasePage{
	
  
	
   public TeamsMenuPage(WebDriver driver)
   {
	   super(driver);
	  
   }
   
   
   public boolean isTeamLogoDisplayed(String teamName)
   {
	   
	   WebElement logo=driver.findElement(By.xpath("//li[@class='TL_"+teamName+"']//div[@class='vn-team-logo']//img"));
	   return logo.isDisplayed(); 
   }
   
   public String hoverAndExtractTextOnTeam(String teamName)
   {
	   WebElement team=driver.findElement(By.xpath("//li[@class='TL_"+teamName+"']//div[@class='team-on-hover']"));
	   	  
	   WebElement cupYears=driver.findElement(By.xpath("//li[contains(@class,'TL_"+teamName+"')]//div[contains(@class,'team-on-hover')]//div[@class='trophy-text-align']"));
	   
	   String str="";
	   actions.moveToElement(team).perform();
       str=cupYears.getText();
	   return str;
   }
   
}
