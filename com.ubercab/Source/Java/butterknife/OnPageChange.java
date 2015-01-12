package butterknife;

import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(callbacks=Callback.class, setter="setOnPageChangeListener", targetType="android.support.v4.view.ViewPager", type="android.support.v4.view.ViewPager.OnPageChangeListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnPageChange
{
  public abstract Callback callback();

  public abstract int[] value();

  public static enum Callback
  {
    static
    {
      PAGE_SCROLLED = new Callback("PAGE_SCROLLED", 1);
      PAGE_SCROLL_STATE_CHANGED = new Callback("PAGE_SCROLL_STATE_CHANGED", 2);
      Callback[] arrayOfCallback = new Callback[3];
      arrayOfCallback[0] = PAGE_SELECTED;
      arrayOfCallback[1] = PAGE_SCROLLED;
      arrayOfCallback[2] = PAGE_SCROLL_STATE_CHANGED;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     butterknife.OnPageChange
 * JD-Core Version:    0.6.2
 */