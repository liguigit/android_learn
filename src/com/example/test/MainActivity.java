package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {  
	  
    private Button startService;  
  
    private Button stopService;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        startService = (Button) findViewById(R.id.start_service);  
        stopService = (Button) findViewById(R.id.stop_service);  
        startService.setOnClickListener(this);  
        stopService.setOnClickListener(this);  
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
            startService(intent);
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
