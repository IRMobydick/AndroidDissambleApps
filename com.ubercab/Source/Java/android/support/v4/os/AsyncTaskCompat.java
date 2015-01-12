package android.support.v4.os;

import android.os.AsyncTask;
import android.os.Build.VERSION;

public class AsyncTaskCompat
{
  public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> executeParallel(AsyncTask<Params, Progress, Result> paramAsyncTask, Params[] paramArrayOfParams)
  {
    if (paramAsyncTask == null)
      throw new IllegalArgumentException("task can not be null");
    if (Build.VERSION.SDK_INT >= 11)
    {
      AsyncTaskCompatHoneycomb.executeParallel(paramAsyncTask, paramArrayOfParams);
      return paramAsyncTask;
    }
    paramAsyncTask.execute(paramArrayOfParams);
    return paramAsyncTask;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v4.os.AsyncTaskCompat
 * JD-Core Version:    0.6.2
 */