package com.inauth.mme.logs;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.gson.Gson;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthConstants;

public class MMSLog
{
  private static final String incoming = "type=137";
  private static final String outgoing = "type=151";
  private long lastTimeChecked;

  private long getLastTimeChecked()
  {
    return this.lastTimeChecked;
  }

  private String getMMSAddress(Application paramApplication, long paramLong)
  {
    Object localObject1 = "";
    String[] arrayOfString = { "address", "contact_id", "charset", "type" };
    Uri.Builder localBuilder = InAuthConstants.MMS_CONTENT_URI.buildUpon();
    localBuilder.appendPath(String.valueOf(paramLong)).appendPath("addr");
    Cursor localCursor = paramApplication.getContentResolver().query(localBuilder.build(), arrayOfString, "type='137' OR type='151'", null, null);
    if (localCursor != null);
    try
    {
      if (localCursor.moveToFirst())
      {
        String str = localCursor.getString(0);
        localObject1 = str;
      }
      return localObject1;
    }
    finally
    {
      localCursor.close();
    }
  }

  private String getMMSType(Application paramApplication, long paramLong, String paramString)
  {
    Object localObject1 = "";
    String[] arrayOfString = { "address", "contact_id", "charset", "type" };
    Uri.Builder localBuilder = InAuthConstants.MMS_CONTENT_URI.buildUpon();
    localBuilder.appendPath(String.valueOf(paramLong)).appendPath("addr");
    Cursor localCursor = paramApplication.getContentResolver().query(localBuilder.build(), arrayOfString, paramString, null, null);
    if (localCursor != null);
    try
    {
      if (localCursor.moveToFirst())
      {
        String str = localCursor.getString(3);
        localObject1 = str;
      }
      return localObject1;
    }
    finally
    {
      localCursor.close();
    }
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
  public String serializeIncoming(Application paramApplication, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 111	com/inauth/mme/header/LogHeader
    //   3: dup
    //   4: invokespecial 112	com/inauth/mme/header/LogHeader:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_3
    //   12: invokevirtual 116	com/inauth/mme/header/LogHeader:setAccountGUID	(Ljava/lang/String;)V
    //   15: aload 5
    //   17: aload_2
    //   18: invokevirtual 119	com/inauth/mme/header/LogHeader:setDeviceGUID	(Ljava/lang/String;)V
    //   21: aload 5
    //   23: invokestatic 125	com/inauth/mme/InAuthManager:getInstance	()Lcom/inauth/mme/InAuthManager;
    //   26: invokevirtual 129	com/inauth/mme/InAuthManager:getInAuthDynamicID	()Ljava/lang/String;
    //   29: invokevirtual 132	com/inauth/mme/header/LogHeader:setDynamicID	(Ljava/lang/String;)V
    //   32: aload 5
    //   34: aload 4
    //   36: invokevirtual 135	com/inauth/mme/header/LogHeader:setTransaction_id	(Ljava/lang/String;)V
    //   39: aload 5
    //   41: invokestatic 125	com/inauth/mme/InAuthManager:getInstance	()Lcom/inauth/mme/InAuthManager;
    //   44: invokevirtual 138	com/inauth/mme/InAuthManager:getSDKVersion	()Ljava/lang/String;
    //   47: invokevirtual 141	com/inauth/mme/header/LogHeader:setSDKVersion	(Ljava/lang/String;)V
    //   50: aload 5
    //   52: ldc 143
    //   54: invokevirtual 146	com/inauth/mme/header/LogHeader:setType	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: lconst_0
    //   59: invokespecial 148	com/inauth/mme/logs/MMSLog:setLastTimeChecked	(J)V
    //   62: iconst_0
    //   63: istore 6
    //   65: aload_1
    //   66: invokevirtual 65	android/app/Application:getContentResolver	()Landroid/content/ContentResolver;
    //   69: getstatic 41	com/inauth/utilities/InAuthConstants:MMS_CONTENT_URI	Landroid/net/Uri;
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: ldc 150
    //   77: invokevirtual 77	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore 7
    //   82: aload 7
    //   84: ifnull +451 -> 535
    //   87: aload 7
    //   89: ldc 152
    //   91: invokeinterface 156 2 0
    //   96: istore 8
    //   98: aload 7
    //   100: invokeinterface 160 1 0
    //   105: ifle +423 -> 528
    //   108: aload 7
    //   110: invokeinterface 83 1 0
    //   115: pop
    //   116: aload 7
    //   118: invokeinterface 163 1 0
    //   123: istore 11
    //   125: iload 11
    //   127: ifeq +401 -> 528
    //   130: iconst_0
    //   131: istore 12
    //   133: aload 7
    //   135: invokeinterface 166 1 0
    //   140: ifne +385 -> 525
    //   143: aload 7
    //   145: invokeinterface 169 1 0
    //   150: istore 15
    //   152: iload 15
    //   154: ifne +371 -> 525
    //   157: iload 12
    //   159: iconst_1
    //   160: iadd
    //   161: istore 16
    //   163: iload 12
    //   165: sipush 1000
    //   168: if_icmpgt +360 -> 528
    //   171: iload 6
    //   173: ifne +355 -> 528
    //   176: aload_1
    //   177: invokevirtual 173	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   180: ldc 175
    //   182: invokevirtual 181	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   185: checkcast 183	android/telephony/TelephonyManager
    //   188: invokevirtual 186	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   191: astore 19
    //   193: new 188	com/inauth/mme/beans/MMSBean
    //   196: dup
    //   197: invokespecial 189	com/inauth/mme/beans/MMSBean:<init>	()V
    //   200: astore 20
    //   202: aload 20
    //   204: aload 7
    //   206: iconst_5
    //   207: invokeinterface 87 2 0
    //   212: invokevirtual 192	com/inauth/mme/beans/MMSBean:setService_number	(Ljava/lang/String;)V
    //   215: new 194	java/text/SimpleDateFormat
    //   218: dup
    //   219: ldc 196
    //   221: getstatic 202	java/util/Locale:US	Ljava/util/Locale;
    //   224: invokespecial 205	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   227: astore 22
    //   229: aload 20
    //   231: aload 22
    //   233: new 207	java/util/Date
    //   236: dup
    //   237: ldc2_w 208
    //   240: aload 7
    //   242: iload 8
    //   244: invokeinterface 213 2 0
    //   249: lmul
    //   250: invokespecial 215	java/util/Date:<init>	(J)V
    //   253: invokevirtual 221	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   256: invokevirtual 224	com/inauth/mme/beans/MMSBean:setMms_at	(Ljava/lang/String;)V
    //   259: aload 7
    //   261: iload 8
    //   263: invokeinterface 213 2 0
    //   268: lstore 23
    //   270: aload 20
    //   272: invokestatic 229	com/inauth/utilities/InAuthUtilities:GetIsoDateTime	()Ljava/lang/String;
    //   275: invokevirtual 232	com/inauth/mme/beans/MMSBean:setChecked_at	(Ljava/lang/String;)V
    //   278: ldc 25
    //   280: astore 25
    //   282: aload_0
    //   283: aload_1
    //   284: aload 7
    //   286: iconst_0
    //   287: invokeinterface 213 2 0
    //   292: ldc 8
    //   294: invokespecial 234	com/inauth/mme/logs/MMSLog:getMMSType	(Landroid/app/Application;JLjava/lang/String;)Ljava/lang/String;
    //   297: astore 27
    //   299: aload 27
    //   301: astore 25
    //   303: aload 25
    //   305: ldc 236
    //   307: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   310: ifeq +67 -> 377
    //   313: aload 20
    //   315: ldc 241
    //   317: invokevirtual 244	com/inauth/mme/beans/MMSBean:setMms_type	(Ljava/lang/String;)V
    //   320: aload 20
    //   322: aload_0
    //   323: aload_1
    //   324: aload 7
    //   326: iconst_0
    //   327: invokeinterface 213 2 0
    //   332: invokespecial 246	com/inauth/mme/logs/MMSLog:getMMSAddress	(Landroid/app/Application;J)Ljava/lang/String;
    //   335: invokevirtual 249	com/inauth/mme/beans/MMSBean:setFrom_number	(Ljava/lang/String;)V
    //   338: aload 20
    //   340: aload 19
    //   342: invokevirtual 252	com/inauth/mme/beans/MMSBean:setTo_number	(Ljava/lang/String;)V
    //   345: lload 23
    //   347: aload_0
    //   348: invokespecial 254	com/inauth/mme/logs/MMSLog:getLastTimeChecked	()J
    //   351: lcmp
    //   352: ifle +167 -> 519
    //   355: aload 5
    //   357: aload 20
    //   359: invokevirtual 258	com/inauth/mme/header/LogHeader:addLogs	(Lcom/inauth/mme/beans/Bean;)V
    //   362: aload 7
    //   364: invokeinterface 261 1 0
    //   369: pop
    //   370: iload 16
    //   372: istore 12
    //   374: goto -241 -> 133
    //   377: aload 25
    //   379: ldc_w 263
    //   382: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   385: ifeq +39 -> 424
    //   388: aload 20
    //   390: ldc_w 264
    //   393: invokevirtual 244	com/inauth/mme/beans/MMSBean:setMms_type	(Ljava/lang/String;)V
    //   396: aload 20
    //   398: aload_0
    //   399: aload_1
    //   400: aload 7
    //   402: iconst_0
    //   403: invokeinterface 213 2 0
    //   408: invokespecial 246	com/inauth/mme/logs/MMSLog:getMMSAddress	(Landroid/app/Application;J)Ljava/lang/String;
    //   411: invokevirtual 252	com/inauth/mme/beans/MMSBean:setTo_number	(Ljava/lang/String;)V
    //   414: aload 20
    //   416: aload 19
    //   418: invokevirtual 249	com/inauth/mme/beans/MMSBean:setFrom_number	(Ljava/lang/String;)V
    //   421: goto -76 -> 345
    //   424: aload 25
    //   426: ldc_w 266
    //   429: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   432: ifeq +51 -> 483
    //   435: aload 20
    //   437: ldc_w 268
    //   440: invokevirtual 244	com/inauth/mme/beans/MMSBean:setMms_type	(Ljava/lang/String;)V
    //   443: aload 20
    //   445: aload_0
    //   446: aload_1
    //   447: aload 7
    //   449: iconst_0
    //   450: invokeinterface 213 2 0
    //   455: invokespecial 246	com/inauth/mme/logs/MMSLog:getMMSAddress	(Landroid/app/Application;J)Ljava/lang/String;
    //   458: invokevirtual 249	com/inauth/mme/beans/MMSBean:setFrom_number	(Ljava/lang/String;)V
    //   461: aload 20
    //   463: aload 19
    //   465: invokevirtual 252	com/inauth/mme/beans/MMSBean:setTo_number	(Ljava/lang/String;)V
    //   468: goto -123 -> 345
    //   471: astore 9
    //   473: aload 7
    //   475: invokeinterface 90 1 0
    //   480: aload 9
    //   482: athrow
    //   483: aload 20
    //   485: ldc_w 268
    //   488: invokevirtual 244	com/inauth/mme/beans/MMSBean:setMms_type	(Ljava/lang/String;)V
    //   491: aload 20
    //   493: aload_0
    //   494: aload_1
    //   495: aload 7
    //   497: iconst_0
    //   498: invokeinterface 213 2 0
    //   503: invokespecial 246	com/inauth/mme/logs/MMSLog:getMMSAddress	(Landroid/app/Application;J)Ljava/lang/String;
    //   506: invokevirtual 249	com/inauth/mme/beans/MMSBean:setFrom_number	(Ljava/lang/String;)V
    //   509: aload 20
    //   511: aload 19
    //   513: invokevirtual 252	com/inauth/mme/beans/MMSBean:setTo_number	(Ljava/lang/String;)V
    //   516: goto -171 -> 345
    //   519: iconst_1
    //   520: istore 6
    //   522: goto -160 -> 362
    //   525: iload 12
    //   527: pop
    //   528: aload 7
    //   530: invokeinterface 90 1 0
    //   535: new 98	com/google/gson/Gson
    //   538: dup
    //   539: invokespecial 99	com/google/gson/Gson:<init>	()V
    //   542: aload 5
    //   544: invokevirtual 272	com/google/gson/Gson:toJson	(Ljava/lang/Object;)Ljava/lang/String;
    //   547: areturn
    //   548: astore 9
    //   550: iload 12
    //   552: pop
    //   553: goto -80 -> 473
    //   556: astore 26
    //   558: goto -255 -> 303
    //   561: astore 21
    //   563: goto -348 -> 215
    //   566: astore 17
    //   568: goto -206 -> 362
    //
    // Exception table:
    //   from	to	target	type
    //   98	125	471	finally
    //   176	202	471	finally
    //   202	215	471	finally
    //   215	278	471	finally
    //   282	299	471	finally
    //   303	345	471	finally
    //   345	362	471	finally
    //   362	370	471	finally
    //   377	421	471	finally
    //   424	468	471	finally
    //   483	516	471	finally
    //   133	152	548	finally
    //   282	299	556	java/lang/Exception
    //   202	215	561	java/lang/Exception
    //   176	202	566	java/lang/Exception
    //   215	278	566	java/lang/Exception
    //   303	345	566	java/lang/Exception
    //   345	362	566	java/lang/Exception
    //   377	421	566	java/lang/Exception
    //   424	468	566	java/lang/Exception
    //   483	516	566	java/lang/Exception
  }

  // ERROR //
  public String serializeOutgoing(Application paramApplication, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 111	com/inauth/mme/header/LogHeader
    //   3: dup
    //   4: invokespecial 112	com/inauth/mme/header/LogHeader:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_3
    //   12: invokevirtual 116	com/inauth/mme/header/LogHeader:setAccountGUID	(Ljava/lang/String;)V
    //   15: aload 5
    //   17: aload_2
    //   18: invokevirtual 119	com/inauth/mme/header/LogHeader:setDeviceGUID	(Ljava/lang/String;)V
    //   21: aload 5
    //   23: invokestatic 125	com/inauth/mme/InAuthManager:getInstance	()Lcom/inauth/mme/InAuthManager;
    //   26: invokevirtual 129	com/inauth/mme/InAuthManager:getInAuthDynamicID	()Ljava/lang/String;
    //   29: invokevirtual 132	com/inauth/mme/header/LogHeader:setDynamicID	(Ljava/lang/String;)V
    //   32: aload 5
    //   34: aload 4
    //   36: invokevirtual 135	com/inauth/mme/header/LogHeader:setTransaction_id	(Ljava/lang/String;)V
    //   39: aload 5
    //   41: invokestatic 125	com/inauth/mme/InAuthManager:getInstance	()Lcom/inauth/mme/InAuthManager;
    //   44: invokevirtual 138	com/inauth/mme/InAuthManager:getSDKVersion	()Ljava/lang/String;
    //   47: invokevirtual 141	com/inauth/mme/header/LogHeader:setSDKVersion	(Ljava/lang/String;)V
    //   50: aload 5
    //   52: ldc 143
    //   54: invokevirtual 146	com/inauth/mme/header/LogHeader:setType	(Ljava/lang/String;)V
    //   57: lconst_0
    //   58: lstore 6
    //   60: iconst_0
    //   61: istore 8
    //   63: aload_1
    //   64: invokevirtual 65	android/app/Application:getContentResolver	()Landroid/content/ContentResolver;
    //   67: getstatic 41	com/inauth/utilities/InAuthConstants:MMS_CONTENT_URI	Landroid/net/Uri;
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: ldc 150
    //   75: invokevirtual 77	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore 9
    //   80: aload 9
    //   82: ifnull +472 -> 554
    //   85: aload 9
    //   87: ldc 152
    //   89: invokeinterface 156 2 0
    //   94: istore 10
    //   96: aload 9
    //   98: invokeinterface 160 1 0
    //   103: ifle +444 -> 547
    //   106: aload 9
    //   108: invokeinterface 83 1 0
    //   113: pop
    //   114: aload 9
    //   116: iload 10
    //   118: invokeinterface 213 2 0
    //   123: lstore 31
    //   125: lload 31
    //   127: lstore 6
    //   129: aload 9
    //   131: invokeinterface 163 1 0
    //   136: istore 14
    //   138: iload 14
    //   140: ifeq +407 -> 547
    //   143: iconst_0
    //   144: istore 15
    //   146: aload 9
    //   148: invokeinterface 166 1 0
    //   153: ifne +385 -> 538
    //   156: aload 9
    //   158: invokeinterface 169 1 0
    //   163: istore 18
    //   165: iload 18
    //   167: ifne +371 -> 538
    //   170: iload 15
    //   172: iconst_1
    //   173: iadd
    //   174: istore 19
    //   176: iload 15
    //   178: sipush 1000
    //   181: if_icmpgt +360 -> 541
    //   184: iload 8
    //   186: ifne +355 -> 541
    //   189: aload_1
    //   190: invokevirtual 173	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   193: ldc 175
    //   195: invokevirtual 181	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   198: checkcast 183	android/telephony/TelephonyManager
    //   201: invokevirtual 186	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   204: astore 22
    //   206: new 188	com/inauth/mme/beans/MMSBean
    //   209: dup
    //   210: invokespecial 189	com/inauth/mme/beans/MMSBean:<init>	()V
    //   213: astore 23
    //   215: aload 23
    //   217: aload 9
    //   219: iconst_5
    //   220: invokeinterface 87 2 0
    //   225: invokevirtual 192	com/inauth/mme/beans/MMSBean:setService_number	(Ljava/lang/String;)V
    //   228: new 194	java/text/SimpleDateFormat
    //   231: dup
    //   232: ldc 196
    //   234: getstatic 202	java/util/Locale:US	Ljava/util/Locale;
    //   237: invokespecial 205	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   240: astore 25
    //   242: aload 23
    //   244: aload 25
    //   246: new 207	java/util/Date
    //   249: dup
    //   250: ldc2_w 208
    //   253: aload 9
    //   255: iload 10
    //   257: invokeinterface 213 2 0
    //   262: lmul
    //   263: invokespecial 215	java/util/Date:<init>	(J)V
    //   266: invokevirtual 221	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   269: invokevirtual 224	com/inauth/mme/beans/MMSBean:setMms_at	(Ljava/lang/String;)V
    //   272: aload 9
    //   274: iload 10
    //   276: invokeinterface 213 2 0
    //   281: lstore 26
    //   283: aload 23
    //   285: invokestatic 229	com/inauth/utilities/InAuthUtilities:GetIsoDateTime	()Ljava/lang/String;
    //   288: invokevirtual 232	com/inauth/mme/beans/MMSBean:setChecked_at	(Ljava/lang/String;)V
    //   291: ldc 25
    //   293: astore 28
    //   295: aload_0
    //   296: aload_1
    //   297: aload 9
    //   299: iconst_0
    //   300: invokeinterface 213 2 0
    //   305: ldc 11
    //   307: invokespecial 234	com/inauth/mme/logs/MMSLog:getMMSType	(Landroid/app/Application;JLjava/lang/String;)Ljava/lang/String;
    //   310: astore 30
    //   312: aload 30
    //   314: astore 28
    //   316: aload 28
    //   318: ldc 236
    //   320: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   323: ifeq +67 -> 390
    //   326: aload 23
    //   328: ldc 241
    //   330: invokevirtual 244	com/inauth/mme/beans/MMSBean:setMms_type	(Ljava/lang/String;)V
    //   333: aload 23
    //   335: aload_0
    //   336: aload_1
    //   337: aload 9
    //   339: iconst_0
    //   340: invokeinterface 213 2 0
    //   345: invokespecial 246	com/inauth/mme/logs/MMSLog:getMMSAddress	(Landroid/app/Application;J)Ljava/lang/String;
    //   348: invokevirtual 249	com/inauth/mme/beans/MMSBean:setFrom_number	(Ljava/lang/String;)V
    //   351: aload 23
    //   353: aload 22
    //   355: invokevirtual 252	com/inauth/mme/beans/MMSBean:setTo_number	(Ljava/lang/String;)V
    //   358: lload 26
    //   360: aload_0
    //   361: invokespecial 254	com/inauth/mme/logs/MMSLog:getLastTimeChecked	()J
    //   364: lcmp
    //   365: ifle +167 -> 532
    //   368: aload 5
    //   370: aload 23
    //   372: invokevirtual 258	com/inauth/mme/header/LogHeader:addLogs	(Lcom/inauth/mme/beans/Bean;)V
    //   375: aload 9
    //   377: invokeinterface 261 1 0
    //   382: pop
    //   383: iload 19
    //   385: istore 15
    //   387: goto -241 -> 146
    //   390: aload 28
    //   392: ldc_w 263
    //   395: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   398: ifeq +39 -> 437
    //   401: aload 23
    //   403: ldc_w 264
    //   406: invokevirtual 244	com/inauth/mme/beans/MMSBean:setMms_type	(Ljava/lang/String;)V
    //   409: aload 23
    //   411: aload_0
    //   412: aload_1
    //   413: aload 9
    //   415: iconst_0
    //   416: invokeinterface 213 2 0
    //   421: invokespecial 246	com/inauth/mme/logs/MMSLog:getMMSAddress	(Landroid/app/Application;J)Ljava/lang/String;
    //   424: invokevirtual 252	com/inauth/mme/beans/MMSBean:setTo_number	(Ljava/lang/String;)V
    //   427: aload 23
    //   429: aload 22
    //   431: invokevirtual 249	com/inauth/mme/beans/MMSBean:setFrom_number	(Ljava/lang/String;)V
    //   434: goto -76 -> 358
    //   437: aload 28
    //   439: ldc_w 266
    //   442: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   445: ifeq +51 -> 496
    //   448: aload 23
    //   450: ldc_w 268
    //   453: invokevirtual 244	com/inauth/mme/beans/MMSBean:setMms_type	(Ljava/lang/String;)V
    //   456: aload 23
    //   458: aload_0
    //   459: aload_1
    //   460: aload 9
    //   462: iconst_0
    //   463: invokeinterface 213 2 0
    //   468: invokespecial 246	com/inauth/mme/logs/MMSLog:getMMSAddress	(Landroid/app/Application;J)Ljava/lang/String;
    //   471: invokevirtual 249	com/inauth/mme/beans/MMSBean:setFrom_number	(Ljava/lang/String;)V
    //   474: aload 23
    //   476: aload 22
    //   478: invokevirtual 252	com/inauth/mme/beans/MMSBean:setTo_number	(Ljava/lang/String;)V
    //   481: goto -123 -> 358
    //   484: astore 11
    //   486: aload 9
    //   488: invokeinterface 90 1 0
    //   493: aload 11
    //   495: athrow
    //   496: aload 23
    //   498: ldc_w 268
    //   501: invokevirtual 244	com/inauth/mme/beans/MMSBean:setMms_type	(Ljava/lang/String;)V
    //   504: aload 23
    //   506: aload_0
    //   507: aload_1
    //   508: aload 9
    //   510: iconst_0
    //   511: invokeinterface 213 2 0
    //   516: invokespecial 246	com/inauth/mme/logs/MMSLog:getMMSAddress	(Landroid/app/Application;J)Ljava/lang/String;
    //   519: invokevirtual 249	com/inauth/mme/beans/MMSBean:setFrom_number	(Ljava/lang/String;)V
    //   522: aload 23
    //   524: aload 22
    //   526: invokevirtual 252	com/inauth/mme/beans/MMSBean:setTo_number	(Ljava/lang/String;)V
    //   529: goto -171 -> 358
    //   532: iconst_1
    //   533: istore 8
    //   535: goto -160 -> 375
    //   538: iload 15
    //   540: pop
    //   541: aload_0
    //   542: lload 6
    //   544: invokespecial 148	com/inauth/mme/logs/MMSLog:setLastTimeChecked	(J)V
    //   547: aload 9
    //   549: invokeinterface 90 1 0
    //   554: new 98	com/google/gson/Gson
    //   557: dup
    //   558: invokespecial 99	com/google/gson/Gson:<init>	()V
    //   561: aload 5
    //   563: invokevirtual 272	com/google/gson/Gson:toJson	(Ljava/lang/Object;)Ljava/lang/String;
    //   566: areturn
    //   567: astore 13
    //   569: goto -440 -> 129
    //   572: astore 11
    //   574: iload 15
    //   576: pop
    //   577: goto -91 -> 486
    //   580: astore 29
    //   582: goto -266 -> 316
    //   585: astore 24
    //   587: goto -359 -> 228
    //   590: astore 20
    //   592: goto -217 -> 375
    //
    // Exception table:
    //   from	to	target	type
    //   96	114	484	finally
    //   114	125	484	finally
    //   129	138	484	finally
    //   189	215	484	finally
    //   215	228	484	finally
    //   228	291	484	finally
    //   295	312	484	finally
    //   316	358	484	finally
    //   358	375	484	finally
    //   375	383	484	finally
    //   390	434	484	finally
    //   437	481	484	finally
    //   496	529	484	finally
    //   541	547	484	finally
    //   114	125	567	java/lang/Exception
    //   146	165	572	finally
    //   295	312	580	java/lang/Exception
    //   215	228	585	java/lang/Exception
    //   189	215	590	java/lang/Exception
    //   228	291	590	java/lang/Exception
    //   316	358	590	java/lang/Exception
    //   358	375	590	java/lang/Exception
    //   390	434	590	java/lang/Exception
    //   437	481	590	java/lang/Exception
    //   496	529	590	java/lang/Exception
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.MMSLog
 * JD-Core Version:    0.6.2
 */