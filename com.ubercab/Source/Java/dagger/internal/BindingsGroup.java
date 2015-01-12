package dagger.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BindingsGroup
{
  private final Map<String, Binding<?>> bindings = new LinkedHashMap();

  public Binding<?> contributeProvidesBinding(String paramString, ProvidesBinding<?> paramProvidesBinding)
  {
    return put(paramString, paramProvidesBinding);
  }

  public abstract Binding<?> contributeSetBinding(String paramString, SetBinding<?> paramSetBinding);

  public final Set<Map.Entry<String, Binding<?>>> entrySet()
  {
    return this.bindings.entrySet();
  }

  public Binding<?> get(String paramString)
  {
    return (Binding)this.bindings.get(paramString);
  }

  protected Binding<?> put(String paramString, Binding<?> paramBinding)
  {
    Binding localBinding = (Binding)this.bindings.put(paramString, paramBinding);
    if (localBinding != null)
    {
      this.bindings.put(paramString, localBinding);
      throw new IllegalArgumentException("Duplicate:\n    " + localBinding + "\n    " + paramBinding);
    }
    return null;
  }

  public String toString()
  {
    return getClass().getSimpleName() + this.bindings.toString();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.BindingsGroup
 * JD-Core Version:    0.6.2
 */