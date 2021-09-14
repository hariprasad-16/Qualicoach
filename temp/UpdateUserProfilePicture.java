package qualicoach;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DashBoardPage;
import pageObjects.EditProfile;
import pageObjects.LoginPage;
import pageObjects.UserProfile;
import resources.Base;
public class UpdateUserProfilePicture extends Base {

	WebDriver driver = null;
	@BeforeTest
	public void testLogin() {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void EditUserPicture() throws InterruptedException
	{
		driver.get("https://test.qualicoach.org/my/");

		// login page
		LoginPage login = new LoginPage(driver);
		login.getUserName().sendKeys("user91");
		login.getPassword().sendKeys("User@7014");
		login.getLoginButton().click();

		// click on user picture
		DashBoardPage dashboard = new DashBoardPage(driver);
		dashboard.getUserPhoto().click();

		// click on profile option
		dashboard.getProfileOption().click();

		// click on edit Profile
		UserProfile userProf = new UserProfile(driver);
		userProf.getEditProfile().click();
		EditProfile editProfile = new EditProfile(driver);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", editProfile.getAddFile());
		//editProfile.getAddFile().click();
		editProfile.getPicDesc().clear();
		editProfile.getPicDesc().sendKeys("User Profile Picture");
		editProfile.getUpdateProfileButton().click();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
