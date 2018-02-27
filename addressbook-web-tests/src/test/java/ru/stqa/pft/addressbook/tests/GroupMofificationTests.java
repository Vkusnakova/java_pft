package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupMofificationTests extends TestBase {

    @Test
    public void groupModificationTests (){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("1", "2", "3"));
        app.getGroupHelper().submitGroupmodification();
        app.getGroupHelper().returnToGroupPage();

    }

}
