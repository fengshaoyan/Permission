package com.android.permission;
import android.os.Build;

import com.android.permission.install.InstallRequest;
import com.android.permission.install.NRequestFactory;
import com.android.permission.install.ORequestFactory;
import com.android.permission.notify.Notify;
import com.android.permission.notify.option.NotifyOption;
import com.android.permission.option.Option;
import com.android.permission.overlay.LRequestFactory;
import com.android.permission.overlay.MRequestFactory;
import com.android.permission.overlay.OverlayRequest;
import com.android.permission.runtime.option.RuntimeOption;
import com.android.permission.runtime.Runtime;
import com.android.permission.setting.Setting;
import com.android.permission.source.Source;

public class Boot implements Option {

    private static final InstallRequestFactory INSTALL_REQUEST_FACTORY;
    private static final OverlayRequestFactory OVERLAY_REQUEST_FACTORY;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            INSTALL_REQUEST_FACTORY = new ORequestFactory();
        } else {
            INSTALL_REQUEST_FACTORY = new NRequestFactory();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            OVERLAY_REQUEST_FACTORY = new MRequestFactory();
        } else {
            OVERLAY_REQUEST_FACTORY = new LRequestFactory();
        }
    }

    public interface InstallRequestFactory {

        /**
         * Create apk installer request.
         */
        InstallRequest create(Source source);
    }

    public interface OverlayRequestFactory {

        /**
         * Create overlay request.
         */
        OverlayRequest create(Source source);
    }

    private Source mSource;

    public Boot(Source source) {
        this.mSource = source;
    }

    @Override
    public RuntimeOption runtime() {
        return new Runtime(mSource);
    }

    @Override
    public InstallRequest install() {
        return INSTALL_REQUEST_FACTORY.create(mSource);
    }

    @Override
    public OverlayRequest overlay() {
        return OVERLAY_REQUEST_FACTORY.create(mSource);
    }

    @Override
    public NotifyOption notification() {
        return new Notify(mSource);
    }

    @Override
    public Setting setting() {
        return new Setting(mSource);
    }
}