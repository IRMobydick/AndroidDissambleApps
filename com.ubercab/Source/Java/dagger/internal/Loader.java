package dagger.internal;

public abstract class Loader
{
  private final Memoizer<ClassLoader, Memoizer<String, Class<?>>> caches = new Memoizer()
  {
    protected Memoizer<String, Class<?>> create(final ClassLoader paramAnonymousClassLoader)
    {
      return new Memoizer()
      {
        protected Class<?> create(String paramAnonymous2String)
        {
          try
          {
            Class localClass = paramAnonymousClassLoader.loadClass(paramAnonymous2String);
            return localClass;
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
          }
          return Void.class;
        }
      };
    }
  };

  public abstract Binding<?> getAtInjectBinding(String paramString1, String paramString2, ClassLoader paramClassLoader, boolean paramBoolean);

  public abstract <T> ModuleAdapter<T> getModuleAdapter(Class<T> paramClass);

  public abstract StaticInjection getStaticInjection(Class<?> paramClass);

  protected <T> T instantiate(String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      Class localClass = loadClass(paramClassLoader, paramString);
      if (localClass == Void.class)
        return null;
      Object localObject = localClass.newInstance();
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("Failed to initialize " + paramString, localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("Failed to initialize " + paramString, localIllegalAccessException);
    }
  }

  protected Class<?> loadClass(ClassLoader paramClassLoader, String paramString)
  {
    if (paramClassLoader != null);
    while (true)
    {
      return (Class)((Memoizer)this.caches.get(paramClassLoader)).get(paramString);
      paramClassLoader = ClassLoader.getSystemClassLoader();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.Loader
 * JD-Core Version:    0.6.2
 */