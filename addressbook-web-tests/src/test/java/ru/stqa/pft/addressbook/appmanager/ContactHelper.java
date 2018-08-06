package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by kozhed on 02.04.2018.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver driver) {
        super(driver);

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

    public void modifyContact(ContactData contact) {
       initContactModificationById(contact.getId());
       fillContactForm(contact);
       updateContact();
       returnToHomePage();
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void initContactModification(int index) {
        driver.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void initContactModificationById(int id) {
        driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void selectContact(int index) {

        driver.findElements(By.name("selected[]")).get(index).click();
    }
    private void selectContactById(int id) {
        driver.findElement(By.cssSelector("input[value = '" + id +"']")).click();;
    }

    public void updateContact() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }
    public void delete(int index) {
        selectContact(index);
        deleteSelectedContact();
        returnToHomePage();
    }
    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        returnToHomePage();

    }




    public void create(ContactData contact) {
        addNewContact();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }


    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCounter() {
        return driver.findElements(By.name("selected[]")).size();
    }


   public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();

       List<WebElement> elements = driver.findElements(By.cssSelector("#maintable tr[name='entry']"));
       for (WebElement element : elements) {
           String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
           String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
           int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
           contacts.add(new ContactData().withId(id).withName(name).withLastname(lastname));
        }
        return contacts;

    }
    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = driver.findElements(By.cssSelector("#maintable tr[name='entry']"));
        for (WebElement element : elements) {
            String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withName(name).withLastname(lastname));
        }
        return contacts;

    }


}

     //   List<WebElement> elements = driver.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']/td[1]"));
    //    for (WebElement element : elements) {
      //  String name = element.findElement(By.xpath("//td[2]")).getText();
      //  String lastname = element.findElement(By.xpath("//td[3]")).getText();


