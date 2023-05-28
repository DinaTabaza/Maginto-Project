import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;


public class SignUp extends Parameters{
	

		@BeforeTest
		public void preTest() throws InterruptedException {
			driver.get(HomePage);
			driver.manage().window().maximize();
		}
		
		
		
	@Test( description = "Test number 1",priority =1)
	public void Success_Signup_Message() throws InterruptedException {

	WebElement Signup = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a"));
	Signup.click();

	// FirstName
	WebElement First_Name = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
	First_Name.sendKeys(FirstName);

	// LastName
	WebElement Last_Name = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
	Last_Name.sendKeys(LastName);

	// CheckBox
	WebElement CheckBox_NewsLetter = driver.findElement(By.id("is_subscribed"));
	if (!CheckBox_NewsLetter.isSelected()) {
		CheckBox_NewsLetter.click();
	}

	// Email
	WebElement Email = driver.findElement(By.xpath("//*[@id=\"email_address\"]"));
	Email.sendKeys(email);

	// Password
	WebElement Password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	Password.sendKeys(password);

	// Confirm Password
	WebElement Confirm_Password = driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
	Confirm_Password.sendKeys(password);
	Thread.sleep(1000);

	// Create an Account Button
	WebElement CreateAccount_Button =
			driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
	CreateAccount_Button.click();
	

	// Assert if The Signup Success
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement Success_Signup_Message = driver
				.findElement(By.className("message"));
		
        String Expected_Success_Signup_Message = "Thank you for registering with Main Website Store.";
     	String Actual_Success_Signup_Message = Success_Signup_Message.getText();
		System.out.println(Actual_Success_Signup_Message);
        Assert.assertEquals(Actual_Success_Signup_Message,Expected_Success_Signup_Message);	


	}
	}
