package com.sou.Testsample2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

public class Data1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		XSSFWorkbook excelWorkbook = null;
        XSSFSheet excelSheet;
        File excelFile = new File("C:\\username4.xlsx");
        FileInputStream reader = null;

        try {
            reader = new FileInputStream(excelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            excelWorkbook = new XSSFWorkbook(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        excelSheet = excelWorkbook.getSheetAt(0);
        int totalRow = excelSheet.getLastRowNum() + 1;
        int totalCell = excelSheet.getRow(0).getLastCellNum();

        for (int currentRow = 0; currentRow < totalRow; currentRow++) {
        	WebDriver driver=new ChromeDriver();
        	driver.manage().window().maximize();
        	driver.get("https://www.facebook.com//");
        	driver.findElement(By.id("email")).sendKeys(excelSheet.getRow(currentRow).getCell(0).toString());
        	driver.findElement(By.id("pass")).sendKeys(excelSheet.getRow(currentRow).getCell(1).toString());
        	driver.findElement(By.name("login")).click();
        	

try {
	Thread.sleep(300);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
driver.quit();

        	for (int currentCell = 0; currentCell < totalCell; currentCell++) {
                XSSFCell cell = excelSheet.getRow(currentRow).getCell(currentCell);

                if (cell != null) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(String.format("%.0f", cell.getNumericCellValue()));
                    } else {
                        System.out.print(cell.toString());
                    }
                } else {
                    System.out.print("Cell is null");
                }

                System.out.print("\t");
            }
            System.out.println();
        }
        

        try {
            excelWorkbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
