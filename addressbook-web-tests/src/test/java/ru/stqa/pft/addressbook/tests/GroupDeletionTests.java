package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().gotoGroupPage();
    if (!  app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("v", "2", "n"));
    }
  }

  @Test
  public void testGroupDeletionTests() throws Exception {

    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(before.size()-1); //перед сравнением удаляем один элемент, чтобы списки до и после совпадали
    Assert.assertEquals(before,after);
  }


}
