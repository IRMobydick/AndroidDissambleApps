package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;

@ez
public final class cf
{
  public static void a(Context paramContext, b paramb)
  {
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) != 0)
    {
      paramb.a(bn.bs());
      return;
    }
    new a(paramContext, paramb);
  }

  public static final class a
    implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener
  {
    private final Object mw = new Object();
    private final cf.b pN;
    private final cg pO;

    public a(Context paramContext, cf.b paramb)
    {
      this(paramContext, paramb, false);
    }

    a(Context paramContext, cf.b paramb, boolean paramBoolean)
    {
      this.pN = paramb;
      this.pO = new cg(paramContext, this, this, 6171000);
      if (!paramBoolean)
        this.pO.connect();
    }

    // ERROR //
    public void onConnected(Bundle paramBundle)
    {
      // Byte code:
      //   0: invokestatic 49	com/google/android/gms/internal/bn:bs	()Landroid/os/Bundle;
      //   3: astore_2
      //   4: aload_0
      //   5: getfield 24	com/google/android/gms/internal/cf$a:mw	Ljava/lang/Object;
      //   8: astore_3
      //   9: aload_3
      //   10: monitorenter
      //   11: aload_0
      //   12: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   15: invokevirtual 53	com/google/android/gms/internal/cg:bC	()Lcom/google/android/gms/internal/ch;
      //   18: astore 9
      //   20: aload 9
      //   22: ifnull +186 -> 208
      //   25: aload 9
      //   27: invokeinterface 58 1 0
      //   32: astore 10
      //   34: aload 10
      //   36: astore 7
      //   38: aload_0
      //   39: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   42: invokevirtual 62	com/google/android/gms/internal/cg:isConnected	()Z
      //   45: ifne +13 -> 58
      //   48: aload_0
      //   49: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   52: invokevirtual 65	com/google/android/gms/internal/cg:isConnecting	()Z
      //   55: ifeq +10 -> 65
      //   58: aload_0
      //   59: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   62: invokevirtual 68	com/google/android/gms/internal/cg:disconnect	()V
      //   65: aload_3
      //   66: monitorexit
      //   67: aload_0
      //   68: getfield 26	com/google/android/gms/internal/cf$a:pN	Lcom/google/android/gms/internal/cf$b;
      //   71: aload 7
      //   73: invokeinterface 73 2 0
      //   78: return
      //   79: astore 8
      //   81: ldc 75
      //   83: aload 8
      //   85: invokestatic 81	com/google/android/gms/internal/gs:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   88: aload_0
      //   89: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   92: invokevirtual 62	com/google/android/gms/internal/cg:isConnected	()Z
      //   95: ifne +13 -> 108
      //   98: aload_0
      //   99: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   102: invokevirtual 65	com/google/android/gms/internal/cg:isConnecting	()Z
      //   105: ifeq +97 -> 202
      //   108: aload_0
      //   109: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   112: invokevirtual 68	com/google/android/gms/internal/cg:disconnect	()V
      //   115: aload_2
      //   116: astore 7
      //   118: goto -53 -> 65
      //   121: astore 6
      //   123: ldc 75
      //   125: aload 6
      //   127: invokestatic 81	com/google/android/gms/internal/gs:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   130: aload_0
      //   131: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   134: invokevirtual 62	com/google/android/gms/internal/cg:isConnected	()Z
      //   137: ifne +13 -> 150
      //   140: aload_0
      //   141: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   144: invokevirtual 65	com/google/android/gms/internal/cg:isConnecting	()Z
      //   147: ifeq +55 -> 202
      //   150: aload_0
      //   151: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   154: invokevirtual 68	com/google/android/gms/internal/cg:disconnect	()V
      //   157: aload_2
      //   158: astore 7
      //   160: goto -95 -> 65
      //   163: astore 4
      //   165: aload_0
      //   166: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   169: invokevirtual 62	com/google/android/gms/internal/cg:isConnected	()Z
      //   172: ifne +13 -> 185
      //   175: aload_0
      //   176: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   179: invokevirtual 65	com/google/android/gms/internal/cg:isConnecting	()Z
      //   182: ifeq +10 -> 192
      //   185: aload_0
      //   186: getfield 34	com/google/android/gms/internal/cf$a:pO	Lcom/google/android/gms/internal/cg;
      //   189: invokevirtual 68	com/google/android/gms/internal/cg:disconnect	()V
      //   192: aload 4
      //   194: athrow
      //   195: astore 5
      //   197: aload_3
      //   198: monitorexit
      //   199: aload 5
      //   201: athrow
      //   202: aload_2
      //   203: astore 7
      //   205: goto -140 -> 65
      //   208: aload_2
      //   209: astore 7
      //   211: goto -173 -> 38
      //
      // Exception table:
      //   from	to	target	type
      //   11	20	79	java/lang/IllegalStateException
      //   25	34	79	java/lang/IllegalStateException
      //   11	20	121	android/os/RemoteException
      //   25	34	121	android/os/RemoteException
      //   11	20	163	finally
      //   25	34	163	finally
      //   81	88	163	finally
      //   123	130	163	finally
      //   38	58	195	finally
      //   58	65	195	finally
      //   65	67	195	finally
      //   88	108	195	finally
      //   108	115	195	finally
      //   130	150	195	finally
      //   150	157	195	finally
      //   165	185	195	finally
      //   185	192	195	finally
      //   192	195	195	finally
      //   197	199	195	finally
    }

    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.pN.a(bn.bs());
    }

    public void onDisconnected()
    {
      gs.S("Disconnected from remote ad request service.");
    }
  }

  public static abstract interface b
  {
    public abstract void a(Bundle paramBundle);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cf
 * JD-Core Version:    0.6.2
 */