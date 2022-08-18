package com.walgreens.qa.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.walgreens.qa.commons.CommonFunctions;
import com.walgreens.qa.commons.CommonWaits;
import com.walgreens.qa.objects.CancelRegistration;
import com.walgreens.qa.objects.HomePage;
import com.walgreens.qa.objects.Registration;
import com.walgreens.qa.utils.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Configuration configuration = new Configuration(null);

	protected WebDriver driver;
	WebDriverWait wait;

	protected CommonFunctions commons;
	CommonWaits waits;
	protected Registration registration;
	protected HomePage homePage;
	protected CancelRegistration cancelRegistration;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		driver = localDriver(browser);
		driver.manage().window().maximize();
		driver.get(configuration.getConfig("url"));
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfig("pageloadWait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfig("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.getConfig("explicitWait"))));

		initClasses();
	}

	private WebDriver localDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	protected WebDriver getDriver() {
		return driver;
	}

	private void initClasses() {
		waits = new CommonWaits(wait);
		commons = new CommonFunctions(waits);
		homePage = new HomePage(driver, commons);
		registration = new Registration(driver, commons);
		cancelRegistration = new CancelRegistration(driver, commons);
	}

	@AfterMethod
	public void terminate() {
		driver.quit();
	}

}
