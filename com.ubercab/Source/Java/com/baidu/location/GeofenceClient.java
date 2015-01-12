package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import java.util.List;

public class GeofenceClient
  implements ax, n
{
  public static final String BUNDLE_FOR_GEOFENCE_ID = "geofence_id";
  private static final int bj = 1;
  private static long bn = 1800000L;
  private Context bf;
  private OnGeofenceTriggerListener bg;
  private ServiceConnection bh = new GeofenceClient.1(this);
  private Messenger bi = new Messenger(this.bm);
  private Messenger bk = null;
  private boolean bl = false;
  private a bm = new a(null);

  public GeofenceClient(Context paramContext)
  {
    this.bf = paramContext;
  }

  protected static long d()
  {
    return bn;
  }

  private void jdMethod_for(String paramString)
  {
    if (this.bg != null)
      this.bg.onGeofenceTrigger(paramString);
  }

  private void jdMethod_int(String paramString)
  {
    if (this.bg != null)
      this.bg.onGeofenceExit(paramString);
  }

  private void jdMethod_long()
  {
    try
    {
      Message localMessage = Message.obtain(null, 207);
      localMessage.replyTo = this.bi;
      this.bk.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void jdMethod_void()
  {
    if (this.bl)
      return;
    Intent localIntent = new Intent(this.bf, f.class);
    localIntent.putExtra("interval", bn);
    try
    {
      this.bf.bindService(localIntent, this.bh, 1);
      return;
    }
    catch (Exception localException)
    {
      this.bl = false;
    }
  }

  public void addBDGeofence(BDGeofence paramBDGeofence, OnAddBDGeofencesResultListener paramOnAddBDGeofencesResultListener)
    throws NullPointerException, IllegalArgumentException, IllegalStateException
  {
    an.a(paramBDGeofence, "geofence is null");
    if (paramBDGeofence != null)
      an.jdMethod_if(paramBDGeofence instanceof aq, "BDGeofence must be created using BDGeofence.Builder");
    au.jdMethod_for(this.bf).jdMethod_if((aq)paramBDGeofence, paramOnAddBDGeofencesResultListener);
  }

  public boolean isStarted()
  {
    return this.bl;
  }

  public void registerGeofenceTriggerListener(OnGeofenceTriggerListener paramOnGeofenceTriggerListener)
  {
    if (this.bg == null)
      this.bg = paramOnGeofenceTriggerListener;
  }

  public void removeBDGeofences(List paramList, OnRemoveBDGeofencesResultListener paramOnRemoveBDGeofencesResultListener)
    throws NullPointerException, IllegalArgumentException
  {
    au.jdMethod_for(this.bf).jdMethod_if(paramList, paramOnRemoveBDGeofencesResultListener);
  }

  public void setInterval(long paramLong)
  {
    if (paramLong > bn)
      bn = paramLong;
  }

  public void start()
    throws NullPointerException
  {
    an.a(this.bg, "OnGeofenceTriggerListener not register!");
    this.bm.obtainMessage(1).sendToTarget();
  }

  public void startGeofenceScann()
  {
    if (this.bl);
    try
    {
      Message localMessage = Message.obtain(null, 206);
      localMessage.replyTo = this.bi;
      this.bk.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void stop()
  {
    jdMethod_long();
  }

  public static abstract interface OnAddBDGeofencesResultListener
  {
    public abstract void onAddBDGeofencesResult(int paramInt, String paramString);
  }

  public static abstract interface OnGeofenceTriggerListener
  {
    public abstract void onGeofenceExit(String paramString);

    public abstract void onGeofenceTrigger(String paramString);
  }

  public static abstract interface OnRemoveBDGeofencesResultListener
  {
    public abstract void onRemoveBDGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString);
  }

  private class a extends Handler
  {
    private a()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      Bundle localBundle = paramMessage.getData();
      switch (paramMessage.what)
      {
      default:
      case 208:
      case 1:
      case 209:
      }
      do
      {
        do
          return;
        while (localBundle == null);
        String str2 = localBundle.getString("geofence_id");
        GeofenceClient.jdMethod_do(GeofenceClient.this, str2);
        return;
        GeofenceClient.jdMethod_do(GeofenceClient.this);
        return;
      }
      while (localBundle == null);
      String str1 = localBundle.getString("geofence_id");
      GeofenceClient.jdMethod_if(GeofenceClient.this, str1);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.GeofenceClient
 * JD-Core Version:    0.6.2
 */