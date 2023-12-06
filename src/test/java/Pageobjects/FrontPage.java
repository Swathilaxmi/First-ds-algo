package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FrontPage {

	public WebDriver driver;

	public FrontPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}


	@FindBy(xpath = "//button[@class='btn']")
	public WebElement getStarted;

	public void clickonGetStarted() throws Exception {
		//waitForElement(20,getStarted);
		getStarted.click();
	}
}

