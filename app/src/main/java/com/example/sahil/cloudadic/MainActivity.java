package com.example.sahil.cloudadic;

import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import at.markushi.ui.CircleButton;

import static android.R.attr.bitmap;

public class MainActivity extends AppCompatActivity {

    CircleButton camera,loaction,weather,notifaction,deveice,internet;
    ImageView imgview;

    static  final int CAM_REQUEST =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = (CircleButton)findViewById(R.id.btn_camera);
        loaction = (CircleButton)findViewById(R.id.btn_location);
        weather = (CircleButton)findViewById(R.id.btn_weather);
        notifaction = (CircleButton)findViewById(R.id.btn_notifaction);
        deveice = (CircleButton)findViewById(R.id.btn_device);
        internet = (CircleButton)findViewById(R.id.btn_internet);
        imgview = (ImageView)findViewById(R.id.imageview);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file =  getFile();
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent,CAM_REQUEST);

            }
        });

        loaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent location = new Intent(MainActivity.this,Location.class);
                startActivity(location);
                Toast.makeText(MainActivity.this, "why app crashess", Toast.LENGTH_SHORT).show();

            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ye not complete due to time restriction(on progress)", Toast.LENGTH_SHORT).show();
            }
        });

        notifaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent notification = new Intent(MainActivity.this,Notification.class);
                startActivity(notification);
            }
        });

        deveice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityManager actManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
                actManager.getMemoryInfo(memInfo);
                long totalMemory = memInfo.totalMem;
                String strLong = Long.toString(totalMemory);
                String version = Build.VERSION.RELEASE;
                String model =   Build.MODEL;
                // 1. Instantiate an AlertDialog.Builder with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage("Memeory : "+strLong+"\n"+"Model : "+model+"\n"+"Version : "+version);
                builder.setPositiveButton(
                        "Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                // 3. Get the AlertDialog from create()
                AlertDialog dialog = builder.create();
                dialog.show();
                Toast.makeText(MainActivity.this, "camera", Toast.LENGTH_SHORT).show();
            }
        });

        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo info = cm.getActiveNetworkInfo();
                if(info != null && info.isConnected())
                {
                    // 1. Instantiate an AlertDialog.Builder with its constructor
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    // 2. Chain together various setter methods to set the dialog characteristics
                    builder.setMessage(info.getTypeName())
                            .setTitle("Network is Connected");
                    builder.setPositiveButton(
                            "Dismiss",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    // 3. Get the AlertDialog from create()
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    //Toast.makeText(getBaseContext(), "Network is connected \n Network : "+info.getTypeName(), Toast.LENGTH_LONG).show();
                }
                else
                {
                    // 1. Instantiate an AlertDialog.Builder with its constructor
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    // 2. Chain together various setter methods to set the dialog characteristics
                    builder.setMessage("No network Available");
                    builder.setPositiveButton(
                            "Dismiss",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    // 3. Get the AlertDialog from create()
                    AlertDialog dialog = builder.create();
                    dialog.show();

                    Toast.makeText(getBaseContext(), "No network is available", Toast.LENGTH_LONG).show();

                }

            }
        });
    }

    private File getFile()
    {
        File folder = new File("storage/sdcard1/DCIM/camera_app");

        if(!folder.exists())
        {
            folder.mkdir();
        }

        File image_file = new  File(folder,"cam_image.jpg");
        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         String path =  "storage/sdcard1/DCIM/camera_app/cam_image.jpg";


    }
}
