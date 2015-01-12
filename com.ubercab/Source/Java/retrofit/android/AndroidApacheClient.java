package retrofit.android;

import android.net.http.AndroidHttpClient;
import retrofit.client.ApacheClient;

public final class AndroidApacheClient extends ApacheClient
{
  public AndroidApacheClient()
  {
    super(AndroidHttpClient.newInstance("Retrofit"));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.android.AndroidApacheClient
 * JD-Core Version:    0.6.2
 */