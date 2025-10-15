package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {
	
	WebDriver driver= new ChromeDriver();
	
	
	@BeforeTest
	public void beforeTest() throws InterruptedException
	{
		driver.get("https://automationteststore.com/");
		//Thread.sleep(1000);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void signUp()
	{
//		WebElement signUp=driver.findElement(By.id("customer_menu_top"));
//		signUp.click();
//		WebElement continue1=driver.findElement(By.className("btn btn-orange pull-right"));
//		continue1.click();
		driver.navigate().to("https://automationteststore.com/index.php?rt=account/create");
		WebElement firstName=driver.findElement(By.id("AccountFrm_firstname"));
		firstName.sendKeys("Shireen");
		WebElement lastName=driver.findElement(By.id("AccountFrm_lastname"));
		lastName.sendKeys("Bataineh");
		WebElement email=driver.findElement(By.id("AccountFrm_email"));
		email.sendKeys("she_bata@yahoo.com");
		WebElement telephone=driver.findElement(By.id("AccountFrm_telephone"));
		telephone.sendKeys("0791445979");
		WebElement fax=driver.findElement(By.id("AccountFrm_fax"));
		fax.sendKeys("jhfkduri94085");
		WebElement address1=driver.findElement(By.id("AccountFrm_address_1"));
		address1.sendKeys("Shmeisani");
		WebElement city=driver.findElement(By.id("AccountFrm_city"));
		city.sendKeys("Shmeisani");
		WebElement region=driver.findElement(By.id("AccountFrm_zone_id"));
		region.click();
		region.sendKeys("3514");
		WebElement zipCode=driver.findElement(By.id("AccountFrm_postcode"));
		zipCode.sendKeys("21354");
		WebElement loginName=driver.findElement(By.id("AccountFrm_loginname"));
		loginName.sendKeys("ShireenBata");
		WebElement password=driver.findElement(By.id("AccountFrm_password"));
		password.sendKeys("GHuyklir78@");
		WebElement confirmPassword=driver.findElement(By.id("AccountFrm_confirm"));
		confirmPassword.sendKeys("GHuyklir78@");
		WebElement check=driver.findElement(By.id("AccountFrm_agree"));
		check.click();
		WebElement continue2=driver.findElement(By.xpath("//*[@id=\"AccountFrm\"]/div[5]/div/div/button"));
		continue2.click();
		
		
		
	}
	
	@AfterTest(enabled = false)
	public void Close()
	{
		driver.close();
	}


}
