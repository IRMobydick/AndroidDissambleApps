package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jf;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new b();
  String a;
  private final int b;
  private String c;
  private Inet4Address d;
  private String e;
  private String f;
  private String g;
  private int h;
  private List i;
  private int j;

  private CastDevice()
  {
    this(2, null, null, null, null, null, -1, new ArrayList(), 0);
  }

  CastDevice(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, List paramList, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramString1;
    this.a = paramString2;
    if (this.a != null);
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(this.a);
      if ((localInetAddress instanceof Inet4Address))
        this.d = ((Inet4Address)localInetAddress);
      this.e = paramString3;
      this.f = paramString4;
      this.g = paramString5;
      this.h = paramInt2;
      this.i = paramList;
      this.j = paramInt3;
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      while (true)
        this.d = null;
    }
  }

  int a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public String c()
  {
    return this.e;
  }

  public String d()
  {
    return this.f;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.g;
  }

  public boolean equals(Object paramObject)
  {
    int k = 1;
    if (paramObject == this);
    while (true)
    {
      return k;
      if (!(paramObject instanceof CastDevice))
      {
        k = 0;
        continue;
      }
      CastDevice localCastDevice = (CastDevice)paramObject;
      if (b() == null)
      {
        if (localCastDevice.b() == null)
          continue;
        k = 0;
        continue;
      }
      if ((jf.a(this.c, localCastDevice.c)) && (jf.a(this.d, localCastDevice.d)) && (jf.a(this.f, localCastDevice.f)) && (jf.a(this.e, localCastDevice.e)) && (jf.a(this.g, localCastDevice.g)) && (this.h == localCastDevice.h) && (jf.a(this.i, localCastDevice.i)) && (this.j == localCastDevice.j))
        continue;
      k = 0;
    }
  }

  public int f()
  {
    return this.h;
  }

  public List g()
  {
    return Collections.unmodifiableList(this.i);
  }

  public int h()
  {
    return this.j;
  }

  public int hashCode()
  {
    if (this.c == null);
    for (int k = 0; ; k = this.c.hashCode())
      return k;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.e;
    arrayOfObject[1] = this.c;
    return String.format("\"%s\" (%s)", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.CastDevice
 * JD-Core Version:    0.6.0
 */