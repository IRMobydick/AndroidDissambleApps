package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import com.google.android.gms.maps.model.internal.i;
import com.google.android.gms.maps.model.internal.i.a;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final w CREATOR = new w();
  private final int BR;
  private float ajL;
  private boolean ajM = true;
  private i akr;
  private TileProvider aks;
  private boolean akt = true;

  public TileOverlayOptions()
  {
    this.BR = 1;
  }

  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.BR = paramInt;
    this.akr = i.a.by(paramIBinder);
    if (this.akr == null);
    for (TileProvider local1 = null; ; local1 = new TileProvider()
    {
      private final i aku = TileOverlayOptions.a(TileOverlayOptions.this);

      public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        try
        {
          Tile localTile = this.aku.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          return localTile;
        }
        catch (RemoteException localRemoteException)
        {
        }
        return null;
      }
    })
    {
      this.aks = local1;
      this.ajM = paramBoolean1;
      this.ajL = paramFloat;
      this.akt = paramBoolean2;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public TileOverlayOptions fadeIn(boolean paramBoolean)
  {
    this.akt = paramBoolean;
    return this;
  }

  public boolean getFadeIn()
  {
    return this.akt;
  }

  public TileProvider getTileProvider()
  {
    return this.aks;
  }

  int getVersionCode()
  {
    return this.BR;
  }

  public float getZIndex()
  {
    return this.ajL;
  }

  public boolean isVisible()
  {
    return this.ajM;
  }

  IBinder mR()
  {
    return this.akr.asBinder();
  }

  public TileOverlayOptions tileProvider(final TileProvider paramTileProvider)
  {
    this.aks = paramTileProvider;
    if (this.aks == null);
    for (i.a local2 = null; ; local2 = new i.a()
    {
      public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        return paramTileProvider.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
      }
    })
    {
      this.akr = local2;
      return this;
    }
  }

  public TileOverlayOptions visible(boolean paramBoolean)
  {
    this.ajM = paramBoolean;
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.mM())
    {
      x.a(this, paramParcel, paramInt);
      return;
    }
    w.a(this, paramParcel, paramInt);
  }

  public TileOverlayOptions zIndex(float paramFloat)
  {
    this.ajL = paramFloat;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.TileOverlayOptions
 * JD-Core Version:    0.6.2
 */