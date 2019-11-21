package com.android.permission.setting.write;

import com.android.permission.source.Source;

public class LWriteRequest extends BaseRequest {

    public LWriteRequest(Source source) {
        super(source);
    }

    @Override
    public void start() {
        callbackSucceed();
    }
}