package com.ubercab.library.network.dispatch;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.network.FailoverStrategy;
import com.ubercab.library.network.UberEndpoint;
import com.ubercab.library.network.dispatch.model.DispatchResponse;
import com.ubercab.library.util.DeviceUtils;
import com.ubercab.library.util.StringUtils;
import com.ubercab.library.util.TimeUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

public final class DispatchClient
{
  public static final String MESSAGE_TYPE_ERROR = "Error";
  public static final String MESSAGE_TYPE_NONE = "";
  public static final String MESSAGE_TYPE_OK = "OK";
  public static final String MESSAGE_TYPE_UPGRADE = "Upgrade";
  public static final int MODE_FIRE_AND_FORGET = 0;
  public static final int MODE_INTERRUPT_CANCEL = 1;
  public static final int MODE_INTERRUPT_CANCEL_DUPLICATE_ONLY = 2;
  public static final String PARAM_ALTITUDE = "altitude";
  public static final String PARAM_API_METHOD = "apiMethod";
  public static final String PARAM_API_METHOD_DELETE = "DELETE";
  public static final String PARAM_API_METHOD_GET = "GET";
  public static final String PARAM_API_METHOD_POST = "POST";
  public static final String PARAM_API_METHOD_PUT = "PUT";
  public static final String PARAM_API_PARAMETERS = "apiParameters";
  public static final String PARAM_API_URL = "apiUrl";
  public static final String PARAM_APP = "app";
  public static final String PARAM_CLIENT_ID = "clientID";
  public static final String PARAM_COURSE = "course";
  public static final String PARAM_DESCRIPTION = "description";
  public static final String PARAM_DEVICE = "device";
  public static final String PARAM_DEVICE_ID = "deviceId";
  public static final String PARAM_DEVICE_MOBILE_COUNTRY_ISO2 = "deviceMobileCountryIso2";
  public static final String PARAM_DEVICE_MOBILE_DIGITS = "deviceMobileDigits";
  public static final String PARAM_DEVICE_MODEL = "deviceModel";
  public static final String PARAM_DEVICE_OS = "deviceOS";
  public static final String PARAM_DEVICE_SERIAL_NUMBER = "deviceSerialNumber";
  public static final String PARAM_DEVICE_TYPE = "deviceType";
  public static final String PARAM_EPOCH = "epoch";
  public static final String PARAM_HORIZONTAL_ACCURACY = "horizontalAccuracy";
  public static final String PARAM_LANGUAGE = "language";
  public static final String PARAM_LATITUDE = "latitude";
  public static final String PARAM_LONGITUDE = "longitude";
  public static final String PARAM_MESSAGE = "message";
  public static final String PARAM_MESSAGE_TYPE = "messageType";
  public static final String PARAM_SPEED = "speed";
  public static final String PARAM_TOKEN = "token";
  public static final String PARAM_VERSION = "version";
  private static final int RELIABLE_QUEUE_SIZE = 1;
  private static final int REQUEST_ATTEMPT_MAX = 3;
  private BuildConfigProxy mAppBuildConfig;
  private final List<DispatchCallback> mCallbacks = new CopyOnWriteArrayList();
  private Context mContext;
  private DispatchApi mDispatchApi;
  private final List<DispatchParameterInterceptor> mDispatchParameterInterceptor = new CopyOnWriteArrayList();
  private UberPreferences mPreferences;
  private final Queue<InternalCallback> mReliableQueue = new ArrayBlockingQueue(1);
  private UberEndpoint mUberEndpoint;

  public DispatchClient(Context paramContext, DispatchApi paramDispatchApi, UberEndpoint paramUberEndpoint, BuildConfigProxy paramBuildConfigProxy, UberPreferences paramUberPreferences)
  {
    this.mContext = paramContext;
    this.mPreferences = paramUberPreferences;
    this.mAppBuildConfig = paramBuildConfigProxy;
    this.mDispatchApi = paramDispatchApi;
    this.mUberEndpoint = paramUberEndpoint;
  }

