package com.android.permission.install;

import com.android.permission.Boot;
import com.android.permission.source.Source;

public class ORequestFactory implements Boot.InstallRequestFactory {

    @Override
    public InstallRequest create(Source source) {
        return new ORequest(source);
    }
}
