package com.android.permission.setting;

import android.os.Build;

import com.android.permission.setting.write.LWriteRequestFactory;
import com.android.permission.setting.write.MWriteRequestFactory;
import com.android.permission.setting.write.WriteRequest;
import com.android.permission.source.Source;

public class Setting {
    private static final SettingRequestFactory SETTING_REQUEST_FACTORY;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            SETTING_REQUEST_FACTORY = new MWriteRequestFactory();
        } else {
            SETTING_REQUEST_FACTORY = new LWriteRequestFactory();
        }
    }

    public interface SettingRequestFactory {

        WriteRequest create(Source source);
    }

    private Source mSource;

    public Setting(Source source) {
        this.mSource = source;
    }

    /**
     * Handle write system settings.
     */
    public WriteRequest write() {
        return SETTING_REQUEST_FACTORY.create(mSource);
    }
}
