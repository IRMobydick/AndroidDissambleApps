package android.support.v4.b;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public class a
{
  public static Parcelable.Creator a(c paramc)
  {
    if (Build.VERSION.SDK_INT >= 13)
      e.a(paramc);
    return new b(paramc);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.b.a
 * JD-Core Version:    0.6.0
 */