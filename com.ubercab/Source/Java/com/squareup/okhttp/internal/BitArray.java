package com.squareup.okhttp.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract interface BitArray
{
  public abstract void clear();

  public abstract boolean get(int paramInt);

  public abstract void set(int paramInt);

  public abstract void shiftLeft(int paramInt);

  public abstract void toggle(int paramInt);

  public static final class FixedCapacity
    implements BitArray
  {
    long data = 0L;

    private static int checkInput(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 63))
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        throw new IllegalArgumentException(String.format("input must be between 0 and 63: %s", arrayOfObject));
      }
      return paramInt;
    }

    public void clear()
    {
      this.data = 0L;
    }

    public boolean get(int paramInt)
    {
      return (1L & this.data >> checkInput(paramInt)) == 1L;
    }

    public void set(int paramInt)
    {
      this.data |= 1L << checkInput(paramInt);
    }

    public void shiftLeft(int paramInt)
    {
      this.data <<= checkInput(paramInt);
    }

    public String toString()
    {
      return Long.toBinaryString(this.data);
    }

    public BitArray toVariableCapacity()
    {
      return new BitArray.VariableCapacity(this, null);
    }

    public void toggle(int paramInt)
    {
      this.data ^= 1L << checkInput(paramInt);
    }
  }

  public static final class VariableCapacity
    implements BitArray
  {
    long[] data;
    private int start;

    public VariableCapacity()
    {
      this.data = new long[1];
    }

    private VariableCapacity(BitArray.FixedCapacity paramFixedCapacity)
    {
      long[] arrayOfLong = new long[2];
      arrayOfLong[0] = paramFixedCapacity.data;
      arrayOfLong[1] = 0L;
      this.data = arrayOfLong;
    }

    private static int checkInput(int paramInt)
    {
      if (paramInt < 0)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        throw new IllegalArgumentException(String.format("input must be a positive number: %s", arrayOfObject));
      }
      return paramInt;
    }

    private void growToSize(int paramInt)
    {
      long[] arrayOfLong = new long[paramInt];
      if (this.data != null)
        System.arraycopy(this.data, 0, arrayOfLong, 0, this.data.length);
      this.data = arrayOfLong;
    }

    private int offsetOf(int paramInt)
    {
      int i = (paramInt + this.start) / 64;
      if (i > -1 + this.data.length)
        growToSize(i + 1);
      return i;
    }

    private int shiftOf(int paramInt)
    {
      return (paramInt + this.start) % 64;
    }

    public void clear()
    {
      Arrays.fill(this.data, 0L);
    }

    public boolean get(int paramInt)
    {
      checkInput(paramInt);
      int i = offsetOf(paramInt);
      return (this.data[i] & 1L << shiftOf(paramInt)) != 0L;
    }

    public void set(int paramInt)
    {
      checkInput(paramInt);
      int i = offsetOf(paramInt);
      long[] arrayOfLong = this.data;
      arrayOfLong[i] |= 1L << shiftOf(paramInt);
    }

    public void shiftLeft(int paramInt)
    {
      this.start -= checkInput(paramInt);
      if (this.start < 0)
      {
        int i = 1 + this.start / -64;
        long[] arrayOfLong = new long[i + this.data.length];
        System.arraycopy(this.data, 0, arrayOfLong, i, this.data.length);
        this.data = arrayOfLong;
        this.start = (64 + this.start % 64);
      }
    }

    List<Integer> toIntegerList()
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = 64 * this.data.length - this.start;
      while (i < j)
      {
        if (get(i))
          localArrayList.add(Integer.valueOf(i));
        i++;
      }
      return localArrayList;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{");
      List localList = toIntegerList();
      int i = 0;
      int j = localList.size();
      while (i < j)
      {
        if (i > 0)
          localStringBuilder.append(',');
        localStringBuilder.append(localList.get(i));
        i++;
      }
      return '}';
    }

    public void toggle(int paramInt)
    {
      checkInput(paramInt);
      int i = offsetOf(paramInt);
      long[] arrayOfLong = this.data;
      arrayOfLong[i] ^= 1L << shiftOf(paramInt);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.BitArray
 * JD-Core Version:    0.6.2
 */