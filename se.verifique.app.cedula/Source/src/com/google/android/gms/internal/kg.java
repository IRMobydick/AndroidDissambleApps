package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.HashMap;

public final class kg
  implements Handler.Callback
{
  private static final Object a = new Object();
  private static kg b;
  private final Context c;
  private final HashMap d = new HashMap();
  private final Handler e = new Handler(paramContext.getMainLooper(), this);

  private kg(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
  }

  public static kg a(Context paramContext)
  {
    synchronized (a)
    {
      if (b == null)
        b = new kg(paramContext.getApplicationContext());
      return b;
    }
  }

  // ERROR //
  public boolean a(java.lang.String paramString, jz paramjz)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/google/android/gms/internal/kg:d	Ljava/util/HashMap;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 42	com/google/android/gms/internal/kg:d	Ljava/util/HashMap;
    //   11: aload_1
    //   12: invokevirtual 59	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 61	com/google/android/gms/internal/kh
    //   18: astore 5
    //   20: aload 5
    //   22: ifnonnull +80 -> 102
    //   25: new 61	com/google/android/gms/internal/kh
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 64	com/google/android/gms/internal/kh:<init>	(Lcom/google/android/gms/internal/kg;Ljava/lang/String;)V
    //   34: astore 5
    //   36: aload 5
    //   38: aload_2
    //   39: invokevirtual 67	com/google/android/gms/internal/kh:a	(Lcom/google/android/gms/internal/jz;)V
    //   42: new 69	android/content/Intent
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 72	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   50: ldc 74
    //   52: invokevirtual 78	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   55: astore 6
    //   57: aload 5
    //   59: aload_0
    //   60: getfield 48	com/google/android/gms/internal/kg:c	Landroid/content/Context;
    //   63: aload 6
    //   65: aload 5
    //   67: invokevirtual 81	com/google/android/gms/internal/kh:a	()Lcom/google/android/gms/internal/ki;
    //   70: sipush 129
    //   73: invokevirtual 85	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   76: invokevirtual 88	com/google/android/gms/internal/kh:a	(Z)V
    //   79: aload_0
    //   80: getfield 42	com/google/android/gms/internal/kg:d	Ljava/util/HashMap;
    //   83: aload_1
    //   84: aload 5
    //   86: invokevirtual 92	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload 5
    //   92: invokevirtual 95	com/google/android/gms/internal/kh:c	()Z
    //   95: istore 8
    //   97: aload_3
    //   98: monitorexit
    //   99: iload 8
    //   101: ireturn
    //   102: aload_0
    //   103: getfield 37	com/google/android/gms/internal/kg:e	Landroid/os/Handler;
    //   106: iconst_0
    //   107: aload 5
    //   109: invokevirtual 99	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   112: aload 5
    //   114: aload_2
    //   115: invokevirtual 102	com/google/android/gms/internal/kh:c	(Lcom/google/android/gms/internal/jz;)Z
    //   118: ifeq +37 -> 155
    //   121: new 104	java/lang/IllegalStateException
    //   124: dup
    //   125: new 106	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   132: ldc 109
    //   134: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokespecial 118	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   147: athrow
    //   148: astore 4
    //   150: aload_3
    //   151: monitorexit
    //   152: aload 4
    //   154: athrow
    //   155: aload 5
    //   157: aload_2
    //   158: invokevirtual 67	com/google/android/gms/internal/kh:a	(Lcom/google/android/gms/internal/jz;)V
    //   161: aload 5
    //   163: invokevirtual 121	com/google/android/gms/internal/kh:d	()I
    //   166: tableswitch	default:+79 -> 245, 1:+22->188, 2:+39->205
    //   189: aload 5
    //   191: invokevirtual 125	com/google/android/gms/internal/kh:g	()Landroid/content/ComponentName;
    //   194: aload 5
    //   196: invokevirtual 129	com/google/android/gms/internal/kh:f	()Landroid/os/IBinder;
    //   199: invokevirtual 135	com/google/android/gms/internal/jz:onServiceConnected	(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    //   202: goto -112 -> 90
    //   205: new 69	android/content/Intent
    //   208: dup
    //   209: aload_1
    //   210: invokespecial 72	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   213: ldc 74
    //   215: invokevirtual 78	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   218: astore 9
    //   220: aload 5
    //   222: aload_0
    //   223: getfield 48	com/google/android/gms/internal/kg:c	Landroid/content/Context;
    //   226: aload 9
    //   228: aload 5
    //   230: invokevirtual 81	com/google/android/gms/internal/kh:a	()Lcom/google/android/gms/internal/ki;
    //   233: sipush 129
    //   236: invokevirtual 85	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   239: invokevirtual 88	com/google/android/gms/internal/kh:a	(Z)V
    //   242: goto -152 -> 90
    //   245: goto -155 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   7	152	148	finally
    //   155	242	148	finally
  }

  // ERROR //
  public void b(java.lang.String paramString, jz paramjz)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/google/android/gms/internal/kg:d	Ljava/util/HashMap;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 42	com/google/android/gms/internal/kg:d	Ljava/util/HashMap;
    //   11: aload_1
    //   12: invokevirtual 59	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 61	com/google/android/gms/internal/kh
    //   18: astore 5
    //   20: aload 5
    //   22: ifnonnull +37 -> 59
    //   25: new 104	java/lang/IllegalStateException
    //   28: dup
    //   29: new 106	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   36: ldc 138
    //   38: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 118	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: astore 4
    //   54: aload_3
    //   55: monitorexit
    //   56: aload 4
    //   58: athrow
    //   59: aload 5
    //   61: aload_2
    //   62: invokevirtual 102	com/google/android/gms/internal/kh:c	(Lcom/google/android/gms/internal/jz;)Z
    //   65: ifne +30 -> 95
    //   68: new 104	java/lang/IllegalStateException
    //   71: dup
    //   72: new 106	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   79: ldc 140
    //   81: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 118	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   94: athrow
    //   95: aload 5
    //   97: aload_2
    //   98: invokevirtual 142	com/google/android/gms/internal/kh:b	(Lcom/google/android/gms/internal/jz;)V
    //   101: aload 5
    //   103: invokevirtual 144	com/google/android/gms/internal/kh:e	()Z
    //   106: ifeq +28 -> 134
    //   109: aload_0
    //   110: getfield 37	com/google/android/gms/internal/kg:e	Landroid/os/Handler;
    //   113: iconst_0
    //   114: aload 5
    //   116: invokevirtual 148	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   119: astore 6
    //   121: aload_0
    //   122: getfield 37	com/google/android/gms/internal/kg:e	Landroid/os/Handler;
    //   125: aload 6
    //   127: ldc2_w 149
    //   130: invokevirtual 154	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   133: pop
    //   134: aload_3
    //   135: monitorexit
    //   136: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	56	52	finally
    //   59	136	52	finally
  }

  public boolean handleMessage(Message paramMessage)
  {
    int i;
    switch (paramMessage.what)
    {
    default:
      i = 0;
    case 0:
    }
    while (true)
    {
      return i;
      kh localkh = (kh)paramMessage.obj;
      synchronized (this.d)
      {
        if (localkh.e())
        {
          this.c.unbindService(localkh.a());
          this.d.remove(localkh.b());
        }
        i = 1;
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kg
 * JD-Core Version:    0.6.0
 */