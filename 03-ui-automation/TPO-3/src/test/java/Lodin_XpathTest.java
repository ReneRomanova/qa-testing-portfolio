import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

public class Lodin_XpathTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    private JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void lodin() {
        driver.get("https://promopult.ru/");
        driver.manage().window().setSize(new Dimension(1552, 832));

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='button-block']//button[@class='l-button']")));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();

        WebElement signupLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='auth__link-signup']/span")));
        signupLink.click();

        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='register-btn']")));
        registerButton.click();

        WebElement registerTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='auth-content-tab-register']")));
        registerTab.click();

        String emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='register-email-error']"))).getText();
        assertThat(emailError, is("Заполните, пожалуйста, поле E-mail"));

        WebElement passwordRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'auth-form-row') and position()=7]")));
        passwordRow.click();
        String passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='register-pass-error']"))).getText();
        assertThat(passwordError, is("Пароль должен состоять минимум из 8 символов"));

        WebElement privacyRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'auth-form-row') and position()=10]")));
        privacyRow.click();
        String privacyError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='register-privacy-error']"))).getText();
        assertThat(privacyError, is("Необходимо принять согласие на обработку данных"));
    }
}
