package POM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class BasePage {
    public AndroidDriver<MobileElement> driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

}
