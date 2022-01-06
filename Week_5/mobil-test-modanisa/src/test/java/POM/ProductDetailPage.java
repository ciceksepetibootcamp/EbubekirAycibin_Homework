package POM;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class ProductDetailPage extends BasePage {


    public ProductDetailPage(AndroidDriver driver) {
        super(driver);
    }

    public void checkProductDetails(String brandName, String brandSelector, String actualProductName, String expectedProductName) {


        Assert.assertEquals(brandName, brandSelector);
        Assert.assertTrue(actualProductName.contains(expectedProductName));

    }
}
