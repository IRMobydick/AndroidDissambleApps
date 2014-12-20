package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public final class MostRecentGameInfoRef extends f
  implements MostRecentGameInfo
{
  private final b c;

  public MostRecentGameInfoRef(DataHolder paramDataHolder, int paramInt, b paramb)
  {
    super(paramDataHolder, paramInt);
    this.c = paramb;
  }

  public String c()
  {
    return e(this.c.t);
  }

  public long d()
  {
    return b(this.c.u);
  }

  public int describeContents()
  {
    return 0;
  }

  public Uri e()
  {
    return h(this.c.v);
  }

  public boolean equals(Object paramObject)
  {
    return MostRecentGameInfoEntity.a(this, paramObject);
  }

  public Uri f()
  {
    return h(this.c.w);
  }

  public String f_()
  {
    return e(this.c.s);
  }

  public Uri g()
  {
    return h(this.c.x);
  }

  public MostRecentGameInfo h()
  {
    return new MostRecentGameInfoEntity(this);
  }

  public int hashCode()
  {
    return MostRecentGameInfoEntity.a(this);
  }

  public String toString()
  {
    return MostRecentGameInfoEntity.b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((MostRecentGameInfoEntity)h()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.MostRecentGameInfoRef
 * JD-Core Version:    0.6.0
 */