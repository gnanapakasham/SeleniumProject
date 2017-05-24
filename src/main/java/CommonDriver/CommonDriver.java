package CommonDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonDriver {

	private WebDriver Driver;
	private long setPageLoadTimmeout;
	private long elementDetectionTimeout;

	public static Logger LOGGER = Logger.getLogger(CommonDriver.class.getName());

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

	public void invokeBrowser(String browserType, String url) throws Exception {

		browserType = browserType.trim();
		url = url.trim();

		if (browserType.equalsIgnoreCase("chrome") || browserType.equalsIgnoreCase("google")
				|| browserType.equalsIgnoreCase("google chrome")) {

			LOGGER.info("Set chrome driver path and initialize chrome driver");

			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");

			Driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("mozilla") || browserType.equalsIgnoreCase("firefox")
				|| browserType.equalsIgnoreCase("mozilla firefox")) {

			LOGGER.info("Set chrome driver path and initialize chrome driver");
			System.setProperty("webdriver.gekodriver.driver", "");

			Driver = new FirefoxDriver();
		} else {

			throw new Exception("Invalid Browser Type : " + browserType);
		}

		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().setScriptTimeout(setPageLoadTimmeout, TimeUnit.SECONDS);
		Driver.manage().timeouts().setScriptTimeout(elementDetectionTimeout, TimeUnit.SECONDS);
		Driver.get(url);

	}

}
