package com.example.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AvPlayReceiver extends BroadcastReceiver
{
	private String TAG = "AvPlayReceiver";
    @Override
    public void onReceive(Context arg0, Intent arg1)
    {
        String action = arg1.getAction();
        if (action == null)
        {
            return;
        }
		Log.v(TAG, action);
        if (action.equals("android.intent.action.HIDTV_AV_PLAY"))
        {
        	Toast.makeText(arg0,"testaa AvPlayReceiver receiver HIDTV_AV_PLAY",Toast.LENGTH_SHORT).show();  
            Log.v(TAG, "AvPlayReceiver receiver HIDTV_AV_PLAY");
        }
		else if (action.equals("android.intent.action.HIDTV_AV_STOP"))
		{
			Toast.makeText(arg0,"testab AvPlayReceiver receiver HIDTV_AV_STOP",Toast.LENGTH_SHORT).show();  
            Log.v(TAG, "AvPlayReceiver receiver HIDTV_AV_STOP");
        }
    }
}
