package com.baidu.location;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import java.util.List;
import org.apache.http.HttpEntity;

abstract class s
  implements ax, n
{
  private static int cU = 4;
  private static String cX = "10.0.0.172";
  protected static int cY = 0;
  private static int cZ = 80;
  public int c0 = 3;
  public String cR = null;
  public HttpEntity cS = null;
  public List cT = null;
  private boolean cV = false;
  public String cW = null;

  private void L()
  {
    cU = P();
  }

  // ERROR //
  private int P()
  {
    // Byte code:
    //   0: invokestatic 68	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   3: astore_1
    //   4: aload_1
    //   5: ldc 70
    //   7: invokevirtual 76	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   10: checkcast 78	android/net/ConnectivityManager
    //   13: astore 7
    //   15: aload 7
    //   17: ifnonnull +5 -> 22
    //   20: iconst_4
    //   21: ireturn
    //   22: aload 7
    //   24: invokevirtual 82	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   27: astore 8
    //   29: aload 8
    //   31: ifnull +271 -> 302
    //   34: aload 8
    //   36: invokevirtual 88	android/net/NetworkInfo:isAvailable	()Z
    //   39: ifne +6 -> 45
    //   42: goto +260 -> 302
    //   45: aload 8
    //   47: invokevirtual 91	android/net/NetworkInfo:getType	()I
    //   50: iconst_1
    //   51: if_icmpne +5 -> 56
    //   54: iconst_3
    //   55: ireturn
    //   56: ldc 93
    //   58: invokestatic 99	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   61: astore 10
    //   63: aload_1
    //   64: invokevirtual 103	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   67: aload 10
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: invokevirtual 109	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore 11
    //   78: aload 11
    //   80: ifnull +177 -> 257
    //   83: aload 11
    //   85: invokeinterface 114 1 0
    //   90: ifeq +167 -> 257
    //   93: aload 11
    //   95: aload 11
    //   97: ldc 116
    //   99: invokeinterface 120 2 0
    //   104: invokeinterface 124 2 0
    //   109: astore 12
    //   111: aload 12
    //   113: ifnull +71 -> 184
    //   116: aload 12
    //   118: invokevirtual 129	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   121: ldc 131
    //   123: invokevirtual 135	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   126: ifeq +58 -> 184
    //   129: invokestatic 140	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   132: astore 14
    //   134: aload 14
    //   136: ifnull +170 -> 306
    //   139: aload 14
    //   141: ldc 142
    //   143: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifne +160 -> 306
    //   149: aload 14
    //   151: ldc 148
    //   153: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: ifne +150 -> 306
    //   159: aload 14
    //   161: putstatic 31	com/baidu/location/s:cX	Ljava/lang/String;
    //   164: bipush 80
    //   166: putstatic 33	com/baidu/location/s:cZ	I
    //   169: aload 11
    //   171: ifnull +133 -> 304
    //   174: aload 11
    //   176: invokeinterface 151 1 0
    //   181: goto +123 -> 304
    //   184: aload 12
    //   186: ifnull +71 -> 257
    //   189: aload 12
    //   191: invokevirtual 129	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   194: ldc 153
    //   196: invokevirtual 135	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   199: ifeq +58 -> 257
    //   202: invokestatic 140	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   205: astore 13
    //   207: aload 13
    //   209: ifnull +106 -> 315
    //   212: aload 13
    //   214: ldc 142
    //   216: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: ifne +96 -> 315
    //   222: aload 13
    //   224: ldc 148
    //   226: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: ifne +86 -> 315
    //   232: aload 13
    //   234: putstatic 31	com/baidu/location/s:cX	Ljava/lang/String;
    //   237: bipush 80
    //   239: putstatic 33	com/baidu/location/s:cZ	I
    //   242: aload 11
    //   244: ifnull +69 -> 313
    //   247: aload 11
    //   249: invokeinterface 151 1 0
    //   254: goto +59 -> 313
    //   257: aload 11
    //   259: ifnull +10 -> 269
    //   262: aload 11
    //   264: invokeinterface 151 1 0
    //   269: iconst_2
    //   270: ireturn
    //   271: astore_3
    //   272: aconst_null
    //   273: astore 4
    //   275: aload_1
    //   276: aload 4
    //   278: invokestatic 157	com/baidu/location/s:if	(Landroid/content/Context;Landroid/net/NetworkInfo;)I
    //   281: istore 6
    //   283: iload 6
    //   285: ireturn
    //   286: astore 5
    //   288: iconst_4
    //   289: ireturn
    //   290: astore_2
    //   291: iconst_4
    //   292: ireturn
    //   293: astore 9
    //   295: aload 8
    //   297: astore 4
    //   299: goto -24 -> 275
    //   302: iconst_4
    //   303: ireturn
    //   304: iconst_1
    //   305: ireturn
    //   306: ldc 159
    //   308: astore 14
    //   310: goto -151 -> 159
    //   313: iconst_1
    //   314: ireturn
    //   315: ldc 29
    //   317: astore 13
    //   319: goto -87 -> 232
    //
    // Exception table:
    //   from	to	target	type
    //   4	15	271	java/lang/SecurityException
    //   22	29	271	java/lang/SecurityException
    //   275	283	286	java/lang/Exception
    //   4	15	290	java/lang/Exception
    //   22	29	290	java/lang/Exception
    //   34	42	290	java/lang/Exception
    //   45	54	290	java/lang/Exception
    //   56	78	290	java/lang/Exception
    //   83	111	290	java/lang/Exception
    //   116	134	290	java/lang/Exception
    //   139	159	290	java/lang/Exception
    //   159	169	290	java/lang/Exception
    //   174	181	290	java/lang/Exception
    //   189	207	290	java/lang/Exception
    //   212	232	290	java/lang/Exception
    //   232	242	290	java/lang/Exception
    //   247	254	290	java/lang/Exception
    //   262	269	290	java/lang/Exception
    //   34	42	293	java/lang/SecurityException
    //   45	54	293	java/lang/SecurityException
    //   56	78	293	java/lang/SecurityException
    //   83	111	293	java/lang/SecurityException
    //   116	134	293	java/lang/SecurityException
    //   139	159	293	java/lang/SecurityException
    //   159	169	293	java/lang/SecurityException
    //   174	181	293	java/lang/SecurityException
    //   189	207	293	java/lang/SecurityException
    //   212	232	293	java/lang/SecurityException
    //   232	242	293	java/lang/SecurityException
    //   247	254	293	java/lang/SecurityException
    //   262	269	293	java/lang/SecurityException
  }

  private static int jdMethod_if(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    int i = 2;
    String str2;
    String str3;
    if ((paramNetworkInfo != null) && (paramNetworkInfo.getExtraInfo() != null))
    {
      str2 = paramNetworkInfo.getExtraInfo().toLowerCase();
      if (str2 != null)
        if ((str2.startsWith("cmwap")) || (str2.startsWith("uniwap")) || (str2.startsWith("3gwap")))
        {
          str3 = Proxy.getDefaultHost();
          if ((str3 != null) && (!str3.equals("")) && (!str3.equals("null")))
          {
            cX = str3;
            i = 1;
          }
        }
    }
    String str1;
    do
    {
      do
      {
        do
        {
          return i;
          str3 = "10.0.0.172";
          break;
          if (str2.startsWith("ctwap"))
          {
            String str4 = Proxy.getDefaultHost();
            if ((str4 != null) && (!str4.equals("")) && (!str4.equals("null")));
            while (true)
            {
              cX = str4;
              return 1;
              str4 = "10.0.0.200";
            }
          }
        }
        while ((str2.startsWith("cmnet")) || (str2.startsWith("uninet")) || (str2.startsWith("ctnet")) || (str2.startsWith("3gnet")));
        str1 = Proxy.getDefaultHost();
      }
      while ((str1 == null) || (str1.length() <= 0));
      if ("10.0.0.172".equals(str1.trim()))
      {
        cX = "10.0.0.172";
        return 1;
      }
    }
    while (!"10.0.0.200".equals(str1.trim()));
    cX = "10.0.0.200";
    return 1;
  }

  public static boolean jdMethod_if(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager.getActiveNetworkInfo() != null)
      {
        boolean bool = localConnectivityManager.getActiveNetworkInfo().isAvailable();
        return bool;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    return false;
  }

  public void N()
  {
    new s.2(this).start();
  }

  public void Q()
  {
    new s.1(this).start();
  }

  public void R()
  {
    new s.3(this).start();
  }

  abstract void T();

  abstract void jdMethod_do(boolean paramBoolean);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.s
 * JD-Core Version:    0.6.2
 */