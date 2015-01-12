package butterknife.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class ViewInjection
{
  private final int id;
  private final Map<ListenerClass, Map<ListenerMethod, ListenerBinding>> listenerBindings = new LinkedHashMap();
  private final Set<ViewBinding> viewBindings = new LinkedHashSet();

  ViewInjection(int paramInt)
  {
    this.id = paramInt;
  }

  public void addListenerBinding(ListenerClass paramListenerClass, ListenerMethod paramListenerMethod, ListenerBinding paramListenerBinding)
  {
    Object localObject = (Map)this.listenerBindings.get(paramListenerClass);
    if (localObject == null)
    {
      localObject = new LinkedHashMap();
      this.listenerBindings.put(paramListenerClass, localObject);
    }
    ListenerBinding localListenerBinding = (ListenerBinding)((Map)localObject).get(paramListenerMethod);
    if (localListenerBinding != null)
      throw new IllegalStateException("View " + this.id + " already has listener binding for " + paramListenerClass.type() + "." + paramListenerMethod.name() + " on " + localListenerBinding.getDescription());
    ((Map)localObject).put(paramListenerMethod, paramListenerBinding);
  }

  public void addViewBinding(ViewBinding paramViewBinding)
  {
    this.viewBindings.add(paramViewBinding);
  }

  public int getId()
  {
    return this.id;
  }

  public Map<ListenerClass, Map<ListenerMethod, ListenerBinding>> getListenerBindings()
  {
    return this.listenerBindings;
  }

  public List<Binding> getRequiredBindings()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.viewBindings.iterator();
    while (localIterator1.hasNext())
    {
      ViewBinding localViewBinding = (ViewBinding)localIterator1.next();
      if (localViewBinding.isRequired())
        localArrayList.add(localViewBinding);
    }
    Iterator localIterator2 = this.listenerBindings.values().iterator();
    while (localIterator2.hasNext())
    {
      Iterator localIterator3 = ((Map)localIterator2.next()).values().iterator();
      while (localIterator3.hasNext())
      {
        ListenerBinding localListenerBinding = (ListenerBinding)localIterator3.next();
        if (localListenerBinding.isRequired())
          localArrayList.add(localListenerBinding);
      }
    }
    return localArrayList;
  }

  public Collection<ViewBinding> getViewBindings()
  {
    return this.viewBindings;
  }

  public boolean hasListenerBinding(ListenerClass paramListenerClass, ListenerMethod paramListenerMethod)
  {
    Map localMap = (Map)this.listenerBindings.get(paramListenerClass);
    return (localMap != null) && (localMap.containsKey(paramListenerMethod));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     butterknife.internal.ViewInjection
 * JD-Core Version:    0.6.2
 */