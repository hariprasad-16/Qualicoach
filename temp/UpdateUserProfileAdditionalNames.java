package qualicoach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DashBoardPage;
import pageObjects.EditProfile;
import pageObjects.LoginPage;
import pageObjects.UserProfile;
import resources.Base;

public class UpdateUserProfileAdditionalNames extends Base {
	
	WebDriver driver = null;
	@BeforeTest
	public void testLogin() {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void EditUserAdditionalNames()
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
		editProfile.getAdditionalName().click();
		editProfile.getFirstNamePhonetic().clear();
		editProfile.getFirstNamePhonetic().sendKeys("first-name-phonetic");
		editProfile.getLastNamePhonetic().clear();
		editProfile.getLastNamePhonetic().sendKeys("last-name-phonetic");
		editProfile.getMiddleName().clear();
		editProfile.getMiddleName().sendKeys("middle-name");
		editProfile.getAlternateName().clear();
		editProfile.getAlternateName().sendKeys("Test-User-No1");
		editProfile.getUpdateProfileButton().click();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
