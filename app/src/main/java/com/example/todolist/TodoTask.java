package com.example.todolist;

public class TodoTask {
    String name, memo;

    public TodoTask(String name, String memo) {
        this.name = name;
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
