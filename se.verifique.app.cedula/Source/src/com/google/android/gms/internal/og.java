package com.google.android.gms.internal;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;

class og
  implements ComponentCallbacks
{
  og(of paramof)
  {
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((of.a(this.a) != null) && (of.a(this.a).i != null) && (of.a(this.a).i.b != null))
      of.a(this.a).i.b.a();
  }

  public void onLowMemory()
  {
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.og
 * JD-Core Version:    0.6.0
 */