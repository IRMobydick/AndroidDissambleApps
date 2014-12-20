package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kx;

public final class SnapshotMetadataChange
  implements SafeParcelable
{
  public static final b a = new b();
  public static final SnapshotMetadataChange b = new SnapshotMetadataChange();
  private final int c;
  private final String d;
  private final Long e;
  private final Uri f;
  private a g;

  SnapshotMetadataChange()
  {
    this(4, null, null, null, null);
  }

  SnapshotMetadataChange(int paramInt, String paramString, Long paramLong, a parama, Uri paramUri)
  {
    this.c = paramInt;
    this.d = paramString;
    this.e = paramLong;
    this.g = parama;
    this.f = paramUri;
    if (this.g != null)
      if (this.f == null)
        kx.a(bool, "Cannot set both a URI and an image");
    do
    {
      return;
      bool = false;
      break;
    }
    while (this.f == null);
    if (this.g == null);
    while (true)
    {
      kx.a(bool, "Cannot set both a URI and an image");
      break;
      bool = false;
    }
  }

  public int a()
  {
    return this.c;
  }

  public String b()
  {
    return this.d;
  }

  public Long c()
  {
    return this.e;
  }

  public a d()
  {
    return this.g;
  }

  public int describeContents()
  {
    return 0;
  }

  public Uri e()
  {
    return this.f;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadataChange
 * JD-Core Version:    0.6.0
 */