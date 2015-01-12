package com.cocoahero.android.geojson.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtils
{
  public static String toString(InputStream paramInputStream)
    throws IOException
  {
    return toString(paramInputStream, "UTF-8");
  }

  public static String toString(InputStream paramInputStream, String paramString)
    throws IOException
  {
    char[] arrayOfChar = new char[1024];
    StringBuilder localStringBuilder = new StringBuilder();
    InputStreamReader localInputStreamReader = new InputStreamReader(paramInputStream, paramString);
    while (true)
    {
      int i = localInputStreamReader.read(arrayOfChar);
      if (i < 0)
        break;
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    localInputStreamReader.close();
    return localStringBuilder.toString();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.util.StreamUtils
 * JD-Core Version:    0.6.2
 */