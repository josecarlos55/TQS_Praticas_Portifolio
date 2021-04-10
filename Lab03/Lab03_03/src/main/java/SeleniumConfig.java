import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfig {

    private WebDriver driver;

    public SeleniumConfig() {
        driver = new ChromeDriver();
    }

    public void close() {
        driver.close();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public WebDriver getDriver() {
        return driver;
    }
}