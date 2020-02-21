package browser;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser extends Driver {

	public final String BROWSERUSED = "chrome";
	public final String MODEEXECUTIONHEADLESS = "headless";
	public final String MODEEXECUTIOWINDOWVISIBLE = "start-maximized";
	public WebDriver driver;
	private final String URL = "https://shopcart-challenge.4all.com/";

	public Browser() {
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	@Override
	public void startBrowser(String browserName, String executionMode) {

		int count = 0;

		while (count <= 10) {
			count++;

			if (browserName.equals("chrome")) {
				try {

					System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chrome\\chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments(executionMode, "--ignore-certificate-errors");
					driver = new ChromeDriver(options);
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					break;
					
				} catch(Exception msgError) {
					msgError.printStackTrace();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					continue;
				}
			}

			if (browserName.equals("firefox")) {
				// TODO Auto-generated method stub
			}

			if (browserName.equals("iexplore")) {
				// TODO Auto-generated method stub
			}

			if (browserName.equals("opera")) {
				// TODO Auto-generated method stub
			}
		}
	}

	@Override
	public void openUrl() {
		driver.get(URL);

	}

	public String getBROWSERUSED() {
		return BROWSERUSED;
	}

	public String getMODEEXECUTIONHEADLESS() {
		return MODEEXECUTIONHEADLESS;
	}

	public String getMODEEXECUTIOWINDOWVISIBLE() {
		return MODEEXECUTIOWINDOWVISIBLE;
	}
	
	

}
