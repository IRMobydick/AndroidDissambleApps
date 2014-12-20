package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gw
{
  private static final Object a = new Object();
  private static boolean b = true;
  private static String c;
  private static boolean d = false;

  // ERROR //
  private static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 18	com/google/android/gms/internal/gw:a	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: getstatic 27	com/google/android/gms/internal/gw:c	Ljava/lang/String;
    //   9: ifnull +13 -> 22
    //   12: getstatic 27	com/google/android/gms/internal/gw:c	Ljava/lang/String;
    //   15: astore 4
    //   17: aload_2
    //   18: monitorexit
    //   19: goto +128 -> 147
    //   22: getstatic 33	android/os/Build$VERSION:SDK_INT	I
    //   25: bipush 17
    //   27: if_icmplt +58 -> 85
    //   30: aload_0
    //   31: invokestatic 38	com/google/android/gms/internal/hf:a	(Landroid/content/Context;)Ljava/lang/String;
    //   34: putstatic 27	com/google/android/gms/internal/gw:c	Ljava/lang/String;
    //   37: new 40	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   44: getstatic 27	com/google/android/gms/internal/gw:c	Ljava/lang/String;
    //   47: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 47
    //   52: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 49
    //   61: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: putstatic 27	com/google/android/gms/internal/gw:c	Ljava/lang/String;
    //   70: getstatic 27	com/google/android/gms/internal/gw:c	Ljava/lang/String;
    //   73: astore 4
    //   75: aload_2
    //   76: monitorexit
    //   77: goto +70 -> 147
    //   80: astore_3
    //   81: aload_2
    //   82: monitorexit
    //   83: aload_3
    //   84: athrow
    //   85: invokestatic 58	com/google/android/gms/internal/hh:b	()Z
    //   88: ifne +49 -> 137
    //   91: getstatic 61	com/google/android/gms/internal/hh:a	Landroid/os/Handler;
    //   94: new 63	com/google/android/gms/internal/gx
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 66	com/google/android/gms/internal/gx:<init>	(Landroid/content/Context;)V
    //   102: invokevirtual 72	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   105: pop
    //   106: getstatic 27	com/google/android/gms/internal/gw:c	Ljava/lang/String;
    //   109: astore 6
    //   111: aload 6
    //   113: ifnonnull -76 -> 37
    //   116: getstatic 18	com/google/android/gms/internal/gw:a	Ljava/lang/Object;
    //   119: invokevirtual 75	java/lang/Object:wait	()V
    //   122: goto -16 -> 106
    //   125: astore 7
    //   127: getstatic 27	com/google/android/gms/internal/gw:c	Ljava/lang/String;
    //   130: astore 4
    //   132: aload_2
    //   133: monitorexit
    //   134: goto +13 -> 147
    //   137: aload_0
    //   138: invokestatic 78	com/google/android/gms/internal/gw:e	(Landroid/content/Context;)Ljava/lang/String;
    //   141: putstatic 27	com/google/android/gms/internal/gw:c	Ljava/lang/String;
    //   144: goto -107 -> 37
    //   147: aload 4
    //   149: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   6	83	80	finally
    //   85	111	80	finally
    //   116	122	80	finally
    //   127	144	80	finally
    //   116	122	125	java/lang/InterruptedException
  }

  public static String a(Readable paramReadable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = CharBuffer.allocate(2048);
    while (true)
    {
      int i = paramReadable.read(localCharBuffer);
      if (i == -1)
        break;
      localCharBuffer.flip();
      localStringBuilder.append(localCharBuffer, 0, i);
    }
    return localStringBuilder.toString();
  }

  public static String a(String paramString)
  {
    return Uri.parse(paramString).buildUpon().query(null).build().toString();
  }

  public static Map a(Uri paramUri)
  {
    if (paramUri == null);
    HashMap localHashMap;
    for (Object localObject = null; ; localObject = localHashMap)
    {
      return localObject;
      localHashMap = new HashMap();
      UrlQuerySanitizer localUrlQuerySanitizer = new UrlQuerySanitizer();
      localUrlQuerySanitizer.setAllowUnregisteredParamaters(true);
      localUrlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
      localUrlQuerySanitizer.parseUrl(paramUri.toString());
      Iterator localIterator = localUrlQuerySanitizer.getParameterList().iterator();
      while (localIterator.hasNext())
      {
        UrlQuerySanitizer.ParameterValuePair localParameterValuePair = (UrlQuerySanitizer.ParameterValuePair)localIterator.next();
        localHashMap.put(localParameterValuePair.mParameter, localParameterValuePair.mValue);
      }
    }
  }

  private static JSONArray a(Collection paramCollection)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      a(localJSONArray, localIterator.next());
    return localJSONArray;
  }

  static JSONArray a(Object[] paramArrayOfObject)
  {
    JSONArray localJSONArray = new JSONArray();
    int i = paramArrayOfObject.length;
    for (int j = 0; j < i; j++)
      a(localJSONArray, paramArrayOfObject[j]);
    return localJSONArray;
  }

  private static JSONObject a(Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a(localJSONObject, str, paramBundle.get(str));
    }
    return localJSONObject;
  }

  public static JSONObject a(Map paramMap)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(localJSONObject, str, paramMap.get(str));
      }
    }
    catch (ClassCastException localClassCastException)
    {
      throw new JSONException("Could not convert map to JSON: " + localClassCastException.getMessage());
    }
    return localJSONObject;
  }

  public static void a(Context paramContext, String paramString, WebSettings paramWebSettings)
  {
    paramWebSettings.setUserAgentString(a(paramContext, paramString));
  }

  public static void a(Context paramContext, String paramString, List paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      new hg(paramContext, paramString, (String)localIterator.next()).e();
  }

  public static void a(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", a(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(false);
  }

  public static void a(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT >= 11)
      he.a(paramWebView);
  }

  private static void a(JSONArray paramJSONArray, Object paramObject)
  {
    if ((paramObject instanceof Bundle))
      paramJSONArray.put(a((Bundle)paramObject));
    while (true)
    {
      return;
      if ((paramObject instanceof Map))
      {
        paramJSONArray.put(a((Map)paramObject));
        continue;
      }
      if ((paramObject instanceof Collection))
      {
        paramJSONArray.put(a((Collection)paramObject));
        continue;
      }
      if ((paramObject instanceof Object[]))
      {
        paramJSONArray.put(a((Object[])(Object[])paramObject));
        continue;
      }
      paramJSONArray.put(paramObject);
    }
  }

  private static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    if ((paramObject instanceof Bundle))
      paramJSONObject.put(paramString, a((Bundle)paramObject));
    while (true)
    {
      return;
      if ((paramObject instanceof Map))
      {
        paramJSONObject.put(paramString, a((Map)paramObject));
        continue;
      }
      if ((paramObject instanceof Collection))
      {
        if (paramString != null);
        while (true)
        {
          paramJSONObject.put(paramString, a((Collection)paramObject));
          break;
          paramString = "null";
        }
      }
      if ((paramObject instanceof Object[]))
      {
        paramJSONObject.put(paramString, a(Arrays.asList((Object[])(Object[])paramObject)));
        continue;
      }
      paramJSONObject.put(paramString, paramObject);
    }
  }

  public static boolean a()
  {
    return b;
  }

  public static boolean a(Context paramContext)
  {
    int i = 0;
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveActivity(localIntent, 65536);
    if ((localResolveInfo == null) || (localResolveInfo.activityInfo == null))
    {
      hi.e("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
      return i;
    }
    if ((0x10 & localResolveInfo.activityInfo.configChanges) == 0)
    {
      Object[] arrayOfObject7 = new Object[1];
      arrayOfObject7[i] = "keyboard";
      hi.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject7));
    }
    for (int j = 0; ; j = 1)
    {
      if ((0x20 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[i] = "keyboardHidden";
        hi.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject6));
        j = 0;
      }
      if ((0x80 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        Object[] arrayOfObject5 = new Object[1];
        arrayOfObject5[i] = "orientation";
        hi.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject5));
        j = 0;
      }
      if ((0x100 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[i] = "screenLayout";
        hi.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject4));
        j = 0;
      }
      if ((0x200 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[i] = "uiMode";
        hi.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject3));
        j = 0;
      }
      if ((0x400 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[i] = "screenSize";
        hi.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject2));
        j = 0;
      }
      if ((0x800 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[i] = "smallestScreenSize";
        hi.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject1));
        break;
      }
      i = j;
      break;
    }
  }

  public static boolean a(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    if (paramPackageManager.checkPermission(paramString2, paramString1) == 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(ClassLoader paramClassLoader, Class paramClass, String paramString)
  {
    int i = 0;
    try
    {
      boolean bool = paramClass.isAssignableFrom(Class.forName(paramString, false, paramClassLoader));
      i = bool;
      label17: return i;
    }
    catch (Throwable localThrowable)
    {
      break label17;
    }
  }

  public static int b()
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (int i = 6; ; i = 0)
      return i;
  }

  public static void b(Context paramContext)
  {
    if (d);
    while (true)
    {
      return;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      paramContext.getApplicationContext().registerReceiver(new gz(null), localIntentFilter);
      d = true;
    }
  }

  public static void b(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT >= 11)
      he.b(paramWebView);
  }

  public static int c()
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (int i = 7; ; i = 1)
      return i;
  }

  public static int c(Context paramContext)
  {
    int i = 0;
    int j;
    if ((paramContext instanceof Activity))
    {
      Window localWindow = ((Activity)paramContext).getWindow();
      Rect localRect = new Rect();
      localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
      j = localRect.top;
      i = localWindow.findViewById(16908290).getTop() - j;
    }
    while (true)
    {
      return i + j;
      j = 0;
    }
  }

  public static String d()
  {
    UUID localUUID = UUID.randomUUID();
    byte[] arrayOfByte1 = BigInteger.valueOf(localUUID.getLeastSignificantBits()).toByteArray();
    byte[] arrayOfByte2 = BigInteger.valueOf(localUUID.getMostSignificantBits()).toByteArray();
    Object localObject = new BigInteger(1, arrayOfByte1).toString();
    int i = 0;
    while (true)
    {
      if (i < 2);
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(arrayOfByte1);
        localMessageDigest.update(arrayOfByte2);
        byte[] arrayOfByte3 = new byte[8];
        System.arraycopy(localMessageDigest.digest(), 0, arrayOfByte3, 0, 8);
        String str = new BigInteger(1, arrayOfByte3).toString();
        localObject = str;
        label106: i++;
        continue;
        return localObject;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        break label106;
      }
    }
  }

  private static String e(Context paramContext)
  {
    return new WebView(paramContext).getSettings().getUserAgentString();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gw
 * JD-Core Version:    0.6.0
 */