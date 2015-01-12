package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

class c
{
  private final String a = "HttpAsyncTask";
  private Context b;
  private String c = null;
  private String d = null;
  private HashMap<String, String> e = null;
  private a<String> f = null;

  protected c(Context paramContext)
  {
    this.b = paramContext;
  }

  private String a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()))
      return "";
    String str = localNetworkInfo.getExtraInfo();
    if ((str != null) && ((str.trim().toLowerCase().equals("cmwap")) || (str.trim().toLowerCase().equals("uniwap")) || (str.trim().toLowerCase().equals("3gwap")) || (str.trim().toLowerCase().equals("ctwap"))))
    {
      if (str.trim().toLowerCase().equals("ctwap"))
        return "ctwap";
      return "cmwap";
    }
    return "wifi";
  }

  private HashMap<String, String> a(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = localIterator.next().toString();
      localHashMap.put(str, paramHashMap.get(str));
    }
    return localHashMap;
  }

  private HttpClient a()
  {
    InputStream localInputStream = null;
    try
    {
      CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
      try
      {
        localInputStream = this.b.getResources().getAssets().open("sapi_cert.cer");
        Certificate localCertificate = localCertificateFactory.generateCertificate(localInputStream);
        localInputStream.close();
        KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        localKeyStore.load(null, null);
        localKeyStore.setCertificateEntry("ca", localCertificate);
        b localb = new b(localKeyStore);
        localb.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", localb, 443));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      }
      finally
      {
        localInputStream.close();
      }
    }
    catch (Exception localException)
    {
    }
    return new DefaultHttpClient();
  }

  private void a(String paramString)
  {
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (!localJSONObject.has("status"))
        localJSONObject.put("status", -1);
      if (this.f != null)
      {
        a locala = this.f;
        if (localJSONObject != null)
        {
          str = localJSONObject.toString();
          locala.a(str);
        }
      }
      else
      {
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      while (true)
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("status", -1);
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
        continue;
        String str = new JSONObject().toString();
      }
    }
  }

  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (a.a)
      a.a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
    HttpClient localHttpClient = a();
    b(localHttpClient);
    if (a(localHttpClient))
      a(localHttpClient, paramString, paramHashMap);
    while (true)
    {
      if (a.a)
        a.a("syncConnect end");
      return;
      a(ErrorMessage.a("Current network is not available."));
    }
  }

  // ERROR //
  private void a(HttpClient paramHttpClient, String paramString, HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: getstatic 279	com/baidu/lbsapi/auth/a:a	Z
    //   3: ifeq +9 -> 12
    //   6: ldc_w 334
    //   9: invokestatic 305	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   12: getstatic 279	com/baidu/lbsapi/auth/a:a	Z
    //   15: ifeq +801 -> 816
    //   18: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   21: l2d
    //   22: dstore 4
    //   24: new 341	org/apache/http/client/methods/HttpPost
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 342	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   32: astore 6
    //   34: getstatic 279	com/baidu/lbsapi/auth/a:a	Z
    //   37: ifeq +26 -> 63
    //   40: new 281	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 344
    //   50: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_2
    //   54: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 305	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   63: aload_3
    //   64: ifnonnull +14 -> 78
    //   67: aload_0
    //   68: ldc_w 346
    //   71: invokestatic 325	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   74: invokespecial 326	com/baidu/lbsapi/auth/c:a	(Ljava/lang/String;)V
    //   77: return
    //   78: new 348	java/util/ArrayList
    //   81: dup
    //   82: aload_3
    //   83: invokevirtual 352	java/util/HashMap:size	()I
    //   86: invokespecial 355	java/util/ArrayList:<init>	(I)V
    //   89: astore 7
    //   91: aload_3
    //   92: invokevirtual 358	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   95: invokeinterface 99 1 0
    //   100: astore 8
    //   102: aload 8
    //   104: invokeinterface 104 1 0
    //   109: ifeq +128 -> 237
    //   112: aload 8
    //   114: invokeinterface 108 1 0
    //   119: checkcast 360	java/util/Map$Entry
    //   122: astore 21
    //   124: aload 21
    //   126: invokeinterface 363 1 0
    //   131: checkcast 64	java/lang/String
    //   134: ldc_w 365
    //   137: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: ifne -38 -> 102
    //   143: getstatic 279	com/baidu/lbsapi/auth/a:a	Z
    //   146: ifeq +53 -> 199
    //   149: new 281	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   156: ldc 58
    //   158: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 21
    //   163: invokeinterface 363 1 0
    //   168: checkcast 64	java/lang/String
    //   171: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc_w 367
    //   177: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 21
    //   182: invokeinterface 370 1 0
    //   187: checkcast 64	java/lang/String
    //   190: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 305	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   199: aload 7
    //   201: new 372	org/apache/http/message/BasicNameValuePair
    //   204: dup
    //   205: aload 21
    //   207: invokeinterface 363 1 0
    //   212: checkcast 64	java/lang/String
    //   215: aload 21
    //   217: invokeinterface 370 1 0
    //   222: checkcast 64	java/lang/String
    //   225: invokespecial 375	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: invokeinterface 380 2 0
    //   233: pop
    //   234: goto -132 -> 102
    //   237: getstatic 279	com/baidu/lbsapi/auth/a:a	Z
    //   240: ifeq +9 -> 249
    //   243: ldc_w 382
    //   246: invokestatic 305	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   249: aload 6
    //   251: invokevirtual 386	org/apache/http/client/methods/HttpPost:getAllHeaders	()[Lorg/apache/http/Header;
    //   254: astore 9
    //   256: aload 9
    //   258: arraylength
    //   259: istore 10
    //   261: iconst_0
    //   262: istore 11
    //   264: iload 11
    //   266: iload 10
    //   268: if_icmpge +67 -> 335
    //   271: aload 9
    //   273: iload 11
    //   275: aaload
    //   276: astore 20
    //   278: getstatic 279	com/baidu/lbsapi/auth/a:a	Z
    //   281: ifeq +48 -> 329
    //   284: new 281	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   291: ldc_w 388
    //   294: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 20
    //   299: invokeinterface 393 1 0
    //   304: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc_w 395
    //   310: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 20
    //   315: invokeinterface 397 1 0
    //   320: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 305	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   329: iinc 11 1
    //   332: goto -68 -> 264
    //   335: new 399	org/apache/http/client/entity/UrlEncodedFormEntity
    //   338: dup
    //   339: aload 7
    //   341: ldc_w 401
    //   344: invokespecial 404	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   347: astore 12
    //   349: aload 6
    //   351: aload 12
    //   353: invokevirtual 408	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   356: getstatic 279	com/baidu/lbsapi/auth/a:a	Z
    //   359: ifeq +9 -> 368
    //   362: ldc_w 410
    //   365: invokestatic 305	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   368: aload_1
    //   369: aload 6
    //   371: invokeinterface 416 2 0
    //   376: astore 16
    //   378: getstatic 279	com/baidu/lbsapi/auth/a:a	Z
    //   381: ifeq +52 -> 433
    //   384: new 281	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 418
    //   394: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   400: l2d
    //   401: dload 4
    //   403: dsub
    //   404: ldc2_w 419
    //   407: ddiv
    //   408: invokevirtual 423	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   411: ldc_w 425
    //   414: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_2
    //   418: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: ldc_w 427
    //   424: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 305	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   433: aload 16
    //   435: ifnull +261 -> 696
    //   438: aload 16
    //   440: invokeinterface 433 1 0
    //   445: ifnull +251 -> 696
    //   448: aload 16
    //   450: invokeinterface 433 1 0
    //   455: invokeinterface 438 1 0
    //   460: istore 17
    //   462: iload 17
    //   464: sipush 200
    //   467: if_icmpeq +245 -> 712
    //   470: getstatic 279	com/baidu/lbsapi/auth/a:a	Z
    //   473: ifeq +37 -> 510
    //   476: new 281	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 440
    //   486: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 16
    //   491: invokeinterface 433 1 0
    //   496: invokeinterface 443 1 0
    //   501: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 305	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   510: aload_0
    //   511: new 281	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   518: ldc_w 445
    //   521: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: iload 17
    //   526: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: ldc_w 450
    //   532: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload 16
    //   537: invokeinterface 433 1 0
    //   542: invokeinterface 443 1 0
    //   547: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 325	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   556: invokespecial 326	com/baidu/lbsapi/auth/c:a	(Ljava/lang/String;)V
    //   559: return
    //   560: astore 19
    //   562: aload_0
    //   563: new 281	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   570: ldc_w 452
    //   573: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 19
    //   578: invokevirtual 455	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   581: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 325	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   590: invokespecial 326	com/baidu/lbsapi/auth/c:a	(Ljava/lang/String;)V
    //   593: return
    //   594: astore 15
    //   596: aload_0
    //   597: new 281	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   604: ldc_w 457
    //   607: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload 15
    //   612: invokevirtual 458	org/apache/http/conn/ConnectTimeoutException:getMessage	()Ljava/lang/String;
    //   615: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 325	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   624: invokespecial 326	com/baidu/lbsapi/auth/c:a	(Ljava/lang/String;)V
    //   627: return
    //   628: astore 14
    //   630: aload_0
    //   631: new 281	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   638: ldc_w 460
    //   641: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: aload 14
    //   646: invokevirtual 461	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   649: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokestatic 325	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   658: invokespecial 326	com/baidu/lbsapi/auth/c:a	(Ljava/lang/String;)V
    //   661: return
    //   662: astore 13
    //   664: aload_0
    //   665: new 281	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   672: ldc_w 463
    //   675: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload 13
    //   680: invokevirtual 464	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   683: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 325	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   692: invokespecial 326	com/baidu/lbsapi/auth/c:a	(Ljava/lang/String;)V
    //   695: return
    //   696: aload_0
    //   697: ldc_w 466
    //   700: invokestatic 325	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   703: invokespecial 326	com/baidu/lbsapi/auth/c:a	(Ljava/lang/String;)V
    //   706: iconst_0
    //   707: istore 17
    //   709: goto -247 -> 462
    //   712: aload_0
    //   713: aload 16
    //   715: invokeinterface 470 1 0
    //   720: ldc_w 401
    //   723: invokestatic 475	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;
    //   726: putfield 27	com/baidu/lbsapi/auth/c:c	Ljava/lang/String;
    //   729: getstatic 279	com/baidu/lbsapi/auth/a:a	Z
    //   732: ifeq +29 -> 761
    //   735: new 281	java/lang/StringBuilder
    //   738: dup
    //   739: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   742: ldc_w 477
    //   745: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: aload_0
    //   749: getfield 27	com/baidu/lbsapi/auth/c:c	Ljava/lang/String;
    //   752: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokestatic 305	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   761: aload_0
    //   762: aload_0
    //   763: getfield 27	com/baidu/lbsapi/auth/c:c	Ljava/lang/String;
    //   766: invokespecial 326	com/baidu/lbsapi/auth/c:a	(Ljava/lang/String;)V
    //   769: getstatic 279	com/baidu/lbsapi/auth/a:a	Z
    //   772: ifeq -695 -> 77
    //   775: ldc_w 479
    //   778: invokestatic 305	com/baidu/lbsapi/auth/a:a	(Ljava/lang/String;)V
    //   781: return
    //   782: astore 18
    //   784: aload_0
    //   785: new 281	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   792: ldc_w 463
    //   795: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload 18
    //   800: invokevirtual 464	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   803: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 325	com/baidu/lbsapi/auth/ErrorMessage:a	(Ljava/lang/String;)Ljava/lang/String;
    //   812: invokespecial 326	com/baidu/lbsapi/auth/c:a	(Ljava/lang/String;)V
    //   815: return
    //   816: dconst_0
    //   817: dstore 4
    //   819: goto -795 -> 24
    //
    // Exception table:
    //   from	to	target	type
    //   335	349	560	java/io/UnsupportedEncodingException
    //   356	368	594	org/apache/http/conn/ConnectTimeoutException
    //   368	378	594	org/apache/http/conn/ConnectTimeoutException
    //   356	368	628	java/net/SocketTimeoutException
    //   368	378	628	java/net/SocketTimeoutException
    //   356	368	662	java/lang/Exception
    //   368	378	662	java/lang/Exception
    //   712	729	782	java/lang/Exception
  }

  private boolean a(HttpClient paramHttpClient)
  {
    if (a.a)
      a.a("checkNetwork 1 start");
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()))
      return false;
    String str = a(this.b);
    if (a.a)
      a.a("checkNetwork = " + str);
    if (str.equals("cmwap"))
    {
      HttpHost localHttpHost1 = new HttpHost("10.0.0.172", 80, "http");
      paramHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost1);
    }
    while (true)
    {
      if (a.a)
        a.a("checkNetwork 4 end");
      return true;
      if (str.equals("ctwap"))
      {
        HttpHost localHttpHost2 = new HttpHost("10.0.0.200", 80, "http");
        paramHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost2);
      }
    }
  }

  private void b(HttpClient paramHttpClient)
  {
    if (a.a)
      a.a("setTimeout start");
    paramHttpClient.getParams().setIntParameter("http.socket.timeout", 50000);
    paramHttpClient.getParams().setIntParameter("http.connection.timeout", 50000);
    if (a.a)
      a.a("setTimeout end");
  }

  protected void a(HashMap<String, String> paramHashMap, a<String> parama)
  {
    this.e = a(paramHashMap);
    this.f = parama;
    this.d = ((String)this.e.get("url"));
    new Thread(new d(this)).start();
  }

  static abstract interface a<Result>
  {
    public abstract void a(Result paramResult);
  }

  class b extends org.apache.http.conn.ssl.SSLSocketFactory
    implements X509TrustManager
  {
    SSLContext a = SSLContext.getInstance("TLS");
    X509TrustManager b = null;

    public b(KeyStore arg2)
      throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
      super();
      TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      localTrustManagerFactory.init(localKeyStore);
      TrustManager[] arrayOfTrustManager1 = localTrustManagerFactory.getTrustManagers();
      if (a.a)
        a.a("trustmanagers.length:" + arrayOfTrustManager1.length);
      if (arrayOfTrustManager1.length == 0)
        throw new NoSuchAlgorithmException("no trust manager found");
      this.b = ((X509TrustManager)arrayOfTrustManager1[0]);
      SSLContext localSSLContext = this.a;
      TrustManager[] arrayOfTrustManager2 = new TrustManager[1];
      arrayOfTrustManager2[0] = this.b;
      localSSLContext.init(null, arrayOfTrustManager2, null);
    }

    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      this.b.checkClientTrusted(paramArrayOfX509Certificate, paramString);
    }

    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      if ((paramArrayOfX509Certificate != null) && (paramArrayOfX509Certificate.length == 1))
      {
        paramArrayOfX509Certificate[0].checkValidity();
        return;
      }
      this.b.checkServerTrusted(paramArrayOfX509Certificate, paramString);
    }

    public Socket createSocket()
      throws IOException
    {
      return this.a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
      throws IOException, UnknownHostException
    {
      return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    }

    public X509Certificate[] getAcceptedIssuers()
    {
      return this.b.getAcceptedIssuers();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.lbsapi.auth.c
 * JD-Core Version:    0.6.2
 */