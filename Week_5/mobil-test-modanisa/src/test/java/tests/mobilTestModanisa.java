package tests;

import POM.BasketPage;
import POM.ProductDetailPage;
import POM.SearchBar;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class mobilTestModanisa extends BaseTest {

    @Test( priority = 0)
      public void goToProductDetail() throws InterruptedException {
        SearchBar searchBar = new SearchBar(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        searchBar.searchBarClick();
        searchBar.searchBarSendKeys("çorap");
        MobileElement selectOneOfSuggestions = driver.findElementByXPath("//android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView");
        selectOneOfSuggestions.click();
        MobileElement selectProduct = driver.findElementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView");
        selectProduct.click();
        String brandName = "AYESS ÇORAP";
        String brandSelector = driver.findElement(By.id("com.modanisa:id/brandName")).getText();
        String actualProductName = driver.findElement(By.id("com.modanisa:id/productName")).getText();
        String expectedProductName = "İkili Bambu Bayan Patik Çorap - Siyah";
        productDetailPage.checkProductDetails(brandName, brandSelector, actualProductName, expectedProductName);
    }

    @Test(priority=1)
    public void addProductInBasket() throws InterruptedException {
        BasketPage basketPage = new BasketPage(driver);
        goToProductDetail();
        MobileElement addBasketButton = driver.findElement(By.id("com.modanisa:id/addToBasket"));
        addBasketButton.click();
        MobileElement productSelectorInBasket = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]"));
        String expectedProductName = "İkili Bambu Bayan Patik Çorap - Siyah";
        basketPage.checkProductInBasket(expectedProductName, productSelectorInBasket);
    }

    @Test(priority=2)
    public void clearBasket() throws InterruptedException {
        BasketPage basketPage = new BasketPage(driver);
        MobileElement basketButton = driver.findElement(By.id("com.modanisa:id/tab_basket"));

        basketPage.goToBasketPage(basketButton);

        MobileElement clearButton = driver.findElement(By.id("com.modanisa:id/remove"));
        basketPage.clearBasket(clearButton);

        Thread.sleep(2000L);
        MobileElement confirmButton = driver.findElement(By.id("android:id/button1"));
        confirmButton.click();
        Thread.sleep(5000L);

        MobileElement basketTitle = driver.findElement(By.id("com.modanisa:id/emptyBasketTitle"));
        String expectedProductName = "İkili Bambu Bayan Patik Çorap - Siyah";
        Thread.sleep(1000L);
        Assert.assertFalse(basketTitle.getText().contains(expectedProductName));
    }
}
