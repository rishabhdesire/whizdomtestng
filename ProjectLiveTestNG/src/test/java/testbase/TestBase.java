package testbase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

public class TestBase {
	
	public ExtentReports rep;
	public ExtentTest test;
	public SoftAssert softAssert;
	public String browser;
	public WebDriver driver;
	
	@BeforeMethod (alwaysRun = true)
	public void init(ITestContext context, ITestResult result)
	{
		rep = ExtentManager.getReports();
		test = rep.createTest(result.getMethod().getMethodName().toUpperCase());
		result.setAttribute("report", test);
		softAssert = new SoftAssert();
		//Init if only one browser
//		browser = context.getCurrentXmlTest().getParameter("browser");
//		System.out.println("Current Browser:--- " + browser);
		//if multiple browser basisi browser group.
		String groupNames[] = context.getAllTestMethods()[0].getGroups();
		String browserGroup = "";
		for(String grp : groupNames)
		{
			if(grp.startsWith("browsergroup"))
			{
				browserGroup = grp;
				break;
			}
		}
		System.out.println("Browser Group Name is:---" + browserGroup);
		browser = context.getCurrentXmlTest().getParameter(browserGroup);
		System.out.println(browser);
		
		
		//to run same script with multiple browsers, put below code in datprovider
		//String browsers[] = context.getCurrentXmlTest().getParameter("browsers").split(",");
		
		
		
	
		
		
	}
	
	@AfterMethod (alwaysRun = true)
	public void quit()
	{
		rep.flush();
		
	}
	
	public void log(String msg)
	{
		System.out.println(msg);
		test.log(Status.INFO, msg);
	}
	
	public void FailAndStop(String msg)
	{
		test.log(Status.FAIL, msg);
		softAssert.fail(msg);;
		softAssert.assertAll();
	}
	
	public void softAssert(String msg)
	{
		test.log(Status.FAIL, msg);
		softAssert.fail(msg);
	}
	
	public void LaunchBrowser(String browser)
	{
		//options = (options != null) ? "good" : null;//self written by me no logic
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			//to generate log
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "logs\\chrome.log");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			chromeOptions.addArguments("--disable-notifications");
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("ignore-certificate-errors");
			
			//pageload yes same as firefox
			//set binary pth same as firefox
			
			//Proxy (import not run below code else it will update your proxy system setting, only use for projects
			////chromeOptions.addArguments("--proxy-server=http://89.2765.292.2:9090");
			
			
			//profile (path: type chrome://version on google logged account)
			//chromeOptions.addArguments("user-data-dir=C:\\Users\\risha\\AppData\\Local\\Google\\Chrome\\User Data");
			
			//for some other profile to load, you need to create a default first, This is some crude solution to do so
			//watch video
			
			driver = new ChromeDriver(chromeOptions);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//to generate logs
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "logs\\firefox.log"); //to create respective driver log files
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			//options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); //use incase firefox is not running changes of use is 1% only
			//pageloadstrategy
			firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);//will teach in further videos
			
			//Profile
			ProfilesIni allProfile = new ProfilesIni();
			FirefoxProfile prof= allProfile.getProfile("Jun2022");//Keys: Win + run-> firefox.exe -p profilemanager (Note: please exit firefox from menu-> exit option only)
			//to manage notification
			prof.setPreference("dom.webnotifications.enabled", false); //Type about:config in firefox to see all keys
			// to manage ssl
			prof.setAcceptUntrustedCertificates(true);
			prof.setAssumeUntrustedCertificateIssuer(false);
			//Proxy
			//prof.setPreference("network.proxy.type", 1);
			//prof.setPreference("network.proxy.socks", "83.876.52.211");//dummy only not work	
			//prof.setPreference("network.proxy.socks_port", 1827);//dummy only not work
			firefoxOptions.setProfile(prof);
				
			driver = new FirefoxDriver(firefoxOptions);
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			//no setting for notification
			//no binary set
			//no profile
			//yes page load, proxy and certifcate
			
//			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
//			
//			DesiredCapabilities cap = new DesiredCapabilities();
//			
//			String proxy = "82.122.287.22:8080";
//			Proxy p = new Proxy();
//			p.setAutodetect(false);
//			p.setProxyType(ProxyType.MANUAL);
//			p.setSocksProxy(proxy);
//			
//			cap.setCapability(CapabilityType.PROXY, p);
//
//			ieOptions.merge(cap);
//	
//			driver = new InternetExplorerDriver(ieOptions);
			
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "logs\\ie.logs");
			//System.setProperty("webdriver.ie.driver", "C:\\Selenium\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
			//to overcome certificate challege
//			driver.get("https://expired.badssl.com/");//eg certificate
//			driver.get("javascript:document.getElementById('overridelink').click();");// standard code
			
		}else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY, "logs\\edge.log");
			//System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--disable-notifications");
			edgeOptions.addArguments("--start-maximized");
			edgeOptions.addArguments("ignore-certificate-errors");
			
			//pageload yes same as firefox
			//set binary pth same as firefox
			
			//Proxy (import not run below code else it will update your proxy system setting, only use for projects
			////chromeOptions.addArguments("--proxy-server=http://89.2765.292.2:9090");
			
			//profile same as chrome
			driver = new EdgeDriver(edgeOptions);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public boolean isElementPresent(By locator)
	{
		try{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	//https://stackoverflow.com/questions/51322201/cant-select-multiple-dropdown-with-selenium-webdriver-not-class-select
	public void selectOption(WebDriver driver, String optionName, By selector) {
    List<WebElement> options = driver.findElements(selector);
    for (WebElement option: options)
    {
            if (option.getAttribute("innerText").equals(optionName)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(option).click().build().perform();
            }
    }
    }
}
