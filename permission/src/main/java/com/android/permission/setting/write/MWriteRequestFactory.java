package com.android.permission.setting.write;

import com.android.permission.setting.Setting;
import com.android.permission.source.Source;

public class MWriteRequestFactory implements Setting.SettingRequestFactory {

    @Override
    public WriteRequest create(Source source) {
        return new MWriteRequest(source);
    }
}
