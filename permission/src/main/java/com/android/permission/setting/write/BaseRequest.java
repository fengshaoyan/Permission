package com.android.permission.setting.write;


import android.content.Context;

import com.android.permission.Action;
import com.android.permission.Rationale;
import com.android.permission.RequestExecutor;
import com.android.permission.source.Source;

abstract class BaseRequest implements WriteRequest {

    private Source mSource;

    private Rationale<Void> mRationale = new Rationale<Void>() {
        @Override
        public void showRationale(Context context, Void data, RequestExecutor executor) {
            executor.execute();
        }
    };
    private Action<Void> mGranted;
    private Action<Void> mDenied;

    BaseRequest(Source source) {
        this.mSource = source;
    }

    @Override
    public final WriteRequest rationale(Rationale<Void> rationale) {
        this.mRationale = rationale;
        return this;
    }

    @Override
    public final WriteRequest onGranted(Action<Void> granted) {
        this.mGranted = granted;
        return this;
    }

    @Override
    public final WriteRequest onDenied(Action<Void> denied) {
        this.mDenied = denied;
        return this;
    }

    /**
     * Why permissions are required.
     */
    final void showRationale(RequestExecutor executor) {
        mRationale.showRationale(mSource.getContext(), null, executor);
    }

    /**
     * Callback acceptance status.
     */
    final void callbackSucceed() {
        if (mGranted != null) {
            mGranted.onAction(null);
        }
    }

    /**
     * Callback rejected state.
     */
    final void callbackFailed() {
        if (mDenied != null) {
            mDenied.onAction(null);
        }
    }
}
