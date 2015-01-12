package com.baidu.mapapi.map;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ZoomControls;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.c.c;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.w;
import java.io.IOException;
import java.io.InputStream;

public final class MapView extends ViewGroup
{
  private static final String a = MapView.class.getSimpleName();
  private static final SparseArray<Integer> k = new SparseArray();
  private e b;
  private BaiduMap c;
  private ImageView d;
  private Bitmap e;
  private ZoomControls f;
  private RelativeLayout g;
  private TextView h;
  private TextView i;
  private ImageView j;
  private float l;
  private com.baidu.platform.comapi.map.g m;

  static
  {
    k.append(3, Integer.valueOf(2000000));
    k.append(4, Integer.valueOf(1000000));
    k.append(5, Integer.valueOf(500000));
    k.append(6, Integer.valueOf(200000));
    k.append(7, Integer.valueOf(100000));
    k.append(8, Integer.valueOf(50000));
    k.append(9, Integer.valueOf(25000));
    k.append(10, Integer.valueOf(20000));
    k.append(11, Integer.valueOf(10000));
    k.append(12, Integer.valueOf(5000));
    k.append(13, Integer.valueOf(2000));
    k.append(14, Integer.valueOf(1000));
    k.append(15, Integer.valueOf(500));
    k.append(16, Integer.valueOf(200));
    k.append(17, Integer.valueOf(100));
    k.append(18, Integer.valueOf(50));
    k.append(19, Integer.valueOf(20));
  }

