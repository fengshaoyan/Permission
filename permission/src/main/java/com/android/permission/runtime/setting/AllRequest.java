package com.android.permission.runtime.setting;

import com.android.permission.source.Source;

public class AllRequest implements SettingRequest {

    private Source mSource;

    public AllRequest(Source source) {
        this.mSource = source;
    }

    @Override
    public void start(int requestCode) {
        SettingPage setting = new SettingPage(mSource);
        setting.start(requestCode);
    }
}
