package android.support.v4.os;

import android.os.AsyncTask;

class AsyncTaskCompatHoneycomb
{
  static <Params, Progress, Result> void executeParallel(AsyncTask<Params, Progress, Result> paramAsyncTask, Params[] paramArrayOfParams)
  {
    paramAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramArrayOfParams);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v4.os.AsyncTaskCompatHoneycomb
 * JD-Core Version:    0.6.2
 */