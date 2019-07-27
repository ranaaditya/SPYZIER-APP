package com.rana_aditya.parent;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends Activity {


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        NotificationChannel channel = new NotificationChannel("mychannel", "mychannel", NotificationManager.IMPORTANCE_DEFAULT);
           NotificationManager manager = getSystemService(NotificationManager.class);
           manager.createNotificationChannel(channel);



        FirebaseMessaging.getInstance().subscribeToTopic("parentclient")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "sucessfull";
                        if (!task.isSuccessful()) {

                            msg = "failed";
                        }

                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });


    }

    public void about_app(View view) {


        Intent intent=new Intent(MainActivity.this, aboutapp.class);
        startActivity(intent);

    }

    public void next(View view) {
        Intent intent=new Intent(MainActivity.this,choice.class);
        startActivity(intent);
        //Intent intent =new Intent(MainActivity.this,screenview.class);
       // startActivity(intent);

    }




}
