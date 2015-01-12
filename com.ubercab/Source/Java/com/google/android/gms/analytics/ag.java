package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class ag
  implements m
{
  private final HttpClient Bj;
  private URL Bk;
  private final Context mContext;
  private final String vW;
  private GoogleAnalytics yu;

  ag(HttpClient paramHttpClient, Context paramContext)
  {
    this(paramHttpClient, GoogleAnalytics.getInstance(paramContext), paramContext);
  }

  ag(HttpClient paramHttpClient, GoogleAnalytics paramGoogleAnalytics, Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.vW = a("GoogleAnalytics", "3.0", Build.VERSION.RELEASE, aj.a(Locale.getDefault()), Build.MODEL, Build.ID);
    this.Bj = paramHttpClient;
    this.yu = paramGoogleAnalytics;
  }

  // ERROR //
  private void a(aa paramaa, URL paramURL, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 89	com/google/android/gms/analytics/aa:eL	()Ljava/lang/String;
    //   4: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 99	com/google/android/gms/analytics/ag:eS	()Z
    //   14: ifne +4 -> 18
    //   17: return
    //   18: aload_2
    //   19: ifnonnull +254 -> 273
    //   22: aload_0
    //   23: getfield 101	com/google/android/gms/analytics/ag:Bk	Ljava/net/URL;
    //   26: ifnull +190 -> 216
    //   29: aload_0
    //   30: getfield 101	com/google/android/gms/analytics/ag:Bk	Ljava/net/URL;
    //   33: astore 4
    //   35: new 103	org/apache/http/HttpHost
    //   38: dup
    //   39: aload 4
    //   41: invokevirtual 108	java/net/URL:getHost	()Ljava/lang/String;
    //   44: aload 4
    //   46: invokevirtual 112	java/net/URL:getPort	()I
    //   49: aload 4
    //   51: invokevirtual 115	java/net/URL:getProtocol	()Ljava/lang/String;
    //   54: invokespecial 118	org/apache/http/HttpHost:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: astore 5
    //   59: aload_0
    //   60: aload_1
    //   61: invokevirtual 89	com/google/android/gms/analytics/aa:eL	()Ljava/lang/String;
    //   64: aload 4
    //   66: invokevirtual 121	java/net/URL:getPath	()Ljava/lang/String;
    //   69: invokespecial 125	com/google/android/gms/analytics/ag:h	(Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/HttpEntityEnclosingRequest;
    //   72: astore 8
    //   74: aload 8
    //   76: ifnull -59 -> 17
    //   79: aload 8
    //   81: ldc 127
    //   83: aload 5
    //   85: invokevirtual 130	org/apache/http/HttpHost:toHostString	()Ljava/lang/String;
    //   88: invokeinterface 136 3 0
    //   93: invokestatic 141	com/google/android/gms/analytics/z:eK	()Z
    //   96: ifeq +9 -> 105
    //   99: aload_0
    //   100: aload 8
    //   102: invokespecial 144	com/google/android/gms/analytics/ag:a	(Lorg/apache/http/HttpEntityEnclosingRequest;)V
    //   105: iload_3
    //   106: ifeq +10 -> 116
    //   109: aload_0
    //   110: getfield 38	com/google/android/gms/analytics/ag:mContext	Landroid/content/Context;
    //   113: invokestatic 150	com/google/android/gms/analytics/p:A	(Landroid/content/Context;)V
    //   116: aload_0
    //   117: getfield 74	com/google/android/gms/analytics/ag:Bj	Lorg/apache/http/client/HttpClient;
    //   120: aload 5
    //   122: aload 8
    //   124: invokeinterface 156 3 0
    //   129: astore 9
    //   131: aload 9
    //   133: invokeinterface 162 1 0
    //   138: invokeinterface 167 1 0
    //   143: istore 10
    //   145: aload 9
    //   147: invokeinterface 171 1 0
    //   152: astore 11
    //   154: aload 11
    //   156: ifnull +10 -> 166
    //   159: aload 11
    //   161: invokeinterface 176 1 0
    //   166: iload 10
    //   168: sipush 200
    //   171: if_icmpeq -154 -> 17
    //   174: new 178	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   181: ldc 181
    //   183: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 9
    //   188: invokeinterface 162 1 0
    //   193: invokeinterface 167 1 0
    //   198: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 195	com/google/android/gms/analytics/z:W	(Ljava/lang/String;)V
    //   207: return
    //   208: astore 7
    //   210: ldc 197
    //   212: invokestatic 195	com/google/android/gms/analytics/z:W	(Ljava/lang/String;)V
    //   215: return
    //   216: new 105	java/net/URL
    //   219: dup
    //   220: ldc 199
    //   222: invokespecial 201	java/net/URL:<init>	(Ljava/lang/String;)V
    //   225: astore 4
    //   227: goto -192 -> 35
    //   230: astore 12
    //   232: return
    //   233: astore 6
    //   235: new 178	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   242: ldc 203
    //   244: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 6
    //   249: invokevirtual 207	java/lang/Object:getClass	()Ljava/lang/Class;
    //   252: invokevirtual 212	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   255: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 195	com/google/android/gms/analytics/z:W	(Ljava/lang/String;)V
    //   264: aload 6
    //   266: invokevirtual 215	java/io/IOException:getMessage	()Ljava/lang/String;
    //   269: invokestatic 195	com/google/android/gms/analytics/z:W	(Ljava/lang/String;)V
    //   272: return
    //   273: aload_2
    //   274: astore 4
    //   276: goto -241 -> 35
    //
    // Exception table:
    //   from	to	target	type
    //   59	74	208	org/apache/http/client/ClientProtocolException
    //   79	105	208	org/apache/http/client/ClientProtocolException
    //   109	116	208	org/apache/http/client/ClientProtocolException
    //   116	154	208	org/apache/http/client/ClientProtocolException
    //   159	166	208	org/apache/http/client/ClientProtocolException
    //   174	207	208	org/apache/http/client/ClientProtocolException
    //   22	35	230	java/net/MalformedURLException
    //   216	227	230	java/net/MalformedURLException
    //   59	74	233	java/io/IOException
    //   79	105	233	java/io/IOException
    //   109	116	233	java/io/IOException
    //   116	154	233	java/io/IOException
    //   159	166	233	java/io/IOException
    //   174	207	233	java/io/IOException
  }

  private void a(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Header[] arrayOfHeader = paramHttpEntityEnclosingRequest.getAllHeaders();
    int i = arrayOfHeader.length;
    for (int j = 0; j < i; j++)
      localStringBuffer.append(arrayOfHeader[j].toString()).append("\n");
    localStringBuffer.append(paramHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
    if (paramHttpEntityEnclosingRequest.getEntity() != null);
    try
    {
      InputStream localInputStream = paramHttpEntityEnclosingRequest.getEntity().getContent();
      if (localInputStream != null)
      {
        int k = localInputStream.available();
        if (k > 0)
        {
          byte[] arrayOfByte = new byte[k];
          localInputStream.read(arrayOfByte);
          localStringBuffer.append("POST:\n");
          localStringBuffer.append(new String(arrayOfByte)).append("\n");
        }
      }
      z.V(localStringBuffer.toString());
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        z.V("Error Writing hit to log...");
    }
  }

  private HttpEntityEnclosingRequest h(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      z.W("Empty hit, discarding.");
      return null;
    }
    String str = paramString2 + "?" + paramString1;
    BasicHttpEntityEnclosingRequest localBasicHttpEntityEnclosingRequest;
    if (str.length() < 2036)
      localBasicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", str);
    while (true)
    {
      localBasicHttpEntityEnclosingRequest.addHeader("User-Agent", this.vW);
      return localBasicHttpEntityEnclosingRequest;
      localBasicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", paramString2);
      try
      {
        localBasicHttpEntityEnclosingRequest.setEntity(new StringEntity(paramString1));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        z.W("Encoding error, discarding hit");
      }
    }
    return null;
  }

  public int a(List<w> paramList, aa paramaa, boolean paramBoolean)
  {
    int i = 0;
    int j = Math.min(paramList.size(), 40);
    paramaa.e("_hr", paramList.size());
    int k = 0;
    Object localObject1 = null;
    boolean bool = true;
    int m = 0;
    if (m < j)
    {
      w localw = (w)paramList.get(m);
      URL localURL = a(localw);
      int n;
      Object localObject2;
      if (localURL == null)
      {
        if (z.eK())
          z.W("No destination: discarding hit: " + localw.eF());
        while (true)
        {
          int i3 = i + 1;
          k++;
          Object localObject3 = localObject1;
          n = i3;
          localObject2 = localObject3;
          m++;
          i = n;
          localObject1 = localObject2;
          break;
          z.W("No destination: discarding hit.");
        }
      }
      HttpHost localHttpHost = new HttpHost(localURL.getHost(), localURL.getPort(), localURL.getProtocol());
      String str1 = localURL.getPath();
      if (TextUtils.isEmpty(localw.eF()));
      HttpEntityEnclosingRequest localHttpEntityEnclosingRequest;
      for (String str2 = ""; ; str2 = x.a(localw, System.currentTimeMillis()))
      {
        localHttpEntityEnclosingRequest = h(str2, str1);
        if (localHttpEntityEnclosingRequest != null)
          break label246;
        int i2 = i + 1;
        k++;
        n = i2;
        localObject2 = localURL;
        break;
      }
      label246: localHttpEntityEnclosingRequest.addHeader("Host", localHttpHost.toHostString());
      if (z.eK())
        a(localHttpEntityEnclosingRequest);
      if (str2.length() > 8192)
      {
        z.W("Hit too long (> 8192 bytes)--not sent");
        k++;
      }
      while (true)
      {
        paramaa.e("_td", str2.getBytes().length);
        n = i + 1;
        localObject2 = localURL;
        break;
        if (this.yu.isDryRunEnabled())
        {
          z.U("Dry run enabled. Hit not actually sent.");
        }
        else
        {
          if (bool);
          try
          {
            p.A(this.mContext);
            bool = false;
            HttpResponse localHttpResponse = this.Bj.execute(localHttpHost, localHttpEntityEnclosingRequest);
            int i1 = localHttpResponse.getStatusLine().getStatusCode();
            HttpEntity localHttpEntity = localHttpResponse.getEntity();
            if (localHttpEntity != null)
              localHttpEntity.consumeContent();
            if (i1 != 200)
              z.W("Bad response: " + localHttpResponse.getStatusLine().getStatusCode());
          }
          catch (ClientProtocolException localClientProtocolException)
          {
            z.W("ClientProtocolException sending hit; discarding hit...");
            paramaa.e("_hd", k);
          }
          catch (IOException localIOException)
          {
            z.W("Exception sending hit: " + localIOException.getClass().getSimpleName());
            z.W(localIOException.getMessage());
            paramaa.e("_de", 1);
            paramaa.e("_hd", k);
            paramaa.e("_hs", i);
            a(paramaa, localURL, bool);
            return i;
          }
        }
      }
    }
    paramaa.e("_hd", k);
    paramaa.e("_hs", i);
    if (paramBoolean)
      a(paramaa, localObject1, bool);
    return i;
  }

  String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }

  URL a(w paramw)
  {
    if (this.Bk != null)
      return this.Bk;
    String str1 = paramw.eI();
    while (true)
    {
      try
      {
        if ("http:".equals(str1))
        {
          str2 = "http://www.google-analytics.com/collect";
          URL localURL = new URL(str2);
          return localURL;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        z.T("Error trying to parse the hardcoded host url. This really shouldn't happen.");
        return null;
      }
      String str2 = "https://ssl.google-analytics.com/collect";
    }
  }

  public void af(String paramString)
  {
    try
    {
      this.Bk = new URL(paramString);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      this.Bk = null;
    }
  }

  public boolean dX()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      z.V("...no network connectivity");
      return false;
    }
    return true;
  }

  boolean eS()
  {
    return 100.0D * Math.random() <= 1.0D;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ag
 * JD-Core Version:    0.6.2
 */