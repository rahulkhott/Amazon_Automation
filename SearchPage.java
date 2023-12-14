package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AmazonSearchPage {

    private final WebDriver driver;

    public AmazonSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String productName) {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(productName);
        searchBox.submit();
    }

    public void selectProductFromList(String productName) {
        WebElement productLink = driver.findElement(By.xpath("//span[contains(text(),'" + productName + "')]"));
        productLink.click();
    }
}
