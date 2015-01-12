package com.google.android.gms.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
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
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ez
public final class gj
{
  private static final Object uf = new Object();
  private static final SimpleDateFormat[] wm = arrayOfSimpleDateFormat;
  private static boolean wn = true;
  private static String wo;
  private static boolean wp = false;

  static
  {
    SimpleDateFormat[] arrayOfSimpleDateFormat = new SimpleDateFormat[2];
    arrayOfSimpleDateFormat[0] = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    arrayOfSimpleDateFormat[1] = new SimpleDateFormat("yyyyMMdd");
  }

  public static String L(String paramString)
  {
    return Uri.parse(paramString).buildUpon().query(null).build().toString();
  }

  public static int M(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      gs.W("Could not parse value:" + localNumberFormatException);
    }
    return 0;
  }

  public static boolean N(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    return paramString.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
  }

  public static long O(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString))
      return -1L;
    SimpleDateFormat[] arrayOfSimpleDateFormat = wm;
    int j = arrayOfSimpleDateFormat.length;
    while (i < j)
    {
      SimpleDateFormat localSimpleDateFormat = arrayOfSimpleDateFormat[i];
      try
      {
        localSimpleDateFormat.setLenient(false);
        localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        long l2 = localSimpleDateFormat.parse(paramString).getTime();
        return l2;
      }
      catch (ParseException localParseException)
      {
        i++;
      }
    }
    try
    {
      long l1 = Long.parseLong(paramString);
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return -1L;
  }

  public static String a(Readable paramReadable)
    throws IOException
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

  private static JSONArray a(Collection<?> paramCollection)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      a(localJSONArray, localIterator.next());
    return localJSONArray;
  }

  static JSONArray a(Object[] paramArrayOfObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    int i = paramArrayOfObject.length;
    for (int j = 0; j < i; j++)
      a(localJSONArray, paramArrayOfObject[j]);
    return localJSONArray;
  }

  public static void a(Context paramContext, String paramString, WebSettings paramWebSettings)
  {
    paramWebSettings.setUserAgentString(c(paramContext, paramString));
  }

  public static void a(Context paramContext, String paramString, List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      new gq(paramContext, paramString, (String)localIterator.next()).start();
  }

  public static void a(Context paramContext, String paramString1, List<String> paramList, String paramString2)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      new gq(paramContext, paramString1, (String)localIterator.next(), paramString2).start();
  }

  public static void a(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection)
  {
    a(paramContext, paramString, paramBoolean, paramHttpURLConnection, false);
  }

  public static void a(Context paramContext, String paramString1, boolean paramBoolean, HttpURLConnection paramHttpURLConnection, String paramString2)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", paramString2);
    paramHttpURLConnection.setUseCaches(false);
  }

  public static void a(Context paramContext, String paramString, boolean paramBoolean1, HttpURLConnection paramHttpURLConnection, boolean paramBoolean2)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean1);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", c(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(paramBoolean2);
  }

  public static void a(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT >= 11)
      gn.a(paramWebView);
  }

  private static void a(JSONArray paramJSONArray, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONArray.put(c((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONArray.put(t((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      paramJSONArray.put(a((Collection)paramObject));
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONArray.put(a((Object[])paramObject));
      return;
    }
    paramJSONArray.put(paramObject);
  }

  private static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof Bundle))
    {
      paramJSONObject.put(paramString, c((Bundle)paramObject));
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJSONObject.put(paramString, t((Map)paramObject));
      return;
    }
    if ((paramObject instanceof Collection))
    {
      if (paramString != null);
      while (true)
      {
        paramJSONObject.put(paramString, a((Collection)paramObject));
        return;
        paramString = "null";
      }
    }
    if ((paramObject instanceof Object[]))
    {
      paramJSONObject.put(paramString, a(Arrays.asList((Object[])paramObject)));
      return;
    }
    paramJSONObject.put(paramString, paramObject);
  }

  public static boolean a(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    return paramPackageManager.checkPermission(paramString2, paramString1) == 0;
  }

  public static boolean a(ClassLoader paramClassLoader, Class<?> paramClass, String paramString)
  {
    try
    {
      boolean bool = paramClass.isAssignableFrom(Class.forName(paramString, false, paramClassLoader));
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static void b(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT >= 11)
      gn.b(paramWebView);
  }

  public static String c(Context paramContext, String paramString)
  {
    synchronized (uf)
    {
      if (wo != null)
      {
        String str4 = wo;
        return str4;
      }
      int i = Build.VERSION.SDK_INT;
      if (i < 17)
        break label93;
    }
    try
    {
      wo = gp.getDefaultUserAgent(paramContext);
      wo = wo + " (Mobile; " + paramString + ")";
      String str3 = wo;
      return str3;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Exception localException2)
    {
    }
    label93: if (!gr.ds())
    {
      gr.wC.post(new Runnable()
      {
        public void run()
        {
          synchronized (gj.dp())
          {
            gj.P(gj.u(this.mV));
            gj.dp().notifyAll();
            return;
          }
        }
      });
      while (true)
      {
        String str2 = wo;
        if (str2 != null)
          break;
        try
        {
          uf.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          wo = dn();
          gs.W("Interrupted, use default user agent: " + wo);
        }
      }
    }
    try
    {
      wo = r(paramContext);
      wo = wo + " (Mobile; " + paramString + ")";
      String str1 = wo;
      return str1;
    }
    catch (Exception localException1)
    {
      while (true)
        wo = dn();
    }
  }

  public static Map<String, String> c(Uri paramUri)
  {
    if (paramUri == null)
      return null;
    HashMap localHashMap = new HashMap();
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
    return localHashMap;
  }

  private static JSONObject c(Bundle paramBundle)
    throws JSONException
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

  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString2);
    a(paramContext, paramString1, localArrayList);
  }

  public static boolean dk()
  {
    return wn;
  }

  public static int dl()
  {
    if (Build.VERSION.SDK_INT >= 9)
      return 6;
    return 0;
  }

  public static int dm()
  {
    if (Build.VERSION.SDK_INT >= 9)
      return 7;
    return 1;
  }

  static String dn()
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("Mozilla/5.0 (Linux; U; Android");
    if (Build.VERSION.RELEASE != null)
      localStringBuffer.append(" ").append(Build.VERSION.RELEASE);
    localStringBuffer.append("; ").append(Locale.getDefault());
    if (Build.DEVICE != null)
    {
      localStringBuffer.append("; ").append(Build.DEVICE);
      if (Build.DISPLAY != null)
        localStringBuffer.append(" Build/").append(Build.DISPLAY);
    }
    localStringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
    return localStringBuffer.toString();
  }

  public static String jdMethod_do()
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

  public static boolean p(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveActivity(localIntent, 65536);
    if ((localResolveInfo == null) || (localResolveInfo.activityInfo == null))
    {
      gs.W("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
      return false;
    }
    if ((0x10 & localResolveInfo.activityInfo.configChanges) == 0)
      gs.W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboard" }));
    for (boolean bool = false; ; bool = true)
    {
      if ((0x20 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        gs.W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "keyboardHidden" }));
        bool = false;
      }
      if ((0x80 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        gs.W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "orientation" }));
        bool = false;
      }
      if ((0x100 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        gs.W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenLayout" }));
        bool = false;
      }
      if ((0x200 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        gs.W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "uiMode" }));
        bool = false;
      }
      if ((0x400 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        gs.W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "screenSize" }));
        bool = false;
      }
      if ((0x800 & localResolveInfo.activityInfo.configChanges) == 0)
      {
        gs.W(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[] { "smallestScreenSize" }));
        return false;
      }
      return bool;
    }
  }

  public static void q(Context paramContext)
  {
    if (wp)
      return;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.getApplicationContext().registerReceiver(new a(null), localIntentFilter);
    wp = true;
  }

  private static String r(Context paramContext)
  {
    return new WebView(paramContext).getSettings().getUserAgentString();
  }

  public static int s(Context paramContext)
  {
    int j;
    int i;
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
      i = 0;
      j = 0;
    }
  }

  public static JSONObject t(Map<String, ?> paramMap)
    throws JSONException
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

  public static int[] t(Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f = 160.0F / localDisplayMetrics.densityDpi;
    return new int[] { (int)(f * localDisplayMetrics.widthPixels), (int)(f * localDisplayMetrics.heightPixels) };
  }

  private static final class a extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction()))
        gj.w(true);
      while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()))
        return;
      gj.w(false);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gj
 * JD-Core Version:    0.6.2
 */