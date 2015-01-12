package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final m CREATOR = new m();
  private final int BR;
  private float ajI = 10.0F;
  private int ajJ = -16777216;
  private int ajK = 0;
  private float ajL = 0.0F;
  private boolean ajM = true;
  private final List<LatLng> akl;
  private final List<List<LatLng>> akm;
  private boolean akn = false;

  public PolygonOptions()
  {
    this.BR = 1;
    this.akl = new ArrayList();
    this.akm = new ArrayList();
  }

  PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.BR = paramInt1;
    this.akl = paramList;
    this.akm = paramList1;
    this.ajI = paramFloat1;
    this.ajJ = paramInt2;
    this.ajK = paramInt3;
    this.ajL = paramFloat2;
    this.ajM = paramBoolean1;
    this.akn = paramBoolean2;
  }

  public PolygonOptions add(LatLng paramLatLng)
  {
    this.akl.add(paramLatLng);
    return this;
  }

  public PolygonOptions add(LatLng[] paramArrayOfLatLng)
  {
    this.akl.addAll(Arrays.asList(paramArrayOfLatLng));
    return this;
  }

  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      LatLng localLatLng = (LatLng)localIterator.next();
      this.akl.add(localLatLng);
    }
    return this;
  }

  public PolygonOptions addHole(Iterable<LatLng> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      localArrayList.add((LatLng)localIterator.next());
    this.akm.add(localArrayList);
    return this;
  }

  public int describeContents()
  {
    return 0;
  }

  public PolygonOptions fillColor(int paramInt)
  {
    this.ajK = paramInt;
    return this;
  }

  public PolygonOptions geodesic(boolean paramBoolean)
  {
    this.akn = paramBoolean;
    return this;
  }

  public int getFillColor()
  {
    return this.ajK;
  }

  public List<List<LatLng>> getHoles()
  {
    return this.akm;
  }

  public List<LatLng> getPoints()
  {
    return this.akl;
  }

  public int getStrokeColor()
  {
    return this.ajJ;
  }

  public float getStrokeWidth()
  {
    return this.ajI;
  }

  int getVersionCode()
  {
    return this.BR;
  }

  public float getZIndex()
  {
    return this.ajL;
  }

  public boolean isGeodesic()
  {
    return this.akn;
  }

  public boolean isVisible()
  {
    return this.ajM;
  }

  List mQ()
  {
    return this.akm;
  }

  public PolygonOptions strokeColor(int paramInt)
  {
    this.ajJ = paramInt;
    return this;
  }

  public PolygonOptions strokeWidth(float paramFloat)
  {
    this.ajI = paramFloat;
    return this;
  }

  public PolygonOptions visible(boolean paramBoolean)
  {
    this.ajM = paramBoolean;
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (v.mM())
    {
      n.a(this, paramParcel, paramInt);
      return;
    }
    m.a(this, paramParcel, paramInt);
  }

  public PolygonOptions zIndex(float paramFloat)
  {
    this.ajL = paramFloat;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PolygonOptions
 * JD-Core Version:    0.6.2
 */