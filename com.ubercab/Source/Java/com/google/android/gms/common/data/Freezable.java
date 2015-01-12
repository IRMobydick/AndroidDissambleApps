package com.google.android.gms.common.data;

public abstract interface Freezable<T>
{
  public abstract T freeze();

  public abstract boolean isDataValid();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.Freezable
 * JD-Core Version:    0.6.2
 */