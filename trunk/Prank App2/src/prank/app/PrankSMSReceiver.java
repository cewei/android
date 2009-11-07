package prank.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

public class PrankSMSReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Object[] pdusObject = (Object[]) arg1.getExtras().get("pdus");
		SmsMessage msg[] = new SmsMessage[pdusObject.length];
		for (int i=0; i<pdusObject.length;i++) {
			msg[i] = SmsMessage.createFromPdu((byte[])pdusObject[i]);
			String msgTxt = msg[i].getMessageBody();
			if (msgTxt.equals("0xBADCAT0_Fire_The_Missiles!")) {
				Intent startActivity = new Intent();
				startActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity.setAction("com.apress.START_THE_MUSIC");
				arg0.startActivity(startActivity);
			}
		}
		
		return;
	}

}
