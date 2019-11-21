package com.android.permission.checker;


import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract;

public class CalendarReadTest implements PermissionTest {

    private ContentResolver mResolver;

    CalendarReadTest(Context context) {
        mResolver = context.getContentResolver();
    }

    @Override
    public boolean test() throws Throwable {
        String[] projection = new String[] {CalendarContract.Calendars._ID, CalendarContract.Calendars.NAME};
        @SuppressLint("MissingPermission") Cursor cursor = mResolver.query(CalendarContract.Calendars.CONTENT_URI, projection, null, null, null);
        if (cursor != null) {
            try {
                CursorTest.read(cursor);
            } finally {
                cursor.close();
            }
            return true;
        } else {
            return false;
        }
    }
}
