package com.crashlytics.android;

import java.io.InputStream;

public abstract interface PinningInfoProvider
{
  public abstract String getKeyStorePassword();

  public abstract InputStream getKeyStoreStream();

  public abstract String[] getPins();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.PinningInfoProvider
 * JD-Core Version:    0.6.2
 */