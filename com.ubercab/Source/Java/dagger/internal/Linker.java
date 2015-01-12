package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class Linker
{
  private static final Object UNINITIALIZED = new Object();
  private boolean attachSuccess = true;
  private final Linker base;
  private final Map<String, Binding<?>> bindings = new HashMap();
  private final ErrorHandler errorHandler;
  private final List<String> errors = new ArrayList();
  private volatile Map<String, Binding<?>> linkedBindings = null;
  private final Loader plugin;
  private final Queue<Binding<?>> toLink = new ArrayQueue();

  public Linker(Linker paramLinker, Loader paramLoader, ErrorHandler paramErrorHandler)
  {
    if (paramLoader == null)
      throw new NullPointerException("plugin");
    if (paramErrorHandler == null)
      throw new NullPointerException("errorHandler");
    this.base = paramLinker;
    this.plugin = paramLoader;
    this.errorHandler = paramErrorHandler;
  }

  private void addError(String paramString)
  {
    this.errors.add(paramString);
  }

  private void assertLockHeld()
  {
    if (!Thread.holdsLock(this))
      throw new AssertionError();
  }

  private Binding<?> createBinding(String paramString, Object paramObject, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    String str1 = Keys.getBuiltInBindingsKey(paramString);
    Object localObject;
    if (str1 != null)
      localObject = new BuiltInBinding(paramString, paramObject, paramClassLoader, str1);
    String str3;
    do
    {
      return localObject;
      String str2 = Keys.getLazyKey(paramString);
      if (str2 != null)
        return new LazyBinding(paramString, paramObject, paramClassLoader, str2);
      str3 = Keys.getClassName(paramString);
      if ((str3 == null) || (Keys.isAnnotated(paramString)))
        throw new IllegalArgumentException(paramString);
      localObject = this.plugin.getAtInjectBinding(paramString, str3, paramClassLoader, paramBoolean);
    }
    while (localObject != null);
    throw new Binding.InvalidBindingException(str3, "could not be bound with key " + paramString);
  }

  private <T> void putBinding(Binding<T> paramBinding)
  {
    if (paramBinding.provideKey != null)
      putIfAbsent(this.bindings, paramBinding.provideKey, paramBinding);
    if (paramBinding.membersKey != null)
      putIfAbsent(this.bindings, paramBinding.membersKey, paramBinding);
  }

  private <K, V> void putIfAbsent(Map<K, V> paramMap, K paramK, V paramV)
  {
    Object localObject = paramMap.put(paramK, paramV);
    if (localObject != null)
      paramMap.put(paramK, localObject);
  }

  static <T> Binding<T> scope(Binding<T> paramBinding)
  {
    if ((!paramBinding.isSingleton()) || ((paramBinding instanceof SingletonBinding)))
      return paramBinding;
    return new SingletonBinding(paramBinding, null);
  }

  public Map<String, Binding<?>> fullyLinkedBindings()
  {
    return this.linkedBindings;
  }

  public void installBindings(BindingsGroup paramBindingsGroup)
  {
    if (this.linkedBindings != null)
      throw new IllegalStateException("Cannot install further bindings after calling linkAll().");
    Iterator localIterator = paramBindingsGroup.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.bindings.put(localEntry.getKey(), scope((Binding)localEntry.getValue()));
    }
  }

  public Map<String, Binding<?>> linkAll()
  {
    assertLockHeld();
    if (this.linkedBindings != null)
      return this.linkedBindings;
    Iterator localIterator = this.bindings.values().iterator();
    while (localIterator.hasNext())
    {
      Binding localBinding = (Binding)localIterator.next();
      if (!localBinding.isLinked())
        this.toLink.add(localBinding);
    }
    linkRequested();
    this.linkedBindings = Collections.unmodifiableMap(this.bindings);
    return this.linkedBindings;
  }

  public void linkRequested()
  {
    assertLockHeld();
    while (true)
    {
      Binding localBinding1 = (Binding)this.toLink.poll();
      if (localBinding1 == null)
        break;
      if ((localBinding1 instanceof DeferredBinding))
      {
        DeferredBinding localDeferredBinding = (DeferredBinding)localBinding1;
        String str = localDeferredBinding.deferredKey;
        boolean bool = localDeferredBinding.mustHaveInjections;
        if (!this.bindings.containsKey(str))
          try
          {
            localBinding2 = createBinding(str, localBinding1.requiredBy, localDeferredBinding.classLoader, bool);
            localBinding2.setLibrary(localBinding1.library());
            localBinding2.setDependedOn(localBinding1.dependedOn());
            if ((!str.equals(localBinding2.provideKey)) && (!str.equals(localBinding2.membersKey)))
              throw new IllegalStateException("Unable to create binding for " + str);
          }
          catch (Binding.InvalidBindingException localInvalidBindingException)
          {
            Binding localBinding2;
            addError(localInvalidBindingException.type + " " + localInvalidBindingException.getMessage() + " required by " + localBinding1.requiredBy);
            this.bindings.put(str, Binding.UNRESOLVED);
            continue;
            Binding localBinding3 = scope(localBinding2);
            this.toLink.add(localBinding3);
            putBinding(localBinding3);
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            addError("Unsupported: " + localUnsupportedOperationException.getMessage() + " required by " + localBinding1.requiredBy);
            this.bindings.put(str, Binding.UNRESOLVED);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            addError(localIllegalArgumentException.getMessage() + " required by " + localBinding1.requiredBy);
            this.bindings.put(str, Binding.UNRESOLVED);
          }
          catch (RuntimeException localRuntimeException)
          {
            throw localRuntimeException;
          }
          catch (Exception localException)
          {
            throw new RuntimeException(localException);
          }
      }
      else
      {
        this.attachSuccess = true;
        localBinding1.attach(this);
        if (this.attachSuccess)
          localBinding1.setLinked();
        else
          this.toLink.add(localBinding1);
      }
    }
    try
    {
      this.errorHandler.handleErrors(this.errors);
      return;
    }
    finally
    {
      this.errors.clear();
    }
  }

  @Deprecated
  public Binding<?> requestBinding(String paramString, Object paramObject)
  {
    return requestBinding(paramString, paramObject, getClass().getClassLoader(), true, true);
  }

  public Binding<?> requestBinding(String paramString, Object paramObject, ClassLoader paramClassLoader)
  {
    return requestBinding(paramString, paramObject, paramClassLoader, true, true);
  }

  public Binding<?> requestBinding(String paramString, Object paramObject, ClassLoader paramClassLoader, boolean paramBoolean1, boolean paramBoolean2)
  {
    assertLockHeld();
    Binding localBinding = null;
    for (Linker localLinker = this; localLinker != null; localLinker = localLinker.base)
    {
      localBinding = (Binding)localLinker.bindings.get(paramString);
      if (localBinding != null)
      {
        if ((localLinker == this) || (localBinding.isLinked()))
          break;
        throw new AssertionError();
      }
    }
    if (localBinding == null)
    {
      DeferredBinding localDeferredBinding = new DeferredBinding(paramString, paramClassLoader, paramObject, paramBoolean1, null);
      localDeferredBinding.setLibrary(paramBoolean2);
      localDeferredBinding.setDependedOn(true);
      this.toLink.add(localDeferredBinding);
      this.attachSuccess = false;
      return null;
    }
    if (!localBinding.isLinked())
      this.toLink.add(localBinding);
    localBinding.setLibrary(paramBoolean2);
    localBinding.setDependedOn(true);
    return localBinding;
  }

  @Deprecated
  public Binding<?> requestBinding(String paramString, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    return requestBinding(paramString, paramObject, getClass().getClassLoader(), paramBoolean1, paramBoolean2);
  }

  private static class DeferredBinding extends Binding<Object>
  {
    final ClassLoader classLoader;
    final String deferredKey;
    final boolean mustHaveInjections;

    private DeferredBinding(String paramString, ClassLoader paramClassLoader, Object paramObject, boolean paramBoolean)
    {
      super(null, false, paramObject);
      this.deferredKey = paramString;
      this.classLoader = paramClassLoader;
      this.mustHaveInjections = paramBoolean;
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      throw new UnsupportedOperationException("Deferred bindings must resolve first.");
    }

    public void injectMembers(Object paramObject)
    {
      throw new UnsupportedOperationException("Deferred bindings must resolve first.");
    }

    public String toString()
    {
      return "DeferredBinding[deferredKey=" + this.deferredKey + "]";
    }
  }

  public static abstract interface ErrorHandler
  {
    public static final ErrorHandler NULL = new ErrorHandler()
    {
      public void handleErrors(List<String> paramAnonymousList)
      {
      }
    };

    public abstract void handleErrors(List<String> paramList);
  }

  private static class SingletonBinding<T> extends Binding<T>
  {
    private final Binding<T> binding;
    private volatile Object onlyInstance = Linker.UNINITIALIZED;

    private SingletonBinding(Binding<T> paramBinding)
    {
      super(paramBinding.membersKey, true, paramBinding.requiredBy);
      this.binding = paramBinding;
    }

    public void attach(Linker paramLinker)
    {
      this.binding.attach(paramLinker);
    }

    public boolean dependedOn()
    {
      return this.binding.dependedOn();
    }

    public T get()
    {
      if (this.onlyInstance == Linker.UNINITIALIZED);
      try
      {
        if (this.onlyInstance == Linker.UNINITIALIZED)
          this.onlyInstance = this.binding.get();
        return this.onlyInstance;
      }
      finally
      {
      }
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      this.binding.getDependencies(paramSet1, paramSet2);
    }

    public void injectMembers(T paramT)
    {
      this.binding.injectMembers(paramT);
    }

    public boolean isCycleFree()
    {
      return this.binding.isCycleFree();
    }

    public boolean isLinked()
    {
      return this.binding.isLinked();
    }

    protected boolean isSingleton()
    {
      return true;
    }

    public boolean isVisiting()
    {
      return this.binding.isVisiting();
    }

    public boolean library()
    {
      return this.binding.library();
    }

    public void setCycleFree(boolean paramBoolean)
    {
      this.binding.setCycleFree(paramBoolean);
    }

    public void setDependedOn(boolean paramBoolean)
    {
      this.binding.setDependedOn(paramBoolean);
    }

    public void setLibrary(boolean paramBoolean)
    {
      this.binding.setLibrary(true);
    }

    protected void setLinked()
    {
      this.binding.setLinked();
    }

    public void setVisiting(boolean paramBoolean)
    {
      this.binding.setVisiting(paramBoolean);
    }

    public String toString()
    {
      return "@Singleton/" + this.binding.toString();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.Linker
 * JD-Core Version:    0.6.2
 */