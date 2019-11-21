package com.android.permission.overlay;


import com.android.permission.Boot;
import com.android.permission.source.Source;

public class LRequestFactory implements Boot.OverlayRequestFactory {

    @Override
    public OverlayRequest create(Source source) {
        return new LRequest(source);
    }
}
