import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumConfigTest {

    @Test
    public void SeleniumConfig() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("headless");

        WebDriver driver = new ChromeDriver();

        //Open browser == BeforeEach
        driver.get("https://www.facebook.com");

        System.out.println(driver.getTitle());

        //Close browser == AfterEach
        driver.close();
    }
}