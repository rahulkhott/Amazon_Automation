import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void searchAndAddToCart() {
        AmazonSearchPage searchPage = new AmazonSearchPage(driver);
        AmazonProductDetailsPage productDetailsPage = new AmazonProductDetailsPage(driver);

        driver.get("https://www.amazon.in");

        searchPage.searchForProduct("iPhone");
        searchPage.selectProductFromList("iPhone");

        // Assuming the details page opens automatically after clicking on the product link
        String productPrice = productDetailsPage.getProductPrice();
        productDetailsPage.addToCart();
    }

    @Test(priority = 2)
    public void registerUser() {
        AmazonRegistrationPage registrationPage = new AmazonRegistrationPage(driver);

        driver.get("https://www.amazon.in");

        registrationPage.navigateToRegistration();
        registrationPage.fillRegistrationForm("YourName", "your.email@example.com", "yourPassword");
        registrationPage.createAccount();
    }

    @Test(priority = 3)
    public void searchWithFilters() {
        AmazonFilterSearchPage filterSearchPage = new AmazonFilterSearchPage(driver);

        driver.get("https://www.amazon.in");

        filterSearchPage.applyFilter("Brand");
        // Add more filter applications if needed

        filterSearchPage.validateFilteredResults();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
