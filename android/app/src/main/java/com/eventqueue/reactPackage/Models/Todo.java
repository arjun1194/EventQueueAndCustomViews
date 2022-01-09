
package com.eventqueue.reactPackage.Models;

import com.google.gson.annotations.SerializedName;

public class Todo {

    @SerializedName("completed")
    private Boolean mCompleted;
    @SerializedName("id")
    private Long mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("userId")
    private Long mUserId;

    public Boolean getCompleted() {
        return mCompleted;
    }

    public Long getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Long getUserId() {
        return mUserId;
    }

    public static class Builder {

        private Boolean mCompleted;
        private Long mId;
        private String mTitle;
        private Long mUserId;

        public Todo.Builder withCompleted(Boolean completed) {
            mCompleted = completed;
            return this;
        }

        public Todo.Builder withId(Long id) {
            mId = id;
            return this;
        }

        public Todo.Builder withTitle(String title) {
            mTitle = title;
            return this;
        }

        public Todo.Builder withUserId(Long userId) {
            mUserId = userId;
            return this;
        }

        public Todo build() {
            Todo todo = new Todo();
            todo.mCompleted = mCompleted;
            todo.mId = mId;
            todo.mTitle = mTitle;
            todo.mUserId = mUserId;
            return todo;
        }

    }

}
