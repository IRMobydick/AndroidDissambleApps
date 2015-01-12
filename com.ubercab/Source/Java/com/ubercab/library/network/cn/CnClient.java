package com.ubercab.library.network.cn;

import android.os.Build;
import android.os.Build.VERSION;
import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.network.NetworkLog;
import com.ubercab.library.network.NetworkLogger;
import java.util.HashMap;
import java.util.Map;
import retrofit.Callback;

public final class CnClient
{
  private final BuildConfigProxy mBuildConfigProxy;
  private final CnApi mCnApi;
  private final NetworkLogger mNetworkLogger;

  public CnClient(BuildConfigProxy paramBuildConfigProxy, CnApi paramCnApi, NetworkLogger paramNetworkLogger)
  {
    this.mBuildConfigProxy = paramBuildConfigProxy;
    this.mCnApi = paramCnApi;
    this.mNetworkLogger = paramNetworkLogger;
  }

  public void sendLogs(String paramString1, String paramString2, String paramString3, Callback<Void> paramCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("message", this.mNetworkLogger.getNetworkLog().getLogReport());
    localHashMap.put("description", paramString1);
    localHashMap.put("clientID", paramString2);
    localHashMap.put("token", paramString3);
    localHashMap.put("device", "Android");
    localHashMap.put("deviceType", Build.MODEL);
    localHashMap.put("deviceOS", Build.VERSION.RELEASE);
    localHashMap.put("version", this.mBuildConfigProxy.getVersionName());
    this.mCnApi.uploadMobileLogs(localHashMap, paramCallback);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.cn.CnClient
 * JD-Core Version:    0.6.2
 */