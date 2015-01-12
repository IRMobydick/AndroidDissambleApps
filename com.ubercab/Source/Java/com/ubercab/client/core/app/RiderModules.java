package com.ubercab.client.core.app;

import com.ubercab.client.core.module.RiderApplicationModule;

public final class RiderModules
{
  public static Object[] list(RiderApplication paramRiderApplication)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = new RiderApplicationModule(paramRiderApplication);
    return arrayOfObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderModules
 * JD-Core Version:    0.6.2
 */