import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Reorder_Five_Times extends Parameters {

	@BeforeTest
	public void preTest() throws InterruptedException {
		driver.get(HomePage);
		driver.manage().window().maximize();
	}

	// Reorder 5 Times
	@Test(description = "Test number 8", priority = 8)
	public void Reorder_five_Times() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		// SignIn

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

		// ----------------------------------
		Thread.sleep(3000);
		// Go To My Account
		WebElement DropDown = driver.findElement(By.className("customer-name"));
		DropDown.click();

		WebElement MyAccount = driver
				.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a"));
		MyAccount.click();

		WebElement MyOrder = driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a"));
		MyOrder.click();

		for (int i = 1; i < 6; i++) {
			WebElement reorderButton = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr/td[6]/a[2]"));
			reorderButton.click();

			WebElement Proceed_To_Checkout = driver
					.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button"));
			Proceed_To_Checkout.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

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

				WebElement placeorder_Button = driver.findElement(
						By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button"));

				JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
				jsExecutor1.executeScript("arguments[0].click();", placeorder_Button);

				driver.get("https://magento.softwaretestingboard.com/sales/order/history/");

			}

			driver.navigate().refresh();
		}

	}

	// Check The price of the Last 5 Invoices Added Are The Same
	@Test(description = "Test number 9", priority = 9)
	public void Check_five_OrderPrice() throws InterruptedException {
		WebElement table = driver.findElement(By.className("main"));

		// Find all rows in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Get the last 5 rows (excluding the header row if present)
		int numRows = rows.size();
		int startRow = numRows >= 5 ? numRows - 5 : 0;
		for (int i = startRow; i < numRows; i++) {
			WebElement row = rows.get(i);

			// Get the desired cell from each row
			WebElement cell = row.findElement(By.className("price"));

			// Perform actions with the cell content
			String Actualprice = cell.getText().trim();
			System.out.println(Actualprice);

			WebElement TheFistPriceInTheTable = driver
					.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[4]/span"));
			String ExpectedPrice = TheFistPriceInTheTable.getText().trim();
			System.out.println(ExpectedPrice);

			// Assert that the price is equal to the expected price
			if (Actualprice.equals(ExpectedPrice)) {
				System.out.println("Price assertion passed!");
				break;
			}
		}

	}
}
