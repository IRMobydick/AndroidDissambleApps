package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator
{
  static void a(ZInvitationCluster paramZInvitationCluster, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.b(paramParcel, 1, paramZInvitationCluster.c(), false);
    c.a(paramParcel, 1000, paramZInvitationCluster.b());
    c.a(paramParcel, i);
  }

  public ZInvitationCluster a(Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.a(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1:
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, InvitationEntity.CREATOR);
        break;
      case 1000:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ZInvitationCluster(j, localArrayList);
  }

  public ZInvitationCluster[] a(int paramInt)
  {
    return new ZInvitationCluster[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.multiplayer.a
 * JD-Core Version:    0.6.0
 */