import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AmazonRegistrationPage;
import pages.AmazonSearchPage;
import pages.AmazonProductDetailsPage;

public class AmazonTest {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        BasePage.setDriver(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void searchAndAddToCart() {
        AmazonSearchPage searchPage = new AmazonSearchPage(driver);
        AmazonProductDetailsPage productDetailsPage = new AmazonProductDetailsPage(driver);

        driver.get("https://www.amazon.in");

        searchPage.searchForProduct("iPhone");
        searchPage.selectProductFromList("iPhone");

        // Assuming the details page opens automatically after clicking on the product link
        String productPrice = productDetailsPage.getProductPrice();
        productDetailsPage.addToCart();

        // Example assertion
        assertTrue(productPrice.startsWith("$"));
    }

    @Test
    public void registerUser() {
        AmazonRegistrationPage registrationPage = new AmazonRegistrationPage(driver);

        driver.get("https://www.amazon.in");

        registrationPage.navigateToRegistration();
        registrationPage.fillRegistrationForm("YourName", "your.email@example.com", "yourPassword");
        registrationPage.createAccount();

        // Example assertion
        assertTrue(driver.getTitle().equals("Registration Successful"));
    }

    @After
    public void tearDown() {
        BasePage.closeBrowser();
    }
}
