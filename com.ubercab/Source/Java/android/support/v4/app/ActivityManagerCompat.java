package android.support.v4.app;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

public final class ActivityManagerCompat
{
  public static boolean isLowRamDevice(@NonNull ActivityManager paramActivityManager)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return ActivityManagerCompatKitKat.isLowRamDevice(paramActivityManager);
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityManagerCompat
 * JD-Core Version:    0.6.2
 */