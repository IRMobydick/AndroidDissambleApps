package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator
{
  static void a(QuestEntity paramQuestEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramQuestEntity.j(), paramInt, false);
    c.a(paramParcel, 2, paramQuestEntity.k_(), false);
    c.a(paramParcel, 3, paramQuestEntity.m());
    c.a(paramParcel, 4, paramQuestEntity.e(), paramInt, false);
    c.a(paramParcel, 5, paramQuestEntity.f(), false);
    c.a(paramParcel, 6, paramQuestEntity.d(), false);
    c.a(paramParcel, 7, paramQuestEntity.n());
    c.a(paramParcel, 8, paramQuestEntity.o());
    c.a(paramParcel, 9, paramQuestEntity.g(), paramInt, false);
    c.a(paramParcel, 10, paramQuestEntity.h(), false);
    c.a(paramParcel, 12, paramQuestEntity.c(), false);
    c.a(paramParcel, 13, paramQuestEntity.p());
    c.a(paramParcel, 14, paramQuestEntity.q());
    c.a(paramParcel, 15, paramQuestEntity.k());
    c.b(paramParcel, 17, paramQuestEntity.i(), false);
    c.a(paramParcel, 16, paramQuestEntity.l());
    c.a(paramParcel, 1000, paramQuestEntity.r());
    c.a(paramParcel, i);
  }

  public QuestEntity a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    GameEntity localGameEntity = null;
    String str1 = null;
    long l1 = 0L;
    Uri localUri1 = null;
    String str2 = null;
    String str3 = null;
    long l2 = 0L;
    long l3 = 0L;
    Uri localUri2 = null;
    String str4 = null;
    String str5 = null;
    long l4 = 0L;
    long l5 = 0L;
    int k = 0;
    int m = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        localGameEntity = (GameEntity)a.a(paramParcel, n, GameEntity.CREATOR);
        break;
      case 2:
        str1 = a.o(paramParcel, n);
        break;
      case 3:
        l1 = a.i(paramParcel, n);
        break;
      case 4:
        localUri1 = (Uri)a.a(paramParcel, n, Uri.CREATOR);
        break;
      case 5:
        str2 = a.o(paramParcel, n);
        break;
      case 6:
        str3 = a.o(paramParcel, n);
        break;
      case 7:
        l2 = a.i(paramParcel, n);
        break;
      case 8:
        l3 = a.i(paramParcel, n);
        break;
      case 9:
        localUri2 = (Uri)a.a(paramParcel, n, Uri.CREATOR);
        break;
      case 10:
        str4 = a.o(paramParcel, n);
        break;
      case 12:
        str5 = a.o(paramParcel, n);
        break;
      case 13:
        l4 = a.i(paramParcel, n);
        break;
      case 14:
        l5 = a.i(paramParcel, n);
        break;
      case 15:
        k = a.g(paramParcel, n);
        break;
      case 17:
        localArrayList = a.c(paramParcel, n, MilestoneEntity.a);
        break;
      case 16:
        m = a.g(paramParcel, n);
        break;
      case 1000:
        j = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + i, paramParcel);
    return new QuestEntity(j, localGameEntity, str1, l1, localUri1, str2, str3, l2, l3, localUri2, str4, str5, l4, l5, k, m, localArrayList);
  }

  public QuestEntity[] a(int paramInt)
  {
    return new QuestEntity[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.b
 * JD-Core Version:    0.6.0
 */