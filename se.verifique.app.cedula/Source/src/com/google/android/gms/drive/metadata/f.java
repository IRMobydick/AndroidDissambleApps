package com.google.android.gms.drive.metadata;

import com.google.android.gms.internal.kx;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class f
  implements a
{
  private final String a;
  private final Set b;
  private final Set c;
  private final int d;

  protected f(String paramString, int paramInt)
  {
    this.a = ((String)kx.a(paramString, "fieldName"));
    this.b = Collections.singleton(paramString);
    this.c = Collections.emptySet();
    this.d = paramInt;
  }

  protected f(String paramString, Collection paramCollection1, Collection paramCollection2, int paramInt)
  {
    this.a = ((String)kx.a(paramString, "fieldName"));
    this.b = Collections.unmodifiableSet(new HashSet(paramCollection1));
    this.c = Collections.unmodifiableSet(new HashSet(paramCollection2));
    this.d = paramInt;
  }

  public final String a()
  {
    return this.a;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.f
 * JD-Core Version:    0.6.0
 */