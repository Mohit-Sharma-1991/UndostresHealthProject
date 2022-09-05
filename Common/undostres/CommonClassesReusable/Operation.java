
package undostres.CommonClassesReusable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;


public class Operation extends BrowserSelection  {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	static WebElement element;
	static String value = "";
	static Select select = null;


	public static void click(String attribute, String attributevalue, String actionInfo) {

		try {
//			dynamicwait.WAitUntilPageLoad();

			//			find the object based on attribute
			switch (attribute.toLowerCase()) {
			case "xpath":
				element = driver.findElement(By.xpath(attributevalue));
				break;
			case "id":
				element = driver.findElement(By.id(attributevalue));
				break;
			case "name":
				element = driver.findElement(By.name(attributevalue));
				break;
			case "linktext":
				element = driver.findElement(By.linkText(attributevalue));
				break;
			case "cssselector":
				element = driver.findElement(By.cssSelector(attributevalue));
				break;
			case "classname":
				element = driver.findElement(By.className(attributevalue));
				break;
			default: 
				logger.log(LogStatus.ERROR, "Failed: Attribute Name {" +attribute+"} Not Found " + actionInfo);
				throw new UnsupportedOperationException();
			}

			Jexecutor.highlightElement(element);
			try{
				element.click();

			}catch(ElementNotVisibleException e1){
				JavascriptExecutor jss= ((JavascriptExecutor)driver);
				jss.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(1000);
				jss.executeScript("arguments[0].click();", element);

			}catch(StaleElementReferenceException e2){
				int count=0;
				while(count <4){
					if(element.isDisplayed()){

						element.click();
						break;
					}
					Thread.sleep(1500);
					count++;
				}
			}catch(WebDriverException e3){

				JavascriptExecutor jss= ((JavascriptExecutor)driver);
				jss.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(1000);
				jss.executeScript("arguments[0].click();", element);
			}

			System.out.println("Successfully: " + actionInfo);
			logger.log(LogStatus.INFO, "Successfully: " + actionInfo);
		} catch (Exception e) {
			System.out.println("RUNTIME_ERROR : : Not able to  : " + actionInfo );
			throw new java.lang.RuntimeException(
					"RUNTIME_ERROR : : Not able to  : " + actionInfo + "--------------->" + e);

		}

	}

	public static String getText(String attribute, String attributevalue, String actionInfo) {
		String textvalue = null;
		try {
			dynamicwait.WAitUntilPageLoad();

			//			find the object based on attribute
			switch (attribute.toLowerCase()) {
			case "xpath":
				element = driver.findElement(By.xpath(attributevalue));
				break;
			case "id":
				element = driver.findElement(By.id(attributevalue));
				break;
			case "name":
				element = driver.findElement(By.name(attributevalue));
				break;
			case "linktext":
				element = driver.findElement(By.linkText(attributevalue));
				break;
			case "cssselector":
				element = driver.findElement(By.cssSelector(attributevalue));
				break;
			case "classname":
				element = driver.findElement(By.className(attributevalue));
				break;
			default: 
				logger.log(LogStatus.ERROR, "Failed: Attribute Name {" +attribute+"} Not Found " + actionInfo);
				throw new UnsupportedOperationException();
			}
			Jexecutor.highlightElement(element);
			try{
				textvalue = element.getText();
			}catch(ElementNotVisibleException e1){

				JavascriptExecutor jss=((JavascriptExecutor)driver);
				jss.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(1000);
				textvalue = element.getText();

			}catch(StaleElementReferenceException e2){
				int count=0;
				while(count <4){
					if(element.isDisplayed()){

						textvalue = element.getText();
						break;
					}
					Thread.sleep(1500);
					count++;
				}
			}catch(WebDriverException e3){

				JavascriptExecutor jss=((JavascriptExecutor)driver);
				jss.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(1000);
				textvalue = element.getText();
			}

			System.out.println("Successfully: " + actionInfo);
			logger.log(LogStatus.INFO, "Successfully: " + actionInfo);
		} catch (Exception e) {
			System.out.println("RUNTIME_ERROR : : Not able to  : " + actionInfo );
			throw new java.lang.RuntimeException(
					"RUNTIME_ERROR : : Not able to  : " + actionInfo + "--------------->" + e);
		}
		return textvalue;

	}

