package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.Contents;

public class z
  implements Parcelable.Creator
{
  static void a(CloseContentsRequest paramCloseContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramCloseContentsRequest.a);
    c.a(paramParcel, 2, paramCloseContentsRequest.b, paramInt, false);
    c.a(paramParcel, 3, paramCloseContentsRequest.c, false);
    c.a(paramParcel, i);
  }

  public CloseContentsRequest a(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = a.b(paramParcel);
    int j = 0;
    Object localObject2 = null;
    if (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      Object localObject3;
      Object localObject4;
      int m;
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        localObject3 = localObject1;
        localObject4 = localObject2;
        m = j;
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        j = m;
        localObject2 = localObject4;
        localObject1 = localObject3;
        break;
        int n = a.g(paramParcel, k);
        Object localObject5 = localObject1;
        localObject4 = localObject2;
        m = n;
        localObject3 = localObject5;
        continue;
        Contents localContents = (Contents)a.a(paramParcel, k, Contents.CREATOR);
        m = j;
        localObject3 = localObject1;
        localObject4 = localContents;
        continue;
        localObject3 = a.d(paramParcel, k);
        localObject4 = localObject2;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return (CloseContentsRequest)new CloseContentsRequest(j, localObject2, localObject1);
  }

  public CloseContentsRequest[] a(int paramInt)
  {
    return new CloseContentsRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.z
 * JD-Core Version:    0.6.0
 */