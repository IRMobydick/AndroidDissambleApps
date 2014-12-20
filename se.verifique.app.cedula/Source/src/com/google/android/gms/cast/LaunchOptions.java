package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jf;
import com.google.android.gms.internal.kt;
import java.util.Locale;

public class LaunchOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  private final int a;
  private boolean b;
  private String c;

  public LaunchOptions()
  {
    this(1, false, jf.a(Locale.getDefault()));
  }

  LaunchOptions(int paramInt, boolean paramBoolean, String paramString)
  {
    this.a = paramInt;
    this.b = paramBoolean;
    this.c = paramString;
  }

  int a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (paramObject == this);
    while (true)
    {
      return i;
      if (!(paramObject instanceof LaunchOptions))
      {
        i = 0;
        continue;
      }
      LaunchOptions localLaunchOptions = (LaunchOptions)paramObject;
      if ((this.b == localLaunchOptions.b) && (jf.a(this.c, localLaunchOptions.c)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Boolean.valueOf(this.b);
    arrayOfObject[1] = this.c;
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Boolean.valueOf(this.b);
    arrayOfObject[1] = this.c;
    return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.LaunchOptions
 * JD-Core Version:    0.6.0
 */