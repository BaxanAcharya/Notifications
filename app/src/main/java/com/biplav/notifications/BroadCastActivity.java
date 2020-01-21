package com.biplav.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.biplav.notifications.broadcast.BroadcastReceiverExample;

public class BroadCastActivity extends AppCompatActivity {

    Button btn_noti,btn_ser;
    BroadcastReceiverExample broadcastReceiverExample=new BroadcastReceiverExample();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        btn_noti=findViewById(R.id.btn_noti);

        btn_ser=findViewById(R.id.btn_service);
        btn_ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BroadCastActivity.this,ServiceActivity.class);
                startActivity(intent);
            }
        });
        btn_noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BroadCastActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastReceiverExample,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiverExample);
    }
}
