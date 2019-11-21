package com.android.permission.overlay;

import com.android.permission.RequestExecutor;
import com.android.permission.bridge.BridgeRequest;
import com.android.permission.bridge.RequestManager;
import com.android.permission.source.Source;


class LRequest extends BaseRequest implements RequestExecutor, BridgeRequest.Callback {

    private Source mSource;

    LRequest(Source source) {
        super(source);
        this.mSource = source;
    }

    @Override
    public void start() {
        if (tryDisplayDialog(mSource.getContext())) {
            callbackSucceed();
        } else {
            showRationale(this);
        }
    }

    @Override
    public void execute() {
        BridgeRequest request = new BridgeRequest(mSource);
        request.setType(BridgeRequest.TYPE_ALERT_WINDOW);
        request.setCallback(this);
        RequestManager.get().add(request);
    }

    @Override
    public void cancel() {
        callbackFailed();
    }

    @Override
    public void onCallback() {
        if (tryDisplayDialog(mSource.getContext())) {
            callbackSucceed();
        } else {
            callbackFailed();
        }
    }
}