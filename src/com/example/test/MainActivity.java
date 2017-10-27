package com.example.test;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {  
	  
    private Button startService;  
  
    private Button stopService;  
    
    private final static int MSG_AV_PLAY=1;
    
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_AV_PLAY:
                	Log.v("TEST", "handler MSG_AV_PLAY");
					break;
                default:
                    break;
            }
        }
    };
    
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        startService = (Button) findViewById(R.id.start_service);  
        stopService = (Button) findViewById(R.id.stop_service);  
        startService.setOnClickListener(this);  
        stopService.setOnClickListener(this); 
        startService.addOnLayoutChangeListener(new OnLayoutChangeListener() {

			@Override
			public void onLayoutChange(View arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7,
					int arg8) {
				
			}

		});
    }  
  
    @Override  
    public void onClick(View v) {  
        switch (v.getId()) {  
        case R.id.start_service:
        	Button bt = (Button) findViewById(R.id.start_service);
        	Rect rect = new Rect();
			int location[] = new int[2];
			bt.getLocationOnScreen(location);
			rect.left = location[0];
			rect.top = location[1];
			rect.right = rect.left + bt.getWidth();
			rect.bottom = rect.top + bt.getHeight();
			
            Intent intent = new Intent(this, MyService.class);
         
            intent.putExtra("action", "avpaly"); 
			intent.putExtra("left", rect.left);  
			intent.putExtra("top", rect.top);  
			intent.putExtra("right", rect.right);
            intent.putExtra("bottom", rect.bottom);
            ComponentName name = startService(intent);
			if (name == null) {
				Log.d("LG1", "startService SetVideoRectAndPlay faild");
				handler.sendEmptyMessageDelayed(MSG_AV_PLAY, 100);
			}else {
				Log.d("LG1", "startServic: " + name.getPackageName() + " " + name.getClassName());
			}
            break;  
        case R.id.stop_service:  
            Intent stopIntent = new Intent(this, MyService.class);  
            stopService(stopIntent);  
            break;  
        default:  
            break;  
        }  
    }
  
}  
