using System.Threading;
using OpenQA.Selenium;
using SeleniumExtras.PageObjects;
using OpenQA.Selenium.Support.UI;

namespace dotnetciceksepeti
{
public class searchBar : basePage{
  public void driverSetup(IWebDriver driver) {
      PageFactory.InitElements(driver,this);
  }

  public void searchProduct(string sendKeys) {
        IWebElement SeacrhBar = driver.FindElement(By.XPath("//input[@name=\' \']"));
        SeacrhBar.Click();

        SeacrhBar.SendKeys(sendKeys);
        SeacrhBar.SendKeys(Keys.Enter);
        Thread.Sleep(3000);

  }

}}
