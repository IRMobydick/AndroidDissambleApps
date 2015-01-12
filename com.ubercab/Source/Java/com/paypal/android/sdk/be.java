package com.paypal.android.sdk;

import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class be
  implements X509TrustManager
{
  private X509TrustManager a = null;

  public be(KeyStore paramKeyStore)
  {
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    localTrustManagerFactory.init(null);
    TrustManager[] arrayOfTrustManager = localTrustManagerFactory.getTrustManagers();
    if (arrayOfTrustManager.length == 0)
      throw new NoSuchAlgorithmException("no trust manager found");
    this.a = ((X509TrustManager)arrayOfTrustManager[0]);
  }

  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }

  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if ((paramArrayOfX509Certificate != null) && (paramArrayOfX509Certificate.length == 1))
    {
      paramArrayOfX509Certificate[0].checkValidity();
      return;
    }
    this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }

  public final X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.be
 * JD-Core Version:    0.6.2
 */