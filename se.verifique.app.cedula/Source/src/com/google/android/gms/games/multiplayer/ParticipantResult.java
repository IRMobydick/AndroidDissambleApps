package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.a.a;
import com.google.android.gms.internal.kx;

public final class ParticipantResult
  implements SafeParcelable
{
  public static final e a = new e();
  private final int b;
  private final String c;
  private final int d;
  private final int e;

  public ParticipantResult(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = ((String)kx.a(paramString));
    kx.a(a.a(paramInt2));
    this.d = paramInt2;
    this.e = paramInt3;
  }

  public ParticipantResult(String paramString, int paramInt1, int paramInt2)
  {
    this(1, paramString, paramInt1, paramInt2);
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

  public int d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantResult
 * JD-Core Version:    0.6.0
 */