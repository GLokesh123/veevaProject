package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PointsTableMenuPage extends BasePage{
	
	public PointsTableMenuPage(WebDriver driver)
	{
		super(driver);
	}
    @FindBy(xpath="//tbody[@id='pointsdata']/tr[1]")
    WebElement top1Team;
    
    public int top1PlayedMatches()
    {
    	String str=driver.findElement(By.xpath("//tbody[@id='pointsdata']/tr[1]/td[4]")).getText();
    	//System.out.println("top1PlayedMatches "+str);
    	return Integer.parseInt(str);
    	
    }
    public int top1MatchesWon()
    {
    	String str=driver.findElement(By.xpath("//tbody[@id='pointsdata']/tr[1]/td[5]")).getText();
    	//System.out.println("top1MatchesWon "+str);
    	return Integer.parseInt(str);
    }
    public int top1NoResults()
    {
    	String str=driver.findElement(By.xpath("//tbody[@id='pointsdata']/tr[1]/td[7]")).getText();
    	//System.out.println("top1NoResults "+str);
    	return Integer.parseInt(str);
    }
    
    public int top1Score()
    {
    	String str=driver.findElement(By.xpath("//tbody[@id='pointsdata']/tr[1]/td[11]")).getText();
    	//System.out.println("top1Score "+str);
    	return Integer.parseInt(str);
    }
    
    public boolean  isTop1ScoreValid()
    {
    	System.out.println("played "+top1MatchesWon());
    	System.out.println("no result: "+top1NoResults());
    	
    	System.out.println("top score: "+top1Score());
    	return top1Score()==(top1MatchesWon()*2+top1NoResults());
    }
    
    public String top1Team()
    {
    	String str=driver.findElement(By.xpath("//tbody[@id='pointsdata']/tr[1]/td[3]//h2")).getText();
    	System.out.println(str);
    	return str;
    }
    
    
}
