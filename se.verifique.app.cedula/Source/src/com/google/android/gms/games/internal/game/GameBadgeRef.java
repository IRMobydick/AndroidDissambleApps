package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public final class GameBadgeRef extends f
  implements GameBadge
{
  GameBadgeRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  public String c()
  {
    return e("badge_title");
  }

  public String d()
  {
    return e("badge_description");
  }

  public int describeContents()
  {
    return 0;
  }

  public Uri e()
  {
    return h("badge_icon_image_uri");
  }

  public int e_()
  {
    return c("badge_type");
  }

  public boolean equals(Object paramObject)
  {
    return GameBadgeEntity.a(this, paramObject);
  }

  public GameBadge f()
  {
    return new GameBadgeEntity(this);
  }

  public int hashCode()
  {
    return GameBadgeEntity.a(this);
  }

  public String toString()
  {
    return GameBadgeEntity.b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((GameBadgeEntity)f()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.GameBadgeRef
 * JD-Core Version:    0.6.0
 */