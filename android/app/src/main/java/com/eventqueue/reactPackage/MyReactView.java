package com.eventqueue.reactPackage;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.eventqueue.R;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;

import java.util.HashMap;
import java.util.Map;

import timber.log.Timber;

public class MyReactView extends ViewGroupManager<LinearLayout> {


    public MyReactView(ReactContext context) {
    }

    @NonNull
    @Override
    public String getName() {
        return "MyReactView";
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    protected LinearLayout createViewInstance(@NonNull ThemedReactContext reactContext) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(reactContext).inflate(R.layout.activity_main, null, false);
        WebView webView = layout.findViewById(R.id.webview);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                Timber.d("onPageFinished: ");
                WritableMap params = Arguments.createMap();
                reactContext
                        .getJSModule(RCTEventEmitter.class)
                        .receiveEvent(layout.getId(), "onPageFinished", params);
            }
        });
        webView.loadUrl("https://www.google.com");
        webView.setOnLongClickListener(v -> {
            WritableMap params = Arguments.createMap();
            reactContext
                    .getJSModule(RCTEventEmitter.class)
                    .receiveEvent(layout.getId(), "onLongClick", params);
            return false;
        });
        return layout;
    }

    @Nullable
    @Override
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        Map<String, Object> map = new HashMap<>();
        map.put("onPageFinished",
                MapBuilder
                        .builder()
                        .put("phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onLoad")
                        ).build()
        );
        map.put("onLongClick",
                MapBuilder
                        .builder()
                        .put("phasedRegistrationNames",
                                MapBuilder.of("bubbled", "longClick")
                        ).build()
        );
        return map;
    }
}
