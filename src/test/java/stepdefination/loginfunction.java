package stepdefination;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginfunction {
	
	WebDriver driver;
	
	@Given("openbrowser and enter url")
	public void openbrowser_and_enter_url() {
		driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");
	
	}

	
	@When("user enter valid username")
	public void user_enter_valid_username() {
     WebElement   username=driver.findElement(By.id("Email"));
     username.clear();
     username.sendKeys("admin@yourstore.com");
	}
	
	@And("user enter vlaid password")
	public void user_enter_vlaid_password() {
		WebElement   password=driver.findElement(By.id("Password"));
		password.clear();
		password.sendKeys("admin");
	}
	
	@When("user click on loginButton")
	public void user_click_on_loginButton() {
	WebElement	btn=driver.findElement(By.xpath("//button[@type='submit']"));
	btn.click();
	}
	
	@Then("it should naviagte to dashboardpage")
	public void it_should_naviagte_to_dashboardpage() {
		String actualvalue=driver.getTitle();
		String Expectedvalue="Dashboard / nopCommerce administration";
		Assert.assertEquals(Expectedvalue, actualvalue);
	}
	
	
	@When("user enter invalid username")
	public void user_enter_invalid_username() {
		 WebElement   username=driver.findElement(By.id("Email"));
	     username.clear();
	     username.sendKeys("abc123@gmail.com");
	}

	@When("user enter invalid password")
	public void user_enter_invalid_password() {
		WebElement   password=driver.findElement(By.id("Password"));
		password.clear();
		password.sendKeys("abc123456");
	}

	@Then("it should throw error message as No customer account found")
	public void it_should_throw_error_message_as_No_customer_account_found() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	 WebElement erromessage= driver.findElement(By.xpath("//li[contains(text(),'No customer account found')]"));
	          String actualvalue=erromessage.getText();
	          String expectedValue="No customer account found";
	          Assert.assertEquals(expectedValue, actualvalue);
	}
	
	
	@Then("it should throw error message as The credentials provided are incorrect")
	public void it_should_throw_error_message_as_The_credentials_provided_are_incorrect() {
		 WebElement erromessage= driver.findElement(By.xpath("//li[contains(text(),'The credentials provided are incorrect')]"));
         String actualvalue=erromessage.getText();
         String expectedValue="The credentials provided are incorrect";
         Assert.assertEquals(expectedValue, actualvalue);
         
	}

	@When("user click on login button without credentials")
	public void user_click_on_login_button_without_credentials() {
		WebElement	btn=driver.findElement(By.xpath("//button[@type='submit']"));
		btn.click();
	}

	@Then("it should throw error message as Please enter your email")
	public void it_should_throw_error_message_as_Please_enter_your_email() {
	  WebElement error=  driver.findElement(By.xpath("//span[@id=\"Email-error\"]"));
	     String Actualvalue=error.getText();
	     String Expectedvalue="Please enter your email";
	     Assert.assertEquals(Expectedvalue, Actualvalue);
	}
	
	 @When("user Keep username and password Fields as empty")
	 public void  When_user_Keep_username_and_password_Fields_as_empty() {
		 WebElement   username=driver.findElement(By.id("Email"));
		 WebElement   password=driver.findElement(By.id("Password"));
		 username.clear();
		 password.clear();
	 }

}
