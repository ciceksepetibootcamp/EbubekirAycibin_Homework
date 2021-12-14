package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class test_demo {

    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/cloudnesil/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.ciceksepeti.com/");
        driver.manage().window().setSize(new Dimension(1662, 902));
        Thread.sleep(1200L);
        //  driver.findElement(By.className("ab-close-button")).click();
        driver.findElement(By.className("js-subheader-close")).click();
    }
    @Test
    public void searchProduct() throws InterruptedException {

        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"product-search-2\"]/input"));
        searchBar.click();
        searchBar.sendKeys("çiçek");
        Thread.sleep(500L);
        WebElement oneOfSuggestion = driver.findElement(By.xpath("//div[@id='product-search-2']/div[3]/ul/li/a/span"));
        oneOfSuggestion.click();
        Thread.sleep(500L);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,1200)");
        WebElement oneOfProducts = driver.findElement(By.className("products__container-background"));
        Thread.sleep(500L);
        oneOfProducts.click();
        String productName = driver.findElement(By.xpath("//*[@id=\"productDetailSend\"]/div/div/div[2]/div[2]/div[2]/div/div[1]/h1/span")).getAttribute("textContent");
        Assert.assertEquals(productName,"Doğal Ahşap Kütükte Renkli Papatya Aranjmanı");
    }
    @Test
    public void cleanRecentSearch() throws InterruptedException {
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"product-search-2\"]/input"));
        searchBar.click();
        searchBar.sendKeys("çiçek");
        Thread.sleep(500L);
        WebElement oneOfSuggestion = driver.findElement(By.xpath("//div[@id='product-search-2']/div[3]/ul/li/a/span"));
        oneOfSuggestion.click();
        Thread.sleep(500L);
        driver.findElement(By.xpath("//*[@id=\"product-search-2\"]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"product-search-2\"]/input")).click();
        Thread.sleep(500L);
        String recentSearchName = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div[2]/div/span")).getAttribute("textContent");
        Assert.assertEquals(recentSearchName,"Geçmiş Aramalarım");
        Thread.sleep(500L);
        WebElement clearButton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div[2]/div/div/span"));
        clearButton.click();
    }
    @Test
    public void addProductInBasket() throws InterruptedException {
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"product-search-2\"]/input"));
        searchBar.click();
        searchBar.sendKeys("mum");
        Thread.sleep(2000L);
        WebElement oneOfSuggestion = driver.findElement(By.xpath("//div[@id='product-search-2']/div[3]/ul/li/a/span"));
        oneOfSuggestion.click();
        Thread.sleep(500L);
        WebElement oneOfProducts = driver.findElement(By.xpath("/html/body/main/div/div[4]/div[63]/div/div"));
        oneOfProducts.click();
        WebElement addBasketButton = driver.findElement(By.xpath("//*[@id=\"productDetailSend\"]/div/div/div[2]/div[2]/div[5]/div[13]/div[5]/button"));
        addBasketButton.click();
        Thread.sleep(1000L);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.ciceksepeti.com/sepetim" );
        String addedProductName = driver.findElement(By.className("cart__item-col-link")).getAttribute("textContent");
        Assert.assertEquals(addedProductName, "Luxery Candle Lavanta Kokulu Mor Cam Mum " );
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
