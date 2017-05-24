package CommonDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonDriver {


	private WebDriver Driver;
	private long setPageLoadTimmeout;
	private long elementDetectionTimeout;

	public CommonDriver() {
		
		setPageLoadTimmeout = 90l;
		elementDetectionTimeout = 40l;
	}

	public void setSetPageLoadTimmeout(long setPageLoadTimmeout) {
		this.setPageLoadTimmeout = setPageLoadTimmeout;
	}

	public void setElementDetectionTimeout(long elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	public void invokeBrowser (String browserType, String url) throws Exception{
		
		browserType= browserType.trim();
		url = url.trim();
		
		if(browserType.equalsIgnoreCase("chrome") || browserType.equalsIgnoreCase("google")|| browserType.equalsIgnoreCase("google chrome")){
			
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
			
			Driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("mozilla") || browserType.equalsIgnoreCase("firefox")|| browserType.equalsIgnoreCase("mozilla firefox")){
			
			System.setProperty("webdriver.gekodriver.driver", "");
			
			Driver = new FirefoxDriver();
		}else{
			
			throw new Exception("Invalid Browser Type : "+ browserType);
			}
		}
	
	
	
}

