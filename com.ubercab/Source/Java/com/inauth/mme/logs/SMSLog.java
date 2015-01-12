package com.inauth.mme.logs;

import com.google.gson.Gson;
import com.inauth.mme.response.LogResponse;

public class SMSLog
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
    //   57: lconst_0
    //   58: lstore 6
    //   60: aload_0
    //   61: lconst_0
    //   62: invokespecial 70	com/inauth/mme/logs/SMSLog:setLastTimeChecked	(J)V
    //   65: iconst_0
    //   66: istore 8
    //   68: aload_1
    //   69: invokevirtual 76	android/app/Application:getContentResolver	()Landroid/content/ContentResolver;
    //   72: getstatic 82	com/inauth/utilities/InAuthConstants:SMS_CONTENT_URI	Landroid/net/Uri;
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: ldc 84
    //   80: invokevirtual 90	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 9
    //   85: aload 9
    //   87: ifnull +366 -> 453
    //   90: aload 9
    //   92: ldc 92
    //   94: invokeinterface 98 2 0
    //   99: istore 10
    //   101: aload 9
    //   103: invokeinterface 102 1 0
    //   108: ifle +338 -> 446
    //   111: aload 9
    //   113: invokeinterface 106 1 0
    //   118: pop
    //   119: aload 9
    //   121: iload 10
    //   123: invokeinterface 110 2 0
    //   128: lstore 28
    //   130: lload 28
    //   132: lstore 6
    //   134: aload 9
    //   136: invokeinterface 113 1 0
    //   141: istore 14
    //   143: iload 14
    //   145: ifeq +301 -> 446
    //   148: iconst_0
    //   149: istore 15
    //   151: aload 9
    //   153: invokeinterface 116 1 0
    //   158: ifne +344 -> 502
    //   161: aload 9
    //   163: invokeinterface 119 1 0
    //   168: istore 18
    //   170: iload 18
    //   172: ifne +330 -> 502
    //   175: iload 15
    //   177: iconst_1
    //   178: iadd
    //   179: istore 19
    //   181: iload 15
    //   183: sipush 1000
    //   186: if_icmpgt +254 -> 440
    //   189: iload 8
    //   191: ifne +249 -> 440
    //   194: aload_1
    //   195: invokevirtual 123	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   198: ldc 125
    //   200: invokevirtual 131	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   203: checkcast 133	android/telephony/TelephonyManager
    //   206: invokevirtual 136	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   209: astore 22
    //   211: new 138	com/inauth/mme/beans/SMSBean
    //   214: dup
    //   215: invokespecial 139	com/inauth/mme/beans/SMSBean:<init>	()V
    //   218: astore 23
    //   220: aload 23
    //   222: aload 9
    //   224: aload 9
    //   226: ldc 141
    //   228: invokeinterface 98 2 0
    //   233: invokeinterface 145 2 0
    //   238: invokevirtual 148	com/inauth/mme/beans/SMSBean:setService_number	(Ljava/lang/String;)V
    //   241: new 150	java/text/SimpleDateFormat
    //   244: dup
    //   245: ldc 152
    //   247: getstatic 158	java/util/Locale:US	Ljava/util/Locale;
    //   250: invokespecial 161	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   253: astore 24
    //   255: aload 23
    //   257: aload 24
    //   259: new 163	java/util/Date
    //   262: dup
    //   263: aload 9
    //   265: iload 10
    //   267: invokeinterface 110 2 0
    //   272: invokespecial 165	java/util/Date:<init>	(J)V
    //   275: invokevirtual 171	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   278: invokevirtual 174	com/inauth/mme/beans/SMSBean:setSms_at	(Ljava/lang/String;)V
    //   281: aload 9
    //   283: iload 10
    //   285: invokeinterface 110 2 0
    //   290: lstore 25
    //   292: aload 23
    //   294: invokestatic 179	com/inauth/utilities/InAuthUtilities:GetIsoDateTime	()Ljava/lang/String;
    //   297: invokevirtual 182	com/inauth/mme/beans/SMSBean:setChecked_at	(Ljava/lang/String;)V
    //   300: aload 9
    //   302: aload 9
    //   304: ldc 184
    //   306: invokeinterface 98 2 0
    //   311: invokeinterface 145 2 0
    //   316: astore 27
    //   318: aload 27
    //   320: ldc 186
    //   322: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   325: ifeq +38 -> 363
    //   328: aload 23
    //   330: ldc 194
    //   332: invokevirtual 197	com/inauth/mme/beans/SMSBean:setSms_type	(Ljava/lang/String;)V
    //   335: aload 23
    //   337: aload 9
    //   339: aload 9
    //   341: ldc 199
    //   343: invokeinterface 98 2 0
    //   348: invokeinterface 145 2 0
    //   353: invokevirtual 202	com/inauth/mme/beans/SMSBean:setFrom_number	(Ljava/lang/String;)V
    //   356: aload 23
    //   358: aload 22
    //   360: invokevirtual 205	com/inauth/mme/beans/SMSBean:setTo_number	(Ljava/lang/String;)V
    //   363: aload 27
    //   365: ldc 207
    //   367: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   370: ifeq +38 -> 408
    //   373: aload 23
    //   375: ldc 209
    //   377: invokevirtual 197	com/inauth/mme/beans/SMSBean:setSms_type	(Ljava/lang/String;)V
    //   380: aload 23
    //   382: aload 9
    //   384: aload 9
    //   386: ldc 199
    //   388: invokeinterface 98 2 0
    //   393: invokeinterface 145 2 0
    //   398: invokevirtual 205	com/inauth/mme/beans/SMSBean:setTo_number	(Ljava/lang/String;)V
    //   401: aload 23
    //   403: aload 22
    //   405: invokevirtual 202	com/inauth/mme/beans/SMSBean:setFrom_number	(Ljava/lang/String;)V
    //   408: lload 25
    //   410: aload_0
    //   411: invokespecial 211	com/inauth/mme/logs/SMSLog:getLastTimeChecked	()J
    //   414: lcmp
    //   415: ifle +81 -> 496
    //   418: aload 5
    //   420: aload 23
    //   422: invokevirtual 215	com/inauth/mme/header/LogHeader:addLogs	(Lcom/inauth/mme/beans/Bean;)V
    //   425: aload 9
    //   427: invokeinterface 218 1 0
    //   432: pop
    //   433: iload 19
    //   435: istore 15
    //   437: goto -286 -> 151
    //   440: aload_0
    //   441: lload 6
    //   443: invokespecial 70	com/inauth/mme/logs/SMSLog:setLastTimeChecked	(J)V
    //   446: aload 9
    //   448: invokeinterface 221 1 0
    //   453: new 20	com/google/gson/Gson
    //   456: dup
    //   457: invokespecial 21	com/google/gson/Gson:<init>	()V
    //   460: aload 5
    //   462: invokevirtual 225	com/google/gson/Gson:toJson	(Ljava/lang/Object;)Ljava/lang/String;
    //   465: areturn
    //   466: astore 11
    //   468: aload 9
    //   470: invokeinterface 221 1 0
    //   475: aload 11
    //   477: athrow
    //   478: astore 13
    //   480: goto -346 -> 134
    //   483: astore 11
    //   485: iload 15
    //   487: pop
    //   488: goto -20 -> 468
    //   491: astore 20
    //   493: goto -68 -> 425
    //   496: iconst_1
    //   497: istore 8
    //   499: goto -74 -> 425
    //   502: iload 15
    //   504: pop
    //   505: goto -65 -> 440
    //
    // Exception table:
    //   from	to	target	type
    //   101	119	466	finally
    //   119	130	466	finally
    //   134	143	466	finally
    //   194	363	466	finally
    //   363	408	466	finally
    //   408	425	466	finally
    //   425	433	466	finally
    //   440	446	466	finally
    //   119	130	478	java/lang/Exception
    //   151	170	483	finally
    //   194	363	491	java/lang/Exception
    //   363	408	491	java/lang/Exception
    //   408	425	491	java/lang/Exception
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.SMSLog
 * JD-Core Version:    0.6.2
 */