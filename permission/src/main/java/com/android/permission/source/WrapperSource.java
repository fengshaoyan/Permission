package com.android.permission.source;

import android.content.Context;
import android.content.Intent;

public class WrapperSource extends Source {

    private Source mSource;

    public WrapperSource(Source source) {
        this.mSource = source;
    }

    @Override
    public Context getContext() {
        return mSource.getContext();
    }

    @Override
    public void startActivity(Intent intent) {
        mSource.startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        mSource.startActivityForResult(intent, requestCode);
    }

    @Override
    public boolean isShowRationalePermission(String permission) {
        return mSource.isShowRationalePermission(permission);
    }
}
