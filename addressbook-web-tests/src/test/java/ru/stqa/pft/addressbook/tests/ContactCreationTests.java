package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase {


        @Test
        public void testContactCreation() throws Exception {
            app.goTo().homePage();
            Contacts before = app.contact().all();
            ContactData contact = new ContactData().withName("dar").withLastname("koz");
            app.contact().create(contact);
            Contacts after = app.contact().all();
            assertEquals(after.size(), before.size()+1);//размер списка после добавленя равен размеру до плюс 1

            //contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
            //before.add(contact);
            /*Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
            before.sort(byId);
            after.sort(byId);*/
            assertThat(after, equalTo(
                    before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

        }


}

