package android.support.v4.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.m;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup
{
  static final u a;
  private int b;
  private int c;
  private Drawable d;
  private final int e;
  private boolean f;
  private View g;
  private float h;
  private float i;
  private int j;
  private boolean k;
  private int l;
  private float m;
  private float n;
  private s o;
  private final y p;
  private boolean q;
  private boolean r;
  private final Rect s;
  private final ArrayList t;

  static
  {
    int i1 = Build.VERSION.SDK_INT;
    if (i1 >= 17)
      a = new x();
    while (true)
    {
      return;
      if (i1 >= 16)
      {
        a = new w();
        continue;
      }
      a = new v();
    }
  }

  private void a(float paramFloat)
  {
    int i1 = 0;
    r localr = (r)this.g.getLayoutParams();
    int i2;
    label36: View localView;
    if ((localr.c) && (localr.leftMargin <= 0))
    {
      i2 = 1;
      int i3 = getChildCount();
      if (i1 >= i3)
        return;
      localView = getChildAt(i1);
      if (localView != this.g)
        break label70;
    }
    while (true)
    {
      i1++;
      break label36;
      i2 = 0;
      break;
      label70: int i4 = (int)((1.0F - this.i) * this.l);
      this.i = paramFloat;
      localView.offsetLeftAndRight(i4 - (int)((1.0F - paramFloat) * this.l));
      if (i2 == 0)
        continue;
      a(localView, 1.0F - this.i, this.c);
    }
  }

  private void a(View paramView, float paramFloat, int paramInt)
  {
    r localr = (r)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      int i1 = (int)(paramFloat * ((0xFF000000 & paramInt) >>> 24)) << 24 | 0xFFFFFF & paramInt;
      if (localr.d == null)
        localr.d = new Paint();
      localr.d.setColorFilter(new PorterDuffColorFilter(i1, PorterDuff.Mode.SRC_OVER));
      if (android.support.v4.view.x.c(paramView) != 2)
        android.support.v4.view.x.a(paramView, 2, localr.d);
      d(paramView);
    }
    while (true)
    {
      return;
      if (android.support.v4.view.x.c(paramView) != 0)
      {
        if (localr.d != null)
          localr.d.setColorFilter(null);
        q localq = new q(this, paramView);
        this.t.add(localq);
        android.support.v4.view.x.a(this, localq);
        continue;
      }
    }
  }

  private boolean a(View paramView, int paramInt)
  {
    int i1 = 0;
    if ((this.r) || (a(0.0F, paramInt)))
    {
      this.q = false;
      i1 = 1;
    }
    return i1;
  }

  private boolean b(View paramView, int paramInt)
  {
    boolean bool = true;
    if ((this.r) || (a(1.0F, paramInt)))
      this.q = bool;
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  private static boolean c(View paramView)
  {
    int i1 = 1;
    if (android.support.v4.view.x.e(paramView));
    while (true)
    {
      return i1;
      if (Build.VERSION.SDK_INT >= 18)
      {
        i1 = 0;
        continue;
      }
      Drawable localDrawable = paramView.getBackground();
      if (localDrawable != null)
      {
        if (localDrawable.getOpacity() == -1)
          continue;
        i1 = 0;
        continue;
      }
      i1 = 0;
    }
  }

  private void d(View paramView)
  {
    a.a(this, paramView);
  }

  void a()
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = getChildAt(i2);
      if (localView.getVisibility() != 4)
        continue;
      localView.setVisibility(0);
    }
  }

  void a(View paramView)
  {
    int i1 = getPaddingLeft();
    int i2 = getWidth() - getPaddingRight();
    int i3 = getPaddingTop();
    int i4 = getHeight() - getPaddingBottom();
    int i8;
    int i7;
    int i6;
    int i5;
    if ((paramView != null) && (c(paramView)))
    {
      i8 = paramView.getLeft();
      i7 = paramView.getRight();
      i6 = paramView.getTop();
      i5 = paramView.getBottom();
    }
    int i10;
    View localView;
    while (true)
    {
      int i9 = getChildCount();
      i10 = 0;
      if (i10 < i9)
      {
        localView = getChildAt(i10);
        if (localView != paramView)
          break;
      }
      return;
      i5 = 0;
      i6 = 0;
      i7 = 0;
      i8 = 0;
    }
    int i11 = Math.max(i1, localView.getLeft());
    int i12 = Math.max(i3, localView.getTop());
    int i13 = Math.min(i2, localView.getRight());
    int i14 = Math.min(i4, localView.getBottom());
    if ((i11 >= i8) && (i12 >= i6) && (i13 <= i7) && (i14 <= i5));
    for (int i15 = 4; ; i15 = 0)
    {
      localView.setVisibility(i15);
      i10++;
      break;
    }
  }

  boolean a(float paramFloat, int paramInt)
  {
    int i2;
    if (!this.f)
      i2 = 0;
    while (true)
    {
      return i2;
      r localr = (r)this.g.getLayoutParams();
      int i1 = (int)(getPaddingLeft() + localr.leftMargin + paramFloat * this.j);
      if (this.p.a(this.g, i1, this.g.getTop()))
      {
        a();
        android.support.v4.view.x.b(this);
        i2 = 1;
        continue;
      }
      i2 = 0;
    }
  }

  public boolean b()
  {
    return b(this.g, 0);
  }

  boolean b(View paramView)
  {
    int i1 = 0;
    if (paramView == null)
      return i1;
    r localr = (r)paramView.getLayoutParams();
    if ((this.f) && (localr.c) && (this.h > 0.0F));
    for (int i2 = 1; ; i2 = 0)
    {
      i1 = i2;
      break;
    }
  }

  public boolean c()
  {
    return a(this.g, 0);
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (((paramLayoutParams instanceof r)) && (super.checkLayoutParams(paramLayoutParams)));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void computeScroll()
  {
    if (this.p.a(true))
    {
      if (this.f)
        break label26;
      this.p.f();
    }
    while (true)
    {
      return;
      label26: android.support.v4.view.x.b(this);
    }
  }

  public boolean d()
  {
    if ((!this.f) || (this.h == 1.0F));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    View localView;
    if (getChildCount() > 1)
    {
      localView = getChildAt(1);
      if ((localView != null) && (this.d != null))
        break label36;
    }
    while (true)
    {
      return;
      localView = null;
      break;
      label36: int i1 = this.d.getIntrinsicWidth();
      int i2 = localView.getLeft();
      int i3 = localView.getTop();
      int i4 = localView.getBottom();
      int i5 = i2 - i1;
      this.d.setBounds(i5, i3, i2, i4);
      this.d.draw(paramCanvas);
    }
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    r localr = (r)paramView.getLayoutParams();
    int i1 = paramCanvas.save(2);
    if ((this.f) && (!localr.b) && (this.g != null))
    {
      paramCanvas.getClipBounds(this.s);
      this.s.right = Math.min(this.s.right, this.g.getLeft());
      paramCanvas.clipRect(this.s);
    }
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11)
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    while (true)
    {
      paramCanvas.restoreToCount(i1);
      return bool;
      if ((localr.c) && (this.h > 0.0F))
      {
        if (!paramView.isDrawingCacheEnabled())
          paramView.setDrawingCacheEnabled(true);
        Bitmap localBitmap = paramView.getDrawingCache();
        if (localBitmap != null)
        {
          paramCanvas.drawBitmap(localBitmap, paramView.getLeft(), paramView.getTop(), localr.d);
          bool = false;
          continue;
        }
        Log.e("SlidingPaneLayout", "drawChild: child view " + paramView + " returned null drawing cache");
        bool = super.drawChild(paramCanvas, paramView, paramLong);
        continue;
      }
      if (paramView.isDrawingCacheEnabled())
        paramView.setDrawingCacheEnabled(false);
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
  }

  public boolean e()
  {
    return this.f;
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new r();
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new r(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams));
    for (r localr = new r((ViewGroup.MarginLayoutParams)paramLayoutParams); ; localr = new r(paramLayoutParams))
      return localr;
  }

  public int getCoveredFadeColor()
  {
    return this.c;
  }

  public int getParallaxDistance()
  {
    return this.l;
  }

  public int getSliderFadeColor()
  {
    return this.b;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.r = true;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.r = true;
    int i1 = this.t.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((q)this.t.get(i2)).run();
    this.t.clear();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i1 = m.a(paramMotionEvent);
    boolean bool2;
    if ((!this.f) && (i1 == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null)
      {
        if (this.p.b(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
          break label102;
        bool2 = true;
        this.q = bool2;
      }
    }
    if ((!this.f) || ((this.k) && (i1 != 0)))
    {
      this.p.e();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    while (true)
    {
      return bool1;
      label102: bool2 = false;
      break;
      if ((i1 == 3) || (i1 == 1))
      {
        this.p.e();
        continue;
      }
      switch (i1)
      {
      case 1:
      default:
      case 0:
      case 2:
      }
      label156: float f3;
      float f4;
      do
      {
        for (int i2 = 0; (this.p.a(paramMotionEvent)) || (i2 != 0); i2 = 1)
        {
          bool1 = true;
          break;
          this.k = false;
          float f5 = paramMotionEvent.getX();
          float f6 = paramMotionEvent.getY();
          this.m = f5;
          this.n = f6;
          if ((!this.p.b(this.g, (int)f5, (int)f6)) || (!b(this.g)))
            break label156;
        }
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        f3 = Math.abs(f1 - this.m);
        f4 = Math.abs(f2 - this.n);
      }
      while ((f3 <= this.p.d()) || (f4 <= f3));
      this.p.e();
      this.k = true;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    int i2 = getPaddingLeft();
    int i3 = getPaddingRight();
    int i4 = getPaddingTop();
    int i5 = getChildCount();
    float f1;
    if (this.r)
    {
      if ((!this.f) || (!this.q))
        break label106;
      f1 = 1.0F;
    }
    while (true)
    {
      this.h = f1;
      int i6 = 0;
      int i7 = i2;
      View localView;
      int i11;
      while (true)
      {
        if (i6 >= i5)
          break label330;
        localView = getChildAt(i6);
        if (localView.getVisibility() == 8)
        {
          i11 = i7;
          i6++;
          i7 = i11;
          continue;
          label106: f1 = 0.0F;
          break;
        }
      }
      r localr = (r)localView.getLayoutParams();
      int i9 = localView.getMeasuredWidth();
      boolean bool;
      label206: int i10;
      if (localr.b)
      {
        int i13 = localr.leftMargin + localr.rightMargin;
        int i14 = Math.min(i2, i1 - i3 - this.e) - i7 - i13;
        this.j = i14;
        if (i14 + (i7 + localr.leftMargin) + i9 / 2 > i1 - i3)
        {
          bool = true;
          localr.c = bool;
          i11 = i7 + ((int)(i14 * this.h) + localr.leftMargin);
          i10 = 0;
        }
      }
      while (true)
      {
        int i12 = i11 - i10;
        localView.layout(i12, i4, i12 + i9, i4 + localView.getMeasuredHeight());
        i2 += localView.getWidth();
        break;
        bool = false;
        break label206;
        if ((this.f) && (this.l != 0))
        {
          i10 = (int)((1.0F - this.h) * this.l);
          i11 = i2;
          continue;
        }
        i10 = 0;
        i11 = i2;
      }
    }
    label330: if (this.r)
    {
      if (!this.f)
        break label405;
      if (this.l != 0)
        a(this.h);
      if (((r)this.g.getLayoutParams()).c)
        a(this.g, this.h, this.b);
    }
    while (true)
    {
      a(this.g);
      this.r = false;
      return;
      label405: for (int i8 = 0; i8 < i5; i8++)
        a(getChildAt(i8), 0.0F, this.b);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i5;
    int i6;
    int i7;
    if (i1 != 1073741824)
      if (isInEditMode())
        if (i1 == -2147483648)
        {
          i5 = i3;
          i6 = i2;
          i7 = i4;
        }
    while (true)
    {
      int i9;
      int i10;
      label91: boolean bool1;
      int i11;
      int i12;
      int i13;
      int i14;
      float f1;
      label145: View localView2;
      r localr2;
      int i30;
      float f3;
      int i31;
      switch (i5)
      {
      default:
        i9 = 0;
        i10 = -1;
        bool1 = false;
        i11 = i6 - getPaddingLeft() - getPaddingRight();
        i12 = getChildCount();
        if (i12 > 2)
          Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        this.g = null;
        i13 = 0;
        i14 = i9;
        f1 = 0.0F;
        if (i13 >= i12)
          break label648;
        localView2 = getChildAt(i13);
        localr2 = (r)localView2.getLayoutParams();
        if (localView2.getVisibility() != 8)
          break;
        localr2.c = false;
        i30 = i11;
        f3 = f1;
        i31 = i14;
      case 1073741824:
      case -2147483648:
      }
      for (boolean bool4 = bool1; ; bool4 = bool1)
      {
        i13++;
        bool1 = bool4;
        i14 = i31;
        f1 = f3;
        i11 = i30;
        break label145;
        if (i1 != 0)
          break label1125;
        i5 = i3;
        i6 = 300;
        i7 = i4;
        break;
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        if (i3 != 0)
          break label1125;
        if (isInEditMode())
        {
          if (i3 != 0)
            break label1125;
          i5 = -2147483648;
          i6 = i2;
          i7 = 300;
          break;
        }
        throw new IllegalStateException("Height must not be UNSPECIFIED");
        i9 = i7 - getPaddingTop() - getPaddingBottom();
        i10 = i9;
        break label91;
        int i8 = i7 - getPaddingTop() - getPaddingBottom();
        i9 = 0;
        i10 = i8;
        break label91;
        if (localr2.a <= 0.0F)
          break label392;
        f1 += localr2.a;
        if (localr2.width != 0)
          break label392;
        i30 = i11;
        f3 = f1;
        i31 = i14;
      }
      label392: int i24 = localr2.leftMargin + localr2.rightMargin;
      int i25;
      label428: int i26;
      label448: int i29;
      if (localr2.width == -2)
      {
        i25 = View.MeasureSpec.makeMeasureSpec(i6 - i24, -2147483648);
        if (localr2.height != -2)
          break label603;
        i26 = View.MeasureSpec.makeMeasureSpec(i10, -2147483648);
        localView2.measure(i25, i26);
        int i27 = localView2.getMeasuredWidth();
        int i28 = localView2.getMeasuredHeight();
        if ((i5 == -2147483648) && (i28 > i14))
          i14 = Math.min(i28, i10);
        i29 = i11 - i27;
        if (i29 >= 0)
          break label642;
      }
      label642: for (boolean bool2 = true; ; bool2 = false)
      {
        localr2.b = bool2;
        boolean bool3 = bool2 | bool1;
        if (localr2.b)
          this.g = localView2;
        i30 = i29;
        i31 = i14;
        float f2 = f1;
        bool4 = bool3;
        f3 = f2;
        break;
        if (localr2.width == -1)
        {
          i25 = View.MeasureSpec.makeMeasureSpec(i6 - i24, 1073741824);
          break label428;
        }
        i25 = View.MeasureSpec.makeMeasureSpec(localr2.width, 1073741824);
        break label428;
        label603: if (localr2.height == -1)
        {
          i26 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
          break label448;
        }
        i26 = View.MeasureSpec.makeMeasureSpec(localr2.height, 1073741824);
        break label448;
      }
      label648: if ((bool1) || (f1 > 0.0F))
      {
        int i15 = i6 - this.e;
        int i16 = 0;
        if (i16 < i12)
        {
          View localView1 = getChildAt(i16);
          if (localView1.getVisibility() == 8);
          while (true)
          {
            i16++;
            break;
            r localr1 = (r)localView1.getLayoutParams();
            if (localView1.getVisibility() == 8)
              continue;
            int i17;
            label744: int i18;
            label752: int i23;
            if ((localr1.width == 0) && (localr1.a > 0.0F))
            {
              i17 = 1;
              if (i17 == 0)
                break label840;
              i18 = 0;
              if ((!bool1) || (localView1 == this.g))
                break label905;
              if ((localr1.width >= 0) || ((i18 <= i15) && (localr1.a <= 0.0F)))
                continue;
              if (i17 == 0)
                break label889;
              if (localr1.height != -2)
                break label850;
              i23 = View.MeasureSpec.makeMeasureSpec(i10, -2147483648);
            }
            while (true)
            {
              localView1.measure(View.MeasureSpec.makeMeasureSpec(i15, 1073741824), i23);
              break;
              i17 = 0;
              break label744;
              label840: i18 = localView1.getMeasuredWidth();
              break label752;
              label850: if (localr1.height == -1)
              {
                i23 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                continue;
              }
              i23 = View.MeasureSpec.makeMeasureSpec(localr1.height, 1073741824);
              continue;
              label889: i23 = View.MeasureSpec.makeMeasureSpec(localView1.getMeasuredHeight(), 1073741824);
            }
            label905: if (localr1.a <= 0.0F)
              continue;
            int i19;
            if (localr1.width == 0)
              if (localr1.height == -2)
                i19 = View.MeasureSpec.makeMeasureSpec(i10, -2147483648);
            while (true)
            {
              if (!bool1)
                break label1048;
              int i21 = i6 - (localr1.leftMargin + localr1.rightMargin);
              int i22 = View.MeasureSpec.makeMeasureSpec(i21, 1073741824);
              if (i18 == i21)
                break;
              localView1.measure(i22, i19);
              break;
              if (localr1.height == -1)
              {
                i19 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                continue;
              }
              i19 = View.MeasureSpec.makeMeasureSpec(localr1.height, 1073741824);
              continue;
              i19 = View.MeasureSpec.makeMeasureSpec(localView1.getMeasuredHeight(), 1073741824);
            }
            label1048: int i20 = Math.max(0, i11);
            localView1.measure(View.MeasureSpec.makeMeasureSpec(i18 + (int)(localr1.a * i20 / f1), 1073741824), i19);
          }
        }
      }
      setMeasuredDimension(i6, i14);
      this.f = bool1;
      if ((this.p.a() != 0) && (!bool1))
        this.p.f();
      return;
      label1125: i5 = i3;
      i6 = i2;
      i7 = i4;
    }
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SlidingPaneLayout.SavedState localSavedState = (SlidingPaneLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.a)
      b();
    while (true)
    {
      this.q = localSavedState.a;
      return;
      c();
    }
  }

  protected Parcelable onSaveInstanceState()
  {
    SlidingPaneLayout.SavedState localSavedState = new SlidingPaneLayout.SavedState(super.onSaveInstanceState());
    if (e());
    for (boolean bool = d(); ; bool = this.q)
    {
      localSavedState.a = bool;
      return localSavedState;
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      this.r = true;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (!this.f)
      bool = super.onTouchEvent(paramMotionEvent);
    while (true)
    {
      return bool;
      this.p.b(paramMotionEvent);
      int i1 = paramMotionEvent.getAction();
      bool = true;
      switch (i1 & 0xFF)
      {
      default:
        break;
      case 0:
        float f5 = paramMotionEvent.getX();
        float f6 = paramMotionEvent.getY();
        this.m = f5;
        this.n = f6;
        break;
      case 1:
        if (!b(this.g))
          continue;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        float f3 = f1 - this.m;
        float f4 = f2 - this.n;
        int i2 = this.p.d();
        if ((f3 * f3 + f4 * f4 >= i2 * i2) || (!this.p.b(this.g, (int)f1, (int)f2)))
          continue;
        a(this.g, 0);
      }
    }
  }

  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.f))
      if (paramView1 != this.g)
        break label36;
    label36: for (boolean bool = true; ; bool = false)
    {
      this.q = bool;
      return;
    }
  }

  public void setCoveredFadeColor(int paramInt)
  {
    this.c = paramInt;
  }

  public void setPanelSlideListener(s params)
  {
    this.o = params;
  }

  public void setParallaxDistance(int paramInt)
  {
    this.l = paramInt;
    requestLayout();
  }

  public void setShadowDrawable(Drawable paramDrawable)
  {
    this.d = paramDrawable;
  }

  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }

  public void setSliderFadeColor(int paramInt)
  {
    this.b = paramInt;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout
 * JD-Core Version:    0.6.0
 */