package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

class LocationClient$1
  implements ServiceConnection
{
  LocationClient$1(LocationClient paramLocationClient)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LocationClient.jdMethod_if(this.a, new Messenger(paramIBinder));
    if (LocationClient.jdMethod_char(this.a) == null);
    while (true)
    {
      return;
      LocationClient.jdMethod_if(this.a, true);
      Log.d("baidu_location_client", "baidu location connected ...");
      try
      {
        Message localMessage = Message.obtain(null, 11);
        localMessage.replyTo = LocationClient.jdMethod_new(this.a);
        localMessage.setData(LocationClient.jdMethod_long(this.a));
        LocationClient.jdMethod_char(this.a).send(localMessage);
        LocationClient.jdMethod_if(this.a, true);
        if (LocationClient.jdMethod_else(this.a) != null)
        {
          if (LocationClient.jdMethod_if(this.a).booleanValue());
          LocationClient.jdMethod_byte(this.a).obtainMessage(4).sendToTarget();
          return;
        }
      }
      catch (Exception localException)
      {
      }
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    LocationClient.jdMethod_if(this.a, null);
    LocationClient.jdMethod_if(this.a, false);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.LocationClient.1
 * JD-Core Version:    0.6.2
 */