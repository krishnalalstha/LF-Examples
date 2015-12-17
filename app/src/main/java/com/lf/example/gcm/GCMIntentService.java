package com.lf.example.gcm;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.lf.example.R;
import com.lf.example.SplashActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class GCMIntentService extends IntentService {
	public static final int NOTIFICATION_ID = 1;
	private NotificationManager mNotificationManager;
	NotificationCompat.Builder builder;

	public GCMIntentService() {
		super("GcmIntentService");
	}

	public static final String FROM_NOTIFICATION = "fromNotification";

	@Override
	protected void onHandleIntent(Intent intent) {
		Bundle extras = intent.getExtras();


				Log.v("Notification response", extras.toString());


		GCMBroadcastReceiver.completeWakefulIntent(intent);
	}

	// Put the message into a notification and post it.
	// This is just one simple example of what you might choose to do with
	// a GCM message.
	private void sendNotification(Bundle bundle) {
		if (bundle == null)
			return;
		try {
			JSONObject obj = new JSONObject(bundle.getString("message"));
			mNotificationManager = (NotificationManager) this
					.getSystemService(Context.NOTIFICATION_SERVICE);


			// setAction should
			// be set to
			// propagate
			// extra

			PendingIntent contentIntent = PendingIntent.getActivity(this,
					obj.getInt("groupId"), new Intent(this, SplashActivity.class),
					PendingIntent.FLAG_UPDATE_CURRENT);

			NotificationCompat.Builder mBuilder;

			mBuilder = new NotificationCompat.Builder(this)
					.setSmallIcon(R.drawable.ic_cast_off_light)
					.setContentTitle(obj.getString("title"))
					.setStyle(
							new NotificationCompat.BigTextStyle().bigText(obj
									.getString("title"))).setContentText("");
			mBuilder.setContentIntent(contentIntent);
			Notification notification = mBuilder.build();
			notification.flags |= Notification.FLAG_AUTO_CANCEL;
			notification.defaults |= Notification.DEFAULT_VIBRATE;
			notification.defaults |= Notification.DEFAULT_SOUND;

			mNotificationManager.notify(1, notification);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}
}
