package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ai
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new g();
  final int a;
  private final String b;
  private final String c;

  ai(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 0;
    if (!(paramObject instanceof ai));
    while (true)
    {
      return i;
      ai localai = (ai)paramObject;
      if ((!localai.b.equals(this.b)) || (!localai.c.equals(this.c)))
        continue;
      i = 1;
    }
  }

  public int hashCode()
  {
    return 37 * (629 + this.b.hashCode()) + this.c.hashCode();
  }

  public String toString()
  {
    return "NodeParcelable{" + this.b + "," + this.c + "}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ai
 * JD-Core Version:    0.6.0
 */