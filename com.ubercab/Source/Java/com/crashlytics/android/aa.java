package com.crashlytics.android;

import com.crashlytics.android.internal.q;
import com.crashlytics.android.internal.r;
import com.crashlytics.android.internal.v;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class aa
{
  static final Map<String, String> a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
  private static final FilenameFilter b = new ab();
  private static final short[] c = { 10, 20, 30, 60, 120, 300 };
  private final Object d = new Object();
  private final V e;
  private Thread f;

  public aa(V paramV)
  {
    if (paramV == null)
      throw new IllegalArgumentException("createReportCall must not be null.");
    this.e = paramV;
  }

  final List<Z> a()
  {
    v.a().b().a("Crashlytics", "Checking for crash reports...");
    LinkedList localLinkedList;
    synchronized (this.d)
    {
      File[] arrayOfFile = v.a().h().listFiles(b);
      localLinkedList = new LinkedList();
      int i = arrayOfFile.length;
      int j = 0;
      if (j < i)
      {
        File localFile = arrayOfFile[j];
        v.a().b().a("Crashlytics", "Found crash report " + localFile.getPath());
        localLinkedList.add(new Z(localFile));
        j++;
      }
    }
    v.a().b().a("Crashlytics", "No reports found.");
    return localLinkedList;
  }

  public final void a(float paramFloat)
  {
    try
    {
      if (this.f == null)
      {
        this.f = new Thread(new ac(this, paramFloat), "Crashlytics Report Uploader");
        this.f.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final boolean a(Z paramZ)
  {
    synchronized (this.d)
    {
      try
      {
        U localU = new U(r.a(v.a().getContext(), v.a().f()), paramZ);
        boolean bool2 = this.e.a(localU);
        q localq = v.a().b();
        StringBuilder localStringBuilder = new StringBuilder("Crashlytics report upload ");
        if (bool2);
        for (String str = "complete: "; ; str = "FAILED: ")
        {
          localq.b("Crashlytics", str + paramZ.b());
          bool1 = false;
          if (bool2)
          {
            paramZ.a();
            bool1 = true;
          }
          return bool1;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          v.a().b().a("Crashlytics", "Error occurred sending report " + paramZ, localException);
          boolean bool1 = false;
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.aa
 * JD-Core Version:    0.6.2
 */