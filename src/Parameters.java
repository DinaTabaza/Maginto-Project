import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class Parameters {
	static WebDriver driver = new ChromeDriver();
	Assertion Assert = new Assertion();
	Random rand = new Random();

	String HomePage = "https://magento.softwaretestingboard.com/";
	String CheckoutPage = "https://magento.softwaretestingboard.com/checkout/#shipping";

	// Login info
	String FirstName = "Dina";
	String LastName = "Tabaza";
	String email = "Dina_Muwaffaq.tabaza@yahoo.com";
	String password = "0795646019Dd";

	// Checkout info
	String CompanyName = "Amazon";
	String streeAddress = "wasfi-Altal street";
	String City = "Amman";
	String PostalCode = "12345";
	String PhoneNumber = "0795646019";

	// Add_Five_Items_ToCart
	String URL_Items[] = { "https://magento.softwaretestingboard.com/radiant-tee.html",
			"https://magento.softwaretestingboard.com/breathe-easy-tank.html",
			"https://magento.softwaretestingboard.com/argus-all-weather-tank.html",
			"https://magento.softwaretestingboard.com/hero-hoodie.html" };

}
