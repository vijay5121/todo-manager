package com.practice.todo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Todo {
    private int id;
    private String title;
    private String content;
    private String status;

    private Date addeddate;
    @JsonFormat(pattern ="dd/MM/yyyy")
    private Date todocompletedate;

    public Todo(int id, String title, String content, String status,Date addeddate,Date todocompletedate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.addeddate=addeddate;
        this.todocompletedate=todocompletedate;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public Date getTodocompletedate() {
        return todocompletedate;
    }

    public void setTodocompletedate(Date todocompletedate) {
        this.todocompletedate = todocompletedate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", addeddate=" + addeddate +
                ", todocompletedate=" + todocompletedate +
                '}';
    }
}
