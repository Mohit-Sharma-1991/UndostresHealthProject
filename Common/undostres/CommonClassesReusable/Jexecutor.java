package undostres.CommonClassesReusable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Jexecutor extends BrowserSelection  {
	public static void highlightElement(WebElement element) throws InterruptedException {
		 JavascriptExecutor jse=(JavascriptExecutor) driver;
		try {
			if (AGlobalComponents.jsExecutor) {
			//	JavascriptExecutor js = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"color: brown; border: 4px solid black;");
				Thread.sleep(100);
			}
		} catch (Exception e) {
		//	ExtentReport.testStep("Caught exception in " + Thread.currentThread().getStackTrace()[1].getMethodName() + "Due to: "+e.getMessage());
			 e.getMessage();
		}
	}

	public static void hidePopup(WebElement element) throws InterruptedException {
		 JavascriptExecutor jse=(JavascriptExecutor) driver;
		// js.executeScript("arguments[0].setAttribute(style.visibility='visible';
		// ");
		try {
			if (AGlobalComponents.jsExecutor) {
				jse.executeScript("arguments[0].style.visibility='hidden';", element);
				// ((JavascriptExecutor)
				// driver).executeScript("arguments[0].style.display='none';",element);
			}
		} catch (Exception e) {
			//ExtentReport.testStep("Caught exception in " + Thread.currentThread().getStackTrace()[1].getMethodName() + "Due to: "+e.getMessage());
	        e.getMessage();
		}
	}

	public static void showPopup(WebElement element) throws InterruptedException {
		 JavascriptExecutor jse=(JavascriptExecutor) driver;
		// js.executeScript("arguments[0].setAttribute(style.visibility='visible';
		// ");
		try {
			if (AGlobalComponents.jsExecutor) {
				jse.executeScript("arguments[0].style.visibility='visible';", element);
				// ((JavascriptExecutor)
				// driver).executeScript("arguments[0].style.display='none';",element);
			}
		} catch (Exception e) {
			//ExtentReport.testStep("Caught exception in " + Thread.currentThread().getStackTrace()[1].getMethodName() + "Due to: "+e.getMessage());
			 e.getMessage();
		}
	}
	
	public static void setAttValue(WebElement element,String AtributeName, String value) throws InterruptedException {
		 JavascriptExecutor jse=(JavascriptExecutor) driver;
		// js.executeScript("arguments[0].setAttribute(style.visibility='visible';
		// ");
		try {
			
				jse.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",element,AtributeName,value);
			}
		 catch (Exception e) {
		//	ExtentReport.testStep("Caught exception in " + Thread.currentThread().getStackTrace()[1].getMethodName() + "Due to: "+e.getMessage());
		      e.getMessage();
		 }
	}
	
	
}
