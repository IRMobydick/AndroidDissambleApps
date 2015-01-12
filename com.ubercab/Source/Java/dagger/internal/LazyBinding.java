package dagger.internal;

import dagger.Lazy;

final class LazyBinding<T> extends Binding<Lazy<T>>
{
  private static final Object NOT_PRESENT = new Object();
  private Binding<T> delegate;
  private final String lazyKey;
  private final ClassLoader loader;

  public LazyBinding(String paramString1, Object paramObject, ClassLoader paramClassLoader, String paramString2)
  {
    super(paramString1, null, false, paramObject);
    this.loader = paramClassLoader;
    this.lazyKey = paramString2;
  }

  public void attach(Linker paramLinker)
  {
    this.delegate = paramLinker.requestBinding(this.lazyKey, this.requiredBy, this.loader);
  }

  public Lazy<T> get()
  {
    return new Lazy()
    {
      private volatile Object cacheValue = LazyBinding.NOT_PRESENT;

      public T get()
      {
        if (this.cacheValue == LazyBinding.NOT_PRESENT);
        try
        {
          if (this.cacheValue == LazyBinding.NOT_PRESENT)
            this.cacheValue = LazyBinding.this.delegate.get();
          return this.cacheValue;
        }
        finally
        {
        }
      }
    };
  }

  public void injectMembers(Lazy<T> paramLazy)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.LazyBinding
 * JD-Core Version:    0.6.2
 */