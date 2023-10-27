package org.mvndeno;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;

public class Sample extends BaseClass{
	public static void main(String[] args) throws IOException {
		
		browserLaunch("chrome");
		loadUrl("https://www.facebook.com/");
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\"
						+ "MavenSepAdv\\src\\test\\resources\\Data.xlsx");
		String userName = excelRead(file, "Sheet1", 1, 1);	
		String password = excelRead(file, "Sheet1", 2, 1);	
		passValue(findingElement("id","email"), userName);		
		passValue(findingElement("id","pass"), password);
		
		WebElement loginButton = findingElement("name","login");
		//elementClick(loginButton);
		
	}
}
