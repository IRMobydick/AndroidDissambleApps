package com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

public abstract class a
  implements Releasable, Result
{
  protected final Status CM;
  protected final DataHolder II;

  protected a(DataHolder paramDataHolder)
  {
    this.CM = new Status(paramDataHolder.getStatusCode());
    this.II = paramDataHolder;
  }

  public Status getStatus()
  {
    return this.CM;
  }

  public void release()
  {
    if (this.II != null)
      this.II.close();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.a
 * JD-Core Version:    0.6.2
 */