package com.android.permission.notify.listener;

import com.android.permission.notify.Notify;
import com.android.permission.source.Source;


public class J1RequestFactory implements Notify.ListenerRequestFactory {

    @Override
    public ListenerRequest create(Source source) {
        return new J1Request(source);
    }
}
