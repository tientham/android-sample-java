package com.tientham.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public class TodoEntity {

    @SerializedName("id")
    private int todoId;

    @SerializedName("title")
    private String title;

    @SerializedName("note")
    private String note;

    @SerializedName("is_completed")
    private boolean isCompleted;

    public TodoEntity() {
    }

    public int getTodoId() {
        return todoId;
    }

    // This is only for MOCK TEST
    public void setTodoId(int todoId) {
        this.todoId = todoId;
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
