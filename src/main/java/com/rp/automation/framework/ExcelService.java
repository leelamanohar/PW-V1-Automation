package com.rp.automation.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * ExcelService class
 * 
 * @author PW TA Team
 */
public class ExcelService {

	/**
	 * readTestDataFromExcel method
	 * 
	 * @param sWorkBookName
	 * @param sWorkbookSheetName
	 * @return
	 */
	public Iterator<Object[]> readTestDataFromExcel(String sWorkBookName, String sWorkbookSheetName) {
		String testDataFolderPath = WebDriverBase._prop.getString("root_folder");

		List<HashMap<String, String>> testData = null;
		for (File testDataFile : new File(testDataFolderPath).listFiles()) {
			if (!testDataFile.getAbsolutePath().contains("$")) {
				FileInputStream file = null;
				if (testDataFile.getPath().contains(sWorkBookName)) {
					try {
						file = new FileInputStream(testDataFile);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					Workbook workBook = null;
					try {
						workBook = WorkbookFactory.create(file);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InvalidFormatException e) {
						e.printStackTrace();
					}
					Sheet testDataSheet = workBook.getSheet(sWorkbookSheetName);
					testData = getTestDataBySheet(testDataSheet);

				}
			}

		}
		return getIterator(testData);
	}

	/**
	 * getTestDataBySheet method
	 * 
	 * @param testDataSheet
	 * @return testData
	 */
	public List<HashMap<String, String>> getTestDataBySheet(Sheet testDataSheet) {
		List<String> headers = getHeaders(testDataSheet);
		List<HashMap<String, String>> testData = new ArrayList<HashMap<String, String>>();
		for (int i = 1; i < testDataSheet.getPhysicalNumberOfRows(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			Row dataRow = testDataSheet.getRow(i);
			Cell dataCell;
			for (int j = 0; j < headers.size(); j++) {
				try {
					dataCell = dataRow.getCell(j);
					dataCell.setCellType(Cell.CELL_TYPE_STRING);
					map.put(headers.get(j), dataCell.getStringCellValue());

				} catch (Exception e) {

				}
			}
			testData.add(map);

		}
		return testData;
	}

	/**
	 * getIterator class
	 * 
	 * @param testDataList
	 * @return iteratorList
	 */
	@SuppressWarnings("rawtypes")
	public Iterator<Object[]> getIterator(List<HashMap<String, String>> testDataList) {
		List<Object[]> iteratorList = new ArrayList<Object[]>();
		for (Map map : testDataList) {
			iteratorList.add(new Object[] { map });
		}

		return iteratorList.iterator();

	}

	/**
	 * getHeaders method
	 * 
	 * @param sheet
	 * @return headers
	 */
	public List<String> getHeaders(Sheet sheet) {

		List<String> headers = new ArrayList<String>();
		Row headerRow = sheet.getRow(0);
		for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
			Cell dataCell = headerRow.getCell(i);
			dataCell.setCellType(Cell.CELL_TYPE_STRING);
			headers.add(dataCell.getStringCellValue());
		}
		return headers;
	}

}
