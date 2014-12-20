package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;

public class h
  implements Parcelable.Creator
{
  static void a(OnEventResponse paramOnEventResponse, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramOnEventResponse.a);
    c.a(paramParcel, 2, paramOnEventResponse.b);
    c.a(paramParcel, 3, paramOnEventResponse.c, paramInt, false);
    c.a(paramParcel, 4, paramOnEventResponse.d, paramInt, false);
    c.a(paramParcel, i);
  }

  public OnEventResponse a(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = 0;
    int j = a.b(paramParcel);
    Object localObject2 = null;
    int k = 0;
    if (paramParcel.dataPosition() < j)
    {
      int m = a.a(paramParcel);
      Object localObject3;
      Object localObject4;
      int n;
      int i1;
      switch (a.a(m))
      {
      default:
        a.b(paramParcel, m);
        localObject3 = localObject1;
        localObject4 = localObject2;
        n = i;
        i1 = k;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        k = i1;
        i = n;
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
        int i3 = a.g(paramParcel, m);
        Object localObject7 = localObject1;
        localObject4 = localObject2;
        n = i;
        i1 = i3;
        localObject3 = localObject7;
        continue;
        int i2 = a.g(paramParcel, m);
        i1 = k;
        Object localObject6 = localObject2;
        n = i2;
        localObject3 = localObject1;
        localObject4 = localObject6;
        continue;
        ChangeEvent localChangeEvent = (ChangeEvent)a.a(paramParcel, m, ChangeEvent.CREATOR);
        n = i;
        i1 = k;
        Object localObject5 = localObject1;
        localObject4 = localChangeEvent;
        localObject3 = localObject5;
        continue;
        localObject3 = (FileConflictEvent)a.a(paramParcel, m, FileConflictEvent.CREATOR);
        localObject4 = localObject2;
        n = i;
        i1 = k;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return (OnEventResponse)new OnEventResponse(k, i, localObject2, localObject1);
  }

  public OnEventResponse[] a(int paramInt)
  {
    return new OnEventResponse[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.h
 * JD-Core Version:    0.6.0
 */