package com.android.permission.option;

import com.android.permission.install.InstallRequest;
import com.android.permission.notify.option.NotifyOption;
import com.android.permission.overlay.OverlayRequest;
import com.android.permission.runtime.option.RuntimeOption;
import com.android.permission.setting.Setting;

public interface Option {

    /**
     * Handle runtime permissions.
     */
    RuntimeOption runtime();

    /**
     * Handle request package install permission.
     */
    InstallRequest install();

    /**
     * Handle overlay permission.
     */
    OverlayRequest overlay();

    /**
     * Handle notification permission.
     */
    NotifyOption notification();

    /**
     * Handle system setting.
     */
    Setting setting();
}
