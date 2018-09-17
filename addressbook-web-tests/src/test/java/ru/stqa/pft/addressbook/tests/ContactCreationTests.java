package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase {


        @Test
        public void testContactCreation() throws Exception {
            app.goTo().homePage();
            Contacts before = app.contact().all();
            File photo = new File("src/test/resources/test.jpg");
            ContactData contact = new ContactData().withName("dar").withLastname("koz").withPhoto(photo);
            app.contact().create(contact);
            assertThat(app.contact().count(), equalTo(before.size() +1));//размер списка после добавленя равен размеру до плюс 1
            Contacts after = app.contact().all();
            assertThat(after, equalTo(
                    before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

        }

     /*   @Test
    public void testCurrentDir() {
            File currentDir = new File(".");
            System.out.println(currentDir.getAbsolutePath());
            File photo = new File("src/test/resources/test.jpg");
            System.out.println(photo.getAbsolutePath());
            System.out.println(photo.exists());
    }*/

}

