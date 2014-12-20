package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public final class SnapshotMetadataEntity
  implements SafeParcelable, SnapshotMetadata
{
  public static final c a = new c();
  private final int b;
  private final GameEntity c;
  private final PlayerEntity d;
  private final String e;
  private final Uri f;
  private final String g;
  private final String h;
  private final String i;
  private final long j;
  private final long k;
  private final float l;
  private final String m;

  SnapshotMetadataEntity(int paramInt, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, float paramFloat, String paramString5)
  {
    this.b = paramInt;
    this.c = paramGameEntity;
    this.d = paramPlayerEntity;
    this.e = paramString1;
    this.f = paramUri;
    this.g = paramString2;
    this.l = paramFloat;
    this.h = paramString3;
    this.i = paramString4;
    this.j = paramLong1;
    this.k = paramLong2;
    this.m = paramString5;
  }

  public SnapshotMetadataEntity(SnapshotMetadata paramSnapshotMetadata)
  {
    this.b = 3;
    this.c = new GameEntity(paramSnapshotMetadata.l_());
    this.d = new PlayerEntity(paramSnapshotMetadata.c());
    this.e = paramSnapshotMetadata.d();
    this.f = paramSnapshotMetadata.e();
    this.g = paramSnapshotMetadata.f();
    this.l = paramSnapshotMetadata.g();
    this.h = paramSnapshotMetadata.i();
    this.i = paramSnapshotMetadata.j();
    this.j = paramSnapshotMetadata.k();
    this.k = paramSnapshotMetadata.l();
    this.m = paramSnapshotMetadata.h();
  }

  static int a(SnapshotMetadata paramSnapshotMetadata)
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = paramSnapshotMetadata.l_();
    arrayOfObject[1] = paramSnapshotMetadata.c();
    arrayOfObject[2] = paramSnapshotMetadata.d();
    arrayOfObject[3] = paramSnapshotMetadata.e();
    arrayOfObject[4] = Float.valueOf(paramSnapshotMetadata.g());
    arrayOfObject[5] = paramSnapshotMetadata.i();
    arrayOfObject[6] = paramSnapshotMetadata.j();
    arrayOfObject[7] = Long.valueOf(paramSnapshotMetadata.k());
    arrayOfObject[8] = Long.valueOf(paramSnapshotMetadata.l());
    arrayOfObject[9] = paramSnapshotMetadata.h();
    return kt.a(arrayOfObject);
  }

  static boolean a(SnapshotMetadata paramSnapshotMetadata, Object paramObject)
  {
    int n = 1;
    if (!(paramObject instanceof SnapshotMetadata))
      n = 0;
    while (true)
    {
      return n;
      if (paramSnapshotMetadata == paramObject)
        continue;
      SnapshotMetadata localSnapshotMetadata = (SnapshotMetadata)paramObject;
      if ((kt.a(localSnapshotMetadata.l_(), paramSnapshotMetadata.l_())) && (kt.a(localSnapshotMetadata.c(), paramSnapshotMetadata.c())) && (kt.a(localSnapshotMetadata.d(), paramSnapshotMetadata.d())) && (kt.a(localSnapshotMetadata.e(), paramSnapshotMetadata.e())) && (kt.a(Float.valueOf(localSnapshotMetadata.g()), Float.valueOf(paramSnapshotMetadata.g()))) && (kt.a(localSnapshotMetadata.i(), paramSnapshotMetadata.i())) && (kt.a(localSnapshotMetadata.j(), paramSnapshotMetadata.j())) && (kt.a(Long.valueOf(localSnapshotMetadata.k()), Long.valueOf(paramSnapshotMetadata.k()))) && (kt.a(Long.valueOf(localSnapshotMetadata.l()), Long.valueOf(paramSnapshotMetadata.l()))) && (kt.a(localSnapshotMetadata.h(), paramSnapshotMetadata.h())))
        continue;
      n = 0;
    }
  }

  static String b(SnapshotMetadata paramSnapshotMetadata)
  {
    return kt.a(paramSnapshotMetadata).a("Game", paramSnapshotMetadata.l_()).a("Owner", paramSnapshotMetadata.c()).a("SnapshotId", paramSnapshotMetadata.d()).a("CoverImageUri", paramSnapshotMetadata.e()).a("CoverImageUrl", paramSnapshotMetadata.f()).a("CoverImageAspectRatio", Float.valueOf(paramSnapshotMetadata.g())).a("Description", paramSnapshotMetadata.j()).a("LastModifiedTimestamp", Long.valueOf(paramSnapshotMetadata.k())).a("PlayedTime", Long.valueOf(paramSnapshotMetadata.l())).a("UniqueName", paramSnapshotMetadata.h()).toString();
  }

  public Player c()
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

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public String f()
  {
    return this.g;
  }

  public float g()
  {
    return this.l;
  }

  public String h()
  {
    return this.m;
  }

  public int hashCode()
  {
    return a(this);
  }

  public String i()
  {
    return this.h;
  }

  public String j()
  {
    return this.i;
  }

  public long k()
  {
    return this.j;
  }

  public long l()
  {
    return this.k;
  }

  public Game l_()
  {
    return this.c;
  }

  public int m()
  {
    return this.b;
  }

  public SnapshotMetadata n()
  {
    return this;
  }

  public String toString()
  {
    return b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadataEntity
 * JD-Core Version:    0.6.0
 */