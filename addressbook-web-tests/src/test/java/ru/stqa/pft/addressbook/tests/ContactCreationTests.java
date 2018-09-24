package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase {


    @DataProvider
    public Iterator<Object[]> validContacts(){
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src/test/resources/test.jpg");
        list.add(new Object[] {new ContactData().withName("name1").withLastname("last1").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withName("name2").withLastname("last2").withPhoto(photo)});
        list.add(new Object[] {new ContactData().withName("name3").withLastname("last3").withPhoto(photo)});
        return list.iterator();
    }

        @Test(dataProvider = "validContacts")
        public void testContactCreation(ContactData contact) throws Exception {
            app.goTo().homePage();
            Contacts before = app.contact().all();
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

