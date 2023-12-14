package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;




public class ScreenshotUtility {
	private static final String SCREENSHOT_FOLDER = "screenshots";

    public static void takeScreenshot(WebDriver driver, String methodName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String screenshotPath = SCREENSHOT_FOLDER + File.separator + methodName + "_" + timestamp + ".png";

        try {
            Files.createDirectories(Paths.get(SCREENSHOT_FOLDER));
            Path destinationPath = Paths.get(screenshotPath);
            Files.copy(screenshotFile.toPath(), destinationPath);
            Reporter.log("<br> <img src='" + destinationPath.toAbsolutePath().toString() + "' height='300' width='300'/> <br>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
