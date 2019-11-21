package com.android.permission.permission;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.android.permission.Rationale;
import com.android.permission.RequestExecutor;
import com.android.permission.dialog.CommonTextDialog;

import java.util.List;

public class AlbumRuntimeRationale implements Rationale<List<String>> {
    private String mRationale;

    public AlbumRuntimeRationale(String rationale) {
        this.mRationale = rationale;
    }

    @Override
    public void showRationale(Context context, List<String> permissions, final RequestExecutor executor) {
        final CommonTextDialog commonTextDialog = new CommonTextDialog(context);
        commonTextDialog.show();
        commonTextDialog.setCommonHintText(mRationale);
        commonTextDialog.setCancleOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commonTextDialog.dismiss();
                executor.execute();
            }
        });
    }
}
