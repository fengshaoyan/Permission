package com.android.permission.notify;


import com.android.permission.Action;
import com.android.permission.Rationale;

public interface PermissionRequest {
    /**
     * Set request rationale.
     */
    PermissionRequest rationale(Rationale<Void> rationale);

    /**
     * Action to be taken when all permissions are granted.
     */
    PermissionRequest onGranted(Action<Void> granted);

    /**
     * Action to be taken when all permissions are denied.
     */
    PermissionRequest onDenied(Action<Void> denied);

    /**
     * Start install.
     */
    void start();
}
