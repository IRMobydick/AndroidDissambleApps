package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class b
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  public final String k;
  public final String l;
  public final String m;
  public final String n;
  public final String o;
  public final String p;
  public final String q;
  public final String r;
  public final String s;
  public final String t;
  public final String u;
  public final String v;
  public final String w;
  public final String x;

  public b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.a = "external_player_id";
      this.b = "profile_name";
      this.c = "profile_icon_image_uri";
      this.d = "profile_icon_image_url";
      this.e = "profile_hi_res_image_uri";
      this.f = "profile_hi_res_image_url";
      this.g = "last_updated";
      this.h = "is_in_circles";
      this.i = "played_with_timestamp";
      this.j = "current_xp_total";
      this.k = "current_level";
      this.l = "current_level_min_xp";
      this.m = "current_level_max_xp";
      this.n = "next_level";
      this.o = "next_level_max_xp";
      this.p = "last_level_up_timestamp";
      this.q = "player_title";
      this.r = "has_all_public_acls";
      this.s = "most_recent_external_game_id";
      this.t = "most_recent_game_name";
      this.u = "most_recent_activity_timestamp";
      this.v = "most_recent_game_icon_uri";
      this.w = "most_recent_game_hi_res_uri";
    }
    for (this.x = "most_recent_game_featured_uri"; ; this.x = (paramString + "most_recent_game_featured_uri"))
    {
      return;
      this.a = (paramString + "external_player_id");
      this.b = (paramString + "profile_name");
      this.c = (paramString + "profile_icon_image_uri");
      this.d = (paramString + "profile_icon_image_url");
      this.e = (paramString + "profile_hi_res_image_uri");
      this.f = (paramString + "profile_hi_res_image_url");
      this.g = (paramString + "last_updated");
      this.h = (paramString + "is_in_circles");
      this.i = (paramString + "played_with_timestamp");
      this.j = (paramString + "current_xp_total");
      this.k = (paramString + "current_level");
      this.l = (paramString + "current_level_min_xp");
      this.m = (paramString + "current_level_max_xp");
      this.n = (paramString + "next_level");
      this.o = (paramString + "next_level_max_xp");
      this.p = (paramString + "last_level_up_timestamp");
      this.q = (paramString + "player_title");
      this.r = (paramString + "has_all_public_acls");
      this.s = (paramString + "most_recent_external_game_id");
      this.t = (paramString + "most_recent_game_name");
      this.u = (paramString + "most_recent_activity_timestamp");
      this.v = (paramString + "most_recent_game_icon_uri");
      this.w = (paramString + "most_recent_game_hi_res_uri");
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.b
 * JD-Core Version:    0.6.0
 */