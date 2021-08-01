package tests.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import tests.repository.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager implements Repository {
    public WebDriver wd;
    String browser;
    WebElement element;
    List<WebElement> elements;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equals(BrowserType.FIREFOX)) wd= new FirefoxDriver();
        else
        if(browser.equals(BrowserType.CHROME)) wd = new ChromeDriver();
        else
        if(browser.equals(BrowserType.EDGE)) wd = new EdgeDriver();
        else
            System.out.println("Unknown browser type.");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        openSite(START_URL);
    }

    public void stop() {
        wd.quit();
    }

    public void openSite(String url) {
        wd.get(url);
    }


    //---------------------------------------------------------------------------------------------------------------

    public String returnCurrentURL () {
        return wd.getCurrentUrl().toString();
    }

    public void type(String selector, String text)  {
        element = findElement(selector);
        element.click();
        element.clear();
        element.sendKeys(text);
        pause(1000);
    }

    public WebElement findElement (String selector) {
        try {
            By by = returnLocator(selector);
            element = wd.findElement(by);
            return element;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
            throw e;
        }
    }

    public void waitForElement (String selector) {
        while (!isElementPresent(selector)){
            pause(200);
        }
    }

    public boolean isElementPresent(String selector) {
        try {
            By by = returnLocator(selector);
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void click(String selector) {
        element = findElement(selector);
        element.click();
        pause(1000);
    }

    public By returnLocator (String selector) {
        if (isElementPresent(By.xpath(selector))) return By.xpath(selector);
        if (isElementPresent(By.id(selector))) return By.id(selector);
        if (isElementPresent(By.cssSelector(selector))) return By.cssSelector(selector);
        if (isElementPresent(By.className(selector))) return By.className(selector);
        if (isElementPresent(By.linkText(selector))) return By.linkText(selector);
        if (isElementPresent(By.name(selector))) return By.name(selector);
        return null;
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void pause(long milliSeconds) {
        long time = System.currentTimeMillis();
        long stopTime = time + milliSeconds;
        while (time < stopTime) {
            time = System.currentTimeMillis();
        }
    }
}
