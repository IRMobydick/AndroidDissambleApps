package com.ubercab.library.map.internal;

import com.ubercab.library.map.internal.model.IUberCameraPosition;

public abstract interface IUberMapOptions
{
  public abstract IUberMapOptions camera(IUberCameraPosition paramIUberCameraPosition);

  public abstract IUberMapOptions compassEnabled(boolean paramBoolean);

  public abstract IUberMapOptions rotateGesturesEnabled(boolean paramBoolean);

  public abstract IUberMapOptions scrollGesturesEnabled(boolean paramBoolean);

  public abstract IUberMapOptions tiltGesturesEnabled(boolean paramBoolean);

  public abstract IUberMapOptions zoomControlsEnabled(boolean paramBoolean);

  public abstract IUberMapOptions zoomGesturesEnabled(boolean paramBoolean);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.internal.IUberMapOptions
 * JD-Core Version:    0.6.2
 */