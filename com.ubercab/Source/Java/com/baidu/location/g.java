package com.baidu.location;

import java.text.SimpleDateFormat;
import java.util.Date;

class g
  implements ax, n
{
  private static g br = null;
  private long bo = 0L;
  public long bp = 0L;
  private long bq = 0L;
  public boolean bs = false;

  public static g e()
  {
    if (br == null)
      br = new g();
    return br;
  }

  public void h()
  {
    if (this.bs)
      return;
    this.bo = System.currentTimeMillis();
  }

  public long jdMethod_new(String paramString)
  {
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString).getTime();
      return l;
    }
    catch (Exception localException)
    {
    }
    return -1L;
  }

  public void jdMethod_try(String paramString)
  {
    if (this.bs);
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        this.bq = System.currentTimeMillis();
        l1 = (this.bq - this.bo) / 2L;
      }
      while ((l1 > 3000L) || (l1 < 0L));
      l2 = jdMethod_new(paramString);
    }
    while (l2 <= 0L);
    this.bp = (l1 + l2 - System.currentTimeMillis());
    this.bs = false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.g
 * JD-Core Version:    0.6.2
 */