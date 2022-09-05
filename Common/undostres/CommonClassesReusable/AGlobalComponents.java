package undostres.CommonClassesReusable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AGlobalComponents {

	public static String FilePath =System.getProperty("user.dir")+"\\Browser_Files\\ConfigRise.txt";
	public static String commonData = "properties\\commonData.properties";
	public static String extentDate = new SimpleDateFormat("dd_MM_yyyy hh_mm_ss").format(new Date());
	public static String currentDateLoggr = new SimpleDateFormat("dd_MM_yyyy_hhmmss").format(new Date());
	public static String extentReportScreenshotFolder = System.getProperty("user.dir") + "\\ExtentReport\\Output\\Screenshots\\";
	public static String extentReportPath = System.getProperty("user.dir") + "\\ExtentReport\\Output\\Report.html";	
	public static boolean jsExecutor = true;	
	public static String AttachmentFile = System.getProperty("user.dir") + "\\Browser_Files\\upload.csv";

	

	/* Credentials */
	public static String browserName ="GC";	
	
	public static String applicationURL = "https://prueba.undostres.com.mx/";
		
	}
