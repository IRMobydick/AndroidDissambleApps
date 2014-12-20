package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator
{
  static void a(GameRequestCluster paramGameRequestCluster, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.b(paramParcel, 1, paramGameRequestCluster.c(), false);
    c.a(paramParcel, 1000, paramGameRequestCluster.b());
    c.a(paramParcel, i);
  }

  public GameRequestCluster a(Parcel paramParcel)
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
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, GameRequestEntity.a);
        break;
      case 1000:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new GameRequestCluster(j, localArrayList);
  }

  public GameRequestCluster[] a(int paramInt)
  {
    return new GameRequestCluster[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.request.a
 * JD-Core Version:    0.6.0
 */