package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test

    public void testRegistration(){
        app.registartion().start("user1", "user1@localhost.localdomain");

    }
}
