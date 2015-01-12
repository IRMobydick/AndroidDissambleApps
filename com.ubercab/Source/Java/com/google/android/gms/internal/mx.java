package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.n.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class mx
  implements SafeParcelable
{
  public static final my CREATOR = new my();
  public final String Dv;
  public final String aij;
  public final String aik;
  public final int versionCode;

  public mx(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.versionCode = paramInt;
    this.aij = paramString1;
    this.aik = paramString2;
    this.Dv = paramString3;
  }

  public mx(String paramString1, Locale paramLocale, String paramString2)
  {
    this.versionCode = 0;
    this.aij = paramString1;
    this.aik = paramLocale.toString();
    this.Dv = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    mx localmx;
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof mx)))
        return false;
      localmx = (mx)paramObject;
    }
    while ((this.aik.equals(localmx.aik)) && (this.aij.equals(localmx.aij)) && (n.equal(this.Dv, localmx.Dv)));
    return false;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.aij;
    arrayOfObject[1] = this.aik;
    arrayOfObject[2] = this.Dv;
    return n.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return n.h(this).a("clientPackageName", this.aij).a("locale", this.aik).a("accountName", this.Dv).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    my.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mx
 * JD-Core Version:    0.6.2
 */