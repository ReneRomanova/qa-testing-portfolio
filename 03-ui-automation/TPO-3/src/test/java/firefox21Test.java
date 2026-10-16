import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class firefox21Test {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/java/geckodriver.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
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

        // Wait for the element to be clickable before clicking on it
        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header[@id='top-panel']/div/div/div/div[3]/div/ul/li[2]/a/span")));
        registerButton.click();

        // Wait for the email input field to be present and visible before sending keys
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='register-email']")));
        emailInput.sendKeys("dohenika");

        // Similarly, wait for the password input field before sending keys
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='register-pass']")));
        passInput.sendKeys("iri47534893268234");

        // Wait for the register button to be clickable before clicking on it
        WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='register-btn']")));
        registerBtn.click();

        // Wait for error message elements to be present before asserting
        WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='register-email-error']")));
        assertThat(emailError.getText(), is("Введите действующий адрес электронной почты"));

        WebElement privacyError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='register-privacy-error']")));
        assertThat(privacyError.getText(), is("Необходимо принять согласие на обработку данных"));
    }
}
