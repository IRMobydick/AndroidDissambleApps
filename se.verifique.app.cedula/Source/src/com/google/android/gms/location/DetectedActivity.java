package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity
  implements SafeParcelable
{
  public static final c a = new c();
  int b;
  int c;
  private final int d;

  public DetectedActivity(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }

  private int a(int paramInt)
  {
    if (paramInt > 8)
      paramInt = 4;
    return paramInt;
  }

  public int a()
  {
    return a(this.b);
  }

  public int b()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "DetectedActivity [type=" + a() + ", confidence=" + this.c + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.DetectedActivity
 * JD-Core Version:    0.6.0
 */