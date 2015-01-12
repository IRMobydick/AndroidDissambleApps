package com.ubercab.client.core.network.events;

import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class ValidateAccountResponseEvent extends ResponseEvent<Map<String, Object>>
{
  private final Map<String, Object> mData;
  private final Map<String, String> mErrorHash;
  private boolean mIsSuccess;

  public ValidateAccountResponseEvent(Map<String, Object> paramMap, Response paramResponse)
  {
    super(paramMap, paramResponse);
    int i;
    Object localObject1;
    if (getResponse() != null)
    {
      i = getResponse().getStatus();
      boolean bool1 = super.isSuccess();
      boolean bool2 = false;
      if (bool1)
      {
        bool2 = false;
        if (i != 400)
        {
          bool2 = false;
          if (i != 401)
          {
            bool2 = false;
            if (i != 406)
              bool2 = true;
          }
        }
      }
      this.mIsSuccess = bool2;
      localObject1 = paramMap;
      if (!this.mIsSuccess)
        break label122;
    }
    label122: for (Object localObject2 = localObject1; ; localObject2 = new HashMap())
    {
      this.mData = ((Map)localObject2);
      if (this.mIsSuccess)
        localObject1 = new HashMap();
      this.mErrorHash = ((Map)localObject1);
      return;
      i = 0;
      break;
    }
  }

  public ValidateAccountResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
    this.mData = new HashMap();
    this.mErrorHash = ((Map)paramRetrofitError.getBodyAs(new TypeToken()
    {
    }
    .getType()));
  }

  public Map<String, Object> getData()
  {
    return this.mData;
  }

  public Map<String, String> getErrorHash()
  {
    return this.mErrorHash;
  }

  public boolean isSuccess()
  {
    return this.mIsSuccess;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.ValidateAccountResponseEvent
 * JD-Core Version:    0.6.2
 */