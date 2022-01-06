package POM;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SearchBar extends BasePage {

    public SearchBar(AndroidDriver driver) {
        super(driver);
    }

    public void searchBarClick() throws InterruptedException {
        Thread.sleep(1000L);
        MobileElement searchBar = driver.findElement(By.id("com.modanisa:id/placeholder"));
        searchBar.click();
    }

    public void searchBarSendKeys(String sendkey) throws InterruptedException {
        MobileElement searchBarSendKeys = driver.findElementByXPath("//android.widget.EditText");
        searchBarSendKeys.sendKeys(sendkey);
        Thread.sleep(1000L);

    }
}
