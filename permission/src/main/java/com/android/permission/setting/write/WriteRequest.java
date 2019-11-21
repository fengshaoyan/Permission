package com.android.permission.setting.write;


import com.android.permission.Action;
import com.android.permission.Rationale;

public interface WriteRequest {

    /**
     * Set request rationale.
     */
    WriteRequest rationale(Rationale<Void> rationale);

    /**
     * Action to be taken when all permissions are granted.
     */
    WriteRequest onGranted(Action<Void> granted);

    /**
     * Action to be taken when all permissions are denied.
     */
    WriteRequest onDenied(Action<Void> denied);

    /**
     * Start install.
     */
    void start();
}
