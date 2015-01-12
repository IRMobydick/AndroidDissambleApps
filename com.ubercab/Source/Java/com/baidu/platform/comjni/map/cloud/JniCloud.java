package com.baidu.platform.comjni.map.cloud;

import android.os.Bundle;

public class JniCloud
{
  public native void cloudDetailSearch(int paramInt, Bundle paramBundle);

  public native void cloudSearch(int paramInt, Bundle paramBundle);

  public native int create();

  public native String getSearchResult(int paramInt1, int paramInt2);

  public native int release(int paramInt);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comjni.map.cloud.JniCloud
 * JD-Core Version:    0.6.2
 */