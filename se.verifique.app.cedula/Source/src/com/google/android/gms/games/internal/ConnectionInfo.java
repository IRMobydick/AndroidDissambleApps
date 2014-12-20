package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo
  implements SafeParcelable
{
  public static final a a = new a();
  private final int b;
  private final String c;
  private final int d;

  public ConnectionInfo(int paramInt1, String paramString, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramString;
    this.d = paramInt2;
  }

  public int a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public int c()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.ConnectionInfo
 * JD-Core Version:    0.6.0
 */