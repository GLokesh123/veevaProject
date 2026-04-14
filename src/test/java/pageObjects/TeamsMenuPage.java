package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	   
	   acceptCookiesIfPresent(); 
	   WebElement cupYears=driver.findElement(By.xpath("//li[contains(@class,'TL_"+teamName+"')]//div[contains(@class,'team-on-hover')]//div[@class='trophy-text-align']"));
	  
	   String str="";
	   actions.moveToElement(team).perform();
	   System.out.println(teamName+" won in "+cupYears.getText());
       str=cupYears.getText();
	   return str;
   }
   public void acceptCookiesIfPresent()
   {
       try
       {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

           WebElement acceptBtn = wait.until(
               ExpectedConditions.elementToBeClickable(
                   By.xpath("//button[contains(.,'Accept cookies')]")
               )
           );

           acceptBtn.click();

           wait.until(ExpectedConditions.invisibilityOf(acceptBtn));
       }
       catch (Exception e)
       {
           System.out.println("Cookie popup not present**");
       }
   }
   
}
