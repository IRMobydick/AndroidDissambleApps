package dagger;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface Module
{
  public abstract Class<?> addsTo();

  public abstract boolean complete();

  public abstract Class<?>[] includes();

  public abstract Class<?>[] injects();

  public abstract boolean library();

  public abstract boolean overrides();

  public abstract Class<?>[] staticInjections();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.Module
 * JD-Core Version:    0.6.2
 */