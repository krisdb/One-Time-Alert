package com.krisdb.onetimealert;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class OneTimeAlert {

    /**
     * Toast message
     *
     * @param context The context to use to create the Toast.
     * @param key     A unique identifier
     * @param message Message to display
     */
    public static void Toast(Context context, String key, String message) {
        if (!SharedPreferencesHelper.getBoolean(context, key)) {

            Toast.makeText(context, message, Toast.LENGTH_LONG).show();

            SharedPreferencesHelper.put(context, key, true);
        }
    }

    /**
     * Alert dialog
     *
     * @param context The context to use to create the dialog.
     * @param key     A unique identifier
     * @param message Message to display
     */
    public static void Dialog(Context context, String key, String message) {
        if (!SharedPreferencesHelper.getBoolean(context, key)) {

            final AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setMessage(message);
            alert.setNeutralButton("OK", (dialog, which) -> {
                dialog.dismiss();
            }).show();

            SharedPreferencesHelper.put(context, key, true);
        }
    }

    /**
     * Snackbar alert
     *
     * @param context The context to use to create the Snackbar.
     * @param view    The view to find a parent from.
     * @param key     A unique identifier
     * @param message Message to display
     */
    public static void Snackbar(Context context, View view, String key, String message) {
        if (!SharedPreferencesHelper.getBoolean(context, key)) {

            Snackbar.make(context, view, message, Snackbar.LENGTH_LONG).show();

            SharedPreferencesHelper.put(context, key, true);
        }
    }
}
