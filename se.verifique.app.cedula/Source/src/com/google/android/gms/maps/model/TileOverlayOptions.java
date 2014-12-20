package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.a.a;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final q a = new q();
  private final int b;
  private a c;
  private r d;
  private boolean e = true;
  private float f;
  private boolean g = true;

  public TileOverlayOptions()
  {
    this.b = 1;
  }

  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.b = paramInt;
    this.c = com.google.android.gms.maps.model.a.b.a(paramIBinder);
    if (this.c == null);
    for (p localp = null; ; localp = new p(this))
    {
      this.d = localp;
      this.e = paramBoolean1;
      this.f = paramFloat;
      this.g = paramBoolean2;
      return;
    }
  }

  int a()
  {
    return this.b;
  }

  IBinder b()
  {
    return this.c.asBinder();
  }

  public float c()
  {
    return this.f;
  }

  public boolean d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    return this.g;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (com.google.android.gms.maps.a.b.a())
      ac.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      q.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.TileOverlayOptions
 * JD-Core Version:    0.6.0
 */