package com.flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewOffers {

	public static WebDriver driver;
	
	@DataProvider(name="from")
	public Object[][] sendText() {
		return new Object[][] {{"Guduvanchery",1}};
	}
	
	@DataProvider(name="to")
	public Object[][] sendText1() {
		return new Object[][] {{"Chengalpattu"}};
	}
	
@Parameters({"browser"}) 
@BeforeClass(groups="i")
public void launch_the_redBus(String b) {
	
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	System.out.println("driver launched");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://www.redbus.in/");
}


@BeforeMethod(groups="i")
public void method() {
	System.out.println("before method");
}

@BeforeSuite(groups="i")
public void beforeSuite() {
	System.out.println("Suite Before");
}

@AfterSuite(groups="i")
public void afterSuite() {
	System.out.println("Suite after");
}

@BeforeTest(groups="i")
public void beforeTest() {
	System.out.println("Test Before");
}

@AfterTest(groups="i")
public void afterTest() {
	System.out.println("Test After");
}


@AfterMethod(groups="i")
public void method1() {
	System.out.println("after method");
}

@Test(dataProvider="from",groups="sanity")
public void enter_the_from_place(String a, int i) {
	WebElement from = driver.findElement(By.xpath("//input[@id='src']"));
	from.click();
	from.sendKeys(a);
	System.out.println(i);
	WebElement place = driver.findElement(By.xpath("//div[contains(@class,'bSzhQs')]//text"));
	place.click();
}

@Test(dependsOnMethods = "enter_the_from_place",dataProvider = "to",groups="sanity")
public void enter_the_to_place(String b) {
	WebElement to = driver.findElement(By.id("dest"));
	to.click();
	String	toPlace = b;
	to.sendKeys(toPlace);
	
	WebElement place = driver.findElement(By.xpath("//text[text()='"+toPlace+"']"));
	place.click();
}


@Parameters({"mock","intern"})
@Test
public void select_the_date_in_calendar(@Optional("parle") String par,@Optional("new Optional Value")String nem) throws InterruptedException {
	WebElement date = driver.findElement(By.xpath("//span[text()='Date']"));
	date.click();
	System.out.println(par+nem);
	Thread.sleep(5000);
	WebElement calendar = driver.findElement(By.xpath("//div[@class='sc-jzJRlG dPBSOp-']"));
	Actions a = new Actions(driver);
	
	a.moveToElement(calendar, 4, 3).build().perform();
	a.click(calendar).build().perform();
}

@Test
public void click_on_searchbuses() {
	WebElement search = driver.findElement(By.id("search_button"));
	search.click();
	SoftAssert sa = new SoftAssert();	
}

@AfterClass(groups="i")
public void close() {
	
//	driver.quit();
}

}

