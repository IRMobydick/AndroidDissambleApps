package co.vine.android;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ActionCache$1
  implements Parcelable.Creator<ActionCache>
{
  public ActionCache createFromParcel(Parcel paramParcel)
  {
    return new ActionCache(paramParcel);
  }

  public ActionCache[] newArray(int paramInt)
  {
    return new ActionCache[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ActionCache.1
 * JD-Core Version:    0.6.0
 */