package DatadrivernApachePoi;

import java.io.IOException;

import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;




import BasePage.BaseClass1;


import org.testng.ITestListener;

import page.FacebookLoginPage1;
import utility.ExcelUtility;
import utility.TestListener;


@Listeners(TestListener.class)
public class FacebookLoginTest extends BaseClass1 {
	private FacebookLoginPage1 facebookLoginPage;

    @BeforeMethod
    public void setUpTest() {
        setUp();
        facebookLoginPage = new FacebookLoginPage1(driver);
        facebookLoginPage.navigateToLoginPage("https://www.facebook.com");
    }

    @Test(dataProvider = "loginData")
    public void loginToFacebookTest(String username, String password) {
        facebookLoginPage.login(username, password);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
        
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        String excelFilePath = "C:\\username4.xlsx";
        return ExcelUtility.readExcelData(excelFilePath);
    }
}
