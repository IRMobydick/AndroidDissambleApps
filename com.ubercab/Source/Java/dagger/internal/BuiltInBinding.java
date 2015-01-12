package dagger.internal;

final class BuiltInBinding<T> extends Binding<T>
{
  private final ClassLoader classLoader;
  private Binding<?> delegate;
  private final String delegateKey;

  public BuiltInBinding(String paramString1, Object paramObject, ClassLoader paramClassLoader, String paramString2)
  {
    super(paramString1, null, false, paramObject);
    this.classLoader = paramClassLoader;
    this.delegateKey = paramString2;
  }

  public void attach(Linker paramLinker)
  {
    this.delegate = paramLinker.requestBinding(this.delegateKey, this.requiredBy, this.classLoader);
  }

  public T get()
  {
    return this.delegate;
  }

  public Binding<?> getDelegate()
  {
    return this.delegate;
  }

  public void injectMembers(T paramT)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.BuiltInBinding
 * JD-Core Version:    0.6.2
 */