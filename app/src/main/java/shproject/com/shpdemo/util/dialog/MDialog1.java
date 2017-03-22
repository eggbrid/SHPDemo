package shproject.com.shpdemo.util.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import shproject.com.shpdemo.R;


/**
 * Created by yanghaitao on 2016/9/20.
 */

public class MDialog1 extends Dialog implements DialogInterface {
    ImageView ivTitleIcon;
    TextView tvTitleText;
    View titleDivider;
    TextView tvMessage;
    View bottomDivider;
    Button btn1;
    View btnDivider;
    Button btn2;

    private View mDialogView;

    public MDialog1(Context context) {
        this(context, R.style.dialog_untran);
    }

    public MDialog1(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes((WindowManager.LayoutParams) params);
    }

    private void initView(Context context) {
        mDialogView = View.inflate(context, R.layout.other_dialog_layout_view, null);
        ivTitleIcon = (ImageView) mDialogView.findViewById(R.id.iv_title_icon);
        tvTitleText = (TextView) mDialogView.findViewById(R.id.tv_title_text);
        titleDivider = (View) mDialogView.findViewById(R.id.title_divider);
        tvMessage = (TextView) mDialogView.findViewById(R.id.tv_message);
        bottomDivider = (View) mDialogView.findViewById(R.id.bottom_divider);
        btn1 = (Button) mDialogView.findViewById(R.id.btn1);
        btnDivider = (View) mDialogView.findViewById(R.id.btn_divider);
        btn2 = (Button) mDialogView.findViewById(R.id.btn2);
        setContentView(mDialogView);
    }

    public void setTitleIcon(int resId) {
        ivTitleIcon.setImageResource(resId);
    }

    public void setTitle(String title) {
        tvTitleText.setText(title);
    }

    public void setMessage(String message) {
        tvMessage.setText(message);
    }

    public void setBtn1Text(String titleText, final MDialog.OnMDialogClickListener MDialogBtnlistener) {
        btn1.setVisibility(View.VISIBLE);
        btn1.setText(titleText);
        if (MDialogBtnlistener != null) {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MDialogBtnlistener.onClick(MDialog1.this, v);
                }
            });
        } else {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
    }

    public void setBtn2Text(String titleText, final MDialog.OnMDialogClickListener MDialogBtnlistener) {
        btn2.setVisibility(View.VISIBLE);
        btn2.setText(titleText);
        btnDivider.setVisibility(View.VISIBLE);
        if (MDialogBtnlistener != null) {
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MDialogBtnlistener.onClick(MDialog1.this, v);
                }
            });
        } else {
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
    }

    private MDialog.OnMDialogClickListener MDialoglistener;

    public void setMDialogBtnlistener(MDialog.OnMDialogClickListener MDialogBtnlistener) {
        this.MDialoglistener = MDialogBtnlistener;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
