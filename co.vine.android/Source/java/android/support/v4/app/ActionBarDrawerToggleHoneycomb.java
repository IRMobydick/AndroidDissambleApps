package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb
{
  private static final String TAG = "ActionBarDrawerToggleHoneycomb";
  private static final int[] THEME_ATTRS;

  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16843531;
    THEME_ATTRS = arrayOfInt;
  }

  public static Drawable getThemeUpIndicator(Activity paramActivity)
  {
    TypedArray localTypedArray = paramActivity.obtainStyledAttributes(THEME_ATTRS);
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return localDrawable;
  }

  public static Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
  {
    if (paramObject == null)
      paramObject = new SetIndicatorInfo(paramActivity);
    SetIndicatorInfo localSetIndicatorInfo = (SetIndicatorInfo)paramObject;
    if (localSetIndicatorInfo.setHomeAsUpIndicator != null);
    try
    {
      ActionBar localActionBar = paramActivity.getActionBar();
      Method localMethod = localSetIndicatorInfo.setHomeActionContentDescription;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      localMethod.invoke(localActionBar, arrayOfObject);
      if (Build.VERSION.SDK_INT <= 19)
        localActionBar.setSubtitle(localActionBar.getSubtitle());
      return paramObject;
    }
    catch (Exception localException)
    {
      while (true)
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", localException);
    }
  }

  public static Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
  {
    if (paramObject == null)
      paramObject = new SetIndicatorInfo(paramActivity);
    SetIndicatorInfo localSetIndicatorInfo = (SetIndicatorInfo)paramObject;
    if (localSetIndicatorInfo.setHomeAsUpIndicator != null);
    while (true)
    {
      try
      {
        ActionBar localActionBar = paramActivity.getActionBar();
        Method localMethod1 = localSetIndicatorInfo.setHomeAsUpIndicator;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = paramDrawable;
        localMethod1.invoke(localActionBar, arrayOfObject1);
        Method localMethod2 = localSetIndicatorInfo.setHomeActionContentDescription;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(paramInt);
        localMethod2.invoke(localActionBar, arrayOfObject2);
        return paramObject;
      }
      catch (Exception localException)
      {
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", localException);
        continue;
      }
      if (localSetIndicatorInfo.upIndicatorView != null)
      {
        localSetIndicatorInfo.upIndicatorView.setImageDrawable(paramDrawable);
        continue;
      }
      Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
    }
  }

  private static class SetIndicatorInfo
  {
    public Method setHomeActionContentDescription;
    public Method setHomeAsUpIndicator;
    public ImageView upIndicatorView;

    SetIndicatorInfo(Activity paramActivity)
    {
      label141: 
      while (true)
      {
        View localView2;
        View localView3;
        try
        {
          Class[] arrayOfClass1 = new Class[1];
          arrayOfClass1[0] = Drawable.class;
          this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", arrayOfClass1);
          Class[] arrayOfClass2 = new Class[1];
          arrayOfClass2[0] = Integer.TYPE;
          this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", arrayOfClass2);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          View localView1 = paramActivity.findViewById(16908332);
          if (localView1 == null)
            continue;
          ViewGroup localViewGroup = (ViewGroup)localView1.getParent();
          if (localViewGroup.getChildCount() != 2)
            continue;
          localView2 = localViewGroup.getChildAt(0);
          localView3 = localViewGroup.getChildAt(1);
          if (localView2.getId() != 16908332);
        }
        for (View localView4 = localView3; ; localView4 = localView2)
        {
          if (!(localView4 instanceof ImageView))
            break label141;
          this.upIndicatorView = ((ImageView)localView4);
          break;
        }
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggleHoneycomb
 * JD-Core Version:    0.6.0
 */