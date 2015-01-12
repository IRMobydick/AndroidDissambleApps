package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class g<T> extends DataBuffer<T>
{
  private boolean Kp = false;
  private ArrayList<Integer> Kq;

  protected g(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }

  private void gE()
  {
    while (true)
    {
      int k;
      try
      {
        if (!this.Kp)
        {
          int i = this.II.getCount();
          this.Kq = new ArrayList();
          if (i > 0)
          {
            this.Kq.add(Integer.valueOf(0));
            String str = gD();
            int j = this.II.ar(0);
            localObject2 = this.II.c(str, 0, j);
            k = 1;
            if (k < i)
            {
              int m = this.II.ar(k);
              localObject3 = this.II.c(str, k, m);
              if (((String)localObject3).equals(localObject2))
                break label148;
              this.Kq.add(Integer.valueOf(k));
              break label152;
            }
          }
          this.Kp = true;
        }
        else
        {
          return;
        }
      }
      finally
      {
      }
      label148: Object localObject3 = localObject2;
      label152: k++;
      Object localObject2 = localObject3;
    }
  }

  int au(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.Kq.size()))
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    return ((Integer)this.Kq.get(paramInt)).intValue();
  }

  protected int av(int paramInt)
  {
    int i;
    if ((paramInt < 0) || (paramInt == this.Kq.size()))
      i = 0;
    label137: 
    while (true)
    {
      return i;
      if (paramInt == -1 + this.Kq.size());
      for (i = this.II.getCount() - ((Integer)this.Kq.get(paramInt)).intValue(); ; i = ((Integer)this.Kq.get(paramInt + 1)).intValue() - ((Integer)this.Kq.get(paramInt)).intValue())
      {
        if (i != 1)
          break label137;
        int j = au(paramInt);
        int k = this.II.ar(j);
        String str = gF();
        if ((str == null) || (this.II.c(str, j, k) != null))
          break;
        return 0;
      }
    }
  }

  protected abstract T f(int paramInt1, int paramInt2);

  protected abstract String gD();

  protected String gF()
  {
    return null;
  }

  public final T get(int paramInt)
  {
    gE();
    return f(au(paramInt), av(paramInt));
  }

  public int getCount()
  {
    gE();
    return this.Kq.size();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.g
 * JD-Core Version:    0.6.2
 */