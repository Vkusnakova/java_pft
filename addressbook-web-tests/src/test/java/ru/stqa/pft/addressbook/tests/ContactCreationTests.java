package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.*;


public class ContactCreationTests extends TestBase {


        @Test
        public void testContactCreation() throws Exception {
            app.goTo().homePage();
            Set<ContactData> before = app.contact().all();
            ContactData contact = new ContactData().withName("dar").withLastname("koz");
            app.contact().create(contact);
            Set<ContactData> after = app.contact().all();
            Assert.assertEquals(after.size(), before.size()+1);//размер списка после добавленя равен размеру до плюс 1

            contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
            before.add(contact);
            /*Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
            before.sort(byId);
            after.sort(byId);*/
            Assert.assertEquals(before, after);

        }


    }

