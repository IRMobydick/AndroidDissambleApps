package com.google.android.gms.plus.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;

public class i
{
  private String Dd;
  private String[] alF;
  private String alG;
  private String alH;
  private String alI;
  private PlusCommonExtras alK;
  private final ArrayList<String> alL = new ArrayList();
  private String[] alM;

  public i(Context paramContext)
  {
    this.alH = paramContext.getPackageName();
    this.alG = paramContext.getPackageName();
    this.alK = new PlusCommonExtras();
    this.alL.add("https://www.googleapis.com/auth/plus.login");
  }

  public i ch(String paramString)
  {
    this.Dd = paramString;
    return this;
  }

  public i g(String[] paramArrayOfString)
  {
    this.alL.clear();
    this.alL.addAll(Arrays.asList(paramArrayOfString));
    return this;
  }

  public i h(String[] paramArrayOfString)
  {
    this.alM = paramArrayOfString;
    return this;
  }

  public i np()
  {
    this.alL.clear();
    return this;
  }

  public h nq()
  {
    if (this.Dd == null)
      this.Dd = "<<default account>>";
    String[] arrayOfString = (String[])this.alL.toArray(new String[this.alL.size()]);
    return new h(this.Dd, arrayOfString, this.alM, this.alF, this.alG, this.alH, this.alI, this.alK);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.i
 * JD-Core Version:    0.6.2
 */