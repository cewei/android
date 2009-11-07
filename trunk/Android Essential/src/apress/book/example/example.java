package apress.book.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class example extends Activity {
	
	boolean m_bSplashActive;
	boolean m_bPaused;
	
	long m_dwSplashTime = 3000;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        m_bPaused = false;
        m_bSplashActive = true;
        
        //Very simple timer thread
        Thread splashTimer = new Thread() 
        {
        	public void run()
        	{
        		try
        		{
        			//Wait loop
        			long ms = 0;
        			while(m_bSplashActive && ms < m_dwSplashTime)
        			{
        				sleep(100);
        				//Only advance the timer if we're running.
        				if(!m_bPaused)
        					ms += 100;
        			}
        			//Advance to the next screen.
        			startActivity(new Intent("com.google.app.splashy.CLEARSPLASH"));
        			finish();
        		}
        		catch(Exception e)
        		{
        			//Thread exception
        			System.out.println(e.toString());
        		}
        	}
        };
        
        splashTimer.start();
        
        setContentView(R.layout.splash);
        
        return;        
    }
    @Override
    protected void onStop() {
    	super.onStop();
    }
    @Override
    protected void onPause() {
    	super.onPause();
    	m_bPaused = true;
    }
    @Override
    protected void onResume() {
    	super.onResume();
    	m_bPaused = false;
    }
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	super.onKeyDown(keyCode, event);
    	m_bSplashActive = false;
    	return true;
    }
}