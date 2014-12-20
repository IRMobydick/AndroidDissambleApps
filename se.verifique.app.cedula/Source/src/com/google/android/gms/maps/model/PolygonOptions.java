package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.b;
import java.util.ArrayList;
import java.util.List;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final h a = new h();
  private final int b;
  private final List c;
  private final List d;
  private float e = 10.0F;
  private int f = -16777216;
  private int g = 0;
  private float h = 0.0F;
  private boolean i = true;
  private boolean j = false;

  public PolygonOptions()
  {
    this.b = 1;
    this.c = new ArrayList();
    this.d = new ArrayList();
  }

  PolygonOptions(int paramInt1, List paramList1, List paramList2, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramInt1;
    this.c = paramList1;
    this.d = paramList2;
    this.e = paramFloat1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramFloat2;
    this.i = paramBoolean1;
    this.j = paramBoolean2;
  }

  int a()
  {
    return this.b;
  }

  List b()
  {
    return this.d;
  }

  public List c()
  {
    return this.c;
  }

  public float d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return this.f;
  }

  public int f()
  {
    return this.g;
  }

  public float g()
  {
    return this.h;
  }

  public boolean h()
  {
    return this.i;
  }

  public boolean i()
  {
    return this.j;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
      z.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      h.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PolygonOptions
 * JD-Core Version:    0.6.0
 */