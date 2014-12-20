package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.b;
import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions
  implements SafeParcelable
{
  public static final i a = new i();
  private final int b;
  private final List c;
  private float d = 10.0F;
  private int e = -16777216;
  private float f = 0.0F;
  private boolean g = true;
  private boolean h = false;

  public PolylineOptions()
  {
    this.b = 1;
    this.c = new ArrayList();
  }

  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramInt1;
    this.c = paramList;
    this.d = paramFloat1;
    this.e = paramInt2;
    this.f = paramFloat2;
    this.g = paramBoolean1;
    this.h = paramBoolean2;
  }

  int a()
  {
    return this.b;
  }

  public List b()
  {
    return this.c;
  }

  public float c()
  {
    return this.d;
  }

  public int d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public float e()
  {
    return this.f;
  }

  public boolean f()
  {
    return this.g;
  }

  public boolean g()
  {
    return this.h;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
      aa.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      i.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PolylineOptions
 * JD-Core Version:    0.6.0
 */