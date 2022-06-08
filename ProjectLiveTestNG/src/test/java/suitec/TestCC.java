package suitec;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import dataprovider.TestDataProvider;
import testbase.TestBase;

public class TestCC extends TestBase{

	@Test(groups = {"smoke","regression", "browsergroup1"},dataProviderClass = TestDataProvider.class, dataProvider = "dataSuiteC")
	public void testCC(String browser, String dummy1, String dummy2) throws InterruptedException {
		log("Launching on browser" + browser);
		log("Starting CC");
		Thread.sleep(2000);
		log(dummy1+" ---- "+ dummy2);
		log("Ending CC");
	}
}
