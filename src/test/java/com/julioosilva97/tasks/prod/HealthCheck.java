package com.julioosilva97.tasks.prod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HealthCheck {
	
	@Test
	public void healthCheck() throws MalformedURLException {
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver =  new RemoteWebDriver(new URL("http://189.124.128.210:4444/wd/hub"),cap);
		
		try {
			driver.navigate().to("http://189.124.128.210:9999/tasks/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String version = driver.findElement(By.id("version")).getText();
			Assert.assertTrue(version.startsWith("build"));
			
		}finally {
			driver.quit();
		}
		
	}
	
	
	 

}