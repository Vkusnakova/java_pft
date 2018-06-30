package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupMofificationTests extends TestBase {

    @Test
    public void groupModificationTests (){
        app.getNavigationHelper().gotoGroupPage();
        if (!  app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("v", "2", "n"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size()-1).getId(),"group", "2", "3");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupmodification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1); //удаляем последний объект
        before.add(group); //добавляем модифицированный объект
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

    }

}
