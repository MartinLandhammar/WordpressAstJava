package WordpressTestcases;

import org.junit.Test;
import org.testng.annotations.AfterTest;
import WordpressPages.LoginPage;

public class LoginTest extends LoginPage{
	
	@Test
	public void Login() throws InterruptedException {

		Login("mlandham@yahoo.se", "Zzaj20372");
	}
	
	@AfterTest
	public void TearDown() {
		ServiceStop();
	}
}
