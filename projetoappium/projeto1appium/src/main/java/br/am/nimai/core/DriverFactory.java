package br.am.nimai.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	
	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			createDriverSauceLabs();
		}
		return driver;
	}

	private static void createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\nimai\\Downloads\\instagram.apk");
	    desiredCapabilities.setCapability("appPackage", "com.instagram.android");
	    desiredCapabilities.setCapability("appActivity", "com.instagram.mainactivity.LauncherActivity");
	    try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	private static void createDriverSauceLabs() {
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:app", "storage:filename=instagram.apk");  // The filename of the mobile app
		caps.setCapability("appium:deviceName", "Samsung Galaxy S6 GoogleAPI Emulator");
		caps.setCapability("appium:platformVersion", "8.0");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:appPackage", "com.instagram.android");
		caps.setCapability("appium:appActivity", "com.instagram.mainactivity.LauncherActivity");
		// "message": "An unknown server-side error occurred while processing the command. Original error: Cannot start the 'com.instagram.android' application. Visit https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/android/activity-startup.md for troubleshooting. Original error: 'com.instagram.android.activity.MainTabActivity' or 'com.instagram.android.com.instagram.android.activity.MainTabActivity' never started. Visit https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/android/activity-startup.md for troubleshooting",
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", Properties.username);
		sauceOptions.setCapability("accessKey", Properties.accessKey);
		sauceOptions.setCapability("build", "appium-build-3BL8S");
		sauceOptions.setCapability("name", "automation testing");
		sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
		caps.setCapability("sauce:options", sauceOptions);
		
	    try {
			driver = new AndroidDriver<MobileElement>(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
