package ru.stqa.pft.addressbook;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;


    public class ContactCreation {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @BeforeClass(alwaysRun = true)
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
            driver = new ChromeDriver();
            baseUrl = "https://www.katalon.com/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            login("admin", "secret");
        }

        @Test
        public void testContactCreation() throws Exception {
            addNewContact();
            fillContactForm(new ContactData("daria", "kozhevnikova", "spb", "911", "daria.kozhevnikova@emc.com"));
            submitContactCreation();
            returnToHomePage();
        }

        private void returnToHomePage() {
            driver.findElement(By.linkText("home")).click();
        }

        private void submitContactCreation() {
            driver.findElement(By.name("submit")).click();
        }

        private void fillContactForm(ContactData contactData) {
            driver.findElement(By.name("firstname")).click();
            driver.findElement(By.name("firstname")).clear();
            driver.findElement(By.name("firstname")).sendKeys(contactData.getName());
            driver.findElement(By.name("lastname")).click();
            driver.findElement(By.name("lastname")).clear();
            driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
            driver.findElement(By.name("address")).click();
            driver.findElement(By.name("address")).clear();
            driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
            driver.findElement(By.name("home")).click();
            driver.findElement(By.name("home")).clear();
            driver.findElement(By.name("home")).sendKeys(contactData.getPhonenumber());
            driver.findElement(By.name("email")).click();
            driver.findElement(By.name("email")).clear();
            driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
        }

        private void addNewContact() {
            driver.findElement(By.linkText("add new")).click();
        }

        private void login(String login, String password) {
            driver.get("http://localhost/addressbook/index.php");
            driver.findElement(By.name("user")).clear();
            driver.findElement(By.name("user")).sendKeys(login);
            driver.findElement(By.name("pass")).clear();
            driver.findElement(By.name("pass")).sendKeys(password);
            driver.findElement(By.xpath("//input[@value='Login']")).click();
        }

        @AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
    }
