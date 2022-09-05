package undostres.CommonClassesReusable;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class Utility extends BrowserSelection {
	
	public static void verifyElementPresent(String verifyElementXpath,String fieldName,boolean takeScreenshotIfPass,boolean stopExecution) throws Exception
	{
		try{
			Assert.assertTrue(driver.findElement(By.xpath(verifyElementXpath)).isDisplayed());
			WebElement element = driver.findElement(By.xpath(verifyElementXpath));
			Jexecutor.highlightElement(element);
			System.out.println("Successfully: "+fieldName+" is present.");
			if(takeScreenshotIfPass)
			{
				Utility.takeScreenshot(Utility.UniqueNumber(5));
				logger.log(LogStatus.PASS,"Successfully: "+fieldName+" is present."+ imgeHtmlPath);
			}
			else
			{
				logger.log(LogStatus.PASS,"Successfully: "+fieldName+" is present.");	
			}		    	
		}
		catch(Exception e)
		{
			System.out.println("Failed: "+fieldName+" is not present.");
			Utility.takeScreenshot(Utility.UniqueNumber(5));
			logger.log(LogStatus.FAIL, "Failed: "+fieldName+" is not present. Screenshort of BUGG :" + e + imgeHtmlPath);
			if(stopExecution)
			{
				throw (e);
			}
		}
	}
	
	public static void takeScreenshot(String SSname) {
		
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			
			//String screenShotPath=System.getProperty("user.dir") +"\\ExtentReport\\Output\\Screenshots\\";
			FileUtils.copyFile(scrFile, new File(AGlobalComponents.extentReportScreenshotFolder+SSname+".png")); 
			imgeHtmlPath=logger.addScreenCapture(AGlobalComponents.extentReportScreenshotFolder+SSname+".png").replace(AGlobalComponents.extentReportScreenshotFolder, "Screenshots\\").replace("file:///", "").replace("<img", "<img width=\"150\" height=\"70\"");                                
                   
	      
		} catch (IOException e) {
			throw new java.lang.RuntimeException("RUNTIME_ERROR : : Exception occur during take ScreenShot: "+SSname);
		}
	}
	
	public static void verifyElementPresentByScrollView(String verifyElementXpath,String fieldName,boolean takeScreenshotIfPass,boolean stopExecution) throws Throwable
	{
		try{
			WebElement element = driver.findElement(By.xpath(verifyElementXpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			System.out.println("Successfully: "+fieldName+" is present.");
			if(takeScreenshotIfPass)
			{
				Utility.takeScreenshot(Utility.UniqueNumber(5));
				logger.log(LogStatus.PASS,"Successfully: "+fieldName+" is present."+ imgeHtmlPath);
			}
			else
			{
				logger.log(LogStatus.PASS,"Successfully: "+fieldName+" is present.");	
			}		    	
		}
		catch(Exception e)
		{
			System.out.println("Failed: "+fieldName+" is not present.");
			Utility.takeScreenshot(Utility.UniqueNumber(5));
			logger.log(LogStatus.FAIL, "Failed: "+fieldName+" is not present. Screenshort of BUGG :" + e + imgeHtmlPath);
			if(stopExecution)
			{
				throw (e);
			}
		}
	}
	
	public static String UniqueString(int length){
		
		String UniqueString=RandomStringUtils.randomAlphabetic(length);
		return UniqueString;
	}
	
    public static String UniqueNumber(int length){
		
		String UniqueNumber=RandomStringUtils.randomNumeric(length);
		return UniqueNumber;
	}
    
  
	

}