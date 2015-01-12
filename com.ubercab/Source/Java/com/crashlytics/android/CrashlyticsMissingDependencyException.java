package com.crashlytics.android;

import com.crashlytics.android.internal.q;
import com.crashlytics.android.internal.v;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CrashlyticsMissingDependencyException extends RuntimeException
{
  private static final long serialVersionUID = -1151536370019872859L;

  CrashlyticsMissingDependencyException(String paramString1, String paramString2)
  {
    super(a(paramString1, paramString2));
  }

  private static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    try
    {
      localStringBuilder1.append("\nThis app relies on Crashlytics. Configure your build environment here: \n");
      StringBuilder localStringBuilder2 = new StringBuilder();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = URLEncoder.encode(paramString1, "UTF-8");
      arrayOfObject[1] = URLEncoder.encode(paramString2, "UTF-8");
      localStringBuilder1.append(String.format("https://crashlytics.com/register/%s/android/%s", arrayOfObject) + "\n");
      return localStringBuilder1.toString();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        v.a().b().a("Crashlytics", "Could not find UTF-8 encoding.", localUnsupportedEncodingException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.CrashlyticsMissingDependencyException
 * JD-Core Version:    0.6.2
 */