package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupMofificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("v"));
        }
    }

    @Test
    public void groupModificationTests (){
        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        //int index = before.size()-1;
        GroupData group = new GroupData().withId((modifiedGroup).getId()).withName("group").withHeader("2").withFooter("3");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup); //удаляем последний объект
        before.add(group); //добавляем модифицированный объект
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
       // before.sort(byId);
        //after.sort(byId);
        Assert.assertEquals(before,after);
    }



}
