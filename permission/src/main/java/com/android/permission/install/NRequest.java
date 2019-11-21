package com.android.permission.install;


import com.android.permission.source.Source;

class NRequest extends BaseRequest {

    NRequest(Source source) {
        super(source);
    }

    @Override
    public void start() {
        callbackSucceed();
        install();
    }
}
