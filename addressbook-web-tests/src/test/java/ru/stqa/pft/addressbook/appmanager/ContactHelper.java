package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by kozhed on 02.04.2018.
 */
public class ContactHelper extends HelperBase{


    public ContactHelper(WebDriver driver) {super(driver);

    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void fillContactForm(ContactData contactData) {
        type("firstname", contactData.getName());
        type("lastname", contactData.getLastname());
        type("address", contactData.getAddress());
        type("home", contactData.getPhonenumber());
        type("email", contactData.getEmail());
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void initContctModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void selectContact() {
        click(By.id("1"));
    }

    public void updateContact() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }
}
