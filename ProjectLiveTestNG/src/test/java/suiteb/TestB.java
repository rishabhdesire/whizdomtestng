package suiteb;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import dataprovider.TestDataProvider;
import testbase.TestBase;

public class TestB extends TestBase{
	@Test(groups = {"regression", "browsergroup1"}, dataProviderClass = TestDataProvider.class, dataProvider = "dataSuiteB")
	public void testB(String dummy1, String dummy2) throws InterruptedException {
		log("Starting B");
		Thread.sleep(2000);
		log(dummy1+" ---- "+ dummy2);
		log("Ending B");
	}
}
