package com.ubercab.library.network;

import android.os.Handler;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public abstract class BaseRetryCallback<T>
  implements Callback<T>
{
  private static final int BACKOFF_EXPONENT = 2;
  private static final int MIN_RETRY_MILLISECONDS = 100;
  static final int REQUEST_ATTEMPT_MAX = 3;
  private final Handler mHandler = new Handler();
  int mRequestAttempts = 0;
  private Runnable mRunnable;

  private static boolean isRetryStatusCode(int paramInt)
  {
    return (paramInt == 0) || ((paramInt >= 400) && (paramInt <= 499) && (paramInt != 406));
  }

  public abstract void errorRetryFailed(RetrofitError paramRetrofitError);

  public void failure(RetrofitError paramRetrofitError)
  {
    if (paramRetrofitError.getResponse() == null);
    for (int i = 0; (this.mRunnable != null) && (isRetryStatusCode(i)) && (this.mRequestAttempts < 3); i = paramRetrofitError.getResponse().getStatus())
    {
      this.mRequestAttempts = (1 + this.mRequestAttempts);
      this.mHandler.postDelayed(this.mRunnable, getDelay());
      return;
    }
    errorRetryFailed(paramRetrofitError);
  }

  long getDelay()
  {
    return ()(100.0D * Math.pow(this.mRequestAttempts, 2.0D));
  }

  public void setRetryRunnable(Runnable paramRunnable)
  {
    this.mRunnable = paramRunnable;
  }

  public abstract void success(T paramT, Response paramResponse);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.BaseRetryCallback
 * JD-Core Version:    0.6.2
 */