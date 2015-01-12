package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(method={@butterknife.internal.ListenerMethod(name="onFocusChange", parameters={"android.view.View", "boolean"})}, setter="setOnFocusChangeListener", targetType="android.view.View", type="android.view.View.OnFocusChangeListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnFocusChange
{
  public abstract int[] value();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     butterknife.OnFocusChange
 * JD-Core Version:    0.6.2
 */