package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by kozhed on 02.04.2018.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModifiction () {
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactCounter(); //считаем количество элементов перед модификацией
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("v", "1", "n", "455", "asd@ffhf.ru"));
        }
        //app.getContactHelper().selectContact(before-1);
        app.getContactHelper().initContactModification(before-1);
        app.getContactHelper().fillContactForm(new ContactData("vovka - molodec", "kozhevnikov", "spb", "911", "daria.kozhevnikova@emc.com"));
        app.getContactHelper().updateContact();
        app.getContactHelper().returnToHomePage();
        int after = app.getContactHelper().getContactCounter(); //считаем количество элементов после модификацией
        Assert.assertEquals(after, before); // сравниваем количество элементов перед и после модицикации
    }
}
