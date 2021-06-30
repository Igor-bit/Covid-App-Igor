/*
package com.igorcordeiroszeremeta.coronavirusapp7;

//import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_TEXT = "text";
    public static final String EXTRA_OUTPUT_MESSAGE = "output_message";

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override
    public Result doWork() {
        //Executed on different thread

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String title = getInputData().getString(EXTRA_TITLE);
        String text = getInputData().getString(EXTRA_TEXT);

        //sendNotification("Simple Work Manager", "I have been send by WorkManager!");
        sendNotification(title, text);

        Data output = new Data.Builder()
                .putString(EXTRA_OUTPUT_MESSAGE, "I have come from MyWorker!")
                .build();

        //setOutputData(output);

        return Result.success();
    }

    public void sendNotification(String title, String message) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        //If on Oreo then notification required a notification channel.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), "default")
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_launcher);

        notificationManager.notify(1, notification.build());
    }
}
 */