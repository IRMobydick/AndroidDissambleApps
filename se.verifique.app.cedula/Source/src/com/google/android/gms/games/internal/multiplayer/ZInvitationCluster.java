package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.jn;
import com.google.android.gms.internal.kt;
import java.util.ArrayList;

public final class ZInvitationCluster
  implements SafeParcelable, Invitation
{
  public static final a a = new a();
  private final int b;
  private final ArrayList c;

  ZInvitationCluster(int paramInt, ArrayList paramArrayList)
  {
    this.b = paramInt;
    this.c = paramArrayList;
    m();
  }

  private void m()
  {
    if (!this.c.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      jn.a(bool);
      Invitation localInvitation1 = (Invitation)this.c.get(0);
      int i = this.c.size();
      int j = 1;
      while (j < i)
      {
        Invitation localInvitation2 = (Invitation)this.c.get(j);
        jn.a(localInvitation1.f().equals(localInvitation2.f()), "All the invitations must be from the same inviter");
        j += 1;
      }
    }
  }

  public int b()
  {
    return this.b;
  }

  public ArrayList c()
  {
    return new ArrayList(this.c);
  }

  public Game d()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return ((InvitationEntity)this.c.get(0)).e();
  }

  public boolean equals(Object paramObject)
  {
    int k;
    if (!(paramObject instanceof ZInvitationCluster))
      k = 0;
    while (true)
    {
      return k;
      if (this == paramObject)
      {
        k = 1;
        continue;
      }
      ZInvitationCluster localZInvitationCluster = (ZInvitationCluster)paramObject;
      if (localZInvitationCluster.c.size() != this.c.size())
      {
        k = 0;
        continue;
      }
      int i = this.c.size();
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label111;
        if (((Invitation)this.c.get(j)).equals((Invitation)localZInvitationCluster.c.get(j)))
          continue;
        k = 0;
        break;
      }
      label111: k = 1;
    }
  }

  public Participant f()
  {
    return ((InvitationEntity)this.c.get(0)).f();
  }

  public long g()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public int h()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public int hashCode()
  {
    return kt.a(this.c.toArray());
  }

  public int i()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public int j()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public Invitation k()
  {
    return this;
  }

  public ArrayList l()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.multiplayer.ZInvitationCluster
 * JD-Core Version:    0.6.0
 */