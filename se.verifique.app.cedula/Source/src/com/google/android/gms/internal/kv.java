package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class kv
{
  private final List a;
  private final Object b;

  private kv(Object paramObject)
  {
    this.b = kx.a(paramObject);
    this.a = new ArrayList();
  }

  public kv a(String paramString, Object paramObject)
  {
    this.a.add((String)kx.a(paramString) + "=" + String.valueOf(paramObject));
    return this;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
    int i = this.a.size();
    for (int j = 0; j < i; j++)
    {
      localStringBuilder.append((String)this.a.get(j));
      if (j >= i - 1)
        continue;
      localStringBuilder.append(", ");
    }
    return '}';
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kv
 * JD-Core Version:    0.6.0
 */