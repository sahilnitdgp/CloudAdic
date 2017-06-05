package com.example.sahil.cloudadic;

import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Notification extends AppCompatActivity {

    EditText input;
    Button notify;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        input = (EditText)findViewById(R.id.edtuserinput);
        notify = (Button)findViewById(R.id.notifiyme);

        message = input.getText().toString();

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(Notification.this)
                        .setSmallIcon(android.R.drawable.stat_notify_error)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setContentTitle(message)
                        .setContentText("This is notificatino Content");
                notificationBuilder.setDefaults(
                        android.app.Notification.DEFAULT_SOUND | android.app.Notification.DEFAULT_LIGHTS | android.app.Notification.DEFAULT_VIBRATE);
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(Notification.this);
                notificationManagerCompat.notify(1,notificationBuilder.build());

            }
        });

    }
}
