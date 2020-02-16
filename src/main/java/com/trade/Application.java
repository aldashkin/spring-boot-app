package com.trade;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
		File excelFile = new File("BTC.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIt = sheet.iterator();

		while (rowIt.hasNext()){
			Row row =rowIt.next();
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()){
				Cell cell = cellIterator.next();
				System.out.println(cell.toString() + ";");
			}
			System.out.println();
		}
		workbook.close();
		fis.close();

//		FileInputStream fis = new FileInputStream("C:/Users/work/Desktop/spring-boot-app/spring-boot-app/primer.xls");
//		Workbook wb = new HSSFWorkbook(fis);
//		String result = wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
//		System.out.println(result);
//
//		System.out.println(getCellText(wb.getSheetAt(0).getRow(0).getCell(1)));
//
//		fis.close();
//
//	}
//
//	public static String getCellText(Cell cell){
//
//		String result="";
//
//		switch (cell.getCellType()) {
//			case Cell.CELL_TYPE_STRING:
//				result = cell.getRichStringCellValue().getString();
//				break;
//			case Cell.CELL_TYPE_NUMERIC:
//				if (DateUtil.isCellDateFormatted(cell)) {
//					result = cell.getDateCellValue().toString();
//				} else {
//					result = Double.toString(cell.getNumericCellValue());
//				}
//				break;
//			case Cell.CELL_TYPE_BOOLEAN:
//				result = Boolean.toString(cell.getBooleanCellValue());
//				break;
//			default:
//				break;
//		}
//		return result;
	}
}