package com.ubercab.client.feature.notification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class NotificationActionActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent1 = new Intent();
    Intent localIntent2 = getIntent();
    int i = localIntent2.getIntExtra("com.ubercab.client.EXTRA_MESSAGE_IDENTIFIER", 0);
    localIntent1.setAction(localIntent2.getStringExtra("com.ubercab.client.EXTRA_ACTION"));
    localIntent1.putExtra("com.ubercab.client.EXTRA_MESSAGE_IDENTIFIER", i);
    sendOrderedBroadcast(localIntent1, null);
    finish();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.NotificationActionActivity
 * JD-Core Version:    0.6.2
 */