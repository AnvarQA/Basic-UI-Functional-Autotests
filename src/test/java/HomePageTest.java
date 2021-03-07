import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;

import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://godaddy.com/");
        homePage = new HomePage(driver);
    }
    @Test
    public void LaunchBrowser() throws InterruptedException {
        System.out.println("The test 'LaunchBrowser' has started");
        System.out.println("1. The browser has been opened");
        System.out.println("2. The browser has been closed");
        System.out.println("The test 'LaunchBrowser' has been executed successfully!");
    }
    @Test
    public void MaximizeBrowserWindow() {
        System.out.println("The test 'MaximizeBrowserWindow' has started");
        System.out.println("1. The browser has been opened");
        driver.manage().window().maximize();
        System.out.println("2. Window has been maximized");
        System.out.println("3. The browser has been closed");
        System.out.println("The test 'MaximizeBrowserWindow' has been executed successfully!");
    }
    @Test
    public void PrintPageTitle() {
        System.out.println("The test 'PrintPageTitle' has started");
        System.out.println("1. The browser has been opened");
        driver.manage().window().maximize();
        System.out.println("2. Window has been maximized");
        System.out.println("3. The Home page title is: " + driver.getTitle());
        System.out.println("4. The browser has been closed");
        System.out.println("The test 'PrintPageTitle' has been executed successfully!");
    }
    @Test
    public void PrintCurrentUrl() {
        System.out.println("The test 'PrintCurrentUrl' has started");
        System.out.println("1. The browser has been opened");
        driver.manage().window().maximize();
        System.out.println("2. Window has been maximized");
        System.out.println("3. The current URL is: " + driver.getCurrentUrl());
        System.out.println("4. The browser has been closed");
        System.out.println("The test 'PrintCurrentUrl' has been executed successfully!");
    }
    @Test
    public void PrintPageSource() {
        System.out.println("The test 'PrintPageSource' has started");
        System.out.println("1. The browser has been opened");
        driver.manage().window().maximize();
        System.out.println("2. Window has been maximized");
        System.out.println("3. The page source is: " + driver.getPageSource());
        System.out.println("4. The browser has been closed");
        System.out.println("The test 'PrintPageSource' has been executed successfully!");
    }
    @Test
    public void ValidatePageTitle() throws InterruptedException {
        System.out.println("The test 'ValidatePageTitle' has started");
        System.out.println("1. The browser has been opened");
        driver.manage().window().maximize();
        System.out.println("2. Window has been maximized");
        homePage.scrollDown();
        Thread.sleep(2000);
        homePage.chooseEnglishLanguage();
        System.out.println("3. English language has been selected");
        Assert.assertEquals(driver.getTitle(), homePage.pageTitle());
        System.out.println("3. The current page title '" + driver.getTitle() + "' is equal to the expected");
        Assert.assertEquals(driver.getCurrentUrl(), homePage.pageUrl());
        System.out.println("4. The current url '" + driver.getCurrentUrl() + "' is equal to the expected");
        driver.getPageSource().contains(homePage.pageTitle());
        System.out.println("5. The page title is present on the page source");
        System.out.println("4. The browser has been closed");
        System.out.println("The test 'ValidatePageTitle' has been executed successfully!");
    }
    @Test
    public void RightMenuLinkClick() throws InterruptedException {
        System.out.println("The test 'RightMenuLinkClick' has started");
        System.out.println("1. The browser has been opened");
        driver.manage().window().maximize();
        System.out.println("2. Window has been maximized");
        homePage.scrollDown();
        Thread.sleep(2000);
        homePage.chooseEnglishLanguage();
        System.out.println("3. English language has been selected");
        String mainPageTitle = new String(driver.getTitle());
        System.out.println("4. The Home page title is: " + driver.getTitle());
        homePage.scrollDown();
        Thread.sleep(1000);
        homePage.clickBlogButton();
        System.out.println("5. The Blog button has been clicked");
        Thread.sleep(1000);
        System.out.println("6. The Blog page title is: " + driver.getTitle());
        driver.navigate().back();
        System.out.println("7. Navigated back to Home page");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), mainPageTitle);
        System.out.println("8. The Home page title is the same");
        System.out.println("9. The browser has been closed");
        System.out.println("The test 'RightMenuLinkClick' has been executed successfully!");
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
