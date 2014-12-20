package com.google.android.gms.ads.b;

import android.content.Context;
import com.google.android.gms.internal.kx;

public final class a
{
  // ERROR //
  static b a(Context paramContext, com.google.android.gms.common.i parami)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 17	com/google/android/gms/common/i:a	()Landroid/os/IBinder;
    //   4: invokestatic 22	com/google/android/gms/internal/oc:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/ob;
    //   7: astore 8
    //   9: new 24	com/google/android/gms/ads/b/b
    //   12: dup
    //   13: aload 8
    //   15: invokeinterface 29 1 0
    //   20: aload 8
    //   22: iconst_1
    //   23: invokeinterface 32 2 0
    //   28: invokespecial 36	com/google/android/gms/ads/b/b:<init>	(Ljava/lang/String;Z)V
    //   31: astore 9
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 42	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   38: aload 9
    //   40: areturn
    //   41: astore 10
    //   43: ldc 44
    //   45: ldc 46
    //   47: aload 10
    //   49: invokestatic 52	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   52: pop
    //   53: goto -15 -> 38
    //   56: astore 6
    //   58: ldc 44
    //   60: ldc 54
    //   62: aload 6
    //   64: invokestatic 52	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   67: pop
    //   68: new 56	java/io/IOException
    //   71: dup
    //   72: ldc 58
    //   74: invokespecial 61	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: astore_3
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 42	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   84: aload_3
    //   85: athrow
    //   86: astore_2
    //   87: new 56	java/io/IOException
    //   90: dup
    //   91: ldc 63
    //   93: invokespecial 61	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   96: athrow
    //   97: astore 4
    //   99: ldc 44
    //   101: ldc 46
    //   103: aload 4
    //   105: invokestatic 52	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   108: pop
    //   109: goto -25 -> 84
    //
    // Exception table:
    //   from	to	target	type
    //   33	38	41	java/lang/IllegalArgumentException
    //   0	33	56	android/os/RemoteException
    //   0	33	78	finally
    //   58	78	78	finally
    //   87	97	78	finally
    //   0	33	86	java/lang/InterruptedException
    //   79	84	97	java/lang/IllegalArgumentException
  }

  // ERROR //
  static com.google.android.gms.common.i a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 72	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: ldc 74
    //   6: iconst_0
    //   7: invokevirtual 80	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   10: pop
    //   11: aload_0
    //   12: invokestatic 86	com/google/android/gms/common/g:b	(Landroid/content/Context;)V
    //   15: new 14	com/google/android/gms/common/i
    //   18: dup
    //   19: invokespecial 89	com/google/android/gms/common/i:<init>	()V
    //   22: astore 4
    //   24: new 91	android/content/Intent
    //   27: dup
    //   28: ldc 93
    //   30: invokespecial 94	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   33: astore 5
    //   35: aload 5
    //   37: ldc 96
    //   39: invokevirtual 100	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   42: pop
    //   43: aload_0
    //   44: aload 5
    //   46: aload 4
    //   48: iconst_1
    //   49: invokevirtual 104	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   52: ifeq +27 -> 79
    //   55: aload 4
    //   57: areturn
    //   58: astore_1
    //   59: new 68	com/google/android/gms/common/e
    //   62: dup
    //   63: bipush 9
    //   65: invokespecial 107	com/google/android/gms/common/e:<init>	(I)V
    //   68: athrow
    //   69: astore_3
    //   70: new 56	java/io/IOException
    //   73: dup
    //   74: aload_3
    //   75: invokespecial 110	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: new 56	java/io/IOException
    //   82: dup
    //   83: ldc 112
    //   85: invokespecial 61	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   88: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	11	58	android/content/pm/PackageManager$NameNotFoundException
    //   11	15	69	com/google/android/gms/common/e
  }

  public static b b(Context paramContext)
  {
    kx.c("Calling this from your main thread can lead to deadlock");
    return a(paramContext, a(paramContext));
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.b.a
 * JD-Core Version:    0.6.0
 */