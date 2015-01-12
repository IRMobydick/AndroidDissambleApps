package com.baidu.location;

import java.util.List;

class at
  implements ax
{
  public static String kt = null;
  private int kA = 0;
  private boolean kB = false;
  private int kC = 0;
  private int kD = 0;
  private String kE = "";
  private String kF = "";
  private boolean kG = false;
  public int ko = 0;
  private int kp = 1;
  private List kq = null;
  private final boolean kr = false;
  private double ks = 0.0D;
  private String ku = "";
  private boolean kv = false;
  private double kw = 0.0D;
  private char kx = 'N';
  private String ky = "";
  private boolean kz = false;

  public at(List paramList, String paramString1, String paramString2, String paramString3)
  {
    this.kq = paramList;
    this.ky = paramString1;
    this.kE = paramString2;
    this.kF = paramString3;
    cS();
  }

  private void cS()
  {
    int i = 0;
    if (t(this.kF))
    {
      String str = this.kF.substring(0, -3 + this.kF.length());
      int j = 0;
      while (i < str.length())
      {
        if (str.charAt(i) == ',')
          j++;
        i++;
      }
      String[] arrayOfString = str.split(",", j + 1);
      if (arrayOfString.length < 6)
        return;
      if ((!arrayOfString[2].equals("")) && (!arrayOfString[(-3 + arrayOfString.length)].equals("")) && (!arrayOfString[(-2 + arrayOfString.length)].equals("")) && (!arrayOfString[(-1 + arrayOfString.length)].equals("")))
      {
        this.kp = Integer.valueOf(arrayOfString[2]).intValue();
        this.kw = Double.valueOf(arrayOfString[(-3 + arrayOfString.length)]).doubleValue();
        this.ks = Double.valueOf(arrayOfString[(-2 + arrayOfString.length)]).doubleValue();
        this.kB = true;
      }
    }
    this.kz = this.kB;
  }

  private boolean t(String paramString)
  {
    boolean bool1 = false;
    if (paramString != null)
    {
      int i = paramString.length();
      bool1 = false;
      if (i > 8)
      {
        int j = 1;
        int k = 0;
        while (j < -3 + paramString.length())
        {
          k ^= paramString.charAt(j);
          j++;
        }
        boolean bool2 = Integer.toHexString(k).equalsIgnoreCase(paramString.substring(-2 + paramString.length(), paramString.length()));
        bool1 = false;
        if (bool2)
          bool1 = true;
      }
    }
    return bool1;
  }

  public double cT()
  {
    return this.ks;
  }

  public String cU()
  {
    return this.ku;
  }

  public boolean cV()
  {
    return this.kz;
  }

  public double cW()
  {
    return this.kw;
  }

  public int cX()
  {
    return this.kA;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.at
 * JD-Core Version:    0.6.2
 */