package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public final class MilestoneRef extends f
  implements Milestone
{
  MilestoneRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }

  private long i()
  {
    return b("initial_value");
  }

  public long c()
  {
    long l = 0L;
    switch (e())
    {
    case 1:
    default:
    case 3:
    case 4:
    case 2:
    }
    while (true)
    {
      return l;
      l = f();
      continue;
      l = b("current_value") - i();
    }
  }

  public String d()
  {
    return e("external_event_id");
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return c("milestone_state");
  }

  public boolean equals(Object paramObject)
  {
    return MilestoneEntity.a(this, paramObject);
  }

  public long f()
  {
    return b("target_value");
  }

  public byte[] g()
  {
    return g("completion_reward_data");
  }

  public Milestone h()
  {
    return new MilestoneEntity(this);
  }

  public int hashCode()
  {
    return MilestoneEntity.a(this);
  }

  public String j_()
  {
    return e("external_milestone_id");
  }

  public String toString()
  {
    return MilestoneEntity.b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((MilestoneEntity)h()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.MilestoneRef
 * JD-Core Version:    0.6.0
 */