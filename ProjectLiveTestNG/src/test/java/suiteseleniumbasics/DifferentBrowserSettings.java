package suiteseleniumbasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import testbase.TestBase;

public class DifferentBrowserSettings extends TestBase{
	
//	@Test(groups = {"smoke","regression"})
//	public void BrowsersOptions()
//	{
//		LaunchBrowser("edge");
////		driver.get("http://facebook.com");
//		System.out.println(driver.getTitle());
//		
//		
//		//for ie certicaite issue
//		driver.get("https://expired.badssl.com/");//eg certificate
//		System.out.println(driver.getTitle());
////		driver.get("javascript:document.getElementById('overridelink').click();");
//		
//	}
//	
//	@Test(groups = {"smoke"})
//	public void TC1()
//	{
//		LaunchBrowser("chrome");
//		driver.get("https://www.cnn.com/");
//		driver.findElement(By.cssSelector("li[class*='More'][type=collapsed]")).click();
//	}
	
	@Test(groups = {"smoke"})
	public void TC2() throws InterruptedException
	{
		//not working application is in correct
//		LaunchBrowser("chrome");
//		driver.get("https://mdbootstrap.com/docs/standard/extended/multiselect/");
//		WebElement multiSelect = driver.findElement(By.cssSelector("section#section-basic-example select"));
//		Select sel = new Select(multiSelect);
////		sel.selectByVisibleText("One");
////		sel.selectByVisibleText("Three");
//		
//
//		//sel.deselectAll();
//		//sel.selectByValue("1");
//		Thread.sleep(20000);
//		driver.findElement(By.cssSelector("section#section-basic-example span.select-arrow")).click();
//		List<WebElement> options = driver.findElements(By.cssSelector("section#section-basic-example option"));
//		for(WebElement option : options){
//			if(option.getAttribute("innerText").equals("Two")) {
//				Actions a = new Actions(driver);
//				a.moveToElement(option).click().build().perform();
//				//option.click();
//			}
//	
//		}
		
		
		LaunchBrowser("chrome");
		log("Browser Launch");
//		driver.get("https://demoqa.com/select-menu");
//		WebElement multi = driver.findElement(By.cssSelector("select#cars"));
//		Select optionssel = new Select(multi);
//		optionssel.selectByValue("volvo");
//		optionssel.selectByValue("audi");
//		
//		driver.findElement(By.cssSelector("#selectMenuContainer > div:nth-child(7) > div > div > div > div.css-1wy0on6 > div")).click();
//		List<WebElement> coloroptions = driver.findElements(By.cssSelector("div[class*=option]"));
//		String[] colvalues = {"Blue","Black"};
//		List<String> col = new ArrayList<String>(Arrays.asList(colvalues));
//		coloroptions.forEach(coloropt ->{			
//			if(col.contains(coloropt.getAttribute("innerText")))
//			{
//				coloropt.click();
//			}
//		});
//		
//		for(int i=0;i<col.size();i++)
//		{
//			String val = "//div[contains(@class,'multiValue')]//div[text()='"+col.get(i)+"']/following-sibling::div";
//			driver.findElement(By.xpath(val)).click();
//			Thread.sleep(1000);
//		}
//		
		
		driver.get("https://google.com");
		driver.findElement(By.cssSelector("input[title=Search]")).sendKeys("Hello");
		Thread.sleep(10000);
		String listcont = "div[role=presentation]:nth-child(1) ul";
		List<WebElement> searchlist = driver.findElements(By.xpath("//li[@role='presentation']"));
		for(int i=1;i<=searchlist.size();i++)
		{
			WebElement item = driver.findElement(By.xpath("//li[@role='presentation']["+i+"]/div/div[2]/div[1]/span"));
			String act = item.getAttribute("innerText");
			System.out.println(act);
			if(item.getAttribute("innerText").equalsIgnoreCase("hello google"))
				item.click();
				log("Able to navigate to new page");
		}
		
		
	}
	
}
