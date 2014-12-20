package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d
  implements Parcelable.Creator
{
  public BackStackState a(Parcel paramParcel)
  {
    return new BackStackState(paramParcel);
  }

  public BackStackState[] a(int paramInt)
  {
    return new BackStackState[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.d
 * JD-Core Version:    0.6.0
 */