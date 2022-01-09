package com.eventqueue.reactPackage.data;

import com.eventqueue.reactPackage.Models.Todo;
import com.eventqueue.reactPackage.utils.AppExecutors;

import java.util.Arrays;
import java.util.List;

public class TodoRepository {

    public List<Todo> getAll() {
        return Arrays.asList(
                new Todo.Builder()
                        .withId(1L)
                        .withUserId(1L)
                        .withTitle("My Todo")
                        .withCompleted(false)
                        .build(),
                new Todo.Builder()
                        .withId(2L)
                        .withUserId(2L)
                        .withTitle("My Todo")
                        .withCompleted(false)
                        .build(),
                new Todo.Builder()
                        .withId(3L)
                        .withUserId(3L)
                        .withTitle("My Todo")
                        .withCompleted(false)
                        .build(),
                new Todo.Builder()
                        .withId(4L)
                        .withUserId(4L)
                        .withTitle("My Todo")
                        .withCompleted(false)
                        .build(),
                new Todo.Builder()
                        .withId(5L)
                        .withUserId(5L)
                        .withTitle("My Todo")
                        .withCompleted(false)
                        .build(),
                new Todo.Builder()
                        .withId(6L)
                        .withUserId(6L)
                        .withTitle("My Todo")
                        .withCompleted(false)
                        .build(),
                new Todo.Builder()
                        .withId(7L)
                        .withUserId(7L)
                        .withTitle("My Todo")
                        .withCompleted(false)
                        .build(),
                new Todo.Builder()
                        .withId(8L)
                        .withUserId(8L)
                        .withTitle("My Todo")
                        .withCompleted(false)
                        .build(),
                new Todo.Builder()
                        .withId(9L)
                        .withUserId(9L)
                        .withTitle("My Todo")
                        .withCompleted(false)
                        .build()

        );
    }
}
