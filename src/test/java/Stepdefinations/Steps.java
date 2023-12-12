
package Stepdefinations;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Pageobjects.ArrayPage;
import Pageobjects.DataStructurePage;
import Pageobjects.FrontPage;
import Pageobjects.HomePage;
import Pageobjects.RegisterPage;
import Pageobjects.SignPage;
import Pageobjects.StackPage;
import Pageobjects.graphPage;
import Utilities.ExcelUtils;
import Utilities.LoggerLoad;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends BaseClass {

	String expected, actual;

	@Before

	public void setup() throws Exception {

		LoggerLoad.info("****Launching Browser****");
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("C:\\Users\\16692\\eclipse-workspace\\DsalgoProject\\test-output\\config.properties");
		configProp.load(configPropfile);
		String br = configProp.getProperty("browser");
		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		driver.manage().window().maximize();
		home = new HomePage(driver);
		front = new FrontPage(driver);
		regist = new RegisterPage(driver);
		signIn = new SignPage(driver);
		stack = new StackPage(driver);
		array=new ArrayPage(driver);
		graph=new graphPage(driver);
		dataStructure = new DataStructurePage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		LoggerLoad.info("****Launching URL****");
		driver.get(url);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String titile) {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			LoggerLoad.error("**unsuccessful login***");
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(titile, driver.getTitle());
		}

	}

	@When("Click on Get Started")
	public void click_on_get_started() throws Exception {
		front.clickonGetStarted();
	}

	
	@When("User click on Register link")
	
	public void user_click_on_register_link() {
		home.clickOnRegister();
	}

	@When("User click on Sign in link")
	public void user_click_on_sign_in_link() {
		home.clickOnSignIn();
	}

	@When("User click on Data Structure DropDown")
	public void user_click_on_data_structure_drop_down() {
		home.clickOnDataStructure();
	}

	@When("User click on {string}")
	public void user_click_on(String option) {
		home.clickOnDSOption(option);
	}

	@Then("The user get warning message {string}")
	public void the_user_get_warning_message(String string) {
		home.getErrorMessage();
	}

	// Signin

	@When("The user enter invalid {string} and {string}")
	public void the_user_enter_invalid_and(String username, String password) {

		signIn.enterUsernameinSignin(username);
		signIn.enterPasswordinSignin(password);

	}

	@When("The user clicks on register link on signin page")
	public void the_user_clicks_on_register_link_on_signin_page() {
		signIn.clickonregisterlink();
	}

	@Then("The user should get error message {string} below first empty field {string} {string}")
	public void the_user_should_get_error_message_below_first_empty_field(String expectedMessage, String username,
			String password) {

		if (username.isEmpty()) {
			String actualMessage = signIn.txtUsername.getAttribute("validationMessage");
			Assert.assertEquals(actualMessage, expectedMessage);
		} else if (password.isEmpty()) {
			String actualMessage = signIn.txtloginPassword.getAttribute("validationMessage");
			Assert.assertEquals(actualMessage, expectedMessage);
		}
	}

	@When("The user clicks on Signout button")
	public void the_user_clicks_on_signout_button() {

		signIn.clickonsignOutlink();
	}

