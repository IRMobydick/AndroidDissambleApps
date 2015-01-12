package com.crashlytics.android.internal;

import java.io.File;
import java.util.Iterator;
import java.util.List;

final class H extends Z
  implements N
{
  public H(String paramString1, String paramString2, av paramav)
  {
    super(paramString1, paramString2, paramav, ax.b);
  }

  public final boolean a(String paramString, List<File> paramList)
  {
    ay localay = b().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", v.a().getVersion()).a("X-CRASHLYTICS-API-KEY", paramString);
    Iterator localIterator = paramList.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      File localFile = (File)localIterator.next();
      ab.c("Adding analytics session file " + localFile.getName() + " to multipart POST");
      localay.a("session_analytics_file_" + i, localFile.getName(), "application/vnd.crashlytics.android.events", localFile);
    }
    ab.c("Sending " + paramList.size() + " analytics files to " + a());
    int j = localay.b();
    ab.c("Response code for analytics file send is " + j);
    int k = r.a(j);
    boolean bool = false;
    if (k == 0)
      bool = true;
    return bool;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.H
 * JD-Core Version:    0.6.2
 */