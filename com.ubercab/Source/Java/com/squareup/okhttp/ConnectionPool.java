package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool
{
  private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000L;
  private static final int MAX_CONNECTIONS_TO_CLEANUP = 2;
  private static final ConnectionPool systemDefault = new ConnectionPool(5, l);
  private final LinkedList<Connection> connections = new LinkedList();
  private final Runnable connectionsCleanupRunnable = new Runnable()
  {
    public void run()
    {
      ArrayList localArrayList = new ArrayList(2);
      int i = 0;
      synchronized (ConnectionPool.this)
      {
        ListIterator localListIterator1 = ConnectionPool.this.connections.listIterator(ConnectionPool.this.connections.size());
        while (true)
        {
          Connection localConnection2;
          if (localListIterator1.hasPrevious())
          {
            localConnection2 = (Connection)localListIterator1.previous();
            if ((!localConnection2.isAlive()) || (localConnection2.isExpired(ConnectionPool.this.keepAliveDurationNs)))
            {
              localListIterator1.remove();
              localArrayList.add(localConnection2);
              if (localArrayList.size() != 2)
                continue;
            }
          }
          else
          {
            ListIterator localListIterator2 = ConnectionPool.this.connections.listIterator(ConnectionPool.this.connections.size());
            while ((localListIterator2.hasPrevious()) && (i > ConnectionPool.this.maxIdleConnections))
            {
              Connection localConnection1 = (Connection)localListIterator2.previous();
              if (localConnection1.isIdle())
              {
                localArrayList.add(localConnection1);
                localListIterator2.remove();
                i--;
              }
            }
            if (localConnection2.isIdle())
              i++;
          }
        }
        Iterator localIterator = localArrayList.iterator();
        if (localIterator.hasNext())
          Util.closeQuietly(((Connection)localIterator.next()).getSocket());
      }
    }
  };
  private final ExecutorService executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
  private final long keepAliveDurationNs;
  private final int maxIdleConnections;

  static
  {
    String str1 = System.getProperty("http.keepAlive");
    String str2 = System.getProperty("http.keepAliveDuration");
    String str3 = System.getProperty("http.maxConnections");
    if (str2 != null);
    for (long l = Long.parseLong(str2); (str1 != null) && (!Boolean.parseBoolean(str1)); l = 300000L)
    {
      systemDefault = new ConnectionPool(0, l);
      return;
    }
    if (str3 != null)
    {
      systemDefault = new ConnectionPool(Integer.parseInt(str3), l);
      return;
    }
  }

  public ConnectionPool(int paramInt, long paramLong)
  {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = (1000L * (paramLong * 1000L));
  }

  public static ConnectionPool getDefault()
  {
    return systemDefault;
  }

  private void waitForCleanupCallableToRun()
  {
    try
    {
      this.executorService.submit(new Runnable()
      {
        public void run()
        {
        }
      }).get();
      return;
    }
    catch (Exception localException)
    {
    }
    throw new AssertionError();
  }

  public void evictAll()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.connections);
      this.connections.clear();
      int i = 0;
      int j = localArrayList.size();
      while (i < j)
      {
        Util.closeQuietly(((Connection)localArrayList.get(i)).getSocket());
        i++;
      }
    }
    finally
    {
    }
  }

  public Connection get(Address paramAddress)
  {
    try
    {
      ListIterator localListIterator = this.connections.listIterator(this.connections.size());
      while (true)
      {
        boolean bool1 = localListIterator.hasPrevious();
        Object localObject2 = null;
        Connection localConnection;
        if (bool1)
        {
          localConnection = (Connection)localListIterator.previous();
          if ((localConnection.getRoute().getAddress().equals(paramAddress)) && (localConnection.isAlive()) && (System.nanoTime() - localConnection.getIdleStartTimeNs() < this.keepAliveDurationNs))
          {
            localListIterator.remove();
            boolean bool2 = localConnection.isSpdy();
            if (bool2);
          }
        }
        else
        {
          try
          {
            Platform.get().tagSocket(localConnection.getSocket());
            localObject2 = localConnection;
            if ((localObject2 != null) && (localObject2.isSpdy()))
              this.connections.addFirst(localObject2);
            this.executorService.execute(this.connectionsCleanupRunnable);
            return localObject2;
          }
          catch (SocketException localSocketException)
          {
            Util.closeQuietly(localConnection.getSocket());
            Platform.get().logW("Unable to tagSocket(): " + localSocketException);
          }
        }
      }
    }
    finally
    {
    }
  }

  public int getConnectionCount()
  {
    try
    {
      int i = this.connections.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  List<Connection> getConnections()
  {
    waitForCleanupCallableToRun();
    try
    {
      ArrayList localArrayList = new ArrayList(this.connections);
      return localArrayList;
    }
    finally
    {
    }
  }

  public int getHttpConnectionCount()
  {
    int i = 0;
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((Connection)localIterator.next()).isSpdy();
        if (!bool)
          i++;
      }
      return i;
    }
    finally
    {
    }
  }

  public int getSpdyConnectionCount()
  {
    int i = 0;
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((Connection)localIterator.next()).isSpdy();
        if (bool)
          i++;
      }
      return i;
    }
    finally
    {
    }
  }

  // ERROR //
  void recycle(Connection paramConnection)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 212	com/squareup/okhttp/Connection:isSpdy	()Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: invokevirtual 272	com/squareup/okhttp/Connection:clearOwner	()Z
    //   12: ifeq -5 -> 7
    //   15: aload_1
    //   16: invokevirtual 199	com/squareup/okhttp/Connection:isAlive	()Z
    //   19: ifne +11 -> 30
    //   22: aload_1
    //   23: invokevirtual 159	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   26: invokestatic 163	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   29: return
    //   30: invokestatic 217	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   33: aload_1
    //   34: invokevirtual 159	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   37: invokevirtual 275	com/squareup/okhttp/internal/Platform:untagSocket	(Ljava/net/Socket;)V
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: getfield 67	com/squareup/okhttp/ConnectionPool:connections	Ljava/util/LinkedList;
    //   46: aload_1
    //   47: invokevirtual 224	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   50: aload_1
    //   51: invokevirtual 278	com/squareup/okhttp/Connection:incrementRecycleCount	()V
    //   54: aload_1
    //   55: invokevirtual 281	com/squareup/okhttp/Connection:resetIdleStartTime	()V
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_0
    //   61: getfield 93	com/squareup/okhttp/ConnectionPool:executorService	Ljava/util/concurrent/ExecutorService;
    //   64: aload_0
    //   65: getfield 100	com/squareup/okhttp/ConnectionPool:connectionsCleanupRunnable	Ljava/lang/Runnable;
    //   68: invokeinterface 228 2 0
    //   73: return
    //   74: astore_2
    //   75: invokestatic 217	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   78: new 230	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 283
    //   88: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_2
    //   92: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 248	com/squareup/okhttp/internal/Platform:logW	(Ljava/lang/String;)V
    //   101: aload_1
    //   102: invokevirtual 159	com/squareup/okhttp/Connection:getSocket	()Ljava/net/Socket;
    //   105: invokestatic 163	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   108: return
    //   109: astore_3
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_3
    //   113: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   30	40	74	java/net/SocketException
    //   42	60	109	finally
    //   110	112	109	finally
  }

  void share(Connection paramConnection)
  {
    if (!paramConnection.isSpdy())
      throw new IllegalArgumentException();
    this.executorService.execute(this.connectionsCleanupRunnable);
    if (paramConnection.isAlive())
      try
      {
        this.connections.addFirst(paramConnection);
        return;
      }
      finally
      {
      }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.ConnectionPool
 * JD-Core Version:    0.6.2
 */