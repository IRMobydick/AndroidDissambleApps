package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ds
  implements SafeParcelable
{
  public static final fn a = new fn();
  public final int b;
  public final Bundle c;
  public final ai d;
  public final al e;
  public final String f;
  public final ApplicationInfo g;
  public final PackageInfo h;
  public final String i;
  public final String j;
  public final String k;
  public final ev l;
  public final Bundle m;
  public final String n;

  ds(int paramInt, Bundle paramBundle1, ai paramai, al paramal, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, ev paramev, Bundle paramBundle2, String paramString5)
  {
    this.b = paramInt;
    this.c = paramBundle1;
    this.d = paramai;
    this.e = paramal;
    this.f = paramString1;
    this.g = paramApplicationInfo;
    this.h = paramPackageInfo;
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramString4;
    this.l = paramev;
    this.m = paramBundle2;
    this.n = paramString5;
  }

  public ds(Bundle paramBundle1, ai paramai, al paramal, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, ev paramev, Bundle paramBundle2, String paramString5)
  {
    this(3, paramBundle1, paramai, paramal, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramev, paramBundle2, paramString5);
  }

  public ds(fl paramfl, String paramString1, String paramString2)
  {
    this(paramfl.a, paramfl.b, paramfl.c, paramfl.d, paramfl.e, paramfl.f, paramString1, paramfl.g, paramfl.h, paramfl.j, paramfl.i, paramString2);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fn.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ds
 * JD-Core Version:    0.6.0
 */