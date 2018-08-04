package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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

        Set<ContactData> before = app.contact().all();//считаем количество элементов перед модификацией
        //int index = 7;
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withName("vovka").withLastname("kozhevnikov")
                .withAddress("spb").withPhonenumber("911").withEmail("daria.kozhevnikova@emc.com");

        app.contact().modifyContact(contact);
        Set<ContactData> after = app.contact().all();//считаем количество элементов после модификацией
        Assert.assertEquals(after.size(), before.size()); // сравниваем количество элементов перед и после модицикации


        before.remove(modifiedContact); //удаляем последний объект
        before.add(contact); //добавляем модифицированный объект
        Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
        //before.sort(byId);
        //after.sort(byId);
        Assert.assertEquals(before,after);
    }


}

