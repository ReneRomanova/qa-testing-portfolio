import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class firefox44Test {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/java/geckodriver.exe");
        driver = new FirefoxDriver(); // Use FirefoxDriver for Firefox compatibility
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test4() {
        driver.get("https://promopult.ru/");
        driver.manage().window().setSize(new Dimension(1552, 832));
        {
            WebElement element = driver.findElement(By.linkText("Вход"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.linkText("Вход")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-uname")));
        usernameInput.sendKeys("dohenika.irina@gmail.com");

        driver.findElement(By.id("login-pass")).sendKeys("irina254");
        driver.findElement(By.id("login-show-pass-eye")).click();
        driver.findElement(By.id("login-btn")).click();
    }
}
