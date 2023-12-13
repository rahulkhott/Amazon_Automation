import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonRegistrationPage {
    private final WebDriver driver;

    public AmazonRegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToRegistration() {
        WebElement accountLink = driver.findElement(By.id("nav-link-accountList"));
        accountLink.click();

        WebElement createAccountButton = driver.findElement(By.id("createAccountSubmit"));
        createAccountButton.click();
    }

    public void fillRegistrationForm(String name, String email, String password) {
        WebElement nameField = driver.findElement(By.id("ap_customer_name"));
        nameField.sendKeys(name);

        WebElement emailField = driver.findElement(By.id("ap_email"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys(password);
    }

    public void createAccount() {
        WebElement createAccountButton = driver.findElement(By.id("continue"));
        createAccountButton.click();
    }
}
