package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class BackStackState$1
  implements Parcelable.Creator<BackStackState>
{
  public BackStackState createFromParcel(Parcel paramParcel)
  {
    return new BackStackState(paramParcel);
  }

  public BackStackState[] newArray(int paramInt)
  {
    return new BackStackState[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackState.1
 * JD-Core Version:    0.6.0
 */