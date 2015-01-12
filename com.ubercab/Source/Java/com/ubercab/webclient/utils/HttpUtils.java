package com.ubercab.webclient.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class HttpUtils
{
  public static String formatCookie(String paramString1, String paramString2, Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, MMM dd yyyy HH:mm:ss z");
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return String.format("%s=%s;expires=%s;path=/", new Object[] { paramString1, paramString2, localSimpleDateFormat.format(paramDate) });
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.webclient.utils.HttpUtils
 * JD-Core Version:    0.6.2
 */