package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;

class ah
  implements ag
{
  public void a(Activity paramActivity, Intent paramIntent)
  {
    paramIntent.addFlags(67108864);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ah
 * JD-Core Version:    0.6.0
 */