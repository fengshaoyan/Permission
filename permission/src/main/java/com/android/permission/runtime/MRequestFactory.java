package com.android.permission.runtime;

import com.android.permission.source.Source;


public class MRequestFactory implements Runtime.PermissionRequestFactory {

    @Override
    public PermissionRequest create(Source source) {
        return new MRequest(source);
    }
}
