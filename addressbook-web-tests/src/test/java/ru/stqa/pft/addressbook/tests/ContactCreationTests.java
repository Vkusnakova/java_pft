package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;


public class ContactCreationTests extends TestBase {


        @Test
        public void testContactCreation() throws Exception {
            app.getNavigationHelper().gotoHomePage();
            List<ContactData> before = app.getContactHelper().getContactList();
            ContactData contact = new ContactData("daria", "kozhevnikova", null, null, null);
            app.getContactHelper().createContact(contact);
            List<ContactData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size()+1);//размер списка после добавленя равен размеру до плюс 1

            contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
           // int max =0;
          //  for (ContactData c : after) {
           //         max = c.getId();
           //     }

           // }
          //  contact.setId(max);
            before.add(contact);
            Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

        }


    }

