package suitec;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import dataprovider.TestDataProvider;
import testbase.TestBase;

public class TestC extends TestBase{

	@Test(groups = {"smoke", "browsergroup2"}, dataProviderClass = TestDataProvider.class, dataProvider = "dataSuiteC")
	public void testC(String browser, String dummy1, String dummy2) throws InterruptedException {
		log("Launching on browser" + browser);
		log("Starting C");
		Thread.sleep(2000);
		log(dummy1+" ---- "+ dummy2);
		log("Ending C");
	}
}
