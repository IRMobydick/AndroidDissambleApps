package com.ubercab.library.network;

import com.ubercab.library.app.UberPreferences;
import retrofit.Endpoint;

public class UberEndpoint
  implements Endpoint
{
  private FailoverStrategy mFailoverStrategy;
  private UberPreferences mUberPreferences;

  UberEndpoint(UberPreferences paramUberPreferences, FailoverStrategy paramFailoverStrategy)
  {
    this.mFailoverStrategy = paramFailoverStrategy;
    this.mUberPreferences = paramUberPreferences;
  }

  public FailoverStrategy getFailoverStrategy()
  {
    return this.mFailoverStrategy;
  }

  public String getName()
  {
    return this.mFailoverStrategy.getName();
  }

  public String getUrl()
  {
    if (this.mUberPreferences.hasCnEndpoint())
      return this.mUberPreferences.getCnEndpoint();
    return this.mFailoverStrategy.getUrl();
  }

  public void setFailoverStrategy(FailoverStrategy paramFailoverStrategy)
  {
    this.mFailoverStrategy = paramFailoverStrategy;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.UberEndpoint
 * JD-Core Version:    0.6.2
 */