package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	// a[contains(text(),'Sign in')]
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	public WebElement SignIn;

	// a[contains(text(),'Register')]
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	public WebElement Register;

	// div[@class='alert alert-primary']
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	public WebElement errorMessage;
	
	@FindBy(xpath="//a[@class='nav-link dropdown-toggle']")
	public WebElement dataStructureDropdown;
	public void clickOnDataStructure() {
		dataStructureDropdown.click();
		
	}
	
	public void clickOnDSOption(String option) {
		Actions act = new Actions(driver);
		WebElement linkEle = driver.findElement(By.xpath("//a[contains(text(),'"+option+"')]"));
		act.moveToElement(linkEle).perform();
		linkEle.click();
	}
	
	public void clickOnGetStartedOfEachSection(String option) {
		Actions act = new Actions(driver);
		WebElement linkEle = driver.findElement(By.xpath("//a[@href='"+option+"']"));
		act.moveToElement(linkEle).perform();
		linkEle.click();
	}
	

	public void clickOnSignIn() {
		SignIn.click();
	}

	public void clickOnRegister() {
		Register.click();
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}
	
	
	//a[contains(text(),'Get Started')]/..//h5[contains(text(),'Data Structures-Introduction')]
		@FindBy(xpath="//a[contains(text(),'Get Started')]/..//h5[contains(text(),'Data Structures-Introduction')]")
		public WebElement getStartedDataStructure;
		
		
		public void clickoNGetstarted() {
			
			getStartedDataStructure.click();
		}
}



