// Generated by Selenium IDE
using System.Threading;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;

namespace dotnetciceksepeti{ 
[TestFixture]
public class dotnet_ciceksepeti {
  private IWebDriver driver;
  [SetUp]
  public void SetUp() {
    driver = new ChromeDriver();
    driver.Navigate().GoToUrl("https://www.ciceksepeti.com/");
    driver.Manage().Window.Size = new System.Drawing.Size(1630, 1920);
    Thread.Sleep(2000);
    driver.FindElement(By.ClassName("js-subheader-close")).Click();
  }
  [TearDown]
  protected void TearDown() {
    driver.Quit();
  }
  [Test]
  public void searchPoduct() {
    
    driver.FindElement(By.XPath("//input[@name=\' \']")).SendKeys("çiçek");
    driver.FindElement(By.CssSelector("#product-search-2 > .js-product-search-button")).Click();
    Thread.Sleep(2000);
    driver.FindElement(By.CssSelector(".products__item:nth-child(2) .products__item-img")).Click();
    driver.FindElement(By.CssSelector(".product__info__title")).Click();
    Assert.That(driver.FindElement(By.CssSelector(".js-product-title")).Text, Is.EqualTo("Doğal Ahşap Kütükte Renkli Papatya Aranjmanı"));
  }
[Test]
  public void addProductInBasket() {

        Thread.Sleep(500);
        driver.FindElement(By.XPath("//*[@id=\"product-search-2\"]/input")).Click();
        driver.FindElement(By.XPath("//*[@id=\"product-search-2\"]/input")).SendKeys("Mum");
        Thread.Sleep(500);
        driver.FindElement(By.XPath("//div[@id='product-search-2']/div[3]/ul/li/a/span")).Click();
        Thread.Sleep(2000);
        driver.FindElement(By.XPath("/html/body/main/div/div[4]/div[64]/div/div")).Click();
        driver.FindElement(By.XPath("//*[@id=\"productDetailSend\"]/div/div/div[2]/div[2]/div[5]/div[13]/div[5]/button")).Click();
        Thread.Sleep(2000);
        string URL = driver.Url;
        Assert.AreEqual(URL, "https://www.ciceksepeti.com/sepetim" );
        string addedProductName = driver.FindElement(By.ClassName("cart__item-col-link")).GetAttribute("textContent");
        Assert.AreEqual(addedProductName, "Luxery Candle Lavanta Kokulu Mor Cam Mum " );
  }
}}