	public static void setText(String attribute, String attributevalue, String text, String actionInfo) {
		try {
//			dynamicwait.WAitUntilPageLoad();

			//			find the object based on attribute
			switch (attribute.toLowerCase()) {
			case "xpath":
				element = driver.findElement(By.xpath(attributevalue));
				break;
			case "id":
				element = driver.findElement(By.id(attributevalue));
				break;
			case "name":
				element = driver.findElement(By.name(attributevalue));
				break;
			case "linktext":
				element = driver.findElement(By.linkText(attributevalue));
				break;
			case "cssselector":
				element = driver.findElement(By.cssSelector(attributevalue));
				break;
			case "classname":
				element = driver.findElement(By.className(attributevalue));
				break;
			default: 
				logger.log(LogStatus.ERROR, "Failed: Attribute Name {" +attribute+"} Not Found " + actionInfo);
				throw new UnsupportedOperationException();
			}

			Jexecutor.highlightElement(element);
			try{
				element.sendKeys(text);
			}catch(ElementNotVisibleException e1){

				JavascriptExecutor jss=((JavascriptExecutor)driver);
				jss.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(1000);
				element.sendKeys(text);

			}catch(StaleElementReferenceException e2){
				int count=0;
				while(count <4){
					if(element.isDisplayed()){

						element.sendKeys(text);
						break;
					}
					Thread.sleep(1500);
					count++;
				}
			}catch(WebDriverException e3){

				JavascriptExecutor jss=((JavascriptExecutor)driver);
				jss.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(1000);
				element.sendKeys(text);
			}
			System.out.println("Successfully: " + actionInfo);
			logger.log(LogStatus.INFO, "Successfully: "+ actionInfo);
		} catch (Exception e) {
			System.out.println("RUNTIME_ERROR : : Not able to  : " + actionInfo);
			throw new java.lang.RuntimeException("RUNTIME_ERROR : : Not able to  : " + actionInfo +"--------------->"+ e);
		}
	}


	public static void clearSetText(String attribute, String attributevalue, String text,String actionInfo) {
		try {
			dynamicwait.WAitUntilPageLoad();

			//			find the object based on attribute
			switch (attribute.toLowerCase()) {
			case "xpath":
				element = driver.findElement(By.xpath(attributevalue));
				break;
			case "id":
				element = driver.findElement(By.id(attributevalue));
				break;
			case "name":
				element = driver.findElement(By.name(attributevalue));
				break;
			case "linktext":
				element = driver.findElement(By.linkText(attributevalue));
				break;
			case "cssselector":
				element = driver.findElement(By.cssSelector(attributevalue));
				break;
			case "classname":
				element = driver.findElement(By.className(attributevalue));
				break;
			default: 
				logger.log(LogStatus.ERROR, "Failed: Attribute Name {" +attribute+"} Not Found " + actionInfo);
				throw new UnsupportedOperationException();
			}

			Jexecutor.highlightElement(element);
			try{
				element.clear();
				element.sendKeys(text);
			}catch(ElementNotVisibleException e1){

				JavascriptExecutor jss=((JavascriptExecutor)driver);
				jss.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(1000);
				element.clear();
				element.sendKeys(text);

			}catch(StaleElementReferenceException e2){
				int count=0;
				while(count <4){
					if(element.isDisplayed()){
						element.clear();
						element.sendKeys(text);
						break;
					}
					Thread.sleep(1500);
					count++;
				}
			}catch(WebDriverException e3){

				JavascriptExecutor jss=((JavascriptExecutor)driver);
				jss.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(1000);
				element.clear();
				element.sendKeys(text);
			}
			System.out.println("Successfully: " + actionInfo);
			logger.log(LogStatus.INFO, "Successfully: "+ actionInfo);
		} catch (Exception e) {
			System.out.println("RUNTIME_ERROR : : Not able to  : " + actionInfo);
			throw new java.lang.RuntimeException("RUNTIME_ERROR : : Not able to  : " + actionInfo +"--------------->"+ e);
		}

	}

