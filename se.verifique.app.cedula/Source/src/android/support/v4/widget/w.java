package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class w extends v
{
  private Method a;
  private Field b;

  w()
  {
    try
    {
      this.a = View.class.getDeclaredMethod("getDisplayList", (Class[])null);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        while (true)
        {
          this.b = View.class.getDeclaredField("mRecreateDisplayList");
          this.b.setAccessible(true);
          return;
          localNoSuchMethodException = localNoSuchMethodException;
          Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", localNoSuchMethodException);
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        while (true)
          Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", localNoSuchFieldException);
      }
    }
  }

  public void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    if ((this.a != null) && (this.b != null));
    while (true)
    {
      try
      {
        this.b.setBoolean(paramView, true);
        this.a.invoke(paramView, (Object[])null);
        super.a(paramSlidingPaneLayout, paramView);
        return;
      }
      catch (Exception localException)
      {
        Log.e("SlidingPaneLayout", "Error refreshing display list state", localException);
        continue;
      }
      paramView.invalidate();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.w
 * JD-Core Version:    0.6.0
 */