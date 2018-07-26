package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.*;


public class ContactCreationTests extends TestBase {


        @Test
        public void testContactCreation() throws Exception {
            app.goTo().homePage();
            List<ContactData> before = app.contact().list();
            ContactData contact = new ContactData("daria", "kozhevnikova", null, null, null);
            app.contact().create(contact);
            List<ContactData> after = app.contact().list();
            Assert.assertEquals(after.size(), before.size()+1);//размер списка после добавленя равен размеру до плюс 1

            before.add(contact);
            Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after);

        }


    }

