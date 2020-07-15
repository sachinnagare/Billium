/**
 * The LaunchTest.Java file will use LaunchApp object and parameters are passed from textng.xml file
 * 
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-07-15
 */

package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.LaunchApp;

public class LaunchTest {
	@Parameters({"browser","urlnm","timeoutsec"})
	@Test
	public void executeLaunch(String browsernm, String urlnm, int timeoutsec) throws Exception
	{
		LaunchApp objla=new LaunchApp();
		objla.openBrowser(browsernm);
		objla.enterApplicationURL(urlnm);
		objla.maximizeBrowser();
		objla.waitTillPageLoaded(timeoutsec);

	}

}
