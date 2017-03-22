package shproject.com.shpdemo.util.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import shproject.com.shpdemo.R;


/**
 * Created by yanghaitao on 16/5/10.
 */
public class MDialog {
    private Context mContext;
    private MDialog1 mDialog1;

    public MDialog(Context mContext) {
        this.mContext = mContext;
    }

    public Dialog showDialog(String message){
        return showDialog(mContext,mContext.getString(R.string.other_dialog_default_title),message,mContext.getString(R.string.other_dialog_default_btn),null,null,null);
    }

    public Dialog showDialog(int message){
        return showDialog(mContext,mContext.getString(R.string.other_dialog_default_title),mContext.getString(message),mContext.getString(R.string.other_dialog_default_btn),null,null,null);
    }

    public Dialog showDialog(int message, OnMDialogClickListener btn1Click){
        return showDialog(mContext,mContext.getString(R.string.other_dialog_default_title),mContext.getString(message),mContext.getString(R.string.other_dialog_default_btn),null,btn1Click,null);
    }

    public Dialog showDialog(String message, OnMDialogClickListener btn1Click){
        return showDialog(mContext,mContext.getString(R.string.other_dialog_default_title),message,mContext.getString(R.string.other_dialog_default_btn),null,btn1Click,null);
    }

    public Dialog showDialog(String message, String btn1, OnMDialogClickListener btn1Click){
        return showDialog(mContext,mContext.getString(R.string.other_dialog_default_title),message,btn1,null,btn1Click,null);
    }

    public Dialog showDialog(int message, String btn1, OnMDialogClickListener btn1Click){
        return showDialog(mContext,mContext.getString(R.string.other_dialog_default_title),mContext.getString(message),btn1,null,btn1Click,null);
    }

    public Dialog showDialog(String message, String btn1, String btn2, OnMDialogClickListener btn1Click){
        return showDialog(mContext,mContext.getString(R.string.other_dialog_default_title),message,btn1,btn2,btn1Click,null);
    }

    public Dialog showDialog(String btn1, String btn2, OnMDialogClickListener btn1Click, OnMDialogClickListener btn2Click){
        return showDialog(mContext,mContext.getString(R.string.other_dialog_default_title),"",btn1,btn2,btn1Click,btn2Click);
    }

    public Dialog showDialog(String message, String btn1, String btn2, OnMDialogClickListener btn1Click, OnMDialogClickListener btn2Click){
        return showDialog(mContext,mContext.getString(R.string.other_dialog_default_title),message,btn1,btn2,btn1Click,btn2Click);
    }

    public Dialog showDialog(Context context, String title, String message, String btn1, String btn2, OnMDialogClickListener btn1Click, OnMDialogClickListener btn2Click) {
        try {
            mDialog1= new MDialog1(context);
            if (title!=null){
                mDialog1.setTitle(title);
            }
            if (message!=null){
                mDialog1.setMessage(message);
            }
            if (btn1!=null){
                mDialog1.setBtn1Text(btn1,btn1Click);
            }
            if (btn2!=null){
                mDialog1.setBtn2Text(btn2,btn2Click);
            }
            mDialog1.show();
        }catch (Exception e){
            mDialog1=null;
        }
        return mDialog1;
    }

    public void show(){
        mDialog1.show();
    }

    public void dismiss(){
        if (mDialog1!=null){
            try {
                mDialog1.dismiss();
            }catch (Exception e){
            }
        }
        mDialog1=null;
    }

    public interface OnMDialogClickListener{
        public void onClick(Dialog dialog, View v);
    }

}
