package com.google.android.gms.internal;

import java.util.Arrays;

public final class nu
{
  final int a;
  final byte[] b;

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (paramObject == this);
    while (true)
    {
      return i;
      if (!(paramObject instanceof nu))
      {
        i = 0;
        continue;
      }
      nu localnu = (nu)paramObject;
      if ((this.a == localnu.a) && (Arrays.equals(this.b, localnu.b)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    return 31 * (527 + this.a) + Arrays.hashCode(this.b);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nu
 * JD-Core Version:    0.6.0
 */