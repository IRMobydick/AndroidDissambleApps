package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HeaderParser;

public final class CacheControl
{
  private final boolean isPublic;
  private final int maxAgeSeconds;
  private final int maxStaleSeconds;
  private final int minFreshSeconds;
  private final boolean mustRevalidate;
  private final boolean noCache;
  private final boolean noStore;
  private final boolean onlyIfCached;
  private final int sMaxAgeSeconds;

  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3, int paramInt4, boolean paramBoolean5)
  {
    this.noCache = paramBoolean1;
    this.noStore = paramBoolean2;
    this.maxAgeSeconds = paramInt1;
    this.sMaxAgeSeconds = paramInt2;
    this.isPublic = paramBoolean3;
    this.mustRevalidate = paramBoolean4;
    this.maxStaleSeconds = paramInt3;
    this.minFreshSeconds = paramInt4;
    this.onlyIfCached = paramBoolean5;
  }

  public static CacheControl parse(Headers paramHeaders)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    int i = -1;
    int j = -1;
    boolean bool3 = false;
    boolean bool4 = false;
    int k = -1;
    int m = -1;
    boolean bool5 = false;
    int n = 0;
    while (n < paramHeaders.size())
      if ((!paramHeaders.name(n).equalsIgnoreCase("Cache-Control")) && (!paramHeaders.name(n).equalsIgnoreCase("Pragma")))
      {
        n++;
      }
      else
      {
        String str1 = paramHeaders.value(n);
        int i1 = 0;
        while (true)
        {
          int i2 = str1.length();
          if (i1 >= i2)
            break;
          int i3 = i1;
          int i4 = HeaderParser.skipUntil(str1, i1, "=,;");
          String str2 = str1.substring(i3, i4).trim();
          String str3;
          if ((i4 == str1.length()) || (str1.charAt(i4) == ',') || (str1.charAt(i4) == ';'))
          {
            i1 = i4 + 1;
            str3 = null;
          }
          while (true)
          {
            if (!"no-cache".equalsIgnoreCase(str2))
              break label280;
            bool1 = true;
            break;
            int i5 = HeaderParser.skipWhitespace(str1, i4 + 1);
            if ((i5 < str1.length()) && (str1.charAt(i5) == '"'))
            {
              int i6 = i5 + 1;
              int i7 = HeaderParser.skipUntil(str1, i6, "\"");
              str3 = str1.substring(i6, i7);
              i1 = i7 + 1;
            }
            else
            {
              i1 = HeaderParser.skipUntil(str1, i5, ",;");
              str3 = str1.substring(i5, i1).trim();
            }
          }
          label280: if ("no-store".equalsIgnoreCase(str2))
            bool2 = true;
          else if ("max-age".equalsIgnoreCase(str2))
            i = HeaderParser.parseSeconds(str3);
          else if ("s-maxage".equalsIgnoreCase(str2))
            j = HeaderParser.parseSeconds(str3);
          else if ("public".equalsIgnoreCase(str2))
            bool3 = true;
          else if ("must-revalidate".equalsIgnoreCase(str2))
            bool4 = true;
          else if ("max-stale".equalsIgnoreCase(str2))
            k = HeaderParser.parseSeconds(str3);
          else if ("min-fresh".equalsIgnoreCase(str2))
            m = HeaderParser.parseSeconds(str3);
          else if ("only-if-cached".equalsIgnoreCase(str2))
            bool5 = true;
        }
      }
    return new CacheControl(bool1, bool2, i, j, bool3, bool4, k, m, bool5);
  }

  public boolean isPublic()
  {
    return this.isPublic;
  }

  public int maxAgeSeconds()
  {
    return this.maxAgeSeconds;
  }

  public int maxStaleSeconds()
  {
    return this.maxStaleSeconds;
  }

  public int minFreshSeconds()
  {
    return this.minFreshSeconds;
  }

  public boolean mustRevalidate()
  {
    return this.mustRevalidate;
  }

  public boolean noCache()
  {
    return this.noCache;
  }

  public boolean noStore()
  {
    return this.noStore;
  }

  public boolean onlyIfCached()
  {
    return this.onlyIfCached;
  }

  public int sMaxAgeSeconds()
  {
    return this.sMaxAgeSeconds;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.CacheControl
 * JD-Core Version:    0.6.2
 */