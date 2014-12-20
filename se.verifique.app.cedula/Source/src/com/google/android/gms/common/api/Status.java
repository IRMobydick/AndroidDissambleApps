package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public final class Status
  implements SafeParcelable
{
  public static final Status a = new Status(0);
  public static final Status b = new Status(14);
  public static final Status c = new Status(8);
  public static final Status d = new Status(15);
  public static final Status e = new Status(16);
  public static final e f = new e();
  private final int g;
  private final int h;
  private final String i;
  private final PendingIntent j;

  public Status(int paramInt)
  {
    this(1, paramInt, null, null);
  }

  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramString;
    this.j = paramPendingIntent;
  }

  private String e()
  {
    if (this.i != null);
    for (String str = this.i; ; str = a.a(this.h))
      return str;
  }

  PendingIntent a()
  {
    return this.j;
  }

  public String b()
  {
    return this.i;
  }

  int c()
  {
    return this.g;
  }

  public int d()
  {
    return this.h;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int k = 0;
    if (!(paramObject instanceof Status));
    while (true)
    {
      return k;
      Status localStatus = (Status)paramObject;
      if ((this.g != localStatus.g) || (this.h != localStatus.h) || (!kt.a(this.i, localStatus.i)) || (!kt.a(this.j, localStatus.j)))
        continue;
      k = 1;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(this.g);
    arrayOfObject[1] = Integer.valueOf(this.h);
    arrayOfObject[2] = this.i;
    arrayOfObject[3] = this.j;
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("statusCode", e()).a("resolution", this.j).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Status
 * JD-Core Version:    0.6.0
 */