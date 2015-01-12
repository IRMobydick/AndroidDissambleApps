package com.baidu.location;

import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class s$2 extends Thread
{
  s$2(s params)
  {
  }

  public void run()
  {
    this.a.cR = c.jdMethod_for();
    this.a.T();
    int i = this.a.c0;
    s.jdMethod_if(this.a);
    int j = i;
    Object localObject1 = null;
    while (true)
    {
      if (j > 0);
      try
      {
        localObject2 = new HttpPost(this.a.cR);
        while (true)
        {
          try
          {
            UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(this.a.cT, "utf-8");
            ((HttpPost)localObject2).setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            ((HttpPost)localObject2).setHeader("Accept-Charset", "UTF-8;");
            ((HttpPost)localObject2).setEntity(localUrlEncodedFormEntity);
            DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
            localDefaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(12000));
            localDefaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(12000));
            HttpProtocolParams.setUseExpectContinue(localDefaultHttpClient.getParams(), false);
            if (((s.M() == 1) || (s.M() == 4)) && ((this.a.c0 - j) % 2 == 0))
            {
              HttpHost localHttpHost = new HttpHost(s.O(), s.S(), "http");
              localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
            }
            HttpResponse localHttpResponse = localDefaultHttpClient.execute((HttpUriRequest)localObject2);
            if (localHttpResponse.getStatusLine().getStatusCode() == 200)
            {
              this.a.cS = localHttpResponse.getEntity();
              this.a.jdMethod_do(true);
              if (j > 0)
                break label344;
              s.cY = 1 + s.cY;
              this.a.cS = null;
              this.a.jdMethod_do(false);
              s.jdMethod_if(this.a, false);
              return;
            }
            ((HttpPost)localObject2).abort();
            j--;
            localObject1 = localObject2;
          }
          catch (Exception localException1)
          {
          }
          ((HttpPost)localObject2).abort();
          Log.d("baidu_location_service", "NetworkCommunicationException!");
          continue;
          label344: s.cY = 0;
        }
      }
      catch (Exception localException2)
      {
        while (true)
          Object localObject2 = localObject1;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.s.2
 * JD-Core Version:    0.6.2
 */