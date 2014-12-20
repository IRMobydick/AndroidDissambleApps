package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public final class aj
{
  private final HashSet a = new HashSet();
  private final Bundle b = new Bundle();
  private final HashMap c = new HashMap();
  private final HashSet d = new HashSet();
  private Date e;
  private String f;
  private int g = -1;
  private Location h;
  private boolean i = false;
  private String j;
  private int k = -1;

  public void a(int paramInt)
  {
    this.g = paramInt;
  }

  public void a(Class paramClass, Bundle paramBundle)
  {
    this.b.putBundle(paramClass.getName(), paramBundle);
  }

  public void a(String paramString)
  {
    this.a.add(paramString);
  }

  public void a(Date paramDate)
  {
    this.e = paramDate;
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int m = 1; ; m = 0)
    {
      this.k = m;
      return;
    }
  }

  public void b(String paramString)
  {
    this.d.add(paramString);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.aj
 * JD-Core Version:    0.6.0
 */