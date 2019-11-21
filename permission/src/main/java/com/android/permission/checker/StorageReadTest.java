package com.android.permission.checker;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;

public class StorageReadTest implements PermissionTest {

    StorageReadTest() {
    }

    @Override
    public boolean test() throws Throwable {
        if (!TextUtils.equals(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState())) return true;

        File directory = Environment.getExternalStorageDirectory();
        if (!directory.exists()) return true;

        long modified = directory.lastModified();
        String[] pathList = directory.list();
        return modified > 0 && pathList != null;
    }
}
