package com.lf.example;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lf.example.gcm.GcmManager;

/**
 * Created by krishna on 12/14/15.
 */
public class NotificationExampleActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnNotification;
    Button bntSnackbar;

    GcmManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        btnNotification = (Button) findViewById(R.id.btnNotificationDemo);
        bntSnackbar = (Button) findViewById(R.id.btnShowsnackbar);
        btnNotification.setOnClickListener(this);
        bntSnackbar.setOnClickListener(this);
        manager=new GcmManager(this);
        manager.initGCMRegistration();
        Log.e("Message",manager.getRegistrationId(this));

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnNotificationDemo) {
            sendNotification();
        } else {
            Snackbar.make(v, "Helo Snack bar", Snackbar.LENGTH_LONG).show();
        }

    }


    private void sendNotification() {


        NotificationManager mNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);
        Intent mIntent = new Intent(this, NotificationExampleActivity.class);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 1, mIntent
                , PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder mBuilder;

        mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("This is title")
                .setStyle(
                        new NotificationCompat.BigTextStyle().bigText("This Description")).setContentText("This is sort desc");
        mBuilder.setContentIntent(contentIntent);
        Notification notification = mBuilder.build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_LIGHTS;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.flags |= Notification.FLAG_ONLY_ALERT_ONCE;

        mNotificationManager.notify(120, notification);


    }
}
