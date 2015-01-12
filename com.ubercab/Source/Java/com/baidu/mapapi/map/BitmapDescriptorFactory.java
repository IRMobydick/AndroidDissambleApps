package com.baidu.mapapi.map;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.MeasureSpec;
import com.baidu.mapapi.a;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BitmapDescriptorFactory
{
  public static BitmapDescriptor fromAsset(String paramString)
  {
    Context localContext = a.a().d();
    if (localContext == null)
      return null;
    try
    {
      InputStream localInputStream = localContext.getAssets().open(paramString);
      Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
      localInputStream.close();
      BitmapDescriptor localBitmapDescriptor = fromBitmap(localBitmap);
      localBitmap.recycle();
      return localBitmapDescriptor;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      return null;
    return new BitmapDescriptor(paramBitmap);
  }

  public static BitmapDescriptor fromFile(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
      return null;
    try
    {
      Context localContext = a.a().d();
      if (localContext != null)
      {
        FileInputStream localFileInputStream = localContext.openFileInput(paramString);
        Bitmap localBitmap = BitmapFactory.decodeStream(localFileInputStream);
        localFileInputStream.close();
        if (localBitmap != null)
        {
          BitmapDescriptor localBitmapDescriptor = fromBitmap(localBitmap);
          localBitmap.recycle();
          return localBitmapDescriptor;
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return null;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  public static BitmapDescriptor fromPath(String paramString)
  {
    Bitmap localBitmap = BitmapFactory.decodeFile(paramString);
    if ((localBitmap != null) && (localBitmap != null))
    {
      BitmapDescriptor localBitmapDescriptor = fromBitmap(localBitmap);
      localBitmap.recycle();
      return localBitmapDescriptor;
    }
    return null;
  }

  public static BitmapDescriptor fromResource(int paramInt)
  {
    Context localContext = a.a().d();
    Bitmap localBitmap;
    if (localContext != null)
    {
      localBitmap = BitmapFactory.decodeResource(localContext.getResources(), paramInt);
      if (localBitmap != null);
    }
    else
    {
      return null;
    }
    BitmapDescriptor localBitmapDescriptor = fromBitmap(localBitmap);
    localBitmap.recycle();
    return localBitmapDescriptor;
  }

  public static BitmapDescriptor fromView(View paramView)
  {
    if (a.a().d() != null)
    {
      paramView.destroyDrawingCache();
      paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      paramView.setDrawingCacheEnabled(true);
      Bitmap localBitmap = paramView.getDrawingCache(true);
      BitmapDescriptor localBitmapDescriptor = fromBitmap(localBitmap);
      if (localBitmap != null)
        localBitmap.recycle();
      return localBitmapDescriptor;
    }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.BitmapDescriptorFactory
 * JD-Core Version:    0.6.2
 */