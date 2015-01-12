package com.ubercab.library.metrics.monitoring;

import android.net.Uri;
import android.text.TextUtils;
import com.ubercab.library.network.UberRetrofitClient.Listener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedByteArray;

public class MonitoringListener
  implements UberRetrofitClient.Listener
{
  private static final String JSON_MIME_TYPE = "application/json";
  private MonitoringClient mMonitoringClient;

  public MonitoringListener(MonitoringClient paramMonitoringClient)
  {
    this.mMonitoringClient = paramMonitoringClient;
  }

  private void addRequestBodyDetails(String paramString, MonitoringEvent.Builder paramBuilder)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      String str1 = localJSONObject.optString("messageType");
      String str2 = localJSONObject.optString("apiUrl");
      if (!TextUtils.isEmpty(str1))
        paramBuilder.setMessageType(str1);
      if (!TextUtils.isEmpty(str2))
        paramBuilder.setApiCommandPath(str2);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void addRequestDetailsToBuilder(MonitoringEvent.Builder paramBuilder, Request paramRequest)
  {
    Uri localUri = Uri.parse(paramRequest.getUrl());
    paramBuilder.setHostname(localUri.getScheme() + "://" + localUri.getHost());
    paramBuilder.setPath(localUri.getPath());
    paramBuilder.setMethod(paramRequest.getMethod());
    paramBuilder.setResponseType("response");
    TypedByteArray localTypedByteArray = (TypedByteArray)paramRequest.getBody();
    if ((localTypedByteArray != null) && (localTypedByteArray.mimeType().startsWith("application/json")))
      addRequestBodyDetails(extractBodyString(localTypedByteArray), paramBuilder);
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

  public void onNetworkError(String paramString, Request paramRequest, IOException paramIOException, long paramLong)
  {
    MonitoringEvent.Builder localBuilder = new MonitoringEvent.Builder();
    addRequestDetailsToBuilder(localBuilder, paramRequest);
    if ((paramIOException.getCause() != null) && (paramIOException.getCause().getClass().equals(UnknownHostException.class)))
      localBuilder.setResponseType("no_service");
    while (true)
    {
      localBuilder.setRoundtripTimeMs(paramLong);
      this.mMonitoringClient.addEvent(localBuilder.build());
      return;
      localBuilder.setResponseType("timeout");
    }
  }

  public void onRequest(String paramString, Request paramRequest)
  {
  }

  public void onResponse(String paramString, Request paramRequest, Response paramResponse, long paramLong)
  {
    MonitoringEvent.Builder localBuilder = new MonitoringEvent.Builder();
    addRequestDetailsToBuilder(localBuilder, paramRequest);
    localBuilder.setResponseType("response");
    localBuilder.setRoundtripTimeMs(paramLong);
    localBuilder.setStatusCode(paramResponse.getStatus());
    this.mMonitoringClient.addEvent(localBuilder.build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.monitoring.MonitoringListener
 * JD-Core Version:    0.6.2
 */