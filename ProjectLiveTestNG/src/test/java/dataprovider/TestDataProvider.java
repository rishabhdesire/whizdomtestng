package dataprovider;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import utility.Xls_Reader;

public class TestDataProvider {
	//json, xml, xls
	
	static String path = System.getProperty("user.dir")+"\\src\\test\\java\\dataprovider\\Data.xlsx";
	static Xls_Reader xlsData = new Xls_Reader(path);
	static int row;
	static int col;
	
	void getRowColCount()
	{
		row = xlsData.getRowCount("Login Test");
	}
	
	
	@DataProvider
	public static Object[][] dataSuiteA(Method m)
	{
		Object[][] data = null;
			

		if(m.getName().toUpperCase().equals("TESTAA"))
		{
			row = xlsData.getRowCount("Location");
			col = xlsData.getColumnCount("Location");
			data = new Object[row-1][col];//we will set the row and column index at number at run time, as of now hard coded it
			
			for (int i=0;i<row-1;i++)
			{
				for(int j=0;j<col;j++)
				{
					data[i][j] = xlsData.getCellData("Location",j,i+2);
				}
			}
		}
		else if(m.getName().toUpperCase().equals("TESTA"))
		{
			row = xlsData.getRowCount("LoginTest");
			col = xlsData.getColumnCount("LoginTest");
			data = new Object[row-1][col];//we will set the row and column index at number at run time, as of now hard coded it
			
			for (int i=0;i<row-1;i++)
			{
				for(int j=0;j<col;j++)
				{
					data[i][j] = xlsData.getCellData("LoginTest",j,i+2);
				}
			}
			
		}
		else
		{
			row = xlsData.getRowCount("LoginTest");
			col = xlsData.getColumnCount("LoginTest");
			data = new Object[row-1][col];//we will set the row and column index at number at run time, as of now hard coded it
			
			for (int i=0;i<row-1;i++)
			{
				for(int j=0;j<col;j++)
				{
					data[i][j] = xlsData.getCellData("LoginTest",j,i+2);
				}
			}
			
		}
		return data;
		
	}
	
	@DataProvider
	public static Object[][] dataSuiteB(Method m)
	{
		Object data[][] = new Object[2][2];
		data[0][0] = "rowcol_00_TestB_and_BB";
		data[0][1] = "rowcol_01_TestB_and_BB";
		data[1][0] = "rowcol_10_TestB_and_BB";
		data[1][1] = "rowcol_11_TestB_and_BB";
		return data;
		
	}
	
	@DataProvider
	public static Object[][] dataSuiteC(ITestContext context, Method m)
	{
		
		//to run same script with multiple browsers, put below code in datprovider
		String browsers[] = context.getCurrentXmlTest().getParameter("browsers").split(",");
		
		Object data[][] = new Object[2][3];
		data[0][0] = browsers[0];
		data[0][1] = "rowcol_00_TestC_and_CC";
		data[0][2] = "rowcol_01_TestC_and_CC";
		
		data[1][0] = browsers[1];
		data[1][1] = "rowcol_10_TestC_and_CC";
		data[1][2] = "rowcol_11_TestC_and_CC";
		return data;
	}

}
