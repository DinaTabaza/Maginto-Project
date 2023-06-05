import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parameters {

	@BeforeTest
	public void preTest() throws InterruptedException {
		driver.get(HomePage);
		driver.manage().window().maximize();

	}

	// Signup
	@Test(description = "Test number 1", priority = 1)
	public void Success_Signup() throws InterruptedException {

		driver.get(SignupPage);

		// FirstName
		WebElement First_Name = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
		First_Name.sendKeys(firstNameList[RandomIndex]);

		// LastName
		WebElement Last_Name = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
		Last_Name.sendKeys(lastNameList[RandomIndex]);

		// CheckBox
		WebElement CheckBox_NewsLetter = driver.findElement(By.id("is_subscribed"));
		if (!CheckBox_NewsLetter.isSelected()) {
			CheckBox_NewsLetter.click();
		}

		// Email
		WebElement Email = driver.findElement(By.xpath("//*[@id=\"email_address\"]"));
		Email.sendKeys(EmailUser + RandomIndexForEmail + EmailComplete);
		TheEmailToLogin = EmailUser + RandomIndexForEmail + EmailComplete;

		// Password
		WebElement Password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		Password.sendKeys(Mutualpassword);

		// Confirm Password
		WebElement Confirm_Password = driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
		Confirm_Password.sendKeys(Mutualpassword);
		Thread.sleep(1000);

		// Create an Account Button
		WebElement CreateAccount_Button = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
		CreateAccount_Button.click();

		// Assert if The Signup Success
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement Success_Signup_Message = driver.findElement(By.className("message"));

		String Expected_Success_Signup_Message = "Thank you for registering with Main Website Store.";
		String Actual_Success_Signup_Message = Success_Signup_Message.getText();
		// System.out.println(Actual_Success_Signup_Message);
		Assert.assertEquals(Actual_Success_Signup_Message, Expected_Success_Signup_Message);

		Thread.sleep(3000);
		driver.get(SignOut);
	}

	// SignIn
	@Test(description = "Test number 2", priority = 2)
	public void Login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(LoginPage);

		// Email
		WebElement Email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		Email.sendKeys(TheEmailToLogin);

		// Password
		WebElement Password = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		Password.sendKeys(Mutualpassword);

		Thread.sleep(1000);
		// SignInButton
		WebElement SignIn_Button = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
		SignIn_Button.click();
		Thread.sleep(3000);
	}

