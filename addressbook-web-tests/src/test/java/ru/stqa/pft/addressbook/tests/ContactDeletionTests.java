package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

/**
 * Created by kozhed on 02.04.2018.
 */
public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                    .withName("v").withLastname("1").withAddress("n").withPhonenumber("455").withEmail("asd@ffhf.ru"));
        }

    }

    @Test
    public void testContactDeletion () {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        //int index = before.size()-1;
        app.contact().delete(deletedContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(deletedContact); //удаляем последний объект
        Assert.assertEquals(before,after);
    }




}
