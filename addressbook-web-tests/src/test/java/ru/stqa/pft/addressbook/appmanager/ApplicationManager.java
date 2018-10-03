package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    public WebDriver driver;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    public StringBuffer verificationErrors = new StringBuffer();
    public String baseUrl;
    private String browser;

    public ApplicationManager(String browser)  {

        this.browser = browser;
        properties = new Properties();
    }


    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
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
        driver.get(properties.getProperty("web.baseUrl"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login(properties.getProperty("web.adminLogin"),(properties.getProperty("web.adminPassword")));
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
