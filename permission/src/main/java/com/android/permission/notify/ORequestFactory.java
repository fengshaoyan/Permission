package com.android.permission.notify;


import com.android.permission.source.Source;

public class ORequestFactory implements Notify.PermissionRequestFactory {

    @Override
    public PermissionRequest create(Source source) {
        return new ORequest(source);
    }
}
