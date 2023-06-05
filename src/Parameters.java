import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class Parameters {
	static WebDriver driver = new ChromeDriver();
	Assertion Assert = new Assertion();
	Random rand = new Random();

	String HomePage = "https://magento.softwaretestingboard.com/";
	String SignupPage = "https://magento.softwaretestingboard.com/customer/account/create/";
	String LoginPage = "https://magento.softwaretestingboard.com/customer/account/login/";
	String CheckoutPage = "https://magento.softwaretestingboard.com/checkout/#shipping";
	String SignOut = "https://magento.softwaretestingboard.com/customer/account/logout/";

	// SignUp & SignIn
	String[] firstNameList = { "Dina", "Hamza", "Rania", "Diala", "yazeed" };
	String[] lastNameList = { "Ali", "yazan", "yazeed", "Ahmad", "Faisal" };
	int RandomIndex = rand.nextInt(0, 5);
	
	String EmailUser = "user";
	int RandomIndexForEmail =rand.nextInt(0, 300);
	String EmailComplete = "@yahoo.com";
	String TheEmailToLogin ;

	String Mutualpassword = "0795646019Dd";
	
	
	// Add_Items
		String URL_Items[] = { "https://magento.softwaretestingboard.com/radiant-tee.html",
				"https://magento.softwaretestingboard.com/breathe-easy-tank.html",
				"https://magento.softwaretestingboard.com/argus-all-weather-tank.html",
				"https://magento.softwaretestingboard.com/hero-hoodie.html" };


	// Checkout info
	String CompanyName = "Amazon";
	String streeAddress = "wasfi-Altal street";
	String City = "Amman";
	String PostalCode = "12345";
	String PhoneNumber = "0795646019";

	
}
