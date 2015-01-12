package dagger.internal;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ProblemDetector
{
  private static void detectCircularDependencies(Collection<Binding<?>> paramCollection, List<Binding<?>> paramList)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Binding localBinding = (Binding)localIterator.next();
      if (!localBinding.isCycleFree())
      {
        if (localBinding.isVisiting())
        {
          int i = paramList.indexOf(localBinding);
          StringBuilder localStringBuilder = new StringBuilder().append("Dependency cycle:");
          for (int j = i; j < paramList.size(); j++)
            localStringBuilder.append("\n    ").append(j - i).append(". ").append(((Binding)paramList.get(j)).provideKey).append(" bound by ").append(paramList.get(j));
          localStringBuilder.append("\n    ").append(0).append(". ").append(localBinding.provideKey);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        localBinding.setVisiting(true);
        paramList.add(localBinding);
        try
        {
          ArraySet localArraySet = new ArraySet();
          localBinding.getDependencies(localArraySet, localArraySet);
          detectCircularDependencies(localArraySet, paramList);
          localBinding.setCycleFree(true);
          paramList.remove(-1 + paramList.size());
          localBinding.setVisiting(false);
        }
        finally
        {
          paramList.remove(-1 + paramList.size());
          localBinding.setVisiting(false);
        }
      }
    }
  }

  public void detectCircularDependencies(Collection<Binding<?>> paramCollection)
  {
    detectCircularDependencies(paramCollection, new ArrayList());
  }

  public void detectProblems(Collection<Binding<?>> paramCollection)
  {
    detectCircularDependencies(paramCollection);
    detectUnusedBinding(paramCollection);
  }

  public void detectUnusedBinding(Collection<Binding<?>> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Binding localBinding = (Binding)localIterator.next();
      if ((!localBinding.library()) && (!localBinding.dependedOn()))
        localArrayList.add(localBinding);
    }
    if (!localArrayList.isEmpty())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("You have these unused @Provider methods:");
      for (int i = 0; i < localArrayList.size(); i++)
        localStringBuilder.append("\n    ").append(i + 1).append(". ").append(((Binding)localArrayList.get(i)).requiredBy);
      localStringBuilder.append("\n    Set library=true in your module to disable this check.");
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }

  static class ArraySet<T> extends AbstractSet<T>
  {
    private final ArrayList<T> list = new ArrayList();

    public boolean add(T paramT)
    {
      this.list.add(paramT);
      return true;
    }

    public Iterator<T> iterator()
    {
      return this.list.iterator();
    }

    public int size()
    {
      throw new UnsupportedOperationException();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.ProblemDetector
 * JD-Core Version:    0.6.2
 */