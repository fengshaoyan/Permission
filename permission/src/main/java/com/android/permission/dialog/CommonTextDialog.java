package com.android.permission.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.permission.R;


/**
 * 公共提示框
 */
public class CommonTextDialog extends Dialog {

    private TextView dialog_title;//提示标题
    private TextView dialog_text;//提示文字
    private Button btn_cancle;//取消按钮
    private Button btn_submit;//确认按钮

    public CommonTextDialog(@NonNull Context context) {
        super(context, R.style.CustomDialogStyle);
    }

    public CommonTextDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CommonTextDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCommonCancelable(true);
        setContentView(R.layout.item_live_dialog_common_text);
        initView();
    }

    /**
     * 是否可以撤销...外部区域
     */
    public void setCommonCanceledOnTouchOutside(boolean cancleOnTouch) {
        this.setCanceledOnTouchOutside(cancleOnTouch);
    }

    /**
     * 是否可以撤销...返回键
     */
    public void setCommonCancelable(boolean cancelable) {
        this.setCancelable(cancelable);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        dialog_title = findViewById(R.id.dialog_title);
        dialog_text = findViewById(R.id.dialog_text);
        btn_cancle = findViewById(R.id.btn_cancle);
        btn_submit = findViewById(R.id.btn_submit);
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    /**
     * 设置标题是否显示
     */
    public void setCommonTitleVisibility(int visibility) {
        if (dialog_title != null && dialog_title.getVisibility() != visibility) {
            dialog_title.setVisibility(visibility);
        }
    }

    /**
     * 设置标题
     */
    public void setCommonTitleText(String titleText) {
        if (!TextUtils.isEmpty(titleText)) dialog_title.setText(titleText);
    }

    public void setCommonTitleText(int titleText) {
        if (!TextUtils.isEmpty(titleText + "")) dialog_title.setText(titleText);
    }

    /**
     * 设置提示文字
     */
    public void setCommonHintText(String hintText) {
        if (!TextUtils.isEmpty(hintText)) dialog_text.setText(hintText);
    }

    public void setCommonHintText(int hintText) {
        if (!TextUtils.isEmpty(hintText + "")) dialog_text.setText(hintText);
    }

    /**
     * 设置cancle按钮显示
     */
    public void setCancleVisibility(int visibility) {
        btn_cancle.setVisibility(visibility);
    }

    /**
     * 设置取消文字
     */
    public void setCommonCancleText(String cancleText) {
        if (!TextUtils.isEmpty(cancleText + "")) {
            if (btn_cancle.getVisibility() == View.GONE) {
                btn_cancle.setVisibility(View.VISIBLE);
                btn_cancle.setText(cancleText);
            } else {
                btn_cancle.setText(cancleText);
            }
        }
    }

    public void setCommonCancleText(int cancleText) {
        if (!TextUtils.isEmpty(cancleText + "")) {
            if (btn_cancle.getVisibility() == View.GONE) {
                btn_cancle.setVisibility(View.VISIBLE);
                btn_cancle.setText(cancleText);
            } else {
                btn_cancle.setText(cancleText);
            }
        }
    }

    /**
     * 设置确认文字
     */
    public void setCommonSubmitText(String submitText) {
        if (!TextUtils.isEmpty(submitText)) btn_submit.setText(submitText);
    }

    public void setCommonSubmitText(int submitText) {
        if (!TextUtils.isEmpty(submitText + "")) btn_submit.setText(submitText);
    }

    /**
     * 设置cancle事件
     */
    public void setCancleOnClickListener(View.OnClickListener clickListener) {
        if (btn_cancle != null && btn_cancle.getVisibility() == View.VISIBLE)
            btn_cancle.setOnClickListener(clickListener);
    }

    /**
     * 设置submit事件
     */
    public void setSubmitOnClickListener(View.OnClickListener clickListener) {
        if (btn_submit != null) btn_submit.setOnClickListener(clickListener);
    }

}
