package com.android.permission.notify.listener;

import com.android.permission.notify.Notify;
import com.android.permission.source.Source;

public class J2RequestFactory implements Notify.ListenerRequestFactory {

    @Override
    public ListenerRequest create(Source source) {
        return new J2Request(source);
    }
}
