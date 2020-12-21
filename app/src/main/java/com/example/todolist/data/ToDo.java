package com.example.todolist.data;

class ToDo {
    private String title;
    private String description;
    private boolean status;
    private String date;
    private String list_id;

    public ToDo() {
    }

    public ToDo(String title, String description, boolean status, String date, String list_id) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.date = date;
        this.list_id = list_id;
    }

    public String getList_id() {
        return list_id;
    }

    public void setList_id(String list_id) {
        this.list_id = list_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
