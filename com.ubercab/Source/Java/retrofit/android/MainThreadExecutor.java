package retrofit.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class MainThreadExecutor
  implements Executor
{
  private final Handler handler = new Handler(Looper.getMainLooper());

  public void execute(Runnable paramRunnable)
  {
    this.handler.post(paramRunnable);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.android.MainThreadExecutor
 * JD-Core Version:    0.6.2
 */