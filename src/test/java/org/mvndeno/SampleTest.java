package org.mvndeno;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SampleTest {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\" + "MavenSepAdv\\src\\test\\resources\\Data.xlsx");

		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(3);

		CellType cellType = cell.getCellType();
		System.out.println(cellType);

		DataFormatter dataFormatter = new DataFormatter();
		String formatCellValue = dataFormatter.formatCellValue(cell);
		System.out.println(formatCellValue);
		
//		if (cellType == CellType.NUMERIC) {
//			if (DateUtil.isCellDateFormatted(cell)) {
//				Date date = cell.getDateCellValue();
//				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
//				String format = dateFormat.format(date);
//				System.out.println(format);
//			} else {
//				double numericCellValue = cell.getNumericCellValue();
//				long data = (long) numericCellValue;
//				if (data == numericCellValue) {
//					System.out.println(data);
//				} else {
//					System.out.println(numericCellValue);
//				}
//
//			}
//		}

//		

	}
}
