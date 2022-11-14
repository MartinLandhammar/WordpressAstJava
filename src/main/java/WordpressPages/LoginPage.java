package WordpressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import WordpressBase.WordpressBase;

public class LoginPage extends WordpressBase {

	WebElement continueButton;
	WebElement emailInput;
	WebElement continueButton2;
	WebElement passwordInput;
	WebElement okButton;

    public void Login(String email, String password) throws InterruptedException{
    	continueButton = driver.findElement(By.ByXPath.id("org.wordpress.android:id/continue_with_wpcom_button"));
        continueButton.click();
        emailInput = driver.findElement(By.ByXPath.id("org.wordpress.android:id/input"));
        emailInput.sendKeys(email);
        continueButton2 = driver.findElement(By.ByXPath.id("org.wordpress.android:id/login_continue_button"));
        continueButton2.click();
        Thread.sleep(1000);
        passwordInput = driver.findElement(By.ByXPath.id("org.wordpress.android:id/input"));
        passwordInput.sendKeys(password);
        okButton = driver.findElement(By.ByXPath.id("org.wordpress.android:id/bottom_button"));
        okButton.click();
    }

}
