package Pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrayPage {

	public WebDriver driver;

	String code = "print'hello world'";
	List<WebElement> topicList;
	String expected, actual;
	public String url = "https://dsportalapp.herokuapp.com/login";

	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	WebElement dropdown;
	@FindBy(xpath = "//a[@class='list-group-item']")
	WebElement listTopic;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement try_here;

	@FindBy(xpath = "//a[contains(text(),'Arrays in Python')]")
	WebElement array_python;
	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement practiceQues;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement btnRun;

	public ArrayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void clickonPracticeQues() {
		array_python.click();
		practiceQues.click();

	}

	public void clickOnrun(String topicLink) throws InterruptedException {
		driver.navigate().forward();
		//List<String> topicArray = List.of(topicLink.split(","));
		//Iterator<String> a = topicArray.iterator();
		//while (a.hasNext()) {
			//String topicToClick = a.next();
			driver.findElement(By.xpath("//a[contains(text(),'" + topicLink + "')]")).click();
			Thread.sleep(1000);
			

		}
	
	
	public void newPagetopics() {
		btnRun.click();
		driver.switchTo().alert().accept();
		driver.navigate().back();
		
	}
}
