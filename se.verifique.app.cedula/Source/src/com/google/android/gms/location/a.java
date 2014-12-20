package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator
{
  static void a(ActivityRecognitionResult paramActivityRecognitionResult, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.b(paramParcel, 1, paramActivityRecognitionResult.b, false);
    c.a(paramParcel, 1000, paramActivityRecognitionResult.a());
    c.a(paramParcel, 2, paramActivityRecognitionResult.c);
    c.a(paramParcel, 3, paramActivityRecognitionResult.d);
    c.a(paramParcel, i);
  }

  public ActivityRecognitionResult a(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
    long l2 = l1;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.a(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1:
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, DetectedActivity.a);
        break;
      case 1000:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2:
        l2 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, k);
        break;
      case 3:
        l1 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ActivityRecognitionResult(j, localArrayList, l2, l1);
  }

  public ActivityRecognitionResult[] a(int paramInt)
  {
    return new ActivityRecognitionResult[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.a
 * JD-Core Version:    0.6.0
 */