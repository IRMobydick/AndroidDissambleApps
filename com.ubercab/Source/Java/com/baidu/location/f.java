package com.baidu.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import dalvik.system.DexClassLoader;
import java.io.File;

public class f extends Service
  implements ax, n
{
  private static final String ij = "app.jar";
  public static Context mC = null;
  public static String replaceFileName = "repll.jar";
  LLSInterface ii = null;
  LLSInterface ik = null;
  LLSInterface il = null;

  public static float getFrameVersion()
  {
    return 4.2F;
  }

  public static String getJarFileName()
  {
    return "app.jar";
  }

  public static Context getServiceContext()
  {
    return mC;
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.il.onBind(paramIntent);
  }

  public void onCreate()
  {
    mC = getApplicationContext();
    System.currentTimeMillis();
    this.ik = new ab();
    try
    {
      File localFile1 = new File(c.jdMethod_goto() + File.separator + replaceFileName);
      if (localFile1.exists())
      {
        File localFile2 = new File(c.jdMethod_goto() + File.separator + "app.jar");
        if (localFile2.exists())
          localFile2.delete();
        localFile1.renameTo(localFile2);
      }
      this.ii = ((LLSInterface)new DexClassLoader(c.jdMethod_goto() + File.separator + "app.jar", c.jdMethod_goto(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance());
      if ((this.ii != null) && (this.ii.getVersion() > this.ik.getVersion()))
      {
        this.il = this.ii;
        this.ik = null;
        this.il.onCreate(this);
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.ii = null;
        continue;
        this.il = this.ik;
        this.ii = null;
      }
    }
  }

  public void onDestroy()
  {
    this.il.onDestroy();
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return this.il.onStartCommand(paramIntent, paramInt1, paramInt2);
  }

  public boolean onUnbind(Intent paramIntent)
  {
    return this.il.onUnBind(paramIntent);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.f
 * JD-Core Version:    0.6.2
 */