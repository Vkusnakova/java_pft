package ru.stqa.pft.addressbook;

public class ContactData {
    private final String name;
    private final String lastname;
    private final String address;
    private final String phonenumber;
    private final String email;

    public ContactData(String name, String lastname, String address, String phonenumber, String email) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }
}
