package dagger.internal;

import dagger.internal.loaders.ReflectiveAtInjectBinding;
import dagger.internal.loaders.ReflectiveStaticInjection;

public final class FailoverLoader extends Loader
{
  private final Memoizer<Class<?>, ModuleAdapter<?>> loadedAdapters = new Memoizer()
  {
    protected ModuleAdapter<?> create(Class<?> paramAnonymousClass)
    {
      ModuleAdapter localModuleAdapter = (ModuleAdapter)FailoverLoader.this.instantiate(paramAnonymousClass.getName().concat("$$ModuleAdapter"), paramAnonymousClass.getClassLoader());
      if (localModuleAdapter == null)
        throw new IllegalStateException("Module adapter for " + paramAnonymousClass + " could not be loaded. " + "Please ensure that code generation was run for this module.");
      return localModuleAdapter;
    }
  };

  public Binding<?> getAtInjectBinding(String paramString1, String paramString2, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    Binding localBinding = (Binding)instantiate(paramString2.concat("$$InjectAdapter"), paramClassLoader);
    if (localBinding != null)
      return localBinding;
    Class localClass = loadClass(paramClassLoader, paramString2);
    if (localClass.equals(Void.class))
      throw new IllegalStateException(String.format("Could not load class %s needed for binding %s", new Object[] { paramString2, paramString1 }));
    if (localClass.isInterface())
      return null;
    return ReflectiveAtInjectBinding.create(localClass, paramBoolean);
  }

  public <T> ModuleAdapter<T> getModuleAdapter(Class<T> paramClass)
  {
    return (ModuleAdapter)this.loadedAdapters.get(paramClass);
  }

  public StaticInjection getStaticInjection(Class<?> paramClass)
  {
    StaticInjection localStaticInjection = (StaticInjection)instantiate(paramClass.getName().concat("$$StaticInjection"), paramClass.getClassLoader());
    if (localStaticInjection != null)
      return localStaticInjection;
    return ReflectiveStaticInjection.create(paramClass);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.FailoverLoader
 * JD-Core Version:    0.6.2
 */