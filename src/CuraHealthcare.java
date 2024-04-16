import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CuraHealthcare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// setup
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// open home page
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		WebElement toggle_menu = driver.findElement(By.id("menu-toggle"));
		WebElement toggle_menu_Login = driver.findElement(By.cssSelector("a[href='profile.php#login']"));
		toggle_menu.click();
		toggle_menu_Login.click();

		try {
			Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/profile.php#login", driver.getCurrentUrl());
		} catch (AssertionError e) {
			System.out.println("Login Failed!!!");
		}

		// access elements of login page
		WebElement username = driver.findElement(By.id("txt-username"));
		WebElement password = driver.findElement(By.id("txt-password"));
		WebElement login = driver.findElement(By.id("btn-login"));

		// enter login data
		username.sendKeys("John Doe");
		password.sendKeys("ThisIsNotAPassword");
		login.click();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://katalon-demo-cura.herokuapp.com/#appointment";
		try {
			Assert.assertEquals(actualUrl, expectedUrl);
		} catch (AssertionError e) {
			System.out.println("login failed!!!");
		}

	}

}
