package Pageobjects;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class LinkedListPage {
	public  WebDriver driver;
	
	
	List<WebElement> topicList;
	String expected, actual;
	public String url = "https://dsportalapp.herokuapp.com/login";
	By dropdown = By.xpath("//a[@class='nav-link dropdown-toggle']");
	By linkedlist =By.xpath("//h5[text()='Stack']/../a[text()='Get Started']");
	By listTopic = By.xpath("//a[@class='list-group-item']");
	By pageContent = By.xpath("//strong/p[contains(@class,'bg-secondary')]");
	By topicLeft = By.xpath("//li[contains(@class,'list-group-item')]/a");
	By try_here =By.xpath("//a[text()='Try here>>>']");
	By codeText = By.xpath("//div[contains(@class, 'CodeMirror')]/div/textarea");
	By btnRun = By.xpath("//button[text()='Run']");
	By out = By.id("output");
	By practiceQues = By.xpath("//a[text()='Practice Questions']");
	
	
	public LinkedListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}

	
	
	public void selectLinkedlist() {
		driver.findElement(dropdown);
		driver.findElement(linkedlist);
		
	}
	public String getPageUrl() {
		
		actual=driver.getCurrentUrl();
		return actual;
	}
	public void clickOnOperation() throws InterruptedException {
		driver.findElements(listTopic);
		Thread.sleep(2000);
		
	}
	public void clickonTopics(String topicLink) throws InterruptedException {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		List<String>topicArray = List.of(topicLink.split(","));
		Iterator<String> a = topicArray.iterator();
		while(a.hasNext()){
			String topicToClick = a.next();
			driver.findElement(By.xpath("//a[contains(text(),'"+topicToClick+"')]")).click();
			Thread.sleep(1000);
			driver.findElement(try_here).click();
			driver.navigate().back();
			
			}
		}
	
	
	
	
	
	
}

