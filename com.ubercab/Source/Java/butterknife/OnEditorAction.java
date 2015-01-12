package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(method={@butterknife.internal.ListenerMethod(defaultReturn="false", name="onEditorAction", parameters={"android.widget.TextView", "int", "android.view.KeyEvent"}, returnType="boolean")}, setter="setOnEditorActionListener", targetType="android.widget.TextView", type="android.widget.TextView.OnEditorActionListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnEditorAction
{
  public abstract int[] value();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     butterknife.OnEditorAction
 * JD-Core Version:    0.6.2
 */