package com.flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TopOffers {

	public static WebDriver driver;
	
@BeforeClass
public static void method1() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		System.out.println("driver launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
	System.out.println("precondition");
	
}
@AfterClass
public static void close() {
	System.out.println("post conditions");
}



@Test
public void method2() {
	System.out.println("second");
}

@Test
public void method3() {
	System.out.println("third");

	
}

@Test
public void method4() {
	System.out.println("fourth");
	String name = "udaya";
	String name2 = "Udaya";
	
}


}
