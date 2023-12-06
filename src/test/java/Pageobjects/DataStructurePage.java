package Pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataStructurePage {

	public WebDriver driver;

	public DataStructurePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	// a[contains(text(),'Time Complexity')]
	@FindBy(xpath = "//a[contains(text(),'Time Complexity')]")
	WebElement timeComplexicity;

	public void clickOnTimeComplexity() {
		timeComplexicity.click();
	}

	// Try here>>>
	@FindBy(partialLinkText = "Try here>>>")
	WebElement tryHere;

	public void clickOnTryHere() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		tryHere.click();
	}

	//form[@id='answer_form']/div/div/div/textarea
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	WebElement textArea;
	public void sendCode(String code) {
		textArea.sendKeys(code);
	}
	
	
	// document.getElementsByClassName(" CodeMirror-line ")[0];
	// button[contains(text(),'Run')]
	@FindBy(xpath = "//button[contains(text(),'Run')]")
	WebElement run;

	public void clickonRun() {
		run.click();
		
//	     Actions builder = new Actions(driver);
//	     builder.moveToElement( run ).click( run );
//	     builder.perform();
	}
	
	//pre[@id='output']
	@FindBy(xpath = "//pre[@id='output']")
	WebElement output;
	
	public String clickTogetoutput()
	{
		String result=output.getText();
		return result;
	}
	
	
}
