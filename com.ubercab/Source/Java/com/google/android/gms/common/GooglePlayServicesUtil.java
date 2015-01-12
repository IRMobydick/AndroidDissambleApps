package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.string;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.kc;
import java.util.Arrays;
import java.util.Set;

public final class GooglePlayServicesUtil
{
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 6171000;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  public static boolean Ii = false;
  public static boolean Ij = false;
  private static int Ik = -1;
  private static final Object Il = new Object();

  public static void D(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      Intent localIntent = c(paramContext, i);
      Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + i);
      if (localIntent == null)
        throw new GooglePlayServicesNotAvailableException(i);
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", localIntent);
    }
  }

  private static void E(Context paramContext)
  {
    int i;
    try
    {
      ApplicationInfo localApplicationInfo2 = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      localApplicationInfo1 = localApplicationInfo2;
      Bundle localBundle = localApplicationInfo1.metaData;
      if (localBundle == null)
        break label115;
      i = localBundle.getInt("com.google.android.gms.version");
      if (i == 6171000)
        return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        Log.wtf("GooglePlayServicesUtil", "This should never happen.", localNameNotFoundException);
        ApplicationInfo localApplicationInfo1 = null;
      }
    }
    throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 6171000 but found " + i + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
    label115: throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
  }

  private static String F(Context paramContext)
  {
    String str = paramContext.getApplicationInfo().name;
    PackageManager localPackageManager;
    if (TextUtils.isEmpty(str))
    {
      str = paramContext.getPackageName();
      localPackageManager = paramContext.getApplicationContext().getPackageManager();
    }
    try
    {
      ApplicationInfo localApplicationInfo2 = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
      localApplicationInfo1 = localApplicationInfo2;
      if (localApplicationInfo1 != null)
        str = localPackageManager.getApplicationLabel(localApplicationInfo1).toString();
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        ApplicationInfo localApplicationInfo1 = null;
    }
  }

  private static Dialog a(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if ((jt.K(paramActivity)) && (paramInt1 == 2))
      paramInt1 = 42;
    if (kc.hE())
    {
      TypedValue localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, localTypedValue, true);
      if (!"Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(localTypedValue.resourceId)));
    }
    for (AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity, 5); ; localBuilder = null)
    {
      if (localBuilder == null)
        localBuilder = new AlertDialog.Builder(paramActivity);
      localBuilder.setMessage(d(paramActivity, paramInt1));
      if (paramOnCancelListener != null)
        localBuilder.setOnCancelListener(paramOnCancelListener);
      Intent localIntent = c(paramActivity, paramInt1);
      if (paramFragment == null);
      for (c localc = new c(paramActivity, localIntent, paramInt2); ; localc = new c(paramFragment, localIntent, paramInt2))
      {
        String str = e(paramActivity, paramInt1);
        if (str != null)
          localBuilder.setPositiveButton(str, localc);
        switch (paramInt1)
        {
        default:
          Log.e("GooglePlayServicesUtil", "Unexpected error code " + paramInt1);
          return localBuilder.create();
        case 0:
        case 4:
        case 6:
        case 1:
        case 3:
        case 2:
        case 42:
        case 9:
        case 7:
        case 8:
        case 10:
        case 5:
        case 11:
        }
      }
      return null;
      return localBuilder.create();
      return localBuilder.setTitle(R.string.common_google_play_services_install_title).create();
      return localBuilder.setTitle(R.string.common_google_play_services_enable_title).create();
      return localBuilder.setTitle(R.string.common_google_play_services_update_title).create();
      return localBuilder.setTitle(R.string.common_android_wear_update_title).create();
      Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
      return localBuilder.setTitle(R.string.common_google_play_services_unsupported_title).create();
      Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
      return localBuilder.setTitle(R.string.common_google_play_services_network_error_title).create();
      Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
      return localBuilder.create();
      Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
      return localBuilder.create();
      Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
      return localBuilder.setTitle(R.string.common_google_play_services_invalid_account_title).create();
      Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
      return localBuilder.create();
    }
  }

  public static boolean a(PackageManager paramPackageManager, PackageInfo paramPackageInfo)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramPackageInfo == null);
    do
    {
      return bool2;
      if (c(paramPackageManager))
      {
        if (a(paramPackageInfo, bool1) != null);
        while (true)
        {
          return bool1;
          bool1 = false;
        }
      }
      byte[] arrayOfByte = a(paramPackageInfo, false);
      bool2 = false;
      if (arrayOfByte != null)
        bool2 = bool1;
    }
    while ((bool2) || (a(paramPackageInfo, bool1) == null));
    Log.w("GooglePlayServicesUtil", "Test-keys aren't accepted on this build.");
    return bool2;
  }

  public static boolean a(Resources paramResources)
  {
    if (paramResources == null);
    while (true)
    {
      return false;
      if ((0xF & paramResources.getConfiguration().screenLayout) > 3);
      for (int i = 1; ((kc.hB()) && (i != 0)) || (b(paramResources)); i = 0)
        return true;
    }
  }

  private static byte[] a(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
      return null;
    }
    byte[] arrayOfByte = paramPackageInfo.signatures[0].toByteArray();
    if (paramBoolean);
    for (Set localSet = b.fY(); localSet.contains(arrayOfByte); localSet = b.fZ())
      return arrayOfByte;
    if (Log.isLoggable("GooglePlayServicesUtil", 2))
      Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(arrayOfByte, 0));
    return null;
  }

  private static byte[] a(PackageInfo paramPackageInfo, byte[][] paramArrayOfByte)
  {
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
      return null;
    }
    byte[] arrayOfByte1 = paramPackageInfo.signatures[0].toByteArray();
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      byte[] arrayOfByte2 = paramArrayOfByte[i];
      if (Arrays.equals(arrayOfByte2, arrayOfByte1))
        return arrayOfByte2;
    }
    if (Log.isLoggable("GooglePlayServicesUtil", 2))
      Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(arrayOfByte1, 0));
    return null;
  }

  public static Intent ai(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
    case 2:
      return h.aY("com.google.android.gms");
    case 42:
      return h.gZ();
    case 3:
    }
    return h.aW("com.google.android.gms");
  }

  public static boolean b(PackageManager paramPackageManager)
  {
    synchronized (Il)
    {
      int i = Ik;
      if (i == -1);
      try
      {
        PackageInfo localPackageInfo = paramPackageManager.getPackageInfo("com.google.android.gms", 64);
        byte[][] arrayOfByte = new byte[1][];
        arrayOfByte[0] = b.Ie[1];
        if (a(localPackageInfo, arrayOfByte) != null);
        for (Ik = 1; Ik != 0; Ik = 0)
          return true;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        while (true)
          Ik = 0;
      }
    }
    return false;
  }

  public static boolean b(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = paramPackageManager.getPackageInfo(paramString, 64);
      return a(paramPackageManager, localPackageInfo);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      if (Log.isLoggable("GooglePlayServicesUtil", 3))
        Log.d("GooglePlayServicesUtil", "Package manager can't find package " + paramString + ", defaulting to false");
    }
    return false;
  }

  private static boolean b(Resources paramResources)
  {
    Configuration localConfiguration = paramResources.getConfiguration();
    boolean bool1 = kc.hD();
    boolean bool2 = false;
    if (bool1)
    {
      int i = 0xF & localConfiguration.screenLayout;
      bool2 = false;
      if (i <= 3)
      {
        int j = localConfiguration.smallestScreenWidthDp;
        bool2 = false;
        if (j >= 600)
          bool2 = true;
      }
    }
    return bool2;
  }

  @Deprecated
  public static Intent c(Context paramContext, int paramInt)
  {
    return ai(paramInt);
  }

  public static boolean c(PackageManager paramPackageManager)
  {
    return (b(paramPackageManager)) || (!ga());
  }

  public static String d(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    switch (paramInt)
    {
    default:
      return localResources.getString(R.string.common_google_play_services_unknown_issue);
    case 1:
      if (a(paramContext.getResources()))
        return localResources.getString(R.string.common_google_play_services_install_text_tablet);
      return localResources.getString(R.string.common_google_play_services_install_text_phone);
    case 3:
      return localResources.getString(R.string.common_google_play_services_enable_text);
    case 2:
      return localResources.getString(R.string.common_google_play_services_update_text);
    case 42:
      return localResources.getString(R.string.common_android_wear_update_text);
    case 9:
      return localResources.getString(R.string.common_google_play_services_unsupported_text);
    case 7:
      return localResources.getString(R.string.common_google_play_services_network_error_text);
    case 5:
    }
    return localResources.getString(R.string.common_google_play_services_invalid_account_text);
  }

  public static String e(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    switch (paramInt)
    {
    default:
      return localResources.getString(17039370);
    case 1:
      return localResources.getString(R.string.common_google_play_services_install_button);
    case 3:
      return localResources.getString(R.string.common_google_play_services_enable_button);
    case 2:
    case 42:
    }
    return localResources.getString(R.string.common_google_play_services_update_button);
  }

  public static String f(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    switch (paramInt)
    {
    default:
      return localResources.getString(R.string.common_google_play_services_unknown_issue);
    case 1:
      return localResources.getString(R.string.common_google_play_services_notification_needs_installation_title);
    case 2:
      return localResources.getString(R.string.common_google_play_services_notification_needs_update_title);
    case 42:
      return localResources.getString(R.string.common_android_wear_notification_needs_update_text);
    case 3:
      return localResources.getString(R.string.common_google_play_services_needs_enabling_title);
    case 9:
      return localResources.getString(R.string.common_google_play_services_unsupported_text);
    case 7:
      return localResources.getString(R.string.common_google_play_services_network_error_text);
    case 5:
    }
    return localResources.getString(R.string.common_google_play_services_invalid_account_text);
  }

  public static boolean ga()
  {
    if (Ii)
      return Ij;
    return "user".equals(Build.TYPE);
  }

  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }

  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }

  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    Intent localIntent = c(paramContext, paramInt1);
    if (localIntent == null)
      return null;
    return PendingIntent.getActivity(paramContext, paramInt2, localIntent, 268435456);
  }

  public static String getErrorString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "UNKNOWN_ERROR_CODE";
    case 0:
      return "SUCCESS";
    case 1:
      return "SERVICE_MISSING";
    case 2:
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3:
      return "SERVICE_DISABLED";
    case 4:
      return "SIGN_IN_REQUIRED";
    case 5:
      return "INVALID_ACCOUNT";
    case 6:
      return "RESOLUTION_REQUIRED";
    case 7:
      return "NETWORK_ERROR";
    case 8:
      return "INTERNAL_ERROR";
    case 9:
      return "SERVICE_INVALID";
    case 10:
      return "DEVELOPER_ERROR";
    case 11:
    }
    return "LICENSE_CHECK_FAILED";
  }

  // ERROR //
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    // Byte code:
    //   0: new 531	android/net/Uri$Builder
    //   3: dup
    //   4: invokespecial 532	android/net/Uri$Builder:<init>	()V
    //   7: ldc_w 534
    //   10: invokevirtual 538	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   13: ldc 11
    //   15: invokevirtual 541	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   18: ldc_w 543
    //   21: invokevirtual 546	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   24: ldc_w 548
    //   27: invokevirtual 546	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   30: invokevirtual 552	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   33: astore_1
    //   34: aload_0
    //   35: invokevirtual 556	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: aload_1
    //   39: invokevirtual 562	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   42: astore 4
    //   44: new 564	java/util/Scanner
    //   47: dup
    //   48: aload 4
    //   50: invokespecial 567	java/util/Scanner:<init>	(Ljava/io/InputStream;)V
    //   53: ldc_w 569
    //   56: invokevirtual 573	java/util/Scanner:useDelimiter	(Ljava/lang/String;)Ljava/util/Scanner;
    //   59: invokevirtual 576	java/util/Scanner:next	()Ljava/lang/String;
    //   62: astore 7
    //   64: aload 7
    //   66: astore_3
    //   67: aload 4
    //   69: ifnull +43 -> 112
    //   72: aload 4
    //   74: invokevirtual 581	java/io/InputStream:close	()V
    //   77: aload_3
    //   78: areturn
    //   79: astore 6
    //   81: aload 4
    //   83: ifnull +31 -> 114
    //   86: aload 4
    //   88: invokevirtual 581	java/io/InputStream:close	()V
    //   91: goto +23 -> 114
    //   94: astore 5
    //   96: aload 4
    //   98: ifnull +8 -> 106
    //   101: aload 4
    //   103: invokevirtual 581	java/io/InputStream:close	()V
    //   106: aload 5
    //   108: athrow
    //   109: astore_2
    //   110: aconst_null
    //   111: astore_3
    //   112: aload_3
    //   113: areturn
    //   114: aconst_null
    //   115: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   44	64	79	java/util/NoSuchElementException
    //   44	64	94	finally
    //   34	44	109	java/lang/Exception
    //   72	77	109	java/lang/Exception
    //   86	91	109	java/lang/Exception
    //   101	106	109	java/lang/Exception
    //   106	109	109	java/lang/Exception
  }

  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      Context localContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return localContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      Resources localResources = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return localResources;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (!com.google.android.gms.common.internal.b.Lr);
    PackageInfo localPackageInfo1;
    while (true)
    {
      try
      {
        paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
        if (!com.google.android.gms.common.internal.b.Lr)
          E(paramContext);
      }
      catch (Throwable localThrowable)
      {
        try
        {
          localPackageInfo1 = localPackageManager.getPackageInfo("com.google.android.gms", 64);
          if (!jt.aP(localPackageInfo1.versionCode))
            break label248;
          if (ga())
          {
            j = 0;
            byte[][] arrayOfByte1 = new byte[3][];
            arrayOfByte1[0] = b.HH[j];
            arrayOfByte1[1] = b.HN[j];
            arrayOfByte1[2] = b.HM[j];
            if (a(localPackageInfo1, arrayOfByte1) != null)
              break;
            Log.w("GooglePlayServicesUtil", "Google Play Services signature invalid on Glass.");
            return 9;
            localThrowable = localThrowable;
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
          return 1;
        }
      }
      int j = 1;
    }
    String str = paramContext.getPackageName();
    try
    {
      PackageInfo localPackageInfo3 = localPackageManager.getPackageInfo(str, 64);
      if (a(localPackageManager, localPackageInfo3))
        break label358;
      Log.w("GooglePlayServicesUtil", "Calling package " + localPackageInfo3.packageName + " signature invalid on Glass.");
      return 9;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException4)
    {
      Log.w("GooglePlayServicesUtil", "Could not get info for calling package: " + str);
      return 9;
    }
    label248: if (jt.K(paramContext))
    {
      if (a(localPackageInfo1, b.HH) == null)
      {
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
      }
    }
    else
    {
      byte[] arrayOfByte;
      try
      {
        PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.android.vending", 64);
        arrayOfByte = a(localPackageInfo2, b.HH);
        if (arrayOfByte == null)
        {
          Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
          return 9;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2)
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
        return 9;
      }
      if (a(localPackageInfo1, new byte[][] { arrayOfByte }) == null)
      {
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
      }
    }
    label358: int i = jt.aN(6171000);
    if (jt.aN(localPackageInfo1.versionCode) < i)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 6171000 but found " + localPackageInfo1.versionCode);
      return 2;
    }
    try
    {
      ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
      if (!localApplicationInfo.enabled)
        return 3;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException3)
    {
      Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
      localNameNotFoundException3.printStackTrace();
      return 1;
    }
    return 0;
  }

  public static boolean isGoogleSignedUid(PackageManager paramPackageManager, int paramInt)
  {
    if (paramPackageManager == null)
      throw new SecurityException("Unknown error: invalid Package Manager");
    String[] arrayOfString = paramPackageManager.getPackagesForUid(paramInt);
    if ((arrayOfString.length == 0) || (!b(paramPackageManager, arrayOfString[0])))
      throw new SecurityException("Uid is not Google Signed");
    return true;
  }

  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    default:
      return false;
    case 1:
    case 2:
    case 3:
    case 9:
    }
    return true;
  }

  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }

  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }

  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = a(paramInt1, paramActivity, paramFragment, paramInt2, paramOnCancelListener);
    if (localDialog == null)
      return false;
    try
    {
      bool = paramActivity instanceof FragmentActivity;
      if (bool)
      {
        android.support.v4.app.FragmentManager localFragmentManager1 = ((FragmentActivity)paramActivity).getSupportFragmentManager();
        SupportErrorDialogFragment.newInstance(localDialog, paramOnCancelListener).show(localFragmentManager1, "GooglePlayServicesErrorDialog");
      }
      while (true)
      {
        return true;
        if (!kc.hB())
          break;
        android.app.FragmentManager localFragmentManager = paramActivity.getFragmentManager();
        ErrorDialogFragment.newInstance(localDialog, paramOnCancelListener).show(localFragmentManager, "GooglePlayServicesErrorDialog");
      }
      throw new RuntimeException("This Activity does not support Fragments.");
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      while (true)
        boolean bool = false;
    }
  }

  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    boolean bool = jt.K(paramContext);
    if ((bool) && (paramInt == 2))
      paramInt = 42;
    Resources localResources = paramContext.getResources();
    String str1 = f(paramContext, paramInt);
    int i = R.string.common_google_play_services_error_notification_requested_by_msg;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = F(paramContext);
    String str2 = localResources.getString(i, arrayOfObject);
    PendingIntent localPendingIntent = getErrorPendingIntent(paramInt, paramContext, 0);
    if (bool)
      o.I(kc.hF());
    Notification localNotification;
    for (Object localObject = new Notification.Builder(paramContext).setSmallIcon(R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText(str1 + " " + str2)).addAction(R.drawable.common_full_open_on_phone, localResources.getString(R.string.common_open_on_phone), localPendingIntent).build(); ; localObject = localNotification)
    {
      ((NotificationManager)paramContext.getSystemService("notification")).notify(39789, (Notification)localObject);
      return;
      localNotification = new Notification(17301642, localResources.getString(R.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
      localNotification.flags = (0x10 | localNotification.flags);
      localNotification.setLatestEventInfo(paramContext, str1, str2, localPendingIntent);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil
 * JD-Core Version:    0.6.2
 */