package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel
  implements Participant
{
  public static final Parcelable.Creator CREATOR = new c();
  private final int a;
  private final String b;
  private final String c;
  private final Uri d;
  private final Uri e;
  private final int f;
  private final String g;
  private final boolean h;
  private final PlayerEntity i;
  private final int j;
  private final ParticipantResult k;
  private final String l;
  private final String m;

  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramUri1;
    this.e = paramUri2;
    this.f = paramInt2;
    this.g = paramString3;
    this.h = paramBoolean;
    this.i = paramPlayerEntity;
    this.j = paramInt3;
    this.k = paramParticipantResult;
    this.l = paramString4;
    this.m = paramString5;
  }

  public ParticipantEntity(Participant paramParticipant)
  {
    this.a = 3;
    this.b = paramParticipant.k();
    this.c = paramParticipant.f();
    this.d = paramParticipant.g();
    this.e = paramParticipant.i();
    this.f = paramParticipant.g_();
    this.g = paramParticipant.c();
    this.h = paramParticipant.e();
    Player localPlayer = paramParticipant.l();
    if (localPlayer == null);
    for (PlayerEntity localPlayerEntity = null; ; localPlayerEntity = new PlayerEntity(localPlayer))
    {
      this.i = localPlayerEntity;
      this.j = paramParticipant.d();
      this.k = paramParticipant.m();
      this.l = paramParticipant.h();
      this.m = paramParticipant.j();
      return;
    }
  }

  static int a(Participant paramParticipant)
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = paramParticipant.l();
    arrayOfObject[1] = Integer.valueOf(paramParticipant.g_());
    arrayOfObject[2] = paramParticipant.c();
    arrayOfObject[3] = Boolean.valueOf(paramParticipant.e());
    arrayOfObject[4] = paramParticipant.f();
    arrayOfObject[5] = paramParticipant.g();
    arrayOfObject[6] = paramParticipant.i();
    arrayOfObject[7] = Integer.valueOf(paramParticipant.d());
    arrayOfObject[8] = paramParticipant.m();
    arrayOfObject[9] = paramParticipant.k();
    return kt.a(arrayOfObject);
  }

  static boolean a(Participant paramParticipant, Object paramObject)
  {
    int n = 1;
    if (!(paramObject instanceof Participant))
      n = 0;
    while (true)
    {
      return n;
      if (paramParticipant == paramObject)
        continue;
      Participant localParticipant = (Participant)paramObject;
      if ((kt.a(localParticipant.l(), paramParticipant.l())) && (kt.a(Integer.valueOf(localParticipant.g_()), Integer.valueOf(paramParticipant.g_()))) && (kt.a(localParticipant.c(), paramParticipant.c())) && (kt.a(Boolean.valueOf(localParticipant.e()), Boolean.valueOf(paramParticipant.e()))) && (kt.a(localParticipant.f(), paramParticipant.f())) && (kt.a(localParticipant.g(), paramParticipant.g())) && (kt.a(localParticipant.i(), paramParticipant.i())) && (kt.a(Integer.valueOf(localParticipant.d()), Integer.valueOf(paramParticipant.d()))) && (kt.a(localParticipant.m(), paramParticipant.m())) && (kt.a(localParticipant.k(), paramParticipant.k())))
        continue;
      n = 0;
    }
  }

  static String b(Participant paramParticipant)
  {
    return kt.a(paramParticipant).a("ParticipantId", paramParticipant.k()).a("Player", paramParticipant.l()).a("Status", Integer.valueOf(paramParticipant.g_())).a("ClientAddress", paramParticipant.c()).a("ConnectedToRoom", Boolean.valueOf(paramParticipant.e())).a("DisplayName", paramParticipant.f()).a("IconImage", paramParticipant.g()).a("IconImageUrl", paramParticipant.h()).a("HiResImage", paramParticipant.i()).a("HiResImageUrl", paramParticipant.j()).a("Capabilities", Integer.valueOf(paramParticipant.d())).a("Result", paramParticipant.m()).toString();
  }

  public String c()
  {
    return this.g;
  }

  public int d()
  {
    return this.j;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    return this.h;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public String f()
  {
    if (this.i == null);
    for (String str = this.c; ; str = this.i.c())
      return str;
  }

  public Uri g()
  {
    if (this.i == null);
    for (Uri localUri = this.d; ; localUri = this.i.d())
      return localUri;
  }

  public int g_()
  {
    return this.f;
  }

  public String h()
  {
    if (this.i == null);
    for (String str = this.l; ; str = this.i.e())
      return str;
  }

  public int hashCode()
  {
    return a(this);
  }

  public Uri i()
  {
    if (this.i == null);
    for (Uri localUri = this.e; ; localUri = this.i.f())
      return localUri;
  }

  public String j()
  {
    if (this.i == null);
    for (String str = this.m; ; str = this.i.g())
      return str;
  }

  public String k()
  {
    return this.b;
  }

  public Player l()
  {
    return this.i;
  }

  public ParticipantResult m()
  {
    return this.k;
  }

  public int n()
  {
    return this.a;
  }

  public Participant o()
  {
    return this;
  }

  public String toString()
  {
    return b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    String str1 = null;
    int n = 0;
    if (!D())
    {
      d.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    String str2;
    label45: label58: int i1;
    if (this.d == null)
    {
      str2 = null;
      paramParcel.writeString(str2);
      if (this.e != null)
        break label139;
      paramParcel.writeString(str1);
      paramParcel.writeInt(this.f);
      paramParcel.writeString(this.g);
      if (!this.h)
        break label150;
      i1 = 1;
      label89: paramParcel.writeInt(i1);
      if (this.i != null)
        break label156;
    }
    while (true)
    {
      paramParcel.writeInt(n);
      if (this.i == null)
        break;
      this.i.writeToParcel(paramParcel, paramInt);
      break;
      str2 = this.d.toString();
      break label45;
      label139: str1 = this.e.toString();
      break label58;
      label150: i1 = 0;
      break label89;
      label156: n = 1;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantEntity
 * JD-Core Version:    0.6.0
 */