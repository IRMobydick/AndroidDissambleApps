package com.ubercab.library.location.client;

import com.ubercab.common.collect.ImmutableList;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.location.model.UberLocationRequest;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class IUberLocationClient
{
  private final List<UberLocationListener> mUberLocationListeners = new CopyOnWriteArrayList();
  private UberLocationRequest mUberLocationRequest = UberLocationRequest.create();

  public abstract void connect();

  public abstract void disconnect();

  public abstract UberLocation getLastKnownLocation();

  public abstract String getLocationClientName();

  public UberLocationRequest getLocationRequest()
  {
    try
    {
      UberLocationRequest localUberLocationRequest = this.mUberLocationRequest;
      return localUberLocationRequest;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public List<UberLocationListener> getUberLocationListeners()
  {
    return ImmutableList.copyOf(this.mUberLocationListeners);
  }

  public abstract boolean isConnected();

  public void registerLocationListener(UberLocationListener paramUberLocationListener)
  {
    if (!this.mUberLocationListeners.contains(paramUberLocationListener))
      this.mUberLocationListeners.add(paramUberLocationListener);
  }

  public void setLocationRequest(UberLocationRequest paramUberLocationRequest)
  {
    try
    {
      this.mUberLocationRequest = paramUberLocationRequest;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void unregisterLocationListener(UberLocationListener paramUberLocationListener)
  {
    this.mUberLocationListeners.remove(paramUberLocationListener);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.location.client.IUberLocationClient
 * JD-Core Version:    0.6.2
 */