package POM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasketPage extends BasePage {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    public BasketPage(AndroidDriver driver) {
        super(driver);
    }

    public void checkProductInBasket(String productName, WebElement productNameSelector) throws InterruptedException {
        Thread.sleep(1000L);
        Assert.assertTrue(productNameSelector.getText().contains(productName));
    }

    public void clearBasket(MobileElement clearButton) {
        clearButton.click();
    }
    public void goToBasketPage(MobileElement basketButton){
    basketButton.click();
    }

}
