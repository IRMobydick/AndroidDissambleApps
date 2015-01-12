package dagger;

import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.FailoverLoader;
import dagger.internal.Keys;
import dagger.internal.Linker;
import dagger.internal.Loader;
import dagger.internal.ModuleAdapter;
import dagger.internal.Modules;
import dagger.internal.ProblemDetector;
import dagger.internal.SetBinding;
import dagger.internal.StaticInjection;
import dagger.internal.ThrowingErrorHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ObjectGraph
{
  public static ObjectGraph create(Object[] paramArrayOfObject)
  {
    return DaggerObjectGraph.makeGraph(null, new FailoverLoader(), paramArrayOfObject);
  }

  static ObjectGraph createWith(Loader paramLoader, Object[] paramArrayOfObject)
  {
    return DaggerObjectGraph.makeGraph(null, paramLoader, paramArrayOfObject);
  }

  public abstract <T> T get(Class<T> paramClass);

  public abstract <T> T inject(T paramT);

  public abstract void injectStatics();

  public abstract ObjectGraph plus(Object[] paramArrayOfObject);

  public abstract void validate();

  static class DaggerObjectGraph extends ObjectGraph
  {
    private final DaggerObjectGraph base;
    private final Map<String, Class<?>> injectableTypes;
    private final Linker linker;
    private final Loader plugin;
    private final List<SetBinding<?>> setBindings;
    private final Map<Class<?>, StaticInjection> staticInjections;

    DaggerObjectGraph(DaggerObjectGraph paramDaggerObjectGraph, Linker paramLinker, Loader paramLoader, Map<Class<?>, StaticInjection> paramMap, Map<String, Class<?>> paramMap1, List<SetBinding<?>> paramList)
    {
      this.base = paramDaggerObjectGraph;
      this.linker = ((Linker)checkNotNull(paramLinker, "linker"));
      this.plugin = ((Loader)checkNotNull(paramLoader, "plugin"));
      this.staticInjections = ((Map)checkNotNull(paramMap, "staticInjections"));
      this.injectableTypes = ((Map)checkNotNull(paramMap1, "injectableTypes"));
      this.setBindings = ((List)checkNotNull(paramList, "setBindings"));
    }

    private static <T> T checkNotNull(T paramT, String paramString)
    {
      if (paramT == null)
        throw new NullPointerException(paramString);
      return paramT;
    }

    private Binding<?> getInjectableTypeBinding(ClassLoader paramClassLoader, String paramString1, String paramString2)
    {
      Class localClass = null;
      for (DaggerObjectGraph localDaggerObjectGraph = this; ; localDaggerObjectGraph = localDaggerObjectGraph.base)
        if (localDaggerObjectGraph != null)
        {
          localClass = (Class)localDaggerObjectGraph.injectableTypes.get(paramString1);
          if (localClass == null);
        }
        else
        {
          if (localClass != null)
            break;
          throw new IllegalArgumentException("No inject registered for " + paramString1 + ". You must explicitly add it to the 'injects' option in one of your modules.");
        }
      synchronized (this.linker)
      {
        Binding localBinding = this.linker.requestBinding(paramString2, localClass, paramClassLoader, false, true);
        if ((localBinding == null) || (!localBinding.isLinked()))
        {
          this.linker.linkRequested();
          localBinding = this.linker.requestBinding(paramString2, localClass, paramClassLoader, false, true);
        }
        return localBinding;
      }
    }

    private Map<String, Binding<?>> linkEverything()
    {
      Map localMap1 = this.linker.fullyLinkedBindings();
      if (localMap1 != null)
        return localMap1;
      synchronized (this.linker)
      {
        Map localMap2 = this.linker.fullyLinkedBindings();
        if (localMap2 != null)
          return localMap2;
        linkStaticInjections();
        linkInjectableTypes();
        Map localMap3 = this.linker.linkAll();
        return localMap3;
      }
    }

    private void linkInjectableTypes()
    {
      Iterator localIterator = this.injectableTypes.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.linker.requestBinding((String)localEntry.getKey(), localEntry.getValue(), ((Class)localEntry.getValue()).getClassLoader(), false, true);
      }
    }

    private void linkStaticInjections()
    {
      Iterator localIterator = this.staticInjections.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        StaticInjection localStaticInjection = (StaticInjection)localEntry.getValue();
        if (localStaticInjection == null)
        {
          localStaticInjection = this.plugin.getStaticInjection((Class)localEntry.getKey());
          localEntry.setValue(localStaticInjection);
        }
        localStaticInjection.attach(this.linker);
      }
    }

    private static ObjectGraph makeGraph(DaggerObjectGraph paramDaggerObjectGraph, Loader paramLoader, Object[] paramArrayOfObject)
    {
      LinkedHashMap localLinkedHashMap1 = new LinkedHashMap();
      LinkedHashMap localLinkedHashMap2 = new LinkedHashMap();
      if (paramDaggerObjectGraph == null);
      ObjectGraph.OverridesBindings localOverridesBindings;
      Map.Entry localEntry;
      ModuleAdapter localModuleAdapter;
      for (ObjectGraph.StandardBindings localStandardBindings = new ObjectGraph.StandardBindings(); ; localStandardBindings = new ObjectGraph.StandardBindings(paramDaggerObjectGraph.setBindings))
      {
        localOverridesBindings = new ObjectGraph.OverridesBindings();
        Iterator localIterator = Modules.loadModules(paramLoader, paramArrayOfObject).entrySet().iterator();
        if (!localIterator.hasNext())
          break label265;
        localEntry = (Map.Entry)localIterator.next();
        localModuleAdapter = (ModuleAdapter)localEntry.getKey();
        for (int i = 0; i < localModuleAdapter.injectableTypes.length; i++)
          localLinkedHashMap1.put(localModuleAdapter.injectableTypes[i], localModuleAdapter.moduleClass);
      }
      for (int j = 0; j < localModuleAdapter.staticInjections.length; j++)
        localLinkedHashMap2.put(localModuleAdapter.staticInjections[j], null);
      while (true)
      {
        try
        {
          if (localModuleAdapter.overrides)
          {
            localObject = localOverridesBindings;
            localModuleAdapter.getBindings((BindingsGroup)localObject, localEntry.getValue());
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw new IllegalArgumentException(localModuleAdapter.moduleClass.getSimpleName() + ": " + localIllegalArgumentException.getMessage(), localIllegalArgumentException);
        }
        Object localObject = localStandardBindings;
      }
      label265: if (paramDaggerObjectGraph != null);
      for (Linker localLinker1 = paramDaggerObjectGraph.linker; ; localLinker1 = null)
      {
        Linker localLinker2 = new Linker(localLinker1, paramLoader, new ThrowingErrorHandler());
        localLinker2.installBindings(localStandardBindings);
        localLinker2.installBindings(localOverridesBindings);
        return new DaggerObjectGraph(paramDaggerObjectGraph, localLinker2, paramLoader, localLinkedHashMap2, localLinkedHashMap1, ObjectGraph.StandardBindings.access$100(localStandardBindings));
      }
    }

    public <T> T get(Class<T> paramClass)
    {
      String str1 = Keys.get(paramClass);
      if (paramClass.isInterface());
      for (String str2 = str1; ; str2 = Keys.getMembersKey(paramClass))
        return getInjectableTypeBinding(paramClass.getClassLoader(), str2, str1).get();
    }

    public <T> T inject(T paramT)
    {
      String str = Keys.getMembersKey(paramT.getClass());
      getInjectableTypeBinding(paramT.getClass().getClassLoader(), str, str).injectMembers(paramT);
      return paramT;
    }

    public void injectStatics()
    {
      synchronized (this.linker)
      {
        linkStaticInjections();
        this.linker.linkRequested();
        linkStaticInjections();
        Iterator localIterator = this.staticInjections.entrySet().iterator();
        if (localIterator.hasNext())
          ((StaticInjection)((Map.Entry)localIterator.next()).getValue()).inject();
      }
    }

    public ObjectGraph plus(Object[] paramArrayOfObject)
    {
      linkEverything();
      return makeGraph(this, this.plugin, paramArrayOfObject);
    }

    public void validate()
    {
      Map localMap = linkEverything();
      new ProblemDetector().detectProblems(localMap.values());
    }
  }

  private static final class OverridesBindings extends BindingsGroup
  {
    public Binding<?> contributeSetBinding(String paramString, SetBinding<?> paramSetBinding)
    {
      throw new IllegalArgumentException("Module overrides cannot contribute set bindings.");
    }
  }

  private static final class StandardBindings extends BindingsGroup
  {
    private final List<SetBinding<?>> setBindings;

    public StandardBindings()
    {
      this.setBindings = new ArrayList();
    }

    public StandardBindings(List<SetBinding<?>> paramList)
    {
      this.setBindings = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        SetBinding localSetBinding = new SetBinding((SetBinding)localIterator.next());
        this.setBindings.add(localSetBinding);
        put(localSetBinding.provideKey, localSetBinding);
      }
    }

    public Binding<?> contributeSetBinding(String paramString, SetBinding<?> paramSetBinding)
    {
      this.setBindings.add(paramSetBinding);
      return super.put(paramString, paramSetBinding);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.ObjectGraph
 * JD-Core Version:    0.6.2
 */