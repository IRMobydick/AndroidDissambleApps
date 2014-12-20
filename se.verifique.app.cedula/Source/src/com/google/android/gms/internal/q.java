package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class q
{
  public static final q a = new q();

  public static q a()
  {
    return a;
  }

  public ai a(Context paramContext, ah paramah)
  {
    Date localDate = paramah.a();
    long l;
    String str1;
    int i;
    List localList;
    label57: boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    com.google.android.gms.ads.e.a locala;
    if (localDate != null)
    {
      l = localDate.getTime();
      str1 = paramah.b();
      i = paramah.c();
      Set localSet = paramah.d();
      if (localSet.isEmpty())
        break label161;
      localList = Collections.unmodifiableList(new ArrayList(localSet));
      bool1 = paramah.a(paramContext);
      j = paramah.k();
      localLocation = paramah.e();
      localBundle = paramah.a(com.google.a.a.a.a.class);
      bool2 = paramah.f();
      str2 = paramah.g();
      locala = paramah.h();
      if (locala == null)
        break label167;
    }
    label161: label167: for (aw localaw = new aw(locala); ; localaw = null)
    {
      return new ai(4, l, localBundle, i, localList, bool1, j, bool2, str2, localaw, localLocation, str1, paramah.j());
      l = -1L;
      break;
      localList = null;
      break label57;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.q
 * JD-Core Version:    0.6.0
 */