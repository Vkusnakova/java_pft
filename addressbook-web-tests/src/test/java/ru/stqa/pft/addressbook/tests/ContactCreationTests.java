package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.*;


public class ContactCreationTests extends TestBase {


        @Test
        public void testContactCreation() throws Exception {
            app.getNavigationHelper().gotoHomePage();
            List<ContactData> before = app.getContactHelper().getContactList();
            ContactData contact = new ContactData("daria", "kozhevnikova", null, null, null);
            app.getContactHelper().createContact(contact);
            List<ContactData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size()+1);//размер списка после добавленя равен размеру до плюс 1

            before.add(contact);
            Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after);

        }


    }

