package com.example.mohamedtaskmngr.data;

public class MyClient {
    private String etFirstName2;
    private String etLastName2;
    private String etPhone3;
    private String key;
    private String owner;

    public String getKey() {
        return key;
    }

    public String getEtFirstName2() {
        return etFirstName2;
    }

    public String getEtLastName2() {
        return etLastName2;
    }

    public String getEtPhone3(String phone) {
        return etPhone3;

    }

    public void setOwner(String owner) {
        this.owner = owner;
    }



    public void setEtFirstName2(String etFirstName2) {
        this.etFirstName2 = etFirstName2;
    }

    public void setEtLastName2(String etLastName2) {
        this.etLastName2 = etLastName2;
    }

    public void setEtPhone3(String etPhone3) {
        this.etPhone3 = etPhone3;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "MyClient{" +
                "etFirstName2='" + etFirstName2 + '\'' +
                ", etLastName2='" + etLastName2 + '\'' +
                ", etPhone3='" + etPhone3 + '\'' +
                ", key='" + key + '\'' +
                '}';
    }


}
