package com.baidu.location;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Timer;

public class aj
  implements n, ax
{
  public static final float hA = 4.0F;
  public static final float hj = 0.01F;
  private static final int hs = 6;
  private static final int hu = 20;
  private static final float hz = 0.8F;
  private int hB = 0;
  private SensorManager hC;
  private boolean hD;
  private int he;
  private int hf = 440;
  private int hg = 1;
  private final long hh = 30L;
  private float[] hi = new float[3];
  private int hk = 0;
  private double hl = 1.6D;
  private double[] hm = new double[6];
  public SensorEventListener hn = new aj.1(this);
  private int ho = 0;
  private long hp = 0L;
  Timer hq;
  private int hr;
  private Sensor ht;
  private float[] hv = { 0.0F, 0.0F, 0.0F };
  private volatile int hw = 0;
  private int hx = 31;
  private double[] hy = new double[this.hx];

  public aj(Context paramContext)
  {
    this(paramContext, 0);
  }

  private aj(Context paramContext, int paramInt)
  {
    try
    {
      this.hC = ((SensorManager)paramContext.getSystemService("sensor"));
      this.hr = paramInt;
      this.ht = this.hC.getDefaultSensor(1);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void bG()
  {
    if (this.he < 20);
    while (true)
    {
      return;
      long l = System.currentTimeMillis();
      float[] arrayOfFloat = new float[3];
      System.arraycopy(this.hv, 0, arrayOfFloat, 0, 3);
      double d1 = Math.sqrt(arrayOfFloat[0] * arrayOfFloat[0] + arrayOfFloat[1] * arrayOfFloat[1] + arrayOfFloat[2] * arrayOfFloat[2]);
      this.hy[this.hB] = d1;
      jdMethod_do(d1);
      this.hB = (1 + this.hB);
      if (this.hB == this.hx)
      {
        this.hB = 0;
        double d2 = jdMethod_if(this.hy);
        if ((this.hw != 0) || (d2 >= 0.3D))
          break label179;
        jdMethod_case(0);
      }
      for (this.hw = 0; (l - this.hp > this.hf) && (jdMethod_if(this.hl)); this.hw = 1)
      {
        this.hk = (1 + this.hk);
        this.hp = l;
        return;
        label179: jdMethod_case(1);
      }
    }
  }

  private void jdMethod_case(int paramInt)
  {
    try
    {
      this.hg = (paramInt | this.hg);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void jdMethod_do(double paramDouble)
  {
    this.hm[(this.ho % 6)] = paramDouble;
    this.ho = (1 + this.ho);
    this.ho %= 6;
  }

  private double jdMethod_if(double[] paramArrayOfDouble)
  {
    int i = 0;
    double d1 = 0.0D;
    int j = paramArrayOfDouble.length;
    int k = 0;
    double d2 = d1;
    while (k < j)
    {
      d2 += paramArrayOfDouble[k];
      k++;
    }
    double d3 = d2 / j;
    while (i < j)
    {
      d1 += (paramArrayOfDouble[i] - d3) * (paramArrayOfDouble[i] - d3);
      i++;
    }
    return d1 / (j - 1);
  }

  private boolean jdMethod_if(double paramDouble)
  {
    for (int i = 1; i <= 5; i++)
      if (this.hm[((6 + (6 + (-1 + this.ho - i))) % 6)] - this.hm[((6 + (-1 + this.ho)) % 6)] > paramDouble)
        return true;
    return false;
  }

  private float[] jdMethod_if(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat = new float[3];
    this.hi[0] = (0.8F * this.hi[0] + 0.2F * paramFloat1);
    this.hi[1] = (0.8F * this.hi[1] + 0.2F * paramFloat2);
    this.hi[2] = (0.8F * this.hi[2] + 0.2F * paramFloat3);
    arrayOfFloat[0] = (paramFloat1 - this.hi[0]);
    arrayOfFloat[1] = (paramFloat2 - this.hi[1]);
    arrayOfFloat[2] = (paramFloat3 - this.hi[2]);
    return arrayOfFloat;
  }

  public int bD()
  {
    try
    {
      int i = this.he;
      if (i < 20);
      for (int j = -1; ; j = this.hk)
        return j;
    }
    finally
    {
    }
  }

  public void bE()
  {
    try
    {
      this.hg = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int bF()
  {
    try
    {
      int i = this.he;
      if (i < 20);
      for (int j = 1; ; j = this.hg)
        return j;
    }
    finally
    {
    }
  }

  public void bH()
  {
    if ((!this.hD) && (this.ht != null));
    try
    {
      this.hC.registerListener(this.hn, this.ht, this.hr);
      label34: this.hq = new Timer("UpdateData", false);
      aj.2 local2 = new aj.2(this);
      this.hq.schedule(local2, 500L, 30L);
      this.hD = true;
      return;
    }
    catch (Exception localException)
    {
      break label34;
    }
  }

  public void bI()
  {
    if (this.hD == true);
    try
    {
      this.hC.unregisterListener(this.hn);
      label19: this.hq.cancel();
      this.hq.purge();
      this.hq = null;
      this.hD = false;
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.aj
 * JD-Core Version:    0.6.2
 */