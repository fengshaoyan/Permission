package com.android.permission.notify.listener;

import com.android.permission.RequestExecutor;
import com.android.permission.source.Source;


class J1Request extends BaseRequest implements RequestExecutor {

    J1Request(Source source) {
        super(source);
    }

    @Override
    public void start() {
        callbackSucceed();
    }

    @Override
    public void execute() {
        // Nothing.
    }

    @Override
    public void cancel() {
        // Nothing.
    }
}
