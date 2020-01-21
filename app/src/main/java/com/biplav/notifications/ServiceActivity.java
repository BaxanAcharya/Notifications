package com.biplav.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.biplav.notifications.service.MyService;

public class ServiceActivity extends AppCompatActivity {

    private Button btn_start,btn_stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        btn_start=findViewById(R.id.btn_start);
        btn_stop=findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyService();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMyService();

            }
        });
    }

    private void startMyService(){
        startService(new Intent(this, MyService.class));
    }

    private void stopMyService(){
        stopService(new Intent(this,MyService.class));
    }
}
