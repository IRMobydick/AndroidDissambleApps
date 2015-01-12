package com.baidu.location;

import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class s$1 extends Thread
{
  s$1(s params)
  {
  }

  public void run()
  {
    this.a.cR = c.jdMethod_for();
    this.a.T();
    int i = this.a.c0;
    s.jdMethod_if(this.a);
    while (true)
    {
      if (i > 0);
      try
      {
        HttpGet localHttpGet = new HttpGet(this.a.cR);
        localHttpGet.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        localHttpGet.setHeader("Accept-Charset", "UTF-8;");
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        localDefaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(12000));
        localDefaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(12000));
        HttpProtocolParams.setUseExpectContinue(localDefaultHttpClient.getParams(), false);
        if (((s.M() == 1) || (s.M() == 4)) && ((this.a.c0 - i) % 2 == 0))
        {
          HttpHost localHttpHost = new HttpHost(s.O(), s.S(), "http");
          localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
        }
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpGet);
        if (localHttpResponse.getStatusLine().getStatusCode() == 200)
        {
          this.a.cS = localHttpResponse.getEntity();
          this.a.jdMethod_do(true);
          if (i <= 0)
          {
            s.cY = 1 + s.cY;
            this.a.cS = null;
            this.a.jdMethod_do(false);
            s.jdMethod_if(this.a, false);
          }
        }
        else
        {
          localHttpGet.abort();
          i--;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          Log.d("baidu_location_service", "NetworkCommunicationException!");
          continue;
          s.cY = 0;
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.s.1
 * JD-Core Version:    0.6.2
 */