package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public class f
{
  static final j a;

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
      a = new i();
    while (true)
    {
      return;
      a = new g();
    }
  }

  public static boolean a(KeyEvent paramKeyEvent)
  {
    return a.b(paramKeyEvent.getMetaState());
  }

  public static boolean a(KeyEvent paramKeyEvent, int paramInt)
  {
    return a.a(paramKeyEvent.getMetaState(), paramInt);
  }

  public static void b(KeyEvent paramKeyEvent)
  {
    a.a(paramKeyEvent);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.f
 * JD-Core Version:    0.6.0
 */