package com.android.permission.notify;

import android.os.Build;

import com.android.permission.notify.listener.J1RequestFactory;
import com.android.permission.notify.listener.J2RequestFactory;
import com.android.permission.notify.listener.ListenerRequest;
import com.android.permission.notify.option.NotifyOption;
import com.android.permission.source.Source;

public class Notify implements NotifyOption {

    private static final PermissionRequestFactory PERMISSION_REQUEST_FACTORY;
    private static final ListenerRequestFactory LISTENER_REQUEST_FACTORY;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            PERMISSION_REQUEST_FACTORY = new ORequestFactory();
        } else {
            PERMISSION_REQUEST_FACTORY = new NRequestFactory();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            LISTENER_REQUEST_FACTORY = new J2RequestFactory();
        } else {
            LISTENER_REQUEST_FACTORY = new J1RequestFactory();
        }
    }

    public interface PermissionRequestFactory {

        /**
         * Create notify request.
         */
        PermissionRequest create(Source source);
    }

    public interface ListenerRequestFactory {

        /**
         * Create notification listener request.
         */
        ListenerRequest create(Source source);
    }

    private Source mSource;

    public Notify(Source source) {
        this.mSource = source;
    }

    public PermissionRequest permission() {
        return PERMISSION_REQUEST_FACTORY.create(mSource);
    }

    public ListenerRequest listener() {
        return LISTENER_REQUEST_FACTORY.create(mSource);
    }
}