  private Map<String, Object> addGlobalBodyParameters(DispatchRequest paramDispatchRequest)
  {
    HashMap localHashMap = new HashMap(paramDispatchRequest.getParameters());
    localHashMap.put("app", this.mAppBuildConfig.getAppName());
    localHashMap.put("device", "android");
    localHashMap.put("deviceId", StringUtils.md5(DeviceUtils.getDeviceId(this.mContext)));
    localHashMap.put("deviceMobileDigits", DeviceUtils.getPhoneNumber(this.mContext));
    localHashMap.put("deviceMobileCountryIso2", DeviceUtils.getPhoneNumberCountryIso2(this.mContext));
    localHashMap.put("deviceModel", Build.MODEL);
    localHashMap.put("deviceOS", Build.VERSION.RELEASE);
    localHashMap.put("deviceSerialNumber", Build.SERIAL);
    localHashMap.put("epoch", Long.valueOf(TimeUtils.getEpochTimeMs()));
    localHashMap.put("language", DeviceUtils.getDeviceLanguage());
    if (this.mPreferences.hasFakeVersion())
    {
      localHashMap.put("version", this.mPreferences.getFakeVersion());
      return localHashMap;
    }
    localHashMap.put("version", this.mAppBuildConfig.getVersionName());
    return localHashMap;
  }

  private void enqueue(DispatchRequest paramDispatchRequest)
  {
    synchronized (this.mReliableQueue)
    {
      InternalCallback localInternalCallback = new InternalCallback(paramDispatchRequest);
      if (!this.mReliableQueue.isEmpty())
        ((InternalCallback)this.mReliableQueue.remove()).detach();
      this.mReliableQueue.add(localInternalCallback);
      executeRequest(paramDispatchRequest, localInternalCallback);
      return;
    }
  }

  private void executeRequest(DispatchRequest paramDispatchRequest, Callback paramCallback)
  {
    Map localMap = addGlobalBodyParameters(paramDispatchRequest);
    Iterator localIterator = this.mDispatchParameterInterceptor.iterator();
    while (localIterator.hasNext())
      ((DispatchParameterInterceptor)localIterator.next()).onInterceptRequestParameters(localMap);
    if (localMap.containsKey("token"))
    {
      this.mDispatchApi.request(localMap, (String)localMap.get("token"), paramCallback);
      return;
    }
    this.mDispatchApi.request(localMap, paramCallback);
  }

  public void addCallback(DispatchCallback paramDispatchCallback)
  {
    this.mCallbacks.add(paramDispatchCallback);
  }

  public void addParameterInterceptor(DispatchParameterInterceptor paramDispatchParameterInterceptor)
  {
    this.mDispatchParameterInterceptor.add(paramDispatchParameterInterceptor);
  }

  public void dequeue(DispatchRequest paramDispatchRequest)
  {
    synchronized (this.mReliableQueue)
    {
      if ((!this.mReliableQueue.isEmpty()) && (((InternalCallback)this.mReliableQueue.peek()).getRequest() == paramDispatchRequest))
        ((InternalCallback)this.mReliableQueue.remove()).detach();
      return;
    }
  }

  public boolean execute(DispatchRequest paramDispatchRequest)
  {
    if (paramDispatchRequest.getMode() == 0)
    {
      executeRequest(paramDispatchRequest, new InternalCallback(paramDispatchRequest));
      return true;
    }
    if (paramDispatchRequest.getMode() == 1)
    {
      enqueue(paramDispatchRequest);
      return true;
    }
    if (paramDispatchRequest.getMode() == 2)
      synchronized (this.mReliableQueue)
      {
        if (this.mReliableQueue.isEmpty())
        {
          enqueue(paramDispatchRequest);
          return true;
        }
        if (paramDispatchRequest.getMessageType().equals(((InternalCallback)this.mReliableQueue.peek()).getRequest().getMessageType()))
        {
          enqueue(paramDispatchRequest);
          return true;
        }
      }
    return false;
  }

  public void removeCallback(DispatchCallback paramDispatchCallback)
  {
    this.mCallbacks.remove(paramDispatchCallback);
  }

  public void removeParameterInterceptor(DispatchParameterInterceptor paramDispatchParameterInterceptor)
  {
    this.mDispatchParameterInterceptor.remove(paramDispatchParameterInterceptor);
  }

