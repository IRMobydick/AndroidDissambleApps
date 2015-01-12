package com.ubercab.common.base;

public abstract interface Function<F, T>
{
  public abstract T apply(F paramF);

  public abstract boolean equals(Object paramObject);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.base.Function
 * JD-Core Version:    0.6.2
 */