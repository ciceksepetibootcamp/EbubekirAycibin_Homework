using System.Threading;
using OpenQA.Selenium;
using SeleniumExtras.PageObjects;
using OpenQA.Selenium.Support.UI;

namespace dotnetciceksepeti
{
public class selectCategory : basePage{
  public void driverSetup(IWebDriver driver) {
      PageFactory.InitElements(driver,this);
  }

  public void selectOneOfCategories(IWebElement categorySelector) {

    WebDriverWait wait = new WebDriverWait(driver, System.TimeSpan.FromSeconds(8));
    wait.Until(driver => categorySelector.Displayed);
    categorySelector.Click();
  }

}}
