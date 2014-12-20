package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class AppVisibleCustomProperties
  implements SafeParcelable, Iterable
{
  public static final Parcelable.Creator CREATOR = new c();
  public static final AppVisibleCustomProperties a = new b().a();
  final int b;
  final List c;

  AppVisibleCustomProperties(int paramInt, Collection paramCollection)
  {
    this.b = paramInt;
    kx.a(paramCollection);
    this.c = new ArrayList(paramCollection);
  }

  private AppVisibleCustomProperties(Collection paramCollection)
  {
    this(1, paramCollection);
  }

  public int describeContents()
  {
    return 0;
  }

  public Iterator iterator()
  {
    return this.c.iterator();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
 * JD-Core Version:    0.6.0
 */