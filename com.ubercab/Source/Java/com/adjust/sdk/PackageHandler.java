package com.adjust.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class PackageHandler extends HandlerThread
  implements IPackageHandler
{
  private static final String PACKAGE_QUEUE_FILENAME = "AdjustIoPackageQueue";
  private ActivityHandler activityHandler;
  private Context context;
  private boolean dropOfflineActivities;
  private final InternalHandler internalHandler;
  private AtomicBoolean isSending;
  private Logger logger;
  private List<ActivityPackage> packageQueue;
  private boolean paused;
  private IRequestHandler requestHandler;

  public PackageHandler(ActivityHandler paramActivityHandler, Context paramContext, boolean paramBoolean)
  {
    super("Adjust", 1);
    setDaemon(true);
    start();
    this.internalHandler = new InternalHandler(getLooper(), this);
    this.logger = AdjustFactory.getLogger();
    this.activityHandler = paramActivityHandler;
    this.context = paramContext;
    this.dropOfflineActivities = paramBoolean;
    Message localMessage = Message.obtain();
    localMessage.arg1 = 1;
    this.internalHandler.sendMessage(localMessage);
  }

  private void addInternal(ActivityPackage paramActivityPackage)
  {
    this.packageQueue.add(paramActivityPackage);
    Logger localLogger = this.logger;
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.packageQueue.size());
    arrayOfObject[1] = paramActivityPackage;
    localLogger.debug(String.format(localLocale, "Added package %d (%s)", arrayOfObject));
    this.logger.verbose(paramActivityPackage.getExtendedString());
    writePackageQueue();
  }

  public static Boolean deletePackageQueue(Context paramContext)
  {
    return Boolean.valueOf(paramContext.deleteFile("AdjustIoPackageQueue"));
  }

  private void initInternal()
  {
    this.requestHandler = AdjustFactory.getRequestHandler(this);
    this.isSending = new AtomicBoolean();
    readPackageQueue();
  }

  // ERROR //
  private void readPackageQueue()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/adjust/sdk/PackageHandler:dropOfflineActivities	Z
    //   4: ifeq +15 -> 19
    //   7: aload_0
    //   8: new 195	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 196	java/util/ArrayList:<init>	()V
    //   15: putfield 103	com/adjust/sdk/PackageHandler:packageQueue	Ljava/util/List;
    //   18: return
    //   19: new 198	java/io/ObjectInputStream
    //   22: dup
    //   23: new 200	java/io/BufferedInputStream
    //   26: dup
    //   27: aload_0
    //   28: getfield 66	com/adjust/sdk/PackageHandler:context	Landroid/content/Context;
    //   31: ldc 10
    //   33: invokevirtual 204	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   36: invokespecial 207	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: invokespecial 208	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 212	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   47: checkcast 105	java/util/List
    //   50: astore 9
    //   52: aload_0
    //   53: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   56: astore 10
    //   58: getstatic 115	java/util/Locale:US	Ljava/util/Locale;
    //   61: astore 11
    //   63: iconst_1
    //   64: anewarray 117	java/lang/Object
    //   67: astore 12
    //   69: aload 12
    //   71: iconst_0
    //   72: aload 9
    //   74: invokeinterface 121 1 0
    //   79: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aastore
    //   83: aload 10
    //   85: aload 11
    //   87: ldc 214
    //   89: aload 12
    //   91: invokestatic 135	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   94: invokeinterface 141 2 0
    //   99: aload_0
    //   100: aload 9
    //   102: putfield 103	com/adjust/sdk/PackageHandler:packageQueue	Ljava/util/List;
    //   105: aload_1
    //   106: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   109: return
    //   110: astore 4
    //   112: aload_0
    //   113: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   116: ldc 219
    //   118: invokeinterface 150 2 0
    //   123: aload_0
    //   124: new 195	java/util/ArrayList
    //   127: dup
    //   128: invokespecial 196	java/util/ArrayList:<init>	()V
    //   131: putfield 103	com/adjust/sdk/PackageHandler:packageQueue	Ljava/util/List;
    //   134: return
    //   135: astore 8
    //   137: aload_0
    //   138: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   141: ldc 221
    //   143: invokeinterface 224 2 0
    //   148: aload_1
    //   149: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   152: goto -29 -> 123
    //   155: astore_3
    //   156: aload_0
    //   157: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   160: ldc 226
    //   162: invokeinterface 224 2 0
    //   167: goto -44 -> 123
    //   170: astore 7
    //   172: aload_1
    //   173: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   176: goto -53 -> 123
    //   179: astore 6
    //   181: aload_0
    //   182: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   185: ldc 228
    //   187: invokeinterface 224 2 0
    //   192: aload_1
    //   193: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   196: goto -73 -> 123
    //   199: astore 5
    //   201: aload_0
    //   202: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   205: ldc 230
    //   207: invokeinterface 224 2 0
    //   212: aload_1
    //   213: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   216: goto -93 -> 123
    //   219: astore_2
    //   220: aload_1
    //   221: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   224: aload_2
    //   225: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   19	43	110	java/io/FileNotFoundException
    //   105	109	110	java/io/FileNotFoundException
    //   148	152	110	java/io/FileNotFoundException
    //   172	176	110	java/io/FileNotFoundException
    //   192	196	110	java/io/FileNotFoundException
    //   212	216	110	java/io/FileNotFoundException
    //   220	226	110	java/io/FileNotFoundException
    //   43	105	135	java/lang/ClassNotFoundException
    //   19	43	155	java/lang/Exception
    //   105	109	155	java/lang/Exception
    //   148	152	155	java/lang/Exception
    //   172	176	155	java/lang/Exception
    //   192	196	155	java/lang/Exception
    //   212	216	155	java/lang/Exception
    //   220	226	155	java/lang/Exception
    //   43	105	170	java/io/OptionalDataException
    //   43	105	179	java/io/IOException
    //   43	105	199	java/lang/ClassCastException
    //   43	105	219	finally
    //   137	148	219	finally
    //   181	192	219	finally
    //   201	212	219	finally
  }

  private void sendFirstInternal()
  {
    if (this.packageQueue.isEmpty())
      return;
    if (this.paused)
    {
      this.logger.debug("Package handler is paused");
      return;
    }
    if (this.isSending.getAndSet(true))
    {
      this.logger.verbose("Package handler is already sending");
      return;
    }
    ActivityPackage localActivityPackage = (ActivityPackage)this.packageQueue.get(0);
    this.requestHandler.sendPackage(localActivityPackage);
  }

  private void sendNextInternal()
  {
    this.packageQueue.remove(0);
    writePackageQueue();
    this.isSending.set(false);
    sendFirstInternal();
  }

  // ERROR //
  private void writePackageQueue()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/adjust/sdk/PackageHandler:dropOfflineActivities	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 263	java/io/ObjectOutputStream
    //   11: dup
    //   12: new 265	java/io/BufferedOutputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 66	com/adjust/sdk/PackageHandler:context	Landroid/content/Context;
    //   20: ldc 10
    //   22: iconst_0
    //   23: invokevirtual 269	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   26: invokespecial 272	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: invokespecial 273	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 103	com/adjust/sdk/PackageHandler:packageQueue	Ljava/util/List;
    //   38: invokevirtual 277	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   41: aload_0
    //   42: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   45: astore 7
    //   47: getstatic 115	java/util/Locale:US	Ljava/util/Locale;
    //   50: astore 8
    //   52: iconst_1
    //   53: anewarray 117	java/lang/Object
    //   56: astore 9
    //   58: aload 9
    //   60: iconst_0
    //   61: aload_0
    //   62: getfield 103	com/adjust/sdk/PackageHandler:packageQueue	Ljava/util/List;
    //   65: invokeinterface 121 1 0
    //   70: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: aastore
    //   74: aload 7
    //   76: aload 8
    //   78: ldc_w 279
    //   81: aload 9
    //   83: invokestatic 135	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokeinterface 141 2 0
    //   91: aload_1
    //   92: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   95: return
    //   96: astore_3
    //   97: aload_0
    //   98: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   101: astore 4
    //   103: iconst_1
    //   104: anewarray 117	java/lang/Object
    //   107: astore 5
    //   109: aload 5
    //   111: iconst_0
    //   112: aload_3
    //   113: invokevirtual 283	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   116: aastore
    //   117: aload 4
    //   119: ldc_w 285
    //   122: aload 5
    //   124: invokestatic 288	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   127: invokeinterface 224 2 0
    //   132: aload_3
    //   133: invokevirtual 291	java/lang/Exception:printStackTrace	()V
    //   136: return
    //   137: astore 6
    //   139: aload_0
    //   140: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   143: ldc_w 293
    //   146: invokeinterface 224 2 0
    //   151: aload_1
    //   152: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   155: return
    //   156: astore_2
    //   157: aload_1
    //   158: invokevirtual 280	java/io/ObjectOutputStream:close	()V
    //   161: aload_2
    //   162: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   8	33	96	java/lang/Exception
    //   91	95	96	java/lang/Exception
    //   151	155	96	java/lang/Exception
    //   157	163	96	java/lang/Exception
    //   33	91	137	java/io/NotSerializableException
    //   33	91	156	finally
    //   139	151	156	finally
  }

  public void addPackage(ActivityPackage paramActivityPackage)
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 2;
    localMessage.obj = paramActivityPackage;
    this.internalHandler.sendMessage(localMessage);
  }

  public void closeFirstPackage()
  {
    if (this.dropOfflineActivities)
    {
      sendNextPackage();
      return;
    }
    this.isSending.set(false);
  }

  public boolean dropsOfflineActivities()
  {
    return this.dropOfflineActivities;
  }

  public void finishedTrackingActivity(ActivityPackage paramActivityPackage, ResponseData paramResponseData)
  {
    paramResponseData.setActivityKind(paramActivityPackage.getActivityKind());
    this.activityHandler.finishedTrackingActivity(paramResponseData);
  }

  public String getFailureMessage()
  {
    if (this.dropOfflineActivities)
      return "Dropping offline activity.";
    return "Will retry later.";
  }

  public void pauseSending()
  {
    this.paused = true;
  }

  public void resumeSending()
  {
    this.paused = false;
  }

  public void sendFirstPackage()
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 4;
    this.internalHandler.sendMessage(localMessage);
  }

  public void sendNextPackage()
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 3;
    this.internalHandler.sendMessage(localMessage);
  }

  private static final class InternalHandler extends Handler
  {
    private static final int ADD = 2;
    private static final int INIT = 1;
    private static final int SEND_FIRST = 4;
    private static final int SEND_NEXT = 3;
    private final WeakReference<PackageHandler> packageHandlerReference;

    protected InternalHandler(Looper paramLooper, PackageHandler paramPackageHandler)
    {
      super();
      this.packageHandlerReference = new WeakReference(paramPackageHandler);
    }

    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      PackageHandler localPackageHandler = (PackageHandler)this.packageHandlerReference.get();
      if (localPackageHandler == null)
        return;
      switch (paramMessage.arg1)
      {
      default:
        return;
      case 1:
        localPackageHandler.initInternal();
        return;
      case 2:
        localPackageHandler.addInternal((ActivityPackage)paramMessage.obj);
        return;
      case 4:
        localPackageHandler.sendFirstInternal();
        return;
      case 3:
      }
      localPackageHandler.sendNextInternal();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.PackageHandler
 * JD-Core Version:    0.6.2
 */