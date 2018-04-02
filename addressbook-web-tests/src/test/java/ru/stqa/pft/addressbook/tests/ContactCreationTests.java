package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {


        @Test
        public void testContactCreation() throws Exception {
            app.getContactHelper().addNewContact();
            app.getContactHelper().fillContactForm(new ContactData("daria", "kozhevnikova", "spb", "911", "daria.kozhevnikova@emc.com"));
            app.getContactHelper().submitContactCreation();
            app.getContactHelper().returnToHomePage();
        }


    }

