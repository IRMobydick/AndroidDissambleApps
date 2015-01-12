package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;

public class JNIBaseMap
{
  int a;

  public static native int MapProc(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public native int AddLayer(int paramInt1, int paramInt2, int paramInt3, String paramString);

  public native void ClearLayer(int paramInt1, int paramInt2);

  public native int Create();

  public native int CreateDuplicate(int paramInt);

  public native String GeoPtToScrPoint(int paramInt1, int paramInt2, int paramInt3);

  public native Bundle GetMapStatus(int paramInt);

  public native String GetNearlyObjID(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);

  public native int[] GetScreenBuf(int paramInt, int[] paramArrayOfInt);

  public native float GetZoomToBound(int paramInt, Bundle paramBundle);

  public native boolean Init(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);

  public native String OnHotcityGet(int paramInt);

  public native void OnPause(int paramInt);

  public native boolean OnRecordAdd(int paramInt1, int paramInt2);

  public native String OnRecordGetAll(int paramInt);

  public native String OnRecordGetAt(int paramInt1, int paramInt2);

  public native boolean OnRecordImport(int paramInt, boolean paramBoolean);

  public native boolean OnRecordRemove(int paramInt1, int paramInt2, boolean paramBoolean);

  public native boolean OnRecordStart(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);

  public native boolean OnRecordSuspend(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);

  public native void OnResume(int paramInt);

  public native String OnSchcityGet(int paramInt, String paramString);

  public native void PostStatInfo(int paramInt);

  public native int Release(int paramInt);

  public native void ResetImageRes(int paramInt);

  public native void SaveScreenToLocal(int paramInt, String paramString);

  public native String ScrPtToGeoPoint(int paramInt1, int paramInt2, int paramInt3);

  public native int SetCallback(int paramInt, BaseMapCallback paramBaseMapCallback);

  public native int SetMapControlMode(int paramInt1, int paramInt2);

  public native void SetMapStatus(int paramInt, Bundle paramBundle);

  public native void ShowLayers(int paramInt1, int paramInt2, boolean paramBoolean);

  public native void ShowSatelliteMap(int paramInt, boolean paramBoolean);

  public native void ShowTrafficMap(int paramInt, boolean paramBoolean);

  public native void UpdateLayers(int paramInt1, int paramInt2);

  public native void addOneOverlayItem(int paramInt, Bundle paramBundle);

  public native void clearHeatMapLayerCache(int paramInt);

  public native void enableDrawHouseHeight(int paramInt, boolean paramBoolean);

  public native boolean isDrawHouseHeightEnable(int paramInt);

  public native void removeOneOverlayItem(int paramInt, Bundle paramBundle);

  public native void updateOneOverlayItem(int paramInt, Bundle paramBundle);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comjni.map.basemap.JNIBaseMap
 * JD-Core Version:    0.6.2
 */