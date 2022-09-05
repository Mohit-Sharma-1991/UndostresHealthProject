
package undostres.CommonFuntions;
import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

import undostres.CommonClassesReusable.BrowserSelection;
import undostres.CommonClassesReusable.Operation;
import undostres.CommonClassesReusable.Utility;
import undostres.ObjectRepository.HomeObjects;

public class CommonMethod extends BrowserSelection 
{


	
	public static void rechargeProcess() throws Throwable
	{
		System.out.println("******************************** rechargeProcess *****************************************");
		Operation.click("xpath", HomeObjects.recargaCelularBtn, "Click on Recarga celular Button");
		
		Operation.setText("xpath", HomeObjects.recargaCelularNumeroDeCelularTxt, "8465433546", "Enter Numero de celular: 8465433546");
		Operation.click("xpath", HomeObjects.recargaCelularOperadorDdn, "Click on Operador Dropdown");
		Operation.click("xpath", HomeObjects.recargaCelularOperadorSelectTelcelDdn, "Click on 'telcel' from Dropdown");
		Operation.click("xpath", HomeObjects.recargaCelularMontoDeRecargaDdn, "Click on Monto de Recarga Dropdown");
		Operation.click("xpath", HomeObjects.recargaCelularMontoDeRecargaSelectDdn, "select '$10' from dropdown");
			
		Operation.click("xpath", HomeObjects.recargaCelularSiguienteBtn, "Click on Siguiente Button");
		
		Utility.verifyElementPresent(HomeObjects.recargaCelularPaymentScreenPge, "Payment Screen", false, false);
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.recargaCelularTarjetaBtn, "Click on Tarjeta");
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.recargaCelularUsarNuevaTarjetaBtn, "Click on Usar nueva tarjeta");
		
		Operation.setText("xpath", HomeObjects.recargaCelularNúmeroDeTarjetaTxt, "4111111111111111", "Enter 4111111111111111");
		Operation.setText("xpath", HomeObjects.recargaCelularMonthTxt, "11", "Enter 11");
		Operation.setText("xpath", HomeObjects.recargaCelularYearTxt, "25", "Enter 25");
		Operation.setText("xpath", HomeObjects.recargaCelularCvvTxt, "111", "Enter 111");
		
		Operation.setText("xpath", HomeObjects.recargaCelularEmailTxt, "test@test.com", "Enter 111");
		Operation.click("xpath", HomeObjects.recargaCelularPagarConTarjetaBtn, "Click on Pagar con Tarjeta Button");
		
		Operation.setText("xpath", HomeObjects.recargaCelularUsernameTxt, "automationUDT1@gmail.com", "Enter Email: automationUDT1@gmail.com");
		Operation.setText("xpath", HomeObjects.recargaCelularPasswordTxt, "automationUDT123", "Enter Password: automationUDT123");
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath(HomeObjects.recargaCelularCaptchaChk)).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		Utility.verifyElementPresentByScrollView(HomeObjects.recargaCelularAccesoBtn, "Acceso button", false, false);
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.recargaCelularAccesoBtn, "Click on Acceso button");
		Thread.sleep(1000);
		
		if(driver.findElements(By.xpath(HomeObjects.recargaCelularSuccessMessageLbl)).size()>0)
		{
			Utility.verifyElementPresent("//div[text() = 'Recarga Saldo de Telcel al número 8465433546']//parent::div//div[contains(text(),'$10')]", "Success Message", false, false);
		}
		else
		{
			System.out.println("Success Message is Not present. Please check Application");
			logger.log(LogStatus.FAIL,"Success Message is Not present. Please check Application");
		}
		
		
		
		
		
	
	}
	
	public static void registerPatient(String name) throws Throwable 
	{		
		
		/* Register Patient */
		Utility.verifyElementPresent(HomeObjects.homePageHeadingLbl, "Page Heading: Logged in as Super User (admin) at Inpatient Ward.", false,false);
		Operation.click("xpath", HomeObjects.homePageRegisterPatientBtn, "Click on Register a patient Button");
		Thread.sleep(1500);
		Operation.setText("xpath", HomeObjects.registerPatientGivenNameTxt, name, "Enter Name: "+name);
		Operation.setText("xpath", HomeObjects.registerPatientMiddleNameTxt, "Auto", "Enter Name: Auto");
		Operation.setText("xpath", HomeObjects.registerPatientFamilyNameTxt, "Test", "Enter Name: Test");
		Operation.click("xpath", HomeObjects.registerPatientRightArrowBtn, "Click on right arrow to move next page");
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.registerPatientGenderlbl, "Select Gender: Male");
		Operation.click("xpath", HomeObjects.registerPatientRightArrowBtn, "Click on right arrow to move next page");
		Thread.sleep(1000);
		Operation.setText("xpath", HomeObjects.registerPatientBirthdateDayTxt, "11", "Enter Birth date day: 11");
		Operation.click("xpath", HomeObjects.registerPatientBirthdateMonthDdn, "Click on Month field to select Month");
		Operation.click("xpath", HomeObjects.registerPatientBirthdateMonthSelectDdn, "Click on February Month");			
		Operation.setText("xpath", HomeObjects.registerPatientBirthdateYearTxt, "1965", "Enter Birth date Year: 1965");
		Operation.click("xpath", HomeObjects.registerPatientRightArrowBtn, "Click on right arrow to move next page");
		Thread.sleep(1000);
		Operation.setText("xpath", HomeObjects.registerPatientAddress1Txt, "132", "Enter Address 1: 132");
		Operation.setText("xpath", HomeObjects.registerPatientAddress2Txt, "My Street", "Enter Address 2: My Street");
		Operation.click("xpath", HomeObjects.registerPatientRightArrowBtn, "Click on right arrow to move next page");
		Thread.sleep(1000);
		Operation.setText("xpath", HomeObjects.registerPatientPhoneNumberTxt, "8954751258", "Enter Phone Number: 8954751258");
		Operation.click("xpath", HomeObjects.registerPatientRightArrowBtn, "Click on right arrow to move next page");
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.registerPatientRightArrowBtn, "Click on right arrow to move next page");
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.registerPatientSubmitBtn, "Click on Submit button");
		Thread.sleep(2000);
	}
	
	public static void findPatientRecordAndBookAppointment(String name) throws Throwable 
	{		
		Operation.click("xpath", HomeObjects.registerPatientHomeBtn, "Click on Home Button");
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.findPatientBtn, "Click on Find Patient Record Button");
		Utility.verifyElementPresent(HomeObjects.findPatientRecordPageLbl, "Page Heading: Find Patient Record", false, false);
		Operation.setText("xpath", HomeObjects.findPatientRecordSearchBoxTxt, name+" Auto Test", "Searched with Name: "+name+" Auto Test");
		Thread.sleep(1500);
		Utility.verifyElementPresent("//*[@id='patient-search-results-table']/tbody//td[text() = '"+name+" Auto Test']", "User: "+name+" Auto Test" , false, false);
		Operation.click("xpath", "//*[@id='patient-search-results-table']/tbody//td[text() = '"+name+" Auto Test']", "Click on searched User");
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.requestAppointmentBtn, "Click on Request Appointment Button");
		Thread.sleep(1000);
		Operation.setText("xpath", HomeObjects.requestAppointmentTypeTxt, "Dermatology", "Enter Appointment Type: Dermatology");
		Thread.sleep(500);
		Operation.click("xpath", HomeObjects.requestAppointmentTypeSelectDdn, "Click on Dermatology (New Patient)");
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.requestAppointmentSaveBtn, "Click on Save Button");
		Thread.sleep(2000);
			
	}

	public static void deletePatient(String name) throws Throwable 
	{		
		Operation.click("xpath", HomeObjects.registerPatientHomeBtn, "Click on Home Button");
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.findPatientBtn, "Click on Find Patient Record Button");
		Operation.setText("xpath", HomeObjects.findPatientRecordSearchBoxTxt, name+" Auto Test", "Searched with Name: "+name+" Auto Test");
		Thread.sleep(1500);
		Operation.click("xpath", "//*[@id='patient-search-results-table']/tbody//td[text() = '"+name+" Auto Test']", "Click on searched User");
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.deletePatientBtn, "Click on Delete Button");
		Thread.sleep(1000);
		Operation.setText("xpath", HomeObjects.deletePatientReasonTxt, "Fine", "Enter Delete Reason");
		Thread.sleep(1000);
		Operation.click("xpath", HomeObjects.deletePatientConfirmBtn, "Click on Confirm Button");
		Thread.sleep(1500);
	}

	public static void logout() throws Throwable 
	{		
		Operation.click("xpath", HomeObjects.logoutBtn, "Click on Logout Button");		
	}
	
}