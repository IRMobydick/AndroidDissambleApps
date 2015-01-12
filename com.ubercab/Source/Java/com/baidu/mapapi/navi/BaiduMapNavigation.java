package com.baidu.mapapi.navi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import java.net.URISyntaxException;

public class BaiduMapNavigation
{
  private static int a(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 0).versionName;
      if (str != null)
      {
        if (str.length() <= 0)
          return 0;
        int i = Integer.valueOf(str.trim().replace(".", "").trim()).intValue();
        return i;
      }
    }
    catch (Exception localException)
    {
    }
    return 0;
  }

  private static String a(NaviPara paramNaviPara)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("intent://map/direction?");
    localStringBuffer.append("origin=");
    if (paramNaviPara.startName != null)
      localStringBuffer.append("name:" + paramNaviPara.startName + "|");
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Double.valueOf(paramNaviPara.startPoint.latitude);
    arrayOfObject1[1] = Double.valueOf(paramNaviPara.startPoint.longitude);
    localStringBuffer.append(String.format("latlng:%f,%f", arrayOfObject1));
    localStringBuffer.append("&destination=");
    if (paramNaviPara.endName != null)
      localStringBuffer.append("name:" + paramNaviPara.endName + "|");
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Double.valueOf(paramNaviPara.endPoint.latitude);
    arrayOfObject2[1] = Double.valueOf(paramNaviPara.endPoint.longitude);
    localStringBuffer.append(String.format("latlng:%f,%f", arrayOfObject2));
    localStringBuffer.append("&coord_type=bd09ll");
    localStringBuffer.append("&mode=navigation");
    localStringBuffer.append("#Intent;scheme=bdapp;");
    localStringBuffer.append("package=com.baidu.BaiduMap;");
    localStringBuffer.append("end");
    return localStringBuffer.toString();
  }

  private static String b(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager2 = paramContext.getApplicationContext().getPackageManager();
      localPackageManager1 = localPackageManager2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      try
      {
        PackageManager localPackageManager1;
        ApplicationInfo localApplicationInfo2 = localPackageManager1.getApplicationInfo(paramContext.getPackageName(), 0);
        localApplicationInfo1 = localApplicationInfo2;
        while (true)
        {
          return (String)localPackageManager1.getApplicationLabel(localApplicationInfo1);
          localNameNotFoundException1 = localNameNotFoundException1;
          localApplicationInfo1 = null;
          localPackageManager1 = null;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2)
      {
        while (true)
          ApplicationInfo localApplicationInfo1 = null;
      }
    }
  }

  public static void getLatestBaiduMapApp(Context paramContext)
  {
    if (paramContext == null)
      return;
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("http://mo.baidu.com/map/"));
    paramContext.startActivity(localIntent);
  }

  public static void openBaiduMapNavi(NaviPara paramNaviPara, Context paramContext)
  {
    if ((paramNaviPara == null) || (paramContext == null))
      return;
    if ((paramNaviPara.endPoint == null) || (paramNaviPara.startPoint == null))
      throw new IllegalNaviArgumentException("start point or end point can not be null.");
    int i = a(paramContext);
    if (i == 0)
      throw new BaiduMapAppNotSupportNaviException("BaiduMap app is not installed");
    if (i < 500)
      throw new BaiduMapAppNotSupportNaviException("current baidumap app version not support navigation.");
    try
    {
      paramContext.startActivity(Intent.parseUri(a(paramNaviPara), 0));
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      localURISyntaxException.printStackTrace();
    }
  }

  public static void openWebBaiduMapNavi(NaviPara paramNaviPara, Context paramContext)
    throws IllegalNaviArgumentException
  {
    if ((paramNaviPara == null) || (paramContext == null))
      return;
    if ((paramNaviPara.startPoint != null) && (paramNaviPara.endPoint != null))
    {
      b localb1 = a.a(paramNaviPara.startPoint);
      b localb2 = a.a(paramNaviPara.endPoint);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("http://daohang.map.baidu.com/mobile/#navi/naving/start=");
      localStringBuilder2.append(localb1.b());
      localStringBuilder2.append(",");
      localStringBuilder2.append(localb1.a());
      localStringBuilder2.append("&endp=");
      localStringBuilder2.append(localb2.b());
      localStringBuilder2.append(",");
      localStringBuilder2.append(localb2.a());
      localStringBuilder2.append("&fromprod=");
      localStringBuilder2.append(b(paramContext));
      localStringBuilder2.append("/vt=map&state=entry");
      Uri localUri2 = Uri.parse(localStringBuilder2.toString());
      Intent localIntent2 = new Intent();
      localIntent2.setAction("android.intent.action.VIEW");
      localIntent2.setData(localUri2);
      paramContext.startActivity(localIntent2);
      return;
    }
    if ((paramNaviPara.startName != null) && (!paramNaviPara.startName.equals("")) && (paramNaviPara.endName != null) && (!paramNaviPara.endName.equals("")))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("http://daohang.map.baidu.com/mobile/#search/search/qt=nav&sn=2$$$$$$");
      localStringBuilder1.append(paramNaviPara.startName);
      localStringBuilder1.append("$$$$$$&en=2$$$$$$");
      localStringBuilder1.append(paramNaviPara.endName);
      localStringBuilder1.append("$$$$$$&fromprod=");
      localStringBuilder1.append(b(paramContext));
      Uri localUri1 = Uri.parse(localStringBuilder1.toString());
      Intent localIntent1 = new Intent();
      localIntent1.setAction("android.intent.action.VIEW");
      localIntent1.setData(localUri1);
      paramContext.startActivity(localIntent1);
      return;
    }
    throw new IllegalNaviArgumentException("you must set start and end point or set the start and end name.");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.navi.BaiduMapNavigation
 * JD-Core Version:    0.6.2
 */