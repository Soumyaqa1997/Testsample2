package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLoginPage1 {
	 private WebDriver driver;
	    private By emailField = By.id("email");
	    private By passwordField = By.id("pass");
	    private By loginButton = By.name("login");

	    public FacebookLoginPage1(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void navigateToLoginPage(String url) {
	        driver.get(url);
	    }

	    public void enterUsername(String username) {
	        driver.findElement(emailField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLoginButton() {
	        driver.findElement(loginButton).click();
	    }

	    public void login(String username, String password) {
	        enterUsername(username);
	        enterPassword(password);
	        clickLoginButton();
	    }
}
