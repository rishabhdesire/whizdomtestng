package suitea;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.TestBase;

public class TestAA extends TestBase{

	@Test(groups = {"sanity", "regression", "browsergroup2"}, dataProviderClass = TestDataProvider.class, dataProvider = "dataSuiteA")
	public void testAA(String user, String location) throws InterruptedException {
		log("Starting AA");
		Thread.sleep(2000);
		log(user +" ----- "+ location);
		log("Ending AA");
	}
}
