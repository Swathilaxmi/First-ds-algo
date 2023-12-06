package Pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignPage {

	public WebDriver driver;

	public SignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	//@FindBy(id = "id_username")
	@FindBy(xpath="//input[@name='username']")
	public WebElement txtUsername;
	
	public void enterUsernameinSignin(String username) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}
	
	
	//@FindBy(id = "id_password")
	@FindBy(xpath="//input[@name='password']")

	public WebElement txtloginPassword;
	public void enterPasswordinSignin(String Password) {
		txtloginPassword.clear();
		txtloginPassword.sendKeys(Password);
	}
	
	//input[@value='Login']
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement btnLogin;
	
	public void clickOnLogin(){
		btnLogin.click();
		
	}
	
	@FindBy(partialLinkText = "Register!")
	public WebElement registerlink;
	
	public void clickonregisterlink() {
		registerlink.click();
	}
	 
	@FindBy(partialLinkText = "Sign out")
	public WebElement signOutlink;
	
	public void clickonsignOutlink() {
		signOutlink.click();
	}
}


