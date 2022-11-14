package WordpressBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class WordpressBase {
	
	public static AppiumDriver driver;
	public static Properties prop;
    public static FileInputStream reader;
    static DesiredCapabilities cap = new DesiredCapabilities();
    static AppiumDriverLocalService service;
    static URL url;

    public WordpressBase() {

        cap.setCapability("deviceName", "Galaxy A21s");
        cap.setCapability("udid", "R58N607AT9K");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "org.wordpress.android");
        cap.setCapability("appActivity", "org.wordpress.android.ui.WPLaunchActivity");

        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .withAppiumJS(new File("C:\\Users\\martinl\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/"));
        service.start();
        
        try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        
        driver = new AppiumDriver(url, cap);
    }

    public void ServiceStop(){
    	
    	String[] command = { "adb uninstall io.appium.uiautomator2.server & adb uninstall io.appium.uiautomator2.server.test & Taskkill /IM node.exe /F" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        if (service.isRunning() == true){
            service.close();
        }
        
        driver.close();
    }
}
