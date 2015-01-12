package com.inauth.utilities.network;

import com.inauth.utilities.InAuthUtilities;
import java.io.IOException;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.json.JSONException;

public class UploadFile
{
  private static ExecutorService executor;
  private static UploadFile instance;

  private ExecutorService getExecutorService()
  {
    if (executor == null)
      executor = Executors.newCachedThreadPool();
    return executor;
  }

  public static UploadFile getInstance()
  {
    if (instance == null)
      instance = new UploadFile();
    return instance;
  }

  public String sendLog(String paramString1, final String paramString2)
  {
    final byte[] arrayOfByte = InAuthUtilities.Serverpack(paramString1);
    try
    {
      getInstance().getExecutorService().execute(new Runnable()
      {
        public void run()
        {
          try
          {
            UploadFile.getInstance().sendLog(arrayOfByte, paramString2);
            return;
          }
          catch (Exception localException)
          {
          }
        }
      });
      return "SUCCESS";
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String sendLog(byte[] paramArrayOfByte, String paramString)
    throws IllegalCharsetNameException, UnsupportedCharsetException, ClientProtocolException, IOException, JSONException
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    localDefaultHttpClient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
    HttpPost localHttpPost = new HttpPost(paramString);
    MultipartEntity localMultipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
    localMultipartEntity.addPart("payload", new ByteArrayBody(paramArrayOfByte, "application/gzip"));
    localHttpPost.setEntity(localMultipartEntity);
    HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
    switch (localHttpResponse.getStatusLine().getStatusCode())
    {
    default:
      localHttpResponse.getEntity().consumeContent();
      return null;
    case 200:
    }
    return InAuthUtilities.serverUnpack(InAuthUtilities.streamToByteArray(localHttpResponse.getEntity().getContent()));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.utilities.network.UploadFile
 * JD-Core Version:    0.6.2
 */