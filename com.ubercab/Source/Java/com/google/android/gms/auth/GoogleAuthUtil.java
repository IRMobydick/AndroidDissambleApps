package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.internal.if;
import java.io.IOException;
import java.net.URISyntaxException;

public final class GoogleAuthUtil
{
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  private static final ComponentName Dn;
  private static final ComponentName Do;
  private static final Intent Dp;
  private static final Intent Dq;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID;
  public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";

  @Deprecated
  public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";

  static
  {
    String str1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      str1 = "callerUid";
      KEY_CALLER_UID = str1;
      if (Build.VERSION.SDK_INT < 14)
        break label107;
    }
    label107: for (String str2 = "androidPackageName"; ; str2 = "androidPackageName")
    {
      KEY_ANDROID_PACKAGE_NAME = str2;
      Dn = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      Do = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      Dp = new Intent().setPackage("com.google.android.gms").setComponent(Dn);
      Dq = new Intent().setPackage("com.google.android.gms").setComponent(Do);
      return;
      str1 = "callerUid";
      break;
    }
  }

  private static void D(Context paramContext)
    throws GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtil.D(paramContext);
      return;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      throw new GooglePlayServicesAvailabilityException(localGooglePlayServicesRepairableException.getConnectionStatusCode(), localGooglePlayServicesRepairableException.getMessage(), localGooglePlayServicesRepairableException.getIntent());
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      throw new GoogleAuthException(localGooglePlayServicesNotAvailableException.getMessage());
    }
  }

  private static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (paramBundle == null)
      paramBundle = new Bundle();
    try
    {
      String str = getToken(paramContext, paramString1, paramString2, paramBundle);
      return str;
    }
    catch (GooglePlayServicesAvailabilityException localGooglePlayServicesAvailabilityException)
    {
      int i = localGooglePlayServicesAvailabilityException.getConnectionStatusCode();
      if (b(paramContext, i))
      {
        a locala = new a(paramContext.getApplicationContext());
        locala.sendMessageDelayed(locala.obtainMessage(1), 30000L);
      }
      while (true)
      {
        throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        GooglePlayServicesUtil.showErrorNotification(i, paramContext);
      }
    }
    catch (UserRecoverableAuthException localUserRecoverableAuthException)
    {
    }
    throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
  }

  private static boolean aw(String paramString)
  {
    return ("NetworkError".equals(paramString)) || ("ServiceUnavailable".equals(paramString)) || ("Timeout".equals(paramString));
  }

  private static boolean ax(String paramString)
  {
    return ("BadAuthentication".equals(paramString)) || ("CaptchaRequired".equals(paramString)) || ("DeviceManagementRequiredOrSyncDisabled".equals(paramString)) || ("NeedPermission".equals(paramString)) || ("NeedsBrowser".equals(paramString)) || ("UserCancel".equals(paramString)) || ("AppDownloadRequired".equals(paramString)) || (if.DT.ft().equals(paramString)) || (if.DU.ft().equals(paramString)) || (if.DV.ft().equals(paramString)) || (if.DW.ft().equals(paramString)) || (if.DX.ft().equals(paramString)) || (if.DY.ft().equals(paramString));
  }

  private static boolean b(Context paramContext, int paramInt)
  {
    if (paramInt == 1)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      try
      {
        boolean bool = localPackageManager.getApplicationInfo("com.google.android.gms", 8192).enabled;
        if (bool)
          return true;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
      }
    }
    return false;
  }

  // ERROR //
  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 141	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore_2
    //   5: ldc 241
    //   7: invokestatic 246	com/google/android/gms/common/internal/o:aU	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokestatic 247	com/google/android/gms/auth/GoogleAuthUtil:D	(Landroid/content/Context;)V
    //   14: new 124	android/os/Bundle
    //   17: dup
    //   18: invokespecial 125	android/os/Bundle:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 250	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: getfield 253	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   29: astore 4
    //   31: aload_3
    //   32: ldc 255
    //   34: aload 4
    //   36: invokevirtual 258	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_3
    //   40: getstatic 48	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   43: invokevirtual 261	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   46: ifne +12 -> 58
    //   49: aload_3
    //   50: getstatic 48	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   53: aload 4
    //   55: invokevirtual 258	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: new 263	com/google/android/gms/common/a
    //   61: dup
    //   62: invokespecial 264	com/google/android/gms/common/a:<init>	()V
    //   65: astore 5
    //   67: aload_2
    //   68: getstatic 78	com/google/android/gms/auth/GoogleAuthUtil:Dp	Landroid/content/Intent;
    //   71: aload 5
    //   73: iconst_1
    //   74: invokevirtual 268	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   77: ifeq +107 -> 184
    //   80: aload 5
    //   82: invokevirtual 272	com/google/android/gms/common/a:fW	()Landroid/os/IBinder;
    //   85: invokestatic 277	com/google/android/gms/internal/r$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/r;
    //   88: aload_1
    //   89: aload_3
    //   90: invokeinterface 282 3 0
    //   95: astore 10
    //   97: aload 10
    //   99: getstatic 285	com/google/android/gms/internal/if:Ev	Ljava/lang/String;
    //   102: invokevirtual 289	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore 11
    //   107: aload 10
    //   109: ldc_w 291
    //   112: invokevirtual 294	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   115: ifne +49 -> 164
    //   118: new 85	com/google/android/gms/auth/GoogleAuthException
    //   121: dup
    //   122: aload 11
    //   124: invokespecial 114	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   127: athrow
    //   128: astore 8
    //   130: ldc_w 296
    //   133: ldc_w 298
    //   136: aload 8
    //   138: invokestatic 304	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   141: pop
    //   142: new 118	java/io/IOException
    //   145: dup
    //   146: ldc_w 306
    //   149: invokespecial 307	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   152: athrow
    //   153: astore 7
    //   155: aload_2
    //   156: aload 5
    //   158: invokevirtual 311	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   161: aload 7
    //   163: athrow
    //   164: aload_2
    //   165: aload 5
    //   167: invokevirtual 311	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   170: return
    //   171: astore 6
    //   173: new 85	com/google/android/gms/auth/GoogleAuthException
    //   176: dup
    //   177: ldc_w 313
    //   180: invokespecial 114	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   183: athrow
    //   184: new 118	java/io/IOException
    //   187: dup
    //   188: ldc_w 315
    //   191: invokespecial 307	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   194: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   80	128	128	android/os/RemoteException
    //   80	128	153	finally
    //   130	153	153	finally
    //   173	184	153	finally
    //   80	128	171	java/lang/InterruptedException
  }

  // ERROR //
  public static java.util.List<AccountChangeEvent> getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
    throws GoogleAuthException, IOException
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 319
    //   4: invokestatic 322	com/google/android/gms/common/internal/o:b	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   7: pop
    //   8: ldc 241
    //   10: invokestatic 246	com/google/android/gms/common/internal/o:aU	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 141	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: astore 4
    //   19: aload 4
    //   21: invokestatic 247	com/google/android/gms/auth/GoogleAuthUtil:D	(Landroid/content/Context;)V
    //   24: new 263	com/google/android/gms/common/a
    //   27: dup
    //   28: invokespecial 264	com/google/android/gms/common/a:<init>	()V
    //   31: astore 5
    //   33: aload 4
    //   35: getstatic 78	com/google/android/gms/auth/GoogleAuthUtil:Dp	Landroid/content/Intent;
    //   38: aload 5
    //   40: iconst_1
    //   41: invokevirtual 268	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   44: ifeq +96 -> 140
    //   47: aload 5
    //   49: invokevirtual 272	com/google/android/gms/common/a:fW	()Landroid/os/IBinder;
    //   52: invokestatic 277	com/google/android/gms/internal/r$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/r;
    //   55: new 324	com/google/android/gms/auth/AccountChangeEventsRequest
    //   58: dup
    //   59: invokespecial 325	com/google/android/gms/auth/AccountChangeEventsRequest:<init>	()V
    //   62: aload_2
    //   63: invokevirtual 329	com/google/android/gms/auth/AccountChangeEventsRequest:setAccountName	(Ljava/lang/String;)Lcom/google/android/gms/auth/AccountChangeEventsRequest;
    //   66: iload_1
    //   67: invokevirtual 333	com/google/android/gms/auth/AccountChangeEventsRequest:setEventIndex	(I)Lcom/google/android/gms/auth/AccountChangeEventsRequest;
    //   70: invokeinterface 336 2 0
    //   75: invokevirtual 342	com/google/android/gms/auth/AccountChangeEventsResponse:getEvents	()Ljava/util/List;
    //   78: astore 10
    //   80: aload 4
    //   82: aload 5
    //   84: invokevirtual 311	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   87: aload 10
    //   89: areturn
    //   90: astore 8
    //   92: ldc_w 296
    //   95: ldc_w 298
    //   98: aload 8
    //   100: invokestatic 304	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   103: pop
    //   104: new 118	java/io/IOException
    //   107: dup
    //   108: ldc_w 306
    //   111: invokespecial 307	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   114: athrow
    //   115: astore 7
    //   117: aload 4
    //   119: aload 5
    //   121: invokevirtual 311	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   124: aload 7
    //   126: athrow
    //   127: astore 6
    //   129: new 85	com/google/android/gms/auth/GoogleAuthException
    //   132: dup
    //   133: ldc_w 313
    //   136: invokespecial 114	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   139: athrow
    //   140: new 118	java/io/IOException
    //   143: dup
    //   144: ldc_w 315
    //   147: invokespecial 307	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   150: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   47	80	90	android/os/RemoteException
    //   47	80	115	finally
    //   92	115	115	finally
    //   129	140	115	finally
    //   47	80	127	java/lang/InterruptedException
  }

  public static String getAccountId(Context paramContext, String paramString)
    throws GoogleAuthException, IOException
  {
    o.b(paramString, "accountName must be provided");
    o.aU("Calling this from your main thread can lead to deadlock");
    D(paramContext.getApplicationContext());
    return getToken(paramContext, paramString, "^^_account_id_^^", new Bundle());
  }

  public static String getAppCert(Context paramContext, String paramString)
  {
    return "spatula";
  }

  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, paramString1, paramString2, new Bundle());
  }

  // ERROR //
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 141	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore 4
    //   6: ldc 241
    //   8: invokestatic 246	com/google/android/gms/common/internal/o:aU	(Ljava/lang/String;)V
    //   11: aload 4
    //   13: invokestatic 247	com/google/android/gms/auth/GoogleAuthUtil:D	(Landroid/content/Context;)V
    //   16: aload_3
    //   17: ifnonnull +125 -> 142
    //   20: new 124	android/os/Bundle
    //   23: dup
    //   24: invokespecial 125	android/os/Bundle:<init>	()V
    //   27: astore 5
    //   29: aload_0
    //   30: invokevirtual 250	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   33: getfield 253	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   36: astore 6
    //   38: aload 5
    //   40: ldc 255
    //   42: aload 6
    //   44: invokevirtual 258	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload 5
    //   49: getstatic 48	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   52: invokevirtual 261	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   55: ifne +13 -> 68
    //   58: aload 5
    //   60: getstatic 48	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   63: aload 6
    //   65: invokevirtual 258	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: new 263	com/google/android/gms/common/a
    //   71: dup
    //   72: invokespecial 264	com/google/android/gms/common/a:<init>	()V
    //   75: astore 7
    //   77: aload 4
    //   79: getstatic 78	com/google/android/gms/auth/GoogleAuthUtil:Dp	Landroid/content/Intent;
    //   82: aload 7
    //   84: iconst_1
    //   85: invokevirtual 268	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   88: ifeq +188 -> 276
    //   91: aload 7
    //   93: invokevirtual 272	com/google/android/gms/common/a:fW	()Landroid/os/IBinder;
    //   96: invokestatic 277	com/google/android/gms/internal/r$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/r;
    //   99: aload_1
    //   100: aload_2
    //   101: aload 5
    //   103: invokeinterface 353 4 0
    //   108: astore 12
    //   110: aload 12
    //   112: ldc_w 355
    //   115: invokevirtual 289	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 13
    //   120: aload 13
    //   122: invokestatic 361	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: istore 14
    //   127: iload 14
    //   129: ifne +26 -> 155
    //   132: aload 4
    //   134: aload 7
    //   136: invokevirtual 311	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   139: aload 13
    //   141: areturn
    //   142: new 124	android/os/Bundle
    //   145: dup
    //   146: aload_3
    //   147: invokespecial 364	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   150: astore 5
    //   152: goto -123 -> 29
    //   155: aload 12
    //   157: ldc_w 366
    //   160: invokevirtual 289	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore 15
    //   165: aload 12
    //   167: ldc_w 368
    //   170: invokevirtual 372	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   173: checkcast 66	android/content/Intent
    //   176: astore 16
    //   178: aload 15
    //   180: invokestatic 374	com/google/android/gms/auth/GoogleAuthUtil:ax	(Ljava/lang/String;)Z
    //   183: ifeq +52 -> 235
    //   186: new 122	com/google/android/gms/auth/UserRecoverableAuthException
    //   189: dup
    //   190: aload 15
    //   192: aload 16
    //   194: invokespecial 377	com/google/android/gms/auth/UserRecoverableAuthException:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
    //   197: athrow
    //   198: astore 10
    //   200: ldc_w 296
    //   203: ldc_w 298
    //   206: aload 10
    //   208: invokestatic 304	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   211: pop
    //   212: new 118	java/io/IOException
    //   215: dup
    //   216: ldc_w 306
    //   219: invokespecial 307	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   222: athrow
    //   223: astore 9
    //   225: aload 4
    //   227: aload 7
    //   229: invokevirtual 311	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   232: aload 9
    //   234: athrow
    //   235: aload 15
    //   237: invokestatic 379	com/google/android/gms/auth/GoogleAuthUtil:aw	(Ljava/lang/String;)Z
    //   240: ifeq +26 -> 266
    //   243: new 118	java/io/IOException
    //   246: dup
    //   247: aload 15
    //   249: invokespecial 307	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   252: athrow
    //   253: astore 8
    //   255: new 85	com/google/android/gms/auth/GoogleAuthException
    //   258: dup
    //   259: ldc_w 313
    //   262: invokespecial 114	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   265: athrow
    //   266: new 85	com/google/android/gms/auth/GoogleAuthException
    //   269: dup
    //   270: aload 15
    //   272: invokespecial 114	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   275: athrow
    //   276: new 118	java/io/IOException
    //   279: dup
    //   280: ldc_w 315
    //   283: invokespecial 307	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   286: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   91	127	198	android/os/RemoteException
    //   155	198	198	android/os/RemoteException
    //   235	253	198	android/os/RemoteException
    //   266	276	198	android/os/RemoteException
    //   91	127	223	finally
    //   155	198	223	finally
    //   200	223	223	finally
    //   235	253	223	finally
    //   255	266	223	finally
    //   266	276	223	finally
    //   91	127	253	java/lang/InterruptedException
    //   155	198	253	java/lang/InterruptedException
    //   235	253	253	java/lang/InterruptedException
    //   266	276	253	java/lang/InterruptedException
  }

  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (paramBundle == null)
      paramBundle = new Bundle();
    paramBundle.putBoolean("handle_notification", true);
    return a(paramContext, paramString1, paramString2, paramBundle);
  }

  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    h(paramIntent);
    if (paramBundle == null)
      paramBundle = new Bundle();
    paramBundle.putParcelable("callback_intent", paramIntent);
    paramBundle.putBoolean("handle_notification", true);
    return a(paramContext, paramString1, paramString2, paramBundle);
  }

  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (TextUtils.isEmpty(paramString3))
      throw new IllegalArgumentException("Authority cannot be empty or null.");
    if (paramBundle1 == null)
      paramBundle1 = new Bundle();
    if (paramBundle2 == null)
      paramBundle2 = new Bundle();
    ContentResolver.validateSyncExtrasBundle(paramBundle2);
    paramBundle1.putString("authority", paramString3);
    paramBundle1.putBundle("sync_extras", paramBundle2);
    paramBundle1.putBoolean("handle_notification", true);
    return a(paramContext, paramString1, paramString2, paramBundle1);
  }

  private static void h(Intent paramIntent)
  {
    if (paramIntent == null)
      throw new IllegalArgumentException("Callback cannot be null.");
    String str = paramIntent.toUri(1);
    try
    {
      Intent.parseUri(str, 1);
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
    }
    throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
  }

  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }

  private static class a extends Handler
  {
    private final Context mD;

    a(Context paramContext)
    {
    }

    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mD);
        if (GooglePlayServicesUtil.isUserRecoverableError(i))
          GooglePlayServicesUtil.showErrorNotification(i, this.mD);
        return;
      }
      Log.wtf("GoogleAuthUtil", "Don't know how to handle this message: " + paramMessage.what);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.GoogleAuthUtil
 * JD-Core Version:    0.6.2
 */