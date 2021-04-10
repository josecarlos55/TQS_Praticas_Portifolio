import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfigTest {

    @Test
    public void SeleniumConfig() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        //Open browser == BeforeEach
        driver.get("https://www.facebook.com");

        System.out.println(driver.getTitle());

        //Close browser == AfterEach
        driver.close();
    }
}