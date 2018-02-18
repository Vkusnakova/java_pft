package ru.stqa.pft.addressbook;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;


    public class ContactCreationTests extends TestBase {


        @Test
        public void testContactCreation() throws Exception {
            addNewContact();
            fillContactForm(new ContactData("daria", "kozhevnikova", "spb", "911", "daria.kozhevnikova@emc.com"));
            submitContactCreation();
            returnToHomePage();
        }


    }

