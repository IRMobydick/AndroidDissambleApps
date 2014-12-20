package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator
{
  public DrawerLayout.SavedState a(Parcel paramParcel)
  {
    return new DrawerLayout.SavedState(paramParcel);
  }

  public DrawerLayout.SavedState[] a(int paramInt)
  {
    return new DrawerLayout.SavedState[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.c
 * JD-Core Version:    0.6.0
 */