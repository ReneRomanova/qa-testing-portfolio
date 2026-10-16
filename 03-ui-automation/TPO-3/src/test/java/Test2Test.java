import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Test2Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void test2() {
    driver.get("https://promopult.ru/");
    driver.manage().window().setSize(new Dimension(1552, 832));

    WebDriverWait wait = new WebDriverWait(driver, 10);

    {
      WebElement element = driver.findElement(By.id("mtop_panel_cont"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }

    WebElement signupLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".auth__link-signup > span")));
    signupLink.click();

    WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register-email")));
    emailField.sendKeys("dohenika");

    WebElement passwordField = driver.findElement(By.id("register-pass"));
    passwordField.click();
    passwordField.sendKeys("iri47534893268234");

    WebElement registerButton = driver.findElement(By.id("register-btn"));
    registerButton.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rtm-register-form > .auth-form-row:nth-child(6)"))).click();
    assertThat(driver.findElement(By.id("register-email-error")).getText(), is("Введите действующий адрес электронной почты"));

    WebElement privacyRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".auth-form-row:nth-child(10)")));
    privacyRow.click();
    assertThat(driver.findElement(By.id("register-privacy-error")).getText(), is("Необходимо принять согласие на обработку данных"));
  }
}
