package com.google.android.gms.internal;

import java.util.PriorityQueue;

public class as
{
  static long a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramLong2 * ((2147483647L + paramInt1) % 1073807359L) % 1073807359L;
    return (paramLong3 * ((paramLong1 + 1073807359L - l) % 1073807359L) % 1073807359L + (2147483647L + paramInt2) % 1073807359L) % 1073807359L;
  }

  static long a(long paramLong, int paramInt)
  {
    if (paramInt == 0)
      paramLong = 1L;
    while (paramInt == 1)
      return paramLong;
    if (paramInt % 2 == 0)
      return a(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L;
    return paramLong * (a(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L) % 1073807359L;
  }

  static String a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (paramArrayOfString.length < paramInt1 + paramInt2)
    {
      gs.T("Unable to construct shingle");
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = paramInt1; i < -1 + (paramInt1 + paramInt2); i++)
    {
      localStringBuffer.append(paramArrayOfString[i]);
      localStringBuffer.append(' ');
    }
    localStringBuffer.append(paramArrayOfString[(-1 + (paramInt1 + paramInt2))]);
    return localStringBuffer.toString();
  }

  private static void a(int paramInt1, long paramLong, int paramInt2, String[] paramArrayOfString, int paramInt3, PriorityQueue<a> paramPriorityQueue)
  {
    paramPriorityQueue.add(new a(paramLong, a(paramArrayOfString, paramInt2, paramInt3)));
    if (paramPriorityQueue.size() > paramInt1)
      paramPriorityQueue.poll();
  }

  public static void a(String[] paramArrayOfString, int paramInt1, int paramInt2, PriorityQueue<a> paramPriorityQueue)
  {
    long l1 = b(paramArrayOfString, 0, paramInt2);
    a(paramInt1, l1, 0, paramArrayOfString, paramInt2, paramPriorityQueue);
    long l2 = a(16785407L, paramInt2 - 1);
    int i = 1;
    while (i < 1 + (paramArrayOfString.length - paramInt2))
    {
      long l3 = a(aq.o(paramArrayOfString[(i - 1)]), aq.o(paramArrayOfString[(-1 + (i + paramInt2))]), l1, l2, 16785407L);
      a(paramInt1, l3, i, paramArrayOfString, paramInt2, paramPriorityQueue);
      i++;
      l1 = l3;
    }
  }

  private static long b(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    long l = (2147483647L + aq.o(paramArrayOfString[paramInt1])) % 1073807359L;
    for (int i = paramInt1 + 1; i < paramInt1 + paramInt2; i++)
      l = (l * 16785407L % 1073807359L + (2147483647L + aq.o(paramArrayOfString[i])) % 1073807359L) % 1073807359L;
    return l;
  }

  public static class a
  {
    final String nQ;
    final long value;

    a(long paramLong, String paramString)
    {
      this.value = paramLong;
      this.nQ = paramString;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.as
 * JD-Core Version:    0.6.2
 */