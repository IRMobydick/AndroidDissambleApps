package retrofit.http;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.PARAMETER})
public @interface Part
{
  public abstract String value();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.http.Part
 * JD-Core Version:    0.6.2
 */