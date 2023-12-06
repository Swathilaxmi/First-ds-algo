package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StackPage {

	public WebDriver driver ;
	
     String s ="print'hello'";
		
	
	String expected, actual;
	
	@FindBy(xpath="//a[@class='nav-link dropdown-toggle']")
	WebElement dropdown ;
	
	@FindBy(xpath="//a[text()='Stack']")
	WebElement stack ;
	
	@FindBy(xpath="//a[text()='Try here>>>']")
	WebElement try_here ;
	
	//@FindBy(xpath="//div[contains(@class, 'CodeMirror')]/div/textarea")
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	WebElement code_text  ;
	
	@FindBy(xpath="//button[text()='Run']")
	WebElement  btnRun ;
	
	@FindBy(xpath="//a[text()='Practice Questions']")
	WebElement praticeQues;
	
	 public StackPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	

	
public void selectStackList() {
dropdown.click();
	stack.click();
}


public String getPageUrl() {
	
	actual=driver.getCurrentUrl();
	return actual;
}

public void clickonTopics(String topicLink) throws InterruptedException {
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	
		driver.findElement(By.xpath("//a[contains(text(),'"+topicLink+"')]")).click();	
		System.out.println("clicked");
	
	}

	public void clickonTryHere() throws InterruptedException {
		try_here.click();
		Thread.sleep(1000);
		code_text.sendKeys(s);
		btnRun.click();
		Thread.sleep(1000);
		driver.navigate().back();
			
		}

	public void clickOnPraticeQues() {
		praticeQues.click();
		driver.navigate().back();
	}


}



