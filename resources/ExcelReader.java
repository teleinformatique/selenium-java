package utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelReader {
    private String filePath;
    private String sheetName;
    public ExcelReader(String filePath, String sheetName) {
        this.filePath = filePath;
        this.sheetName = sheetName;
    }
    private XSSFSheet getSheet() throws IOException {
        FileInputStream fis = new FileInputStream(filePath);

        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFWorkbook test = new XSSFWorkbook();

        XSSFSheet sheet = wb.getSheet(sheetName);

        return sheet;
    }
    public int totalRowCount() throws IOException {
        var sheet = getSheet();
        int rowCount = sheet.getLastRowNum();
        return rowCount;
    }
    public String getCellValue(int rowNum, int columnNum) throws IOException {
        var sheet = getSheet();
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(columnNum);
        String value = getCellValueAsString(cell);
        return value;
    }
    public String getSheetName(int index) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        String sheet = workbook.getSheetName(index);

        return sheet;
    }
    public int getSheetCount() throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        int sheetCount = workbook.getNumberOfSheets();
        return sheetCount;
    }
    public int totolColumnCount() throws IOException {
        var sheet = getSheet();
        Row row = sheet.getRow(0);
        int lastColumnNum = row.getLastCellNum();
        return lastColumnNum;
    }
    public String getCellValueAsString(Cell cell) {
        String cellValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue= cell.getCellFormula();
            case BLANK:
                cellValue="BLANK";
            default:
                cellValue ="DEFAULT";
        }
        return cellValue;
    }

    public Map<String, String> getRowData(String id) throws IOException {
        var sheet = getSheet();
        XSSFRow row;
        XSSFCell cell;
        Map<String, String> data = new HashMap<String, String>();

        Iterator rows = sheet.rowIterator();

        var header = sheet.getRow(0);
        while (rows.hasNext())
        {
            row=(XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext())
            {
                cell=(XSSFCell) cells.next();
                if(cell.getStringCellValue().equalsIgnoreCase(id)){
                    XSSFRow row1 = cell.getRow();
                    for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
                        data.put(header.getCell(i).getStringCellValue(), row1.getCell(i).getStringCellValue());
                    }
                    break;
                }

            }

        }
        return data;
    }
}
