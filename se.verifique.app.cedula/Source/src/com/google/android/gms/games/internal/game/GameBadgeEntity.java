package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel
  implements GameBadge
{
  public static final d a = new c();
  private final int b;
  private int c;
  private String d;
  private String e;
  private Uri f;

  GameBadgeEntity(int paramInt1, int paramInt2, String paramString1, String paramString2, Uri paramUri)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramUri;
  }

  public GameBadgeEntity(GameBadge paramGameBadge)
  {
    this.b = 1;
    this.c = paramGameBadge.e_();
    this.d = paramGameBadge.c();
    this.e = paramGameBadge.d();
    this.f = paramGameBadge.e();
  }

  static int a(GameBadge paramGameBadge)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(paramGameBadge.e_());
    arrayOfObject[1] = paramGameBadge.c();
    arrayOfObject[2] = paramGameBadge.d();
    arrayOfObject[3] = paramGameBadge.e();
    return kt.a(arrayOfObject);
  }

  static boolean a(GameBadge paramGameBadge, Object paramObject)
  {
    int i = 1;
    if (!(paramObject instanceof GameBadge))
      i = 0;
    while (true)
    {
      return i;
      if (paramGameBadge == paramObject)
        continue;
      GameBadge localGameBadge = (GameBadge)paramObject;
      if ((kt.a(Integer.valueOf(localGameBadge.e_()), paramGameBadge.c())) && (kt.a(localGameBadge.d(), paramGameBadge.e())))
        continue;
      i = 0;
    }
  }

  static String b(GameBadge paramGameBadge)
  {
    return kt.a(paramGameBadge).a("Type", Integer.valueOf(paramGameBadge.e_())).a("Title", paramGameBadge.c()).a("Description", paramGameBadge.d()).a("IconImageUri", paramGameBadge.e()).toString();
  }

  public String c()
  {
    return this.d;
  }

  public String d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public Uri e()
  {
    return this.f;
  }

  public int e_()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public int f()
  {
    return this.b;
  }

  public GameBadge g()
  {
    return this;
  }

  public int hashCode()
  {
    return a(this);
  }

  public String toString()
  {
    return b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!D())
    {
      d.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    if (this.f == null);
    for (String str = null; ; str = this.f.toString())
    {
      paramParcel.writeString(str);
      break;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.GameBadgeEntity
 * JD-Core Version:    0.6.0
 */