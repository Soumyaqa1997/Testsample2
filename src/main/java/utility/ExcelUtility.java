package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static Object[][] readExcelData(String filePath) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\username4.xlsx");
        XSSFWorkbook excelWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet excelSheet = excelWorkbook.getSheetAt(0);

        int rowCount = excelSheet.getPhysicalNumberOfRows();
        int colCount = excelSheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][2];

        for (int i = 1; i < rowCount; i++) {
            String username = excelSheet.getRow(i).getCell(0).toString();
            String password = excelSheet.getRow(i).getCell(1).toString();
            data[i - 1] = new Object[]{username, password};
        }

        excelWorkbook.close();
        inputStream.close();

        return data;
    }

}
