/**
 * The BoardGameGeekTest.java file test the functionality such as login to app, redirect to collection, click on collection.
 *
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-07-15
 */



package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import config.Config;
import pages.BoardgamegeekHomePO;

import utility.LaunchApp;

public class BoardGameGeekTest {

	private StringBuffer verificationErrors = new StringBuffer();


	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		LaunchApp la=new LaunchApp();
		la.waitTillPageLoaded(30);
		//Config.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Parameters({"username","password"})
	@Test
	public void BoardGameGeekOperation(String username,String password) 
	{

		BoardgamegeekHomePO objBoardGame=new BoardgamegeekHomePO();
		objBoardGame.loadBoardgamegeekHomePO();
		objBoardGame.clickOnSignHome();
		objBoardGame.enterUserName(username);
		objBoardGame.enterPassword(password);
		objBoardGame.clickOnSignIn();
		objBoardGame.clickOnUsername();
		Assert.assertEquals(Config.driver.findElement(By.linkText("Collection")).getText(), "Collection");
		objBoardGame.clickOnCollection();
		objBoardGame.highestRating();
		objBoardGame.clickOnGameLink();

		Assert.assertEquals(Config.driver.getTitle(), "Among the Stars | Board Game | BoardGameGeek");
	}

	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		Config.driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			AssertJUnit.fail(verificationErrorString);
		}
	}

}
