package retrofit;

import android.os.Build.VERSION;
import android.os.Process;
import com.google.gson.Gson;
import java.io.PrintStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import retrofit.android.AndroidApacheClient;
import retrofit.android.AndroidLog;
import retrofit.android.MainThreadExecutor;
import retrofit.appengine.UrlFetchClient;
import retrofit.client.Client;
import retrofit.client.Client.Provider;
import retrofit.client.OkClient;
import retrofit.client.UrlConnectionClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

abstract class Platform
{
  static final boolean HAS_RX_JAVA = hasRxJavaOnClasspath();
  private static final Platform PLATFORM = findPlatform();

  private static Platform findPlatform()
  {
    try
    {
      Class.forName("android.os.Build");
      if (Build.VERSION.SDK_INT != 0)
      {
        Android localAndroid = new Android(null);
        return localAndroid;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      if (System.getProperty("com.google.appengine.runtime.version") != null)
        return new AppEngine(null);
    }
    return new Base(null);
  }

  static Platform get()
  {
    return PLATFORM;
  }

  private static boolean hasOkHttpOnClasspath()
  {
    try
    {
      Class.forName("com.squareup.okhttp.OkUrlFactory");
      i = 1;
      try
      {
        Class.forName("com.squareup.okhttp.OkHttpClient");
        bool = true;
        if (bool != i)
          throw new RuntimeException("Retrofit detected an unsupported OkHttp on the classpath.\nTo use OkHttp with this version of Retrofit, you'll need:\n1. com.squareup.okhttp:okhttp:1.6.0 (or newer)\n2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)\nNote that OkHttp 2.0.0+ is supported!");
        return bool;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        while (true)
          boolean bool = false;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      while (true)
        int i = 0;
    }
  }

  private static boolean hasRxJavaOnClasspath()
  {
    try
    {
      Class.forName("rx.Observable");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }

  abstract Executor defaultCallbackExecutor();

  abstract Client.Provider defaultClient();

  abstract Converter defaultConverter();

  abstract Executor defaultHttpExecutor();

  abstract RestAdapter.Log defaultLog();

  private static class Android extends Platform
  {
    Executor defaultCallbackExecutor()
    {
      return new MainThreadExecutor();
    }

    Client.Provider defaultClient()
    {
      Object localObject;
      if (Platform.access$300())
        localObject = Platform.OkClientInstantiator.instantiate();
      while (true)
      {
        return new Client.Provider()
        {
          public Client get()
          {
            return this.val$client;
          }
        };
        if (Build.VERSION.SDK_INT < 9)
          localObject = new AndroidApacheClient();
        else
          localObject = new UrlConnectionClient();
      }
    }

    Converter defaultConverter()
    {
      return new GsonConverter(new Gson());
    }

    Executor defaultHttpExecutor()
    {
      return Executors.newCachedThreadPool(new ThreadFactory()
      {
        public Thread newThread(final Runnable paramAnonymousRunnable)
        {
          return new Thread(new Runnable()
          {
            public void run()
            {
              Process.setThreadPriority(10);
              paramAnonymousRunnable.run();
            }
          }
          , "Retrofit-Idle");
        }
      });
    }

    RestAdapter.Log defaultLog()
    {
      return new AndroidLog("Retrofit");
    }
  }

  private static class AppEngine extends Platform.Base
  {
    private AppEngine()
    {
      super();
    }

    Client.Provider defaultClient()
    {
      return new Client.Provider()
      {
        public Client get()
        {
          return this.val$client;
        }
      };
    }
  }

  private static class Base extends Platform
  {
    Executor defaultCallbackExecutor()
    {
      return new Utils.SynchronousExecutor();
    }

    Client.Provider defaultClient()
    {
      if (Platform.access$300());
      for (Object localObject = Platform.OkClientInstantiator.instantiate(); ; localObject = new UrlConnectionClient())
        return new Client.Provider()
        {
          public Client get()
          {
            return this.val$client;
          }
        };
    }

    Converter defaultConverter()
    {
      return new GsonConverter(new Gson());
    }

    Executor defaultHttpExecutor()
    {
      return Executors.newCachedThreadPool(new ThreadFactory()
      {
        public Thread newThread(final Runnable paramAnonymousRunnable)
        {
          return new Thread(new Runnable()
          {
            public void run()
            {
              Thread.currentThread().setPriority(1);
              paramAnonymousRunnable.run();
            }
          }
          , "Retrofit-Idle");
        }
      });
    }

    RestAdapter.Log defaultLog()
    {
      return new RestAdapter.Log()
      {
        public void log(String paramAnonymousString)
        {
          System.out.println(paramAnonymousString);
        }
      };
    }
  }

  private static class OkClientInstantiator
  {
    static Client instantiate()
    {
      return new OkClient();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.Platform
 * JD-Core Version:    0.6.2
 */