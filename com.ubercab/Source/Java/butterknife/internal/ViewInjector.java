package butterknife.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ViewInjector
{
  private final String className;
  private final String classPackage;
  private final Map<CollectionBinding, int[]> collectionBindings = new LinkedHashMap();
  private String parentInjector;
  private final String targetClass;
  private final Map<Integer, ViewInjection> viewIdMap = new LinkedHashMap();

  ViewInjector(String paramString1, String paramString2, String paramString3)
  {
    this.classPackage = paramString1;
    this.className = paramString2;
    this.targetClass = paramString3;
  }

  static void emitCastIfNeeded(StringBuilder paramStringBuilder, String paramString)
  {
    emitCastIfNeeded(paramStringBuilder, "android.view.View", paramString);
  }

  static void emitCastIfNeeded(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (!paramString1.equals(paramString2))
      paramStringBuilder.append('(').append(paramString2).append(") ");
  }

  private void emitCollectionBinding(StringBuilder paramStringBuilder, CollectionBinding paramCollectionBinding, int[] paramArrayOfInt)
  {
    paramStringBuilder.append("    target.").append(paramCollectionBinding.getName()).append(" = ");
    int i;
    switch (1.$SwitchMap$butterknife$internal$CollectionBinding$Kind[paramCollectionBinding.getKind().ordinal()])
    {
    default:
      throw new IllegalStateException("Unknown kind: " + paramCollectionBinding.getKind());
    case 1:
      paramStringBuilder.append("Finder.arrayOf(");
      i = 0;
      label92: if (i >= paramArrayOfInt.length)
        break label202;
      if (i > 0)
        paramStringBuilder.append(',');
      paramStringBuilder.append("\n        ");
      emitCastIfNeeded(paramStringBuilder, paramCollectionBinding.getType());
      if (paramCollectionBinding.isRequired())
        paramStringBuilder.append("finder.findRequiredView(source, ").append(paramArrayOfInt[i]).append(", \"").append(paramCollectionBinding.getName()).append("\")");
      break;
    case 2:
    }
    while (true)
    {
      i++;
      break label92;
      paramStringBuilder.append("Finder.listOf(");
      break;
      paramStringBuilder.append("finder.findOptionalView(source, ").append(paramArrayOfInt[i]).append(")");
    }
    label202: paramStringBuilder.append("\n    );");
  }

  static void emitHumanDescription(StringBuilder paramStringBuilder, List<Binding> paramList)
  {
    int i;
    int j;
    switch (paramList.size())
    {
    default:
      i = 0;
      j = paramList.size();
    case 1:
      while (i < j)
      {
        Binding localBinding = (Binding)paramList.get(i);
        if (i != 0)
          paramStringBuilder.append(", ");
        if (i == j - 1)
          paramStringBuilder.append("and ");
        paramStringBuilder.append(localBinding.getDescription());
        i++;
        continue;
        paramStringBuilder.append(((Binding)paramList.get(0)).getDescription());
      }
      return;
    case 2:
    }
    paramStringBuilder.append(((Binding)paramList.get(0)).getDescription()).append(" and ").append(((Binding)paramList.get(1)).getDescription());
  }

  private void emitInject(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("  public static void inject(Finder finder, final ").append(this.targetClass).append(" target, Object source) {\n");
    if (this.parentInjector != null)
      paramStringBuilder.append("    ").append(this.parentInjector).append(".inject(finder, target, source);\n\n");
    paramStringBuilder.append("    View view;\n");
    Iterator localIterator1 = this.viewIdMap.values().iterator();
    while (localIterator1.hasNext())
      emitViewInjection(paramStringBuilder, (ViewInjection)localIterator1.next());
    Iterator localIterator2 = this.collectionBindings.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      emitCollectionBinding(paramStringBuilder, (CollectionBinding)localEntry.getKey(), (int[])localEntry.getValue());
    }
    paramStringBuilder.append("  }\n");
  }

  private void emitListenerBindings(StringBuilder paramStringBuilder, ViewInjection paramViewInjection)
  {
    Map localMap1 = paramViewInjection.getListenerBindings();
    if (localMap1.isEmpty());
    boolean bool;
    label227: label234: 
    do
    {
      return;
      String str = "";
      bool = paramViewInjection.getRequiredBindings().isEmpty();
      if (bool)
      {
        paramStringBuilder.append("    if (view != null) {\n");
        str = "  ";
      }
      Iterator localIterator1 = localMap1.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        ListenerClass localListenerClass = (ListenerClass)localEntry.getKey();
        Map localMap2 = (Map)localEntry.getValue();
        if (!"android.view.View".equals(localListenerClass.targetType()));
        for (int i = 1; ; i = 0)
        {
          paramStringBuilder.append(str).append("    ");
          if (i == 0)
            break label234;
          paramStringBuilder.append("((").append(localListenerClass.targetType());
          if (localListenerClass.genericArguments() <= 0)
            break label227;
          paramStringBuilder.append('<');
          for (int i3 = 0; i3 < localListenerClass.genericArguments(); i3++)
          {
            if (i3 > 0)
              paramStringBuilder.append(", ");
            paramStringBuilder.append('?');
          }
        }
        paramStringBuilder.append('>');
        paramStringBuilder.append(") ");
        paramStringBuilder.append("view");
        if (i != 0)
          paramStringBuilder.append(')');
        paramStringBuilder.append('.').append(localListenerClass.setter()).append("(\n");
        paramStringBuilder.append(str).append("      new ").append(localListenerClass.type()).append("() {\n");
        Iterator localIterator2 = getListenerMethods(localListenerClass).iterator();
        if (localIterator2.hasNext())
        {
          ListenerMethod localListenerMethod = (ListenerMethod)localIterator2.next();
          paramStringBuilder.append(str).append("        @Override public ").append(localListenerMethod.returnType()).append(' ').append(localListenerMethod.name()).append("(\n");
          String[] arrayOfString1 = localListenerMethod.parameters();
          int j = 0;
          int k = arrayOfString1.length;
          while (j < k)
          {
            paramStringBuilder.append(str).append("          ").append(arrayOfString1[j]).append(" p").append(j);
            if (j < k - 1)
              paramStringBuilder.append(',');
            paramStringBuilder.append('\n');
            j++;
          }
          paramStringBuilder.append(str).append("        ) {\n");
          paramStringBuilder.append(str).append("          ");
          if (!"void".equals(localListenerMethod.returnType()));
          for (int m = 1; ; m = 0)
          {
            if (m != 0)
              paramStringBuilder.append("return ");
            if (!localMap2.containsKey(localListenerMethod))
              break label710;
            ListenerBinding localListenerBinding = (ListenerBinding)localMap2.get(localListenerMethod);
            paramStringBuilder.append("target.").append(localListenerBinding.getName()).append('(');
            List localList = localListenerBinding.getParameters();
            String[] arrayOfString2 = localListenerMethod.parameters();
            int n = 0;
            int i1 = localList.size();
            while (n < i1)
            {
              Parameter localParameter = (Parameter)localList.get(n);
              int i2 = localParameter.getListenerPosition();
              emitCastIfNeeded(paramStringBuilder, arrayOfString2[i2], localParameter.getType());
              paramStringBuilder.append('p').append(i2);
              if (n < i1 - 1)
                paramStringBuilder.append(", ");
              n++;
            }
          }
          paramStringBuilder.append(");");
          while (true)
          {
            paramStringBuilder.append('\n');
            paramStringBuilder.append(str).append("        }\n");
            break;
            if (m != 0)
              paramStringBuilder.append(localListenerMethod.defaultReturn()).append(';');
          }
        }
        paramStringBuilder.append(str).append("      });\n");
      }
    }
    while (!bool);
    label710: paramStringBuilder.append("    }\n");
  }

  private void emitReset(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("  public static void reset(").append(this.targetClass).append(" target) {\n");
    if (this.parentInjector != null)
      paramStringBuilder.append("    ").append(this.parentInjector).append(".reset(target);\n\n");
    Iterator localIterator1 = this.viewIdMap.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator3 = ((ViewInjection)localIterator1.next()).getViewBindings().iterator();
      while (localIterator3.hasNext())
      {
        ViewBinding localViewBinding = (ViewBinding)localIterator3.next();
        paramStringBuilder.append("    target.").append(localViewBinding.getName()).append(" = null;\n");
      }
    }
    Iterator localIterator2 = this.collectionBindings.keySet().iterator();
    while (localIterator2.hasNext())
    {
      CollectionBinding localCollectionBinding = (CollectionBinding)localIterator2.next();
      paramStringBuilder.append("    target.").append(localCollectionBinding.getName()).append(" = null;\n");
    }
    paramStringBuilder.append("  }\n");
  }

  private void emitViewBindings(StringBuilder paramStringBuilder, ViewInjection paramViewInjection)
  {
    Collection localCollection = paramViewInjection.getViewBindings();
    if (localCollection.isEmpty());
    while (true)
    {
      return;
      Iterator localIterator = localCollection.iterator();
      while (localIterator.hasNext())
      {
        ViewBinding localViewBinding = (ViewBinding)localIterator.next();
        paramStringBuilder.append("    target.").append(localViewBinding.getName()).append(" = ");
        emitCastIfNeeded(paramStringBuilder, localViewBinding.getType());
        paramStringBuilder.append("view;\n");
      }
    }
  }

  private void emitViewInjection(StringBuilder paramStringBuilder, ViewInjection paramViewInjection)
  {
    paramStringBuilder.append("    view = ");
    List localList = paramViewInjection.getRequiredBindings();
    if (localList.isEmpty())
      paramStringBuilder.append("finder.findOptionalView(source, ").append(paramViewInjection.getId()).append(");\n");
    while (true)
    {
      emitViewBindings(paramStringBuilder, paramViewInjection);
      emitListenerBindings(paramStringBuilder, paramViewInjection);
      return;
      paramStringBuilder.append("finder.findRequiredView(source, ").append(paramViewInjection.getId()).append(", \"");
      emitHumanDescription(paramStringBuilder, localList);
      paramStringBuilder.append("\");\n");
    }
  }

  static List<ListenerMethod> getListenerMethods(ListenerClass paramListenerClass)
  {
    int i = 0;
    Object localObject;
    if (paramListenerClass.method().length == 1)
    {
      localObject = Arrays.asList(paramListenerClass.method());
      return localObject;
    }
    while (true)
    {
      ListenerMethod localListenerMethod;
      try
      {
        localObject = new ArrayList();
        Class localClass = paramListenerClass.callbacks();
        Enum[] arrayOfEnum = (Enum[])localClass.getEnumConstants();
        int j = arrayOfEnum.length;
        if (i >= j)
          break;
        Enum localEnum = arrayOfEnum[i];
        localListenerMethod = (ListenerMethod)localClass.getField(localEnum.name()).getAnnotation(ListenerMethod.class);
        if (localListenerMethod == null)
        {
          Object[] arrayOfObject = new Object[4];
          arrayOfObject[0] = localClass.getEnclosingClass().getSimpleName();
          arrayOfObject[1] = localClass.getSimpleName();
          arrayOfObject[2] = localEnum.name();
          arrayOfObject[3] = ListenerMethod.class.getSimpleName();
          throw new IllegalStateException(String.format("@%s's %s.%s missing @%s annotation.", arrayOfObject));
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        throw new AssertionError(localNoSuchFieldException);
      }
      ((List)localObject).add(localListenerMethod);
      i++;
    }
  }

  private ViewInjection getOrCreateViewInjection(int paramInt)
  {
    ViewInjection localViewInjection = (ViewInjection)this.viewIdMap.get(Integer.valueOf(paramInt));
    if (localViewInjection == null)
    {
      localViewInjection = new ViewInjection(paramInt);
      this.viewIdMap.put(Integer.valueOf(paramInt), localViewInjection);
    }
    return localViewInjection;
  }

  void addCollection(int[] paramArrayOfInt, CollectionBinding paramCollectionBinding)
  {
    this.collectionBindings.put(paramCollectionBinding, paramArrayOfInt);
  }

  boolean addListener(int paramInt, ListenerClass paramListenerClass, ListenerMethod paramListenerMethod, ListenerBinding paramListenerBinding)
  {
    ViewInjection localViewInjection = getOrCreateViewInjection(paramInt);
    if (localViewInjection.hasListenerBinding(paramListenerClass, paramListenerMethod))
      return false;
    localViewInjection.addListenerBinding(paramListenerClass, paramListenerMethod, paramListenerBinding);
    return true;
  }

  void addView(int paramInt, ViewBinding paramViewBinding)
  {
    getOrCreateViewInjection(paramInt).addViewBinding(paramViewBinding);
  }

  String brewJava()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("// Generated code from Butter Knife. Do not modify!\n");
    localStringBuilder.append("package ").append(this.classPackage).append(";\n\n");
    localStringBuilder.append("import android.view.View;\n");
    localStringBuilder.append("import butterknife.ButterKnife.Finder;\n\n");
    localStringBuilder.append("public class ").append(this.className).append(" {\n");
    emitInject(localStringBuilder);
    localStringBuilder.append('\n');
    emitReset(localStringBuilder);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }

  String getFqcn()
  {
    return this.classPackage + "." + this.className;
  }

  void setParentInjector(String paramString)
  {
    this.parentInjector = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     butterknife.internal.ViewInjector
 * JD-Core Version:    0.6.2
 */