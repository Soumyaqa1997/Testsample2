package com.sou.Testsample2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngDAta {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
    }

    @Test(dataProvider = "loginData")
    public void loginToFacebook(String username, String password) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        //String excelFilePath = "C:\\username4.xlsx";
        FileInputStream inputStream = new FileInputStream("C:\\username4.xlsx");
        XSSFWorkbook excelWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet excelSheet = excelWorkbook.getSheetAt(0);


        int rowCount = excelSheet.getPhysicalNumberOfRows();
        int colCount = excelSheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][2]; // 2 parameters for loginToFacebook

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
