package com.mobileapptracker;

import android.util.Log;
import java.util.Date;
import java.util.concurrent.Semaphore;
import org.json.JSONException;
import org.json.JSONObject;

public class MATEventQueue$Add
  implements Runnable
{
  private String b = null;
  private String c = null;
  private JSONObject d = null;
  private Date e = null;

  protected MATEventQueue$Add(MATEventQueue paramMATEventQueue, String paramString1, String paramString2, JSONObject paramJSONObject, Date paramDate)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramJSONObject;
    this.e = paramDate;
  }

  public void run()
  {
    try
    {
      MATEventQueue.a(this.a).acquire();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("link", this.b);
        localJSONObject.put("data", this.c);
        localJSONObject.put("post_body", this.d);
        localJSONObject.put("run_date", this.e.getTime());
        int i = 1 + this.a.getQueueSize();
        this.a.setQueueSize(i);
        String str = Integer.toString(i);
        this.a.setQueueItemForKey(localJSONObject, str);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.w("MobileAppTracker", "Failed creating event for queueing");
        localJSONException.printStackTrace();
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.w("MobileAppTracker", "Interrupted adding event to queue");
      localInterruptedException.printStackTrace();
      return;
    }
    finally
    {
      MATEventQueue.a(this.a).release();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.MATEventQueue.Add
 * JD-Core Version:    0.6.2
 */