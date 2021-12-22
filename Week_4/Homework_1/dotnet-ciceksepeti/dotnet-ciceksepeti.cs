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
    driver.Manage().Window.Maximize();
    Thread.Sleep(2000);
    driver.Navigate().GoToUrl("https://www.ciceksepeti.com/");
    //driver.FindElement(By.ClassName("js-subheader-close")).Click();
  }
  [TearDown]
  protected void TearDown() {
    driver.Quit();
  }
  [Test]
  public void selectProductInCategories() {
    IWebElement categorySelector = driver.FindElement(By.XPath("/html/body/div[4]/div[1]/div[2]/nav/ul/li[2]"));
    categorySelector.Click();
    Thread.Sleep(2000);
    IWebElement productSelector = driver.FindElement(By.XPath("/html/body/main/div/div[4]/div[3]"));
    productSelector.Click();
    Thread.Sleep(1000);
    driver.FindElement(By.CssSelector(".product__info__title")).Click();
    Assert.That(driver.FindElement(By.CssSelector(".js-product-title")).Text, Is.EqualTo("Doğal Ahşap Kütükte Renkli Papatya Aranjmanı"));
  }
[Test]
  public void addProductInBasket() {
        IWebElement SeacrhBar = driver.FindElement(By.XPath("//input[@name=\' \']"));
        SeacrhBar.Click();
        SeacrhBar.SendKeys("Mum");
        SeacrhBar.SendKeys(Keys.Enter);
        Thread.Sleep(2000);
        IWebElement productSelector = driver.FindElement(By.XPath("/html/body/main/div/div[4]/div[64]/div/div"));
        productSelector.Click();
        IWebElement addBasketButton = driver.FindElement(By.XPath("//*[@id=\"productDetailSend\"]/div/div/div[2]/div[2]/div[5]/div[13]/div[5]/button"));
        addBasketButton.Click();
        Thread.Sleep(2000);
        string URL = driver.Url;
        string basketURL = "https://www.ciceksepeti.com/sepetim";
        string expectedName = "Luxery Candle Lavanta Kokulu Mor Cam Mum ";
        string addedProductName = driver.FindElement(By.ClassName("cart__item-col-link")).GetAttribute("textContent");
        Assert.AreEqual(URL,  basketURL);
        Assert.AreEqual(addedProductName,expectedName);
  }
}}
