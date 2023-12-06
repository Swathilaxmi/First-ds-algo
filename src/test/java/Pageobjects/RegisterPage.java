package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	//id_username
		@FindBy(id = "id_username")
		public WebElement txtUsername;
		
		public void enterTxtintoUsername(String username) {
			txtUsername.sendKeys(username);
		}
		
		//id_password1
		
		@FindBy(id = "id_password1")
		public WebElement txtPassword;
		public void enterTxtintoPassword(String Password) {
			txtPassword.sendKeys(Password);
		}
		
		//id_password2
		@FindBy(id = "id_password2")
		public WebElement txtPasswordConfirmation;
		public void enterTxtintoconfirmationPassword(String Password) {
			txtPasswordConfirmation.sendKeys(Password);
		}
		
		//input[@value='Register']
		@FindBy(xpath = "//input[@value='Register']")
		public WebElement btnRegister;
		
		
		
		public void clickonRegisterButton() {
			btnRegister.click();
			
		}
		
		
		
		
		
		
}


