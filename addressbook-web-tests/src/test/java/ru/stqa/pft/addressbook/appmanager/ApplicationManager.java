package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sun.plugin2.util.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    public StringBuffer verificationErrors = new StringBuffer();
    public String baseUrl;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equals(org.openqa.selenium.remote.BrowserType.GOOGLECHROME)) {
            System.setProperty("webdriver.chrome.driver", "/Users/dariakozhevnikova/Desktop/chromedriver");
            driver = new ChromeDriver();
        } else if (Objects.equals(browser, org.openqa.selenium.remote.BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "C://Users/kozhed/Documents/GitHub/java_pft/addressbook-web-tests/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (Objects.equals(browser, org.openqa.selenium.remote.BrowserType.IE)) {
            System.setProperty("webdriver.ie.driver", "C://Users/kozhed/Documents/GitHub/java_pft/addressbook-web-tests/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
        }

        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
        contactHelper = new ContactHelper(driver);
    }


    public void stop() {driver.quit();
    }


    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }
}
