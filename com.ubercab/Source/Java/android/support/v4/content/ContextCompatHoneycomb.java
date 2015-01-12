package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;

class ContextCompatHoneycomb
{
  public static File getObbDir(Context paramContext)
  {
    return paramContext.getObbDir();
  }

  static void startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    paramContext.startActivities(paramArrayOfIntent);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContextCompatHoneycomb
 * JD-Core Version:    0.6.2
 */