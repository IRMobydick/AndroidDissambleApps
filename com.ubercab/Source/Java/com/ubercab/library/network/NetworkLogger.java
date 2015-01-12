package com.ubercab.library.network;

import android.content.Context;
import android.text.TextUtils;
import com.ubercab.common.collect.ImmutableList;
import com.ubercab.library.app.BuildConfigProxy;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedByteArray;
import timber.log.Timber;
import timber.log.Timber.Tree;

public final class NetworkLogger
  implements UberRetrofitClient.Listener
{
  private static final String EOL = String.format("%n", new Object[0]);
  private static final int LOGCAT_CHUNK_SIZE = 4000;
  private static final String LOGCAT_TAG = "Cn";
  private static final List<String> SHORTLOG_HEADERS = ImmutableList.of("Data");
  private final BuildConfigProxy mAppBuildConfig;
  private final ExecutorService mExecutorService;
  private NetworkLog mNetworkLog;

  public NetworkLogger(Context paramContext, ExecutorService paramExecutorService, BuildConfigProxy paramBuildConfigProxy)
  {
    this.mNetworkLog = new NetworkLog(paramContext, paramExecutorService);
    this.mExecutorService = paramExecutorService;
    this.mAppBuildConfig = paramBuildConfigProxy;
  }

  private int createBodyLog(StringBuilder paramStringBuilder, TypedByteArray paramTypedByteArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramTypedByteArray == null)
      i = 0;
    String str1;
    while (true)
    {
      return i;
      i = paramTypedByteArray.getBytes().length;
      if (i == 0)
        return 0;
      if (paramBoolean1)
        paramStringBuilder.append(EOL);
      str1 = extractBodyString(paramTypedByteArray);
      if ((paramTypedByteArray.mimeType().startsWith("application/json")) && (paramBoolean2))
        try
        {
          JSONObject localJSONObject = new JSONObject(str1);
          String str2 = localJSONObject.optString("description", "");
          String str3 = localJSONObject.optString("errorCode", "");
          String str4 = localJSONObject.optString("messageType", "");
          if (!TextUtils.isEmpty(str2))
            paramStringBuilder.append("Error: ").append(str2).append(EOL);
          if (!TextUtils.isEmpty(str3))
            paramStringBuilder.append("ErrorCode: ").append(str3).append(EOL);
          if (!TextUtils.isEmpty(str4))
          {
            paramStringBuilder.append("MessageType: ").append(str4).append(EOL);
            return i;
          }
        }
        catch (JSONException localJSONException)
        {
          Timber.e(localJSONException, "Failed to parse request body json.", new Object[0]);
          return i;
        }
    }
    paramStringBuilder.append(str1).append(EOL);
    return i;
  }

  private boolean createHeadersLog(StringBuilder paramStringBuilder, List<Header> paramList, boolean paramBoolean)
  {
    boolean bool = false;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Header localHeader = (Header)localIterator.next();
      if ((!paramBoolean) || (SHORTLOG_HEADERS.contains(localHeader.getName())))
      {
        if (!TextUtils.isEmpty(localHeader.getName()))
          paramStringBuilder.append(localHeader.getName()).append(": ");
        paramStringBuilder.append(localHeader.getValue()).append(EOL);
        bool = true;
      }
    }
    return bool;
  }

  private void createRequestLog(StringBuilder paramStringBuilder, Request paramRequest, boolean paramBoolean)
  {
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = paramRequest.getMethod();
    arrayOfObject1[1] = paramRequest.getUrl();
    paramStringBuilder.append(String.format("---> HTTP %s %s", arrayOfObject1)).append(EOL);
    boolean bool = createHeadersLog(paramStringBuilder, paramRequest.getHeaders(), paramBoolean);
    int i = createBodyLog(paramStringBuilder, (TypedByteArray)paramRequest.getBody(), bool, paramBoolean);
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Integer.valueOf(i);
    paramStringBuilder.append(String.format("---> END HTTP (%s-byte body)", arrayOfObject2));
  }

  private void createResponseLog(StringBuilder paramStringBuilder, String paramString, Response paramResponse, long paramLong, boolean paramBoolean)
  {
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = Integer.valueOf(paramResponse.getStatus());
    arrayOfObject1[1] = paramString;
    arrayOfObject1[2] = Long.valueOf(paramLong);
    paramStringBuilder.append(String.format("<--- HTTP %s %s (%sms)", arrayOfObject1)).append(EOL);
    boolean bool = createHeadersLog(paramStringBuilder, paramResponse.getHeaders(), paramBoolean);
    int i = createBodyLog(paramStringBuilder, (TypedByteArray)paramResponse.getBody(), bool, paramBoolean);
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Integer.valueOf(i);
    paramStringBuilder.append(String.format("<--- END HTTP (%s-byte body)", arrayOfObject2));
  }

  private String extractBodyString(TypedByteArray paramTypedByteArray)
  {
    try
    {
      String str1 = MimeUtil.parseCharset(paramTypedByteArray.mimeType());
      String str2 = new String(paramTypedByteArray.getBytes(), str1);
      return str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return "";
  }

  private String prefixLines(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Scanner localScanner = new Scanner(paramString1);
    while (localScanner.hasNextLine())
    {
      String str = localScanner.nextLine();
      localStringBuilder.append(paramString2).append(" ").append(str);
      if (localScanner.hasNext())
        localStringBuilder.append(EOL);
    }
    return localStringBuilder.toString();
  }

  private void writeToLogcat(String paramString)
  {
    if (!this.mAppBuildConfig.isDebug());
    while (true)
    {
      return;
      int i = 0;
      int j = paramString.length();
      while (i < j)
      {
        int k = Math.min(j, i + 4000);
        Timber.tag("Cn").d(paramString.substring(i, k), new Object[0]);
        i += 4000;
      }
    }
  }

  public NetworkLog getNetworkLog()
  {
    return this.mNetworkLog;
  }

  public void onNetworkError(final String paramString, Request paramRequest, final IOException paramIOException, long paramLong)
  {
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          StringBuilder localStringBuilder2 = new StringBuilder();
          String str1 = paramIOException.getClass().getName();
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = str1;
          arrayOfObject2[1] = paramIOException.getMessage();
          String str2 = String.format("<--- ERROR: %s %s", arrayOfObject2);
          String str3 = TextUtils.join(NetworkLogger.EOL, paramIOException.getStackTrace());
          localStringBuilder1.append(NetworkLogger.this.prefixLines(str2, paramString)).append(NetworkLogger.EOL).append(NetworkLogger.this.prefixLines(str3, paramString));
          localStringBuilder2.append(NetworkLogger.this.prefixLines(str2, paramString));
          String str4 = localStringBuilder1.toString();
          NetworkLogger.this.mNetworkLog.putLongLog(str4);
          NetworkLogger.this.mNetworkLog.putShortLog(localStringBuilder2.toString());
          NetworkLogger.this.writeToLogcat(str4);
          return;
        }
        catch (Exception localException)
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = paramString;
          Timber.e(localException, "Failed to parse network error: %s", arrayOfObject1);
        }
      }
    });
  }

  public void onRequest(final String paramString, final Request paramRequest)
  {
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          StringBuilder localStringBuilder2 = new StringBuilder();
          NetworkLogger.this.createRequestLog(localStringBuilder1, paramRequest, false);
          NetworkLogger.this.createRequestLog(localStringBuilder2, paramRequest, true);
          String str = NetworkLogger.this.prefixLines(localStringBuilder1.toString(), paramString);
          NetworkLogger.this.mNetworkLog.putLongLog(str);
          NetworkLogger.this.mNetworkLog.putShortLog(NetworkLogger.this.prefixLines(localStringBuilder2.toString(), paramString));
          NetworkLogger.this.writeToLogcat(str);
          return;
        }
        catch (Exception localException)
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = paramString;
          Timber.e(localException, "Failed to process request: %s", arrayOfObject);
        }
      }
    });
  }

  public void onResponse(String paramString, final Request paramRequest, final Response paramResponse, final long paramLong)
  {
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          StringBuilder localStringBuilder2 = new StringBuilder();
          NetworkLogger.this.createResponseLog(localStringBuilder1, paramRequest.getUrl(), paramResponse, paramLong, false);
          NetworkLogger.this.createResponseLog(localStringBuilder2, paramRequest.getUrl(), paramResponse, paramLong, true);
          String str = NetworkLogger.this.prefixLines(localStringBuilder1.toString(), this.val$id);
          NetworkLogger.this.mNetworkLog.putLongLog(str);
          NetworkLogger.this.mNetworkLog.putShortLog(NetworkLogger.this.prefixLines(localStringBuilder2.toString(), this.val$id));
          NetworkLogger.this.writeToLogcat(str);
          return;
        }
        catch (Exception localException)
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = this.val$id;
          Timber.e(localException, "Failed to process response: %s", arrayOfObject);
        }
      }
    });
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.NetworkLogger
 * JD-Core Version:    0.6.2
 */