package com.ubercab.common.base;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;

public final class Joiner
{
  private final String separator;

  private Joiner(Joiner paramJoiner)
  {
    this.separator = paramJoiner.separator;
  }

  private Joiner(String paramString)
  {
    this.separator = paramString;
  }

  private static Iterable<Object> iterable(final Object paramObject1, final Object paramObject2, Object[] paramArrayOfObject)
  {
    return new AbstractList()
    {
      public Object get(int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default:
          return this.val$rest[(paramAnonymousInt - 2)];
        case 0:
          return paramObject1;
        case 1:
        }
        return paramObject2;
      }

      public int size()
      {
        return 2 + this.val$rest.length;
      }
    };
  }

  public static Joiner on(char paramChar)
  {
    return new Joiner(String.valueOf(paramChar));
  }

  public static Joiner on(String paramString)
  {
    return new Joiner(paramString);
  }

  public <A extends Appendable> A appendTo(A paramA, Iterator<?> paramIterator)
    throws IOException
  {
    if (paramIterator.hasNext())
    {
      paramA.append(toString(paramIterator.next()));
      while (paramIterator.hasNext())
      {
        paramA.append(this.separator);
        paramA.append(toString(paramIterator.next()));
      }
    }
    return paramA;
  }

  public StringBuilder appendTo(StringBuilder paramStringBuilder, Iterator<?> paramIterator)
  {
    try
    {
      appendTo(paramStringBuilder, paramIterator);
      return paramStringBuilder;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }

  public String join(Iterable<?> paramIterable)
  {
    return join(paramIterable.iterator());
  }

  public String join(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return join(iterable(paramObject1, paramObject2, paramArrayOfObject));
  }

  public String join(Iterator<?> paramIterator)
  {
    return appendTo(new StringBuilder(), paramIterator).toString();
  }

  public String join(Object[] paramArrayOfObject)
  {
    return join(Arrays.asList(paramArrayOfObject));
  }

  CharSequence toString(Object paramObject)
  {
    if ((paramObject instanceof CharSequence))
      return (CharSequence)paramObject;
    return paramObject.toString();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.base.Joiner
 * JD-Core Version:    0.6.2
 */