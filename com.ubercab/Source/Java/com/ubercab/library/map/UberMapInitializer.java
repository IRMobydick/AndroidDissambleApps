package com.ubercab.library.map;

public final class UberMapInitializer
{
  private static MapVendor sMapVendor;

  static MapVendor getMapVendor()
  {
    return sMapVendor;
  }

  public static void initialize(MapVendor paramMapVendor)
  {
    sMapVendor = paramMapVendor;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberMapInitializer
 * JD-Core Version:    0.6.2
 */