import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class Test44Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void test4() {
    driver.get("https://promopult.ru/");
    driver.manage().window().setSize(new Dimension(1552, 832));

    driver.findElement(By.xpath("//a[@onclick=\'evtTrackAuth(); EvntTrk.BTN_TOP_AUTH(); return Auth.lb_login();\']")).click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-uname']")));

    // Interact with the username input field
    usernameInput.sendKeys("dohenika.irina@gmail.com");
    driver.findElement(By.xpath("//input[@id=\'login-pass\']")).sendKeys("irina254");
    driver.findElement(By.xpath("//input[@id=\'login-btn\']")).click();
//    assertThat(driver.findElement(By.id("sp_main_tbl")).getText(), is("Система управления проектами Развернуть все\nСортировка \nГруппы проектов: Все (1) Неактивные (1) Wildberries (1) | +\nНастройка групп\nЛаба\n  ∙\nid: 4448\n∙\nв системе: 26 дней\nWildberries: Мониторинг позиций\nне запущен\nТоваров\n  0 %\nкластеров в ТОП-100\nCreated with Raphaël 2.1.2\n22.04\n29.04\n06.05\n13.05\n0\nпродажи\nCreated with Raphaël 2.1.2\n22.04\n29.04\n06.05\n13.05\nНе выбран товар для мониторинга позиций?\nВыбрать товар\nРегион: Москва\nПрофиль\nТовары\nПозиции\nОтчет"));
  }
}
