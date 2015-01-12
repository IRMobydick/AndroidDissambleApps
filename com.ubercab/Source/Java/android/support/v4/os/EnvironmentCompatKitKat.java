package android.support.v4.os;

import android.os.Environment;
import java.io.File;

class EnvironmentCompatKitKat
{
  public static String getStorageState(File paramFile)
  {
    return Environment.getStorageState(paramFile);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v4.os.EnvironmentCompatKitKat
 * JD-Core Version:    0.6.2
 */