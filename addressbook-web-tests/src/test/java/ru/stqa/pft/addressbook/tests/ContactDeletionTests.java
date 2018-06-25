package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by kozhed on 02.04.2018.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion () {
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactCounter();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("v", "1", "n", "455", "asd@ffhf.ru"));
        }
        app.getContactHelper().selectContact(before-1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().returnToHomePage();
        int after = app.getContactHelper().getContactCounter();
        Assert.assertEquals(after, before-1);
    }
}
