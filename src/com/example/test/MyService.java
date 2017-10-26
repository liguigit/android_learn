package com.example.test;

import android.app.Service;
import android.content.Intent;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {  
	  
    public static final String TAG = "MyService";  
  
    @Override  
    public void onCreate() {  
        super.onCreate(); 
        Log.d(TAG, "onCreate() executed");  
    }  
  
    @Override  
    public int onStartCommand(Intent intent, int flags, int startId) {  
        Log.d(TAG, "onStartCommand() executed");
        String action;
		action = intent.getStringExtra("action");
		if(action != null){
			if(action.equals("avplay")){
				
			}
		}
        Rect rect = new Rect();
		rect.left = intent.getIntExtra("left",0);
		rect.top = intent.getIntExtra("top",0);
		rect.right = intent.getIntExtra("right",0);
		rect.bottom = intent.getIntExtra("bottom",0);
		Log.d(TAG, "left:" + rect.left +" top:"+rect.top +" right:" + rect.right +" bottom:" + rect.bottom);
        return super.onStartCommand(intent, flags, startId);  
    }  
      
    @Override  
    public void onDestroy() {  
        super.onDestroy();  
        Log.d(TAG, "onDestroy() executed");  
    }  
  
    @Override  
    public IBinder onBind(Intent intent) {  
        return null;  
    }  
  
}  