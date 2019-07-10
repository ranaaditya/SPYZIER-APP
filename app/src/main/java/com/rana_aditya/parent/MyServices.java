package com.rana_aditya.parent;


import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyServices extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        shownotification(remoteMessage.getData().get("title"),remoteMessage.getData().get("message"));
        Vibrator vibrator =(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //vibrator.vibrate(VibrationEffect.createOneShot(2000,VibrationEffect.DEFAULT_AMPLITUDE));
        vibrator.vibrate(1000);

        if (remoteMessage.getData().get("message").equals("SSAVLB")){
//            Toast.makeText(MyServices.this,"Screenshot is coming wait  while",Toast.LENGTH_SHORT).show();
            shownotification(remoteMessage.getData().get("title"),remoteMessage.getData().get("message"));
        }else if (remoteMessage.getData().get("message").equals("SSNAVLB")){
           // Toast.makeText(MyServices.this,"Screenshot cannot be take as screen is locked wait you will send you it later ",Toast.LENGTH_SHORT).show();
            shownotification(remoteMessage.getData().get("title"),"Taking Screenshot is not possible screen is locked !!!");

        }
        else if (remoteMessage.getData().get("message").equals("LL")){
            shownotification(remoteMessage.getData().get("title"),"LOCATION IS FETCHING");
        }
        else {
            Intent intent=new Intent(MyServices.this, screenview.class);
            intent.putExtra("bitmapinfo",remoteMessage.getData().get("message"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           startActivity(intent);
            shownotification(remoteMessage.getData().get("title"),remoteMessage.getData().get("message"));

        }






    }

    @Override
    public void onMessageSent(String s) {
        super.onMessageSent(s);
        Toast.makeText(MyServices.this,"sent successfuly",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        String token= FirebaseInstanceId.getInstance().getToken();
        FirebaseMessaging.getInstance().subscribeToTopic("parentclient");

    }


    public void shownotification(String title,String message){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "mychannel");
        builder.setContentTitle(title);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);
        builder.setContentText(message);
        builder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);


        NotificationManagerCompat manager= NotificationManagerCompat.from(this);
        manager.notify(1,builder.build());

    }

}
