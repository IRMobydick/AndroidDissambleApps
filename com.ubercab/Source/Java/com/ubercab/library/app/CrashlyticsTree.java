package com.ubercab.library.app;

import com.crashlytics.android.Crashlytics;
import timber.log.Timber.HollowTree;

public class CrashlyticsTree extends Timber.HollowTree
{
  public void e(String paramString, Object[] paramArrayOfObject)
  {
    i("ERROR: " + paramString, paramArrayOfObject);
  }

  public void e(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    e(paramString, paramArrayOfObject);
    Crashlytics.logException(paramThrowable);
  }

  public void i(String paramString, Object[] paramArrayOfObject)
  {
    Crashlytics.log(String.format(paramString, paramArrayOfObject));
  }

  public void i(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    i(paramString, paramArrayOfObject);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.CrashlyticsTree
 * JD-Core Version:    0.6.2
 */