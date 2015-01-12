package com.squareup.okhttp.internal.tls;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class OkHostnameVerifier
  implements HostnameVerifier
{
  private static final int ALT_DNS_NAME = 2;
  private static final int ALT_IPA_NAME = 7;
  public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();
  private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

  private List<String> getSubjectAltNames(X509Certificate paramX509Certificate, int paramInt)
  {
    Object localObject = new ArrayList();
    try
    {
      Collection localCollection = paramX509Certificate.getSubjectAlternativeNames();
      if (localCollection == null)
        return Collections.emptyList();
      Iterator localIterator = localCollection.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localIterator.next();
        if ((localList != null) && (localList.size() >= 2))
        {
          Integer localInteger = (Integer)localList.get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            String str = (String)localList.get(1);
            if (str != null)
              ((List)localObject).add(str);
          }
        }
      }
    }
    catch (CertificateParsingException localCertificateParsingException)
    {
      localObject = Collections.emptyList();
    }
    return localObject;
  }

  static boolean verifyAsIpAddress(String paramString)
  {
    return VERIFY_AS_IP_ADDRESS.matcher(paramString).matches();
  }

  private boolean verifyHostName(String paramString, X509Certificate paramX509Certificate)
  {
    String str1 = paramString.toLowerCase(Locale.US);
    int i = 0;
    Iterator localIterator = getSubjectAltNames(paramX509Certificate, 2).iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      i = 1;
      if (verifyHostName(str1, str3))
        return true;
    }
    if (i == 0)
    {
      String str2 = new DistinguishedNameParser(paramX509Certificate.getSubjectX500Principal()).findMostSpecific("cn");
      if (str2 != null)
        return verifyHostName(str1, str2);
    }
    return false;
  }

  private boolean verifyIpAddress(String paramString, X509Certificate paramX509Certificate)
  {
    Iterator localIterator = getSubjectAltNames(paramX509Certificate, 7).iterator();
    while (localIterator.hasNext())
      if (paramString.equalsIgnoreCase((String)localIterator.next()))
        return true;
    return false;
  }

  public boolean verify(String paramString, X509Certificate paramX509Certificate)
  {
    if (verifyAsIpAddress(paramString))
      return verifyIpAddress(paramString, paramX509Certificate);
    return verifyHostName(paramString, paramX509Certificate);
  }

  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      boolean bool = verify(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return bool;
    }
    catch (SSLException localSSLException)
    {
    }
    return false;
  }

  public boolean verifyHostName(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
      bool = false;
    String str;
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return bool;
        str = paramString2.toLowerCase(Locale.US);
        if (!str.contains("*"))
          return paramString1.equals(str);
      }
      while ((str.startsWith("*.")) && (paramString1.regionMatches(0, str, 2, -2 + str.length())));
      i = str.indexOf('*');
      if (i > str.indexOf('.'))
        return false;
      if (!paramString1.regionMatches(0, str, 0, i))
        return false;
      j = str.length() - (i + 1);
      k = paramString1.length() - j;
      if (paramString1.indexOf('.', i) < k)
        return false;
    }
    while (paramString1.regionMatches(k, str, i + 1, j));
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.tls.OkHostnameVerifier
 * JD-Core Version:    0.6.2
 */