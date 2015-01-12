package com.ubercab.library.app;

import android.os.Binder;

public class UberServiceBinder extends Binder
{
  private UberService mUberService;

  public UberServiceBinder(UberService paramUberService)
  {
    this.mUberService = paramUberService;
  }

  public UberService getUberService()
  {
    return this.mUberService;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberServiceBinder
 * JD-Core Version:    0.6.2
 */