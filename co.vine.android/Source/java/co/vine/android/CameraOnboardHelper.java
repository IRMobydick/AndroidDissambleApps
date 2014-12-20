package co.vine.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.Nullable;
import co.vine.android.util.Util;

public class CameraOnboardHelper
{
  public static final String PREF_CAMERA_ONBOARD_STEP = "camera_onboard_step";
  public static final String PREF_DID_SHOW_CAMERA_OVERLAY = "did_show_camera_overlay";
  public static final String STEP_DELETE = "delete";
  public static final String STEP_DELETE_2 = "delete_2";
  public static final String STEP_GRAB = "grab";
  public static final String STEP_MORE_TOOLS = "more_tools";

  private static SharedPreferences getDefaultSharedPrefs(Context paramContext)
  {
    return Util.getSharedPrefs(paramContext, "CameraOnBoardHelper");
  }

  public static boolean getHasShownOverlay(Context paramContext)
  {
    if (paramContext != null);
    for (boolean bool = getDefaultSharedPrefs(paramContext).getBoolean("did_show_camera_overlay", false); ; bool = true)
      return bool;
  }

  @Nullable
  public static String getLastCompletedStep(Context paramContext)
  {
    if (paramContext != null);
    for (String str = getDefaultSharedPrefs(paramContext).getString("camera_onboard_step", null); ; str = "dont_onboard")
      return str;
  }

  public static void setHasShownOverlay(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
      getDefaultSharedPrefs(paramContext).edit().putBoolean("did_show_camera_overlay", paramBoolean).apply();
  }

  public static void setLastCompletedStep(Context paramContext, String paramString)
  {
    if (paramContext != null)
      getDefaultSharedPrefs(paramContext).edit().putString("camera_onboard_step", paramString).apply();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.CameraOnboardHelper
 * JD-Core Version:    0.6.0
 */