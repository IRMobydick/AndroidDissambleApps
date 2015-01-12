package com.ubercab.library.network;

import android.content.Context;
import com.ubercab.common.base.Joiner;
import com.ubercab.common.collect.EvictingQueue;
import java.io.File;
import java.util.concurrent.ExecutorService;

public final class NetworkLog
{
  private static final String FILE_NAME = ".cn_logs";
  private static final int MAX_LOG_COUNT = 128;
  private final ExecutorService mExecutor;
  private final File mFileShortLogs;
  private final EvictingQueue<String> mLongLogs = EvictingQueue.create(128);
  private final EvictingQueue<String> mShortLogs = EvictingQueue.create(128);

  NetworkLog(Context paramContext, ExecutorService paramExecutorService)
  {
    this.mExecutor = paramExecutorService;
    this.mFileShortLogs = new File(paramContext.getCacheDir(), ".cn_logs");
    loadShortLogsFromDisc();
  }

  private void loadShortLogsFromDisc()
  {
    this.mExecutor.execute(new Runnable()
    {
      // ERROR //
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 17	com/ubercab/library/network/NetworkLog$1:this$0	Lcom/ubercab/library/network/NetworkLog;
        //   4: invokestatic 26	com/ubercab/library/network/NetworkLog:access$000	(Lcom/ubercab/library/network/NetworkLog;)Ljava/io/File;
        //   7: invokevirtual 32	java/io/File:exists	()Z
        //   10: ifne +4 -> 14
        //   13: return
        //   14: aconst_null
        //   15: astore_1
        //   16: new 34	java/io/BufferedReader
        //   19: dup
        //   20: new 36	java/io/FileReader
        //   23: dup
        //   24: aload_0
        //   25: getfield 17	com/ubercab/library/network/NetworkLog$1:this$0	Lcom/ubercab/library/network/NetworkLog;
        //   28: invokestatic 26	com/ubercab/library/network/NetworkLog:access$000	(Lcom/ubercab/library/network/NetworkLog;)Ljava/io/File;
        //   31: invokespecial 39	java/io/FileReader:<init>	(Ljava/io/File;)V
        //   34: invokespecial 42	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   37: astore_2
        //   38: aload_2
        //   39: invokevirtual 45	java/io/BufferedReader:ready	()Z
        //   42: ifeq +45 -> 87
        //   45: aload_2
        //   46: invokevirtual 49	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   49: astore 5
        //   51: aload_0
        //   52: getfield 17	com/ubercab/library/network/NetworkLog$1:this$0	Lcom/ubercab/library/network/NetworkLog;
        //   55: invokestatic 53	com/ubercab/library/network/NetworkLog:access$100	(Lcom/ubercab/library/network/NetworkLog;)Lcom/ubercab/common/collect/EvictingQueue;
        //   58: aload 5
        //   60: invokevirtual 59	com/ubercab/common/collect/EvictingQueue:add	(Ljava/lang/Object;)Z
        //   63: pop
        //   64: goto -26 -> 38
        //   67: astore 4
        //   69: aload_2
        //   70: astore_1
        //   71: aload 4
        //   73: ldc 61
        //   75: iconst_0
        //   76: anewarray 4	java/lang/Object
        //   79: invokestatic 67	timber/log/Timber:e	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   82: aload_1
        //   83: invokestatic 72	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
        //   86: return
        //   87: aload_2
        //   88: invokestatic 72	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
        //   91: return
        //   92: astore_3
        //   93: aload_1
        //   94: invokestatic 72	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
        //   97: aload_3
        //   98: athrow
        //   99: astore_3
        //   100: aload_2
        //   101: astore_1
        //   102: goto -9 -> 93
        //   105: astore 4
        //   107: aconst_null
        //   108: astore_1
        //   109: goto -38 -> 71
        //
        // Exception table:
        //   from	to	target	type
        //   38	64	67	java/io/IOException
        //   16	38	92	finally
        //   71	82	92	finally
        //   38	64	99	finally
        //   16	38	105	java/io/IOException
      }
    });
  }

  public String getLogReport()
  {
    synchronized (this.mLongLogs)
    {
      String str = Joiner.on("\n").join(this.mLongLogs);
      return str;
    }
  }

  public void putLongLog(String paramString)
  {
    synchronized (this.mLongLogs)
    {
      this.mLongLogs.add(paramString);
      return;
    }
  }

  // ERROR //
  public void putShortLog(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/ubercab/library/network/NetworkLog:mShortLogs	Lcom/ubercab/common/collect/EvictingQueue;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 34	com/ubercab/library/network/NetworkLog:mShortLogs	Lcom/ubercab/common/collect/EvictingQueue;
    //   11: aload_1
    //   12: invokevirtual 87	com/ubercab/common/collect/EvictingQueue:add	(Ljava/lang/Object;)Z
    //   15: pop
    //   16: aconst_null
    //   17: astore 5
    //   19: new 92	java/io/FileOutputStream
    //   22: dup
    //   23: aload_0
    //   24: getfield 49	com/ubercab/library/network/NetworkLog:mFileShortLogs	Ljava/io/File;
    //   27: iconst_0
    //   28: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   31: astore 6
    //   33: aload 6
    //   35: ldc 71
    //   37: invokestatic 77	com/ubercab/common/base/Joiner:on	(Ljava/lang/String;)Lcom/ubercab/common/base/Joiner;
    //   40: aload_0
    //   41: getfield 34	com/ubercab/library/network/NetworkLog:mShortLogs	Lcom/ubercab/common/collect/EvictingQueue;
    //   44: invokevirtual 81	com/ubercab/common/base/Joiner:join	(Ljava/lang/Iterable;)Ljava/lang/String;
    //   47: invokevirtual 101	java/lang/String:getBytes	()[B
    //   50: invokevirtual 105	java/io/FileOutputStream:write	([B)V
    //   53: aload 6
    //   55: invokevirtual 108	java/io/FileOutputStream:flush	()V
    //   58: aload 6
    //   60: invokestatic 114	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   63: aload_2
    //   64: monitorexit
    //   65: return
    //   66: astore 7
    //   68: aload 7
    //   70: ldc 116
    //   72: iconst_0
    //   73: anewarray 4	java/lang/Object
    //   76: invokestatic 122	timber/log/Timber:e	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: aload 5
    //   81: invokestatic 114	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   84: goto -21 -> 63
    //   87: astore_3
    //   88: aload_2
    //   89: monitorexit
    //   90: aload_3
    //   91: athrow
    //   92: astore 8
    //   94: aload 5
    //   96: invokestatic 114	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   99: aload 8
    //   101: athrow
    //   102: astore 8
    //   104: aload 6
    //   106: astore 5
    //   108: goto -14 -> 94
    //   111: astore 7
    //   113: aload 6
    //   115: astore 5
    //   117: goto -49 -> 68
    //
    // Exception table:
    //   from	to	target	type
    //   19	33	66	java/io/IOException
    //   7	16	87	finally
    //   58	63	87	finally
    //   63	65	87	finally
    //   79	84	87	finally
    //   88	90	87	finally
    //   94	102	87	finally
    //   19	33	92	finally
    //   68	79	92	finally
    //   33	58	102	finally
    //   33	58	111	java/io/IOException
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.NetworkLog
 * JD-Core Version:    0.6.2
 */