//	// Send Items randomly via Search Bar 
//	@Test( description = "Test number 3",priority =3)
//	public void Search_Items_Randomly() {
//		
//		WebElement Search_Bar_For_ITems = driver.findElement(By.xpath("//*[@id=\"search\"]"));
//		String[] Items = { "Jacket", "t-shirt", "jeans for men", "jeans for women", "pants" };
//		int RandomItemIndex=rand.nextInt(0,5);
//
//		Search_Bar_For_ITems.sendKeys(Items[RandomItemIndex] + Keys.ARROW_DOWN + Keys.ENTER);
//		System.out.println(Items[RandomItemIndex]);
//}
//----------------------------------------------------------------------------------------

	// Add Five Items To The Cart
	@Test(description = "Test number 4", priority = 4)
	public void Add_Items() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		for (int i = 0; i < URL_Items.length; i++) {
			driver.get(URL_Items[i]);

			// Radiant Tee Item
			if (driver.getCurrentUrl().contains("tee")) {
				// List Of Sizes
				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> Sizes = SizesBox.findElements(By.tagName("div"));
				
				// Select Random Size
				int RandomSizeIndex = rand.nextInt(0, Sizes.size());
				Sizes.get(RandomSizeIndex).click();
				
				// List Of Colors
				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = ColorBox.findElements(By.tagName("div"));

				// Select Random Color
				int RandomColorIndex = rand.nextInt(0, Colors.size());
				Colors.get(RandomColorIndex).click();

				// Select Quintity
				WebElement Quintyt = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quintyt.clear();
				Quintyt.sendKeys("3");

				WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToCartButton.click();
				Thread.sleep(1000);

				// Breathe-Easy Tank
			} else if (driver.getCurrentUrl().contains("easy")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

				// List Of Sizes
				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> Sizes = SizesBox.findElements(By.tagName("div"));
				
				// Select Random Size
				int RandomSizeIndex = rand.nextInt(0, Sizes.size());
				Sizes.get(RandomSizeIndex).click();
				
				// List Of Colors
				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = ColorBox.findElements(By.tagName("div"));
				
				// Select Random Color
				int RandomColorIndex = rand.nextInt(0, Colors.size());
				Colors.get(RandomColorIndex).click();

				WebElement Quintyt = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quintyt.clear();
				Quintyt.sendKeys("2");
				WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToCartButton.click();
				Thread.sleep(1000);

			}

			// Argus All-Weather Tank Item
			else if (driver.getCurrentUrl().contains("weather")) {
				
				// List Of Sizes
				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> Sizes = SizesBox.findElements(By.tagName("div"));
				
				// Select Random Size
				int RandomSizeIndex = rand.nextInt(0, Sizes.size());
				Sizes.get(RandomSizeIndex).click();
				
				// List Of Colors
				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = ColorBox.findElements(By.tagName("div"));

				// Select Random Color
				int RandomColorIndex = rand.nextInt(0, Colors.size());
				Colors.get(RandomColorIndex).click();

				WebElement Quintyt = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quintyt.clear();
				Quintyt.sendKeys("4");
				WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToCartButton.click();
				Thread.sleep(1000);

				// Hero Hoodie Item
			} else if (driver.getCurrentUrl().contains("hoodie")) {
				
				// List Of Sizes
				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> Sizes = SizesBox.findElements(By.tagName("div"));
				
				// Select Random Size
				int RandomSizeIndex = rand.nextInt(0, Sizes.size());
				Sizes.get(RandomSizeIndex).click();

				
				// List Of Colors
				WebElement ColorBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = ColorBox.findElements(By.tagName("div"));
				
				// Select Random Color
				int RandomColorIndex = rand.nextInt(0, Colors.size());
				Colors.get(RandomColorIndex).click();

				WebElement Quintyt = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quintyt.clear();
				Quintyt.sendKeys("1");
				WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToCartButton.click();
				Thread.sleep(1000);

			}
			// fusion-backpack Item
			else if (driver.getCurrentUrl().contains("fusion")) {

				WebElement Quintyt = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quintyt.clear();
				Quintyt.sendKeys("5");
				WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToCartButton.click();
				Thread.sleep(1000);
			}
		}

	}

	// Fill The Info And Complete The Process Of Shipping The Address
	@Test(description = "Test number 5", priority = 5)
	public void Checkout_Process() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(CheckoutPage);

		// Company_name
		WebElement Company_name = driver.findElement(By.name("company"));
		Company_name.sendKeys("Amazon");

		// Street_Address
		WebElement Street_Address = driver.findElement(By.name("street[0]"));
		Street_Address.sendKeys("Amman");

		// cityName
		WebElement cityName = driver.findElement(By.name("city"));
		cityName.sendKeys("Amman");

		// select_Region
		WebElement region = driver.findElement(By.name("region_id"));
		Select selector = new Select(region);
		selector.selectByIndex(RandomIndex);
		
		// Postal_code
		WebElement Postal_code = driver.findElement(By.name("postcode"));
		Postal_code.sendKeys("12345");

		// Phone_Number
		WebElement PhoneNum = driver.findElement(By.name("telephone"));
		PhoneNum.sendKeys("0795646019");

		// Shipping Method
		WebElement ShippingMethods = driver.findElement(By.name("ko_unique_4"));
		ShippingMethods.click();
		Thread.sleep(2000);
		
		// Next Button
		WebElement NextButton = driver
				.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"));
		NextButton.click();

	}
}
//
//	// Check The final Price
//	@Test(description = "Test number 6", priority = 6)
//	public void Placeorder() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		WebElement placeorder_Button = driver.findElement(
//				By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"));
//
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		jsExecutor.executeScript("arguments[0].click();", placeorder_Button);
//	}
//
//	@Test(description = "Test number 7", priority = 7)
//	public void Total_Of_Invoice_Number() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//		WebElement Invoice_Number_Link = driver
//				.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a"));
//		Invoice_Number_Link.click();
//
//		WebElement ThePricesInFooter = driver.findElement(By.tagName("tfoot"));
//		List<WebElement> ThePrices = ThePricesInFooter.findElements(By.className("price"));
//
//		String Subtotal = ThePrices.get(0).getText();
//		double IntegerSubtotal = Double.parseDouble(Subtotal.replaceAll("[^0-9.]", ""));
//
//		String Discount = ThePrices.get(1).getText();
//		double IntegerDiscount = Double.parseDouble(Discount.replaceAll("[^0-9.]", ""));
//
//		String ShippingAndHandling = ThePrices.get(2).getText();
//		double IntegerShippingAndHandling = Double.parseDouble(ShippingAndHandling.replaceAll("[^0-9.]", ""));
//
//		String FinalPrice = ThePrices.get(3).getText();
//		double ActualfinalPrice = Double.parseDouble(FinalPrice.replaceAll("[^0-9.]", ""));
//		// System.out.println(ActualfinalPrice);
//
//		double ExpectedPrice = IntegerSubtotal - IntegerDiscount + IntegerShippingAndHandling;
//		System.out.println(ExpectedPrice);
//
//		assertEquals(ActualfinalPrice, ExpectedPrice);
//
//	}
