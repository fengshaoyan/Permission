package com.android.permission.install;


import com.android.permission.Action;
import com.android.permission.Rationale;

import java.io.File;


public interface InstallRequest {
    /**
     * The apk file.
     *
     * @param file apk file.
     */
    InstallRequest file(File file);

    /**
     * Set request rationale.
     */
    InstallRequest rationale(Rationale<File> rationale);

    /**
     * Action to be taken when all permissions are granted.
     */
    InstallRequest onGranted(Action<File> granted);

    /**
     * Action to be taken when all permissions are denied.
     */
    InstallRequest onDenied(Action<File> denied);

    /**
     * Start install.
     */
    void start();
}
