using System.Threading;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;
using OpenQA.Selenium.Support.UI;


namespace dotnetciceksepeti{

[TestFixture]
public class basePage {
public static IWebDriver driver;
  public void SetUp() {

    driver = new ChromeDriver();

    driver.Navigate().GoToUrl("https://www.ciceksepeti.com/");
    driver.Manage().Window.Maximize();
    driver.Navigate().Refresh();
    Thread.Sleep(3000);


  }
  protected void TearDown() {
    driver.Quit();
  }
}}
