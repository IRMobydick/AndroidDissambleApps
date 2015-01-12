package com.crashlytics.android.internal;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.security.auth.x500.X500Principal;

public class av
{
  private final q a;
  private aG b;
  private SSLSocketFactory c;
  private boolean d;

  public av()
  {
    this(new r());
  }

  public av(q paramq)
  {
    this.a = paramq;
  }

  private void a()
  {
    try
    {
      this.d = false;
      this.c = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static boolean a(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    if (!paramX509Certificate1.getSubjectX500Principal().equals(paramX509Certificate2.getIssuerX500Principal()))
      return false;
    try
    {
      paramX509Certificate2.verify(paramX509Certificate1.getPublicKey());
      return true;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
    }
    return false;
  }

  public static X509Certificate[] a(X509Certificate[] paramArrayOfX509Certificate, aI paramaI)
    throws CertificateException
  {
    int i = 1;
    LinkedList localLinkedList = new LinkedList();
    if (paramaI.a(paramArrayOfX509Certificate[0]));
    for (int j = i; ; j = 0)
    {
      localLinkedList.add(paramArrayOfX509Certificate[0]);
      int k = j;
      for (int m = i; m < paramArrayOfX509Certificate.length; m++)
      {
        if (paramaI.a(paramArrayOfX509Certificate[m]))
          k = i;
        if (!a(paramArrayOfX509Certificate[m], paramArrayOfX509Certificate[(m - 1)]))
          break;
        localLinkedList.add(paramArrayOfX509Certificate[m]);
      }
      X509Certificate localX509Certificate = paramaI.b(paramArrayOfX509Certificate[(m - 1)]);
      if (localX509Certificate != null)
        localLinkedList.add(localX509Certificate);
      while (true)
      {
        if (i != 0)
          return (X509Certificate[])localLinkedList.toArray(new X509Certificate[localLinkedList.size()]);
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
        i = k;
      }
    }
  }

  private SSLSocketFactory b()
  {
    try
    {
      if ((this.c == null) && (!this.d))
        this.c = c();
      SSLSocketFactory localSSLSocketFactory = this.c;
      return localSSLSocketFactory;
    }
    finally
    {
    }
  }

  private SSLSocketFactory c()
  {
    try
    {
      this.d = true;
      try
      {
        aG localaG = this.b;
        SSLContext localSSLContext = SSLContext.getInstance("TLS");
        localSSLContext.init(null, new TrustManager[] { new aH(new aI(localaG.a(), localaG.b()), localaG) }, null);
        localSSLSocketFactory = localSSLContext.getSocketFactory();
        this.a.a("Crashlytics", "Custom SSL pinning enabled");
        return localSSLSocketFactory;
      }
      catch (Exception localException)
      {
        while (true)
        {
          this.a.a("Crashlytics", "Exception while validating pinned certs", localException);
          SSLSocketFactory localSSLSocketFactory = null;
        }
      }
    }
    finally
    {
    }
  }

  public ay a(ax paramax, String paramString)
  {
    return a(paramax, paramString, Collections.emptyMap());
  }

  public ay a(ax paramax, String paramString, Map<String, String> paramMap)
  {
    ay localay;
    switch (aw.a[paramax.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unsupported HTTP method!");
    case 1:
      localay = ay.a(paramString, paramMap, true);
      if (paramString != null)
        break;
    case 2:
    case 3:
    case 4:
    }
    for (boolean bool = false; ; bool = paramString.toLowerCase().startsWith("https"))
    {
      if ((bool) && (this.b != null))
      {
        SSLSocketFactory localSSLSocketFactory = b();
        if (localSSLSocketFactory != null)
          ((HttpsURLConnection)localay.a()).setSSLSocketFactory(localSSLSocketFactory);
      }
      return localay;
      localay = ay.b(paramString, paramMap, true);
      break;
      localay = ay.a(paramString);
      break;
      localay = ay.b(paramString);
      break;
    }
  }

  public void a(aG paramaG)
  {
    if (this.b != paramaG)
    {
      this.b = paramaG;
      a();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.av
 * JD-Core Version:    0.6.2
 */