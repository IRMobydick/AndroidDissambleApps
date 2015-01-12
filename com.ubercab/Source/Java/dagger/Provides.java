package dagger;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface Provides
{
  public abstract Type type();

  public static enum Type
  {
    static
    {
      SET = new Type("SET", 1);
      SET_VALUES = new Type("SET_VALUES", 2);
      Type[] arrayOfType = new Type[3];
      arrayOfType[0] = UNIQUE;
      arrayOfType[1] = SET;
      arrayOfType[2] = SET_VALUES;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.Provides
 * JD-Core Version:    0.6.2
 */