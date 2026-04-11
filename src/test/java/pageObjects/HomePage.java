package pageObjects;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//ul[contains(@class,'site-menu main-menu js-clone-nav d-none d-lg-block textCenter')]//a[contains(@onclick,'click_menu(this)')][normalize-space()='TEAMS']")
	WebElement teamsElement;
	
	@FindBy(xpath="//ul[contains(@class,'site-menu main-menu js-clone-nav d-none d-lg-block textCenter')]//a[contains(@onclick,'click_menu(this)')][normalize-space()='POINTS TABLE']")
	WebElement pointsTable;
	
	@FindBy(xpath="(//*[text()='NEWS'])[2]")
	WebElement news;
	
	@FindBy(xpath="//img[@id='searchIconHeader']")
	WebElement searchIcon;
	
	@FindBy(xpath="//input[@id='searchInputForHeader']")
	WebElement searchBar;
	
	@FindBy(xpath="//button[@id='searchButtonForHeader']")
	WebElement searchSubmitBtn;
	
	
	public boolean isFooterLinksPresent(String secName)
	{
		WebElement ele=driver.findElement(By.xpath("//div[@class='container py-5 position-relative']"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", ele);
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='ap-foot-menu']/h2[text()='"+secName+"']/../div[@class='ap-foot-nav col-100 floatLft']/a"));
		return list.size()>0;
	}
	
	public void clickOnTeamsMenu()
	{
		teamsElement.click();
	}
	
	public void clickOnPointsTableMenu()
	{
		pointsTable.click();
	}
	public void clickOnNewsMenu()
	{
		news.click();
	}
	
	public void clickOnSearchIcon()
	{
		searchIcon.click();
				
	}
	public void search(String text)
	{
		searchBar.sendKeys(text);
	}
	public  boolean isAnyArcticleContains(String text)
	{
		List<WebElement> textElements=driver.findElements(By.xpath("//li[contains(text(),'"+text+"')]"));
		List<String> list=new ArrayList<>();
		for(WebElement e:textElements)
		{
			list.add(e.getText());
		}
		return list.size()>0;
	}
	public boolean isNewsPageLoaded()
	{
		return driver.getCurrentUrl().contains("news");
	}
	
	public void clickOnSearchBarBtn()
	{
		searchSubmitBtn.click();
	}

}
