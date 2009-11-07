package prank.app;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PrankService extends Service {
	MediaPlayer player = null;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		try {
			player = MediaPlayer.create((Context)this, R.raw.test);
			player.start();
		} catch (Exception e) {
			System.out.println("Exception while starting audio");
		}
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		player.stop();
	}
}
