package co.vine.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;

public class ActionCache
  implements Parcelable
{
  public static final Parcelable.Creator<ActionCache> CREATOR = new ActionCache.1();
  protected final HashMap<Long, Boolean> mCache;

  public ActionCache()
  {
    this.mCache = new HashMap();
  }

  public ActionCache(Parcel paramParcel)
  {
    this.mCache = ((HashMap)paramParcel.readSerializable());
  }

  public void clear()
  {
    this.mCache.clear();
  }

  public boolean contains(long paramLong)
  {
    return this.mCache.containsKey(Long.valueOf(paramLong));
  }

  public int describeContents()
  {
    return 0;
  }

  public void removeEntry(long paramLong)
  {
    this.mCache.remove(Long.valueOf(paramLong));
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeSerializable(this.mCache);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ActionCache
 * JD-Core Version:    0.6.0
 */