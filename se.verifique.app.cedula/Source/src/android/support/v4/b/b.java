package android.support.v4.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class b
  implements Parcelable.Creator
{
  final c a;

  public b(c paramc)
  {
    this.a = paramc;
  }

  public Object createFromParcel(Parcel paramParcel)
  {
    return this.a.a(paramParcel, null);
  }

  public Object[] newArray(int paramInt)
  {
    return this.a.a(paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.b.b
 * JD-Core Version:    0.6.0
 */