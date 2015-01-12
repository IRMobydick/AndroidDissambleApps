package com.baidu.location;

import android.location.Location;

class j
  implements ax, b
{
  private static j kL = null;
  double kH = 0.0D;
  double kI = 0.0D;
  boolean kJ = false;
  volatile int kK = -1;
  double kM = 0.0D;
  int kN = -1;
  long kO = 0L;
  double kP = 0.0D;

  public static j cZ()
  {
    if (kL == null)
      kL = new j();
    return kL;
  }

  public void jdMethod_byte(BDLocation paramBDLocation)
  {
    if (!this.kJ);
    while ((System.currentTimeMillis() - this.kO > 4000L) || (paramBDLocation == null) || (paramBDLocation.getLocType() != 161) || ((!"wf".equals(paramBDLocation.getNetworkLocationType())) && (paramBDLocation.getRadius() >= 300.0F)))
      return;
    this.kH = paramBDLocation.getLongitude();
    this.kI = paramBDLocation.getLatitude();
    float[] arrayOfFloat = new float[1];
    Location.distanceBetween(this.kM, this.kP, this.kI, this.kH, arrayOfFloat);
    this.kK = ((int)arrayOfFloat[0]);
    this.kJ = false;
  }

  public String cY()
  {
    int i = 1;
    if ((this.kN < 0) && (this.kK < 0))
      return null;
    StringBuffer localStringBuffer = new StringBuffer(128);
    int j = this.kN;
    int k = 0;
    if (j >= 0)
    {
      localStringBuffer.append("&osr=");
      localStringBuffer.append(this.kN);
      this.kN = -1;
      k = i;
    }
    if (this.kK >= 0)
    {
      localStringBuffer.append("&oac=");
      localStringBuffer.append(this.kK);
      this.kK = -2;
    }
    while (true)
    {
      if (i != 0)
        return localStringBuffer.toString();
      return null;
      i = k;
    }
  }

  public void jdMethod_if(boolean paramBoolean1, boolean paramBoolean2, double paramDouble1, double paramDouble2)
  {
    if (this.kN < 0)
      this.kN = 0;
    if (paramBoolean1)
      this.kN = (0x1 | this.kN);
    if (paramBoolean2)
    {
      this.kN = (0x2 | this.kN);
      this.kP = paramDouble1;
      this.kM = paramDouble2;
      this.kJ = true;
      this.kO = System.currentTimeMillis();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.j
 * JD-Core Version:    0.6.2
 */