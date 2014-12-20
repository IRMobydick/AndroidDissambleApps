package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class t
  implements Parcelable.Creator
{
  public FragmentState a(Parcel paramParcel)
  {
    return new FragmentState(paramParcel);
  }

  public FragmentState[] a(int paramInt)
  {
    return new FragmentState[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.t
 * JD-Core Version:    0.6.0
 */