package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void browserLaunch(String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}

	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static WebElement findingElement(String locator, String value) {
		if (locator.equals("id")) {
			WebElement element = driver.findElement(By.id(value));
			return element;
		} else if (locator.equals("name")) {
			WebElement element = driver.findElement(By.name(value));
			return element;
		}else if (locator.equals("xpath")) {
			WebElement element = driver.findElement(By.xpath(value));
			return element;
		} else {
			return null;
		}
	}

	public static void passValue(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public static void elementClick(WebElement ele) {
		ele.click();
	}

	public static String elementText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	public static String excelRead(File file, String sheetName, int rowNo, int cellNo) throws IOException {
		String value = "";
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYY");
				value = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long data = (long) numericCellValue;
				if(data==numericCellValue) {
					value = Long.toString(data);
				} else {
					value = Double.toString(numericCellValue);
				}
				
			}
			break;
		case BOOLEAN:
			boolean booleanCellValue = cell.getBooleanCellValue();
			value = Boolean.toString(booleanCellValue);
			break;
		default:
			break;
		}
		return value;
	}
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	public static void screenshot(File file) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, file);
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
	public static void refreshPage() {
		driver.navigate().refresh();
	}
	
	public static void dropDown(WebElement element,String selectBy,String input) {
		
		Select select = new Select(element);
		
		switch (selectBy) {
		case "index":
			select.selectByIndex(Integer.parseInt(input));
			break;
		case "value":
			select.selectByValue(input);
			break;
		case "text":
			select.selectByVisibleText(input);
			break;

		default:
			break;
		}
		
	}
	
	public static String getAtributeValue(WebElement ele,String attribute) {
		String attribute2 = ele.getAttribute(attribute);
		return attribute2;
	}
	
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

}
