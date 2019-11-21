package com.android.permission.checker;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;

public class StorageWriteTest implements PermissionTest {

    StorageWriteTest() {
    }

    @Override
    public boolean test() throws Throwable {
        if (!TextUtils.equals(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState())) return true;

        File directory = Environment.getExternalStorageDirectory();
        if (!directory.exists()) return true;

        File parent = new File(directory, "Android");
        if (parent.exists() && parent.isFile()) {
            if (!parent.delete()) return false;
        }
        if (!parent.exists()) {
            if (!parent.mkdirs()) return false;
        }
        File file = new File(parent, "ANDROID.PERMISSION.TEST");
        if (file.exists()) {
            return file.delete();
        } else {
            return file.createNewFile();
        }
    }
}
