package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;

import java.io.File;

public class HelperBase {
    protected WebDriver driver;
    public boolean acceptNextAlert = true;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null){
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)){
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);

            }
        }
    }

    protected void attach (By locator, File file) {
        if (file != null){
                driver.findElement(locator).sendKeys(file.getAbsolutePath());


        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
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

    protected void type(String locator, String text) {
        click(By.name(locator));
        if (text != null) {
            driver.findElement(By.name(locator)).clear();
            driver.findElement(By.name(locator)).sendKeys(text);
        }
    }
}
