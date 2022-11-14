package WordpressTestcases;

import org.junit.Test;
import org.testng.annotations.AfterMethod;

import WordpressPages.LoginPage;

public class LoginTest extends LoginPage{
	
	@Test
	public void Login() throws InterruptedException {

		Login("mlandham@yahoo.se", "Zzaj20372");
	}
	
	@AfterMethod
	public void TearDown() {
		ServiceStop();
	}
}
