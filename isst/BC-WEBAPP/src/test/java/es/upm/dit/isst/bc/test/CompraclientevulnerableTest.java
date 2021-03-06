package es.upm.dit.isst.bc.test;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class CompraclientevulnerableTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void compraclientevulnerable() {
    driver.get("http://localhost:8080/BC-WEBAPP/FormLoginServlet?email=cvulnerable@email.com&password=123&remember=on");
    driver.manage().window().setSize(new Dimension(1294, 694));
    driver.findElement(By.cssSelector(".w3-row-padding:nth-child(3) button")).click();
    driver.findElement(By.cssSelector(".w3-row-padding:nth-child(3) .boton2")).click();
    driver.findElement(By.cssSelector(".w3-bar-item:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.name("hora")).click();
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".w3-block")).click();
  }
}
