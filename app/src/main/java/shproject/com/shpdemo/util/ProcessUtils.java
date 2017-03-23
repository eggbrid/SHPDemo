package shproject.com.shpdemo.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by yanghaitao on 16/5/26.
 */
public class ProcessUtils {
    private static ProgressDialog progressDialog;

    public static void show(Context context, int message) {
        String text = context.getString(message);
        show(context, text);
    }

    public static void show(Context context, String message) {
        try {
            dismiss();
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(message);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    progressDialog = null;
                }
            });
            progressDialog.show();
        } catch (Exception e) {
            progressDialog = null;
        }
    }

    public static boolean isDismiss() {
        if (progressDialog != null) {
            return false;
        }
        return true;
    }

    public static void dismiss() {
        try {
            if (progressDialog != null)
                progressDialog.dismiss();
        } catch (Exception e) {
        } finally {
            progressDialog = null;
        }
    }

}
