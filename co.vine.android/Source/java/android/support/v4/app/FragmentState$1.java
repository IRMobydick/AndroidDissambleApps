package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class FragmentState$1
  implements Parcelable.Creator<FragmentState>
{
  public FragmentState createFromParcel(Parcel paramParcel)
  {
    return new FragmentState(paramParcel);
  }

  public FragmentState[] newArray(int paramInt)
  {
    return new FragmentState[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentState.1
 * JD-Core Version:    0.6.0
 */