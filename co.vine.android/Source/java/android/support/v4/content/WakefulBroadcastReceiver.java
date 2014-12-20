package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver
{
  private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
  private static final SparseArray<PowerManager.WakeLock> mActiveWakeLocks = new SparseArray();
  private static int mNextId = 1;

  public static boolean completeWakefulIntent(Intent paramIntent)
  {
    int i = 0;
    int j = paramIntent.getIntExtra("android.support.content.wakelockid", 0);
    if (j == 0);
    while (true)
    {
      return i;
      synchronized (mActiveWakeLocks)
      {
        PowerManager.WakeLock localWakeLock = (PowerManager.WakeLock)mActiveWakeLocks.get(j);
        if (localWakeLock != null)
        {
          localWakeLock.release();
          mActiveWakeLocks.remove(j);
          i = 1;
          continue;
        }
        Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + j);
        i = 1;
      }
    }
  }

  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent)
  {
    ComponentName localComponentName;
    synchronized (mActiveWakeLocks)
    {
      int i = mNextId;
      mNextId = 1 + mNextId;
      if (mNextId <= 0)
        mNextId = 1;
      paramIntent.putExtra("android.support.content.wakelockid", i);
      localComponentName = paramContext.startService(paramIntent);
      if (localComponentName == null)
      {
        localComponentName = null;
      }
      else
      {
        PowerManager.WakeLock localWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "wake:" + localComponentName.flattenToShortString());
        localWakeLock.setReferenceCounted(false);
        localWakeLock.acquire(60000L);
        mActiveWakeLocks.put(i, localWakeLock);
      }
    }
    return localComponentName;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.WakefulBroadcastReceiver
 * JD-Core Version:    0.6.0
 */