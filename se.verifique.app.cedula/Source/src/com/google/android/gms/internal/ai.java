package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class ai
  implements SafeParcelable
{
  public static final p a = new p();
  public final int b;
  public final long c;
  public final Bundle d;
  public final int e;
  public final List f;
  public final boolean g;
  public final int h;
  public final boolean i;
  public final String j;
  public final aw k;
  public final Location l;
  public final String m;
  public final Bundle n;

  public ai(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List paramList, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, aw paramaw, Location paramLocation, String paramString2, Bundle paramBundle2)
  {
    this.b = paramInt1;
    this.c = paramLong;
    this.d = paramBundle1;
    this.e = paramInt2;
    this.f = paramList;
    this.g = paramBoolean1;
    this.h = paramInt3;
    this.i = paramBoolean2;
    this.j = paramString1;
    this.k = paramaw;
    this.l = paramLocation;
    this.m = paramString2;
    this.n = paramBundle2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ai
 * JD-Core Version:    0.6.0
 */