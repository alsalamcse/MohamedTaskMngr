package com.example.mohamedtaskmngr.data;

public class MyTurn {
 private String key;
 private String time;
 private String date;
 private String owner;


    public String getOwner() {
        return owner;
    }

    public String getKey() {
        return key;
    }

    public String getTitle() {
        return time;
    }

    public String getSubject() {
        return date;
    }


    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTitle(String title) {
        this.time = title;
    }

    public void setSubject(String subject) {
        this.date = subject;
    }



    @Override
    public String toString() {
        return "MyTurn{" +
                "key='" + key + '\'' +
                ", title='" + time + '\'' +
                ", subject='" + date + '\'' +
                '}';
    }
}

