package com.biplav.notifications.broadcast;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.biplav.notifications.R;
import com.biplav.notifications.createChannel.CreateChannel;


public class BroadcastReceiverExample extends BroadcastReceiver {
    private int counter=0;
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    public void onReceive(Context context, Intent intent) {
        notificationManagerCompat=NotificationManagerCompat.from(context);
        CreateChannel createChannel=new CreateChannel(context);
        createChannel.createChannel();
        boolean noConnectivity;
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity=intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,
                    false
            );

            if (noConnectivity){
                //Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();

                DisplayPopUpNotification(context,"Wifi status", "Disconnected");


            }else {
//                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                DisplayPopUpNotification(context,"Wifi status", "Connected");
            }
        }
    }


    private void DisplayPopUpNotification(Context context,String title, String message){
        Notification notification=new NotificationCompat.Builder(context,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_sms_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        counter=counter+1;

        notificationManagerCompat.notify(counter,notification);
    }


}
