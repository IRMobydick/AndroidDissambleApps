package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public final class MilestoneEntity
  implements SafeParcelable, Milestone
{
  public static final a a = new a();
  private final int b;
  private final String c;
  private final long d;
  private final long e;
  private final byte[] f;
  private final int g;
  private final String h;

  MilestoneEntity(int paramInt1, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt2, String paramString2)
  {
    this.b = paramInt1;
    this.c = paramString1;
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramArrayOfByte;
    this.g = paramInt2;
    this.h = paramString2;
  }

  public MilestoneEntity(Milestone paramMilestone)
  {
    this.b = 4;
    this.c = paramMilestone.j_();
    this.d = paramMilestone.c();
    this.e = paramMilestone.f();
    this.g = paramMilestone.e();
    this.h = paramMilestone.d();
    byte[] arrayOfByte = paramMilestone.g();
    if (arrayOfByte == null)
      this.f = null;
    while (true)
    {
      return;
      this.f = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.f, 0, arrayOfByte.length);
    }
  }

  static int a(Milestone paramMilestone)
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = paramMilestone.j_();
    arrayOfObject[1] = Long.valueOf(paramMilestone.c());
    arrayOfObject[2] = Long.valueOf(paramMilestone.f());
    arrayOfObject[3] = Integer.valueOf(paramMilestone.e());
    arrayOfObject[4] = paramMilestone.d();
    return kt.a(arrayOfObject);
  }

  static boolean a(Milestone paramMilestone, Object paramObject)
  {
    int i = 1;
    if (!(paramObject instanceof Milestone))
      i = 0;
    while (true)
    {
      return i;
      if (paramMilestone == paramObject)
        continue;
      Milestone localMilestone = (Milestone)paramObject;
      if ((kt.a(localMilestone.j_(), paramMilestone.j_())) && (kt.a(Long.valueOf(localMilestone.c()), Long.valueOf(paramMilestone.c()))) && (kt.a(Long.valueOf(localMilestone.f()), Long.valueOf(paramMilestone.f()))) && (kt.a(Integer.valueOf(localMilestone.e()), Integer.valueOf(paramMilestone.e()))) && (kt.a(localMilestone.d(), paramMilestone.d())))
        continue;
      i = 0;
    }
  }

  static String b(Milestone paramMilestone)
  {
    return kt.a(paramMilestone).a("MilestoneId", paramMilestone.j_()).a("CurrentProgress", Long.valueOf(paramMilestone.c())).a("TargetProgress", Long.valueOf(paramMilestone.f())).a("State", Integer.valueOf(paramMilestone.e())).a("CompletionRewardData", paramMilestone.g()).a("EventId", paramMilestone.d()).toString();
  }

  public long c()
  {
    return this.d;
  }

  public String d()
  {
    return this.h;
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return this.g;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public long f()
  {
    return this.e;
  }

  public byte[] g()
  {
    return this.f;
  }

  public int h()
  {
    return this.b;
  }

  public int hashCode()
  {
    return a(this);
  }

  public Milestone i()
  {
    return this;
  }

  public String j_()
  {
    return this.c;
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
 * Qualified Name:     com.google.android.gms.games.quest.MilestoneEntity
 * JD-Core Version:    0.6.0
 */