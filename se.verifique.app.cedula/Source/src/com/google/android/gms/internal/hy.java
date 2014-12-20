package com.google.android.gms.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class hy
{
  private void a(StringBuilder paramStringBuilder, hy.a parama, Object paramObject)
  {
    if (parama.b() == 11)
      paramStringBuilder.append(((hy)parama.h().cast(paramObject)).toString());
    while (true)
    {
      return;
      if (parama.b() == 7)
      {
        paramStringBuilder.append("\"");
        paramStringBuilder.append(lr.a((String)paramObject));
        paramStringBuilder.append("\"");
        continue;
      }
      paramStringBuilder.append(paramObject);
    }
  }

  private void a(StringBuilder paramStringBuilder, hy.a parama, ArrayList paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = 0;
    int j = paramArrayList.size();
    while (i < j)
    {
      if (i > 0)
        paramStringBuilder.append(",");
      Object localObject = paramArrayList.get(i);
      if (localObject != null)
        a(paramStringBuilder, parama, localObject);
      i++;
    }
    paramStringBuilder.append("]");
  }

  protected Object a(hy.a parama, Object paramObject)
  {
    if (hy.a.a(parama) != null)
      paramObject = parama.a(paramObject);
    return paramObject;
  }

  protected abstract Object a(String paramString);

  protected boolean a(hy.a parama)
  {
    boolean bool;
    if (parama.d() == 11)
      if (parama.e())
        bool = d(parama.f());
    while (true)
    {
      return bool;
      bool = c(parama.f());
      continue;
      bool = b(parama.f());
    }
  }

  protected Object b(hy.a parama)
  {
    String str1 = parama.f();
    boolean bool;
    HashMap localHashMap;
    if (parama.h() != null)
      if (a(parama.f()) == null)
      {
        bool = true;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = parama.f();
        kx.a(bool, "Concrete field shouldn't be value object: %s", arrayOfObject);
        if (!parama.e())
          break label84;
        localHashMap = d();
        label62: if (localHashMap == null)
          break label93;
      }
    for (Object localObject1 = localHashMap.get(str1); ; localObject1 = a(parama.f()))
      while (true)
      {
        return localObject1;
        bool = false;
        break;
        label84: localHashMap = c();
        break label62;
        try
        {
          label93: String str2 = "get" + Character.toUpperCase(str1.charAt(0)) + str1.substring(1);
          Object localObject2 = getClass().getMethod(str2, new Class[0]).invoke(this, new Object[0]);
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          throw new RuntimeException(localException);
        }
      }
  }

  public abstract HashMap b();

  protected abstract boolean b(String paramString);

  public HashMap c()
  {
    return null;
  }

  protected boolean c(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }

  public HashMap d()
  {
    return null;
  }

  protected boolean d(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }

  public String toString()
  {
    HashMap localHashMap = b();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      hy.a locala = (hy.a)localHashMap.get(str);
      if (!a(locala))
        continue;
      Object localObject = a(locala, b(locala));
      if (localStringBuilder.length() == 0)
        localStringBuilder.append("{");
      while (true)
      {
        localStringBuilder.append("\"").append(str).append("\":");
        if (localObject != null)
          break label135;
        localStringBuilder.append("null");
        break;
        localStringBuilder.append(",");
      }
      label135: switch (locala.d())
      {
      default:
        if (locala.c())
          a(localStringBuilder, locala, (ArrayList)localObject);
        break;
      case 8:
        localStringBuilder.append("\"").append(lo.a((byte[])(byte[])localObject)).append("\"");
        break;
      case 9:
        localStringBuilder.append("\"").append(lo.b((byte[])(byte[])localObject)).append("\"");
        break;
      case 10:
        ls.a(localStringBuilder, (HashMap)localObject);
        continue;
        a(localStringBuilder, locala, localObject);
      }
    }
    if (localStringBuilder.length() > 0)
      localStringBuilder.append("}");
    while (true)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{}");
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hy
 * JD-Core Version:    0.6.0
 */