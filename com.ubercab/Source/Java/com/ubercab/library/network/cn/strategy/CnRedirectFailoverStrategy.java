package com.ubercab.library.network.cn.strategy;

import com.ubercab.library.network.FailoverStrategy;
import com.ubercab.library.util.NetworkUtils;
import java.net.MalformedURLException;
import java.net.URL;
import retrofit.client.Response;
import timber.log.Timber;

public class CnRedirectFailoverStrategy
  implements FailoverStrategy
{
  private static final String DEFAULT_URL = "https://cn-dc1.uber.com/";
  public static final String NAME = "cnRedirect";
  private String mCnEndpointUrl = "https://cn-dc1.uber.com/";

  public void changeEndpoint()
  {
  }

  public String getName()
  {
    return "cnRedirect";
  }

  public String getUrl()
  {
    return this.mCnEndpointUrl;
  }

  public boolean interceptResponse(Response paramResponse)
  {
    if (paramResponse.getStatus() == 307)
    {
      String str = NetworkUtils.getHeaderValue("Location", paramResponse);
      if (str != null)
        try
        {
          URL localURL = new URL(str);
          this.mCnEndpointUrl = (localURL.getProtocol() + "://" + localURL.getHost() + "/");
          return true;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          Timber.e("Unable to parse redirect URL, not going to persist.", new Object[] { localMalformedURLException });
        }
    }
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.cn.strategy.CnRedirectFailoverStrategy
 * JD-Core Version:    0.6.2
 */