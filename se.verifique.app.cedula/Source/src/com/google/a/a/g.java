package com.google.a.a;

import com.google.android.gms.internal.hi;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public abstract class g
{
  protected void a()
  {
  }

  public void a(Map paramMap)
  {
    HashMap localHashMap = new HashMap();
    for (Field localField3 : getClass().getFields())
    {
      i locali = (i)localField3.getAnnotation(i.class);
      if (locali == null)
        continue;
      localHashMap.put(locali.a(), localField3);
    }
    if (localHashMap.isEmpty())
      hi.e("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Field localField2 = (Field)localHashMap.remove(localEntry.getKey());
      if (localField2 != null)
      {
        try
        {
          localField2.set(this, localEntry.getValue());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          hi.e("Server option \"" + (String)localEntry.getKey() + "\" could not be set: Illegal Access");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          hi.e("Server option \"" + (String)localEntry.getKey() + "\" could not be set: Bad Type");
        }
        continue;
      }
      hi.a("Unexpected server option: " + (String)localEntry.getKey() + " = \"" + (String)localEntry.getValue() + "\"");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator2 = localHashMap.values().iterator();
    while (localIterator2.hasNext())
    {
      Field localField1 = (Field)localIterator2.next();
      if (!((i)localField1.getAnnotation(i.class)).b())
        continue;
      hi.e("Required server option missing: " + ((i)localField1.getAnnotation(i.class)).a());
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(((i)localField1.getAnnotation(i.class)).a());
    }
    if (localStringBuilder.length() > 0)
      throw new h("Required server option(s) missing: " + localStringBuilder.toString());
    a();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.a.a.g
 * JD-Core Version:    0.6.0
 */