package com.eventqueue.reactPackage;

import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;

import timber.log.Timber;

public class MyReactView extends SimpleViewManager<ProgressBar> {


    @NonNull
    @Override
    public String getName() {
        return "MyReactView";
    }

    @NonNull
    @Override
    protected ProgressBar createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new ProgressBar(reactContext);
    }

    @ReactProp(name = "myProp")
    public void setBackgroundColor(ProgressBar view, @Nullable String color) {
        Timber.d("Color is %s", color);
    }
}
