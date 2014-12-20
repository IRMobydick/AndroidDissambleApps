package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ActivityRecognitionResult
  implements SafeParcelable
{
  public static final a a = new a();
  List b;
  long c;
  long d;
  private final int e = 1;

  public ActivityRecognitionResult(int paramInt, List paramList, long paramLong1, long paramLong2)
  {
    this.b = paramList;
    this.c = paramLong1;
    this.d = paramLong2;
  }

  public int a()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "ActivityRecognitionResult [probableActivities=" + this.b + ", timeMillis=" + this.c + ", elapsedRealtimeMillis=" + this.d + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionResult
 * JD-Core Version:    0.6.0
 */