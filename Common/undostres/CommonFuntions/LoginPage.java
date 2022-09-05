package undostres.CommonFuntions;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import undostres.CommonClassesReusable.AGlobalComponents;
import undostres.CommonClassesReusable.BrowserSelection;
import undostres.CommonClassesReusable.Operation;
import undostres.CommonClassesReusable.dynamicwait;
import undostres.ObjectRepository.LoginObjects;


public class LoginPage extends BrowserSelection {

	
	public static boolean hitURL() throws Exception
	{
		System.out.println("**************************** login **********************************");		
		driver.get(AGlobalComponents.applicationURL);
		System.out.println("Successfully: open url- "+AGlobalComponents.applicationURL);
		dynamicwait.WAitUntilPageLoad2();

		return true;
	}
	
	public static void login(String url, String username, String password) throws Throwable 
	{		
		/* Login Function */
		driver.get(url);
		Thread.sleep(1000);
		Operation.setText("xpath", LoginObjects.loginPageUsernameTxt, username, "Enter Username: Admin");
		Operation.setText("xpath", LoginObjects.loginPagePasswordTxt, password, "Enter Password: Admin123");
		Thread.sleep(1000);
		Operation.click("xpath", LoginObjects.loginPageLocationBtn, "Click on Location: Inpatient Ward");
		Operation.click("xpath", LoginObjects.loginPageLoginBtn, "Click on Login Button");
		Thread.sleep(1500);
			
	}
}
