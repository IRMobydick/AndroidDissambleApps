package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static List<JNIBaseMap> d = new ArrayList();
  private int b = 0;
  private JNIBaseMap c = null;

  public static int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return JNIBaseMap.MapProc(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public int a(int paramInt)
  {
    return this.c.SetMapControlMode(this.b, paramInt);
  }

  public int a(int paramInt1, int paramInt2, String paramString)
  {
    return this.c.AddLayer(this.b, paramInt1, paramInt2, paramString);
  }

  public String a(int paramInt1, int paramInt2)
  {
    return this.c.ScrPtToGeoPoint(this.b, paramInt1, paramInt2);
  }

  public String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return this.c.GetNearlyObjID(this.b, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    this.c.ShowLayers(this.b, paramInt, paramBoolean);
  }

  public void a(Bundle paramBundle)
  {
    this.c.SetMapStatus(this.b, paramBundle);
  }

  public void a(String paramString)
  {
    this.c.SaveScreenToLocal(this.b, paramString);
  }

  public void a(boolean paramBoolean)
  {
    this.c.ShowSatelliteMap(this.b, paramBoolean);
  }

  public boolean a()
  {
    if (d.size() == 0);
    for (this.b = this.c.Create(); ; this.b = this.c.CreateDuplicate(((JNIBaseMap)d.get(0)).a))
    {
      this.c.a = this.b;
      d.add(this.c);
      this.c.SetCallback(this.b, null);
      return true;
    }
  }

  public boolean a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return this.c.OnRecordStart(this.b, paramInt1, paramBoolean, paramInt2);
  }

  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    return this.c.Init(this.b, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }

  public int[] a(int[] paramArrayOfInt)
  {
    return this.c.GetScreenBuf(this.b, paramArrayOfInt);
  }

  public float b(Bundle paramBundle)
  {
    return this.c.GetZoomToBound(this.b, paramBundle);
  }

  public String b(int paramInt1, int paramInt2)
  {
    return this.c.GeoPtToScrPoint(this.b, paramInt1, paramInt2);
  }

  public String b(String paramString)
  {
    return this.c.OnSchcityGet(this.b, paramString);
  }

  public void b(int paramInt)
  {
    this.c.UpdateLayers(this.b, paramInt);
  }

  public void b(boolean paramBoolean)
  {
    this.c.ShowTrafficMap(this.b, paramBoolean);
  }

  public boolean b()
  {
    this.c.Release(this.b);
    d.remove(this.c);
    return true;
  }

  public boolean b(int paramInt, boolean paramBoolean)
  {
    return this.c.OnRecordRemove(this.b, paramInt, paramBoolean);
  }

  public boolean b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return this.c.OnRecordSuspend(this.b, paramInt1, paramBoolean, paramInt2);
  }

  public int c()
  {
    return this.b;
  }

  public void c(int paramInt)
  {
    this.c.ClearLayer(this.b, paramInt);
  }

  public void c(Bundle paramBundle)
  {
    this.c.addOneOverlayItem(this.b, paramBundle);
  }

  public boolean c(boolean paramBoolean)
  {
    return this.c.OnRecordImport(this.b, paramBoolean);
  }

  public void d()
  {
    this.c.OnPause(this.b);
  }

  public void d(Bundle paramBundle)
  {
    this.c.updateOneOverlayItem(this.b, paramBundle);
  }

  public void d(boolean paramBoolean)
  {
    this.c.enableDrawHouseHeight(this.b, paramBoolean);
  }

  public boolean d(int paramInt)
  {
    return this.c.OnRecordAdd(this.b, paramInt);
  }

  public String e(int paramInt)
  {
    return this.c.OnRecordGetAt(this.b, paramInt);
  }

  public void e()
  {
    this.c.OnResume(this.b);
  }

  public void e(Bundle paramBundle)
  {
    this.c.removeOneOverlayItem(this.b, paramBundle);
  }

  public void f()
  {
    this.c.ResetImageRes(this.b);
  }

  public Bundle g()
  {
    return this.c.GetMapStatus(this.b);
  }

  public String h()
  {
    return this.c.OnRecordGetAll(this.b);
  }

  public String i()
  {
    return this.c.OnHotcityGet(this.b);
  }

  public void j()
  {
    this.c.PostStatInfo(this.b);
  }

  public boolean k()
  {
    return this.c.isDrawHouseHeightEnable(this.b);
  }

  public void l()
  {
    this.c.clearHeatMapLayerCache(this.b);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comjni.map.basemap.a
 * JD-Core Version:    0.6.2
 */