package com.android.premission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.permission.Action;
import com.android.permission.AndPermission;
import com.android.permission.Permission;
import com.android.permission.dialog.CommonTextDialog;
import com.android.permission.permission.AlbumRuntimeRationale;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    /**
     * 跳转到设置页面
     */
    private static final int REQUEST_CODE_SETTING = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initPermission();
            }
        });
    }

    private void initPermission() {
        AndPermission.with(MainActivity.this)
                .runtime()
                .permission(Permission.CAMERA, Permission.RECORD_AUDIO)
                .rationale(new AlbumRuntimeRationale("需要开启用户权限"))
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        Toast.makeText(MainActivity.this, "success", Toast.LENGTH_LONG).show();
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        final CommonTextDialog commonTextDialog = new CommonTextDialog(MainActivity.this);
                        commonTextDialog.show();
                        commonTextDialog.setCancleVisibility(View.VISIBLE);
                        commonTextDialog.setCancleOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                commonTextDialog.dismiss();
                            }
                        });
                        commonTextDialog.setSubmitOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AndPermission.with(MainActivity.this).runtime().setting().start(REQUEST_CODE_SETTING);
                                commonTextDialog.dismiss();
                            }
                        });
                    }
                }).start();
    }
}
