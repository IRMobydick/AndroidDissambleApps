package com.baidu.platform.comjni.map.cloud;

import android.os.Bundle;

public class a
{
  private static final String a = a.class.getSimpleName();
  private int b;
  private JniCloud c = new JniCloud();

  public int a()
  {
    this.b = this.c.create();
    return this.b;
  }

  public String a(int paramInt)
  {
    return this.c.getSearchResult(this.b, paramInt);
  }

  public void a(Bundle paramBundle)
  {
    this.c.cloudSearch(this.b, paramBundle);
  }

  public int b()
  {
    return this.c.release(this.b);
  }

  public void b(Bundle paramBundle)
  {
    this.c.cloudDetailSearch(this.b, paramBundle);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comjni.map.cloud.a
 * JD-Core Version:    0.6.2
 */