package dagger.internal;

public abstract class ProvidesBinding<T> extends Binding<T>
{
  protected final String methodName;
  protected final String moduleClass;

  public ProvidesBinding(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    super(paramString1, null, paramBoolean, paramString2 + "." + paramString3 + "()");
    this.moduleClass = paramString2;
    this.methodName = paramString3;
  }

  public abstract T get();

  public String toString()
  {
    return getClass().getName() + "[key=" + this.provideKey + " method=" + this.moduleClass + "." + this.methodName + "()" + "]";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.ProvidesBinding
 * JD-Core Version:    0.6.2
 */