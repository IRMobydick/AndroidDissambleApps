package net.photopay.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

public class FakeR
{
  private Context mContext;
  private String mPackageName;

  public FakeR(Activity paramActivity)
  {
    this.mContext = paramActivity.getApplicationContext();
    this.mPackageName = this.mContext.getPackageName();
  }

  public FakeR(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPackageName = this.mContext.getPackageName();
  }

  public static int getId(Context paramContext, String paramString1, String paramString2)
  {
    int i = paramContext.getResources().getIdentifier(paramString2, paramString1, paramContext.getPackageName());
    if (i == 0)
      throw new RuntimeException("Cannot find resource " + paramString2 + " in group " + paramString1 + " for package " + paramContext.getPackageName() + " (a.k.a. R." + paramString1 + "." + paramString2 + ")");
    return i;
  }

  public int getId(String paramString1, String paramString2)
  {
    int i = this.mContext.getResources().getIdentifier(paramString2, paramString1, this.mPackageName);
    if (i == 0)
      throw new RuntimeException("Cannot find resource " + paramString2 + " in group " + paramString1 + " for package " + this.mPackageName + " (a.k.a. R." + paramString1 + "." + paramString2 + ")");
    return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.util.FakeR
 * JD-Core Version:    0.6.0
 */