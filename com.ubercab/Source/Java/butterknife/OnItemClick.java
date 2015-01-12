package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(method={@butterknife.internal.ListenerMethod(name="onItemClick", parameters={"android.widget.AdapterView<?>", "android.view.View", "int", "long"})}, setter="setOnItemClickListener", targetType="android.widget.AdapterView<?>", type="android.widget.AdapterView.OnItemClickListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnItemClick
{
  public abstract int[] value();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     butterknife.OnItemClick
 * JD-Core Version:    0.6.2
 */