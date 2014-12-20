package com.google.b.a.a;

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

class bf
  implements o
{
  private final String a;
  private final HttpClient b;
  private final Context c;
  private ao d;
  private URL e;

  bf(HttpClient paramHttpClient, Context paramContext)
  {
    this(paramHttpClient, ao.a(paramContext), paramContext);
  }

  bf(HttpClient paramHttpClient, ao paramao, Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.a = a("GoogleAnalytics", "3.0", Build.VERSION.RELEASE, bj.a(Locale.getDefault()), Build.MODEL, Build.ID);
    this.b = paramHttpClient;
    this.d = paramao;
  }

  private HttpEntityEnclosingRequest a(String paramString1, String paramString2)
  {
    BasicHttpEntityEnclosingRequest localBasicHttpEntityEnclosingRequest;
    if (TextUtils.isEmpty(paramString1))
    {
      ar.d("Empty hit, discarding.");
      localBasicHttpEntityEnclosingRequest = null;
    }
    while (true)
    {
      return localBasicHttpEntityEnclosingRequest;
      String str = paramString2 + "?" + paramString1;
      if (str.length() < 2036)
        localBasicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", str);
      while (true)
      {
        localBasicHttpEntityEnclosingRequest.addHeader("User-Agent", this.a);
        break;
        localBasicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", paramString2);
        try
        {
          localBasicHttpEntityEnclosingRequest.setEntity(new StringEntity(paramString1));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          ar.d("Encoding error, discarding hit");
          localBasicHttpEntityEnclosingRequest = null;
        }
      }
    }
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
      ar.c(localStringBuffer.toString());
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        ar.c("Error Writing hit to log...");
    }
  }

  public int a(List paramList)
  {
    int i = Math.min(paramList.size(), 40);
    int j = 1;
    int k = 0;
    int m = 0;
    HttpHost localHttpHost;
    HttpEntityEnclosingRequest localHttpEntityEnclosingRequest;
    label191: int i1;
    if (k < i)
    {
      ap localap = (ap)paramList.get(k);
      URL localURL = a(localap);
      int i4;
      if (localURL == null)
      {
        if (ar.a())
          ar.d("No destination: discarding hit: " + localap.a());
        while (true)
        {
          i4 = m + 1;
          k++;
          m = i4;
          break;
          ar.d("No destination: discarding hit.");
        }
      }
      localHttpHost = new HttpHost(localURL.getHost(), localURL.getPort(), localURL.getProtocol());
      String str1 = localURL.getPath();
      if (TextUtils.isEmpty(localap.a()));
      for (String str2 = ""; ; str2 = aq.a(localap, System.currentTimeMillis()))
      {
        localHttpEntityEnclosingRequest = a(str2, str1);
        if (localHttpEntityEnclosingRequest != null)
          break label191;
        i4 = m + 1;
        break;
      }
      localHttpEntityEnclosingRequest.addHeader("Host", localHttpHost.toHostString());
      if (ar.a())
        a(localHttpEntityEnclosingRequest);
      if (str2.length() > 8192)
        ar.d("Hit too long (> 8192 bytes)--not sent");
      for (i1 = j; ; i1 = j)
      {
        int i2 = m + 1;
        int i3 = i1;
        i4 = i2;
        j = i3;
        break;
        if (!this.d.b())
          break label279;
        ar.b("Dry run enabled. Hit not actually sent.");
      }
      label279: if (j == 0)
        break label461;
    }
    while (true)
    {
      try
      {
        while (true)
        {
          v.b(this.c);
          i1 = 0;
          try
          {
            HttpResponse localHttpResponse = this.b.execute(localHttpHost, localHttpEntityEnclosingRequest);
            int i5 = localHttpResponse.getStatusLine().getStatusCode();
            HttpEntity localHttpEntity = localHttpResponse.getEntity();
            if (localHttpEntity != null)
              localHttpEntity.consumeContent();
            if (i5 == 200)
              break;
            ar.d("Bad response: " + localHttpResponse.getStatusLine().getStatusCode());
          }
          catch (ClientProtocolException localClientProtocolException1)
          {
          }
        }
        ar.d("ClientProtocolException sending hit; discarding hit...");
      }
      catch (IOException localIOException)
      {
        ar.d("Exception sending hit: " + localIOException.getClass().getSimpleName());
        ar.d(localIOException.getMessage());
        int n = m;
        return n;
        n = m;
        continue;
      }
      catch (ClientProtocolException localClientProtocolException2)
      {
        i1 = j;
        continue;
      }
      label461: i1 = j;
    }
  }

  String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramString2;
    arrayOfObject[2] = paramString3;
    arrayOfObject[3] = paramString4;
    arrayOfObject[4] = paramString5;
    arrayOfObject[5] = paramString6;
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", arrayOfObject);
  }

  URL a(ap paramap)
  {
    URL localURL;
    if (this.e != null)
    {
      localURL = this.e;
      return localURL;
    }
    String str1 = paramap.d();
    while (true)
    {
      try
      {
        if (!"http:".equals(str1))
          break label63;
        str2 = "http://www.google-analytics.com/collect";
        localURL = new URL(str2);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        ar.a("Error trying to parse the hardcoded host url. This really shouldn't happen.");
        localURL = null;
      }
      break;
      label63: String str2 = "https://ssl.google-analytics.com/collect";
    }
  }

  public void a(String paramString)
  {
    try
    {
      this.e = new URL(paramString);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (true)
        this.e = null;
    }
  }

  public boolean a()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.c.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
      ar.c("...no network connectivity");
    for (int i = 0; ; i = 1)
      return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.bf
 * JD-Core Version:    0.6.0
 */