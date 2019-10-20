package com.example.mohamedtaskmngr.data;

public class MyTask {
 private String key;
 private String title;
 private String subject;
 private String owner;
 private int important;

    public String getOwner() {
        return owner;
    }

    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public int getImportant() {
        return important;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", important=" + important +
                '}';
    }
}

