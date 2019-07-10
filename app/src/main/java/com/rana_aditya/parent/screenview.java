package com.rana_aditya.parent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.InputStream;

public class screenview extends Activity {
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screenshotview);
      imageView=findViewById(R.id.issimage);
       /* Intent intent=getIntent();
        String bitmapstring=intent.getStringExtra("bitmapinfo");
       Bitmap bitmap=StringToBitMap(bitmapstring);
       imageView.setImageBitmap(bitmap);*/
     Intent intent=getIntent();
     String url=intent.getStringExtra("bitmapinfo");
       // StorageReference storageReference= FirebaseStorage.getInstance().getReference("uploads");

       // Log.d("```````````````",storageReference.toString());
   Glide.with(this).load(url).into(imageView);



    }


    public Bitmap StringToBitMap(String encodedString){
        try {
            byte [] encodeByte= Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }




}


