package undostres;

import java.lang.reflect.Method;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import undostres.CommonClassesReusable.BrowserSelection;
import undostres.CommonClassesReusable.Utility;
import undostres.CommonFuntions.CommonMethod;
import undostres.CommonFuntions.LoginPage;

public class Unostres extends BrowserSelection
{
	String testName;
	
	@BeforeClass
	public void Login() throws Throwable
	{

	}
	
	@BeforeMethod
	public void commonPage(Method method) throws Throwable
	{
		testName = method.getName();
		driver.navigate().refresh();
		
	}
	
	public static void isConditionX(boolean condition)
	{
		if(condition==false)
		{
			throw new SkipException("skipp");
		}
	}

	@Test(priority=1,enabled=true)
	public void E2E_TC0001() throws Throwable 
	{
		logger =report.startTest("E2E_TC0001", "Verify recharge functionality");
		System.out.println("START----------->"+testName);
		
		/***** Recharge Process *****/
		LoginPage.hitURL();
		
		CommonMethod.rechargeProcess();
	}

	@Test(priority=2,enabled=true)
	public void E2E_TC0002() throws Throwable 
	{
		logger =report.startTest("E2E_TC0002", "Verify recharge functionality");
		System.out.println("START----------->"+testName);
		
		/***** Recharge Process *****/
		String url = "https://demo.openmrs.org/openmrs/login.htm";
		String username = "Admin";
		String password = "Admin123";
		LoginPage.login(url, username, password);
		
		String patientFirstName = Utility.UniqueString(5);
		CommonMethod.registerPatient(patientFirstName);
		
		CommonMethod.findPatientRecordAndBookAppointment(patientFirstName);
		
		CommonMethod.deletePatient(patientFirstName);
		
		CommonMethod.logout();
		
	}
}	