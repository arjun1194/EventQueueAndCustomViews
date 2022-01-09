package com.eventqueue.reactPackage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import timber.log.Timber;

public class MyDataEmitter {

    private static final Executor myExecutor = Executors.newSingleThreadExecutor();
    private Integer a = 0;

    MutableLiveData<Integer> myLiveData = new MutableLiveData<>();

    public MyDataEmitter() {
        myExecutor.execute(() -> {
            while(a > 100000) {
                myLiveData.postValue(a);
                a = a +1;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Timber.e(e);
                }
            }
        });
    }

    public LiveData<Integer> getMyLiveData() {
        return myLiveData;
    }
}
