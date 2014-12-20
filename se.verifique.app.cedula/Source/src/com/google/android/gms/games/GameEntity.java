package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public final class GameEntity extends GamesDowngradeableSafeParcel
  implements Game
{
  public static final Parcelable.Creator CREATOR = new a();
  private final int a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final Uri h;
  private final Uri i;
  private final Uri j;
  private final boolean k;
  private final boolean l;
  private final String m;
  private final int n;
  private final int o;
  private final int p;
  private final boolean q;
  private final boolean r;
  private final String s;
  private final String t;
  private final String u;
  private final boolean v;
  private final boolean w;
  private final boolean x;

  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramUri1;
    this.s = paramString8;
    this.i = paramUri2;
    this.t = paramString9;
    this.j = paramUri3;
    this.u = paramString10;
    this.k = paramBoolean1;
    this.l = paramBoolean2;
    this.m = paramString7;
    this.n = paramInt2;
    this.o = paramInt3;
    this.p = paramInt4;
    this.q = paramBoolean3;
    this.r = paramBoolean4;
    this.v = paramBoolean5;
    this.w = paramBoolean6;
    this.x = paramBoolean7;
  }

  public GameEntity(Game paramGame)
  {
    this.a = 4;
    this.b = paramGame.a_();
    this.d = paramGame.d();
    this.e = paramGame.e();
    this.f = paramGame.f();
    this.g = paramGame.g();
    this.c = paramGame.c();
    this.h = paramGame.h();
    this.s = paramGame.i();
    this.i = paramGame.j();
    this.t = paramGame.k();
    this.j = paramGame.l();
    this.u = paramGame.m();
    this.k = paramGame.n();
    this.l = paramGame.q();
    this.m = paramGame.r();
    this.n = paramGame.s();
    this.o = paramGame.t();
    this.p = paramGame.u();
    this.q = paramGame.v();
    this.r = paramGame.w();
    this.v = paramGame.o();
    this.w = paramGame.p();
    this.x = paramGame.x();
  }

  static int a(Game paramGame)
  {
    Object[] arrayOfObject = new Object[20];
    arrayOfObject[0] = paramGame.a_();
    arrayOfObject[1] = paramGame.c();
    arrayOfObject[2] = paramGame.d();
    arrayOfObject[3] = paramGame.e();
    arrayOfObject[4] = paramGame.f();
    arrayOfObject[5] = paramGame.g();
    arrayOfObject[6] = paramGame.h();
    arrayOfObject[7] = paramGame.j();
    arrayOfObject[8] = paramGame.l();
    arrayOfObject[9] = Boolean.valueOf(paramGame.n());
    arrayOfObject[10] = Boolean.valueOf(paramGame.q());
    arrayOfObject[11] = paramGame.r();
    arrayOfObject[12] = Integer.valueOf(paramGame.s());
    arrayOfObject[13] = Integer.valueOf(paramGame.t());
    arrayOfObject[14] = Integer.valueOf(paramGame.u());
    arrayOfObject[15] = Boolean.valueOf(paramGame.v());
    arrayOfObject[16] = Boolean.valueOf(paramGame.w());
    arrayOfObject[17] = Boolean.valueOf(paramGame.o());
    arrayOfObject[18] = Boolean.valueOf(paramGame.p());
    arrayOfObject[19] = Boolean.valueOf(paramGame.x());
    return kt.a(arrayOfObject);
  }

  static boolean a(Game paramGame, Object paramObject)
  {
    boolean bool1 = true;
    if (!(paramObject instanceof Game))
      bool1 = false;
    label460: label464: 
    while (true)
    {
      return bool1;
      if (paramGame == paramObject)
        continue;
      Game localGame = (Game)paramObject;
      Boolean localBoolean;
      if ((kt.a(localGame.a_(), paramGame.a_())) && (kt.a(localGame.c(), paramGame.c())) && (kt.a(localGame.d(), paramGame.d())) && (kt.a(localGame.e(), paramGame.e())) && (kt.a(localGame.f(), paramGame.f())) && (kt.a(localGame.g(), paramGame.g())) && (kt.a(localGame.h(), paramGame.h())) && (kt.a(localGame.j(), paramGame.j())) && (kt.a(localGame.l(), paramGame.l())) && (kt.a(Boolean.valueOf(localGame.n()), Boolean.valueOf(paramGame.n()))) && (kt.a(Boolean.valueOf(localGame.q()), Boolean.valueOf(paramGame.q()))) && (kt.a(localGame.r(), paramGame.r())) && (kt.a(Integer.valueOf(localGame.s()), Integer.valueOf(paramGame.s()))) && (kt.a(Integer.valueOf(localGame.t()), Integer.valueOf(paramGame.t()))) && (kt.a(Integer.valueOf(localGame.u()), Integer.valueOf(paramGame.u()))) && (kt.a(Boolean.valueOf(localGame.v()), Boolean.valueOf(paramGame.v()))))
      {
        localBoolean = Boolean.valueOf(localGame.w());
        if ((!paramGame.w()) || (!kt.a(Boolean.valueOf(localGame.o()), Boolean.valueOf(paramGame.o()))) || (!kt.a(Boolean.valueOf(localGame.p()), Boolean.valueOf(paramGame.p()))))
          break label460;
      }
      for (boolean bool2 = bool1; ; bool2 = false)
      {
        if ((kt.a(localBoolean, Boolean.valueOf(bool2))) && (kt.a(Boolean.valueOf(localGame.x()), Boolean.valueOf(paramGame.x()))))
          break label464;
        bool1 = false;
        break;
      }
    }
  }

  static String b(Game paramGame)
  {
    return kt.a(paramGame).a("ApplicationId", paramGame.a_()).a("DisplayName", paramGame.c()).a("PrimaryCategory", paramGame.d()).a("SecondaryCategory", paramGame.e()).a("Description", paramGame.f()).a("DeveloperName", paramGame.g()).a("IconImageUri", paramGame.h()).a("IconImageUrl", paramGame.i()).a("HiResImageUri", paramGame.j()).a("HiResImageUrl", paramGame.k()).a("FeaturedImageUri", paramGame.l()).a("FeaturedImageUrl", paramGame.m()).a("PlayEnabledGame", Boolean.valueOf(paramGame.n())).a("InstanceInstalled", Boolean.valueOf(paramGame.q())).a("InstancePackageName", paramGame.r()).a("AchievementTotalCount", Integer.valueOf(paramGame.t())).a("LeaderboardCount", Integer.valueOf(paramGame.u())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.v())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.w())).a("AreSnapshotsEnabled", Boolean.valueOf(paramGame.x())).toString();
  }

  public String a_()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public String f()
  {
    return this.f;
  }

  public String g()
  {
    return this.g;
  }

  public Uri h()
  {
    return this.h;
  }

  public int hashCode()
  {
    return a(this);
  }

  public String i()
  {
    return this.s;
  }

  public Uri j()
  {
    return this.i;
  }

  public String k()
  {
    return this.t;
  }

  public Uri l()
  {
    return this.j;
  }

  public String m()
  {
    return this.u;
  }

  public boolean n()
  {
    return this.k;
  }

  public boolean o()
  {
    return this.v;
  }

  public boolean p()
  {
    return this.w;
  }

  public boolean q()
  {
    return this.l;
  }

  public String r()
  {
    return this.m;
  }

  public int s()
  {
    return this.n;
  }

  public int t()
  {
    return this.o;
  }

  public String toString()
  {
    return b(this);
  }

  public int u()
  {
    return this.p;
  }

  public boolean v()
  {
    return this.q;
  }

  public boolean w()
  {
    return this.r;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    String str1 = null;
    if (!D())
    {
      b.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    String str2;
    label77: String str3;
    label93: label106: int i2;
    if (this.h == null)
    {
      str2 = null;
      paramParcel.writeString(str2);
      if (this.i != null)
        break label187;
      str3 = null;
      paramParcel.writeString(str3);
      if (this.j != null)
        break label199;
      paramParcel.writeString(str1);
      if (!this.k)
        break label211;
      i2 = i1;
      label122: paramParcel.writeInt(i2);
      if (!this.l)
        break label217;
    }
    while (true)
    {
      paramParcel.writeInt(i1);
      paramParcel.writeString(this.m);
      paramParcel.writeInt(this.n);
      paramParcel.writeInt(this.o);
      paramParcel.writeInt(this.p);
      break;
      str2 = this.h.toString();
      break label77;
      label187: str3 = this.i.toString();
      break label93;
      label199: str1 = this.j.toString();
      break label106;
      label211: i2 = 0;
      break label122;
      label217: i1 = 0;
    }
  }

  public boolean x()
  {
    return this.x;
  }

  public int y()
  {
    return this.a;
  }

  public Game z()
  {
    return this;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.GameEntity
 * JD-Core Version:    0.6.0
 */