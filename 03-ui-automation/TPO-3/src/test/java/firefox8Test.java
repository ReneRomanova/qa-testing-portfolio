import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class firefox8Test {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        // Set geckodriver path
        System.setProperty("webdriver.gecko.driver", "src/test/java/geckodriver.exe");
        // Use FirefoxDriver
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test8() {
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
        {
            WebElement element = driver.findElement(By.cssSelector(".side-menu-section:nth-child(3) .side-menu__item:nth-child(2) > .side-menu-item"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".side-menu-section:nth-child(3) .side-menu__item:nth-child(3) > .side-menu-item"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".side-menu-section:nth-child(3) .side-menu__item:nth-child(1) use")).click();
        driver.findElement(By.id("itp_content_wrapper")).click();

        WebElement addButton = driver.findElement(By.name("add"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addButton);

        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        WebElement clickableAddButton = wait1.until(ExpectedConditions.elementToBeClickable(By.name("add")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickableAddButton);

        driver.findElement(By.cssSelector(".btn_or_12d")).click();
        driver.findElement(By.id("lightbox-message")).click();
        assertThat(driver.findElement(By.id("lightbox_error_message")).getText(), is("Неверный формат адресса сайта. Проверьте, чтобы он начинался с http:// или с https:// (например, http://mysite.ru)"));
    }
}
