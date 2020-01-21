package com.biplav.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
//import android.view.Display;
import android.view.View;
import android.widget.Button;

import com.biplav.notifications.createChannel.CreateChannel;

//pending intent
public class MainActivity extends AppCompatActivity {

    int counter=0;
    Button btnPopup,btnBack;
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManagerCompat=NotificationManagerCompat.from(this);
        CreateChannel createChannel=new CreateChannel(this);
        createChannel.createChannel();
        btnPopup=findViewById(R.id.btnPopup);
        btnBack=findViewById(R.id.btnBack);

        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayPopUpNotification();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayBackGroundNotification();
            }
        });
    }

    private void DisplayPopUpNotification(){
       // Notification notification=new NotificationCompat().Builder(this,CreateChannel.CHANNEL_1).
        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_sms_black_24dp)
                .setContentTitle("First Message")
                .setContentText("First Message Body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        counter=counter+1;

notificationManagerCompat.notify(counter,notification);
    }

    private void DisplayBackGroundNotification(){
       // Notification notification=new Notification.Builder(this,CreateChannel.CHANNEL_2);
        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle("Second Message")
                .setContentText("Second Message Body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        counter=counter+1;
        notificationManagerCompat.notify(counter,notification);
    }
}
