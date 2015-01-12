package dagger.internal;

public abstract class ModuleAdapter<T>
{
  public final boolean complete;
  public final Class<?>[] includes;
  public final String[] injectableTypes;
  public final boolean library;
  public final Class<T> moduleClass;
  public final boolean overrides;
  public final Class<?>[] staticInjections;

  protected ModuleAdapter(Class<T> paramClass, String[] paramArrayOfString, Class<?>[] paramArrayOfClass1, boolean paramBoolean1, Class<?>[] paramArrayOfClass2, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.moduleClass = paramClass;
    this.injectableTypes = paramArrayOfString;
    this.staticInjections = paramArrayOfClass1;
    this.overrides = paramBoolean1;
    this.includes = paramArrayOfClass2;
    this.complete = paramBoolean2;
    this.library = paramBoolean3;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if ((paramObject instanceof ModuleAdapter))
    {
      ModuleAdapter localModuleAdapter = (ModuleAdapter)paramObject;
      return this.moduleClass.equals(localModuleAdapter.moduleClass);
    }
    return false;
  }

  public void getBindings(BindingsGroup paramBindingsGroup, T paramT)
  {
  }

  public final int hashCode()
  {
    return this.moduleClass.hashCode();
  }

  protected T newModule()
  {
    throw new UnsupportedOperationException("No no-args constructor on " + getClass().getName());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.ModuleAdapter
 * JD-Core Version:    0.6.2
 */