package Stepdefinations;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import Pageobjects.ArrayPage;
import Pageobjects.DataStructurePage;
import Pageobjects.FrontPage;
import Pageobjects.HomePage;
import Pageobjects.RegisterPage;
import Pageobjects.SignPage;
import Pageobjects.StackPage;
import Pageobjects.graphPage;

public class BaseClass {
	
	
	public  WebDriver driver;
	
	public HomePage home;
	public FrontPage front;
	public RegisterPage regist;
	public SignPage signIn;
	public DataStructurePage dataStructure;
	public StackPage stack;
	public ArrayPage array;
	public graphPage graph;
	
	public Properties configProp;
	//creating random String for unique email
	public static String randomstring()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
	}

}
