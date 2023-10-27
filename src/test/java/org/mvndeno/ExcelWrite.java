package org.mvndeno;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws IOException {
		File file = new File(
				"C:\\Users\\Lenovo\\eclipse-workspace\\" 
		+ "MavenSepAdv\\src\\test\\resources\\Data3.xlsx");
		
		File file2 = new File("");
		
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);

		// Access a existing sheet in workbook
		Sheet sheet = workbook.getSheet("Login Data");
		// Create a new sheet in workbook
		Sheet createSheet = workbook.createSheet("Data");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			// Access the row in existing sheet
			Row row = sheet.getRow(i);
			// Create a row in new sheet
			Row createRow = createSheet.createRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				// Access the cell in existing row
				Cell cell = row.getCell(j);
				// Create a cell in new row
				Cell createCell = createRow.createCell(j);

				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					String value = cell.getStringCellValue();
					createCell.setCellValue(value);
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						createCell.setCellValue(dateCellValue);
					} else {
						double numericCellValue = cell.getNumericCellValue();
						long data = (long) numericCellValue;

						if (numericCellValue == data) {
							createCell.setCellValue(data);
						} else {
							createCell.setCellValue(numericCellValue);
						}

					}
					break;
				case BOOLEAN:
					boolean booleanCellValue = cell.getBooleanCellValue();
					createCell.setCellValue(booleanCellValue);
					break;
				default:
					break;
				}

			}
			
		}
		
		FileOutputStream outputStream = new FileOutputStream(file2);
		workbook.write(outputStream);
	}
}
