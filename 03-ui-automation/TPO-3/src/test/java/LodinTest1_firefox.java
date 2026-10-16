import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class LodinTest1_firefox {
  private WebDriver driver;

  @Before
  public void setUp() {
    // Define the path to the Firefox driver
    System.setProperty("webdriver.gecko.driver", "src/test/java/geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1552, 832));
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void lodin() {
    driver.get("https://promopult.ru/");

    // Hover over the element
    WebElement element = driver.findElement(By.xpath("//a[contains(@href, '/welcome.html?t=reg&goal=/item_add.html')]"));
    Actions builder = new Actions(driver);
    builder.moveToElement(element).perform();

    // Click on the registration link
    driver.findElement(By.xpath("//header[@id='top-panel']/div/div/div/div[3]/div/ul/li[2]/a/span")).click();

    // Wait for the register button and click on it
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement registerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='register-btn']")));
    registerButton.click();

    // Switch to the registration tab
    driver.findElement(By.id("auth-content-tab-register")).click();

    // Assertions for the registration form errors
    assertEquals("Заполните, пожалуйста, поле E-mail", driver.findElement(By.id("register-email-error")).getText());
    assertEquals("Пароль должен состоять минимум из 8 символов", driver.findElement(By.id("register-pass-error")).getText());
    assertEquals("Необходимо принять согласие на обработку данных", driver.findElement(By.id("register-privacy-error")).getText());
  }
}