	public static void selectText(String attribute, String attributevalue, String text, String actionInfo) {
		try {
//			dynamicwait.WAitUntilPageLoad();

			//			find the object based on attribute
			switch (attribute.toLowerCase()) {
			case "xpath":
				select = new Select(driver.findElement(By.xpath(attributevalue)));
				Jexecutor.highlightElement(driver.findElement(By.xpath(attributevalue)));
				break;
			case "id":
				select = new Select(driver.findElement(By.id(attributevalue)));
				Jexecutor.highlightElement(driver.findElement(By.id(attributevalue)));
				break;
			case "name":
				select = new Select(driver.findElement(By.name(attributevalue)));
				Jexecutor.highlightElement(driver.findElement(By.name(attributevalue)));
				break;
			case "linktext":
				select = new Select(driver.findElement(By.linkText(attributevalue)));
				Jexecutor.highlightElement(driver.findElement(By.linkText(attributevalue)));
				break;
			case "cssselector":
				select = new Select(driver.findElement(By.cssSelector(attributevalue)));
				Jexecutor.highlightElement(driver.findElement(By.cssSelector(attributevalue)));
				break;
			case "classname":
				select = new Select(driver.findElement(By.className(attributevalue)));
				Jexecutor.highlightElement(driver.findElement(By.className(attributevalue)));
				break;
			default: 
				logger.log(LogStatus.ERROR, "Failed: Attribute Name {" +attribute+"} Not Found ");
				throw new UnsupportedOperationException();
			}
			try{
				select.selectByVisibleText(text);
			}catch(ElementNotVisibleException e1){
				JavascriptExecutor jss= ((JavascriptExecutor)driver);
				element=driver.findElement(By.xpath(attributevalue));
				jss.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(1000);
				select.selectByVisibleText(text);

			}catch(StaleElementReferenceException e2){
				int count=0;
				element=driver.findElement(By.xpath(attributevalue));
				while(count <4){
					if(element.isDisplayed()){

						select.selectByVisibleText(text);
						break;
					}
					Thread.sleep(1500);
					count++;
				}
			}catch(WebDriverException e3){

				JavascriptExecutor jss= ((JavascriptExecutor)driver);
				element=driver.findElement(By.xpath(attributevalue));
				jss.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(1000);
				select.selectByVisibleText(text);
			}
			System.out.println("Successfully: " + actionInfo);
			logger.log(LogStatus.INFO, "Successfully: " + actionInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("RUNTIME_ERROR : : Not able to  : " + actionInfo );
			throw new java.lang.RuntimeException(
					"RUNTIME_ERROR : : Not able to  : " + actionInfo + "--------------->" + e);
		}
	}

	public static void selectTextContain(String attribute, String attributevalue, String text, String actionInfo) {
		try {

//			dynamicwait.WAitUntilPageLoad();

			//			find the object based on attribute
			switch (attribute.toLowerCase()) {
			case "xpath":
				element = driver.findElement(By.xpath(attributevalue));
				break;
			case "id":
				element = driver.findElement(By.id(attributevalue));
				break;
			case "name":
				element = driver.findElement(By.name(attributevalue));
				break;
			case "linktext":
				element = driver.findElement(By.linkText(attributevalue));
				break;
			case "cssselector":
				element = driver.findElement(By.cssSelector(attributevalue));
				break;
			case "classname":
				element = driver.findElement(By.className(attributevalue));
				break;
			default: 
				logger.log(LogStatus.ERROR, "Failed: Attribute Name {" +attribute+"} Not Found ");
				throw new UnsupportedOperationException();
			}

			List<WebElement> elements = element.findElements(By.tagName("option"));

			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getText().contains(text)) {
					elements.get(i).click();
					break;
				}
			}
			System.out.println("Successfully: " + actionInfo);
			logger.log(LogStatus.INFO, "Successfully: " + actionInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("RUNTIME_ERROR : : Not able to  : " + actionInfo );
			throw new java.lang.RuntimeException(
					"RUNTIME_ERROR : : Not able to  : " + actionInfo + "--------------->" + e);
		}
		// return bResult;
	}
	
}
