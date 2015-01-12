package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class n
{
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static a h(Object paramObject)
  {
    return new a(paramObject, null);
  }

  public static int hashCode(Object[] paramArrayOfObject)
  {
    return Arrays.hashCode(paramArrayOfObject);
  }

  public static final class a
  {
    private final List<String> Mg;
    private final Object Mh;

    private a(Object paramObject)
    {
      this.Mh = o.i(paramObject);
      this.Mg = new ArrayList();
    }

    public a a(String paramString, Object paramObject)
    {
      this.Mg.add((String)o.i(paramString) + "=" + String.valueOf(paramObject));
      return this;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100).append(this.Mh.getClass().getSimpleName()).append('{');
      int i = this.Mg.size();
      for (int j = 0; j < i; j++)
      {
        localStringBuilder.append((String)this.Mg.get(j));
        if (j < i - 1)
          localStringBuilder.append(", ");
      }
      return '}';
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.n
 * JD-Core Version:    0.6.2
 */