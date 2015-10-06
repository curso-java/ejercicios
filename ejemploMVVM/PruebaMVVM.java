package es.cic.curso.ejercicio011;

import java.util.concurrent.TimeUnit;


import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PruebaMVVM {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPruebaMVVM() throws Exception {
    driver.get(baseUrl + "/completar###/indexPrueba.html");
    driver.findElement(By.id("tString")).clear();
    driver.findElement(By.id("tString")).sendKeys("Texto de prueba");
    driver.findElement(By.id("bBoton")).click();
    
    String valorMetido = driver.findElement(By.id("tDevuelto")).getText();
    String valorServicio = driver.findElement(By.id("tMVVM")).getText();
    
    assertEquals(valorMetido, valorServicio);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
