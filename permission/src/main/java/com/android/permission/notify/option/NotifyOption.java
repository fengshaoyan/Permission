package com.android.permission.notify.option;

import com.android.permission.notify.PermissionRequest;
import com.android.permission.notify.listener.ListenerRequest;

public interface NotifyOption {
    /**
     * Handle permissions.
     */
    PermissionRequest permission();

    /**
     * Handle notify listener.
     */
    ListenerRequest listener();
}