//	Registration

	@When("User enters Username as {string} , Password as {string} and Password confirmation as {string}")
	public void user_enters_username_as_password_as_and_password_confirmation_as(String username, String password,
			String password3) {
		regist.enterTxtintoUsername(username);
		regist.enterTxtintoPassword(password);
		regist.enterTxtintoconfirmationPassword(password3);
	}

	@When("The user clicks on Register button")
	public void the_user_clicks_on_register_button() {
		regist.clickonRegisterButton();
	}

	@Then("It should display an error {string} below Username textbox")
	public void it_should_display_an_error_below_username_textbox(String expectedMessage) {
		String actualMessage = regist.txtUsername.getAttribute("validationMessage");
		Assert.assertEquals(actualMessage, expectedMessage);

	}

	@Then("It should display an error message {string}")
	public void it_should_display_an_error_message(String expectedMessage) {

		String actualMessage = home.getErrorMessage();
		System.out.println(actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Then("The user should be redirected to Homepage with the message {string}")
	public void the_user_should_be_redirected_to_homepage_with_the_message(String expectedMessage) {
		String actualMessage = home.getErrorMessage();
		Assert.assertEquals(actualMessage, expectedMessage);
		System.out.println(driver.getTitle());
		System.out.println(actualMessage);
	}

	@Then("The user should get error message {string} below first empty field {string} {string} {string}.")
	public void the_user_should_get_error_message_below_first_empty_field(String expectedMessage, String username,
			String password, String passwordconfirm) {

		if (username.isEmpty()) {
			String actualMessage = regist.txtUsername.getAttribute("validationMessage");
			Assert.assertEquals(actualMessage, expectedMessage);
		} else if (password.isEmpty()) {
			String actualMessage = regist.txtPassword.getAttribute("validationMessage");
			Assert.assertEquals(actualMessage, expectedMessage);
		} else if (passwordconfirm.isEmpty()) {

			String actualMessage = regist.txtPasswordConfirmation.getAttribute("validationMessage");
			Assert.assertEquals(actualMessage, expectedMessage);

		}

	}

	@When("User click on Get Started of {string}")
	public void user_click_on_get_started_of(String option) {
		home.clickOnGetStartedOfEachSection(option);
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

//	Data Structure scenerios

	@When("The user enter valid {string} and {string}")
	public void the_user_enter_valid_and(String username, String password) {
		signIn.enterUsernameinSignin(username);
		signIn.enterPasswordinSignin(password);
	}

	@Then("The user click on login button")
	public void the_user_click_on_login_button() {
		signIn.clickOnLogin();
	}

	@Given("The user should get a message {string}")
	public void the_user_should_get_a_message(String expectedMessage) {
		String actualmessage = home.getErrorMessage();
		System.out.println("actualmessage" + actualmessage);
		Assert.assertEquals(actualmessage, expectedMessage);

	}

	@When("The user clicks Time Complexity link")
	public void the_user_clicks_time_complexity_link() {
		dataStructure.clickOnTimeComplexity();
	}

	@When("The user clicks Try Here button on Time Complexity page")
	public void the_user_clicks_try_here_button_on_time_complexity_page() {

		dataStructure.clickOnTryHere();
	}

	@When("The user clicks on run button")
	public void the_user_clicks_on_run_button() {

		dataStructure.clickonRun();
		System.out.println("Clicked on run");

	}

	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() {
		System.out.println(dataStructure.clickTogetoutput());

	}

	@Then("The user should be presented with error message")
	public void the_user_should_be_presented_with_error_message() {

		String errorMessage = driver.switchTo().alert().getText();
		System.out.println("errorMessage: " + errorMessage);
		driver.switchTo().alert().accept();
		System.out.println("Accepted alert message");

	}

	@When("The user enter python code in tryEditor from sheet {string} and {string}")
	public void the_user_enter_python_code_in_try_editor_from_sheet_and(String pythonCode, String rowNumber) {
		try {
			String code = ExcelUtils.readexcel(pythonCode, rowNumber);
			dataStructure.sendCode(code);
			dataStructure.clickonRun();
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("document.getElementsByClassName(' CodeMirror-line
			// ')[0].innerHTML = '"+code+"';");

			// js.executeScript("document.getElementsByClassName(' CodeMirror-line
			// ')[0].innerHTML = '"+code+"';");
			// driver.findElement(By.className("CodeMirror-line")).sendKeys("Show this
			// message in rich text editor");
		} catch (Exception e) {
			System.out.println("exception" + e);
		}
	}

	@When("User click on Get Started of datastructure")
	public void user_click_on_get_started_of_datastructure() {

	}
	// Sign in data driven

	@When("The user enter username password from sheet {string} and {string}")
	public void the_user_enter_username_password_from_sheet_and(String Login, String rowNumber) throws Exception {
		try {
			String[] Logindetails = ExcelUtils.readLoginfromexcel(Login, rowNumber);
			signIn.enterUsernameinSignin(Logindetails[0]);
			signIn.enterPasswordinSignin(Logindetails[1]);
		} catch (Exception e) {
			System.out.println("exception" + e.getStackTrace());
			e.printStackTrace();
		}

	}

		// Linked list

	@Then("Linked List page is displayed")
	public void linked_list_page_is_displayed() {
		expected = "https://dsportalapp.herokuapp.com/linked-list/";
		actual =  stack.getPageUrl();
		Assert.assertTrue(expected.equalsIgnoreCase(actual));

	}

	 //Arrays
    
    
    
    @Then("Arrays page is displayed")
    public void Arrays_page_is_displayed() {
expected = "https://dsportalapp.herokuapp.com/array/";
actual = stack.getPageUrl();
Assert.assertTrue(expected.equalsIgnoreCase(actual));

}
    
    @When("User clicks on pratice button")
    public void user_clicks_on_pratice_button() {
    	array.clickonPracticeQues();
    	
    }
    
    @Then("new array page opens")
    public void new_array_page_opens() {
    	expected = "https://dsportalapp.herokuapp.com/array/practice";
    	actual = stack.getPageUrl();
    	Assert.assertTrue(expected.equalsIgnoreCase(actual));
    }
    
    @When("click on topics covered with {string}")
    public void click_on_topics_covered_with_string(String string) throws InterruptedException {
    	array.clickOnrun(string);
    	
    	
    }
    @Then("new page displayed")
    public void new_page_displayed() {
    	System.out.println("https://dsportalapp.herokuapp.com/question/");
    }

    @And("User clicks on run button")
    public void user_clicks_on_run_button() {
    	array.newPagetopics();
    }
    
    
    
//stack

@When("User click on stack from the dropdown")
public void user_click_on_stack_from_the_dropdown() throws InterruptedException {

stack.selectStackList();
Thread.sleep(2000);

}

@Then("Stack page is displayed")
public void Stack_page_is_displayed() {

expected = "https://dsportalapp.herokuapp.com/Stack/";
actual = stack.getPageUrl();
Assert.assertTrue(expected.equalsIgnoreCase(actual));

}

@Then("User is on Stack page")
public void user_is_on_stack_page() {
System.out.println("On Stack Page");
}




@When("User click on topics covered with {string} links")
public void user_click_on_topics_covered_with_links(String string) throws InterruptedException {
stack.clickonTopics(string);

}


@And("User click on try here button")
public void user_click_on_try_here_button() throws InterruptedException {
stack.clickonTryHere();
}




@Then("User clicks on pratice question")
public void user_clicks_on_pratice_question() {
stack.clickOnPraticeQues();

}


//tree

@Then("Tree page is displayed")
public void Tree_page_is_displayed() {
expected = "https://dsportalapp.herokuapp.com/tree/";
actual = stack.getPageUrl();
Assert.assertTrue(expected.equalsIgnoreCase(actual));

}
//queue
@Then("Queue page is displayed")
public void queue_page_is_displayed() {
expected = "https://dsportalapp.herokuapp.com/queue/";
actual = stack.getPageUrl();
Assert.assertTrue(expected.equalsIgnoreCase(actual));

}

//graph
@Then("graph page is displayed")
public void graph_page_is_displayed() {
	expected = "https://dsportalapp.herokuapp.com/graph/";
	actual = stack.getPageUrl();
	Assert.assertTrue(expected.equalsIgnoreCase(actual));

}

@When("User click on options of graph {string} links")
public void user_click_on_options_of_graph_links(String option) {
  graph.clickonoptions(option);

}


	@After
	public void afterScenario(Scenario scenario) {

		boolean failed = scenario.isFailed();
		System.out.println("is Failed?" + failed);
		if (failed) {

			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());

//	TakesScreenshot scrShot = ((TakesScreenshot)driver);
//	  File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
//	  
//	  	Date currentDate = new Date();
//	  	String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
//	  	String fileSeperator = System.getProperty("file.separator");
//	    String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "Screenshots";
//	    String reportFileName = "ScreenShot"+timestamp+".png";
//	    String filePath =  reportFilepath +fileSeperator+ reportFileName;
//	    File DestFile = new File(filePath);
//	    try {
//			FileUtils.copyFile(srcFile, DestFile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		}
		driver.close();
		driver = null;
	}

}
