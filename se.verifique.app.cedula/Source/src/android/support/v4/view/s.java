package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class s
{
  static final v a;

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
      a = new u();
    while (true)
    {
      return;
      a = new t();
    }
  }

  public static float a(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return a.a(paramVelocityTracker, paramInt);
  }

  public static float b(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return a.b(paramVelocityTracker, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.s
 * JD-Core Version:    0.6.0
 */