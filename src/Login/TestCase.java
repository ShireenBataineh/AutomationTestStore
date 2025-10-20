package Login;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {
	
	WebDriver driver= new ChromeDriver();
	Random rand=new Random();
	
	String [] FNames= {"Shireen","Khawla","Reta","Mera","Roaa","Mary","Sewar"};
	int num1=rand.nextInt(FNames.length);
	
	String [] LNames= {"Abdullah","Mohammad","Zaid","Ahmad","Anas"};
	int num2=rand.nextInt(LNames.length);
	
	int randNumForLloginName=rand.nextInt(555);
	
	String LN=FNames[num1]+LNames[num2]+randNumForLloginName;
	
	int passInt=rand.nextInt(555);
	String passStr="GHuyklir78@"+passInt+"!"+"";

	
	@BeforeTest
	public void beforeTest() throws InterruptedException
	{
		driver.get("https://automationteststore.com/");
		//Thread.sleep(1000);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1, enabled=true)
	public void signUp() throws InterruptedException
	{
//		WebElement signUp=driver.findElement(By.id("customer_menu_top"));
//		signUp.click();
//		WebElement continue1=driver.findElement(By.className("btn btn-orange pull-right"));
//		continue1.click();
		driver.navigate().to("https://automationteststore.com/index.php?rt=account/create");
		
		//FirstName
		WebElement firstName=driver.findElement(By.id("AccountFrm_firstname"));
		firstName.sendKeys(FNames[num1]);
		
		//LastName
		WebElement lastName=driver.findElement(By.id("AccountFrm_lastname"));
		lastName.sendKeys(LNames[num2]);
		
		//Email
		String email=FNames[num1]+LNames[num2]+rand.nextInt(500)+"@gmail.com";
		WebElement emailInput=driver.findElement(By.id("AccountFrm_email"));
		emailInput.sendKeys(email);
		
		//Telephone
		int tele=rand.nextInt(1000000000);
		String telle=""+tele;
		WebElement telephone=driver.findElement(By.id("AccountFrm_telephone"));
		telephone.sendKeys(telle);
		
		//Fax
		int fax=rand.nextInt(100000);
		String faxS=""+fax;
		WebElement faxInput=driver.findElement(By.id("AccountFrm_fax"));
		faxInput.sendKeys(faxS);
		
		//Address1
		String [] address= {"Shmeisani44","Abdoun55","Sweileh66","AboNuseir77","Khalda88","Gardens99"};
		int address1=rand.nextInt(address.length);
		WebElement addressInput=driver.findElement(By.id("AccountFrm_address_1"));
		addressInput.sendKeys(address[address1]);
		
		//City
		String [] City= {"Aamman","Irbid","Aqaba","Tafileh","Madaba","Salt","Mafraq","Ajloun","Jerash"};
		int num4=rand.nextInt(City.length);
		WebElement cityInput=driver.findElement(By.id("AccountFrm_city"));
		cityInput.sendKeys(City[num4]);
		
		//Country
		WebElement country=driver.findElement(By.id("AccountFrm_country_id"));
		Select countryS=new Select(country);
		int countrySize=country.findElements(By.tagName("option")).size();
		int randomValue1=rand.nextInt(1,countrySize);
		countryS.selectByIndex(randomValue1);
		
		Thread.sleep(1000);		
		//Region/ State
		WebElement region=driver.findElement(By.xpath("//select[@id='AccountFrm_zone_id']"));
		Select regionS=new Select(region);
		int regionSize=region.findElements(By.tagName("option")).size();
		int randomValue2=rand.nextInt(1,regionSize);
		regionS.selectByIndex(randomValue2);
		
		//ZipCcode
		int zip=rand.nextInt(10000);
		String zipStr=""+zip;
		WebElement zipCode=driver.findElement(By.id("AccountFrm_postcode"));
		zipCode.sendKeys(zipStr);
		
		//LoginName
		WebElement loginName=driver.findElement(By.id("AccountFrm_loginname"));
		loginName.sendKeys(LN);
		
		//Password
		WebElement password=driver.findElement(By.id("AccountFrm_password"));
		password.sendKeys(passStr);
		
		//ConfirmPassword
		WebElement passwordC=driver.findElement(By.id("AccountFrm_confirm"));
		passwordC.sendKeys(passStr);
		
		//CheckBox
		WebElement check=driver.findElement(By.id("AccountFrm_agree"));
		check.click();
		
		//Conitnue Button
//		WebElement continue2=driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
//		continue2.click();
		//OR BY cssSelectot
		WebElement continue2=driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
		continue2.click();
		
		
	}
	
	@Test(priority=2, enabled=true)
	public void Logout()
	{
				WebElement logout=driver.findElement(By.linkText("Logoff"));
				logout.click();
				
				WebElement continueLogout=driver.findElement(By.linkText("Continue"));
				continueLogout.click();
	}
	
	@Test(priority=3, enabled=true)
	public void login() throws InterruptedException
	{
//		WebElement login=driver.findElement(By.xpath("//a[normalize-space()='Login or register']"));
//		login.click();
		//OR BY LinkText
		WebElement login=driver.findElement(By.partialLinkText("Login or registe"));
		login.click();
		
		WebElement loginName=driver.findElement(By.id("loginFrm_loginname"));
		loginName.sendKeys(LN);
		
		WebElement passwordLogin=driver.findElement(By.id("loginFrm_password"));
		passwordLogin.sendKeys(passStr);
		
		WebElement loginButton=driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		loginButton.click();
	}
	
	@Test(priority=4, invocationCount = 11)
	public void addToCart()
	{
		driver.navigate().to("https://automationteststore.com/");
		
		//Specific Items
//		WebElement prod1=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/a[1]"));
//		prod1.click();
//		driver.findElement(By.xpath("//section[@id='bestseller']//div[2]//div[2]//a[1]//img[1]")).click();
//		WebElement radioBut=driver.findElement(By.id("option344750"));
//		radioBut.click();
//		WebElement prod2=driver.findElement(By.xpath("//a[normalize-space()='Add to Cart']"));
//		prod2.click();
		
		//Random Items
		List <WebElement> products1=driver.findElements(By.className("prdocutname"));
		int size=products1.size();
		int randomSize=rand.nextInt(size);
		products1.get(randomSize).click();
		WebElement div=driver.findElement(By.className("tab-content"));
		WebElement radioContainer = driver.findElement(By.className("control-label"));

	    // Check if the radio container is displayed
	    if (radioContainer.isDisplayed()) {
	        WebElement radioButton = driver.findElement(By.id("option344750"));
	        radioButton.click();
			driver.findElement(By.xpath("//a[normalize-space()='Add to Cart']")).click();
}

	        else if(div.getText().contains("Out of Stock"))
			driver.navigate().back();
		else
			driver.findElement(By.xpath("//a[normalize-space()='Add to Cart']")).click();
		
	}
	
	@Test(priority=5, enabled=true)
	public void Checkout() throws InterruptedException
	{
		WebElement checkout=driver.findElement(By.xpath("//a[@id='cart_checkout1']"));
		checkout.click();
		WebElement confirmOrder=driver.findElement(By.id("checkout_btn"));
		confirmOrder.click();
		Thread.sleep(2000);
		WebElement Continue=driver.findElement(By.cssSelector(".btn.btn-default.mr10"));
		Continue.click();
		
	}
	
	@AfterTest(enabled = true)
	public void Close()
	{
		driver.close();
	}


}