  public MapView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, null);
  }

  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, null);
  }

  public MapView(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
  {
    super(paramContext);
    a(paramContext, paramBaiduMapOptions);
  }

  private void a(Context paramContext)
  {
    try
    {
      AssetManager localAssetManager = paramContext.getAssets();
      if (c.n() >= 180)
      {
        localInputStream = localAssetManager.open("logo_h.png");
      }
      else
      {
        localInputStream = localAssetManager.open("logo_l.png");
        break label97;
        this.e = BitmapFactory.decodeStream(localInputStream);
        localInputStream.close();
        if (this.e == null)
          return;
        this.d = new ImageView(paramContext);
        this.d.setImageBitmap(this.e);
        addView(this.d);
        return;
      }
    }
    catch (Exception localException)
    {
      InputStream localInputStream;
      label97: 
      do
        while (true)
          localException.printStackTrace();
      while (localInputStream != null);
    }
  }

  private void a(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
  {
    com.baidu.mapapi.a.a().b();
    b(paramContext, paramBaiduMapOptions);
    this.c = new BaiduMap(this.b);
    a(paramContext);
    b(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.h))
      this.f.setVisibility(4);
    c(paramContext);
    if ((paramBaiduMapOptions != null) && (!paramBaiduMapOptions.i))
      this.g.setVisibility(4);
  }

  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null)
      localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    int n = localLayoutParams.width;
    int i1;
    int i2;
    if (n > 0)
    {
      i1 = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
      i2 = localLayoutParams.height;
      if (i2 <= 0)
        break label77;
    }
    label77: for (int i3 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824); ; i3 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i1, i3);
      return;
      i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      break;
    }
  }

  private void b()
  {
    float f1 = this.b.m().a;
    ZoomControls localZoomControls1 = this.f;
    boolean bool1;
    ZoomControls localZoomControls2;
    boolean bool3;
    if (f1 <= this.b.b)
    {
      bool1 = false;
      localZoomControls1.setIsZoomOutEnabled(bool1);
      localZoomControls2 = this.f;
      boolean bool2 = f1 < this.b.a;
      bool3 = false;
      if (bool2)
        break label73;
    }
    while (true)
    {
      localZoomControls2.setIsZoomInEnabled(bool3);
      return;
      bool1 = true;
      break;
      label73: bool3 = true;
    }
  }

  private void b(Context paramContext)
  {
    this.f = new ZoomControls(paramContext);
    this.f.setOnZoomOutClickListener(new g(this));
    this.f.setOnZoomInClickListener(new h(this));
    addView(this.f);
  }

  private void b(Context paramContext, BaiduMapOptions paramBaiduMapOptions)
  {
    if (paramBaiduMapOptions == null);
    for (this.b = new e(paramContext, null); ; this.b = new e(paramContext, paramBaiduMapOptions.a()))
    {
      addView(this.b);
      this.m = new f(this);
      this.b.a(this.m);
      return;
    }
  }

  private void c(Context paramContext)
  {
    this.g = new RelativeLayout(paramContext);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -2);
    this.g.setLayoutParams(localLayoutParams);
    this.h = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(14);
    this.h.setTextColor(Color.parseColor("#FFFFFF"));
    this.h.setTextSize(2, 11.0F);
    this.h.setTypeface(this.h.getTypeface(), 1);
    this.h.setLayoutParams(localLayoutParams1);
    this.h.setId(2147483647);
    this.g.addView(this.h);
    this.i = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.width = -2;
    localLayoutParams2.height = -2;
    localLayoutParams2.addRule(14);
    this.i.setTextColor(Color.parseColor("#000000"));
    this.i.setTextSize(2, 11.0F);
    this.i.setLayoutParams(localLayoutParams2);
    this.g.addView(this.i);
    this.j = new ImageView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams3.width = -2;
    localLayoutParams3.height = -2;
    localLayoutParams3.addRule(14);
    localLayoutParams3.addRule(3, this.h.getId());
    this.j.setLayoutParams(localLayoutParams3);
    AssetManager localAssetManager = paramContext.getAssets();
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(localAssetManager.open("icon_scale.9.png"));
      byte[] arrayOfByte = localBitmap.getNinePatchChunk();
      NinePatch.isNinePatchChunk(arrayOfByte);
      NinePatchDrawable localNinePatchDrawable = new NinePatchDrawable(localBitmap, arrayOfByte, new Rect(), null);
      this.j.setBackgroundDrawable(localNinePatchDrawable);
      this.g.addView(this.j);
      addView(this.g);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof MapViewLayoutParams))
      super.addView(paramView, paramLayoutParams);
  }

  public final BaiduMap getMap()
  {
    return this.c;
  }

  public final void onDestroy()
  {
    this.b.l();
    this.e.recycle();
    com.baidu.mapapi.a.a().c();
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int n = getChildCount();
    int i1 = 0;
    if (i1 < n)
    {
      View localView = getChildAt(i1);
      if (localView == this.b)
        this.b.layout(0, 0, getWidth(), getHeight());
      label266: ViewGroup.LayoutParams localLayoutParams;
      do
      {
        while (true)
        {
          i1++;
          break;
          if (localView == this.d)
          {
            a(this.d);
            int i12 = -5 + getHeight();
            int i13 = 5 + this.d.getMeasuredWidth();
            int i14 = i12 - this.d.getMeasuredHeight();
            this.d.layout(5, i14, i13, i12);
          }
          else if (localView == this.f)
          {
            a(this.f);
            int i8 = -5 + getHeight();
            int i9 = -5 + getWidth();
            int i10 = i9 - this.f.getMeasuredWidth();
            int i11 = i8 - this.f.getMeasuredHeight();
            this.f.layout(i10, i11, i9, i8);
          }
          else
          {
            if (localView != this.g)
              break label266;
            a(this.g);
            int i6 = this.g.getMeasuredWidth();
            int i7 = this.g.getMeasuredHeight();
            this.g.layout(5, -56 + (paramInt4 - paramInt2 - i7), i6 + 5, -56 + (paramInt4 - paramInt2));
          }
        }
        localLayoutParams = localView.getLayoutParams();
      }
      while (!(localLayoutParams instanceof MapViewLayoutParams));
      MapViewLayoutParams localMapViewLayoutParams = (MapViewLayoutParams)localLayoutParams;
      if (localMapViewLayoutParams.c == MapViewLayoutParams.ELayoutMode.absoluteMode);
      b localb;
      for (Point localPoint = localMapViewLayoutParams.b; ; localPoint = this.b.a(localb))
      {
        a(localView);
        int i2 = localView.getMeasuredWidth();
        int i3 = localView.getMeasuredHeight();
        float f1 = localMapViewLayoutParams.d;
        float f2 = localMapViewLayoutParams.e;
        int i4 = (int)(localPoint.x - f1 * i2);
        int i5 = (int)(localPoint.y - f2 * i3);
        localView.layout(i4, i5, i4 + i2, i5 + i3);
        break;
        localb = com.baidu.mapapi.model.a.a(localMapViewLayoutParams.a);
      }
    }
  }

  public final void onPause()
  {
    this.b.onPause();
  }

  public final void onResume()
  {
    this.b.onResume();
  }

  public void removeView(View paramView)
  {
    if (paramView == this.d)
      return;
    super.removeView(paramView);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.MapView
 * JD-Core Version:    0.6.2
 */