package com.baidu.mapapi.map;

import android.graphics.Color;
import java.util.HashMap;

public class Gradient
{
  private final int a;
  private final int[] b;
  private final float[] c;

  public Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    this(paramArrayOfInt, paramArrayOfFloat, 1000);
  }

  private Gradient(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfFloat == null))
      throw new IllegalArgumentException("colors and startPoints should not be null");
    if (paramArrayOfInt.length != paramArrayOfFloat.length)
      throw new IllegalArgumentException("colors and startPoints should be same length");
    if (paramArrayOfInt.length == 0)
      throw new IllegalArgumentException("No colors have been defined");
    for (int i = 1; i < paramArrayOfFloat.length; i++)
      if (paramArrayOfFloat[i] <= paramArrayOfFloat[(i - 1)])
        throw new IllegalArgumentException("startPoints should be in increasing order");
    this.a = paramInt;
    this.b = new int[paramArrayOfInt.length];
    this.c = new float[paramArrayOfFloat.length];
    System.arraycopy(paramArrayOfInt, 0, this.b, 0, paramArrayOfInt.length);
    System.arraycopy(paramArrayOfFloat, 0, this.c, 0, paramArrayOfFloat.length);
  }

  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = 0;
    int j = (int)(paramFloat * (Color.alpha(paramInt2) - Color.alpha(paramInt1)) + Color.alpha(paramInt1));
    float[] arrayOfFloat1 = new float[3];
    Color.RGBToHSV(Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1), arrayOfFloat1);
    float[] arrayOfFloat2 = new float[3];
    Color.RGBToHSV(Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2), arrayOfFloat2);
    if (arrayOfFloat1[0] - arrayOfFloat2[0] > 180.0F)
      arrayOfFloat2[0] = (360.0F + arrayOfFloat2[0]);
    float[] arrayOfFloat3;
    while (true)
    {
      arrayOfFloat3 = new float[3];
      while (i < 3)
      {
        arrayOfFloat3[i] = (paramFloat * (arrayOfFloat2[i] - arrayOfFloat1[i]) + arrayOfFloat1[i]);
        i++;
      }
      if (arrayOfFloat2[0] - arrayOfFloat1[0] > 180.0F)
        arrayOfFloat1[0] = (360.0F + arrayOfFloat1[0]);
    }
    return Color.HSVToColor(j, arrayOfFloat3);
  }

  private HashMap<Integer, a> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.c[0] != 0.0F)
    {
      int k = Color.argb(0, Color.red(this.b[0]), Color.green(this.b[0]), Color.blue(this.b[0]));
      localHashMap.put(Integer.valueOf(0), new a(k, this.b[0], this.a * this.c[0], null));
    }
    for (int i = 1; i < this.b.length; i++)
      localHashMap.put(Integer.valueOf((int)(this.a * this.c[(i - 1)])), new a(this.b[(i - 1)], this.b[i], this.a * (this.c[i] - this.c[(i - 1)]), null));
    if (this.c[(-1 + this.c.length)] != 1.0F)
    {
      int j = -1 + this.c.length;
      localHashMap.put(Integer.valueOf((int)(this.a * this.c[j])), new a(this.b[j], this.b[j], this.a * (1.0F - this.c[j]), null));
    }
    return localHashMap;
  }

  int[] a(double paramDouble)
  {
    HashMap localHashMap = a();
    int[] arrayOfInt = new int[this.a];
    a locala1 = (a)localHashMap.get(Integer.valueOf(0));
    int i = 0;
    Object localObject1 = locala1;
    int j = 0;
    int n;
    Object localObject2;
    if (i < this.a)
    {
      if (!localHashMap.containsKey(Integer.valueOf(i)))
        break label197;
      a locala2 = (a)localHashMap.get(Integer.valueOf(i));
      n = i;
      localObject2 = locala2;
    }
    while (true)
    {
      float f = (i - n) / a.a((a)localObject2);
      arrayOfInt[i] = a(a.b((a)localObject2), a.c((a)localObject2), f);
      i++;
      j = n;
      localObject1 = localObject2;
      break;
      boolean bool = paramDouble < 1.0D;
      int k = 0;
      if (bool)
        while (k < this.a)
        {
          int m = arrayOfInt[k];
          arrayOfInt[k] = Color.argb((int)(paramDouble * Color.alpha(m)), Color.red(m), Color.green(m), Color.blue(m));
          k++;
        }
      return arrayOfInt;
      label197: localObject2 = localObject1;
      n = j;
    }
  }

  private class a
  {
    private final int b;
    private final int c;
    private final float d;

    private a(int paramInt1, int paramFloat, float arg4)
    {
      this.b = paramInt1;
      this.c = paramFloat;
      Object localObject;
      this.d = localObject;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.Gradient
 * JD-Core Version:    0.6.2
 */