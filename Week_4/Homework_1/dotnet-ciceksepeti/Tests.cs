using System.Threading;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;
using OpenQA.Selenium.Support.UI;

namespace dotnetciceksepeti{
[TestFixture]
public class dotnet_ciceksepeti : basePage{
searchBar searchbar;
selectCategory selectcategory;
basketPage basketpage;

[SetUp]
public void openPage() {
  SetUp();
  }
[TearDown]
protected void closePage() {
  TearDown();  
  }

  [Test,Order(1)]
  public void selectProductInCategories() {
    selectcategory = new selectCategory();
    IWebElement categorySelector = driver.FindElement(By.XPath("/html/body/div[4]/div[1]/div[2]/nav/ul/li[2]"));
    selectcategory.selectOneOfCategories(categorySelector);

    IWebElement productSelector = driver.FindElement(By.XPath("/html/body/main/div/div[4]/div[4]/div/div"));
      productSelector.Click();


    IWebElement productTitle = driver.FindElement(By.CssSelector(".js-product-title"));
    string productRealTitleName = "Doğal Ahşap Kütükte Renkli Papatya Aranjmanı";
    Assert.That(productTitle.Text, Is.EqualTo(productRealTitleName));
  }
[Test,Order(2)]
    public void goBackWithBreadcromb() {
    selectcategory = new selectCategory();
    IWebElement categorySelector = driver.FindElement(By.XPath("/html/body/div[4]/div[1]/div[2]/nav/ul/li[2]"));
    selectcategory.selectOneOfCategories(categorySelector);
    IWebElement productSelector = driver.FindElement(By.XPath("/html/body/main/div/div[4]/div[4]/div/div"));
      productSelector.Click();

    IWebElement breadcrombCicek = driver.FindElement(By.XPath("/html/body/div[5]/div/ul/li[2]/a/span"));
    WebDriverWait wait = new WebDriverWait(driver, System.TimeSpan.FromSeconds(8));
        wait.Until(driver => breadcrombCicek.Displayed);
    breadcrombCicek.Click();
    IWebElement breadcrombHomePage = driver.FindElement(By.XPath("/html/body/div[5]/div/ul/li[1]/a/span"));
        wait.Until(driver => breadcrombHomePage.Displayed);
    breadcrombHomePage.Click();
    Thread.Sleep(1000);

    string URL = driver.Url;
    string expectedURL = "https://www.ciceksepeti.com/";
    Assert.AreEqual(URL,expectedURL);

  }
[Test,Order(3)]
  public void addProductInBasket() {

        searchbar = new searchBar();
        searchbar.searchProduct("lavanta kokulu Mum");

        IWebElement productSelector = driver.FindElement(By.XPath("/html/body/main/div/div[4]/div[1]/div/div"));
        productSelector.Click();
        IWebElement addBasketButton = driver.FindElement(By.XPath("//*[@id=\"productDetailSend\"]/div/div/div[2]/div[2]/div[5]/div[13]/div[5]/button"));
        addBasketButton.Click();
        Thread.Sleep(2000);
        basketpage = new basketPage();
        string expectedName = "Luxery Candle Lavanta Kokulu Mor Cam Mum";
        basketpage.basketCheck(expectedName);
  }
}}