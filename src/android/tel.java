package com.ytwl.tel;

import java.net.URISyntaxException;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.util.Log;
import android.net.Uri;

/**
 * This class echoes a string called from JavaScript.
 */
public class tel extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("open")) {
            String tel_str = args.getString(0);
            this.open(tel_str, callbackContext);
            return true;
        }
        return false;
    }

    private void open(String tel_str, CallbackContext callbackContext) {
        if (tel_str != null && tel_str.length() > 0) {
            Activity activity =this.cordova.getActivity();
            Uri mapUri = Uri.parse(tel_str);
            Intent intent = new Intent(Intent.ACTION_DIAL, mapUri);
            activity.startActivity(intent); //启动调用
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
