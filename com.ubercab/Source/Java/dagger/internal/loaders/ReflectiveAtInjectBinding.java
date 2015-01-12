package dagger.internal.loaders;

import dagger.internal.Binding;
import dagger.internal.Binding.InvalidBindingException;
import dagger.internal.Keys;
import dagger.internal.Linker;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class ReflectiveAtInjectBinding<T> extends Binding<T>
{
  private final Constructor<T> constructor;
  private final Binding<?>[] fieldBindings;
  private final Field[] fields;
  private final String[] keys;
  private final ClassLoader loader;
  private final Binding<?>[] parameterBindings;
  private final Class<?> supertype;
  private Binding<? super T> supertypeBinding;

  private ReflectiveAtInjectBinding(String paramString1, String paramString2, boolean paramBoolean, Class<?> paramClass1, Field[] paramArrayOfField, Constructor<T> paramConstructor, int paramInt, Class<?> paramClass2, String[] paramArrayOfString)
  {
    super(paramString1, paramString2, paramBoolean, paramClass1);
    this.constructor = paramConstructor;
    this.fields = paramArrayOfField;
    this.supertype = paramClass2;
    this.keys = paramArrayOfString;
    this.parameterBindings = new Binding[paramInt];
    this.fieldBindings = new Binding[paramArrayOfField.length];
    this.loader = paramClass1.getClassLoader();
  }

  public static <T> Binding<T> create(Class<T> paramClass, boolean paramBoolean)
  {
    boolean bool = paramClass.isAnnotationPresent(Singleton.class);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (Object localObject1 = paramClass; localObject1 != Object.class; localObject1 = ((Class)localObject1).getSuperclass())
    {
      Field[] arrayOfField = ((Class)localObject1).getDeclaredFields();
      int i1 = arrayOfField.length;
      int i2 = 0;
      if (i2 < i1)
      {
        Field localField = arrayOfField[i2];
        if ((!localField.isAnnotationPresent(Inject.class)) || (Modifier.isStatic(localField.getModifiers())));
        while (true)
        {
          i2++;
          break;
          if ((0x2 & localField.getModifiers()) != 0)
            throw new IllegalStateException("Can't inject private field: " + localField);
          localField.setAccessible(true);
          localArrayList2.add(localField);
          localArrayList1.add(Keys.get(localField.getGenericType(), localField.getAnnotations(), localField));
        }
      }
    }
    Object localObject2 = null;
    Constructor[] arrayOfConstructor = getConstructorsForType(paramClass);
    int i = arrayOfConstructor.length;
    int j = 0;
    if (j < i)
    {
      Constructor localConstructor2 = arrayOfConstructor[j];
      if (!localConstructor2.isAnnotationPresent(Inject.class));
      while (true)
      {
        j++;
        break;
        if (localObject2 != null)
          throw new Binding.InvalidBindingException(paramClass.getName(), "has too many injectable constructors");
        localObject2 = localConstructor2;
      }
    }
    if ((localObject2 != null) || (!localArrayList2.isEmpty()));
    try
    {
      Constructor localConstructor1 = paramClass.getDeclaredConstructor(new Class[0]);
      localObject2 = localConstructor1;
      label281: 
      while (localObject2 != null)
        if ((0x2 & localObject2.getModifiers()) != 0)
        {
          throw new IllegalStateException("Can't inject private constructor: " + localObject2);
          if (paramBoolean)
            throw new Binding.InvalidBindingException(paramClass.getName(), "has no injectable members. Do you want to add an injectable constructor?");
        }
        else
        {
          str = Keys.get(paramClass);
          localObject2.setAccessible(true);
          Type[] arrayOfType = localObject2.getGenericParameterTypes();
          k = arrayOfType.length;
          if (k == 0)
            break label461;
          Annotation[][] arrayOfAnnotation = localObject2.getParameterAnnotations();
          for (int m = 0; ; m++)
          {
            int n = arrayOfType.length;
            if (m >= n)
              break;
            localArrayList1.add(Keys.get(arrayOfType[m], arrayOfAnnotation[m], localObject2));
          }
        }
      String str = null;
      int k = 0;
      if (bool)
        throw new IllegalArgumentException("No injectable constructor on @Singleton " + paramClass.getName());
      label461: Class localClass = paramClass.getSuperclass();
      if (localClass != null)
      {
        if (!Keys.isPlatformType(localClass.getName()))
          break label546;
        localClass = null;
      }
      while (true)
      {
        return new ReflectiveAtInjectBinding(str, Keys.getMembersKey(paramClass), bool, paramClass, (Field[])localArrayList2.toArray(new Field[localArrayList2.size()]), localObject2, k, localClass, (String[])localArrayList1.toArray(new String[localArrayList1.size()]));
        label546: localArrayList1.add(Keys.getMembersKey(localClass));
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label281;
    }
  }

  private static <T> Constructor<T>[] getConstructorsForType(Class<T> paramClass)
  {
    return (Constructor[])paramClass.getDeclaredConstructors();
  }

  public void attach(Linker paramLinker)
  {
    int i = 0;
    for (int j = 0; j < this.fields.length; j++)
    {
      if (this.fieldBindings[j] == null)
        this.fieldBindings[j] = paramLinker.requestBinding(this.keys[i], this.fields[j], this.loader);
      i++;
    }
    if (this.constructor != null)
      for (int k = 0; k < this.parameterBindings.length; k++)
      {
        if (this.parameterBindings[k] == null)
          this.parameterBindings[k] = paramLinker.requestBinding(this.keys[i], this.constructor, this.loader);
        i++;
      }
    if ((this.supertype != null) && (this.supertypeBinding == null))
      this.supertypeBinding = paramLinker.requestBinding(this.keys[i], this.membersKey, this.loader, false, true);
  }

  public T get()
  {
    if (this.constructor == null)
      throw new UnsupportedOperationException();
    Object[] arrayOfObject = new Object[this.parameterBindings.length];
    for (int i = 0; i < this.parameterBindings.length; i++)
      arrayOfObject[i] = this.parameterBindings[i].get();
    try
    {
      Object localObject = this.constructor.newInstance(arrayOfObject);
      injectMembers(localObject);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((localThrowable instanceof RuntimeException));
      for (RuntimeException localRuntimeException = (RuntimeException)localThrowable; ; localRuntimeException = new RuntimeException(localThrowable))
        throw localRuntimeException;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    if (this.parameterBindings != null)
      Collections.addAll(paramSet1, this.parameterBindings);
    Collections.addAll(paramSet2, this.fieldBindings);
    if (this.supertypeBinding != null)
      paramSet2.add(this.supertypeBinding);
  }

  public void injectMembers(T paramT)
  {
    int i = 0;
    try
    {
      while (i < this.fields.length)
      {
        this.fields[i].set(paramT, this.fieldBindings[i].get());
        i++;
      }
      if (this.supertypeBinding != null)
        this.supertypeBinding.injectMembers(paramT);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }

  public String toString()
  {
    if (this.provideKey != null)
      return this.provideKey;
    return this.membersKey;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.loaders.ReflectiveAtInjectBinding
 * JD-Core Version:    0.6.2
 */