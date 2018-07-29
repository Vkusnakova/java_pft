package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by kozhed on 02.04.2018.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                    .withName("v").withLastname("1").withAddress("n").withPhonenumber("455").withEmail("asd@ffhf.ru"));
        }

    }

    @Test
    public void testContactModifiction () {

        List<ContactData> before = app.contact().list();//считаем количество элементов перед модификацией
        int index = 7;
        ContactData contact = new ContactData()
                .withId(before.get(index).getId()).withName("vovka").withLastname("kozhevnikov")
                .withAddress("spb").withPhonenumber("911").withEmail("daria.kozhevnikova@emc.com");

        app.contact().modifyContact(index, contact);
        List<ContactData> after = app.contact().list();//считаем количество элементов после модификацией
        Assert.assertEquals(after.size(), before.size()); // сравниваем количество элементов перед и после модицикации


        before.remove(index); //удаляем последний объект
        before.add(contact); //добавляем модифицированный объект
        Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }


}

