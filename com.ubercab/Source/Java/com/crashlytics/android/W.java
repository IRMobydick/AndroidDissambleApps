package com.crashlytics.android;

import com.crashlytics.android.internal.av;
import com.crashlytics.android.internal.ax;
import com.crashlytics.android.internal.ay;
import com.crashlytics.android.internal.q;
import com.crashlytics.android.internal.r;
import com.crashlytics.android.internal.v;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class W extends com.crashlytics.android.internal.Z
  implements V
{
  public W(String paramString1, String paramString2, av paramav)
  {
    super(paramString1, paramString2, paramav, ax.b);
  }

  public final boolean a(U paramU)
  {
    ay localay1 = b().a("X-CRASHLYTICS-API-KEY", paramU.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", Crashlytics.getInstance().getVersion());
    Iterator localIterator = paramU.b.e().entrySet().iterator();
    for (ay localay2 = localay1; localIterator.hasNext(); localay2 = localay2.a((Map.Entry)localIterator.next()));
    Z localZ = paramU.b;
    ay localay3 = localay2.a("report[file]", localZ.b(), "application/octet-stream", localZ.d()).b("report[identifier]", localZ.c());
    v.a().b().a("Crashlytics", "Sending report to: " + a());
    int i = localay3.b();
    v.a().b().a("Crashlytics", "Create report request ID: " + localay3.a("X-REQUEST-ID"));
    v.a().b().a("Crashlytics", "Result was: " + i);
    return r.a(i) == 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.W
 * JD-Core Version:    0.6.2
 */