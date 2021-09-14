package Qualicoach_EditUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Chrome Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://test.qualicoach.org/login/index.php");
		driver.findElement(By.id("username")).sendKeys("user91");
		driver.findElement(By.id("password")).sendKeys("User@7014");
		driver.findElement(By.id("loginbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"action-menu-toggle-0\"]/span/span/span/img")).click();
		driver.findElement(By.xpath("//span[@id='actionmenuaction-2']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Edit profile')]")).click();
		driver.findElement(By.id("id_firstname")).clear();
		driver.findElement(By.id("id_firstname")).sendKeys("TEST");
		driver.findElement(By.id("id_lastname")).clear();
		driver.findElement(By.id("id_lastname")).sendKeys("USER1");
		// driver.findElement(By.id("id_email")).clear();
		// driver.findElement(By.id("id_email")).sendKeys("USER1@qualitest.com");
		driver.findElement(By.id("id_maildisplay"));
		WebElement Email_display = driver.findElement(By.id("id_maildisplay"));
		Select Email_display_DD = new Select(Email_display);
		Email_display_DD.selectByIndex(0);
		driver.findElement(By.id("id_city")).clear();
		driver.findElement(By.id("id_city")).sendKeys("User1_city");
		WebElement Country = driver.findElement(By.id("id_country"));
		Select CountryDD = new Select(Country);
		CountryDD.selectByValue("IN");
		WebElement TimeZone = driver.findElement(By.id("id_timezone"));
		Select TimeZone_DD = new Select(TimeZone);
		TimeZone_DD.selectByValue("UTC");
		driver.findElement(By.id("id_submitbutton")).click();
	}
}
