package com.tientham.androidsample.model;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public class TodoModel {

    private final int todoId;

    public TodoModel(int todoId) {
        this.todoId = todoId;
    }

    private String title;
    private String note;
    private boolean isCompleted;

    public int getTodoId() {
        return todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
