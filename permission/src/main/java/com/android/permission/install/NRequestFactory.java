package com.android.permission.install;


import com.android.permission.Boot;
import com.android.permission.source.Source;

public class NRequestFactory implements Boot.InstallRequestFactory {

    @Override
    public InstallRequest create(Source source) {
        return new NRequest(source);
    }
}
