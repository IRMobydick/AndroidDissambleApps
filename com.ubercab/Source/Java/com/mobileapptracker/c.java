package com.mobileapptracker;

import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONObject;
import org.json.JSONTokener;

final class c
{
  private HttpClient a;

  public c()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 60000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 60000);
    this.a = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
  }

  public final JSONObject a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0));
    label345: 
    do
    {
      StatusLine localStatusLine;
      Header localHeader;
      do
      {
        StringBuilder localStringBuilder;
        do
        {
          BufferedReader localBufferedReader;
          while (true)
          {
            Object localObject;
            try
            {
              HttpResponse localHttpResponse1 = this.a.execute(new HttpGet(paramString));
              localObject = localHttpResponse1;
              if (localObject != null)
                try
                {
                  localStatusLine = ((HttpResponse)localObject).getStatusLine();
                  localHeader = ((HttpResponse)localObject).getFirstHeader("X-MAT-Responder");
                  if (paramBoolean)
                    Log.d("MobileAppTracker", "Request completed with status " + localStatusLine.getStatusCode());
                  if ((localStatusLine.getStatusCode() < 200) || (localStatusLine.getStatusCode() > 299))
                    break label345;
                  localBufferedReader = new BufferedReader(new InputStreamReader(((HttpResponse)localObject).getEntity().getContent(), "UTF-8"));
                  localStringBuilder = new StringBuilder();
                  String str = localBufferedReader.readLine();
                  if (str == null)
                    break;
                  localStringBuilder.append(str).append("\n");
                  continue;
                }
                catch (Exception localException2)
                {
                  localException2.printStackTrace();
                }
              localJSONObject = new JSONObject();
              return localJSONObject;
            }
            catch (Exception localException1)
            {
              if (paramBoolean)
                Log.d("MobileAppTracker", "Request error with URL " + paramString);
              localException1.printStackTrace();
              localObject = null;
              continue;
            }
            try
            {
              StringEntity localStringEntity = new StringEntity(paramJSONObject.toString());
              localStringEntity.setContentType("application/json");
              HttpPost localHttpPost = new HttpPost(paramString);
              localHttpPost.setEntity(localStringEntity);
              HttpResponse localHttpResponse2 = this.a.execute(localHttpPost);
              localObject = localHttpResponse2;
            }
            catch (Exception localException3)
            {
              localException3.printStackTrace();
              localObject = null;
            }
          }
          localBufferedReader.close();
        }
        while (localStringBuilder.length() <= 0);
        return new JSONObject(new JSONTokener(localStringBuilder.toString()));
      }
      while ((localStatusLine.getStatusCode() != 400) || (localHeader == null));
      JSONObject localJSONObject = null;
    }
    while (!paramBoolean);
    Log.d("MobileAppTracker", "Request received 400 error from MAT server, won't be retried");
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.c
 * JD-Core Version:    0.6.2
 */