import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By blogButton = By.xpath("//a[@data-track-name='go_daddy_blog_link']");
    private By languageButton = By.xpath("//*[@id=\"id-5a746d15-fd16-4094-8dcc-92b93a13be8b\"]/div[1]/div[1]/div[1]/a");
    private By languageSetToEnglish = By.xpath("//a[@class='btn tray-toggle'][text()='United States - English']");
    private By chooseEnglish = By.xpath("//a[@data-market='en-US']");

    public HomePage clickBlogButton() {
        driver.findElement(blogButton).click();
        return new HomePage(driver);
    }
    public String pageTitle() {
        String pageTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        return pageTitle;
    }
    public String pageUrl() {
        String pageUrl = "https://www.godaddy.com/";
        return pageUrl;
    }
    public HomePage chooseEnglishLanguage() {
        if (!driver.getCurrentUrl().equalsIgnoreCase("https://www.godaddy.com/")) {
            driver.findElement(languageButton).click();
            driver.findElement(chooseEnglish).click();
        }
        else {
        }
        return new HomePage(driver);
    }
    public HomePage scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,11000)", "");
        return new HomePage(driver);
    }
}

