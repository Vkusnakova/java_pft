package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private  int id = Integer.MAX_VALUE;
    private String name;
    private String lastname;
    private String address;
    private String homePhone;
    private String workPhone;
    private String mobilePhone;
    private String email;
    private String allPhones;






    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }
    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }
    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }
    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getAllPhones() {
        return allPhones;
    }



    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", homephone='" + homePhone + '\'' +
                ", workphone='" + workPhone + '\'' +
                ", mobilephone='" + mobilePhone + '\'' +
                '}';
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(workPhone, that.workPhone) &&
                Objects.equals(mobilePhone, that.mobilePhone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, lastname, homePhone, workPhone, mobilePhone);
    }



}
