package prank.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class Ring extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        String action = i.getAction();
        if (action != null && action.equals("com.apress.START_THE_MUSIC")) {
        	setContentView(R.layout.main);
        	//We'll need to start the music service here
        	startService(new Intent("com.apress.START_AUDIO_SERVICE"));
        } else {
        	finish();
        }
        
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	stopService(new Intent("com.apress.START_AUDIO_SERVICE"));
    	finish();
    	return super.onKeyDown(keyCode, event);
    }
}