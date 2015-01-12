package com.mobileapptracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.Semaphore;
import org.json.JSONObject;

public class MATEventQueue
{
  private static long d = 0L;
  private SharedPreferences a;
  private Semaphore b;
  private MobileAppTracker c;

  public MATEventQueue(Context paramContext, MobileAppTracker paramMobileAppTracker)
  {
    this.a = paramContext.getSharedPreferences("mat_queue", 0);
    this.b = new Semaphore(1, true);
    this.c = paramMobileAppTracker;
  }

  protected String getKeyFromQueue(String paramString)
  {
    try
    {
      String str = this.a.getString(paramString, null);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected int getQueueSize()
  {
    try
    {
      int i = this.a.getInt("queuesize", 0);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void removeKeyFromQueue(String paramString)
  {
    try
    {
      setQueueSize(-1 + getQueueSize());
      SharedPreferences.Editor localEditor = this.a.edit();
      localEditor.remove(paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void setQueueItemForKey(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.a.edit();
      localEditor.putString(paramString, paramJSONObject.toString());
      localEditor.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void setQueueSize(int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.a.edit();
      if (paramInt < 0)
        paramInt = 0;
      localEditor.putInt("queuesize", paramInt);
      localEditor.commit();
      return;
    }
    finally
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.MATEventQueue
 * JD-Core Version:    0.6.2
 */