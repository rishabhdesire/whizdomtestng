package suitea;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.TestBase;

public class TestA extends TestBase {
		
	@Test(groups = {"smoke", "sanity", "regression","Login","browsergroup1"},dataProviderClass = TestDataProvider.class, dataProvider = "dataSuiteA")
	public void Login(String runmode, String browser, String userName, String password) throws InterruptedException {
		log("Starting Login");
		Thread.sleep(2000);
		log(runmode +" ---- "+ browser +" ---- "+ userName +" ---- "+ password);
		log("Ending Login");
		if(browser.equals("Chrome"))
		{
			softAssert("On Chrome Login is failing");
			softAssert.assertAll();
		}
	}
	
	@Test(groups = {"regression","Purchase","browsergroup1"},dataProviderClass = TestDataProvider.class, dataProvider = "dataSuiteA")
	public void Purchase(String runmode, String browser, String userName, String password) throws InterruptedException {
		log("Starting Purchasing");
		Thread.sleep(2000);
		log(runmode +" ---- "+ browser +" ---- "+ userName +" ---- "+ password);
		log("Ending Purchasing");
	}

}
