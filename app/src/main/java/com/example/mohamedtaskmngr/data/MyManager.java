package com.example.mohamedtaskmngr.data;

public class MyManager {
    private String key;
    private String etFirstName;
    private String etLastName;
    private String etPhone;
    private String owner
            ;

    public String getPhone1() {
        return etPhone;
    }

    public String getKey() {
        return key;
    }

    public String getFname1() {
        return etFirstName;
    }

    public String getLname1() {
        return etLastName;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setFname1(String fname1) {
        this.etFirstName = fname1;
    }

    public void setLname1(String lname1) {
        this.etLastName = lname1;

    }

    public void setPhone1(String phone1) {
        this.etPhone = phone1;
    }

    @Override
    public String toString() {
        return "MyManager{" +
                "key='" + key + '\'' +
                ", fname1='" + etFirstName + '\'' +
                ", lname1='" + etLastName + '\'' +
                ", phone1='" + etPhone + '\'' +
                '}';
    }
}


