package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class graphPage {

	public WebDriver driver ;

	public graphPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickonoptions(String option)
	{
	Actions act = new Actions(driver);
	WebElement linkEle = driver.findElement(By.xpath("//a[@href='"+option+"']"));
	act.moveToElement(linkEle).perform();
	linkEle.click();
	}
	
	
}
