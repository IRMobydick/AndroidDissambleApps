package com.baidu.platform.comjni.map.commonmemcache;

import android.os.Bundle;

public class JNICommonMemCache
{
  public native int Create();

  public native void Init(int paramInt, Bundle paramBundle);

  public native int Release(int paramInt);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comjni.map.commonmemcache.JNICommonMemCache
 * JD-Core Version:    0.6.2
 */