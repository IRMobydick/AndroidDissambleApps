package com.google.android.gms.analytics;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class h
  implements l
{
  private static h xQ;
  private static final Object xz = new Object();
  private final Context mContext;
  private String xR;
  private boolean xS = false;
  private final Object xT = new Object();

  protected h(Context paramContext)
  {
    this.mContext = paramContext;
    dU();
  }

  private boolean ad(String paramString)
  {
    try
    {
      z.V("Storing clientId.");
      FileOutputStream localFileOutputStream = this.mContext.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      z.T("Error creating clientId file.");
      return false;
    }
    catch (IOException localIOException)
    {
      z.T("Error writing to clientId file.");
    }
    return false;
  }

  public static h dQ()
  {
    synchronized (xz)
    {
      h localh = xQ;
      return localh;
    }
  }

  private String dS()
  {
    if (!this.xS);
    synchronized (this.xT)
    {
      if (!this.xS)
        z.V("Waiting for clientId to load");
      try
      {
        do
          this.xT.wait();
        while (!this.xS);
        z.V("Loaded clientId");
        return this.xR;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          z.T("Exception while waiting for clientId: " + localInterruptedException);
      }
    }
  }

  private void dU()
  {
    new Thread("client_id_fetcher")
    {
      public void run()
      {
        synchronized (h.a(h.this))
        {
          h.a(h.this, h.this.dV());
          h.a(h.this, true);
          h.a(h.this).notifyAll();
          return;
        }
      }
    }
    .start();
  }

  public static void y(Context paramContext)
  {
    synchronized (xz)
    {
      if (xQ == null)
        xQ = new h(paramContext);
      return;
    }
  }

  public boolean ac(String paramString)
  {
    return "&cid".equals(paramString);
  }

  String dR()
  {
    synchronized (this.xT)
    {
      this.xR = dT();
      String str = this.xR;
      return str;
    }
  }

  protected String dT()
  {
    String str = UUID.randomUUID().toString().toLowerCase();
    try
    {
      if (!ad(str))
        str = "0";
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  String dV()
  {
    Object localObject = null;
    try
    {
      localFileInputStream = this.mContext.openFileInput("gaClientId");
      byte[] arrayOfByte = new byte[''];
      int i = localFileInputStream.read(arrayOfByte, 0, 128);
      if (localFileInputStream.available() > 0)
      {
        z.T("clientId file seems corrupted, deleting it.");
        localFileInputStream.close();
        this.mContext.deleteFile("gaClientId");
      }
      while (true)
      {
        if (localObject == null)
          localObject = dT();
        return localObject;
        if (i > 0)
          break;
        z.T("clientId file seems empty, deleting it.");
        localFileInputStream.close();
        this.mContext.deleteFile("gaClientId");
        localObject = null;
      }
      str = new String(arrayOfByte, 0, i);
    }
    catch (IOException localIOException1)
    {
      while (true)
        try
        {
          FileInputStream localFileInputStream;
          localFileInputStream.close();
          z.V("Loaded client id from disk.");
          localObject = str;
          continue;
          localIOException1 = localIOException1;
          z.T("Error reading clientId file, deleting it.");
          this.mContext.deleteFile("gaClientId");
        }
        catch (IOException localIOException2)
        {
          localObject = str;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          String str;
          localObject = str;
        }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      while (true)
        localObject = null;
    }
  }

  public String getValue(String paramString)
  {
    if ("&cid".equals(paramString))
      return dS();
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.h
 * JD-Core Version:    0.6.2
 */