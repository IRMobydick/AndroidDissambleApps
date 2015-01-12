package dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class SetBinding<T> extends Binding<Set<T>>
{
  private final List<Binding<?>> contributors;
  private final SetBinding<T> parent;

  public SetBinding(SetBinding<T> paramSetBinding)
  {
    super(paramSetBinding.provideKey, null, false, paramSetBinding.requiredBy);
    this.parent = paramSetBinding;
    setLibrary(paramSetBinding.library());
    setDependedOn(paramSetBinding.dependedOn());
    this.contributors = new ArrayList();
  }

  public SetBinding(String paramString, Object paramObject)
  {
    super(paramString, null, false, paramObject);
    this.parent = null;
    this.contributors = new ArrayList();
  }

  public static <T> void add(BindingsGroup paramBindingsGroup, String paramString, Binding<?> paramBinding)
  {
    prepareSetBinding(paramBindingsGroup, paramString, paramBinding).contributors.add(Linker.scope(paramBinding));
  }

  private static <T> SetBinding<T> prepareSetBinding(BindingsGroup paramBindingsGroup, String paramString, Binding<?> paramBinding)
  {
    Binding localBinding = paramBindingsGroup.get(paramString);
    if ((localBinding instanceof SetBinding))
    {
      SetBinding localSetBinding2 = (SetBinding)localBinding;
      if ((localSetBinding2.library()) && (paramBinding.library()));
      for (boolean bool = true; ; bool = false)
      {
        localSetBinding2.setLibrary(bool);
        return localSetBinding2;
      }
    }
    if (localBinding != null)
      throw new IllegalArgumentException("Duplicate:\n    " + localBinding + "\n    " + paramBinding);
    SetBinding localSetBinding1 = new SetBinding(paramString, paramBinding.requiredBy);
    localSetBinding1.setLibrary(paramBinding.library());
    paramBindingsGroup.contributeSetBinding(paramString, localSetBinding1);
    return (SetBinding)paramBindingsGroup.get(paramString);
  }

  public void attach(Linker paramLinker)
  {
    Iterator localIterator = this.contributors.iterator();
    while (localIterator.hasNext())
      ((Binding)localIterator.next()).attach(paramLinker);
  }

  public Set<T> get()
  {
    ArrayList localArrayList = new ArrayList();
    for (SetBinding localSetBinding = this; localSetBinding != null; localSetBinding = localSetBinding.parent)
    {
      int i = 0;
      int j = localSetBinding.contributors.size();
      if (i < j)
      {
        Binding localBinding = (Binding)localSetBinding.contributors.get(i);
        Object localObject = localBinding.get();
        if (localBinding.provideKey.equals(this.provideKey))
          localArrayList.addAll((Set)localObject);
        while (true)
        {
          i++;
          break;
          localArrayList.add(localObject);
        }
      }
    }
    return Collections.unmodifiableSet(new LinkedHashSet(localArrayList));
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    for (SetBinding localSetBinding = this; localSetBinding != null; localSetBinding = localSetBinding.parent)
      paramSet1.addAll(localSetBinding.contributors);
  }

  public void injectMembers(Set<T> paramSet)
  {
    throw new UnsupportedOperationException("Cannot inject members on a contributed Set<T>.");
  }

  public int size()
  {
    int i = 0;
    for (SetBinding localSetBinding = this; localSetBinding != null; localSetBinding = localSetBinding.parent)
      i += localSetBinding.contributors.size();
    return i;
  }

  public String toString()
  {
    int i = 1;
    StringBuilder localStringBuilder = new StringBuilder("SetBinding[");
    for (SetBinding localSetBinding = this; localSetBinding != null; localSetBinding = localSetBinding.parent)
    {
      int j = 0;
      int k = localSetBinding.contributors.size();
      while (j < k)
      {
        if (i == 0)
          localStringBuilder.append(",");
        localStringBuilder.append(localSetBinding.contributors.get(j));
        j++;
        i = 0;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.SetBinding
 * JD-Core Version:    0.6.2
 */