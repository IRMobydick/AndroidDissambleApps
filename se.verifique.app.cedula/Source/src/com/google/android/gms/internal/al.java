package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.h;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class al
  implements SafeParcelable
{
  public static final r a = new r();
  public final int b;
  public final String c;
  public final int d;
  public final int e;
  public final boolean f;
  public final int g;
  public final int h;
  public final al[] i;

  public al()
  {
    this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
  }

  al(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, al[] paramArrayOfal)
  {
    this.b = paramInt1;
    this.c = paramString;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramBoolean;
    this.g = paramInt4;
    this.h = paramInt5;
    this.i = paramArrayOfal;
  }

  public al(Context paramContext, e parame)
  {
    this(paramContext, arrayOfe);
  }

  public al(Context paramContext, e[] paramArrayOfe)
  {
    e locale = paramArrayOfe[0];
    this.b = 2;
    this.f = false;
    this.g = locale.b();
    this.d = locale.a();
    int k;
    int m;
    label63: DisplayMetrics localDisplayMetrics;
    int i1;
    label100: int i2;
    if (this.g == -1)
    {
      k = 1;
      if (this.d != -2)
        break label217;
      m = 1;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (k == 0)
        break label223;
      this.h = a(localDisplayMetrics);
      i1 = (int)(this.h / localDisplayMetrics.density);
      if (m == 0)
        break label249;
      i2 = c(localDisplayMetrics);
      label112: this.e = hh.a(localDisplayMetrics, i2);
      if ((k == 0) && (m == 0))
        break label258;
    }
    label258: for (this.c = (i1 + "x" + i2 + "_as"); ; this.c = locale.toString())
    {
      if (paramArrayOfe.length <= 1)
        break label270;
      this.i = new al[paramArrayOfe.length];
      while (j < paramArrayOfe.length)
      {
        this.i[j] = new al(paramContext, paramArrayOfe[j]);
        j++;
      }
      k = 0;
      break;
      label217: m = 0;
      break label63;
      label223: int n = this.g;
      this.h = hh.a(localDisplayMetrics, this.g);
      i1 = n;
      break label100;
      label249: i2 = this.d;
      break label112;
    }
    label270: this.i = null;
  }

  public al(al paramal, al[] paramArrayOfal)
  {
    this(2, paramal.c, paramal.d, paramal.e, paramal.f, paramal.g, paramal.h, paramArrayOfal);
  }

  public static int a(DisplayMetrics paramDisplayMetrics)
  {
    return paramDisplayMetrics.widthPixels;
  }

  public static int b(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(c(paramDisplayMetrics) * paramDisplayMetrics.density);
  }

  private static int c(DisplayMetrics paramDisplayMetrics)
  {
    int j = (int)(paramDisplayMetrics.heightPixels / paramDisplayMetrics.density);
    int k;
    if (j <= 400)
      k = 32;
    while (true)
    {
      return k;
      if (j <= 720)
      {
        k = 50;
        continue;
      }
      k = 90;
    }
  }

  public e a()
  {
    return h.a(this.g, this.d, this.c);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    r.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.al
 * JD-Core Version:    0.6.0
 */