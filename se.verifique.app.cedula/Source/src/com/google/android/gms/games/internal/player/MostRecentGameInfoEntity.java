package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public final class MostRecentGameInfoEntity
  implements SafeParcelable, MostRecentGameInfo
{
  public static final a a = new a();
  private final int b;
  private final String c;
  private final String d;
  private final long e;
  private final Uri f;
  private final Uri g;
  private final Uri h;

  MostRecentGameInfoEntity(int paramInt, String paramString1, String paramString2, long paramLong, Uri paramUri1, Uri paramUri2, Uri paramUri3)
  {
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramLong;
    this.f = paramUri1;
    this.g = paramUri2;
    this.h = paramUri3;
  }

  public MostRecentGameInfoEntity(MostRecentGameInfo paramMostRecentGameInfo)
  {
    this.b = 2;
    this.c = paramMostRecentGameInfo.f_();
    this.d = paramMostRecentGameInfo.c();
    this.e = paramMostRecentGameInfo.d();
    this.f = paramMostRecentGameInfo.e();
    this.g = paramMostRecentGameInfo.f();
    this.h = paramMostRecentGameInfo.g();
  }

  static int a(MostRecentGameInfo paramMostRecentGameInfo)
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = paramMostRecentGameInfo.f_();
    arrayOfObject[1] = paramMostRecentGameInfo.c();
    arrayOfObject[2] = Long.valueOf(paramMostRecentGameInfo.d());
    arrayOfObject[3] = paramMostRecentGameInfo.e();
    arrayOfObject[4] = paramMostRecentGameInfo.f();
    arrayOfObject[5] = paramMostRecentGameInfo.g();
    return kt.a(arrayOfObject);
  }

  static boolean a(MostRecentGameInfo paramMostRecentGameInfo, Object paramObject)
  {
    int i = 1;
    if (!(paramObject instanceof MostRecentGameInfo))
      i = 0;
    while (true)
    {
      return i;
      if (paramMostRecentGameInfo == paramObject)
        continue;
      MostRecentGameInfo localMostRecentGameInfo = (MostRecentGameInfo)paramObject;
      if ((kt.a(localMostRecentGameInfo.f_(), paramMostRecentGameInfo.f_())) && (kt.a(localMostRecentGameInfo.c(), paramMostRecentGameInfo.c())) && (kt.a(Long.valueOf(localMostRecentGameInfo.d()), Long.valueOf(paramMostRecentGameInfo.d()))) && (kt.a(localMostRecentGameInfo.e(), paramMostRecentGameInfo.e())) && (kt.a(localMostRecentGameInfo.f(), paramMostRecentGameInfo.f())) && (kt.a(localMostRecentGameInfo.g(), paramMostRecentGameInfo.g())))
        continue;
      i = 0;
    }
  }

  static String b(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return kt.a(paramMostRecentGameInfo).a("GameId", paramMostRecentGameInfo.f_()).a("GameName", paramMostRecentGameInfo.c()).a("ActivityTimestampMillis", Long.valueOf(paramMostRecentGameInfo.d())).a("GameIconUri", paramMostRecentGameInfo.e()).a("GameHiResUri", paramMostRecentGameInfo.f()).a("GameFeaturedUri", paramMostRecentGameInfo.g()).toString();
  }

  public String c()
  {
    return this.d;
  }

  public long d()
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

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public Uri f()
  {
    return this.g;
  }

  public String f_()
  {
    return this.c;
  }

  public Uri g()
  {
    return this.h;
  }

  public int h()
  {
    return this.b;
  }

  public int hashCode()
  {
    return a(this);
  }

  public MostRecentGameInfo i()
  {
    return this;
  }

  public String toString()
  {
    return b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
 * JD-Core Version:    0.6.0
 */