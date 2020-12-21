package com.example.todolist.data;

public class TaskList {

    private String title;
    private int size;
    private String uid;

    public TaskList(String title, int size, String uid) {
        this.title = title;
        this.size = size;
        this.uid = uid;
    }

    public TaskList() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
