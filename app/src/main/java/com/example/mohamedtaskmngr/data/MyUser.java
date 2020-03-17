package com.example.mohamedtaskmngr.data;

public class MyUser  {
    private String pass;
    private String key;
    private String email;


    public String getPass() {
        return pass;
    }

    public String getKey() {
        return key;
    }

    public String getEmail() {
        return email;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "pass='" + pass + '\'' +
                ", key='" + key + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
