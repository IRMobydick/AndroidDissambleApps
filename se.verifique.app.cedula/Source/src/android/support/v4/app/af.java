package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;

public class af
{
  private static final ag a;

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
      a = new ai();
    while (true)
    {
      return;
      a = new ah();
    }
  }

  public static void a(Activity paramActivity, Intent paramIntent)
  {
    a.a(paramActivity, paramIntent);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.af
 * JD-Core Version:    0.6.0
 */