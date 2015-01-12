package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@ez
public final class gq extends gg
{
  private final Context mContext;
  private final String mv;
  private final String uR;
  private String vW = null;

  public gq(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mv = paramString1;
    this.uR = paramString2;
  }

  public gq(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.mContext = paramContext;
    this.mv = paramString1;
    this.uR = paramString2;
    this.vW = paramString3;
  }

  public void co()
  {
    try
    {
      gs.V("Pinging URL: " + this.uR);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.uR).openConnection();
      try
      {
        if (this.vW == null)
          gj.a(this.mContext, this.mv, true, localHttpURLConnection);
        while (true)
        {
          int i = localHttpURLConnection.getResponseCode();
          if ((i < 200) || (i >= 300))
            gs.W("Received non-success response code " + i + " from pinging URL: " + this.uR);
          return;
          gj.a(this.mContext, this.mv, true, localHttpURLConnection, this.vW);
        }
      }
      finally
      {
        localHttpURLConnection.disconnect();
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      gs.W("Error while parsing ping URL: " + this.uR + ". " + localIndexOutOfBoundsException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      gs.W("Error while pinging URL: " + this.uR + ". " + localIOException.getMessage());
    }
  }

  public void onStop()
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gq
 * JD-Core Version:    0.6.2
 */