package com.crashlytics.android;

import java.io.File;
import java.io.FilenameFilter;

final class g
  implements FilenameFilter
{
  public final boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".cls_temp");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.g
 * JD-Core Version:    0.6.2
 */