  private class InternalCallback
    implements Callback<DispatchResponse>
  {
    private boolean mDetached;
    private DispatchRequest mRequest;
    private int mRequestAttempts;

    public InternalCallback(DispatchRequest arg2)
    {
      Object localObject;
      this.mRequest = localObject;
    }

    public void detach()
    {
      this.mDetached = true;
    }

    public void failure(RetrofitError paramRetrofitError)
    {
      if (this.mDetached);
      label180: label186: DispatchCallback localDispatchCallback;
      do
      {
        return;
        if (this.mRequest.getMode() != 0)
        {
          int i;
          int j;
          if (paramRetrofitError.getResponse() == null)
          {
            i = 0;
            if ((i != 0) && ((i < 400) || (i > 499)))
              break label180;
            j = 1;
          }
          while (true)
            if (j != 0)
            {
              int k = 1 + this.mRequestAttempts;
              this.mRequestAttempts = k;
              if (k < 3)
              {
                DispatchClient.this.mUberEndpoint.getFailoverStrategy().changeEndpoint();
                synchronized (DispatchClient.this.mReliableQueue)
                {
                  if ((DispatchClient.this.mReliableQueue.isEmpty()) || (((InternalCallback)DispatchClient.this.mReliableQueue.peek()).getRequest() != this.mRequest))
                    break label186;
                  DispatchClient.this.executeRequest(this.mRequest, this);
                  return;
                }
                i = paramRetrofitError.getResponse().getStatus();
                break;
                j = 0;
              }
            }
        }
        DispatchClient.this.dequeue(this.mRequest);
        if (!paramRetrofitError.isNetworkError())
          Timber.d("Retrofit Error: " + paramRetrofitError.getMessage(), new Object[0]);
        Iterator localIterator = DispatchClient.this.mCallbacks.iterator();
        while (localIterator.hasNext())
          ((DispatchCallback)localIterator.next()).onDispatchNetworkError(this.mRequest, paramRetrofitError);
        localDispatchCallback = this.mRequest.getCallback();
      }
      while (localDispatchCallback == null);
      localDispatchCallback.onDispatchNetworkError(this.mRequest, paramRetrofitError);
    }

    public DispatchRequest getRequest()
    {
      return this.mRequest;
    }

    public void success(DispatchResponse paramDispatchResponse, Response paramResponse)
    {
      if (this.mDetached);
      DispatchCallback localDispatchCallback;
      do
      {
        do
        {
          return;
          DispatchClient.this.dequeue(this.mRequest);
          localDispatchCallback = this.mRequest.getCallback();
          String str = paramDispatchResponse.getMessageType();
          int i = -1;
          switch (str.hashCode())
          {
          default:
          case 2524:
          case 1433481724:
          case 67232232:
          }
          while (true)
            switch (i)
            {
            default:
              return;
            case 0:
            case 1:
              Iterator localIterator2 = DispatchClient.this.mCallbacks.iterator();
              while (localIterator2.hasNext())
                ((DispatchCallback)localIterator2.next()).onDispatchSuccess(this.mRequest, paramDispatchResponse, paramResponse);
              if (str.equals("OK"))
              {
                i = 0;
                continue;
                if (str.equals("Upgrade"))
                {
                  i = 1;
                  continue;
                  if (str.equals("Error"))
                    i = 2;
                }
              }
              break;
            case 2:
            }
        }
        while (localDispatchCallback == null);
        localDispatchCallback.onDispatchSuccess(this.mRequest, paramDispatchResponse, paramResponse);
        return;
        Iterator localIterator1 = DispatchClient.this.mCallbacks.iterator();
        while (localIterator1.hasNext())
          ((DispatchCallback)localIterator1.next()).onDispatchError(this.mRequest, paramDispatchResponse, paramResponse);
      }
      while (localDispatchCallback == null);
      localDispatchCallback.onDispatchError(this.mRequest, paramDispatchResponse, paramResponse);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.dispatch.DispatchClient
 * JD-Core Version:    0.6.2
 */