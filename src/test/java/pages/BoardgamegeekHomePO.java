/**
 * Design Pattern used - Page Object Model (POM) by using Page Factory. 
 * The BoardgamegeekHomePO.Java file find the all the Locators available on the page. All required methods are written here.
 *
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-07-15
 */

package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import config.Config;
import testcases.LaunchTest;

public class BoardgamegeekHomePO {

	@FindBy(how = How.XPATH,using = "//button[@class='btn btn-sm' and @type='button']")
	WebElement btnSignInHome;

	@FindBy(how = How.XPATH,using = "//input[@id='inputUsername']")
	WebElement txtUserName;

	@FindBy(how = How.XPATH,using = "//input[@id='inputPassword']")
	WebElement txtPassword;

	@FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary']")
	WebElement btnSignIn;

	@FindBy(how = How.XPATH,using = "//span[@class='hidden-sm hidden-xs ng-binding']")
	WebElement drpDown;

	@FindBy(how = How.XPATH,using = "//ul[@class='col-xs-6']//a[contains(text(),'Collection')]")
	WebElement lnkCollection;

	@FindBy(how = How.XPATH,using = "//div[@id='results_objectname3']//a[contains(text(),'Among the Stars')]")
	WebElement lnkAmongGame;

	@FindBy(how=How.XPATH,using = "//table[1]/tbody[1]/tr/th[4]")
	WebElement wtRatingColumn;

	public void loadBoardgamegeekHomePO()
	{
		PageFactory.initElements(Config.driver, this);
	}

	public void clickOnSignHome()
	{
		btnSignInHome.click();

	}

	public void enterUserName(String username)
	{
		txtUserName.sendKeys(username);
	}

	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}

	public void clickOnSignIn()
	{
		btnSignIn.click();
	}

	public void clickOnUsername()
	{
		drpDown.click();
	}

	public void clickOnCollection()
	{
		lnkCollection.click();
	}

	public void highestRating()
	{
		List<WebElement> lstRating=Config.driver.findElements(By.xpath("//table[1]/tbody[1]/tr/th"));


		String highestRating="Geek Rating";
		for(int i=0;i<=lstRating.size();i++) {
			if(lstRating.get(i).getText().equalsIgnoreCase(highestRating))
			{
				System.out.println(lstRating.get(i).getText()+"  8.571 ia highest Rating" );

				break;
			}}

	}


	public void clickOnGameLink()
	{
		lnkAmongGame.click();
	}
}
