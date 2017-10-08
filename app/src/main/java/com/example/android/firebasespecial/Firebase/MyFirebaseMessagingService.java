package com.example.android.firebasespecial.Firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.example.android.firebasespecial.MainActivity;
import com.example.android.firebasespecial.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Divyani on 08-10-2017.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService
{
    private static final String  TAG="MyFirebaseMsgService";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        sendNotification(remoteMessage.getNotification().getBody());
    }

    private void sendNotification(String body) {
        Intent i=new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 , i, PendingIntent.FLAG_ONE_SHOT);

        //Notification Sound
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);




        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("My Title");
        notificationBuilder.setContentText("This is message Body");
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setSound(defaultSoundUri);
        notificationBuilder.setContentIntent(pendingIntent);


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());

        //startActivity(i);
    }
}
