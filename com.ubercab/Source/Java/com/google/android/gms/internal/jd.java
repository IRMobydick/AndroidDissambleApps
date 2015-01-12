package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jd
  implements SafeParcelable
{
  public static final je CREATOR = new je();
  private final int BR;
  private final jf Ms;

  jd(int paramInt, jf paramjf)
  {
    this.BR = paramInt;
    this.Ms = paramjf;
  }

  private jd(jf paramjf)
  {
    this.BR = 1;
    this.Ms = paramjf;
  }

  public static jd a(ji.b<?, ?> paramb)
  {
    if ((paramb instanceof jf))
      return new jd((jf)paramb);
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }

  public int describeContents()
  {
    return 0;
  }

  int getVersionCode()
  {
    return this.BR;
  }

  jf ha()
  {
    return this.Ms;
  }

  public ji.b<?, ?> hb()
  {
    if (this.Ms != null)
      return this.Ms;
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    je.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jd
 * JD-Core Version:    0.6.2
 */