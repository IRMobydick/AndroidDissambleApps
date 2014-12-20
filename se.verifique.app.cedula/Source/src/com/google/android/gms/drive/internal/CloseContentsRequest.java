package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new z();
  final int a;
  final Contents b;
  final Boolean c;

  CloseContentsRequest(int paramInt, Contents paramContents, Boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramContents;
    this.c = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    z.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CloseContentsRequest
 * JD-Core Version:    0.6.0
 */