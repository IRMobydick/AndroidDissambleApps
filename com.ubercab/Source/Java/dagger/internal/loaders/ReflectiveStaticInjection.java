package dagger.internal.loaders;

import dagger.internal.Binding;
import dagger.internal.Keys;
import dagger.internal.Linker;
import dagger.internal.StaticInjection;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public final class ReflectiveStaticInjection extends StaticInjection
{
  private Binding<?>[] bindings;
  private final Field[] fields;
  private final ClassLoader loader;

  private ReflectiveStaticInjection(ClassLoader paramClassLoader, Field[] paramArrayOfField)
  {
    this.fields = paramArrayOfField;
    this.loader = paramClassLoader;
  }

  public static StaticInjection create(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    for (Field localField : paramClass.getDeclaredFields())
      if ((Modifier.isStatic(localField.getModifiers())) && (localField.isAnnotationPresent(Inject.class)))
      {
        localField.setAccessible(true);
        localArrayList.add(localField);
      }
    if (localArrayList.isEmpty())
      throw new IllegalArgumentException("No static injections: " + paramClass.getName());
    return new ReflectiveStaticInjection(paramClass.getClassLoader(), (Field[])localArrayList.toArray(new Field[localArrayList.size()]));
  }

  public void attach(Linker paramLinker)
  {
    this.bindings = new Binding[this.fields.length];
    for (int i = 0; i < this.fields.length; i++)
    {
      Field localField = this.fields[i];
      String str = Keys.get(localField.getGenericType(), localField.getAnnotations(), localField);
      this.bindings[i] = paramLinker.requestBinding(str, localField, this.loader);
    }
  }

  public void inject()
  {
    int i = 0;
    try
    {
      while (i < this.fields.length)
      {
        this.fields[i].set(null, this.bindings[i].get());
        i++;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.loaders.ReflectiveStaticInjection
 * JD-Core Version:    0.6.2
 */