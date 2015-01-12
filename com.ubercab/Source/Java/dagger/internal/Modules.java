package dagger.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class Modules
{
  private static void collectIncludedModulesRecursively(Loader paramLoader, ModuleAdapter<?> paramModuleAdapter, Map<Class<?>, ModuleAdapter<?>> paramMap)
  {
    for (Class localClass : paramModuleAdapter.includes)
      if (!paramMap.containsKey(localClass))
      {
        ModuleAdapter localModuleAdapter = paramLoader.getModuleAdapter(localClass);
        paramMap.put(localClass, localModuleAdapter);
        collectIncludedModulesRecursively(paramLoader, localModuleAdapter, paramMap);
      }
  }

  public static Map<ModuleAdapter<?>, Object> loadModules(Loader paramLoader, Object[] paramArrayOfObject)
  {
    LinkedHashMap localLinkedHashMap1 = new LinkedHashMap(paramArrayOfObject.length);
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      if ((paramArrayOfObject[i] instanceof Class))
      {
        ModuleAdapter localModuleAdapter2 = paramLoader.getModuleAdapter((Class)paramArrayOfObject[i]);
        localLinkedHashMap1.put(localModuleAdapter2, localModuleAdapter2.newModule());
      }
      while (true)
      {
        i++;
        break;
        localLinkedHashMap1.put(paramLoader.getModuleAdapter(paramArrayOfObject[i].getClass()), paramArrayOfObject[i]);
      }
    }
    LinkedHashMap localLinkedHashMap2 = new LinkedHashMap(localLinkedHashMap1);
    LinkedHashMap localLinkedHashMap3 = new LinkedHashMap();
    Iterator localIterator1 = localLinkedHashMap1.keySet().iterator();
    while (localIterator1.hasNext())
      collectIncludedModulesRecursively(paramLoader, (ModuleAdapter)localIterator1.next(), localLinkedHashMap3);
    Iterator localIterator2 = localLinkedHashMap3.values().iterator();
    while (localIterator2.hasNext())
    {
      ModuleAdapter localModuleAdapter1 = (ModuleAdapter)localIterator2.next();
      if (!localLinkedHashMap2.containsKey(localModuleAdapter1))
        localLinkedHashMap2.put(localModuleAdapter1, localModuleAdapter1.newModule());
    }
    return localLinkedHashMap2;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.Modules
 * JD-Core Version:    0.6.2
 */