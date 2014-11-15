package com.generic.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;
import com.generic.property.mgr.PropertyManager;

public class ReadExcel {

    private static final Properties EXCELRELATIVEPATH = PropertyManager
            .loadApplicationPropertyFile("application.properties");
    private static final Logger LOGGER = Logg.createLogger();
    private static String[][] storage;
    private static Sheet sheet = null;

    private ReadExcel() {
    }

    private static int getColumnCount(Sheet sheet) throws IOException {
        int colCount = 0;
        Row row = sheet.getRow(0);
        colCount = row.getPhysicalNumberOfCells();

        LOGGER.info("column count for a Row " + colCount);
        return colCount;
    }

    public static String[][] readTestData(String sheetName) throws IOException,
            InvalidFormatException {
        try {
            FileInputStream file = new FileInputStream(new File(
                    EXCELRELATIVEPATH.getProperty("excelPath")));

            // Create Workbook instance , could be HSSF OR XSSF depending on the
            // argument file
            Workbook workbook = WorkbookFactory.create(file);
            // Get first sheet from the workbook
            sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = getColumnCount(sheet);
            storage = new String[rowCount][colCount];

            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    storeValuesIn2DArray(cell, i, j);
                }
            }
            file.close();

        } catch (FileNotFoundException fException) {
            LOGGER.error("FileNotFoundException in the readTestData() method of ReadExcel Class");
            throw fException;
        } catch (NoSuchElementException noElementException) {
            LOGGER.error("NoSuchElementException in the readTestData() method of ReadExcel Class");
            throw noElementException;
        } catch (IOException ioException) {
            LOGGER.error("IOException in the readTestData() method of ReadExcel Class");
            throw ioException;
        } catch (InvalidFormatException invalidFormatException) {
            LOGGER.error("InvalidFormatException in the readTestData() method of ReadExcel Class");
            throw invalidFormatException;
        }
        return storage;
    }

    private static void storeValuesIn2DArray(Cell cell, int i, int j) {
        if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
            LOGGER.info("Cell Contains value " + cell.getNumericCellValue());
            storage[i][j] = String.valueOf(cell.getNumericCellValue());
        } else if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
            LOGGER.info("Cell Contains value " + cell.getStringCellValue());
            storage[i][j] = cell.getStringCellValue();
        }
    }
}
