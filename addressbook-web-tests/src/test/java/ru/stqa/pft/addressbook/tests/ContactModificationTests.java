package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by kozhed on 02.04.2018.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withName("v").withLastname("1").withAddress("n").withEmail("asd@ffhf.ru"));
        }

    }

    @Test
    public void testContactModifiction () {

        Contacts before = app.contact().all();//считаем количество элементов перед модификацией
        //int index = 7;
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withName("vovka").withLastname("kozhevnikov")
                .withAddress("spb")
                .withEmail("daria.kozhevnikova@emc.com");

        app.contact().modifyContact(contact);
        assertThat(app.contact().count(), equalTo(before.size()));// сравниваем количество элементов перед и после модицикации
        Contacts after = app.contact().all();//считаем количество элементов после модификацией
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}

