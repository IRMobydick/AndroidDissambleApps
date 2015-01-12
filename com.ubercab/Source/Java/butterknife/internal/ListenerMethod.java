package butterknife.internal;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ListenerMethod
{
  public abstract String defaultReturn();

  public abstract String name();

  public abstract String[] parameters();

  public abstract String returnType();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     butterknife.internal.ListenerMethod
 * JD-Core Version:    0.6.2
 */