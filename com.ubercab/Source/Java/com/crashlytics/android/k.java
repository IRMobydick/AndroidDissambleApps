package com.crashlytics.android;

import com.crashlytics.android.internal.aG;
import java.io.InputStream;

final class k
  implements aG
{
  k(PinningInfoProvider paramPinningInfoProvider)
  {
  }

  public final InputStream a()
  {
    return this.a.getKeyStoreStream();
  }

  public final String b()
  {
    return this.a.getKeyStorePassword();
  }

  public final String[] c()
  {
    return this.a.getPins();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.k
 * JD-Core Version:    0.6.2
 */