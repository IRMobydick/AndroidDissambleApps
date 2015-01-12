package butterknife;

import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(callbacks=Callback.class, setter="setOnItemSelectedListener", targetType="android.widget.AdapterView<?>", type="android.widget.AdapterView.OnItemSelectedListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnItemSelected
{
  public abstract Callback callback();

  public abstract int[] value();

  public static enum Callback
  {
    static
    {
      Callback[] arrayOfCallback = new Callback[2];
      arrayOfCallback[0] = ITEM_SELECTED;
      arrayOfCallback[1] = NOTHING_SELECTED;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     butterknife.OnItemSelected
 * JD-Core Version:    0.6.2
 */