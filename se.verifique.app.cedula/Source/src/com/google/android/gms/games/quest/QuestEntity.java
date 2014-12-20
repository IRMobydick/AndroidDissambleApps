package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity
  implements SafeParcelable, Quest
{
  public static final b c = new b();
  private final int d;
  private final GameEntity e;
  private final String f;
  private final long g;
  private final Uri h;
  private final String i;
  private final String j;
  private final long k;
  private final long l;
  private final Uri m;
  private final String n;
  private final String o;
  private final long p;
  private final long q;
  private final int r;
  private final int s;
  private final ArrayList t;

  QuestEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, long paramLong1, Uri paramUri1, String paramString2, String paramString3, long paramLong2, long paramLong3, Uri paramUri2, String paramString4, String paramString5, long paramLong4, long paramLong5, int paramInt2, int paramInt3, ArrayList paramArrayList)
  {
    this.d = paramInt1;
    this.e = paramGameEntity;
    this.f = paramString1;
    this.g = paramLong1;
    this.h = paramUri1;
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramLong2;
    this.l = paramLong3;
    this.m = paramUri2;
    this.n = paramString4;
    this.o = paramString5;
    this.p = paramLong4;
    this.q = paramLong5;
    this.r = paramInt2;
    this.s = paramInt3;
    this.t = paramArrayList;
  }

  public QuestEntity(Quest paramQuest)
  {
    this.d = 2;
    this.e = new GameEntity(paramQuest.j());
    this.f = paramQuest.k_();
    this.g = paramQuest.m();
    this.j = paramQuest.d();
    this.h = paramQuest.e();
    this.i = paramQuest.f();
    this.k = paramQuest.n();
    this.m = paramQuest.g();
    this.n = paramQuest.h();
    this.l = paramQuest.o();
    this.o = paramQuest.c();
    this.p = paramQuest.p();
    this.q = paramQuest.q();
    this.r = paramQuest.k();
    this.s = paramQuest.l();
    List localList = paramQuest.i();
    int i1 = localList.size();
    this.t = new ArrayList(i1);
    for (int i2 = 0; i2 < i1; i2++)
      this.t.add((MilestoneEntity)(MilestoneEntity)((Milestone)localList.get(i2)).a());
  }

  static int a(Quest paramQuest)
  {
    Object[] arrayOfObject = new Object[13];
    arrayOfObject[0] = paramQuest.j();
    arrayOfObject[1] = paramQuest.k_();
    arrayOfObject[2] = Long.valueOf(paramQuest.m());
    arrayOfObject[3] = paramQuest.e();
    arrayOfObject[4] = paramQuest.d();
    arrayOfObject[5] = Long.valueOf(paramQuest.n());
    arrayOfObject[6] = paramQuest.g();
    arrayOfObject[7] = Long.valueOf(paramQuest.o());
    arrayOfObject[8] = paramQuest.i();
    arrayOfObject[9] = paramQuest.c();
    arrayOfObject[10] = Long.valueOf(paramQuest.p());
    arrayOfObject[11] = Long.valueOf(paramQuest.q());
    arrayOfObject[12] = Integer.valueOf(paramQuest.k());
    return kt.a(arrayOfObject);
  }

  static boolean a(Quest paramQuest, Object paramObject)
  {
    int i1 = 1;
    if (!(paramObject instanceof Quest))
      i1 = 0;
    while (true)
    {
      return i1;
      if (paramQuest == paramObject)
        continue;
      Quest localQuest = (Quest)paramObject;
      if ((kt.a(localQuest.j(), paramQuest.j())) && (kt.a(localQuest.k_(), paramQuest.k_())) && (kt.a(Long.valueOf(localQuest.m()), Long.valueOf(paramQuest.m()))) && (kt.a(localQuest.e(), paramQuest.e())) && (kt.a(localQuest.d(), paramQuest.d())) && (kt.a(Long.valueOf(localQuest.n()), Long.valueOf(paramQuest.n()))) && (kt.a(localQuest.g(), paramQuest.g())) && (kt.a(Long.valueOf(localQuest.o()), Long.valueOf(paramQuest.o()))) && (kt.a(localQuest.i(), paramQuest.i())) && (kt.a(localQuest.c(), paramQuest.c())) && (kt.a(Long.valueOf(localQuest.p()), Long.valueOf(paramQuest.p()))) && (kt.a(Long.valueOf(localQuest.q()), Long.valueOf(paramQuest.q()))) && (kt.a(Integer.valueOf(localQuest.k()), Integer.valueOf(paramQuest.k()))))
        continue;
      i1 = 0;
    }
  }

  static String b(Quest paramQuest)
  {
    return kt.a(paramQuest).a("Game", paramQuest.j()).a("QuestId", paramQuest.k_()).a("AcceptedTimestamp", Long.valueOf(paramQuest.m())).a("BannerImageUri", paramQuest.e()).a("BannerImageUrl", paramQuest.f()).a("Description", paramQuest.d()).a("EndTimestamp", Long.valueOf(paramQuest.n())).a("IconImageUri", paramQuest.g()).a("IconImageUrl", paramQuest.h()).a("LastUpdatedTimestamp", Long.valueOf(paramQuest.o())).a("Milestones", paramQuest.i()).a("Name", paramQuest.c()).a("NotifyTimestamp", Long.valueOf(paramQuest.p())).a("StartTimestamp", Long.valueOf(paramQuest.q())).a("State", Integer.valueOf(paramQuest.k())).toString();
  }

  public String c()
  {
    return this.o;
  }

  public String d()
  {
    return this.j;
  }

  public int describeContents()
  {
    return 0;
  }

  public Uri e()
  {
    return this.h;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public String f()
  {
    return this.i;
  }

  public Uri g()
  {
    return this.m;
  }

  public String h()
  {
    return this.n;
  }

  public int hashCode()
  {
    return a(this);
  }

  public List i()
  {
    return new ArrayList(this.t);
  }

  public Game j()
  {
    return this.e;
  }

  public int k()
  {
    return this.r;
  }

  public String k_()
  {
    return this.f;
  }

  public int l()
  {
    return this.s;
  }

  public long m()
  {
    return this.g;
  }

  public long n()
  {
    return this.k;
  }

  public long o()
  {
    return this.l;
  }

  public long p()
  {
    return this.p;
  }

  public long q()
  {
    return this.q;
  }

  public int r()
  {
    return this.d;
  }

  public Quest s()
  {
    return this;
  }

  public String toString()
  {
    return b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.QuestEntity
 * JD-Core Version:    0.6.0
 */