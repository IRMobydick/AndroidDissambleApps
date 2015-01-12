package com.ubercab.library.map.internal;

import android.os.Bundle;

public abstract interface IUberMapView
{
  public abstract IUberMap getMap();

  public abstract void onCreate(Bundle paramBundle);

  public abstract void onDestroy();

  public abstract void onLowMemory();

  public abstract void onPause();

  public abstract void onResume();

  public abstract void onSaveInstanceState(Bundle paramBundle);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.IUberMapView
 * JD-Core Version:    0.6.2
 */