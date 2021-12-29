package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BDD_test_steps {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void TearnDown() {
        driver.quit();
    }

    @Given("Çiçeksepeti.com Sitesine Giriş Yap")
    public void goToHomepage() {
        driver.get("https://www.ciceksepeti.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
    }

    @Given("Kategorilerden Çiçek Seç")
    public void clickCategory() {
        WebElement categorySelector = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/nav/ul/li[2]"));
        categorySelector.click();

    }

    @Given("Listelenenlerin Arasından `Doğal Ahşap Kütükte Renkli Papatya Aranjmanı` ürününü seç")
    public void selectProduct() throws InterruptedException {
        Thread.sleep(1000L);
        WebElement productSelector = driver.findElement(By.xpath("/html/body/main/div/div[4]/div[12]"));
        productSelector.click();
    }

    @Given("Ürün Detay Sayfasına Yönlen")
    public void goToProductDetail() {

        String productRealTitleName = "Doğal Ahşap Kütükte Renkli Papatya Aranjmanı";
        WebElement productTitle = driver.findElement(By.xpath("//*[@id=\"productDetailSend\"]/div/div/div[2]/div[2]/div[2]/div/div[1]/h1"));
        Assert.assertEquals(productTitle.getText(), productRealTitleName);

    }

    @When("Breadcrumb'dan Sırasıyla Çiçek ve Anasayfa Adımına Tıkla")
    public void clickBreadcrumb() throws InterruptedException {
        WebElement breadcrombCicek = driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[2]/a/span"));
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(breadcrombCicek));
        breadcrombCicek.click();
        WebElement breadcrombHomePage = driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[1]/a/span"));
        wait.until(ExpectedConditions.visibilityOf(breadcrombHomePage));
        breadcrombHomePage.click();
        Thread.sleep(1000L);
    }

    @Then("Sırasıyla Çiçek Kategorisine ve Anasayfaya Yönlen")
    public void checkURL() {
        String URL = driver.getCurrentUrl();
        String expectedURL = "https://www.ciceksepeti.com/";
        Assert.assertEquals(URL, expectedURL);
    }

    @Given("Arama Çubuğuna Tıkla")
    public void clickSearchBar() {
        WebElement SearchBar = driver.findElement(By.xpath("//input[@name=' ']"));
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(SearchBar));
        SearchBar.click();
    }

    @Given("Arama Çubuğuna {string} yaz")
    public void sendKeysInSearchBar(String arg0) {
        WebElement SearchBar = driver.findElement(By.xpath("//input[@name=' ']"));
        SearchBar.sendKeys(arg0);

    }

    @Given("Enter Butonunu Tıkla")
    public void clickEnterButton() throws InterruptedException {
        WebElement SearchBar = driver.findElement(By.xpath("//input[@name=' ']"));
        SearchBar.sendKeys(Keys.ENTER);
    }

    @Given("Listelenenlerin Arasından Luxery Candle Lavanta Kokulu Mor Cam Mum Ürününe Tıkla")
    public void clickProduct() throws InterruptedException {
        Thread.sleep(1000L);

        WebElement productSelector = driver.findElement(By.xpath("/html/body/main/div/div[4]/div[1]/div/div"));

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(productSelector));
        productSelector.click();
    }


    @When("Sepete Ekle")
    public void sepeteEkle() throws InterruptedException {
        WebElement addBasketButton = driver.findElement(By.xpath("//*[@id=\"productDetailSend\"]/div/div/div[2]/div[2]/div[5]/div[13]/div[5]/button"));
        addBasketButton.click();
        Thread.sleep(1000L);

    }

    @Then("{string} Ürününü Sapette gör")
    public void sepetteOlupOlmadığınıKontolEt(String expectedPoductName) {
        WebElement basketContainer = driver.findElement(By.xpath("/html/body/main/div[1]"));
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(basketContainer));
        String productText = basketContainer.getAttribute("textContent");
        Assert.assertTrue(productText.contains(expectedPoductName));
    }
}
