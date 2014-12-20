package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class EnvironmentCompat
{
  public static final String MEDIA_UNKNOWN = "unknown";
  private static final String TAG = "EnvironmentCompat";

  public static String getStorageState(File paramFile)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 19)
      localObject = EnvironmentCompatKitKat.getStorageState(paramFile);
    while (true)
    {
      return localObject;
      try
      {
        if (paramFile.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()))
        {
          String str = Environment.getExternalStorageState();
          localObject = str;
        }
      }
      catch (IOException localIOException)
      {
        Log.w("EnvironmentCompat", "Failed to resolve canonical path: " + localIOException);
        localObject = "unknown";
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.os.EnvironmentCompat
 * JD-Core Version:    0.6.0
 */