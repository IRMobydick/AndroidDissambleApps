package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.d;
import com.google.android.gms.internal.kx;
import com.google.android.gms.internal.ns;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new b();
  final int a;
  final String b;
  final long c;
  final long d;
  private volatile String e = null;

  DriveId(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    this.a = paramInt;
    this.b = paramString;
    if (!"".equals(paramString));
    for (boolean bool2 = true; ; bool2 = false)
    {
      kx.b(bool2);
      if ((paramString != null) || (paramLong1 != -1L))
        bool1 = true;
      kx.b(bool1);
      this.c = paramLong1;
      this.d = paramLong2;
      return;
    }
  }

  public final String a()
  {
    if (this.e == null)
    {
      String str = Base64.encodeToString(b(), 10);
      this.e = ("DriveId:" + str);
    }
    return this.e;
  }

  final byte[] b()
  {
    d locald = new d();
    locald.a = this.a;
    if (this.b == null);
    for (String str = ""; ; str = this.b)
    {
      locald.b = str;
      locald.c = this.c;
      locald.d = this.d;
      return ns.a(locald);
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof DriveId));
    while (true)
    {
      return bool;
      DriveId localDriveId = (DriveId)paramObject;
      if (localDriveId.d != this.d)
      {
        Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
        continue;
      }
      if ((localDriveId.c == -1L) && (this.c == -1L))
      {
        bool = localDriveId.b.equals(this.b);
        continue;
      }
      if (localDriveId.c != this.c)
        continue;
      bool = true;
    }
  }

  public int hashCode()
  {
    if (this.c == -1L);
    for (int i = this.b.hashCode(); ; i = (String.valueOf(this.d) + String.valueOf(this.c)).hashCode())
      return i;
  }

  public String toString()
  {
    return a();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DriveId
 * JD-Core Version:    0.6.0
 */