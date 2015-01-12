package butterknife;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface InjectView
{
  public abstract int value();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     butterknife.InjectView
 * JD-Core Version:    0.6.2
 */