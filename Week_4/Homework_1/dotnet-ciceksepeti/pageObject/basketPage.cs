using System.Threading;
using OpenQA.Selenium;
using SeleniumExtras.PageObjects;
using OpenQA.Selenium.Support.UI;
using NUnit.Framework;


namespace dotnetciceksepeti
{
public class basketPage : basePage{
  public void driverSetup(IWebDriver driver) {
      PageFactory.InitElements(driver,this);
  }

  public void basketCheck(string expectedPoductName) {
        string basketURL = "https://www.ciceksepeti.com/sepetim";
        driver.Navigate().GoToUrl(basketURL);
        IWebElement basketContainer = driver.FindElement(By.XPath("/html/body/main/div[1]"));
        WebDriverWait wait = new WebDriverWait(driver, System.TimeSpan.FromSeconds(8));
        wait.Until(driver => basketContainer.Displayed);
        Assert.IsTrue(basketContainer.Text.Contains(expectedPoductName));

  }

}}
