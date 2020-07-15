/**
 * The LaunchApp.Java utility is used to launch the browser, open the url, maximize browser , wait etc.
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-07-15
 */

package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.Config;

public class LaunchApp {

	Properties prop =new Properties();

	public void openBrowser(String browsernm) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
		prop.load(fis);

		if(prop.getProperty("browser").equalsIgnoreCase(browsernm))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeexepath"));
			Config.driver =new ChromeDriver();
			System.out.println("Chrome browser is opened successfully");

		}
		else if(prop.getProperty("browser").equalsIgnoreCase(browsernm))
		{
			System.setProperty("webdriver.gecko.driver", "firefoxexepath");
			Config.driver=new FirefoxDriver();
			System.out.println("Firefox browser opened successfully");
		}

		else
		{
			System.out.println("Incorrect browsername parameter passed");
		}
	}

	public void enterApplicationURL(String urlnm)
	{
		Config.driver.get(urlnm);
	}

	public void maximizeBrowser()
	{
		Config.driver.manage().window().maximize();	
	}

	public void waitTillPageLoaded(int timeoutsec)
	{
		Config.driver.manage().timeouts().implicitlyWait(timeoutsec, TimeUnit.SECONDS);
	}



}
