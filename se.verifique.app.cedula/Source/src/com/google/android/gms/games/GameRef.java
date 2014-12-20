package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public final class GameRef extends f
  implements Game
{
  public GameRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  public String a_()
  {
    return e("external_game_id");
  }

  public String c()
  {
    return e("display_name");
  }

  public String d()
  {
    return e("primary_category");
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return e("secondary_category");
  }

  public boolean equals(Object paramObject)
  {
    return GameEntity.a(this, paramObject);
  }

  public String f()
  {
    return e("game_description");
  }

  public String g()
  {
    return e("developer_name");
  }

  public Uri h()
  {
    return h("game_icon_image_uri");
  }

  public int hashCode()
  {
    return GameEntity.a(this);
  }

  public String i()
  {
    return e("game_icon_image_url");
  }

  public Uri j()
  {
    return h("game_hi_res_image_uri");
  }

  public String k()
  {
    return e("game_hi_res_image_url");
  }

  public Uri l()
  {
    return h("featured_image_uri");
  }

  public String m()
  {
    return e("featured_image_url");
  }

  public boolean n()
  {
    return d("play_enabled_game");
  }

  public boolean o()
  {
    return d("muted");
  }

  public boolean p()
  {
    return d("identity_sharing_confirmed");
  }

  public boolean q()
  {
    if (c("installed") > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public String r()
  {
    return e("package_name");
  }

  public int s()
  {
    return c("gameplay_acl_status");
  }

  public int t()
  {
    return c("achievement_total_count");
  }

  public String toString()
  {
    return GameEntity.b(this);
  }

  public int u()
  {
    return c("leaderboard_count");
  }

  public boolean v()
  {
    if (c("real_time_support") > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean w()
  {
    if (c("turn_based_support") > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((GameEntity)y()).writeToParcel(paramParcel, paramInt);
  }

  public boolean x()
  {
    if (c("snapshots_enabled") > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public Game y()
  {
    return new GameEntity(this);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.GameRef
 * JD-Core Version:    0.6.0
 */