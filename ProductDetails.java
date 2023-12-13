import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonProductDetailsPage {
    private final WebDriver driver;

    public AmazonProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductPrice() {
        WebElement priceElement = driver.findElement(By.id("priceblock_ourprice"));
        return priceElement.getText();
    }

    public void addToCart() {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
    }
}
