package com.eventqueue.reactPackage;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.eventqueue.R;
import com.eventqueue.reactPackage.data.TodoRepository;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

import timber.log.Timber;

public class UploadProgressViewManager extends ViewGroupManager<RecyclerView> {

    UploadProgressViewModel viewModel;
    ListAdapter adapter = new ListAdapter();

    public UploadProgressViewManager(ReactApplicationContext reactContext) {
        AppCompatActivity act = (AppCompatActivity) reactContext.getCurrentActivity();
        if (act != null) {
            viewModel = new ViewModelProvider(act).get(UploadProgressViewModel.class);
            // attach observers;
            act.runOnUiThread(()->{
                viewModel.todo.observe(act, todos -> {
                    adapter.setMyList(todos);
                    adapter.notifyItemRangeInserted(0,todos.size());
                });
                viewModel.getAllTodos();
            });
        }
    }

    @NonNull
    @Override
    public String getName() {
        return "RCTUploadProgressView";
    }

    @NonNull
    @Override
    protected RecyclerView createViewInstance(@NonNull ThemedReactContext reactContext) {
        RecyclerView layout = (RecyclerView) LayoutInflater.from(reactContext).inflate(R.layout.list_adapter,null, false);
        onCreate(layout);
        return layout;
    }

    private void onCreate(View view) {
        RecyclerView lists = (RecyclerView) view;
        lists.setAdapter(adapter);
    }
}
