package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by kozhed on 02.04.2018.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("v", "1", "n", "455", "asd@ffhf.ru"));
        }

    }

    @Test
    public void testContactModifiction () {

        List<ContactData> before = app.getContactHelper().getContactList();//считаем количество элементов перед модификацией
        int index = 7;
        ContactData contact = new ContactData(before.get(index).getId(),"vovka", "kozhevnikov", "spb", "911", "daria.kozhevnikova@emc.com");
        app.getContactHelper().modifyContact(index, contact);
        List<ContactData> after = app.getContactHelper().getContactList();//считаем количество элементов после модификацией
        Assert.assertEquals(after.size(), before.size()); // сравниваем количество элементов перед и после модицикации


        before.remove(index); //удаляем последний объект
        before.add(contact); //добавляем модифицированный объект
        Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }


}

