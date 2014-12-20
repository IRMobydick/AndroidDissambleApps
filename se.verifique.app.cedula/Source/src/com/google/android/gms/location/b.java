package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;

public class b
  implements SafeParcelable
{
  public static final e d = new e();
  int a;
  int b;
  long c;
  private final int e;

  b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.e = paramInt1;
    this.a = paramInt2;
    this.b = paramInt3;
    this.c = paramLong;
  }

  private String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 1:
    default:
      str = "STATUS_UNKNOWN";
    case 0:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    while (true)
    {
      return str;
      str = "STATUS_SUCCESSFUL";
      continue;
      str = "STATUS_TIMED_OUT_ON_SCAN";
      continue;
      str = "STATUS_NO_INFO_IN_DATABASE";
      continue;
      str = "STATUS_INVALID_SCAN";
      continue;
      str = "STATUS_UNABLE_TO_QUERY_DATABASE";
      continue;
      str = "STATUS_SCANS_DISABLED_IN_SETTINGS";
      continue;
      str = "STATUS_LOCATION_DISABLED_IN_SETTINGS";
      continue;
      str = "STATUS_IN_PROGRESS";
    }
  }

  int a()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 0;
    if (!(paramObject instanceof b));
    while (true)
    {
      return i;
      b localb = (b)paramObject;
      if ((this.a != localb.a) || (this.b != localb.b) || (this.c != localb.c))
        continue;
      i = 1;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = Integer.valueOf(this.b);
    arrayOfObject[2] = Long.valueOf(this.c);
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationStatus[cell status: ").append(a(this.a));
    localStringBuilder.append(", wifi status: ").append(a(this.b));
    localStringBuilder.append(", elapsed realtime ns: ").append(this.c);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.b
 * JD-Core Version:    0.6.0
 */