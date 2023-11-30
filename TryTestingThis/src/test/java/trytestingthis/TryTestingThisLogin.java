package trytestingthis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TryTestingThisLogin {

	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		// TODO Auto-generated constructor stub
		 //initialization
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		driver.get("https://trytestingthis.netlify.app/");
		driver.manage().window().maximize();
	}
	
	//name: Nolak Kapali--gender: female--dropdown:option3--checklist:option3
	@Test(priority=0)
	public void input() {
		/*Login
		FirstName*/
		driver.findElement(By.id("fname")).sendKeys("Nolak");
		driver.findElement(By.id("lname")).sendKeys("Kapali");
		
		//choose gender-female
		WebElement genderbtn= driver.findElement(By.id("female"));
		genderbtn.click();
		
		//choose option 3 from dropdown single option
		WebElement singledrop = driver.findElement(By.id("option"));
		Select dropdown = new Select (singledrop);
		dropdown.selectByValue("option 3");
		
		
		//choose option 3 from checklist
		WebElement checklist =driver.findElement(By.name("option3"));
		checklist.click();
		
		//fill up empty field
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/fieldset/input[9]")).sendKeys("biscuits");
        //upload file
		driver.findElement(By.xpath("//input[@id=\"myfile\"]")).sendKeys("C:\\Users\\HP\\Downloads\\image.jpg");
        //CSS selector-submitbutton
		driver.findElement(By.cssSelector("button.btn")).click();

	}
	
	@AfterTest
	 public void endLogin()
	 {
	  driver.quit();
	 }

}
