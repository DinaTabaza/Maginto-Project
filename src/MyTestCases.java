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
	

	// SignIn
	@Test(description = "Test number 2", priority = 2)
	public void Login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

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
	}

	// Send Items via Search Bar .. And Search 5 items randomly 
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
	public void Add_Five_Items_ToCart() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		for (int i = 0; i < URL_Items.length; i++) {
			driver.get(URL_Items[i]);

			// Lists Size and Color
			List<WebElement> SelectSizeButtons = driver.findElements(By.className("swatch-option"));
			List<WebElement> SelectColorButtons = driver.findElements(By.className("swatch-option"));

			// Radiant Tee Item
			if (driver.getCurrentUrl().contains("tee")) {
				// Select Random Size
				int RandomSizeIndex = rand.nextInt(0, 5);
				SelectSizeButtons.get(RandomSizeIndex).click();
				Thread.sleep(1000);

				// Select Random Color
				int RandomColorIndex = rand.nextInt(5, 8);
				SelectColorButtons.get(RandomColorIndex).click();

				// Select Quintity
				WebElement Quintyt = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quintyt.clear();
				Quintyt.sendKeys("3");

				WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToCartButton.click();

				// Breathe-Easy Tank
			} else if (driver.getCurrentUrl().contains("easy")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

				// Select Random Size
				int RandomSizeIndex = rand.nextInt(0, 5);
				SelectSizeButtons.get(RandomSizeIndex).click();
				Thread.sleep(1000);

				// Select Random Color
				int RandomColorIndex = rand.nextInt(5, 8);
				SelectColorButtons.get(RandomColorIndex).click();

				WebElement Quintyt = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quintyt.clear();
				Quintyt.sendKeys("2");
				WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToCartButton.click();
			}

			// Argus All-Weather Tank Item
			else if (driver.getCurrentUrl().contains("weather")) {
				// Select Random Size
				int RandomSizeIndex = rand.nextInt(0, 5);
				SelectSizeButtons.get(RandomSizeIndex).click();

				Thread.sleep(1000);

				// Select Random Color
				int RandomColorIndex = rand.nextInt(5, 6);
				SelectColorButtons.get(RandomColorIndex).click();

				WebElement Quintyt = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quintyt.clear();
				Quintyt.sendKeys("4");
				WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToCartButton.click();

				// Hero Hoodie Item
			} else if (driver.getCurrentUrl().contains("hoodie")) {
				// Select Random Size
				int RandomSizeIndex = rand.nextInt(0, 5);
				SelectSizeButtons.get(RandomSizeIndex).click();
				Thread.sleep(1000);

				// Select Random Color
				int RandomColorIndex = rand.nextInt(5, 8);
				SelectColorButtons.get(RandomColorIndex).click();

				WebElement Quintyt = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quintyt.clear();
				Quintyt.sendKeys("1");
				WebElement AddToCartButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddToCartButton.click();
			}

		}
	}

	// Fill The Info And Complete The Process Of Shipping The Address
	@Test(description = "Test number 5", priority = 5)
	public void Checkout_Process() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(CheckoutPage);

		boolean shippingAddressItemPresent = driver
				.findElements(By.xpath("//*[@id=\"checkout-step-shipping\"]/div[1]/div/div/div")).size() > 0;

		if (shippingAddressItemPresent) {

			// Shipping Method
			WebElement ShippingMethods = driver.findElement(By.name("ko_unique_2"));
			ShippingMethods.click();

			// If the element is present, click on the "Next" button
			WebElement nextButton = driver
					.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"));
			nextButton.click();

		} else {

			// First_name
			WebElement First_name = driver.findElement(By.name("firstname"));
			First_name.clear();
			First_name.sendKeys(FirstName);

			// Last_name
			WebElement Last_name = driver.findElement(By.name("lastname"));
			Last_name.clear();
			Last_name.sendKeys(LastName);

			// Company_name
			WebElement Company_name = driver.findElement(By.name("company"));
			Company_name.sendKeys(CompanyName);

			// Street_Address
			WebElement Street_Address = driver.findElement(By.name("street[0]"));
			Street_Address.sendKeys(streeAddress);

			// cityName
			WebElement cityName = driver.findElement(By.name("city"));
			cityName.sendKeys(City);

			// select_Region
			WebElement select_Region = driver.findElement(By.name("region_id"));
			Select DropDown_region = new Select(select_Region);
			DropDown_region.selectByIndex(2);

			// Postal_code
			WebElement Postal_code = driver.findElement(By.name("postcode"));
			Postal_code.sendKeys(PostalCode);

			// Select_country
			WebElement Select_country = driver.findElement(By.name("country_id"));
			// Select DropDown_country = new Select(Select_country);
			// DropDown_country.selectByVisibleText("Canada");

			// Phone_Number
			WebElement PhoneNum = driver.findElement(By.name("telephone"));
			PhoneNum.sendKeys(PhoneNumber);

			// Shipping Method
			WebElement ShippingMethods = driver.findElement(By.name("ko_unique_4"));
			ShippingMethods.click();

			// Next Button
			WebElement NextButton = driver
					.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"));
			NextButton.click();

		}
	}

	// Check The final Price
	@Test(description = "Test number 6", priority = 6)
	public void Placeorder() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement placeorder_Button = driver.findElement(
				By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"));

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", placeorder_Button);
	}

	@Test(description = "Test number 7", priority = 7)
	public void Total_Of_Invoice_Number() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement Invoice_Number_Link = driver
				.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a"));
		Invoice_Number_Link.click();

		WebElement ThePricesInFooter = driver.findElement(By.tagName("tfoot"));
		List<WebElement> ThePrices = ThePricesInFooter.findElements(By.className("price"));

		String Subtotal = ThePrices.get(0).getText();
		double IntegerSubtotal = Double.parseDouble(Subtotal.replaceAll("[^0-9.]", ""));

		String Discount = ThePrices.get(1).getText();
		double IntegerDiscount = Double.parseDouble(Discount.replaceAll("[^0-9.]", ""));

		String ShippingAndHandling = ThePrices.get(2).getText();
		double IntegerShippingAndHandling = Double.parseDouble(ShippingAndHandling.replaceAll("[^0-9.]", ""));

		String FinalPrice = ThePrices.get(3).getText();
		double ActualfinalPrice = Double.parseDouble(FinalPrice.replaceAll("[^0-9.]", ""));
		// System.out.println(ActualfinalPrice);

		double ExpectedPrice = IntegerSubtotal - IntegerDiscount + IntegerShippingAndHandling;
		System.out.println(ExpectedPrice);

		assertEquals(ActualfinalPrice, ExpectedPrice);

	}

}
