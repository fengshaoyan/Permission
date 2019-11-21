package com.android.permission.notify;


import com.android.permission.source.Source;


public class NRequestFactory implements Notify.PermissionRequestFactory {

    @Override
    public PermissionRequest create(Source source) {
        return new NRequest(source);
    }
}
