package suiteb;

import org.testng.annotations.Test;

import dataprovider.TestDataProvider;
import testbase.TestBase;

public class TestBB extends TestBase{
	@Test(groups = {"sanity", "browsergroup2"}, dataProviderClass = TestDataProvider.class, dataProvider = "dataSuiteB")
	public void testBB(String dummy1, String dummy2) throws InterruptedException {
		log("Starting BB");
		if(!("Text1").equals("Text"))
			softAssert("Soft Assert: Values are not equal");
		log("continue after softasert");
		if(!("Text1").equals("Text2"))
			softAssert("Soft Assert: Other Values are not equal");
		log("continue after second softasert");
		Thread.sleep(2000);
		log(dummy1+" ---- "+ dummy2);
		if(!("Text1").equals("Text2"))
			FailAndStop("Hard Assert: Other Values are not equal");
		log("Ending BB");
		//Assert.fail("Error Caught in Application");
		softAssert.assertAll();
	}

}
