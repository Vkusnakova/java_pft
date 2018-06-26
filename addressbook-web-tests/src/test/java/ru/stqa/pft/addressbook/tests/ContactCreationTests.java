package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class ContactCreationTests extends TestBase {


        @Test
        public void testContactCreation() throws Exception {
            app.getNavigationHelper().gotoHomePage();
            List<ContactData> before = app.getContactHelper().getContactList();
            app.getContactHelper().createContact(new ContactData("daria", "kozhevnikova", "spb", "911", "daria.kozhevnikova@emc.com"));
            List<ContactData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size()+1);
        }


    }

