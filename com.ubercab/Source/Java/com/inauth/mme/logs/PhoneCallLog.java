package com.inauth.mme.logs;

import com.google.gson.Gson;
import com.inauth.mme.response.LogResponse;

public class PhoneCallLog
{
  private long lastTimeChecked;

  private long getLastTimeChecked()
  {
    return this.lastTimeChecked;
  }

  private void setLastTimeChecked(long paramLong)
  {
    this.lastTimeChecked = paramLong;
  }

  public LogResponse deserialize(String paramString)
  {
    return (LogResponse)new Gson().fromJson(paramString, LogResponse.class);
  }

  // ERROR //
  public String serialize(android.app.Application paramApplication, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 33	com/inauth/mme/header/LogHeader
    //   3: dup
    //   4: invokespecial 34	com/inauth/mme/header/LogHeader:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_3
    //   12: invokevirtual 38	com/inauth/mme/header/LogHeader:setAccountGUID	(Ljava/lang/String;)V
    //   15: aload 5
    //   17: aload_2
    //   18: invokevirtual 41	com/inauth/mme/header/LogHeader:setDeviceGUID	(Ljava/lang/String;)V
    //   21: aload 5
    //   23: invokestatic 47	com/inauth/mme/InAuthManager:getInstance	()Lcom/inauth/mme/InAuthManager;
    //   26: invokevirtual 51	com/inauth/mme/InAuthManager:getInAuthDynamicID	()Ljava/lang/String;
    //   29: invokevirtual 54	com/inauth/mme/header/LogHeader:setDynamicID	(Ljava/lang/String;)V
    //   32: aload 5
    //   34: aload 4
    //   36: invokevirtual 57	com/inauth/mme/header/LogHeader:setTransaction_id	(Ljava/lang/String;)V
    //   39: aload 5
    //   41: invokestatic 47	com/inauth/mme/InAuthManager:getInstance	()Lcom/inauth/mme/InAuthManager;
    //   44: invokevirtual 60	com/inauth/mme/InAuthManager:getSDKVersion	()Ljava/lang/String;
    //   47: invokevirtual 63	com/inauth/mme/header/LogHeader:setSDKVersion	(Ljava/lang/String;)V
    //   50: aload 5
    //   52: ldc 65
    //   54: invokevirtual 68	com/inauth/mme/header/LogHeader:setType	(Ljava/lang/String;)V
    //   57: aload_1
    //   58: invokevirtual 74	android/app/Application:getContentResolver	()Landroid/content/ContentResolver;
    //   61: getstatic 80	android/provider/CallLog$Calls:CONTENT_URI	Landroid/net/Uri;
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: ldc 82
    //   69: invokevirtual 88	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore 6
    //   74: aload 6
    //   76: invokeinterface 94 1 0
    //   81: pop
    //   82: aload 6
    //   84: ldc 96
    //   86: invokeinterface 100 2 0
    //   91: istore 8
    //   93: aload 6
    //   95: ldc 102
    //   97: invokeinterface 100 2 0
    //   102: istore 9
    //   104: aload 6
    //   106: ldc 104
    //   108: invokeinterface 100 2 0
    //   113: istore 10
    //   115: aload 6
    //   117: ldc 106
    //   119: invokeinterface 100 2 0
    //   124: istore 11
    //   126: lconst_0
    //   127: lstore 12
    //   129: aload_0
    //   130: lconst_0
    //   131: invokespecial 108	com/inauth/mme/logs/PhoneCallLog:setLastTimeChecked	(J)V
    //   134: iconst_0
    //   135: istore 14
    //   137: aload 6
    //   139: invokeinterface 94 1 0
    //   144: pop
    //   145: aload 6
    //   147: iload 11
    //   149: invokeinterface 112 2 0
    //   154: lstore 31
    //   156: lload 31
    //   158: lstore 12
    //   160: aload 6
    //   162: ifnull +357 -> 519
    //   165: aload 6
    //   167: invokeinterface 116 1 0
    //   172: ifle +340 -> 512
    //   175: aload 6
    //   177: invokeinterface 119 1 0
    //   182: istore 18
    //   184: iload 18
    //   186: ifeq +320 -> 506
    //   189: iconst_0
    //   190: istore 19
    //   192: aload 6
    //   194: invokeinterface 122 1 0
    //   199: ifne +304 -> 503
    //   202: aload 6
    //   204: invokeinterface 125 1 0
    //   209: istore 22
    //   211: iload 22
    //   213: ifne +290 -> 503
    //   216: iload 19
    //   218: iconst_1
    //   219: iadd
    //   220: istore 23
    //   222: iload 19
    //   224: sipush 1000
    //   227: if_icmpgt +279 -> 506
    //   230: iload 14
    //   232: ifne +274 -> 506
    //   235: aload_1
    //   236: invokevirtual 129	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   239: ldc 131
    //   241: invokevirtual 137	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   244: checkcast 139	android/telephony/TelephonyManager
    //   247: invokevirtual 142	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   250: astore 25
    //   252: new 144	com/inauth/mme/beans/PhoneCallBean
    //   255: dup
    //   256: invokespecial 145	com/inauth/mme/beans/PhoneCallBean:<init>	()V
    //   259: astore 26
    //   261: aload 26
    //   263: aload 6
    //   265: iload 10
    //   267: invokeinterface 149 2 0
    //   272: invokevirtual 152	com/inauth/mme/beans/PhoneCallBean:setCall_duration	(Ljava/lang/String;)V
    //   275: new 154	java/text/SimpleDateFormat
    //   278: dup
    //   279: ldc 156
    //   281: getstatic 162	java/util/Locale:US	Ljava/util/Locale;
    //   284: invokespecial 165	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   287: astore 27
    //   289: aload 26
    //   291: aload 27
    //   293: new 167	java/util/Date
    //   296: dup
    //   297: aload 6
    //   299: iload 11
    //   301: invokeinterface 112 2 0
    //   306: invokespecial 169	java/util/Date:<init>	(J)V
    //   309: invokevirtual 175	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   312: invokevirtual 178	com/inauth/mme/beans/PhoneCallBean:setCalled_at	(Ljava/lang/String;)V
    //   315: aload 6
    //   317: iload 11
    //   319: invokeinterface 112 2 0
    //   324: lstore 28
    //   326: aload 6
    //   328: iload 9
    //   330: invokeinterface 182 2 0
    //   335: tableswitch	default:+25 -> 360, 1:+57->392, 2:+131->466, 3:+88->423
    //   361: iload_2
    //   362: aload_0
    //   363: invokespecial 184	com/inauth/mme/logs/PhoneCallLog:getLastTimeChecked	()J
    //   366: lcmp
    //   367: ifle +130 -> 497
    //   370: aload 5
    //   372: aload 26
    //   374: invokevirtual 188	com/inauth/mme/header/LogHeader:addLogs	(Lcom/inauth/mme/beans/Bean;)V
    //   377: aload 6
    //   379: invokeinterface 191 1 0
    //   384: pop
    //   385: iload 23
    //   387: istore 19
    //   389: goto -197 -> 192
    //   392: aload 26
    //   394: ldc 193
    //   396: invokevirtual 196	com/inauth/mme/beans/PhoneCallBean:setPhone_call_type	(Ljava/lang/String;)V
    //   399: aload 26
    //   401: aload 6
    //   403: iload 8
    //   405: invokeinterface 149 2 0
    //   410: invokevirtual 199	com/inauth/mme/beans/PhoneCallBean:setFrom_number	(Ljava/lang/String;)V
    //   413: aload 26
    //   415: aload 25
    //   417: invokevirtual 202	com/inauth/mme/beans/PhoneCallBean:setTo_number	(Ljava/lang/String;)V
    //   420: goto -60 -> 360
    //   423: aload 26
    //   425: ldc 204
    //   427: invokevirtual 196	com/inauth/mme/beans/PhoneCallBean:setPhone_call_type	(Ljava/lang/String;)V
    //   430: aload 26
    //   432: aload 6
    //   434: iload 8
    //   436: invokeinterface 149 2 0
    //   441: invokevirtual 199	com/inauth/mme/beans/PhoneCallBean:setFrom_number	(Ljava/lang/String;)V
    //   444: aload 26
    //   446: aload 25
    //   448: invokevirtual 202	com/inauth/mme/beans/PhoneCallBean:setTo_number	(Ljava/lang/String;)V
    //   451: goto -91 -> 360
    //   454: astore 17
    //   456: aload 6
    //   458: invokeinterface 207 1 0
    //   463: aload 17
    //   465: athrow
    //   466: aload 26
    //   468: ldc 209
    //   470: invokevirtual 196	com/inauth/mme/beans/PhoneCallBean:setPhone_call_type	(Ljava/lang/String;)V
    //   473: aload 26
    //   475: aload 6
    //   477: iload 8
    //   479: invokeinterface 149 2 0
    //   484: invokevirtual 202	com/inauth/mme/beans/PhoneCallBean:setTo_number	(Ljava/lang/String;)V
    //   487: aload 26
    //   489: aload 25
    //   491: invokevirtual 199	com/inauth/mme/beans/PhoneCallBean:setFrom_number	(Ljava/lang/String;)V
    //   494: goto -134 -> 360
    //   497: iconst_1
    //   498: istore 14
    //   500: goto -123 -> 377
    //   503: iload 19
    //   505: pop
    //   506: aload_0
    //   507: lload 12
    //   509: invokespecial 108	com/inauth/mme/logs/PhoneCallLog:setLastTimeChecked	(J)V
    //   512: aload 6
    //   514: invokeinterface 207 1 0
    //   519: new 20	com/google/gson/Gson
    //   522: dup
    //   523: invokespecial 21	com/google/gson/Gson:<init>	()V
    //   526: aload 5
    //   528: invokevirtual 213	com/google/gson/Gson:toJson	(Ljava/lang/Object;)Ljava/lang/String;
    //   531: areturn
    //   532: astore 16
    //   534: goto -374 -> 160
    //   537: astore 17
    //   539: iload 19
    //   541: pop
    //   542: goto -86 -> 456
    //   545: astore 24
    //   547: iload 23
    //   549: istore 19
    //   551: goto -359 -> 192
    //
    // Exception table:
    //   from	to	target	type
    //   165	184	454	finally
    //   235	360	454	finally
    //   360	377	454	finally
    //   377	385	454	finally
    //   392	420	454	finally
    //   423	451	454	finally
    //   466	494	454	finally
    //   506	512	454	finally
    //   145	156	532	java/lang/Exception
    //   192	211	537	finally
    //   235	360	545	java/lang/Exception
    //   360	377	545	java/lang/Exception
    //   377	385	545	java/lang/Exception
    //   392	420	545	java/lang/Exception
    //   423	451	545	java/lang/Exception
    //   466	494	545	java/lang/Exception
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.PhoneCallLog
 * JD-Core Version:    0.6.2
 */