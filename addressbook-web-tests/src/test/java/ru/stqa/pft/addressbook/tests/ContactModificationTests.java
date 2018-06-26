package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by kozhed on 02.04.2018.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModifiction () {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("v", "1", "n", "455", "asd@ffhf.ru"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();//считаем количество элементов перед модификацией
        app.getContactHelper().initContactModification(0);
        app.getContactHelper().fillContactForm(new ContactData("vovka - molodec", "kozhevnikov", "spb", "911", "daria.kozhevnikova@emc.com"));
        app.getContactHelper().updateContact();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();//считаем количество элементов после модификацией
        Assert.assertEquals(after.size(), before.size()); // сравниваем количество элементов перед и после модицикации
    }
}
