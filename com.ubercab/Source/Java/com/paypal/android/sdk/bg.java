package com.paypal.android.sdk;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.conn.ssl.SSLSocketFactory;

public final class bg extends bh
{
  private String a;
  private List b;
  private List c;
  private Handler d;
  private boolean e;
  private SSLSocketFactory f;

  public bg(String paramString, List paramList, Handler paramHandler, boolean paramBoolean, SSLSocketFactory paramSSLSocketFactory)
  {
    this.a = paramString;
    this.b = paramList;
    this.c = new ArrayList();
    this.d = paramHandler;
    this.e = paramBoolean;
    this.f = paramSSLSocketFactory;
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/paypal/android/sdk/bg:d	Landroid/os/Handler;
    //   4: aload_0
    //   5: getfield 31	com/paypal/android/sdk/bg:d	Landroid/os/Handler;
    //   8: iconst_0
    //   9: aload_0
    //   10: getfield 22	com/paypal/android/sdk/bg:a	Ljava/lang/String;
    //   13: invokestatic 46	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   16: invokevirtual 52	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   19: pop
    //   20: aconst_null
    //   21: astore_2
    //   22: aload_0
    //   23: getfield 33	com/paypal/android/sdk/bg:e	Z
    //   26: istore 8
    //   28: aconst_null
    //   29: astore_2
    //   30: iload 8
    //   32: ifne +24 -> 56
    //   35: aload_0
    //   36: getfield 29	com/paypal/android/sdk/bg:c	Ljava/util/List;
    //   39: new 54	org/apache/http/message/BasicNameValuePair
    //   42: dup
    //   43: ldc 56
    //   45: ldc 58
    //   47: invokespecial 61	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: invokeinterface 67 2 0
    //   55: pop
    //   56: aload_0
    //   57: getfield 29	com/paypal/android/sdk/bg:c	Ljava/util/List;
    //   60: new 54	org/apache/http/message/BasicNameValuePair
    //   63: dup
    //   64: ldc 69
    //   66: ldc 71
    //   68: invokespecial 61	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: invokeinterface 67 2 0
    //   76: pop
    //   77: aload_0
    //   78: getfield 29	com/paypal/android/sdk/bg:c	Ljava/util/List;
    //   81: new 54	org/apache/http/message/BasicNameValuePair
    //   84: dup
    //   85: ldc 73
    //   87: ldc 71
    //   89: invokespecial 61	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: invokeinterface 67 2 0
    //   97: pop
    //   98: aload_0
    //   99: getfield 29	com/paypal/android/sdk/bg:c	Ljava/util/List;
    //   102: new 54	org/apache/http/message/BasicNameValuePair
    //   105: dup
    //   106: ldc 75
    //   108: ldc 77
    //   110: invokespecial 61	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: invokeinterface 67 2 0
    //   118: pop
    //   119: aload_0
    //   120: getfield 33	com/paypal/android/sdk/bg:e	Z
    //   123: istore 13
    //   125: aconst_null
    //   126: astore_2
    //   127: iload 13
    //   129: ifeq +144 -> 273
    //   132: new 79	org/apache/http/impl/client/DefaultHttpClient
    //   135: dup
    //   136: invokespecial 80	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   139: astore 14
    //   141: aload 14
    //   143: invokeinterface 86 1 0
    //   148: sipush 10000
    //   151: invokestatic 92	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   154: aload 14
    //   156: invokeinterface 86 1 0
    //   161: sipush 10000
    //   164: invokestatic 95	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   167: new 97	org/apache/http/client/methods/HttpPost
    //   170: dup
    //   171: aload_0
    //   172: getfield 22	com/paypal/android/sdk/bg:a	Ljava/lang/String;
    //   175: invokespecial 100	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   178: astore 15
    //   180: aload_0
    //   181: getfield 29	com/paypal/android/sdk/bg:c	Ljava/util/List;
    //   184: invokeinterface 104 1 0
    //   189: astore 16
    //   191: aload 16
    //   193: invokeinterface 110 1 0
    //   198: istore 17
    //   200: aconst_null
    //   201: astore_2
    //   202: iload 17
    //   204: ifeq +283 -> 487
    //   207: aload 16
    //   209: invokeinterface 114 1 0
    //   214: checkcast 116	org/apache/http/NameValuePair
    //   217: astore 18
    //   219: aload 15
    //   221: aload 18
    //   223: invokeinterface 120 1 0
    //   228: aload 18
    //   230: invokeinterface 123 1 0
    //   235: invokevirtual 126	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: goto -47 -> 191
    //   241: astore 6
    //   243: aload_0
    //   244: getfield 31	com/paypal/android/sdk/bg:d	Landroid/os/Handler;
    //   247: aload_0
    //   248: getfield 31	com/paypal/android/sdk/bg:d	Landroid/os/Handler;
    //   251: iconst_1
    //   252: aload 6
    //   254: invokestatic 46	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   257: invokevirtual 52	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   260: pop
    //   261: aload_2
    //   262: invokestatic 131	com/paypal/android/sdk/R:a	(Ljava/io/Reader;)V
    //   265: invokestatic 136	com/paypal/android/sdk/bi:a	()Lcom/paypal/android/sdk/bi;
    //   268: aload_0
    //   269: invokevirtual 139	com/paypal/android/sdk/bi:b	(Lcom/paypal/android/sdk/bh;)V
    //   272: return
    //   273: new 141	org/apache/http/conn/scheme/SchemeRegistry
    //   276: dup
    //   277: invokespecial 142	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   280: astore 24
    //   282: aload 24
    //   284: new 144	org/apache/http/conn/scheme/Scheme
    //   287: dup
    //   288: ldc 146
    //   290: invokestatic 152	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   293: bipush 80
    //   295: invokespecial 155	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   298: invokevirtual 159	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   301: pop
    //   302: aload_0
    //   303: getfield 35	com/paypal/android/sdk/bg:f	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   306: astore 26
    //   308: aconst_null
    //   309: astore_2
    //   310: aload 26
    //   312: ifnonnull +118 -> 430
    //   315: aload 24
    //   317: new 144	org/apache/http/conn/scheme/Scheme
    //   320: dup
    //   321: ldc 161
    //   323: new 163	com/paypal/android/sdk/bd
    //   326: dup
    //   327: invokespecial 164	com/paypal/android/sdk/bd:<init>	()V
    //   330: sipush 443
    //   333: invokespecial 155	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   336: invokevirtual 159	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   339: pop
    //   340: new 166	org/apache/http/params/BasicHttpParams
    //   343: dup
    //   344: invokespecial 167	org/apache/http/params/BasicHttpParams:<init>	()V
    //   347: astore 28
    //   349: aload 28
    //   351: ldc 169
    //   353: bipush 30
    //   355: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   358: invokeinterface 181 3 0
    //   363: pop
    //   364: aload 28
    //   366: ldc 183
    //   368: new 185	org/apache/http/conn/params/ConnPerRouteBean
    //   371: dup
    //   372: bipush 30
    //   374: invokespecial 188	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   377: invokeinterface 181 3 0
    //   382: pop
    //   383: aload 28
    //   385: ldc 190
    //   387: iconst_0
    //   388: invokestatic 195	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   391: invokeinterface 181 3 0
    //   396: pop
    //   397: aload 28
    //   399: getstatic 201	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   402: invokestatic 207	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   405: new 79	org/apache/http/impl/client/DefaultHttpClient
    //   408: dup
    //   409: new 209	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   412: dup
    //   413: aload 28
    //   415: aload 24
    //   417: invokespecial 212	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   420: aload 28
    //   422: invokespecial 215	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   425: astore 14
    //   427: goto -286 -> 141
    //   430: aload 24
    //   432: new 144	org/apache/http/conn/scheme/Scheme
    //   435: dup
    //   436: ldc 161
    //   438: aload_0
    //   439: getfield 35	com/paypal/android/sdk/bg:f	Lorg/apache/http/conn/ssl/SSLSocketFactory;
    //   442: sipush 443
    //   445: invokespecial 155	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   448: invokevirtual 159	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   451: pop
    //   452: goto -112 -> 340
    //   455: astore 4
    //   457: aload_0
    //   458: getfield 31	com/paypal/android/sdk/bg:d	Landroid/os/Handler;
    //   461: aload_0
    //   462: getfield 31	com/paypal/android/sdk/bg:d	Landroid/os/Handler;
    //   465: iconst_1
    //   466: aload 4
    //   468: invokestatic 46	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   471: invokevirtual 52	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   474: pop
    //   475: aload_2
    //   476: invokestatic 131	com/paypal/android/sdk/R:a	(Ljava/io/Reader;)V
    //   479: invokestatic 136	com/paypal/android/sdk/bi:a	()Lcom/paypal/android/sdk/bi;
    //   482: aload_0
    //   483: invokevirtual 139	com/paypal/android/sdk/bi:b	(Lcom/paypal/android/sdk/bh;)V
    //   486: return
    //   487: aload 15
    //   489: new 217	org/apache/http/client/entity/UrlEncodedFormEntity
    //   492: dup
    //   493: aload_0
    //   494: getfield 24	com/paypal/android/sdk/bg:b	Ljava/util/List;
    //   497: ldc 219
    //   499: invokespecial 222	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   502: invokevirtual 226	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   505: new 228	java/io/BufferedReader
    //   508: dup
    //   509: new 230	java/io/InputStreamReader
    //   512: dup
    //   513: aload 14
    //   515: aload 15
    //   517: invokeinterface 234 2 0
    //   522: invokeinterface 240 1 0
    //   527: invokeinterface 246 1 0
    //   532: ldc 219
    //   534: invokespecial 249	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   537: invokespecial 251	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   540: astore 19
    //   542: new 253	java/lang/StringBuffer
    //   545: dup
    //   546: invokespecial 254	java/lang/StringBuffer:<init>	()V
    //   549: astore 20
    //   551: aload 19
    //   553: invokevirtual 257	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   556: astore 21
    //   558: aload 21
    //   560: ifnull +14 -> 574
    //   563: aload 20
    //   565: aload 21
    //   567: invokevirtual 261	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   570: pop
    //   571: goto -20 -> 551
    //   574: aload_0
    //   575: getfield 31	com/paypal/android/sdk/bg:d	Landroid/os/Handler;
    //   578: aload_0
    //   579: getfield 31	com/paypal/android/sdk/bg:d	Landroid/os/Handler;
    //   582: iconst_2
    //   583: aload 20
    //   585: invokevirtual 264	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   588: invokestatic 46	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   591: invokevirtual 52	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   594: pop
    //   595: aload 19
    //   597: invokestatic 131	com/paypal/android/sdk/R:a	(Ljava/io/Reader;)V
    //   600: invokestatic 136	com/paypal/android/sdk/bi:a	()Lcom/paypal/android/sdk/bi;
    //   603: aload_0
    //   604: invokevirtual 139	com/paypal/android/sdk/bi:b	(Lcom/paypal/android/sdk/bh;)V
    //   607: return
    //   608: astore_3
    //   609: aload_2
    //   610: invokestatic 131	com/paypal/android/sdk/R:a	(Ljava/io/Reader;)V
    //   613: invokestatic 136	com/paypal/android/sdk/bi:a	()Lcom/paypal/android/sdk/bi;
    //   616: aload_0
    //   617: invokevirtual 139	com/paypal/android/sdk/bi:b	(Lcom/paypal/android/sdk/bh;)V
    //   620: aload_3
    //   621: athrow
    //   622: astore_3
    //   623: aload 19
    //   625: astore_2
    //   626: goto -17 -> 609
    //   629: astore 4
    //   631: aload 19
    //   633: astore_2
    //   634: goto -177 -> 457
    //   637: astore 6
    //   639: aload 19
    //   641: astore_2
    //   642: goto -399 -> 243
    //
    // Exception table:
    //   from	to	target	type
    //   22	28	241	java/lang/RuntimeException
    //   35	56	241	java/lang/RuntimeException
    //   56	125	241	java/lang/RuntimeException
    //   132	141	241	java/lang/RuntimeException
    //   141	191	241	java/lang/RuntimeException
    //   191	200	241	java/lang/RuntimeException
    //   207	238	241	java/lang/RuntimeException
    //   273	308	241	java/lang/RuntimeException
    //   315	340	241	java/lang/RuntimeException
    //   340	427	241	java/lang/RuntimeException
    //   430	452	241	java/lang/RuntimeException
    //   487	542	241	java/lang/RuntimeException
    //   22	28	455	java/lang/Exception
    //   35	56	455	java/lang/Exception
    //   56	125	455	java/lang/Exception
    //   132	141	455	java/lang/Exception
    //   141	191	455	java/lang/Exception
    //   191	200	455	java/lang/Exception
    //   207	238	455	java/lang/Exception
    //   273	308	455	java/lang/Exception
    //   315	340	455	java/lang/Exception
    //   340	427	455	java/lang/Exception
    //   430	452	455	java/lang/Exception
    //   487	542	455	java/lang/Exception
    //   22	28	608	finally
    //   35	56	608	finally
    //   56	125	608	finally
    //   132	141	608	finally
    //   141	191	608	finally
    //   191	200	608	finally
    //   207	238	608	finally
    //   243	261	608	finally
    //   273	308	608	finally
    //   315	340	608	finally
    //   340	427	608	finally
    //   430	452	608	finally
    //   457	475	608	finally
    //   487	542	608	finally
    //   542	551	622	finally
    //   551	558	622	finally
    //   563	571	622	finally
    //   574	595	622	finally
    //   542	551	629	java/lang/Exception
    //   551	558	629	java/lang/Exception
    //   563	571	629	java/lang/Exception
    //   574	595	629	java/lang/Exception
    //   542	551	637	java/lang/RuntimeException
    //   551	558	637	java/lang/RuntimeException
    //   563	571	637	java/lang/RuntimeException
    //   574	595	637	java/lang/RuntimeException
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bg
 * JD-Core Version:    0.6.2
 */