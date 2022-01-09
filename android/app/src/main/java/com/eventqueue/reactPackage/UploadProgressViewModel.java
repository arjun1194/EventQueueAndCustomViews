package com.eventqueue.reactPackage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eventqueue.reactPackage.Models.Todo;
import com.eventqueue.reactPackage.data.TodoRepository;

import java.util.List;

public class UploadProgressViewModel extends ViewModel {

    private final MutableLiveData<List<Todo>> _todos;
    private final TodoRepository repo;

    // Live data :)
    public LiveData<List<Todo>> todo;

    public UploadProgressViewModel() {
        this._todos = new MutableLiveData<>();
        this.todo = _todos;
        this.repo = new TodoRepository();
    }

    public void getAllTodos() {
        _todos.postValue(repo.getAll());
    }
}
