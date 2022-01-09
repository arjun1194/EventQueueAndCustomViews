package com.eventqueue.reactPackage.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppExecutors {
    public static final ExecutorService GENERAL = Executors.newSingleThreadExecutor();
}
