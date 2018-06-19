package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by kozhed on 02.04.2018.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModifiction () {
        app.getNavigationHelper().gotoHomePage();
        if (!  app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("v", "1", "n", "455", "asd@ffhf.ru"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initContctModification();
        app.getContactHelper().fillContactForm(new ContactData("vova", "kozhevnikov", "spb", "911", "daria.kozhevnikova@emc.com"));
        app.getContactHelper().updateContact();
        app.getContactHelper().returnToHomePage();
    }
}
