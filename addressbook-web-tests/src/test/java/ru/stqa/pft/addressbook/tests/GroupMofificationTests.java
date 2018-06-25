package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupMofificationTests extends TestBase {

    @Test
    public void groupModificationTests (){
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCounter();
        if (!  app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("v", "2", "n"));
        }
        app.getGroupHelper().selectGroup(before-1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("group", "2", "3"));
        app.getGroupHelper().submitGroupmodification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCounter();
        Assert.assertEquals(after, before);

    }

}
