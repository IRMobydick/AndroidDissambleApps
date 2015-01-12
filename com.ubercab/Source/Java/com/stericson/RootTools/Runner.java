package com.stericson.RootTools;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;

class Runner extends Thread
{
  private static final String LOG_TAG = "RootTools::Runner";
  String binaryName;
  Context context;
  String parameter;

  public Runner(Context paramContext, String paramString1, String paramString2)
  {
    this.context = paramContext;
    this.binaryName = paramString1;
    this.parameter = paramString2;
  }

  public void run()
  {
    try
    {
      String str2 = this.context.getFilesDir().getCanonicalPath();
      str1 = str2;
      if (str1 == null);
    }
    catch (IOException localIOException)
    {
      try
      {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = (str1 + "/" + this.binaryName + " " + this.parameter);
        RootTools.sendShell(arrayOfString, 0, -1);
        return;
        localIOException = localIOException;
        if (RootTools.debugMode)
          Log.e("RootTools::Runner", "Problem occured while trying to locate private files directory!");
        localIOException.printStackTrace();
        String str1 = null;
      }
      catch (Exception localException)
      {
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.Runner
 * JD-Core Version:    0.6.2
 */