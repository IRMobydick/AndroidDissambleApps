package com.adjust.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class RequestHandler extends HandlerThread
  implements IRequestHandler
{
  private static final int CONNECTION_TIMEOUT = 60000;
  private static final int SOCKET_TIMEOUT = 60000;
  private HttpClient httpClient;
  private InternalHandler internalHandler;
  private Logger logger;
  private IPackageHandler packageHandler;

  public RequestHandler(IPackageHandler paramIPackageHandler)
  {
    super("Adjust", 1);
    setDaemon(true);
    start();
    this.logger = AdjustFactory.getLogger();
    this.internalHandler = new InternalHandler(getLooper(), this);
    this.packageHandler = paramIPackageHandler;
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72401;
    this.internalHandler.sendMessage(localMessage);
  }

  private void closePackage(ActivityPackage paramActivityPackage, String paramString, Throwable paramThrowable)
  {
    boolean bool = true;
    String str1 = paramActivityPackage.getFailureMessage();
    String str2 = this.packageHandler.getFailureMessage();
    String str3 = getReasonString(paramString, paramThrowable);
    Logger localLogger = this.logger;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = str1;
    arrayOfObject[bool] = str3;
    arrayOfObject[2] = str2;
    localLogger.error(String.format("%s. (%s) %s", arrayOfObject));
    ResponseData localResponseData = ResponseData.fromError(str3);
    if (!this.packageHandler.dropsOfflineActivities());
    while (true)
    {
      localResponseData.setWillRetry(bool);
      this.packageHandler.finishedTrackingActivity(paramActivityPackage, localResponseData);
      this.packageHandler.closeFirstPackage();
      return;
      bool = false;
    }
  }

  private String getReasonString(String paramString, Throwable paramThrowable)
  {
    if (paramThrowable != null)
      return String.format("%s: %s", new Object[] { paramString, paramThrowable });
    return String.format("%s", new Object[] { paramString });
  }

  private HttpUriRequest getRequest(ActivityPackage paramActivityPackage)
    throws UnsupportedEncodingException
  {
    HttpPost localHttpPost = new HttpPost("https://app.adjust.io" + paramActivityPackage.getPath());
    String str = Locale.getDefault().getLanguage();
    localHttpPost.addHeader("User-Agent", paramActivityPackage.getUserAgent());
    localHttpPost.addHeader("Client-SDK", paramActivityPackage.getClientSdk());
    localHttpPost.addHeader("Accept-Language", str);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramActivityPackage.getParameters().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    localArrayList.add(new BasicNameValuePair("sent_at", Util.dateFormat(System.currentTimeMillis())));
    UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(localArrayList);
    localUrlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
    localHttpPost.setEntity(localUrlEncodedFormEntity);
    return localHttpPost;
  }

  private void initInternal()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 60000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 60000);
    this.httpClient = AdjustFactory.getHttpClient(localBasicHttpParams);
  }

  private String parseResponse(HttpResponse paramHttpResponse)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramHttpResponse.getEntity().writeTo(localByteArrayOutputStream);
      localByteArrayOutputStream.close();
      String str = localByteArrayOutputStream.toString().trim();
      return str;
    }
    catch (Exception localException)
    {
      this.logger.error(String.format("Failed to parse response (%s)", new Object[] { localException }));
    }
    return "Failed to parse response";
  }

  private void requestFinished(HttpResponse paramHttpResponse, ActivityPackage paramActivityPackage)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    ResponseData localResponseData = ResponseData.fromJson(parseResponse(paramHttpResponse));
    if (200 == i)
    {
      localResponseData.setWasSuccess(true);
      this.logger.info(paramActivityPackage.getSuccessMessage());
    }
    while (true)
    {
      this.packageHandler.finishedTrackingActivity(paramActivityPackage, localResponseData);
      this.packageHandler.sendNextPackage();
      return;
      Logger localLogger = this.logger;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramActivityPackage.getFailureMessage();
      arrayOfObject[1] = localResponseData.getError();
      localLogger.error(String.format("%s. (%s)", arrayOfObject));
    }
  }

  private void sendInternal(ActivityPackage paramActivityPackage)
  {
    try
    {
      HttpUriRequest localHttpUriRequest = getRequest(paramActivityPackage);
      requestFinished(this.httpClient.execute(localHttpUriRequest), paramActivityPackage);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      sendNextPackage(paramActivityPackage, "Failed to encode parameters", localUnsupportedEncodingException);
      return;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      closePackage(paramActivityPackage, "Client protocol error", localClientProtocolException);
      return;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      closePackage(paramActivityPackage, "Request timed out", localSocketTimeoutException);
      return;
    }
    catch (IOException localIOException)
    {
      closePackage(paramActivityPackage, "Request failed", localIOException);
      return;
    }
    catch (Throwable localThrowable)
    {
      sendNextPackage(paramActivityPackage, "Runtime exception", localThrowable);
    }
  }

  private void sendNextPackage(ActivityPackage paramActivityPackage, String paramString, Throwable paramThrowable)
  {
    String str1 = paramActivityPackage.getFailureMessage();
    String str2 = getReasonString(paramString, paramThrowable);
    this.logger.error(String.format("%s. (%s)", new Object[] { str1, str2 }));
    ResponseData localResponseData = ResponseData.fromError(str2);
    this.packageHandler.finishedTrackingActivity(paramActivityPackage, localResponseData);
    this.packageHandler.sendNextPackage();
  }

  public void sendPackage(ActivityPackage paramActivityPackage)
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72400;
    localMessage.obj = paramActivityPackage;
    this.internalHandler.sendMessage(localMessage);
  }

  private static final class InternalHandler extends Handler
  {
    private static final int INIT = 72401;
    private static final int SEND = 72400;
    private final WeakReference<RequestHandler> requestHandlerReference;

    protected InternalHandler(Looper paramLooper, RequestHandler paramRequestHandler)
    {
      super();
      this.requestHandlerReference = new WeakReference(paramRequestHandler);
    }

    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      RequestHandler localRequestHandler = (RequestHandler)this.requestHandlerReference.get();
      if (localRequestHandler == null)
        return;
      switch (paramMessage.arg1)
      {
      default:
        return;
      case 72400:
        localRequestHandler.sendInternal((ActivityPackage)paramMessage.obj);
        return;
      case 72401:
      }
      localRequestHandler.initInternal();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.RequestHandler
 * JD-Core Version:    0.6.2
 */