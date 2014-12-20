package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.widget.e;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager extends ViewGroup
{
  private static final int[] a;
  private static final aw af;
  private static final Comparator c;
  private static final Interpolator d;
  private boolean A;
  private boolean B;
  private int C;
  private int D;
  private int E;
  private float F;
  private float G;
  private float H;
  private float I;
  private int J;
  private VelocityTracker K;
  private int L;
  private int M;
  private int N;
  private int O;
  private boolean P;
  private e Q;
  private e R;
  private boolean S;
  private boolean T;
  private boolean U;
  private int V;
  private as W;
  private as Z;
  private ar aa;
  private at ab;
  private Method ac;
  private int ad;
  private ArrayList ae;
  private final Runnable ag;
  private int ah;
  private int b;
  private final ArrayList e;
  private final ap f;
  private final Rect g;
  private r h;
  private int i;
  private int j;
  private Parcelable k;
  private ClassLoader l;
  private Scroller m;
  private au n;
  private int o;
  private Drawable p;
  private int q;
  private int r;
  private float s;
  private float t;
  private int u;
  private int v;
  private boolean w;
  private boolean x;
  private boolean y;
  private int z;

  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16842931;
    a = arrayOfInt;
    c = new am();
    d = new an();
    af = new aw();
  }

  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.N) && (Math.abs(paramInt2) > this.L))
    {
      if (paramInt2 > 0);
      while (true)
      {
        if (this.e.size() > 0)
        {
          ap localap1 = (ap)this.e.get(0);
          ap localap2 = (ap)this.e.get(-1 + this.e.size());
          paramInt1 = Math.max(localap1.b, Math.min(paramInt1, localap2.b));
        }
        return paramInt1;
        paramInt1++;
      }
    }
    float f1;
    if (paramInt1 >= this.i)
      f1 = 0.4F;
    while (true)
    {
      paramInt1 = (int)(f1 + (paramFloat + paramInt1));
      break;
      f1 = 0.6F;
    }
  }

  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null);
    for (Rect localRect1 = new Rect(); ; localRect1 = paramRect)
    {
      if (paramView == null)
        localRect1.set(0, 0, 0, 0);
      for (Rect localRect2 = localRect1; ; localRect2 = localRect1)
      {
        return localRect2;
        localRect1.left = paramView.getLeft();
        localRect1.right = paramView.getRight();
        localRect1.top = paramView.getTop();
        localRect1.bottom = paramView.getBottom();
        ViewGroup localViewGroup;
        for (ViewParent localViewParent = paramView.getParent(); ((localViewParent instanceof ViewGroup)) && (localViewParent != this); localViewParent = localViewGroup.getParent())
        {
          localViewGroup = (ViewGroup)localViewParent;
          localRect1.left += localViewGroup.getLeft();
          localRect1.right += localViewGroup.getRight();
          localRect1.top += localViewGroup.getTop();
          localRect1.bottom += localViewGroup.getBottom();
        }
      }
    }
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.e.isEmpty()))
    {
      int i2 = paramInt3 + (paramInt1 - getPaddingLeft() - getPaddingRight());
      int i3 = paramInt4 + (paramInt2 - getPaddingLeft() - getPaddingRight());
      int i4 = (int)(getScrollX() / i3 * i2);
      scrollTo(i4, getScrollY());
      if (!this.m.isFinished())
      {
        int i5 = this.m.getDuration() - this.m.timePassed();
        ap localap2 = b(this.i);
        this.m.startScroll(i4, 0, (int)(localap2.e * paramInt1), 0, i5);
      }
      return;
    }
    ap localap1 = b(this.i);
    float f1;
    if (localap1 != null)
      f1 = Math.min(localap1.e, this.t);
    while (true)
    {
      int i1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (i1 == getScrollX())
        break;
      a(false);
      scrollTo(i1, getScrollY());
      break;
      f1 = 0.0F;
    }
  }

  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    ap localap = b(paramInt1);
    if (localap != null);
    for (int i1 = (int)(getClientWidth() * Math.max(this.s, Math.min(localap.e, this.t))); ; i1 = 0)
    {
      if (paramBoolean1)
      {
        a(i1, 0, paramInt2);
        if ((paramBoolean2) && (this.W != null))
          this.W.a(paramInt1);
        if ((paramBoolean2) && (this.Z != null))
          this.Z.a(paramInt1);
      }
      while (true)
      {
        return;
        if ((paramBoolean2) && (this.W != null))
          this.W.a(paramInt1);
        if ((paramBoolean2) && (this.Z != null))
          this.Z.a(paramInt1);
        a(false);
        scrollTo(i1, 0);
        d(i1);
      }
    }
  }

  private void a(ap paramap1, int paramInt, ap paramap2)
  {
    int i1 = this.h.a();
    int i2 = getClientWidth();
    float f1;
    int i12;
    float f9;
    int i15;
    int i16;
    if (i2 > 0)
    {
      f1 = this.o / i2;
      if (paramap2 == null)
        break label373;
      i12 = paramap2.b;
      if (i12 < paramap1.b)
      {
        f9 = f1 + (paramap2.e + paramap2.d);
        i15 = i12 + 1;
        i16 = 0;
      }
    }
    else
    {
      while (true)
      {
        if ((i15 > paramap1.b) || (i16 >= this.e.size()))
          break label373;
        ap localap4 = (ap)this.e.get(i16);
        while (true)
          if ((i15 > localap4.b) && (i16 < -1 + this.e.size()))
          {
            i16++;
            localap4 = (ap)this.e.get(i16);
            continue;
            f1 = 0.0F;
            break;
          }
        while (i15 < localap4.b)
        {
          f9 += f1 + this.h.a(i15);
          i15++;
        }
        localap4.e = f9;
        f9 += f1 + localap4.d;
        i15++;
      }
    }
    if (i12 > paramap1.b)
    {
      int i13 = -1 + this.e.size();
      float f8 = paramap2.e;
      for (int i14 = i12 - 1; (i14 >= paramap1.b) && (i13 >= 0); i14--)
      {
        for (ap localap3 = (ap)this.e.get(i13); (i14 < localap3.b) && (i13 > 0); localap3 = (ap)this.e.get(i13))
          i13--;
        while (i14 > localap3.b)
        {
          f8 -= f1 + this.h.a(i14);
          i14--;
        }
        f8 -= f1 + localap3.d;
        localap3.e = f8;
      }
    }
    label373: int i3 = this.e.size();
    float f2 = paramap1.e;
    int i4 = -1 + paramap1.b;
    float f3;
    float f4;
    if (paramap1.b == 0)
    {
      f3 = paramap1.e;
      this.s = f3;
      if (paramap1.b != i1 - 1)
        break label526;
      f4 = paramap1.e + paramap1.d - 1.0F;
      label440: this.t = f4;
    }
    label526: int i10;
    for (int i5 = paramInt - 1; ; i5 = i10)
    {
      if (i5 < 0)
        break label584;
      ap localap2 = (ap)this.e.get(i5);
      float f7 = f2;
      while (true)
        if (i4 > localap2.b)
        {
          r localr2 = this.h;
          int i11 = i4 - 1;
          f7 -= f1 + localr2.a(i4);
          i4 = i11;
          continue;
          f3 = -3.402824E+038F;
          break;
          f4 = 3.4028235E+38F;
          break label440;
        }
      f2 = f7 - (f1 + localap2.d);
      localap2.e = f2;
      if (localap2.b == 0)
        this.s = f2;
      i10 = i5 - 1;
      i4--;
    }
    label584: float f5 = f1 + (paramap1.e + paramap1.d);
    int i6 = 1 + paramap1.b;
    int i8;
    for (int i7 = paramInt + 1; i7 < i3; i7 = i8)
    {
      ap localap1 = (ap)this.e.get(i7);
      float f6 = f5;
      while (i6 < localap1.b)
      {
        r localr1 = this.h;
        int i9 = i6 + 1;
        f6 += f1 + localr1.a(i6);
        i6 = i9;
      }
      if (localap1.b == i1 - 1)
        this.t = (f6 + localap1.d - 1.0F);
      localap1.e = f6;
      f5 = f6 + (f1 + localap1.d);
      i8 = i7 + 1;
      i6++;
    }
    this.T = false;
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = m.b(paramMotionEvent);
    if (m.b(paramMotionEvent, i1) == this.J)
      if (i1 != 0)
        break label56;
    label56: for (int i2 = 1; ; i2 = 0)
    {
      this.F = m.c(paramMotionEvent, i2);
      this.J = m.b(paramMotionEvent, i2);
      if (this.K != null)
        this.K.clear();
      return;
    }
  }

  private void a(boolean paramBoolean)
  {
    if (this.ah == 2);
    int i3;
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
      {
        setScrollingCacheEnabled(false);
        this.m.abortAnimation();
        int i4 = getScrollX();
        int i5 = getScrollY();
        int i6 = this.m.getCurrX();
        int i7 = this.m.getCurrY();
        if ((i4 != i6) || (i5 != i7))
          scrollTo(i6, i7);
      }
      this.y = false;
      int i2 = 0;
      i3 = i1;
      while (i2 < this.e.size())
      {
        ap localap = (ap)this.e.get(i2);
        if (localap.c)
        {
          localap.c = false;
          i3 = 1;
        }
        i2++;
      }
    }
    if (i3 != 0)
    {
      if (!paramBoolean)
        break label158;
      x.a(this, this.ag);
    }
    while (true)
    {
      return;
      label158: this.ag.run();
    }
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    if (((paramFloat1 < this.D) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.D) && (paramFloat2 < 0.0F)));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private void b(boolean paramBoolean)
  {
    int i1 = getChildCount();
    int i2 = 0;
    if (i2 < i1)
    {
      if (paramBoolean);
      for (int i3 = 2; ; i3 = 0)
      {
        x.a(getChildAt(i2), i3, null);
        i2++;
        break;
      }
    }
  }

  private boolean b(float paramFloat)
  {
    int i1 = 1;
    boolean bool = false;
    float f1 = this.F - paramFloat;
    this.F = paramFloat;
    float f2 = f1 + getScrollX();
    int i2 = getClientWidth();
    float f3 = i2 * this.s;
    float f4 = i2 * this.t;
    ap localap1 = (ap)this.e.get(0);
    ap localap2 = (ap)this.e.get(-1 + this.e.size());
    if (localap1.b != 0)
      f3 = localap1.e * i2;
    for (int i3 = 0; ; i3 = i1)
    {
      float f5;
      if (localap2.b != -1 + this.h.a())
      {
        f5 = localap2.e * i2;
        i1 = 0;
      }
      while (true)
      {
        if (f2 < f3)
          if (i3 != 0)
          {
            float f7 = f3 - f2;
            bool = this.Q.a(Math.abs(f7) / i2);
          }
        while (true)
        {
          this.F += f3 - (int)f3;
          scrollTo((int)f3, getScrollY());
          d((int)f3);
          return bool;
          if (f2 > f5)
          {
            if (i1 != 0)
            {
              float f6 = f2 - f5;
              bool = this.R.a(Math.abs(f6) / i2);
            }
            f3 = f5;
            continue;
          }
          f3 = f2;
        }
        f5 = f4;
      }
    }
  }

  private boolean d(int paramInt)
  {
    int i1 = 0;
    if (this.e.size() == 0)
    {
      this.U = false;
      a(0, 0.0F, 0);
      if (!this.U)
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    else
    {
      ap localap = h();
      int i2 = getClientWidth();
      int i3 = i2 + this.o;
      float f1 = this.o / i2;
      int i4 = localap.b;
      float f2 = (paramInt / i2 - localap.e) / (f1 + localap.d);
      int i5 = (int)(f2 * i3);
      this.U = false;
      a(i4, f2, i5);
      if (!this.U)
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      i1 = 1;
    }
    return i1;
  }

  private void f()
  {
    for (int i1 = 0; i1 < getChildCount(); i1++)
    {
      if (((aq)getChildAt(i1).getLayoutParams()).a)
        continue;
      removeViewAt(i1);
      i1--;
    }
  }

  private void g()
  {
    if (this.ad != 0)
    {
      if (this.ae == null)
        this.ae = new ArrayList();
      while (true)
      {
        int i1 = getChildCount();
        for (int i2 = 0; i2 < i1; i2++)
        {
          View localView = getChildAt(i2);
          this.ae.add(localView);
        }
        this.ae.clear();
      }
      Collections.sort(this.ae, af);
    }
  }

  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }

  private ap h()
  {
    int i1 = getClientWidth();
    float f1;
    float f2;
    label31: float f3;
    float f4;
    int i2;
    int i3;
    int i4;
    Object localObject;
    label50: ap localap1;
    ap localap3;
    int i5;
    if (i1 > 0)
    {
      f1 = getScrollX() / i1;
      if (i1 <= 0)
        break label212;
      f2 = this.o / i1;
      f3 = 0.0F;
      f4 = 0.0F;
      i2 = -1;
      i3 = 0;
      i4 = 1;
      localObject = null;
      if (i3 < this.e.size())
      {
        localap1 = (ap)this.e.get(i3);
        if ((i4 != 0) || (localap1.b == i2 + 1))
          break label263;
        localap3 = this.f;
        localap3.e = (f2 + (f3 + f4));
        localap3.b = (i2 + 1);
        localap3.d = this.h.a(localap3.b);
        i5 = i3 - 1;
      }
    }
    for (ap localap2 = localap3; ; localap2 = localap1)
    {
      float f5 = localap2.e;
      float f6 = f2 + (f5 + localap2.d);
      if ((i4 != 0) || (f1 >= f5))
      {
        if ((f1 < f6) || (i5 == -1 + this.e.size()))
          localObject = localap2;
      }
      else
      {
        return localObject;
        f1 = 0.0F;
        break;
        label212: f2 = 0.0F;
        break label31;
      }
      int i6 = localap2.b;
      float f7 = localap2.d;
      int i7 = i5 + 1;
      f4 = f5;
      i2 = i6;
      i4 = 0;
      f3 = f7;
      localObject = localap2;
      i3 = i7;
      break label50;
      label263: i5 = i3;
    }
  }

  private void i()
  {
    this.A = false;
    this.B = false;
    if (this.K != null)
    {
      this.K.recycle();
      this.K = null;
    }
  }

  private void setScrollState(int paramInt)
  {
    if (this.ah == paramInt)
      return;
    this.ah = paramInt;
    if (this.ab != null)
      if (paramInt == 0)
        break label52;
    label52: for (boolean bool = true; ; bool = false)
    {
      b(bool);
      if (this.W == null)
        break;
      this.W.b(paramInt);
      break;
    }
  }

  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.x != paramBoolean)
      this.x = paramBoolean;
  }

  float a(float paramFloat)
  {
    return (float)Math.sin((float)(0.47123891676382D * (paramFloat - 0.5F)));
  }

  ap a(int paramInt1, int paramInt2)
  {
    ap localap = new ap();
    localap.b = paramInt1;
    localap.a = this.h.a(this, paramInt1);
    localap.d = this.h.a(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.e.size()))
      this.e.add(localap);
    while (true)
    {
      return localap;
      this.e.add(paramInt2, localap);
    }
  }

  ap a(View paramView)
  {
    int i1 = 0;
    ap localap;
    if (i1 < this.e.size())
    {
      localap = (ap)this.e.get(i1);
      if (!this.h.a(paramView, localap.a));
    }
    while (true)
    {
      return localap;
      i1++;
      break;
      localap = null;
    }
  }

  void a()
  {
    int i1 = this.h.a();
    this.b = i1;
    int i2;
    int i4;
    int i5;
    int i6;
    int i7;
    label61: ap localap;
    int i10;
    int i11;
    int i12;
    int i13;
    int i14;
    if ((this.e.size() < 1 + 2 * this.z) && (this.e.size() < i1))
    {
      i2 = 1;
      int i3 = this.i;
      i4 = 0;
      i5 = i3;
      i6 = i2;
      i7 = 0;
      if (i7 >= this.e.size())
        break label308;
      localap = (ap)this.e.get(i7);
      i10 = this.h.a(localap.a);
      if (i10 != -1)
        break label154;
      i11 = i7;
      i12 = i4;
      i13 = i5;
      i14 = i6;
    }
    while (true)
    {
      int i15 = i11 + 1;
      i6 = i14;
      i5 = i13;
      i4 = i12;
      i7 = i15;
      break label61;
      i2 = 0;
      break;
      label154: int i16;
      if (i10 == -2)
      {
        this.e.remove(i7);
        i16 = i7 - 1;
        if (i4 == 0)
        {
          this.h.a(this);
          i4 = 1;
        }
        this.h.a(this, localap.b, localap.a);
        if (this.i == localap.b)
        {
          int i17 = Math.max(0, Math.min(this.i, i1 - 1));
          i11 = i16;
          i12 = i4;
          i13 = i17;
          i14 = 1;
          continue;
        }
      }
      else
      {
        if (localap.b != i10)
        {
          if (localap.b == this.i)
            i5 = i10;
          localap.b = i10;
          i11 = i7;
          i12 = i4;
          i13 = i5;
          i14 = 1;
          continue;
          label308: if (i4 != 0)
            this.h.b(this);
          Collections.sort(this.e, c);
          if (i6 != 0)
          {
            int i8 = getChildCount();
            for (int i9 = 0; i9 < i8; i9++)
            {
              aq localaq = (aq)getChildAt(i9).getLayoutParams();
              if (localaq.a)
                continue;
              localaq.c = 0.0F;
            }
            a(i5, false, true);
            requestLayout();
          }
          return;
        }
        i11 = i7;
        i12 = i4;
        i13 = i5;
        i14 = i6;
        continue;
      }
      i11 = i16;
      i12 = i4;
      i13 = i5;
      i14 = 1;
    }
  }

  void a(int paramInt)
  {
    int i21;
    ap localap1;
    if (this.i != paramInt)
      if (this.i < paramInt)
      {
        i21 = 66;
        ap localap13 = b(this.i);
        this.i = paramInt;
        localap1 = localap13;
      }
    for (int i1 = i21; ; i1 = 2)
    {
      if (this.h == null)
        g();
      label74: 
      do
        while (true)
        {
          return;
          i21 = 17;
          break;
          if (!this.y)
            break label74;
          g();
        }
      while (getWindowToken() == null);
      this.h.a(this);
      int i2 = this.z;
      int i3 = Math.max(0, this.i - i2);
      int i4 = this.h.a();
      int i5 = Math.min(i4 - 1, i2 + this.i);
      if (i4 != this.b)
        try
        {
          String str2 = getResources().getResourceName(getId());
          str1 = str2;
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + i4 + " Pager id: " + str1 + " Pager class: " + getClass() + " Problematic adapter: " + this.h.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          while (true)
            String str1 = Integer.toHexString(getId());
        }
      int i6 = 0;
      ap localap2;
      if (i6 < this.e.size())
      {
        localap2 = (ap)this.e.get(i6);
        if (localap2.b >= this.i)
          if (localap2.b != this.i)
            break label1297;
      }
      while (true)
      {
        if ((localap2 == null) && (i4 > 0));
        for (ap localap3 = a(this.i, i6); ; localap3 = localap2)
        {
          ap localap7;
          label360: int i12;
          float f1;
          label374: float f2;
          int i14;
          int i15;
          int i16;
          float f3;
          int i17;
          ap localap8;
          label469: float f4;
          if (localap3 != null)
          {
            int i11 = i6 - 1;
            if (i11 < 0)
              break label679;
            localap7 = (ap)this.e.get(i11);
            i12 = getClientWidth();
            if (i12 > 0)
              break label685;
            f1 = 0.0F;
            int i13 = -1 + this.i;
            f2 = 0.0F;
            i14 = i13;
            i15 = i6;
            i16 = i11;
            if (i14 >= 0)
            {
              if ((f2 < f1) || (i14 >= i3))
                break label787;
              if (localap7 != null)
                break label707;
            }
            f3 = localap3.d;
            i17 = i15 + 1;
            if (f3 < 2.0F)
            {
              if (i17 >= this.e.size())
                break label892;
              localap8 = (ap)this.e.get(i17);
              if (i12 > 0)
                break label898;
              f4 = 0.0F;
            }
          }
          Object localObject2;
          int i19;
          int i20;
          label497: Object localObject1;
          while (true)
          {
            int i18 = 1 + this.i;
            localObject2 = localap8;
            i19 = i17;
            i20 = i18;
            if (i20 < i4)
            {
              if ((f3 < f4) || (i20 <= i5))
                break label1019;
              if (localObject2 != null)
                break label914;
            }
            a(localap3, i15, localap1);
            r localr = this.h;
            int i7 = this.i;
            if (localap3 == null)
              break label1156;
            localObject1 = localap3.a;
            label557: localr.b(this, i7, localObject1);
            this.h.b(this);
            int i8 = getChildCount();
            for (int i9 = 0; i9 < i8; i9++)
            {
              View localView3 = getChildAt(i9);
              aq localaq = (aq)localView3.getLayoutParams();
              localaq.f = i9;
              if ((localaq.a) || (localaq.c != 0.0F))
                continue;
              ap localap6 = a(localView3);
              if (localap6 == null)
                continue;
              localaq.c = localap6.d;
              localaq.e = localap6.b;
            }
            i6++;
            break;
            label679: localap7 = null;
            break label360;
            label685: f1 = 2.0F - localap3.d + getPaddingLeft() / i12;
            break label374;
            label707: if ((i14 == localap7.b) && (!localap7.c))
            {
              this.e.remove(i16);
              this.h.a(this, i14, localap7.a);
              i16--;
              i15--;
              if (i16 < 0)
                break label781;
              localap7 = (ap)this.e.get(i16);
            }
            while (true)
            {
              i14--;
              break;
              label781: localap7 = null;
              continue;
              label787: if ((localap7 != null) && (i14 == localap7.b))
              {
                f2 += localap7.d;
                i16--;
                if (i16 >= 0)
                {
                  localap7 = (ap)this.e.get(i16);
                  continue;
                }
                localap7 = null;
                continue;
              }
              f2 += a(i14, i16 + 1).d;
              i15++;
              if (i16 >= 0)
              {
                localap7 = (ap)this.e.get(i16);
                continue;
              }
              localap7 = null;
            }
            label892: localap8 = null;
            break label469;
            label898: f4 = 2.0F + getPaddingRight() / i12;
          }
          label914: ap localap12;
          label983: Object localObject3;
          float f6;
          if ((i20 == ((ap)localObject2).b) && (!((ap)localObject2).c))
          {
            this.e.remove(i19);
            this.h.a(this, i20, ((ap)localObject2).a);
            if (i19 < this.e.size())
            {
              localap12 = (ap)this.e.get(i19);
              float f10 = f3;
              localObject3 = localap12;
              f6 = f10;
            }
          }
          while (true)
          {
            i20++;
            float f7 = f6;
            localObject2 = localObject3;
            f3 = f7;
            break label497;
            localap12 = null;
            break label983;
            label1019: if ((localObject2 != null) && (i20 == ((ap)localObject2).b))
            {
              float f8 = f3 + ((ap)localObject2).d;
              i19++;
              if (i19 < this.e.size());
              for (ap localap11 = (ap)this.e.get(i19); ; localap11 = null)
              {
                localObject3 = localap11;
                f6 = f8;
                break;
              }
            }
            ap localap9 = a(i20, i19);
            i19++;
            float f5 = f3 + localap9.d;
            if (i19 < this.e.size());
            for (ap localap10 = (ap)this.e.get(i19); ; localap10 = null)
            {
              localObject3 = localap10;
              f6 = f5;
              break;
            }
            label1156: localObject1 = null;
            break label557;
            g();
            if (!hasFocus())
              break;
            View localView1 = findFocus();
            if (localView1 != null);
            for (ap localap4 = b(localView1); ; localap4 = null)
            {
              if ((localap4 != null) && (localap4.b == this.i))
                break label1273;
              for (int i10 = 0; ; i10++)
              {
                if (i10 >= getChildCount())
                  break label1267;
                View localView2 = getChildAt(i10);
                ap localap5 = a(localView2);
                if ((localap5 != null) && (localap5.b == this.i) && (localView2.requestFocus(i1)))
                  break;
              }
              label1267: break;
            }
            label1273: break;
            float f9 = f3;
            localObject3 = localObject2;
            f6 = f9;
          }
        }
        label1297: localap2 = null;
      }
      localap1 = null;
    }
  }

  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.V > 0)
    {
      int i4 = getScrollX();
      int i5 = getPaddingLeft();
      int i6 = getPaddingRight();
      int i7 = getWidth();
      int i8 = getChildCount();
      int i9 = 0;
      while (i9 < i8)
      {
        View localView2 = getChildAt(i9);
        aq localaq = (aq)localView2.getLayoutParams();
        int i12;
        int i13;
        if (!localaq.a)
        {
          int i20 = i6;
          i12 = i5;
          i13 = i20;
          i9++;
          int i15 = i13;
          i5 = i12;
          i6 = i15;
          continue;
        }
        int i10;
        switch (0x7 & localaq.b)
        {
        case 2:
        case 4:
        default:
          i10 = i5;
          int i19 = i6;
          i12 = i5;
          i13 = i19;
        case 3:
        case 1:
        case 5:
        }
        while (true)
        {
          int i14 = i10 + i4 - localView2.getLeft();
          if (i14 == 0)
            break;
          localView2.offsetLeftAndRight(i14);
          break;
          int i17 = i5 + localView2.getWidth();
          int i18 = i5;
          i13 = i6;
          i12 = i17;
          i10 = i18;
          continue;
          i10 = Math.max((i7 - localView2.getMeasuredWidth()) / 2, i5);
          int i16 = i6;
          i12 = i5;
          i13 = i16;
          continue;
          i10 = i7 - i6 - localView2.getMeasuredWidth();
          int i11 = i6 + localView2.getMeasuredWidth();
          i12 = i5;
          i13 = i11;
        }
      }
    }
    if (this.W != null)
      this.W.a(paramInt1, paramFloat, paramInt2);
    if (this.Z != null)
      this.Z.a(paramInt1, paramFloat, paramInt2);
    if (this.ab != null)
    {
      int i1 = getScrollX();
      int i2 = getChildCount();
      int i3 = 0;
      if (i3 < i2)
      {
        View localView1 = getChildAt(i3);
        if (((aq)localView1.getLayoutParams()).a);
        while (true)
        {
          i3++;
          break;
          float f1 = (localView1.getLeft() - i1) / getClientWidth();
          this.ab.a(localView1, f1);
        }
      }
    }
    this.U = true;
  }

  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
      setScrollingCacheEnabled(false);
    int i1;
    int i2;
    int i3;
    int i4;
    while (true)
    {
      return;
      i1 = getScrollX();
      i2 = getScrollY();
      i3 = paramInt1 - i1;
      i4 = paramInt2 - i2;
      if ((i3 != 0) || (i4 != 0))
        break;
      a(false);
      b();
      setScrollState(0);
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    int i5 = getClientWidth();
    int i6 = i5 / 2;
    float f1 = Math.min(1.0F, 1.0F * Math.abs(i3) / i5);
    float f2 = i6 + i6 * a(f1);
    int i7 = Math.abs(paramInt3);
    if (i7 > 0);
    float f3;
    for (int i8 = 4 * Math.round(1000.0F * Math.abs(f2 / i7)); ; i8 = (int)(100.0F * (1.0F + Math.abs(i3) / (f3 + this.o))))
    {
      int i9 = Math.min(i8, 600);
      this.m.startScroll(i1, i2, i3, i4, i9);
      x.b(this);
      break;
      f3 = i5 * this.h.a(this.i);
    }
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    this.y = false;
    a(paramInt, paramBoolean, false);
  }

  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }

  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.h == null) || (this.h.a() <= 0))
      setScrollingCacheEnabled(false);
    while (true)
    {
      return;
      if ((!paramBoolean2) && (this.i == paramInt1) && (this.e.size() != 0))
      {
        setScrollingCacheEnabled(false);
        continue;
      }
      if (paramInt1 < 0)
        paramInt1 = 0;
      while (true)
      {
        int i1 = this.z;
        if ((paramInt1 <= i1 + this.i) && (paramInt1 >= this.i - i1))
          break;
        for (int i2 = 0; i2 < this.e.size(); i2++)
          ((ap)this.e.get(i2)).c = true;
        if (paramInt1 < this.h.a())
          continue;
        paramInt1 = -1 + this.h.a();
      }
      if (this.i != paramInt1)
        bool = true;
      if (this.S)
      {
        this.i = paramInt1;
        if ((bool) && (this.W != null))
          this.W.a(paramInt1);
        if ((bool) && (this.Z != null))
          this.Z.a(paramInt1);
        requestLayout();
        continue;
      }
      a(paramInt1);
      a(paramInt1, paramBoolean1, paramInt2, bool);
    }
  }

  public boolean a(KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramKeyEvent.getAction() == 0)
      switch (paramKeyEvent.getKeyCode())
      {
      default:
      case 21:
      case 22:
      case 61:
      }
    while (true)
    {
      return bool;
      bool = c(17);
      continue;
      bool = c(66);
      continue;
      if (Build.VERSION.SDK_INT < 11)
        continue;
      if (f.a(paramKeyEvent))
      {
        bool = c(2);
        continue;
      }
      if (!f.a(paramKeyEvent, 1))
        continue;
      bool = c(1);
    }
  }

  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    int i3;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i1 = paramView.getScrollX();
      int i2 = paramView.getScrollY();
      i3 = -1 + localViewGroup.getChildCount();
      if (i3 >= 0)
      {
        View localView = localViewGroup.getChildAt(i3);
        if ((paramInt2 + i1 < localView.getLeft()) || (paramInt2 + i1 >= localView.getRight()) || (paramInt3 + i2 < localView.getTop()) || (paramInt3 + i2 >= localView.getBottom()) || (!a(localView, bool, paramInt1, paramInt2 + i1 - localView.getLeft(), paramInt3 + i2 - localView.getTop())));
      }
    }
    while (true)
    {
      return bool;
      i3--;
      break;
      if ((paramBoolean) && (x.a(paramView, -paramInt1)))
        continue;
      bool = false;
    }
  }

  public void addFocusables(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    int i1 = paramArrayList.size();
    int i2 = getDescendantFocusability();
    if (i2 != 393216)
      for (int i3 = 0; i3 < getChildCount(); i3++)
      {
        View localView = getChildAt(i3);
        if (localView.getVisibility() != 0)
          continue;
        ap localap = a(localView);
        if ((localap == null) || (localap.b != this.i))
          continue;
        localView.addFocusables(paramArrayList, paramInt1, paramInt2);
      }
    if (((i2 == 262144) && (i1 != paramArrayList.size())) || (!isFocusable()));
    while (true)
    {
      return;
      if ((((paramInt2 & 0x1) != 1) || (!isInTouchMode()) || (isFocusableInTouchMode())) && (paramArrayList != null))
      {
        paramArrayList.add(this);
        continue;
      }
    }
  }

  public void addTouchables(ArrayList paramArrayList)
  {
    for (int i1 = 0; i1 < getChildCount(); i1++)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() != 0)
        continue;
      ap localap = a(localView);
      if ((localap == null) || (localap.b != this.i))
        continue;
      localView.addTouchables(paramArrayList);
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams));
    for (ViewGroup.LayoutParams localLayoutParams = generateLayoutParams(paramLayoutParams); ; localLayoutParams = paramLayoutParams)
    {
      aq localaq = (aq)localLayoutParams;
      localaq.a |= paramView instanceof ao;
      if (this.w)
      {
        if ((localaq != null) && (localaq.a))
          throw new IllegalStateException("Cannot add pager decor view during layout");
        localaq.d = true;
        addViewInLayout(paramView, paramInt, localLayoutParams);
      }
      while (true)
      {
        return;
        super.addView(paramView, paramInt, localLayoutParams);
      }
    }
  }

  ap b(int paramInt)
  {
    int i1 = 0;
    ap localap;
    if (i1 < this.e.size())
    {
      localap = (ap)this.e.get(i1);
      if (localap.b != paramInt);
    }
    while (true)
    {
      return localap;
      i1++;
      break;
      localap = null;
    }
  }

  ap b(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent != this)
      if ((localViewParent != null) && ((localViewParent instanceof View)));
    for (ap localap = null; ; localap = a(paramView))
    {
      return localap;
      paramView = (View)localViewParent;
      break;
    }
  }

  void b()
  {
    a(this.i);
  }

  boolean c()
  {
    boolean bool = true;
    if (this.i > 0)
      a(-1 + this.i, bool);
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public boolean c(int paramInt)
  {
    View localView1 = findFocus();
    View localView2;
    View localView3;
    boolean bool;
    label86: ViewParent localViewParent1;
    if (localView1 == this)
    {
      localView2 = null;
      localView3 = FocusFinder.getInstance().findNextFocus(this, localView2, paramInt);
      if ((localView3 == null) || (localView3 == localView2))
        break label325;
      if (paramInt != 17)
        break label260;
      int i3 = a(this.g, localView3).left;
      int i4 = a(this.g, localView2).left;
      if ((localView2 != null) && (i3 >= i4))
      {
        bool = c();
        if (bool)
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        return bool;
      }
    }
    else
    {
      if (localView1 == null)
        break label371;
      localViewParent1 = localView1.getParent();
      if (!(localViewParent1 instanceof ViewGroup))
        break label376;
      if (localViewParent1 != this);
    }
    label260: label325: label371: label376: for (int i5 = 1; ; i5 = 0)
    {
      if (i5 == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView1.getClass().getSimpleName());
        ViewParent localViewParent2 = localView1.getParent();
        while (true)
          if ((localViewParent2 instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localViewParent2.getClass().getSimpleName());
            localViewParent2 = localViewParent2.getParent();
            continue;
            localViewParent1 = localViewParent1.getParent();
            break;
          }
        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localView2 = null;
        break;
        bool = localView3.requestFocus();
        break label86;
        if (paramInt == 66)
        {
          int i1 = a(this.g, localView3).left;
          int i2 = a(this.g, localView2).left;
          if ((localView2 != null) && (i1 <= i2))
          {
            bool = d();
            break label86;
          }
          bool = localView3.requestFocus();
          break label86;
          if ((paramInt == 17) || (paramInt == 1))
          {
            bool = c();
            break label86;
          }
          if ((paramInt == 66) || (paramInt == 2))
          {
            bool = d();
            break label86;
          }
        }
        bool = false;
        break label86;
      }
      localView2 = localView1;
      break;
    }
  }

  public boolean canScrollHorizontally(int paramInt)
  {
    int i1 = 1;
    int i2 = 0;
    if (this.h == null);
    int i3;
    int i4;
    do
    {
      return i2;
      i3 = getClientWidth();
      i4 = getScrollX();
      if (paramInt >= 0)
        continue;
      if (i4 > (int)(i3 * this.s));
      while (true)
      {
        i2 = i1;
        break;
        i1 = 0;
      }
    }
    while (paramInt <= 0);
    if (i4 < (int)(i3 * this.t));
    while (true)
    {
      i2 = i1;
      break;
      i1 = 0;
    }
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (((paramLayoutParams instanceof aq)) && (super.checkLayoutParams(paramLayoutParams)));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void computeScroll()
  {
    if ((!this.m.isFinished()) && (this.m.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.m.getCurrX();
      int i4 = this.m.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!d(i3))
        {
          this.m.abortAnimation();
          scrollTo(0, i4);
        }
      }
      x.b(this);
    }
    while (true)
    {
      return;
      a(true);
    }
  }

  boolean d()
  {
    boolean bool = true;
    if ((this.h != null) && (this.i < -1 + this.h.a()))
      a(1 + this.i, bool);
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent)));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool = false;
    if (paramAccessibilityEvent.getEventType() == 4096)
      bool = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    label93: 
    while (true)
    {
      return bool;
      int i1 = getChildCount();
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= i1)
          break label93;
        View localView = getChildAt(i2);
        if (localView.getVisibility() != 0)
          continue;
        ap localap = a(localView);
        if ((localap == null) || (localap.b != this.i) || (!localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent)))
          continue;
        bool = true;
        break;
      }
    }
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    boolean bool = false;
    int i1 = x.a(this);
    if ((i1 == 0) || ((i1 == 1) && (this.h != null) && (this.h.a() > 1)))
    {
      if (!this.Q.a())
      {
        int i5 = paramCanvas.save();
        int i6 = getHeight() - getPaddingTop() - getPaddingBottom();
        int i7 = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i6 + getPaddingTop(), this.s * i7);
        this.Q.a(i6, i7);
        bool = false | this.Q.a(paramCanvas);
        paramCanvas.restoreToCount(i5);
      }
      if (!this.R.a())
      {
        int i2 = paramCanvas.save();
        int i3 = getWidth();
        int i4 = getHeight() - getPaddingTop() - getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(1.0F + this.t) * i3);
        this.R.a(i4, i3);
        bool |= this.R.a(paramCanvas);
        paramCanvas.restoreToCount(i2);
      }
    }
    while (true)
    {
      if (bool)
        x.b(this);
      return;
      this.Q.b();
      this.R.b();
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.p;
    if ((localDrawable != null) && (localDrawable.isStateful()))
      localDrawable.setState(getDrawableState());
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new aq();
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new aq(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }

  public r getAdapter()
  {
    return this.h;
  }

  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.ad == 2)
      paramInt2 = paramInt1 - 1 - paramInt2;
    return ((aq)((View)this.ae.get(paramInt2)).getLayoutParams()).f;
  }

  public int getCurrentItem()
  {
    return this.i;
  }

  public int getOffscreenPageLimit()
  {
    return this.z;
  }

  public int getPageMargin()
  {
    return this.o;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.S = true;
  }

  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.ag);
    super.onDetachedFromWindow();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1;
    int i2;
    float f1;
    ap localap;
    float f2;
    int i3;
    int i4;
    int i5;
    int i6;
    if ((this.o > 0) && (this.p != null) && (this.e.size() > 0) && (this.h != null))
    {
      i1 = getScrollX();
      i2 = getWidth();
      f1 = this.o / i2;
      localap = (ap)this.e.get(0);
      f2 = localap.e;
      i3 = this.e.size();
      i4 = localap.b;
      i5 = ((ap)this.e.get(i3 - 1)).b;
      i6 = 0;
    }
    for (int i7 = i4; ; i7++)
    {
      float f4;
      if (i7 < i5)
      {
        while ((i7 > localap.b) && (i6 < i3))
        {
          ArrayList localArrayList = this.e;
          i6++;
          localap = (ap)localArrayList.get(i6);
        }
        if (i7 != localap.b)
          break label272;
        f4 = (localap.e + localap.d) * i2;
        f2 = f1 + (localap.e + localap.d);
      }
      while (true)
      {
        if (f4 + this.o > i1)
        {
          this.p.setBounds((int)f4, this.q, (int)(0.5F + (f4 + this.o)), this.r);
          this.p.draw(paramCanvas);
        }
        if (f4 <= i1 + i2)
          break;
        return;
        label272: float f3 = this.h.a(i7);
        f4 = (f2 + f3) * i2;
        f2 += f3 + f1;
      }
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i1 = 0xFF & paramMotionEvent.getAction();
    if ((i1 == 3) || (i1 == 1))
    {
      this.A = false;
      this.B = false;
      this.J = -1;
      if (this.K != null)
      {
        this.K.recycle();
        this.K = null;
      }
    }
    do
      while (true)
      {
        return bool;
        if (i1 == 0)
          break label81;
        if (!this.A)
          break;
        bool = true;
      }
    while (this.B);
    label81: switch (i1)
    {
    default:
    case 2:
    case 0:
    case 6:
    }
    while (true)
    {
      if (this.K == null)
        this.K = VelocityTracker.obtain();
      this.K.addMovement(paramMotionEvent);
      bool = this.A;
      break;
      int i2 = this.J;
      if (i2 == -1)
        continue;
      int i3 = m.a(paramMotionEvent, i2);
      float f3 = m.c(paramMotionEvent, i3);
      float f4 = f3 - this.F;
      float f5 = Math.abs(f4);
      float f6 = m.d(paramMotionEvent, i3);
      float f7 = Math.abs(f6 - this.I);
      if ((f4 != 0.0F) && (!a(this.F, f4)) && (a(this, false, (int)f4, (int)f3, (int)f6)))
      {
        this.F = f3;
        this.G = f6;
        this.B = true;
        break;
      }
      float f8;
      if ((f5 > this.E) && (0.5F * f5 > f7))
      {
        this.A = true;
        setScrollState(1);
        if (f4 > 0.0F)
        {
          f8 = this.H + this.E;
          label321: this.F = f8;
          this.G = f6;
          setScrollingCacheEnabled(true);
        }
      }
      while ((this.A) && (b(f3)))
      {
        x.b(this);
        break;
        f8 = this.H - this.E;
        break label321;
        if (f7 <= this.E)
          continue;
        this.B = true;
      }
      float f1 = paramMotionEvent.getX();
      this.H = f1;
      this.F = f1;
      float f2 = paramMotionEvent.getY();
      this.I = f2;
      this.G = f2;
      this.J = m.b(paramMotionEvent, 0);
      this.B = false;
      this.m.computeScrollOffset();
      if ((this.ah == 2) && (Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.O))
      {
        this.m.abortAnimation();
        this.y = false;
        b();
        this.A = true;
        setScrollState(1);
        continue;
      }
      a(false);
      this.A = false;
      continue;
      a(paramMotionEvent);
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i2 = paramInt3 - paramInt1;
    int i3 = paramInt4 - paramInt2;
    int i4 = getPaddingLeft();
    int i5 = getPaddingTop();
    int i6 = getPaddingRight();
    int i7 = getPaddingBottom();
    int i8 = getScrollX();
    int i9 = 0;
    int i10 = 0;
    View localView2;
    int i21;
    label156: int i22;
    int i24;
    int i25;
    label208: int i14;
    int i15;
    int i16;
    if (i10 < i1)
    {
      localView2 = getChildAt(i10);
      if (localView2.getVisibility() == 8)
        break label659;
      aq localaq2 = (aq)localView2.getLayoutParams();
      if (!localaq2.a)
        break label659;
      int i18 = 0x7 & localaq2.b;
      int i19 = 0x70 & localaq2.b;
      switch (i18)
      {
      case 2:
      case 4:
      default:
        i21 = i4;
        switch (i19)
        {
        default:
          i22 = i5;
          int i30 = i7;
          i24 = i5;
          i25 = i30;
          int i26 = i21 + i8;
          localView2.layout(i26, i22, i26 + localView2.getMeasuredWidth(), i22 + localView2.getMeasuredHeight());
          i14 = i9 + 1;
          i15 = i24;
          i7 = i25;
          i16 = i6;
        case 48:
        case 16:
        case 80:
        }
      case 3:
      case 1:
      case 5:
      }
    }
    for (int i17 = i4; ; i17 = i4)
    {
      i10++;
      i4 = i17;
      i6 = i16;
      i5 = i15;
      i9 = i14;
      break;
      int i31 = i4 + localView2.getMeasuredWidth();
      i21 = i4;
      i4 = i31;
      break label156;
      i21 = Math.max((i2 - localView2.getMeasuredWidth()) / 2, i4);
      break label156;
      int i20 = i2 - i6 - localView2.getMeasuredWidth();
      i6 += localView2.getMeasuredWidth();
      i21 = i20;
      break label156;
      int i28 = i5 + localView2.getMeasuredHeight();
      int i29 = i5;
      i25 = i7;
      i24 = i28;
      i22 = i29;
      break label208;
      i22 = Math.max((i3 - localView2.getMeasuredHeight()) / 2, i5);
      int i27 = i7;
      i24 = i5;
      i25 = i27;
      break label208;
      i22 = i3 - i7 - localView2.getMeasuredHeight();
      int i23 = i7 + localView2.getMeasuredHeight();
      i24 = i5;
      i25 = i23;
      break label208;
      int i11 = i2 - i4 - i6;
      for (int i12 = 0; i12 < i1; i12++)
      {
        View localView1 = getChildAt(i12);
        if (localView1.getVisibility() == 8)
          continue;
        aq localaq1 = (aq)localView1.getLayoutParams();
        if (localaq1.a)
          continue;
        ap localap = a(localView1);
        if (localap == null)
          continue;
        int i13 = i4 + (int)(i11 * localap.e);
        if (localaq1.d)
        {
          localaq1.d = false;
          localView1.measure(View.MeasureSpec.makeMeasureSpec((int)(i11 * localaq1.c), 1073741824), View.MeasureSpec.makeMeasureSpec(i3 - i5 - i7, 1073741824));
        }
        localView1.layout(i13, i5, i13 + localView1.getMeasuredWidth(), i5 + localView1.getMeasuredHeight());
      }
      this.q = i5;
      this.r = (i3 - i7);
      this.V = i9;
      if (this.S)
        a(this.i, false, 0, false);
      this.S = false;
      return;
      label659: i14 = i9;
      i15 = i5;
      i16 = i6;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    int i1 = getMeasuredWidth();
    this.D = Math.min(i1 / 10, this.C);
    int i2 = i1 - getPaddingLeft() - getPaddingRight();
    int i3 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int i5 = 0;
    View localView2;
    aq localaq2;
    int i10;
    int i11;
    int i12;
    label167: int i13;
    label182: label192: int i14;
    int i15;
    if (i5 < i4)
    {
      localView2 = getChildAt(i5);
      if (localView2.getVisibility() != 8)
      {
        localaq2 = (aq)localView2.getLayoutParams();
        if ((localaq2 != null) && (localaq2.a))
        {
          int i8 = 0x7 & localaq2.b;
          int i9 = 0x70 & localaq2.b;
          i10 = -2147483648;
          i11 = -2147483648;
          if ((i9 != 48) && (i9 != 80))
            break label296;
          i12 = 1;
          if ((i8 != 3) && (i8 != 5))
            break label302;
          i13 = 1;
          if (i12 == 0)
            break label308;
          i10 = 1073741824;
          if (localaq2.width == -2)
            break label480;
          i14 = 1073741824;
          if (localaq2.width == -1)
            break label473;
          i15 = localaq2.width;
        }
      }
    }
    while (true)
    {
      if (localaq2.height != -2)
      {
        i11 = 1073741824;
        if (localaq2.height == -1);
      }
      for (int i16 = localaq2.height; ; i16 = i3)
      {
        localView2.measure(View.MeasureSpec.makeMeasureSpec(i15, i14), View.MeasureSpec.makeMeasureSpec(i16, i11));
        if (i12 != 0)
          i3 -= localView2.getMeasuredHeight();
        while (true)
        {
          i5++;
          break;
          label296: i12 = 0;
          break label167;
          label302: i13 = 0;
          break label182;
          label308: if (i13 == 0)
            break label192;
          i11 = 1073741824;
          break label192;
          if (i13 == 0)
            continue;
          i2 -= localView2.getMeasuredWidth();
        }
        this.u = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        this.v = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        this.w = true;
        b();
        this.w = false;
        int i6 = getChildCount();
        for (int i7 = 0; i7 < i6; i7++)
        {
          View localView1 = getChildAt(i7);
          if (localView1.getVisibility() == 8)
            continue;
          aq localaq1 = (aq)localView1.getLayoutParams();
          if ((localaq1 != null) && (localaq1.a))
            continue;
          localView1.measure(View.MeasureSpec.makeMeasureSpec((int)(i2 * localaq1.c), 1073741824), this.v);
        }
        return;
      }
      label473: i15 = i2;
      continue;
      label480: i14 = i10;
      i15 = i2;
    }
  }

  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1 = 1;
    int i2 = -1;
    int i3 = getChildCount();
    int i4;
    if ((paramInt & 0x2) != 0)
    {
      i2 = i1;
      i4 = 0;
      if (i4 == i3)
        break label107;
      View localView = getChildAt(i4);
      if (localView.getVisibility() != 0)
        break label97;
      ap localap = a(localView);
      if ((localap == null) || (localap.b != this.i) || (!localView.requestFocus(paramInt, paramRect)))
        break label97;
    }
    while (true)
    {
      return i1;
      i4 = i3 - 1;
      i3 = i2;
      break;
      label97: i4 += i2;
      break;
      label107: i1 = 0;
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager.SavedState))
      super.onRestoreInstanceState(paramParcelable);
    while (true)
    {
      return;
      ViewPager.SavedState localSavedState = (ViewPager.SavedState)paramParcelable;
      super.onRestoreInstanceState(localSavedState.getSuperState());
      if (this.h != null)
      {
        this.h.a(localSavedState.b, localSavedState.c);
        a(localSavedState.a, false, true);
        continue;
      }
      this.j = localSavedState.a;
      this.k = localSavedState.b;
      this.l = localSavedState.c;
    }
  }

  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.i;
    if (this.h != null)
      localSavedState.b = this.h.b();
    return localSavedState;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      a(paramInt1, paramInt3, this.o, this.o);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i1;
    if (this.P)
      i1 = 1;
    while (true)
    {
      return i1;
      if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
      {
        i1 = 0;
        continue;
      }
      if ((this.h != null) && (this.h.a() != 0))
        break;
      i1 = 0;
    }
    if (this.K == null)
      this.K = VelocityTracker.obtain();
    this.K.addMovement(paramMotionEvent);
    switch (0xFF & paramMotionEvent.getAction())
    {
    case 4:
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    case 5:
    case 6:
    }
    while (true)
    {
      if (bool)
        x.b(this);
      i1 = 1;
      break;
      this.m.abortAnimation();
      this.y = false;
      b();
      this.A = true;
      setScrollState(1);
      float f6 = paramMotionEvent.getX();
      this.H = f6;
      this.F = f6;
      float f7 = paramMotionEvent.getY();
      this.I = f7;
      this.G = f7;
      this.J = m.b(paramMotionEvent, 0);
      continue;
      float f3;
      float f5;
      if (!this.A)
      {
        int i6 = m.a(paramMotionEvent, this.J);
        float f1 = m.c(paramMotionEvent, i6);
        float f2 = Math.abs(f1 - this.F);
        f3 = m.d(paramMotionEvent, i6);
        float f4 = Math.abs(f3 - this.G);
        if ((f2 > this.E) && (f2 > f4))
        {
          this.A = true;
          if (f1 - this.H <= 0.0F)
            break label371;
          f5 = this.H + this.E;
        }
      }
      while (true)
      {
        this.F = f5;
        this.G = f3;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        if (!this.A)
          break;
        bool = false | b(m.c(paramMotionEvent, m.a(paramMotionEvent, this.J)));
        break;
        label371: f5 = this.H - this.E;
      }
      if (!this.A)
        continue;
      VelocityTracker localVelocityTracker = this.K;
      localVelocityTracker.computeCurrentVelocity(1000, this.M);
      int i3 = (int)s.a(localVelocityTracker, this.J);
      this.y = true;
      int i4 = getClientWidth();
      int i5 = getScrollX();
      ap localap = h();
      a(a(localap.b, (i5 / i4 - localap.e) / localap.d, i3, (int)(m.c(paramMotionEvent, m.a(paramMotionEvent, this.J)) - this.H)), true, true, i3);
      this.J = -1;
      i();
      bool = this.Q.c() | this.R.c();
      continue;
      if (!this.A)
        continue;
      a(this.i, true, 0, false);
      this.J = -1;
      i();
      bool = this.Q.c() | this.R.c();
      continue;
      int i2 = m.b(paramMotionEvent);
      this.F = m.c(paramMotionEvent, i2);
      this.J = m.b(paramMotionEvent, i2);
      continue;
      a(paramMotionEvent);
      this.F = m.c(paramMotionEvent, m.a(paramMotionEvent, this.J));
    }
  }

  public void removeView(View paramView)
  {
    if (this.w)
      removeViewInLayout(paramView);
    while (true)
    {
      return;
      super.removeView(paramView);
    }
  }

  public void setAdapter(r paramr)
  {
    if (this.h != null)
    {
      this.h.b(this.n);
      this.h.a(this);
      for (int i1 = 0; i1 < this.e.size(); i1++)
      {
        ap localap = (ap)this.e.get(i1);
        this.h.a(this, localap.b, localap.a);
      }
      this.h.b(this);
      this.e.clear();
      f();
      this.i = 0;
      scrollTo(0, 0);
    }
    r localr = this.h;
    this.h = paramr;
    this.b = 0;
    boolean bool;
    if (this.h != null)
    {
      if (this.n == null)
        this.n = new au(this, null);
      this.h.a(this.n);
      this.y = false;
      bool = this.S;
      this.S = true;
      this.b = this.h.a();
      if (this.j < 0)
        break label260;
      this.h.a(this.k, this.l);
      a(this.j, false, true);
      this.j = -1;
      this.k = null;
      this.l = null;
    }
    while (true)
    {
      if ((this.aa != null) && (localr != paramr))
        this.aa.a(localr, paramr);
      return;
      label260: if (!bool)
      {
        b();
        continue;
      }
      requestLayout();
    }
  }

  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.ac == null));
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      this.ac = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", arrayOfClass);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        while (true)
        {
          Method localMethod = this.ac;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Boolean.valueOf(paramBoolean);
          localMethod.invoke(this, arrayOfObject);
          return;
          localNoSuchMethodException = localNoSuchMethodException;
          Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
        }
      }
      catch (Exception localException)
      {
        while (true)
          Log.e("ViewPager", "Error changing children drawing order", localException);
      }
    }
  }

  public void setCurrentItem(int paramInt)
  {
    this.y = false;
    if (!this.S);
    for (boolean bool = true; ; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }

  public void setOffscreenPageLimit(int paramInt)
  {
    if (paramInt < 1)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      paramInt = 1;
    }
    if (paramInt != this.z)
    {
      this.z = paramInt;
      b();
    }
  }

  void setOnAdapterChangeListener(ar paramar)
  {
    this.aa = paramar;
  }

  public void setOnPageChangeListener(as paramas)
  {
    this.W = paramas;
  }

  public void setPageMargin(int paramInt)
  {
    int i1 = this.o;
    this.o = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }

  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }

  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.p = paramDrawable;
    if (paramDrawable != null)
      refreshDrawableState();
    if (paramDrawable == null);
    for (boolean bool = true; ; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.p));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPager
 * JD-Core Version:    0.6.0
 */