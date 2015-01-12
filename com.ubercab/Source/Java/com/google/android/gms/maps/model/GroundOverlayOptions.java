package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.maps.internal.v;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final e CREATOR = new e();
  public static final float NO_DIMENSION = -1.0F;
  private final int BR;
  private float ajE;
  private float ajL;
  private boolean ajM = true;
  private BitmapDescriptor ajO;
  private LatLng ajP;
  private float ajQ;
  private float ajR;
  private LatLngBounds ajS;
  private float ajT = 0.0F;
  private float ajU = 0.5F;
  private float ajV = 0.5F;

  public GroundOverlayOptions()
  {
    this.BR = 1;
  }

  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.BR = paramInt;
    this.ajO = new BitmapDescriptor(d.a.am(paramIBinder));
    this.ajP = paramLatLng;
    this.ajQ = paramFloat1;
    this.ajR = paramFloat2;
    this.ajS = paramLatLngBounds;
    this.ajE = paramFloat3;
    this.ajL = paramFloat4;
    this.ajM = paramBoolean;
    this.ajT = paramFloat5;
    this.ajU = paramFloat6;
    this.ajV = paramFloat7;
  }

  private GroundOverlayOptions a(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.ajP = paramLatLng;
    this.ajQ = paramFloat1;
    this.ajR = paramFloat2;
    return this;
  }

  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.ajU = paramFloat1;
    this.ajV = paramFloat2;
    return this;
  }

  public GroundOverlayOptions bearing(float paramFloat)
  {
    this.ajE = ((360.0F + paramFloat % 360.0F) % 360.0F);
    return this;
  }

  public int describeContents()
  {
    return 0;
  }

  public float getAnchorU()
  {
    return this.ajU;
  }

  public float getAnchorV()
  {
    return this.ajV;
  }

  public float getBearing()
  {
    return this.ajE;
  }

  public LatLngBounds getBounds()
  {
    return this.ajS;
  }

  public float getHeight()
  {
    return this.ajR;
  }

  public BitmapDescriptor getImage()
  {
    return this.ajO;
  }

  public LatLng getLocation()
  {
    return this.ajP;
  }

  public float getTransparency()
  {
    return this.ajT;
  }

  int getVersionCode()
  {
    return this.BR;
  }

  public float getWidth()
  {
    return this.ajQ;
  }

  public float getZIndex()
  {
    return this.ajL;
  }

  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.ajO = paramBitmapDescriptor;
    return this;
  }

  public boolean isVisible()
  {
    return this.ajM;
  }

  IBinder mO()
  {
    return this.ajO.mo().asBinder();
  }

  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (this.ajS == null)
    {
      bool2 = bool1;
      o.a(bool2, "Position has already been set using positionFromBounds");
      if (paramLatLng == null)
        break label60;
      bool3 = bool1;
      label26: o.b(bool3, "Location must be specified");
      if (paramFloat < 0.0F)
        break label66;
    }
    while (true)
    {
      o.b(bool1, "Width must be non-negative");
      return a(paramLatLng, paramFloat, -1.0F);
      bool2 = false;
      break;
      label60: bool3 = false;
      break label26;
      label66: bool1 = false;
    }
  }

  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    label29: boolean bool4;
    if (this.ajS == null)
    {
      bool2 = bool1;
      o.a(bool2, "Position has already been set using positionFromBounds");
      if (paramLatLng == null)
        break label80;
      bool3 = bool1;
      o.b(bool3, "Location must be specified");
      if (paramFloat1 < 0.0F)
        break label86;
      bool4 = bool1;
      label46: o.b(bool4, "Width must be non-negative");
      if (paramFloat2 < 0.0F)
        break label92;
    }
    while (true)
    {
      o.b(bool1, "Height must be non-negative");
      return a(paramLatLng, paramFloat1, paramFloat2);
      bool2 = false;
      break;
      label80: bool3 = false;
      break label29;
      label86: bool4 = false;
      break label46;
      label92: bool1 = false;
    }
  }

  public GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds)
  {
    if (this.ajP == null);
    for (boolean bool = true; ; bool = false)
    {
      o.a(bool, "Position has already been set using position: " + this.ajP);
      this.ajS = paramLatLngBounds;
      return this;
    }
  }

  public GroundOverlayOptions transparency(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F));
    for (boolean bool = true; ; bool = false)
    {
      o.b(bool, "Transparency must be in the range [0..1]");
      this.ajT = paramFloat;
      return this;
    }
  }

  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.ajM = paramBoolean;
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.mM())
    {
      f.a(this, paramParcel, paramInt);
      return;
    }
    e.a(this, paramParcel, paramInt);
  }

  public GroundOverlayOptions zIndex(float paramFloat)
  {
    this.ajL = paramFloat;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.GroundOverlayOptions
 * JD-Core Version:    0.6.2
 */